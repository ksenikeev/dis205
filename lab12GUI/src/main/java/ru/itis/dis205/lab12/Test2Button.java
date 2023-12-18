package ru.itis.dis205.lab12;

import javax.swing.*;

public class Test2Button extends JFrame {

    private JButton button;
    private JTextField textField;
    private JLabel label1;
    private JLabel label2;

    public Test2Button() {
        super("Пример работы с кнопками");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("Simple Window");
        this.setVisible(true);

        // Отключаем автоматическое расположение
        this.setLayout(null);

        textField = new JTextField();
        textField.setBounds(20, 20, 200, 30);

        button = new JButton("Жми!");
        button.setBounds(20, 50, 200, 30);
        button.addActionListener((event) -> {
            System.out.println(textField.getText());
            label1.setText(textField.getText());
        });

        label1 = new JLabel();
        label1.setBounds(20, 100, 200, 30);

        this.add(textField);
        this.add(button);
        this.add(label1);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new Test2Button(); } });
    }

}
