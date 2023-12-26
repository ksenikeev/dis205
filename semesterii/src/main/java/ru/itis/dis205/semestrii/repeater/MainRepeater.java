package ru.itis.dis205.semestrii.repeater;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * сервер - ретранслятор
 *
 * Протокол
 * 1. В момент подключения клиент отправляет свое имя {"name":"UniqueClientName"}\n, ответ {"status":"statusCode"}\n
 * statusCode - 1 (OK), 2 - такое имя уже зарегистрировано, 3 - неверный формат данных от клиента
 *
 * 2. Получение списка пользователей
 *
 * 3. Передача данных другому клиенту
 *
 * 4. Завершение сессии
 */
public class MainRepeater {

    public static int SERVER_PORT = 50000;

    private Map<String, Socket> clientConnectionList;

    public static void main(String[] args) {
        MainRepeater mainRepeater = new MainRepeater();
    }

    public MainRepeater() {

        clientConnectionList = new HashMap<>();

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ServerClientHandler(clientConnectionList, clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
