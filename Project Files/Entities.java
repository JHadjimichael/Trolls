//This implements the Entities interface, which makes certain that a move method is included in a class
//Only Trolls and Players implement Entities, since they are the only two moving objects in the game
//The move method universally takes the world that the creature is in, so it can make decisions.  Think of this as sight.

//Author: Jordan Hadjimichael
//Date: 4/28/2021

import java.io.*;

public interface Entities {
//Moves depending on context.
   public abstract int Move(Block[][] world, String d);
}

