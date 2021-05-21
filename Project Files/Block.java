//This implements the block, which is the main superclass of the game.
//The block has no attributes, including variables and methods.
//The purpose of the block is to act as the base of the array, and to link all other objects in it.
//In the array which represents the world, every space is a Block
//In the graphics this is displayed as a white box with a black outline, creating the grid pattern.

//Methods:
//Move - An empty move which doesn't do anything. Neccessary for compiling and debugging.
//getNum - returns the "id" of the block, meant to be used in the array to differentiate blocks.
//Calculate - Empty, neccessary for compiling

//Author: Jordan Hadjimichael
//Date: 5/20/2021

import java.math.*;

public class Block {
   
   public Block() {
      //Blocks of the array
   }
   public int Move(Block[][] board, String d)
   {
      System.out.println("A block moved");
      return 0;
   }
   public int getNum()
   {
      return 0;
   } 
   public int calculate(Block[][] world, int[] target)
   {
      System.out.println("A block calculated, thinking of the possibilities, and the reason for its existence.");
      return 0;
   }
}