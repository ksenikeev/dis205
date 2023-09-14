package ru.itis.dis205.lab02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

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

                System.out.println("connected");

                InputStream is = clientSocket.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String receivedData = br.readLine();

                System.out.println(receivedData);

                OutputStream os = clientSocket.getOutputStream();

                DataOutputStream serverOutput = new DataOutputStream(os);
                serverOutput.writeBytes("Send response "
                        + " " + receivedData + "\n");

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
