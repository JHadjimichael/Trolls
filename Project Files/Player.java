//Implement the player, which moves in a direction specified by its call, the keypress handler.
//After its move is executed, all trolls in the world are moved.
//If the player collides with a troll, the troll movement returns a 1, and the game is over.
//Also holds its x and y coordinates, to be fetched easily by the troll movement algorithm so the trolls know which way to move.

//Author: Jordan Hadjimichael
//Date: 4/28/2021


import java.math.*;
import java.util.Random;

public class Player extends Block implements Entities {
   private int[] xy;
   private TrollPanel thispanel;
   private int result = 0;
   public Player(Block[][] world, int x, int y, TrollPanel panel) {
      xy = new int[] {x, y};
      thispanel = panel;
   }
   public boolean bcheck(Block[][] world, int newr, int newc)
   {
      if (newr < 0 || newr >= world.length
         || newc < 0 || newc >= world[0].length)
      {
         return false;
      } 
      if (world[newr][newc].getNum() != 0)
      {
         return false;
      }
      return true;
   }

   public int Move(Block[][] world, String d) {
      //will have specific movements to Player
      //Also calls troll movement, if returned a 1, game over
      //For every block in the world, execute Troll.move() if the block is of type troll
      int r = xy[0];
      int c = xy[1];
       
      int[] origcoords = {xy[0], xy[1]};
      switch(d)
      {
         case "n": //System.out.println("Moved the player up");
            if (bcheck(world, r-1, c))
            {
               world[r][c] = new Block();
               r = r-1;
               xy[0] = r;
               world[r][c] = this;
            }
            break;
         case "s": //System.out.println("Moved the player down");
            if (bcheck(world, r+1, c))
            {
               world[r][c] = new Block();
               r = r+1;
               xy[0] = r;
               world[r][c] = this;
            }
            break;
         case "e": //System.out.println("Moved the player to the right");
            if (bcheck(world, r, c+1))
            {
               world[r][c] = new Block();
               c = c+1;
               xy[1] = c;
               world[r][c] = this;
            }
            break;
         case "w": //System.out.println("Moved the player to the left");
            if (bcheck(world, r, c-1))
            {
               world[r][c] = new Block();
               c = c-1;
               xy[1] = c;
               world[r][c] = this;
            }
            break;
         case "nw": 
            if (bcheck(world, r-1, c-1))
            {
               world[r][c] = new Block();
               c = c-1;
               r = r-1; 
               xy[0] = r;
               xy[1] = c;
               world[r][c] = this;
            }
            break;
         case "ne": 
            if (bcheck(world, r-1, c+1))
            {
               world[r][c] = new Block();
               c = c+1;
               r = r-1; 
               xy[0] = r;
               xy[1] = c;
               world[r][c] = this;
            }
            break;
         case "sw": 
            if (bcheck(world, r+1, c-1))
            {
               world[r][c] = new Block();
               c = c-1;
               r = r+1; 
               xy[0] = r;
               xy[1] = c;
               world[r][c] = this;
            }
            break;
         case "se": 
            if (bcheck(world, r+1, c+1))
            {
               world[r][c] = new Block();
               c = c+1;
               r = r+1; 
               xy[0] = r;
               xy[1] = c;
               world[r][c] = this;
            }
            break;
         case "t":
            Random rand = new Random();
            world[r][c] = new Block();
            r = rand.nextInt(world.length);
            c = rand.nextInt(world[0].length);
            xy[0] = r;
            xy[1] = c;
            world[r][c] = this;
            break;
         case "poo":
            break;
      }
      int[] trollTarget = {r, c};
      //System.out.println(Integer.toString(trollTarget[0]));
      //System.out.println(Integer.toString(trollTarget[1]));
      Block[][] newworld = new Block[world.length][world[0].length];
      for(int i = 0; i<world.length; i++)
      {
         for(int a = 0; a<world[0].length; a++)
         {
            newworld[i][a] = new Block();
         }
      }
      newworld[xy[0]][xy[1]] = this;
      
      for (int a = 0; a<world.length; a++)
      {
         for (int b = 0; b<world[0].length; b++)
         {
            switch(world[a][b].getNum())
            {
               case 1: 
                  result += world[a][b].calculate(newworld, trollTarget);
                  break;
               case 3: 
                  newworld[a][b] = world[a][b];
                  break;
            }
         }
      }
      for (int a = 0; a<world.length; a++)
      {
         for (int b = 0; b<world[0].length; b++)
         {
            world[a][b] = newworld[a][b];
         }
      }
      return result;  
      
   }
   public int[] getxy()
   {
      //Return x y coords
      return xy;
   }
   public int getNum()
   {
      return 2;
   } 
}