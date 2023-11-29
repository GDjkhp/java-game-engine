package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends WindowAdapter {
    public static JFrame frame = new JFrame();
    public Window (GameEngine game, int width, int height, String title) {
        width += 16; height += 39; // hack
        frame.addWindowListener(this);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

        // frame.setLocation(1360 - width*2, 0);
        frame.setLocationRelativeTo(null);

        frame.setTitle(title);

        // System.out.println(frame.getWidth()+"x"+frame.getHeight());
        game.start();
    }
    public void setTitle(String title) {
        frame.setTitle(title);
    }
    public void windowClosing(WindowEvent e) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}