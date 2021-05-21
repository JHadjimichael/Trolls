//This is the troll class, the enemy of the game.  
//Will move towards the player at every call.
//If collides with another troll, both are replaced by one corpse object at the site of collision

//Methods: 
//calculate - determines where to move the troll, depending on where the player is.
//after the direction is establishes, a simple boundscheck determines what's in the space the troll wishes to move to.
//depending on the case, different effects happen.
//getNum - returns the "id" of the troll block, meant to be used in the array to differentiate blocks.

//Author: Jordan Hadjimichael
//Date: 5/20/2021
import java.math.*;

public class Troll extends Block implements Entities {
   private int[] xy;
   private int hori;
   private int verti;
   public int id;
   public TrollPanel thepanel;
   public Troll(Block[][] world, int x, int y, int i) {
      id = i;
      xy = new int[] {x, y};
   }
   public int calculate(Block[][] newworld, int[] target)
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
      //different cases
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
            return 1;
         case 3: //Corpse Collision
            //Corpses pile up!
            break;
      }
      return 0;
   }
   
   public int getNum()
   {
      return 1;
   }
}
