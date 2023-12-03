package ru.itis.dis205.lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandler extends JFrame {

    public EventHandler() throws HeadlessException {

        super("Обработка событий клавиатуры");
        // при закрытии окна - выход
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // регистрируем нашего слушателя
        addKeyListener(new KeyL());
        MouseL ml = new MouseL();
        addMouseListener(ml);
        addMouseMotionListener(ml);
        // выводим окно на экран
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new EventHandler(); } });
    }

    class KeyL implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("keyTyped: " + e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed: " + e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased: " + e);
        }
    }

    class MouseL implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("mouseClicked: " + e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println(e.getX() + ", " + e.getY());
        }
    }
}
