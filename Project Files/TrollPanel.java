//This implements the TrollPanel, which is the the main controller of the game and program.
//There are two 2d arrays, one for the logic, one for graphics.
//There is also a Jlabel for the title, which is set through "setTitle", and only takes a name.
//To initialize the game, it will create an empty 2d array of Blocks, the default object.
//Next, it will populate the array at random locations with trolls, and the player is placed at a random location. 
//The TrollPanel then creates a button, for now just using a name.  This button is quit.
//Finally the TrollPanel binds and sets the handler and listener for the keypresses that control the player.

//Author: Jordan Hadjimichael
//Date: 4/28/2021


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
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
   private void initialize()
   {
      //Initializes the array. Returns -1 to compile.
      Block[][] board = new Block[10][10];
   }
   private void createents(Block[][] board)
   {
      Random rand = new Random();
      //for (int i = 0; i < 5; i++) {
      int random_x = rand.nextInt(10);
      int random_y = rand.nextInt(10);
      board[1][2] = new Troll();

         //while ((board[random_x][random_y] instanceof Troll) || ((random_x == 4) && (random_y == 0))) {
           // random_x = rand.nextInt(10);
            //random_y = rand.nextInt(10);
         //}
         //board[random_x][random_y] = new Troll(board);
      //}



      board[4][0] = new Player(board);
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
