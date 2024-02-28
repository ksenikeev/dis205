package ru.itis.dis205.templates.context;

import ru.itis.dis205.templates.annotations.Component;
import ru.itis.dis205.templates.annotations.Controller;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PathScan {


    public static List<Class<?>> find(String scannedPackage) {
        String scannedPath = scannedPackage.replace(".", "/");
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl == null) {
            throw new IllegalArgumentException("Bad package " + scannedPackage);
        }
        File scannedDir = new File(scannedUrl.getFile());
        List<Class<?>> classes = new ArrayList<>();
        for (File file : scannedDir.listFiles()) {
            classes.addAll(find(file, scannedPackage));
        }
        return classes;
    }


    private static List<Class<?>> find(File file, String scannedPackage) {
        List<Class<?>> classes = new ArrayList<>();
        String resource = scannedPackage + "." + file.getName();
        if (resource.endsWith(".class")) {
            String className = resource.substring(0, resource.length() - 6);
            try {
                Class clazz = Class.forName(className);
                Annotation[] annotations = clazz.getAnnotations();
                for (Annotation a : annotations) {
                    if (a.equals(Component.class) || a.equals(Controller.class)) {
                        classes.add(clazz);
                    }
                }

            } catch (ClassNotFoundException ignore) {
            }
        }
        return classes;
    }
}