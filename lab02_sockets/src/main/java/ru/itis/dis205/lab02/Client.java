package ru.itis.dis205.lab02;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {

        try {
            Socket clientSocket = new Socket ("127.0.0.1",50000);

            System.out.println(clientSocket.getLocalAddress());
            System.out.println(clientSocket.getLocalPort());

            OutputStream os = clientSocket.getOutputStream();

            os.write(("hello!\n").getBytes("UTF8"));

            InputStream is = clientSocket.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String receivedData = br.readLine();

            System.out.println("Received Data: "+receivedData);



            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
