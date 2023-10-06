package ru.itis.dis205.lab06;

import java.util.Map;

public class IndexHandler implements ResourceHandler {
    @Override
    public String handle(Map<String, String> params) {

        String html = "<html>\n" +
                "<head><title>Index</title></head>\n" +
                "<body>\n" +
                "<h1>Hello from index page</h1>\n" +
                "index page\n" +
                "</body>\n" +
                "</html>  \n";
        return html;
    }
}
