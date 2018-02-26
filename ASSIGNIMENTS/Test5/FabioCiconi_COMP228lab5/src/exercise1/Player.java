/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

/**
 *
 * @author ZeusAC
 */
public class Player 
{
        private String firstName;
	private String lastName;
	private String playerid;
        private String postecode;
	private String game[];
        private String newGame;

    /**
     *
     * @param firstName
     * @param lastName
     * @param playerid
     * @param postecode
     * @param game
     * @param newGame
     */
    public Player(String firstName, String lastName, String playerid, String postecode, String[] game,
                  String newGame) {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.postecode  = postecode;
        this.game       = game;
        this.newGame    = newGame;
        
        this.playerid = playerid;
        Integer.parseInt(playerid);
    }
        public Player(String firstName, String lastName, String playerid, String postecode, String[] game)                 {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.postecode  = postecode;
        this.game       = game;               
        this.playerid = playerid;
        Integer.parseInt(playerid);
    }


//    Player(String text, String text0, String text1, String text2, String[] toArray) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     *
     * @return
     */
    public String getNewGame(){
        return newGame;
        
    }

    /**
     *
     * @param newGame
     */
    public void setNewGame(String newGame) {
        this.newGame = newGame;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the playerid
     */
    public String getPlayerid() {
        return playerid;
    }

    /**
     * @param playerid the playerid to set
     */
    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }

    /**
     * @return the postecode
     */
    public String getPostecode() {
        return postecode;
    }

    /**
     * @param postecode the postecode to set
     */
    public void setPostecode(String postecode) {
        this.postecode = postecode;
    }

    /**
     * @return the game
     */
    public String[] getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(String[] game) {
        this.game = game;
    }
}
