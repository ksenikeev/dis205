package ru.itis.dis205.semestrii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;

public class GameComponent extends JComponent implements KeyListener, MouseMotionListener {

    int x, y, bounds = 128;
    boolean move_up, move_left;
    int speed = 3;
    int imageIndex = 0;

    Image[] image = new Image[3];

    private SoundUtil su;

    private int count_to_start_play = 0;


    public GameComponent() {
        su = new SoundUtil();

        URL ship1 = GameComponent.class.getClassLoader().getResource("starship/ship1.png");
        URL ship2 = GameComponent.class.getClassLoader().getResource("starship/ship2.png");
        URL ship3 = GameComponent.class.getClassLoader().getResource("starship/ship3.png");

        image[0] = new ImageIcon(ship1.getPath()).getImage();
        image[1] = new ImageIcon(ship2.getPath()).getImage();
        image[2] = new ImageIcon(ship3.getPath()).getImage();

        setFocusable(true);
        addKeyListener(this);
        addMouseMotionListener(this);

        setDoubleBuffered(true);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageIndex = (imageIndex + 1) % image.length;
                count_to_start_play++;
                if (count_to_start_play >= 20) {
                    count_to_start_play = 0;

                    new Thread(()->{
                        play();
                    }).start();

                    Cmd cmd = handler.getCmd();
                }

                repaint();
            }


        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(image[imageIndex],x,y,null);
        g2d.dispose();

        Toolkit.getDefaultToolkit().sync();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           if (x > 0) {
               x -= speed;
           }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if ( x < getWidth() - bounds) {
                x += speed;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if ( y < getHeight() - bounds) {
                y += speed;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if ( y > 0) {
                y -= speed;
            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }


    private void play() {
        File wav = new File(GameComponent.class.getClassLoader().getResource("starship/rocket.wav").getPath());
        su.playWavFromFile(wav);
    }

}
