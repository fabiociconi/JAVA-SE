/** *****************************************************************************
 * Lab - Player provides coordinates X, Y, velocity and state. After program   *
 * Calculates the new positions and return whether the player is alive or not  *
 *-----------------------------------------------------------------------------*
 * Date = 01/23/2017     +   LAB #1 - ex 3           + @author: Fabio Ciconi   *
 ***************************************************************************** */
package exercise3;

public class GameObject {

    double x_pos_cent_game;//x central position
    double y_pos_cent_game;//y central position
    double x_value_game;//x player position
    double y_value_game;//y player position 
    double v_velocity_game;//velocity
    double x_new_position;//new x position
    double y_new_position;//new y position
    String string_status;//palyer states (Alive or Dead) 

    // Multiple Argument Constructor 
    /* @param x_pos_cent_aux - x central position auxiliar
     * @param y_pos_cent_aux - y central position auxiliar
     * @param x_pos_aux - x player position auxiliar
     * @param y_pos_aux - y player position auxiliar
     * @param v_vel_aux - player velocity
     */
    GameObject(double x_pos_cent_aux, double y_pos_cent_aux, double x_pos_aux,
            double y_pos_aux, double v_vel_aux) {
        x_value_game = x_pos_aux;
        y_value_game = y_pos_aux;
        v_velocity_game = v_vel_aux;
        x_pos_cent_game = x_pos_cent_aux;
        y_pos_cent_game = y_pos_cent_aux;
    }

    //Calculate New position X
    public void x_New_Position(double x_pos_cent_aux, double x_pos_aux) {
        x_new_position = x_pos_aux - x_pos_cent_aux;
    }

    //Calculate New position Y
    public void y_New_Position(double y_pos_cent_aux, double y_pos_aux) {
        y_new_position = y_pos_aux - y_pos_cent_aux;

    }

    //Verify Player States
    public String get_State(char s_state_aux) {
        if (s_state_aux == 'A') {
            string_status = "Alive";
        } else {
            string_status = "Dead";
        }
        return string_status;
    }

    //* Fomart the Player information
    public String get_Information_Player() {
        String Info;
        Info = String.format("  PLAYER INFORMATION: %n"
                + "Initial Position-X: %s%n"
                + "Initial Position-Y: %s%n"
                + "Velocity          : %s km/h%n"
                + "State             : %s%n"
                + "Final Position-X  : %s%n"
                + "Final Position-Y  : %s%n",
                x_pos_cent_game, y_pos_cent_game, v_velocity_game,
                string_status, x_new_position, y_new_position);

        return Info;
    }

}
