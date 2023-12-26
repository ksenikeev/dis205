package ru.itis.dis205.semestrii.repeater;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.dis205.semestrii.repeater.cmdmodel.Cmd;
import ru.itis.dis205.semestrii.repeater.cmdmodel.HelloClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServerClientHandler implements Runnable {

    private Map<String, Socket> clientConnectionMap;

    private Socket clientSocket;

    private String name;

    public ServerClientHandler(Map<String, Socket> clientConnectionList, Socket clientSocket) {
        this.clientConnectionMap = clientConnectionList;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String cmd = bufferedReader.readLine();

            ObjectMapper mapper = new ObjectMapper();
            HelloClient clientInfo = mapper.readValue(cmd, HelloClient.class);
            String response = "{\"status\":\"1\"}\n";
            if (clientInfo != null && clientInfo.name != null) {
                // TODO проверка уникальности имени
                clientConnectionMap.put(clientInfo.name, clientSocket);
                name = clientInfo.name;
                response = "{\"status\":\"1\"}\n";

                System.out.println(cmd);
            } else {
                response = "{\"status\":\"3\"}\n";
            }
            clientSocket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));

            while (true) {
                cmd = bufferedReader.readLine();
                Cmd clientCmd = mapper.readValue(cmd, Cmd.class);

                System.out.println(clientCmd);

                if (clientCmd != null && clientCmd.cmd != null) {
                    switch (clientCmd.cmd) {
                        case 2 :
                            List<String> clientNames = new ArrayList<>();
                            clientConnectionMap.forEach((n,s) -> {clientNames.add(n);});
                            String json = mapper.writeValueAsString(clientNames) + '\n';
                            clientSocket.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));
                            break;
                        case 3 :
                            try {
                                redirect(clientCmd);
                            } catch (ConnectionToOtherClientException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 4 :
                            clientConnectionMap.remove(name);
                            clientSocket.close();
                            return;
                    }
                } else {
                    clientConnectionMap.remove(name);
                    clientSocket.close();
                    return;
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void redirect(Cmd cmd) throws ConnectionToOtherClientException {
        Socket otherClientSocket = clientConnectionMap.get(cmd.otherClientName);

        if (otherClientSocket != null && otherClientSocket.isConnected()) {
            System.out.println("Нашли 2 игрока ");
            try {
                otherClientSocket.getOutputStream().write((cmd.data + '\n').getBytes(StandardCharsets.UTF_8));
                otherClientSocket.getOutputStream().flush();
                System.out.println("Отправили 2-му игроку " + cmd.data + " на адрес " +
                        otherClientSocket.getRemoteSocketAddress());
            } catch (IOException e) {
                throw new ConnectionToOtherClientException();
            }
        } else {
            System.out.println("Не нашли 2 игрока");
            //TODO - отправить сообщение о невозможности связи с указанным в команде клиентом
            throw new ConnectionToOtherClientException();
        }

    }
}
