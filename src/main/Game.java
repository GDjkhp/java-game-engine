package main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends GameEngine {
    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        new Window(this, 720, 480, "The Karakters Kompany");
    }

    @Override
    public void tick() {

    }

    @Override
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        // init image
        BufferedImage image = ImageProcessing.processHandlerInit(720, 480);
        Graphics g = image.createGraphics();

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 720, 480);

        g.setColor(Color.GREEN);
        g.fillRect(720/2-32, 480/2-32, 64, 64);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", 0, 16));
        String text = "Hello, world!";
        g.drawString(text, 720/2-getTextWidth(g, text)/2, 480/2+8);

        // get image graphics
        g = bs.getDrawGraphics();

        // image processing codes
        image = ImageProcessing.postProcessing(image);

        // draw everything
        g.drawImage(image, 0, 0, null);
        bs.show();
        g.dispose();
    }

    // the ultimate fix, for center
    public static int getTextWidth(Graphics g, String message){
        return g.getFontMetrics().stringWidth(message);
    }
}