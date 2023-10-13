package ru.itis.dis205.lab06;

import java.util.Map;

public interface ResourceHandler {

    /**
     *
     * @param params [name:value]
     * @return
     */
    ResponseBody handle(Map<String, String> params);
}
