//The screen you see if you get eaten, or teleport into a troll or corpse
//Identical to the winner screen, except for color and the message in the middle.
//Has two buttons, quit and restart
//Quit quits, and restart changes the changeval, alerting the driver to start its loop again

//Methods
//changeCheck - returs the changeval



import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

public class Loser extends JPanel{
   public int changeval = 0;
   public Loser() throws IOException{
   
      Font bigFont = new Font("Times New Roman", Font.PLAIN, 50);
         
      setLayout(new BorderLayout());
      
      JPanel middle = new JPanel();
      JPanel lower = new JPanel();
      
      middle.setLayout(new GridLayout(1, 1));
      lower.setLayout(new GridLayout(1, 2));
      
      middle.setBackground(Color.RED);
      lower.setBackground(Color.RED);
      
      JLabel text = new JLabel("You LOSE!", SwingConstants.CENTER);
      text.setFont(bigFont);
      text.setForeground(Color.WHITE);
      middle.add(text);
      text.setVisible(true);
      
      JButton quit = new JButton("Quit");
      lower.add(quit);
      quit.setVisible(true);
        
      JButton restart = new JButton("Restart");
      lower.add(restart);
      restart.setVisible(true);  
      
      add(middle, BorderLayout.CENTER);
      add(lower, BorderLayout.SOUTH);
      
      quit.addActionListener(new Handler1());
      restart.addActionListener(new Handler2());
   }
   private class Handler1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //System.out.println("You pressed the Quit Buttton!");
         System.exit(0);
      }
   }
      
   private class Handler2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //System.out.println("You pressed the Restart Buttton!");
         changeval = 1;
      }
   }
   public int changeCheck()
   {
      return changeval;
   }    
}