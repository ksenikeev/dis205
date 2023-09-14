package ru.itis.dis205.lab02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Реализует сервер со специфическим протоколом:
 * 8 байт - тип сообщения (text, mp3, jpeg, json, xml)
 * 8 байт - длина сообщения/файла
 * 2 байта - длина имени файла
 * имя файла (UTF-8) указанной длины
 * данные - массив байт указанной длины
 */
public class SimpleServerProtocol {

    public static final int SERVER_PORT = 50000;

    public static void main (String[] args){
        try {
            ServerSocket server =
                    new ServerSocket(SERVER_PORT);
            // wait client connection
            //System.out.println("accept");

            while (true) {
                // Ожидание клиента
                Socket clientSocket = server.accept();

                System.out.println("connected " + clientSocket.getRemoteSocketAddress());

                InputStream is = clientSocket.getInputStream();

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < 8; ++i) {
                    int b = is.read();
                    sb.append((char) b);
                }

                String messageType = sb.toString();
                System.out.println(messageType);

                byte[] lMessage = new byte[8];

                is.read(lMessage, 0, 8);

                long messageSize = byteToLong(lMessage);
                System.out.println(messageSize);

                byte[] lFileName = new byte[2];

                is.read(lFileName, 0, 2);

                long fileNameSize = byteToLong(lFileName);

                System.out.println(fileNameSize);

                byte[] fn = new byte[(int)fileNameSize];

                is.read(lFileName, 0, (int)fileNameSize);
                String fileName = new String(fn, "UTF-8");

                System.out.println(fileName);

                // Запрос данных

                byte[] buffer = new byte[4096];

                int r = 0;

                OutputStream os = new FileOutputStream(fileName);

                while ((r = is.read(buffer)) != -1 && r <  fileNameSize) {
                    os.write(buffer,0, r);
                }

                os.close();

                os = clientSocket.getOutputStream();

                DataOutputStream serverOutput = new DataOutputStream(os);
                serverOutput.writeBytes("Send response "
                         + "\n");

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long byteToLong(byte[] bytes) {
        return 0L;
    }
}
