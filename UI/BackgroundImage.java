package UI;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
public class BackgroundImage extends JPanel {

  private Image backgroundImage;
  
  /**
   * constructor
   * @param fileName  name of the image file to be loaded.
   * @throws IOException
   */
  public BackgroundImage(String fileName) throws IOException {
    backgroundImage = ImageIO.read(new File(fileName));
  }

  @Override
  /**
   * draws the image.
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage, 0, 0, this);
  }
}