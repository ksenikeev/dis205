package ru.itis.dis205.semestrii.repeater;

import java.net.Socket;

public class ClientConnection {
    private String clientName;
    private Socket clientSocket;

    public ClientConnection(String clientName, Socket clientSocket) {
        this.clientName = clientName;
        this.clientSocket = clientSocket;
    }

    public String getClientName() {
        return clientName;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
