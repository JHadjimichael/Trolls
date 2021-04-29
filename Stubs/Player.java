import java.math.*;

public class Player extends Block implements Entities {
   public Player() {
      int destruction;
      int move_speed;
   }

   public void Move() {
      //will have specific movements to Player
      //Also calls troll movement, if returned a 1, game over
   }
   public int[] getxy()
   {
      //Return x y coords
      return new int[1];
   } 
}