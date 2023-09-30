package ru.itis.dis205.lab05;

import java.io.*;
import java.net.Socket;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class HTTPGetParamsClient {

    // host          port       uri      params
    // itislabs.ru    80      /page      ?param1=value1&param2=value2
    public void send(String host, int port, String uri, String params) {

        try {
            Socket clientSocket = new Socket (host, port);

            OutputStream os = clientSocket.getOutputStream();

            params = URLEncoder.encode(params, "utf8");

            // Отправляем заголовок HTTP запроса
            String header = "GET "+uri+"?" + params + " HTTP/1.1\r\n";
            System.out.println("request");
            System.out.println(header);

            os.write((header).getBytes("UTF8"));
            os.write(("\r\n").getBytes("UTF8"));

            // Читаем ответ сервера
            InputStream is = clientSocket.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            System.out.println("Server response:");

            boolean existContent = false;
            int contentLength = 0;
            String contentType = null;


            //читаем ответ
            String receivedData = br.readLine();
            System.out.println(receivedData);

            while (true) {
                receivedData = br.readLine();
                System.out.println(receivedData);
                if (receivedData != null && receivedData.length() > 0) {

                    String[] dataHeader = receivedData.split(":");

                    if (dataHeader[0].trim().equalsIgnoreCase("Content-Length")) {
                        existContent = true;
                        contentLength = Integer.parseInt(dataHeader[1].trim());
                    } else if (dataHeader[0].trim().equalsIgnoreCase("Content-Type")) {
                        existContent = true;
                        contentType = dataHeader[1].trim().toLowerCase();
                    }

                } else break;
            }
            // завершили чтение заголовка

            // проанализировать наличие Content-Type Content-Length

/*
            if (existContent) {
                System.out.println("Size = " + contentLength);
                System.out.println("Type = " + contentType);
            }
*/

            // прочитать тело через clientSocket.getInputStream()
            InputStream contentIs = clientSocket.getInputStream();

            char[] buf = new char[contentLength];

            int countReadedBytes = br.read(buf);

            //System.out.println("countReadedBytes = " + countReadedBytes);

            System.out.println(new String(buf));

            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
