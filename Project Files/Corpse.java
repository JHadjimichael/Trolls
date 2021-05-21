//Implements the corpse, which appears in the position of a collision between two Trolls
//It does not have any distiguishing methods or variables from block, just a seperate name.
//When run into by Troll or Player alike, the entity which moved into it is killed.
//It does not have movement

//Method:
//getNum - returns the "id" of the corpse, meant to be used in the array to differentiate blocks.

//Author: Jordan Hadjimichael
//Date: 5/20/2021


public class Corpse extends Block {
   public Corpse() {
      //No Variables
   }
   public int getNum()
   {
      return 3;
   }
}