//This implements the TrollPanel, which is the the main controller of the game and program.
//There are two 2d arrays, one for the logic, one for graphics.
//There is also a Jlabel for the title, which is set through "setTitle", and only takes a name.
//To initialize the game, it will create an empty 2d array of Blocks, the default object.
//Next, it will populate the array at random locations with trolls, and the player is placed at a random location. 
//The TrollPanel then creates a button, for now just using a name.  This button is quit.
//Finally the TrollPanel binds and sets the handler and listener for the keypresses that control the player.

//Methods:
//setTitle - set the title JLabel to whatever is given as the argument
//initialize - creates an empty block array of arrays of size R and C
//creatents - randomly scatters trolls around the array, and makes sure there are no overlaps.  Also tags each troll with a number
//createButtons - creates an invisible quit button, which doesn't actually quit.  It acts as the focused component for the keylistener
//drawScreen - runs through the array and creates JButton for each place in it.  
//updateScreen - Sets the backgrounds of the buttons 
//movement - adds the listener to quit
//fininit - debugging method to notify when initilization of the board is finished.

//Author: Jordan Hadjimichael
//Date: 5/20/2021


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.event.KeyAdapter;              
import java.awt.event.KeyEvent;
public class TrollPanel extends JPanel
{
   private JButton[][] graphic;
   private Block[][] board;
   private Player ThePlayer;
   private JLabel title;
   private JButton quit;
   private JPanel center;
   private int R = 100;
   private int C = 100;
   private playercoords coords;
   private int changeval = 0;
   
   public TrollPanel()
   {  
      setTitle("Trolls");
     
      initialize();
      
      createents(board);
      
      createbuttons("Quit");
      
      draw_screen();
      
      updateScreen();
      
      movement();
      
      fininit();
   }
   //Dead handler, used to keep the button listeners assigned properly
   private class Handler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      	
      }
   }
   //Empty array of arrays of blocks
   private void initialize()
   {
      board = new Block[R][C];
      
      for(int i = 0; i<R; i++)
      {
         for(int a = 0; a<C; a++)
         {
            board[i][a] = new Block();
         }
      }
      
   }
   //randomly generates places to put trolls then check before putting them there.  Has a troll count so you can adjust difficulty.
   private void createents(Block[][] board)
   {
      Random rand = new Random();
      int random_x = rand.nextInt(C);
      int random_y = rand.nextInt(R);
      int count = 0;
      int pr, pc;
      int numTrolls = 20;
      int ptime = 0;
      
      while(count<numTrolls)
      {
         random_x = rand.nextInt(C);
         random_y = rand.nextInt(R);
         if (board[random_x][random_y].getNum() == 0)
         {
            board[random_x][random_y] = new Troll(board, random_x, random_y, count);
            count += 1;
         }
      }
      while(ptime<1)
      {
         pr = rand.nextInt(R);
         pc = rand.nextInt(C);
         if (board[pr][pc].getNum() == 0)
         {
            board[pr][pc] = new Player(board, pr, pc, this);
            ThePlayer = (Player)board[pr][pc];
            ptime += 1;
         }
      }
      
   }
   //Creates the ghostbutton   
   private void createbuttons(String name)
   {
      JPanel bottom = new JPanel();
      bottom.setLayout(new GridLayout(1,1));
      add(bottom, BorderLayout.SOUTH);
      quit = new JButton(name);
      quit.addActionListener(new Handler2());
      bottom.add(quit);
      quit.setVisible(true);
   }
   
   //Adds buttons equal to the amound of slot in the array of arrays
   private void draw_screen()
   {
      setLayout(new BorderLayout());
      graphic = new JButton[R][C];
      center = new JPanel();
      center.setLayout(new GridLayout(R,C));
      add(center, BorderLayout.CENTER);
   
      for(int r = 0; r < R; r++)
         for(int c = 0; c < C; c++)
         {
            
            graphic[r][c] = new JButton();
            graphic[r][c].setBackground(Color.blue);
            graphic[r][c].addActionListener( new Handler1(r, c) );
            graphic[r][c].setEnabled(false);
            graphic[r][c].setBorderPainted(false);
            center.add(graphic[r][c]);
         }
   }
   //colors the buttons apropriatly
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
   //sets coords, a dead variable, and adds the apropriate listeners to quit
   private void movement()
   {
      for (int a = 0; a<R; a++)
      {
         for (int b = 0; b<C; b++)
         {
            if(board[a][b].getNum() == 2)
            {
               
               coords = new playercoords(a, b);
            }
         }
      }
      quit.addKeyListener(new KeyListener1());
      quit.setFocusable(true);
      quit.requestFocus();
      quit.repaint();
   }
   //prints finished message
   private void fininit()
   {
      System.out.println("Finished initialization");
   }
   
   
   //Sets title
   private void setTitle(String name)
   {
      title = new JLabel(name);
   }
   
   //Dead handler, used to keep the button listeners assigned properly
   private class Handler2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //empty
      }
   }
   //Dead handler, used to keep the button listeners assigned properly
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
      
      }
   }
   //The meat of the panel.  Drives all actions after initialization.
   //Takes keypresses, and convertes them to strings to feed to the player.
   private class KeyListener1 implements KeyListener
   {
      int result = -1;
      
      public void keyPressed(KeyEvent event)
      {
         int livetrollcount = 0;
         switch(event.getKeyCode())
         {
            case KeyEvent.VK_UP: 
            case KeyEvent.VK_W:
               result = ThePlayer.Move(board, "n");
               break;
            case KeyEvent.VK_Q:
               result = ThePlayer.Move(board, "nw");
               break;
            case KeyEvent.VK_E:
               result = ThePlayer.Move(board, "ne");
               break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
               result = ThePlayer.Move(board, "s");
               break;
            case KeyEvent.VK_Z:
               result = ThePlayer.Move(board, "sw");
               break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
               result = ThePlayer.Move(board, "w");
               break;
            case KeyEvent.VK_C:
               result = ThePlayer.Move(board, "se");
               break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
               result = ThePlayer.Move(board, "e");
               break;
            case KeyEvent.VK_T:
               result = ThePlayer.Move(board, "t");
               break;
            case KeyEvent.VK_SPACE:
               result = ThePlayer.Move(board, "poo");
               break;
            default: System.out.println("Invalid Key");
         }
         //updates the sceen after movement
         updateScreen();
         
         //checks the moves results
         if (result > 0)
         {
            System.out.println("GAME OVER");
            changeval = 1;   
         }
         
         for (int a = 0; a<R; a++)
         {
            for (int b = 0; b<C; b++)
            {
               if(board[a][b].getNum() == 1)
               {
                  livetrollcount++;   
               }
            }
         } 
         
         if (livetrollcount == 0)
         {
            System.out.println("YOU WIN");
            changeval = 2;
         }
         
      }
      
      public void keyTyped(KeyEvent event)
      {
        //neccesary for the actionlistener interface
      }
      public void keyReleased(KeyEvent event)
      {
         //neccesary for the actionlistener interface
      }
      
   }
   //checks if the screen needs to be changed
   public int changeCheck()
   {
      return changeval;
   }
   public void changecheckval(int val)
   {
      changeval = val;
   }
}
