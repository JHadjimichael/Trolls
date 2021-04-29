import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TrollPanel extends JPanel
{
   private JPanel[][] graphic;
   private int[][] board;
   private JLabel title;
   private JButton quit;
   public TrollPanel()
   {
      //SetLayout
      setLayout(new BorderLayout());
      
      //Initialize board and graphics
      initialize();
      
      //Create entities
      createents(board);
      
      //Define Buttons
      createbuttons("Reset");
      
      //Define Movement Keys
      setup_movement();
      
      //Enemy AI + Movement
      setup_enemy_AI
   }
   private class Handler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      	//Quit Button
      }
   }
   private int initialize()
   {
      return -1;
   }
   private void createents(int[][] board)
   {
      //Create entities and place them on the board
   }
   private void createbuttons(String name)
   {
      //Create a button with this name
   }
   private void setup_movement()
   {
      //Create a button with this name
   }
}
}