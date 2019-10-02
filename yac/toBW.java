package yac;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class toBW {
  public static File convert(String path) {
    BufferedImage image = null;
    try {
        File input = new File(path);
        image = ImageIO.read(input);

        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);

        Graphics2D graphic = result.createGraphics();
        graphic.drawImage(image, 0, 0, Color.WHITE, null);
        graphic.dispose();
        // thanks to tutorialspoint for conversion algorithm

        File output = new File(path + "-bw.jpeg");
        ImageIO.write(result, "jpeg", output);
        return (output);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
  }
}
