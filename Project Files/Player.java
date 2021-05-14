//Implement the player, which moves in a direction specified by its call, the keypress handler.
//After its move is executed, all trolls in the world are moved.
//If the player collides with a troll, the troll movement returns a 1, and the game is over.
//Also holds its x and y coordinates, to be fetched easily by the troll movement algorithm so the trolls know which way to move.

//Author: Jordan Hadjimichael
//Date: 4/28/2021


import java.math.*;

public class Player extends Block implements Entities {
   private int[] xy;
   public Player(Block[][] world, int x, int y) {
      xy = new int[] {x, y};
   }

   public void Move(Block[][] world, String d) {
      //will have specific movements to Player
      //Also calls troll movement, if returned a 1, game over
      //For every block in the world, execute Troll.move() if the block is of type troll
      System.out.println("A player moved");
      
      switch(d)
      {
         case "n": System.out.println("Moved the player up");
            break;
      }
      
      
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