//This implements the driver, which initializes the JFrame elements of the game.  
//It sets the panel to the TrollPanel, which is the main controller of the program.
//Also sets window attribute to be non-scaleable, since the size will be set upon launch, and resizing the window could mess up the gui.

//Author: Jordan Hadjimichael
//Date: 4/28/2021

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
public class TrollDriver
{
   public static void main(String[] args) throws Exception
   {
      JFrame frame = new JFrame("TROLLS");
      frame.setSize(600, 600);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new TrollPanel());
      frame.setVisible(true);
   }
 
}