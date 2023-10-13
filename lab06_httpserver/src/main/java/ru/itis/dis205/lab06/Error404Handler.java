package ru.itis.dis205.lab06;

import java.util.Map;

public class Error404Handler implements ResourceHandler {
    @Override
    public ResponseBody handle(Map<String, String> params) {

        ResponseBody responseBody = new ResponseBody();

        responseBody.body = "<html>\n" +
                "<head><title>404</title></head>\n" +
                "<body>\n" +
                "<h1>page not found</h1>\n" +
                "</body>\n" +
                "</html>  \n";

        responseBody.contentType = "text/html";

        return responseBody;
    }
}
