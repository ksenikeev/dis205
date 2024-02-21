package ru.itis.dis205.lab2_1;

import java.util.Map;

/**
 * 1. Сканирование и поиск компонентов, контроллеров
 * 2. Инициализация полей @Inject
 * 3. Создание сервлета диспетчера
 * 4. Запуск встроенного Tomcat
 *
 */
public class Context {

    private Map<String, Object> components;

    /**
     *
     * @param className = ru.itis.dis205.lab2_1.PersonService
     * @return
     */
    public Object getObjectByName(String className) {
        return components.get(className);
    }

    public void scanComponent() {
        //PersonRepository

    }

    public void findAndInitInjectedFields() {

    }

}
