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
   private JButton[][] graphic;
   private Block[][] board;
   private JLabel title;
   private JButton quit;
   private JPanel center;
   private int R = 10;
   private int C = 10;
   public TrollPanel()
   {  
   
    
      //SetLayout
      
      
      //Set Title
      setTitle("Trolls");
      
      //Initialize board and graphics
      initialize();
      
      //Create entities
      createents(board);
      
      //Define Buttons
      createbuttons("Quit");
      
      //Define Movement Keys
      setup_movement();
      
      updateScreen();
      
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
      board = new Block[R][C];
      
      for(int i = 0; i<R; i++)
      {
         for(int a = 0; a<C; a++)
         {
            board[i][a] = new Block();
         }
      }
      
   }
   private void createents(Block[][] board)
   {
      Random rand = new Random();
      int random_x = rand.nextInt(C);
      int random_y = rand.nextInt(R);
      int count = 0;
      
   
      while (board[random_x][random_y].getNum() != 1 || board[random_x][random_y].getNum() != 2) {
         random_x = rand.nextInt(C);
         random_y = rand.nextInt(R);
         board[random_x][random_y] = new Troll();
         count += 1;
         if (count == 5)
         {
            break;
         }
      }
      //make random
      board[4][5] = new Player(board);
      
      for (int a = 0; a<R; a++)
      {
         for (int b = 0; b<C; b++)
         {
            System.out.print(board[a][b].getNum());
         }
         System.out.println(" ");
      }
   }
      
   private void createbuttons(String name)
   {
      quit = new JButton(name);
      quit.addActionListener(new Listener1());
      add(quit, BorderLayout.SOUTH);
   }
   
   private void setup_movement()
   {
      setLayout(new BorderLayout());
      
      
      graphic = new JButton[R][C];
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(R,C));
      add(center, BorderLayout.CENTER);
   
      for(int r = 0; r < R; r++)
         for(int c = 0; c < C; c++)
         {
            
            graphic[r][c] = new JButton();
            graphic[r][c].setBackground(Color.blue);
            graphic[r][c].addActionListener( new Handler1(r, c) );
            center.add(graphic[r][c]);
         }
   }
   
   private void updateScreen()
   {
      for(int r = 0; r < R; r++)
         for(int c = 0; c < C; c++)
         {
            switch(board[r][c].getNum())
            {
               case 0: graphic[r][c].setBackground(Color.white);
                  break;
               case 1: graphic[r][c].setBackground(Color.green);
                  break;
               case 2: graphic[r][c].setBackground(Color.blue);
                  break;
               case 3: graphic[r][c].setBackground(Color.red);
                  break;
            }
         }
   }
   
   private void setTitle(String name)
   {
      title = new JLabel(name);
   }
   
   private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
   
   private class Handler1 implements ActionListener
   {
      private int myRow, myCol;
      public Handler1(int r, int c)
      {
         myRow = r;
         myCol = c;
      }
      public void actionPerformed(ActionEvent e)
      {
      	/************************/
      	/*                      */
      	/* Your code goes here. */
      	/*                      */
      	/************************/
      }
   }
}
