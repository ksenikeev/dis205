package ru.itis.dis205.lab2_1;

import java.util.Map;

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
