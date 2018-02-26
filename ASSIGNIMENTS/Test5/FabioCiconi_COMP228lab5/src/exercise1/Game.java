/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import javax.swing.JFrame;

/**
 *
 * @author ZeusAC
 */
public class Game extends JFrame 
{

   /**
   *
   * @throws Exception
   */
   public Game() throws Exception 
   {
      try 
      {
         ConnectionGame da = new ConnectionGame();
         Interface ui = new Interface(da);
         this.add(ui);      
      } 
      catch (Exception e) 
      {
         e.printStackTrace();
         throw e;
      }

   }
   /**
   * @param args the command line arguments
   * @throws java.lang.Exception
   */
   public static void main(String[] args)throws Exception  
   {
      Game.setDefaultLookAndFeelDecorated(true);
       
      Game frame = new Game();
      //frame.setUndecorated(true);
      frame.setSize(800, 600);
      //frame.setBounds(0, 0, 900, 500);         
      //frame.pack();
      //frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setTitle("GAME - FABIO ALEXANDRE CICONI - 900390989");
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }   
}