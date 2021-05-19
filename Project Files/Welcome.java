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
      
      JPanel top = new JPanel();
      JPanel middle = new JPanel();
      JPanel bottom = new JPanel();
      
      top.setLayout(new FlowLayout());
      bottom.setLayout(new GridLayout(2, 1));
      middle.setLayout(new FlowLayout());
      
      JLabel by = new JLabel("Welcome to");
      top.add(by);
      
      JLabel trolls = new JLabel("TROLLS!");
      trolls.setForeground(Color.green);
      middle.add(trolls);
      
      JButton b = new JButton("Start");
      b.addActionListener(new Listener1());
      bottom.add(b);
      
      
      add(top, BorderLayout.NORTH);
      add(middle, BorderLayout.CENTER);
      add(bottom, BorderLayout.SOUTH);
      
      
      
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