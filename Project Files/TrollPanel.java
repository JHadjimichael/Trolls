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
      board = new Block[10][];
      
      for(int i = 0; i<10; i++)
      {
         board[i] = new Block[] {new Block(), new Block(), new Block(), new Block(), new Block(), new Block(), new Block(), new Block(), new Block(), new Block()};
      }
      
   }
   private void createents(Block[][] board)
   {
      Random rand = new Random();
      int random_x = rand.nextInt(10);
      int random_y = rand.nextInt(10);
      int count = 0;
      
   
      while (board[random_x][random_y].getNum() != 1 || board[random_x][random_y].getNum() != 2) {
         random_x = rand.nextInt(10);
         random_y = rand.nextInt(10);
         board[random_x][random_y] = new Troll();
         count += 1;
         if (count == 5)
         {
            break;
         }
      }
      board[4][6] = new Player(board);
      
      for (int a = 0; a<10; a++)
      {
         for (int b = 0; b<10; b++)
         {
            System.out.print(board[a][b].getNum());
         }
         System.out.println(" ");
      }
   }
      
   private void createbuttons(String name)
   {
      quit = new JButton("Quit");
      quit.addActionListener(new Listener1());
   }
   private void setup_movement()
   {
      //Bind keypresses to player movement, which leads to everything moving.
      
   }
   private void setTitle(String name)
   {
      //Set the title to "name"
   }
   private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
}
