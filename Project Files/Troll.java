//This is the troll class, the enemy of the game.  
//Will move towards the player at every call.
//If collides with another troll, both are replaced by one corpse object at the site of collision

//Author: Jordan Hadjimichael
//Date: 4/28/2021


public class Troll extends Block implements Entities {
   public Troll() {
      //No variables
   }

   public void Move(Block[][] world) {
      //will have specific movements to Troll
      //Gets called by player moving, "their eyesight is based on movement".
      //Returns 0 or 1 depending on collision with player
   }
}
