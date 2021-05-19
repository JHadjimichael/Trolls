//Welcome screen for game
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
public class Welcome extends JPanel{
   public int changeval;
   public Welcome() throws IOException{
      changeval = 0;
      setLayout(new BorderLayout());
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(2, 1));
      BufferedImage image = ImageIO.read(new File("download.jpg"));
      JLabel label = new JLabel(new ImageIcon(image));
      panel.add(label);
      label.setVisible(true);
      
      JButton b = new JButton("Start");
      b.addActionListener(new Listener1());
      panel.add(b);
      b.setVisible(true);
      add(panel, BorderLayout.CENTER);
      
      
      
   }
   public class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.out.println("Boop");
         changeval = 1;
      }
   }
   public int changeCheck()
   {
      return changeval;
   }
   
}