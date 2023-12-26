package ru.itis.dis205.semestrii;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new StarShip(); } });

    }
}
