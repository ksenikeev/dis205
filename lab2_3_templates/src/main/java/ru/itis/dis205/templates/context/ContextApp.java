package ru.itis.dis205.templates.context;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import ru.itis.dis205.templates.annotations.Controller;
import ru.itis.dis205.templates.annotations.GetRequest;
import ru.itis.dis205.templates.annotations.Inject;
import ru.itis.dis205.templates.annotations.PostRequest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Класс Контекст приложения
 * 1. Сканируем классы-компоненты и классы-контроллеры (@Component, @Controller)
 *  Создаем экземпляры и кладем в Map<String, Object> <ИмяКласса, ЭкземплярКласса>
 *  Параллельно, если класс оказался контроллером, сканируем методы для определения
 * @PostRequest и  @GetRequest, заполняем структуру ForInvoke
 * и кладем ее в  Map<String, ForInvoke> в качестве ключа будем брать
 * имя http ресурса
 *
 * 2. Перебираем созданный Map, ищем:
 *  поля, аннотированные  @Inject, определяем тип поля и инициализируем его ранее созданным объектом;
 *
 * 3. Конфигурирование и запуск встроенного Tomcat и необходимой логики
 */
public class ContextApp {

    public static String pathForScan = "ru.itis.dis205.templates.components";

    private Map<String, Object> components;
    private Map<String, ForInvoke> controllers;

    public void init() {
        try {

            scanComponent();
            findAndInitInjectedFields();
            scanMethodsForControllers();
            startTomcat();

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     *
     * @param className = ru.itis.dis205.lab2_1.PersonService
     * @return
     */
    private Object getObjectByName(String className) {
        return components.get(className);
    }

    private void scanComponent() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        components = new HashMap<>();
        List<Class<?>> classList = PathScan.find(pathForScan);
        for (Class clazz : classList) {
            Object o = null;
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            o = constructor.newInstance();
            components.put(clazz.getName(), o);
        }
    }

    private void findAndInitInjectedFields(){
        for (Object controller : components.values()) {
            Field[] fields = controller.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    try {
                        field.setAccessible(true);
                        Object instance = components.get(controller.getClass().getName());
                        Object fieldValue = components.get(field.getAnnotatedType().toString());
                        field.set(instance, fieldValue);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void scanMethodsForControllers() {
        controllers = new HashMap<>();
        for (Object controller : components.values()) {
            Class<?> className = controller.getClass();
            if (!className.isAnnotationPresent(Controller.class)) continue;

            Method[] methods = className.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(PostRequest.class)) {
                    ForInvoke forInvoke = new ForInvoke();
                    forInvoke.postMethod = method;
                    forInvoke.object = className;
                    PostRequest postRequestAnnotation = method.getAnnotation(PostRequest.class);
                    String path = postRequestAnnotation.path();
                    controllers.put(path, forInvoke);
                }
                if (method.isAnnotationPresent(GetRequest.class)) {
                    ForInvoke forInvoke = new ForInvoke();
                    forInvoke.getMethod = method;
                    forInvoke.object = className;
                    GetRequest postRequestAnnotation = method.getAnnotation(GetRequest.class);
                    String path = postRequestAnnotation.path();
                    controllers.put(path, forInvoke);
                }
            }
        }
    }

    private void startTomcat() {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        Connector conn = new Connector();
        conn.setPort(8090);
        tomcat.setConnector(conn);
        String contextPath = "";
        String docBase = new File(".").getAbsolutePath();
        Context tomcatContext = tomcat.addContext(contextPath, docBase);

        /*
            Создаем сервлет, лучше разместить этот код в отдельном файле
         */
        HttpServlet servlet = new DispatcherServlet();

        /*
            Динамически подключаем севлет
         */
        String servletName = "dispatcherServlet"; // любое уникальное имя
        tomcat.addServlet(contextPath, servletName, servlet);
        // Указываем имя ресурса и сервлет, который этот ресурс будет обрабатывать
        // (по пути "/*" наш сервлет будет перехватывать все запросы)
        // localhost:8090/start
        tomcatContext.addServletMappingDecoded("/*", servletName);

        try {
            tomcat.start();

            // здесь можно запустить отдельный поток с логикой приложения

            //tomcat.getServer().await();
            System.out.println("----");

            /*
                tomcat.stop()
                tomcat.destroy()
             */
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }

    }

    class DispatcherServlet extends HttpServlet {
        @Override
        public void service(HttpServletRequest request, HttpServletResponse response) {
            String path = request.getPathInfo();
            System.out.println(path);

            ForInvoke forInvoke = controllers.get(path);

            if (forInvoke != null) {
                System.out.println(forInvoke.object);
                if (request.getMethod().toUpperCase().equals("GET")) {
                    try {
                        forInvoke.getMethod.invoke(forInvoke.object, request, response);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } else if (request.getMethod().toUpperCase().equals("POST")) {
                    try {
                        forInvoke.postMethod.invoke(forInvoke.object, request, response);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                try {
                    response.sendError(404);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

}
