package ru.itis.dis205.semestrii;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StarShip extends JFrame {

    private Socket partnerSocket;

    public StarShip() {
        super("star ship");

        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //createBufferStrategy(2);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu f = new JMenu("Роль");
        menuBar.add(f);

        JMenuItem server =new JMenuItem("Запустить сервер");
        f.add(server);
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
        f.add(client);
        client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Вы клиент ");;
            }
        });

        add(new GameComponent());



        setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new StarShip(); } });

    }

}
