package ru.itis.dis205.semestrii;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StarShip extends JFrame {

    private static GameStatus gameStatus;
    public static boolean playStatus;

    private static InstanceStatus instanceStatus;

    private Socket partnerSocket;

    public StarShip() {
        super("star ship");
        gameStatus = GameStatus.Finished;
        playStatus = false;


        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //createBufferStrategy(2);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu menuRole = new JMenu("Роль");
        menuBar.add(menuRole);
        JMenuItem menuSettings = new JMenuItem("Настройки");
        menuBar.add(menuSettings);

        JMenuItem server =new JMenuItem("Запустить сервер");
        menuRole.add(server);
        server.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Вы сервер");

                try {
                    ServerSocket serverSocket = new ServerSocket(5000);
                    partnerSocket = serverSocket.accept();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                System.out.println("Подключение состоялось");

            }
        });
        JMenuItem client =new JMenuItem("Подключиться как клиент");
        menuRole.add(client);
        client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Вы клиент ");;
            }
        });

        menuSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsPanel settingsPanel = new SettingsPanel();
                settingsPanel.setVisible(true);
            }
        });
        add(new GameComponent());



        setVisible(true);
    }
}
