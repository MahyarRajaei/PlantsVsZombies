package gui;

import creatures.Zombie;
import database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameFrame extends JFrame {
    private final JPanel panel;



    public GameFrame(String title, int width, int height, int FPS) {
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

//        createBufferStrategy(2);
        System.out.println(isDoubleBuffered());




        panel = new JPanel();
        panel.setLayout(null);
        panel.setIgnoreRepaint(true);
        panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panel.setSize(width, height);
        panel.setBackground(Color.red);
        panel.setVisible(true);
        super.add(panel);

        // updating
        new Thread(() -> {
            while (true) {
                try {
                    repaint();
                    Thread.sleep(1000 / FPS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


//    public void addAnimationContainer(AnimationContainer animationContainer) {
//
//    }

    BufferStrategy bufferStrategy = getBufferStrategy();

    @Override
    public void paint(Graphics g) {

        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        for (Zombie z : Database.getZombies()) {


            AnimationContainer animation = z.getAnimationContainer();
            int x = animation.getX();
            int y = animation.getY();
            Image frame = animation.getCurrentFrame();
//            new BufferedImage(frame.getWidth(null),frame.getHeight(null), BufferedImage.TYPE_INT_RGB).getGraphics().drawImage(frame, x, y, null);
            g.drawImage(frame, x, y, null);
//            bufferStrategy.getDrawGraphics().drawImage(frame, x, y, null);
//            bufferStrategy.dispose();
//            bufferStrategy.show();
        }
    }


    @Override
    public void update(Graphics g) {
        paint(g);
    }

}
