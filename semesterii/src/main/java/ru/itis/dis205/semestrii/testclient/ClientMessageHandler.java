package ru.itis.dis205.semestrii.testclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ClientMessageHandler implements Runnable {

    private Socket socket;

    public ClientMessageHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                System.out.println("ожидаем данных от сервера " + socket.getRemoteSocketAddress());
                String encodedCmd = bufferedReader.readLine();
                System.out.println(encodedCmd);

                String decodedCmd = new String(Base64.getDecoder().decode(encodedCmd.getBytes()), StandardCharsets.UTF_8);
                System.out.println("получили: " + decodedCmd);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
