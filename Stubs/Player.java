//Implement the player, which moves in a direction specified by its call, the keypress handler.
//After its move is executed, all trolls in the world are moved.
//If the player collides with a troll, the troll movement returns a 1, and the game is over.
//Also holds it's x and y coordinates, to be fetched easily by the troll movement algorithm

//Author: Jordan Hadjimichael
//Date: 4/28/2021


import java.math.*;

public class Player extends Block implements Entities {
   public Player() {
   //No Variables
   }

   public void Move(Block[][] world) {
      //will have specific movements to Player
      //Also calls troll movement, if returned a 1, game over
      //For every block in the world, execute Troll.move() if the block is of type troll
   }
   public int[] getxy()
   {
      //Return x y coords
      return new int[1];
   } 
}