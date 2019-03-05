package pl.sda.programming.day1;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Task13 {

    /**
     * Napisz program który zapisze w pliku .png kwadrat wypełniony na niebiesko, koło wypełnione na czerwono. Podpowiedź - kawałek kodu który tworzy plik png
     */
    @Test
    void task() throws IOException {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, 100, 100);

        g2d.setColor(Color.blue);
        g2d.fillRect(12, 24, 50, 50);

        g2d.setColor(Color.red);
        g2d.fillOval(50, 50, 40, 40);

        g2d.dispose();

        File file = new File("myimage.png");
        ImageIO.write(bufferedImage, "png", file);
    }
}
