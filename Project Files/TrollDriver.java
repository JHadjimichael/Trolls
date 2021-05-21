//This implements the driver, which initializes the JFrame elements of the game.  
//It sets the panel to the TrollPanel, which is the main controller of the program.
//Also sets window attribute to be non-scaleable, since the size will be set upon launch, and resizing the window could mess up the gui.

//Methods:
//main - sets all frame attributes, then the contentPane to the welcome screen. Has a while statement checking for a button press in welcome.
//once welcome button is pressed, the content pane is changed to a trollpanel, and everything is refreshed. 
//after a change has been detected from trollpanel, the contentpane is set to either loser or winner, depending on the result
//after a buttonpress from loser or winner, the game is restarted

//Author: Jordan Hadjimichael
//Date: 4/28/2021

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;              
import java.awt.event.KeyEvent;
import java.awt.Robot;
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
      
         frame.setContentPane(trollpanel);
      
         trollpanel.setVisible(true);
      
         frame.setVisible(true);
         
         //Very strange.  The trollpanel would not recognize keypresses until the cursor had been moved out of, then into the frame.  
         //This creates a little robot which moves the cursor to the top left of the screen, forcing the panel to accept keypresses after it is moved back in.
         //A litle bit of a cheat, but the only solution that worked. (Except in fullscreen)
         Robot r = new Robot();
         r.mouseMove(0,0);
         while (trollpanel.changeCheck() == 0)
         {
            Thread.sleep(100);
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