//Implements the corpse, which appears in the position of a collision between two Trolls
//It does not have any distiguishing methods or variables from block, just a seperate name.
//When run into by Troll or Player alike, the entity which moved into it is killed.
//It does not have movement

//Author: Jordan Hadjimichael
//Date: 4/28/2021


public class Corpse extends Block {
   public Corpse() {
      //No Variables
   }
   public int getNum()
   {
      return 3;
   }
}