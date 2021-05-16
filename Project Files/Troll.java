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
   public Troll(Block[][] world, int x, int y) {
     
      xy = new int[] {x, y};
   }
   public void calculate(Block[][] world, int[] target)
   {
      int hdiff;
      int ldiff;
      ldiff = Math.abs(target[0] - xy[0]);
      hdiff = Math.abs(target[1] - xy[1]);
      if (target[0] > xy[0])
      {
         hori = 1;
      }
      else{
         hori = -1;
      }
      if (target[1] > xy[1])
      {
         verti = 1;
      }
      else
      {
         verti = -1;
      }
      if (hdiff > ldiff && verti == -1)
      {
         this.Move(world, "n");
      }
      else if (hdiff > ldiff && verti == 1)
      {
         this.Move(world, "s");
      }
      else if (hdiff > ldiff && hori == -1)
      {
         this.Move(world, "e");
      }
      else if (hdiff > ldiff && hori == 1)
      {
         this.Move(world, "w");
      }
      //else
      //{
         //System.out.println("You Died!");
         //System.exit(0);
      //}
   }

   public void Move(Block[][] world, String d) {
      int[] origcoords = {xy[0], xy[1]};
      try
      {
         int r = xy[0];
         int c = xy[1]; 
         
      
         switch(d)
         {
            case "n": System.out.println("BeepUP");
               world[r][c] = new Block();
               r = r-1;
               xy[0] = r;
               world[r][c] = this;
               break;
            case "s": System.out.println("BeepDOWN");
               world[r][c] = new Block();
               r = r+1;
               xy[0] = r;
               world[r][c] = this;
               break;
            case "e": System.out.println("BeepRIGHT");
               world[r][c] = new Block();
               c = c+1;
               xy[1] = c;
               world[r][c] = this;
               break;
            case "w": System.out.println("BeepLEFT");
               world[r][c] = new Block();
               c = c-1;
               xy[1] = c;
               world[r][c] = this;
               break;
         }
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
         System.out.println("Illegal move attempted");
      }
   }
   public int getNum()
   {
      return 1;
   }
}
