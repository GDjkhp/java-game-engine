package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends WindowAdapter {
    JFrame frame = new JFrame();
    public Window (GameEngine game, int width, int height, String title){
        frame.addWindowListener(this);

        frame.setPreferredSize(new Dimension(width + 16, height + 39));
        frame.setMaximumSize(new Dimension(width + 16, height + 39));
        frame.setMinimumSize(new Dimension(width + 16, height + 39));

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

        // frame.setLocation(1360 - width*2, 0);
        frame.setLocationRelativeTo(null);

        frame.setTitle(title);

        game.start();
    }
    public void windowClosing(WindowEvent e) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
