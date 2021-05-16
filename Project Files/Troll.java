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
      
   }

   public void Move(Block[][] world, String d) {
      int[] origcoords = {xy[0], xy[1]};
      int r = xy[0];
      int c = xy[1]; 
      
      System.out.println("Troll "+ Integer.toString(id) + " is at: " + Integer.toString(r) + Integer.toString(c));
      switch(d)
      {
         case "n": //System.out.println("Moved the player up");
            try{
               world[r][c] = new Block();
               r = r-1;
               xy[0] = r;
               world[r][c] = this;
               break;
            }
            catch(ArrayIndexOutOfBoundsException e){
               r = r+1;
               xy[0] = r;
               world[r][c] = this;
               break;
            }
         case "s": //System.out.println("Moved the player down");
            try{
               world[r][c] = new Block();
               r = r+1;
               xy[0] = r;
               world[r][c] = this;
               break;
            }
            catch(ArrayIndexOutOfBoundsException e){
               r = r-1;
               xy[0] = r;
               world[r][c] = this;
               break;
            }
         case "e": //System.out.println("Moved the player to the right");
            try{
               world[r][c] = new Block();
               c = c+1;
               xy[1] = c;
               world[r][c] = this;
               break;
            }
            catch(ArrayIndexOutOfBoundsException e){
               c -= 1;
               xy[1] = c;
               world[r][c] = this;
               break;
            }
         case "w": //System.out.println("Moved a troll to the left");
            try{
               world[r][c] = new Block();
               c = c-1;
               xy[1] = c;
               world[r][c] = this;
               break;
            }
            catch(ArrayIndexOutOfBoundsException e){
               c += 1;
               xy[1] = c;
               world[r][c] = this;
               break;
            }
      }
      System.out.println("Troll is now at: " + " " + Integer.toString(r) + Integer.toString(c));
   }
   public int getNum()
   {
      return 1;
   }
}
