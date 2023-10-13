package ru.itis.dis205.lab06;

import java.util.Map;

public class ParamHandler implements ResourceHandler {
    @Override
    public ResponseBody handle(Map<String, String> params) {

        ResponseBody responseBody = new ResponseBody();

        responseBody.body = "<html>\n" +
                "<head><title>Params</title></head>\n" +
                "<body>\n" +
                "<h1>Hello from params page</h1>\n";

        params.entrySet().forEach((s) -> {
            responseBody.body += s.getKey() + " = " + s.getValue();
        });

        responseBody.body += "\n" +
                "</body>\n" +
                "</html>  \n";

        responseBody.contentType = "text/html;charset=utf-8";

        return responseBody;
    }
}
