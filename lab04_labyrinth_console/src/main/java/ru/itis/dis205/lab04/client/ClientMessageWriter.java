package ru.itis.dis205.lab04.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.dis205.lab04.model.ClientMessage;

public class ClientMessageWriter {
    public String write(ClientMessage message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(message);
    }
}
