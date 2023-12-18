package ru.itis.dis205.semestrii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageHandler {

    private Cmd cmd;

    private Socket partnerSocket;

    public MessageHandler(Socket partnerSocket) {
        this.partnerSocket = partnerSocket;
    }

    private void handle() throws IOException {
        while (true) {

            InputStream is = partnerSocket.getInputStream();
            BufferedReader isr = new BufferedReader(new InputStreamReader(is));
            String str = isr.readLine();


        }
    }

    public synchronized Cmd getCmd() {
        return cmd;
    }
}

/**
 * 0. запуск программы
 * 1. я объявляю себя сервером/клиентом
 *
 *
 *
 */