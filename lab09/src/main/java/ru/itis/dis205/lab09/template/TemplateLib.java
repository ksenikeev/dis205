package ru.itis.dis205.lab09.template;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TemplateLib {

    public static void main(String[] args) throws IOException {
        TemplateLib templateLib = new TemplateLib();
        Map<String,String> params = new HashMap<>();
        params.put("errormessage", "Неверный пароль" );
        String html = templateLib.makeHTML("templates/index_template.thtml", params);
        System.out.println(html);
    }

    public String makeHTML(String templateName,
                           Map<String, String> params) throws IOException {

        URL templateUrl =
                this.getClass().getClassLoader().getResource(templateName);

        String html = Files.readString(Paths.get(templateUrl.getPath()));
        Set<String> setOfKeys = params.keySet();
        for(String key : setOfKeys) {
            String value = params.get(key);
            if(value != null) {
                html = html.replaceAll("\\$\\{"+key + "\\}", value);
            }
        }

        return html;
    }

}
