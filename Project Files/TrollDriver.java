//This implements the driver, which initializes the JFrame elements of the game.  
//It sets the panel to the TrollPanel, which is the main controller of the program.
//Also sets window attribute to be non-scaleable, since the size will be set upon launch, and resizing the window could mess up the gui.

//Author: Jordan Hadjimichael
//Date: 4/28/2021

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;              
import java.awt.event.KeyEvent;
public class TrollDriver
{
   public static void main(String[] args) throws Exception
   {
      boolean playagain = true;
      JFrame frame = new JFrame("TROLLS");
      frame.setSize(1000, 1000);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Welcome welcome = new Welcome();
      frame.setContentPane(welcome);
      frame.setVisible(true);
      while (playagain)
      {
         while (welcome.changeCheck() == 0)
         {
            Thread.sleep(1000);
         }
         frame.getContentPane().removeAll();
         
         TrollPanel trollpanel = new TrollPanel();
         trollpanel.requestFocus();
         trollpanel.setVisible(true);
         frame.toFront();
         frame.setContentPane(trollpanel);
         frame.setVisible(true);
         frame.pack();
         frame.revalidate();
         frame.repaint();
         while (trollpanel.changeCheck() == 0)
         {
            Thread.sleep(1000);
         }
         if (trollpanel.changeCheck() == 1)
         {
            Loser loser = new Loser();
            loser.requestFocus();
            frame.setContentPane(loser);
            frame.revalidate();
            frame.repaint();
            while(loser.changeCheck() == 0)
            {
               Thread.sleep(100);
            }
         }
         else if (trollpanel.changeCheck() == 2)
         {
            Winner winner = new Winner();
            winner.requestFocus();
            frame.setContentPane(winner);
            frame.revalidate();
            frame.repaint();
            while(winner.changeCheck() == 0)
            {
               Thread.sleep(100);
            }
         }
         
      }
      
   }
 
}