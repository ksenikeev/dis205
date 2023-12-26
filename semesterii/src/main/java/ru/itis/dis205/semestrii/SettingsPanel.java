package ru.itis.dis205.semestrii;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JFrame {



    public SettingsPanel() {
        super("Настройки подключения");

        setSize(350, 250);
        setLocation(150, 100);

        setDefaultCloseOperation( HIDE_ON_CLOSE );

        JPanel grid = new JPanel(
                new GridLayout(1, 2, 5, 0) );
// добавляем компоненты
        grid.add( new JButton("OK"));
        grid.add( new JButton("Отмена"));
        JPanel flow = new JPanel(
                new FlowLayout( FlowLayout.RIGHT ));
        flow.add(grid);
// помещаем строку кнопок вниз окна
        add(flow, BorderLayout.SOUTH );
    }

}
