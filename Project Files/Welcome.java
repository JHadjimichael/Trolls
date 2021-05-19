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
      panel.setLayout(new GridLayout(1, 1));
      //label.setVisible(true);
      
      JButton b = new JButton("Start");
      b.addActionListener(new Listener1());
      panel.add(b);
      b.setVisible(true);
      panel.setBackground(Color.GREEN);
      add(panel, BorderLayout.SOUTH);
      
      JPanel north = new JPanel();
      north.setBackground(Color.GREEN);
      north.setLayout(new GridLayout(2, 1));
      JLabel trolls = new JLabel("TROLLS");
      trolls.setFont(new Font("Comic Sans", Font.PLAIN, 75));
      trolls.setVisible(true);
      north.add(trolls);
      JLabel author = new JLabel("By: Jai Agarwal, Jordan Hadjimichael, and Venkat Penmetsa");
      author.setFont(new Font("Times New Roman", Font.PLAIN, 25));
      author.setVisible(true);
      north.add(author);
      add(north, BorderLayout.NORTH);
      
      JPanel welcome = new JPanel();
      welcome.setBackground(Color.GREEN);
      welcome.setLayout(new GridLayout(2, 1));
      JLabel hello = new JLabel("Welcome!");
      hello.setFont(new Font("Arial", Font.BOLD, 140));
      hello.setVisible(true);
      welcome.add(hello);
      JLabel start = new JLabel("Click 'Start' to play the game");
      start.setFont(new Font("Times New Roman", Font.PLAIN, 50));
      start.setVisible(true);
      welcome.add(start);
      add(welcome, BorderLayout.CENTER);
      
      
      
      
      
      setBackground(Color.GREEN);
      
      
      
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