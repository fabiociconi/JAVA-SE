/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author ZeusAC
 */
public class ConnectionGame
{
   private PreparedStatement findPlayer, 
                             updatePlayer, 
                             addPlayer, 
                             queryPlayer, 
                             addPlayerGame,
                             reportPlayer,  
                             findGames,
                             deletePlayerGame,
                             addGame;
        
	private final Connection conn;
	private ResultSet resultset;
        
   private final String user ="system";
   private final String pass ="cifa410829";
        
   ConnectionGame() throws Exception 
   {
      ///connection	
      conn            = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", user, pass);

      findPlayer      = conn.prepareStatement("SELECT * FROM player WHERE rtrim(Player_id) = ? ");
        
      findGames       = conn.prepareStatement("SELECT Game_code from Player_Game where rtrim(Player_id) = ?");
                  
      reportPlayer    = conn.prepareStatement("SELECT * FROM player where player.last_name = ?");
                
      updatePlayer    = conn.prepareStatement("UPDATE player "
                                             + "SET player.first_name   = ?,"
                                             + "player.last_name        = ?,"
                                             + "player.postal_code      = ?"
                                             + "WHERE rtrim(player.Player_id) = ?");
	
      addPlayer       = conn.prepareStatement("INSERT into player values (?, ?, ?, ?)");
	
      addPlayerGame   = conn.prepareStatement("INSERT into Player_Game values (?, ?)");
        
      addGame         = conn.prepareStatement("INSERT into Game values (?, ?)");
        
      deletePlayerGame = conn.prepareStatement("DELETE from Player_Game WHERE rtrim(Player_Game.Player_id) = ?");
        
      //show connection
      System.out.println("++++++Connected to JDBC++++++");
   }
   /**
   *
   * @param id
   * @return
   * @throws Exception
   */
   public Player findPlayer(String id)throws Exception
   {
      Player pl = null;
      findPlayer.setString(1, id);
      resultset = findPlayer.executeQuery();
      if (resultset != null) 
      {
         if (resultset.next()) 
         {
            String fname = resultset.getString(2); // using index
            String lname = resultset.getString("last_name"); // using column-name
            String postecode = resultset.getString("postal_code");
            String 	game[] = findPlayerGame(id);												
				
            pl = new Player(fname, lname, id, postecode, game);
                
                System.out.println("Query ok");
         }
            resultset.close();
            return pl;
      } 
      else 
      {
         throw new Exception("****Cannot find record.****");
      }
   }
   
   private String[] findPlayerGame(String id)
   {
      ArrayList<String> alist = new ArrayList<>();
      try 
      {
         findGames.setString(1, id);
         resultset = findGames.executeQuery();		 
         if (resultset != null) 
         {
            while (resultset.next()) 
            {
               String cid = resultset.getString("Game_code"); // using index
               alist.add(cid);
            }
               resultset.close();
               String games [] = new String[alist.size()];
               return alist.toArray(games);
         }
         else
         {
            return new String[0];  //return empty array
         }
		 
      }
      catch (Exception ee)
      {
         return new String[0];  //return empty array
      }
   }
   /**
   *
   * @param st
   * @throws Exception
   */
   public void insertPlayerMethod(Player st) throws Exception 
   {
      addPlayer.setString(2, st.getFirstName());
      addPlayer.setString(3, st.getLastName());
      addPlayer.setString(4, st.getPostecode());
      addPlayer.setString(1, st.getPlayerid());       
      addPlayer.executeUpdate();
      addPlayerGameMethod(st.getPlayerid(), st.getGame());
      System.out.println("insert ok");             
   }
   /**
   *
   * @param st
   * @throws Exception
   */
   public void updatePlayerMethod(Player st) throws Exception 
   {
      deletePlayerGameMethod(st.getPlayerid());
      updatePlayer.setString(4, st.getPlayerid());
      updatePlayer.setString(1, st.getFirstName());
      updatePlayer.setString(2, st.getLastName());
      updatePlayer.setString(3, st.getPostecode());
      addPlayerGameMethod(st.getPlayerid(), st.getGame());
      updatePlayer.executeUpdate();
      System.out.println("update student ok");
   }
   private void addPlayerGameMethod(String id, String game[]) throws Exception
   {
      for (String c: game)
      {
         System.out.println("Insert table palyerGame"+id+c);
         addPlayerGame.setString(1, id);
         addPlayerGame.setString(2, c);
         addPlayerGame.executeUpdate();
         System.out.println("Insert table player_Game");
      }
   }

