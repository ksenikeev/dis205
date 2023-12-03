package ru.itis.dis205.lab11.servlets;

import jakarta.websocket.*;
import jakarta.websocket.server.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(value = "/msg/{username}")
public class WebSocketConnector {

    private Session session;
    private String username;
    public static Map<String, WebSocketConnector> endPoints = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        System.out.println("WS connect " + username);
        this.session = session;
        this.username = username;
        endPoints.put(username, this);
        // Get session and WebSocket connection
    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("username") String username) {
        // Handle new messages
    }

    @OnClose
    public void onClose(Session session) {
        // WebSocket connection closes
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}
