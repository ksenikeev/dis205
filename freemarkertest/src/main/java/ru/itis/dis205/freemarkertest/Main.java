package ru.itis.dis205.freemarkertest;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, TemplateException {
        Main main = new Main();
        Configuration cfg = main.configure();
        main.render(cfg, main.getModel(), "index.ftlh");
    }

    private Configuration configure() throws IOException {
        // Create your Configuration instance, and specify if up to what FreeMarker
// version (here 2.3.32) do you want to apply the fixes that are not 100%
// backward-compatible. See the Configuration JavaDoc for details.
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

// Specify the source where the template files come from. Here I set a
// plain directory for it, but non-file-system sources are possible too:
        String templatesPath = Main.class.getClassLoader().getResource("templates").getPath();
        System.out.println(templatesPath);
        cfg.setDirectoryForTemplateLoading(new File(templatesPath));

// From here we will set the settings recommended for new projects. These
// aren't the defaults for backward compatibilty.

// Set the preferred charset template files are stored in. UTF-8 is
// a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

// Sets how errors will appear.
// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);

// Wrap unchecked exceptions thrown during template processing into TemplateException-s:
        cfg.setWrapUncheckedExceptions(true);

// Do not fall back to higher scopes when reading a null loop variable:
        cfg.setFallbackOnNullLoopVariable(false);

// To accomodate to how JDBC returns values; see Javadoc!
//        cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());
        return cfg;
    }

    private Map<String, ?> getModel() {
        Map<String, Object> model = new HashMap<>();
        model.put("message1", "world!");
        model.put("message2", "group!");

        Person person = new Person();
        person.fio = "Иванов Иван Иванович";
        person.gender = "Мужской";

        model.put("person", person);
        return model;
    }

    private void render(Configuration cfg, Map<String,?> model, String template) throws IOException, TemplateException {
        Template temp = cfg.getTemplate(template);
        Writer writer = new FileWriter("index.html");
        System.out.println(((Person)model.get("person")).fio);

        temp.process(model, writer);
    }


    public class Person {
        public String fio;
        public String gender;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
}
