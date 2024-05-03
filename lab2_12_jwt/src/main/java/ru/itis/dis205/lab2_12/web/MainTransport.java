package ru.itis.dis205.lab2_12.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.dis205.lab2_12.web.model.transport.TrasportDataBase;
import java.io.File;
import java.io.IOException;

public class MainTransport {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TrasportDataBase dataBase =
                mapper.readValue(new File("transport.json"), TrasportDataBase.class);
    }
}
