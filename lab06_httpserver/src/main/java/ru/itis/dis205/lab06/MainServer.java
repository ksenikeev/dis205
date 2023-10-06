package ru.itis.dis205.lab06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainServer {

    private static Map<String, ResourceHandler> handlers = new HashMap<>();

    public static void main(String[] args) {

        handlers.put("/index", new IndexHandler());
        handlers.put("/json", new JsonHandler());

        try {
            ServerSocket server = new ServerSocket(8090);
            // wait client connection
            System.out.println("wait client connection");
            int counter = 0;

            while (true) {

                // Передать обработку в отдельный поток
                // Для выхода из цикла можно реализовать обработчик наподобии GET /closeserver HTTP/1.1 -> return
                Socket clientSocket = server.accept();

                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String responseHeader = null;
                String responseBody = null;

                // Обработка 1-й строки заголовка:
                String receivedData = br.readLine();
                // определяем метод (допустим только GET), ресурс

                String[] firstData = receivedData.split(" ");

                // если метод GET, то идем в обработку ресурса
                String method = firstData[0];
                if (method.equalsIgnoreCase("GET")) {
                    String resource = firstData[1];

                    // ищем обработчик ресурса
                    ResourceHandler handler = handlers.get(resource);
                    if (handler != null) {
                        // запускаем обработчик
                        responseBody = handler.handle(null);

                        // готовим заголовок ответа
                        responseHeader = "HTTP/1.1 200 OK\r\n" +
                            "Server: My Server Name\r\n" +
                            "Date: " + new Date() + "\r\n" +
                            "Content-Type: text/html;charset=utf-8\r\n" +
                            "Content-Length: "
                            + responseBody.getBytes("utf-8").length + "\r\n" +
                            "\r\n";
                    } else {
                        //Если ресурс не найден -> 404
                        responseBody = new Error404Handler().handle(null);
                        responseHeader = "HTTP/1.1 404 Not Found\r\n" +
                                "Server: My Server Name\r\n" +
                                "Date: " + new Date() + "\r\n" +
                                "Content-Type: text/html;charset=utf-8\r\n" +
                                "Content-Length: "
                                + responseBody.getBytes("utf-8").length + "\r\n" +
                                "\r\n";
                    }

                } else {
                    responseHeader = "HTTP/1.1 405 Forbidden\r\n" +
                            "Allow: GET\r\n" +
                            "Server: My Server Name\r\n" +
                            "Date: " + new Date() + "\r\n" +
                            "\r\n";
                }

                // Отправляем клиенту заголовок, и, если есть - тело
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                writer.print(responseHeader);
                if (responseBody != null) {
                    writer.print(responseBody);
                }

                writer.flush();
                clientSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}