   /**
   *
   * @param gameID
   * @throws Exception
   */
   public void addGame(String gameID) throws Exception
   {
      //colocar um botao para inserir games
      addGame.setString(1, gameID);
      addGame.setString(2, user);
      addGame.executeUpdate();
      System.out.println("game inserted");
        
   }
   private void deletePlayerGameMethod(String id) throws Exception
   {     
      //System.out.println("delte table palyerGame"+id+c);
      deletePlayerGame.setString(1, id);
      //deletePlayerGame.setString(2, c);
      deletePlayerGame.executeUpdate();
      conn.commit();            
      System.out.println("delete table player_Game");
   }
   /**
   *
   * @return
   * @throws Exception
   */
   public String[] getGame() throws Exception 
   {
      String query = String.format("SELECT * FROM game");
      ArrayList <String> alist = new ArrayList();
      Statement statement = conn.createStatement();
      resultset = statement.executeQuery(query);
      if (resultset != null) 
      {
         while (resultset.next())
         {
            String id = resultset.getString("game_code"); // using index
            alist.add(id);
         }
            resultset.close();
            statement.close();
            String game [] = new String[alist.size()];
            return alist.toArray(game);
      } 
      else 
      {
         throw new Exception("Cannot find courses.");
      }
   }
   
   /**
   *
   * @param last
   * @return
   * @throws Exception
   */
   public String[] reportGames(String last) throws Exception
   {
        
      reportPlayer.setString(1, last);     
      ArrayList <String> replis = new ArrayList();
      Statement statement = conn.createStatement();
      resultset = reportPlayer.executeQuery();
      //resultset = statement.executeQuery(query);      
      if (resultset != null) 
      {
         while (resultset.next()) 
         {
            String fname = resultset.getString(2); // using index
            String lname = resultset.getString("last_name"); // using column-name
            String postecode = resultset.getString("postal_code");
            String id = resultset.getString(1);
            replis.add("Id: "+ id + " First Name: " + fname+ " Last Name: " + lname + " Poste Code: " + postecode);
         }
            resultset.close();
            statement.close();
            String info [] = new String[replis.size()];
            return replis.toArray(info);
      } 
      else 
      {
         throw new Exception("Cannot find record.");
      }
        
   }

   /**
   *
   * @return
   * @throws Exception
   */
   public String[] reportGamesAll() throws Exception
   {
      String query = String.format("SELECT * FROM player");
      ArrayList <String> replis = new ArrayList();
      Statement statement = conn.createStatement();
      resultset = statement.executeQuery(query);      
      if (resultset != null) 
      {
         while (resultset.next()) 
         {
            String fname = resultset.getString(2); // using index
            String lname = resultset.getString("last_name"); // using column-name
            String postecode = resultset.getString("postal_code");
            String id = resultset.getString(1);
            replis.add("Id: "+ id + " First Name: " + fname+ " Last Name: " + lname + " Poste Code: " + postecode);
         }
            resultset.close();
            statement.close();
            String info [] = new String[replis.size()];
            return replis.toArray(info);
      } 
      else 
      {
         throw new Exception("Cannot find record.");
      }  
   }
   /**
   *
   * @throws Exception
   */
   public void disonnect() throws Exception 
   {
      findPlayer.close();
      findGames.close();
      updatePlayer.close();
      addPlayer.close();
      queryPlayer.close();
      reportPlayer.close();
      conn.close();
   }
   /**
   * 
   *
   * @param s
   * @throws Exception
   */
   public static void main(String s[]) throws Exception 
   {
      ConnectionGame da = null;
      try 
      {
         da = new ConnectionGame();
         Player st = da.findPlayer("001");
         System.out.println("Player Id=" +st.getPlayerid());
      } 
      catch (Exception e) 
      {
         e.printStackTrace();
         throw e;
      }
      finally
      {
         if (da != null)
         {
            da.disonnect();
         }
      }
   }
}
