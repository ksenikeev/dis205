package ru.itis.dis205.lab06;

import java.util.Map;

public class IndexHandler implements ResourceHandler {
    @Override
    public ResponseBody handle(Map<String, String> params) {

        ResponseBody responseBody = new ResponseBody();

        responseBody.body = "<html>\n" +
                "<head><title>Index</title></head>\n" +
                "<body>\n" +
                "<h1>Hello from index page</h1>\n" +
                "index page\n" +
                "</body>\n" +
                "</html>  \n";

        responseBody.contentType = "text/html;charset=utf-8";

        return responseBody;
    }
}
