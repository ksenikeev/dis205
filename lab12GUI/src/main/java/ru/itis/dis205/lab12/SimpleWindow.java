package ru.itis.dis205.lab12;

import javax.swing.*;

public class SimpleWindow  extends JFrame {

    public SimpleWindow() {
        super();
        // Программа прекращает работу при закрытии окна
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Размер окна
        this.setSize(600, 600);
        // Заголовок окна
        this.setTitle("Simple Window");
        // Показываем
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleWindow();
    }

}
