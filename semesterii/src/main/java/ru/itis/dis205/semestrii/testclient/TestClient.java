package ru.itis.dis205.semestrii.testclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.dis205.semestrii.repeater.cmdmodel.HelloClientResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class TestClient {

    public static int SERVER_PORT = 50000;

    /*
        args[0] client_name
        args[1] server_address
        args[2] server_port
     */
    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "Kamil";
        System.out.println(name);
        String server_address = args.length > 1 ? args[1] : "127.0.0.1";
        Integer server_port = args.length > 2 ? Integer.valueOf(args[2]) : SERVER_PORT;

        try {
            Socket socket = new Socket(server_address, server_port);

            String helloCmd = "{\"name\":\"" + name + "\"}\n";
            // Отправили на сервер данные для регистрации
            socket.getOutputStream().write(helloCmd.getBytes(StandardCharsets.UTF_8));

            // Читаем ответ сервера
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String cmd = bufferedReader.readLine();

            ObjectMapper mapper = new ObjectMapper();
            HelloClientResponse serverResponse = mapper.readValue(cmd, HelloClientResponse.class);
            String response = "{\"status\":\"1\"}\n";
            if (serverResponse != null && serverResponse.status != null ) {
                switch (serverResponse.status) {
                    case "1" : System.out.println("Регистрация прошла успешно");break;
                    case "2" : System.out.println("Такое имя уже зарегистрировано");break;
                    case "3" : System.out.println("Данные на сервер отправлены неверно");break;
                }
            } else {
                throw new RuntimeException("Не смогли обработать ответ сервера!");
            }

            // отдельный поток для обработки входящих сообщений
            Thread thread = new Thread(new ClientMessageHandler(socket));
            thread.setDaemon(true);
            thread.start();

            // Принимаем данные и отправляем на сервер
            try {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите команду (2-4)");
                    String userCmd = scanner.nextLine();
                    switch (userCmd.trim()) {
                        case "2" : { String cmdForSend = "{\"cmd\":2 }\n";
                            socket.getOutputStream().write(cmdForSend.getBytes());
                            break; }
                        case "4" : { String cmdForSend = "{\"cmd\":4 }\n";
                            socket.getOutputStream().write(cmdForSend.getBytes());
                            socket.getOutputStream().flush();
                            socket.close();
                            break; }
                        case "3" : {
                            System.out.println("Укажите имя 2 игрока");
                            String gamer2 = scanner.nextLine();

                            System.out.println("Введите информацию для отправки");
                            String data = scanner.nextLine();
                            String encodedData = Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));

                            String cmdForSend = "{\"cmd\":3, \"otherClientName\":\"" + gamer2 + "\", \"data\":\"" + encodedData + "\"}\n";
                            socket.getOutputStream().write(cmdForSend.getBytes(StandardCharsets.UTF_8));
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
