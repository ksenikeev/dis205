package ru.itis.dis205.lab06;

import java.util.Map;

public class JsonHandler implements ResourceHandler {
    @Override
    public ResponseBody handle(Map<String, String> params) {

        ResponseBody responseBody = new ResponseBody();

        responseBody.body = "{\"name\":\"value\"}";

        responseBody.contentType = "application/json";
        return responseBody;
    }
}
