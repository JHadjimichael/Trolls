//This is the troll class, the enemy of the game.  
//Will move towards the player at every call.
//If collides with another troll, both are replaced by one corpse object at the site of collision

//Author: Jordan Hadjimichael
//Date: 4/28/2021
import java.math.*;

public class Troll extends Block implements Entities {
   private int[] xy;
   private int hori;
   private int verti;
   public int id;
   public Troll(Block[][] world, int x, int y, int i) {
      id = i;
      xy = new int[] {x, y};
   }
   public void calculate(Block[][] newworld, int[] target)
   {
      int dr = 0;
      int dc = 0;
      if (xy[0] > target[0])
      {
         dr = -1;
      }
      if (xy[0] < target[0])
      {
         dr = 1;
      }
      if (xy[1] > target[1])
      {
         dc = -1;
      }
      if (xy[1] < target[1])
      {
         dc = 1;
      }
      int r = xy[0] + dr;
      int c = xy[1] + dc;
      switch (newworld[r][c].getNum())
      {
         case 0: //Empty
            newworld[r][c] = this;
            break;
         case 1: //Troll Collision
            newworld[r][c] = new Corpse();
            break;
         case 2: //Player Collision
            System.out.println("You were eaten!");
            System.exit(0);
            break;
         case 3: //Corpse Collision
            //Corpses pile up!
            break;
      }
   }

   /*public void Move(Block[][] world, String d) {
      int[] origcoords = {xy[0], xy[1]};
      int r = xy[0];
      int c = xy[1]; 
      
      System.out.println("Troll "+ Integer.toString(id) + " is at: " + Integer.toString(r) + Integer.toString(c));
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
               break;
            }
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
      }
      System.out.println("Troll is now at: " + " " + Integer.toString(r) + Integer.toString(c));
   }*/
   public int getNum()
   {
      return 1;
   }
}
