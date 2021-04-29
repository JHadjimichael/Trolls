//This implements the TrollPanel, which is the the main controller of the game and program.
//There are two 2d arrays, one for the logic, one for graphics.
//There is also a Jlabel for the title, which is set through "setTitle", and only takes a name.
//To initialize the game, it will create an empty 2d array of Blocks, the default object.
//Next, it will populate the array at random locations with trolls, and the player is placed at a random location. 
//The TrollPanel then creates a button, for now just using a name.  This button is quit.
//Finally the TrollPanel binds and setsthe handler and listener for the keypresses that control the player.

//Author: Jordan Hadjimichael
//Date: 4/28/2021



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TrollPanel extends JPanel
{
   private JPanel[][] graphic;
   private Block[][] board;
   private JLabel title;
   private JButton quit;
   public TrollPanel()
   {
      //SetLayout
      setLayout(new BorderLayout());
      
      //Set Title
      setTitle("Trolls");
      
      //Initialize board and graphics
      initialize();
      
      //Create entities
      createents(board);
      
      //Define Buttons
      createbuttons("Reset");
      
      //Define Movement Keys
      setup_movement();
      
   }
   private class Handler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      	//Quit Button
      }
   }
   private int initialize()
   {
      //Initilizes the array. Returns -1 to compile.
      return -1;
   }
   private void createents(Block[][] board)
   {
      //Create entities and place them on the board
   }
   private void createbuttons(String name)
   {
      //Create a button with this name
   }
   private void setup_movement()
   {
      //Bind keypresses to player movement, which leads to everything moving.
      
   }
   private void setTitle(String name)
   {
      //Set the title to "name"
   }
}
