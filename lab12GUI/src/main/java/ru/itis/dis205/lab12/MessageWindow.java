package ru.itis.dis205.lab12;

import javax.swing.*;
import java.awt.*;

public class MessageWindow extends JFrame {

    private String message;

    private JLabel label;

    private JButton closeBtn;
    private JFrame frame;

    public MessageWindow() {
        super("2-е окно");

        frame = this;

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setSize(200, 200);

//        this.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());

        label = new JLabel();
        this.add(label, BorderLayout.NORTH);

        closeBtn = new JButton("Закрыть");
        closeBtn.addActionListener((e -> {
            frame.setVisible(false);
        }));
        this.add(closeBtn, BorderLayout.SOUTH);
    }

    public void setMessage(String message) {
        this.message = message;

        label.setText(message);
    }
}
