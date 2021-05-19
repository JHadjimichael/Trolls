//Welcome screen for game
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
public class Welcome extends JPanel{
   public Welcome() throws IOException{
      setLayout(new BorderLayout());
      /*JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(2, 1));*/
      //JLabel label = new JLabel("Hello");
      BufferedImage image = ImageIO.read(new File("download.jpg"));
      JLabel label = new JLabel(new ImageIcon(image));
      add(label);
      label.setVisible(true);
      
      JButton b = new JButton("Start");
      add(b);
      b.setVisible(true);
      
      
      
   }
   
}