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
      //System.out.println("Troll " +id+ " is at: " + " " + Integer.toString(xy[0]) + Integer.toString(xy[1]));
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
            xy[0] = r;
            xy[1] = c;
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
      //System.out.println("Troll is now at: " + " " + Integer.toString(r) + Integer.toString(c));
   }
   


      

   public int getNum()
   {
      return 1;
   }
}
