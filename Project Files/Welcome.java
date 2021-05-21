//The welcome screen for the game, appears when you first run the program.  
//Has one button, start, which swaps its "changeval"
//This helps the driver determine if the contentpane should swap

//Methods:
//changeCheck - returns its changeval, which only get modified by the start button



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
      
      JButton b = new JButton("Start");
      b.addActionListener(new Listener1());
      panel.add(b);
      b.setVisible(true);
      panel.setBackground(Color.GREEN);
      add(panel, BorderLayout.SOUTH);
      
      
      JPanel welcome = new JPanel();
      welcome.setBackground(Color.GREEN);
      welcome.setLayout(new GridLayout(3, 1));
      JLabel hello = new JLabel("Welcome to TROLLS", SwingConstants.CENTER);
      hello.setFont(new Font("Times New Roman", Font.PLAIN, 75));
      hello.setVisible(true);
      welcome.add(hello);
      JLabel start = new JLabel("Click 'Start' to play the game", SwingConstants.CENTER);
      start.setFont(new Font("Times New Roman", Font.PLAIN, 50));
      start.setVisible(true);
      welcome.add(start);
      JLabel author = new JLabel("By: Jai Agarwal, Jordan Hadjimichael, and Venkat Penmetsa", SwingConstants.CENTER);
      author.setFont(new Font("Times New Roman", Font.PLAIN, 10));
      author.setVisible(true);
      welcome.add(author);
      add(welcome, BorderLayout.CENTER);
      setBackground(Color.GREEN);
   }
   public class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //Debugging message
         System.out.println("Boop");
         changeval = 1;
      }
   }
   public int changeCheck()
   {
      return changeval;
   }
   
}