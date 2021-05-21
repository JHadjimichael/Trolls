//Implement the player, which moves in a direction specified by its call, the keypress handler.
//After its move is executed, all trolls in the world are moved.
//If the player collides with a troll, the troll movement returns a 1, and the game is over.
//Also holds its x and y coordinates, to be fetched easily by the troll movement algorithm so the trolls know which way to move.

//Methods:
//bcheck - checks if any given move is legal, and what its effects are.
//Move - moves the player in the array according to the string it is passed
//the two special cases are "t" and the spacebar.  "t" teleports, and the spacebar waits.
//After the player is moved, it creates a new array.  This array stores the new positions of trolls, after they're moved.
//This is to get around the array reader reading a troll's new position in the original array as a new troll.
//Move then returns its result, which specifies what happend that cycle.
//getXY - fetches the xy coordinates of the player in the array
//getNum - returns the "id" of the player, meant to be used in the array to differentiate blocks.

//Author: Jordan Hadjimichael
//Date: 5/20/2021


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
   //Takes everything it needs to determine if the new position is legal
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
         case "n": //up
            if (bcheck(world, r-1, c))
            {
               world[r][c] = new Block();
               r = r-1;
               xy[0] = r;
               world[r][c] = this;
            }
            break;
         case "s": //down
            if (bcheck(world, r+1, c))
            {
               world[r][c] = new Block();
               r = r+1;
               xy[0] = r;
               world[r][c] = this;
            }
            break;
         case "e": //right
            if (bcheck(world, r, c+1))
            {
               world[r][c] = new Block();
               c = c+1;
               xy[1] = c;
               world[r][c] = this;
            }
            break;
         case "w": //left
            if (bcheck(world, r, c-1))
            {
               world[r][c] = new Block();
               c = c-1;
               xy[1] = c;
               world[r][c] = this;
            }
            break;
         case "nw": //up and left
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
         case "ne": //up and right
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
         case "sw": //down and left
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
         case "se": //down and right
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
         case "t": //teleports
            Random rand = new Random();
            world[r][c] = new Block();
            r = rand.nextInt(world.length);
            c = rand.nextInt(world[0].length);
            xy[0] = r;
            xy[1] = c;
            if (bcheck(world, r, c))
            {
               world[r][c] = this;
            }
            else 
            {
               result = 1;
            }
            break;
         case "poo": //waits, with a immature variable name 
            break;
      }
      int[] trollTarget = {r, c};
      //creates and initializes the new array
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
                  //sets result
                  result += world[a][b].calculate(newworld, trollTarget);
                  break;
               case 3: 
                  newworld[a][b] = world[a][b];
                  break;
            }
         }
      }
      //copies over the newworld onto the old one
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