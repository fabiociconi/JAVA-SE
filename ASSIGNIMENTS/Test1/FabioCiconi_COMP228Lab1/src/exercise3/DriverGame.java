/** *****************************************************************************
 * Lab - Player provides coordinates X, Y, velocity and state. After program   *
 * Calculates the new positions and return whether the player is alive or not  *
 *-----------------------------------------------------------------------------*
 * Date = 01/23/2017     +   LAB #1 - ex 3           + @author: Fabio Ciconi   *
 ***************************************************************************** */
package exercise3;

import javax.swing.JOptionPane;

public class DriverGame 
{

   public static void main(String[] args) 
   {
      
        double x_pos_cent = 0.0;// Initial position X
        double y_pos_cent = 0.0; // Initial position X
        double x_value;	//Postion X gives by the player
        double y_value;//Postion Y gives by the player
        double v_velocity;//Velocity gives by the player

        //Takes the informations of the player
        x_value = Integer.parseInt(JOptionPane.showInputDialog("Enter X - Coordinates:"));
        y_value = Integer.parseInt(JOptionPane.showInputDialog("Enter Y - Coordinates:"));
        v_velocity = Integer.parseInt(JOptionPane.showInputDialog("Enter with Velocity:"));

        //Declare reference  - create object 
        GameObject GameObject1 = new GameObject(x_pos_cent, y_pos_cent, x_value, y_value, v_velocity);

        //Call methodos to calculate new positionin X
        GameObject1.x_New_Position(x_value, x_pos_cent);
        //Call methodos to calculate new positionin Y
        GameObject1.y_New_Position(y_value, y_pos_cent);

        //Take the staus provides by the player
        char s_state = JOptionPane.showInputDialog("Are you (A)live or (D)ead?").charAt(0);

        //Consist player state
        GameObject1.get_State(s_state);

        //Call method to format all informations
        String msg = GameObject1.get_Information_Player();

        //Show formatted result	
        JOptionPane.showMessageDialog(null, msg);
   }
}
