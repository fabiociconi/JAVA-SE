/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author ZeusAC
 */
class Interface extends JPanel implements ActionListener 
{
   private JTextField  jTextName;
   private JTextField  jTextLast;
   private JTextField  jTextId;
   private JTextField  jTextPosteCode;
   private JTextField  jTextGameTitle;
   private JList       jListArea1;
   private JButton     btnQuery;
   private JButton     btnClear;
   private JButton     btnUpdate;
   private JButton     btnReport;
   private JButton     btnInsert;   
   private JButton     btnExit;
   private JButton     btnAddGame;
   private JList       gameNames;
   private final ConnectionGame da;
    
   ///constructor
   Interface(ConnectionGame da) 
   {
      this.da = da;        
      
      JPanel pannelLabelBoxes = createPlayerPanel();        
      pannelLabelBoxes.setBackground(Color.CYAN);
        
      JPanel pannelButtons = createButtonPanel();
      pannelButtons.setBackground(Color.BLACK);  
    
      JPanel panelReport = createReportPanel();
      panelReport.setBackground(Color.ORANGE);
	
      JPanel panelNewGame = createNewGamePanel();
      panelReport.setBackground(Color.PINK);
            
      add(pannelButtons);
      add(pannelLabelBoxes);     
      add(createGamePanel());
      add(panelReport);
      add(panelNewGame);
      
   }

 
     
   private JPanel createButtonPanel()
   {
      JPanel panel2   = new JPanel();
      btnQuery        = new JButton("Query");                
      btnUpdate       = new JButton("Update");
      btnReport       = new JButton("Report");
      btnInsert       = new JButton("Insert");
      btnClear        = new JButton("Clear");
      btnExit         = new JButton("Exit");
        
      panel2.add(btnQuery);
      panel2.add(btnUpdate);
      panel2.add(btnReport);
      panel2.add(btnInsert);
      panel2.add(btnClear);
      panel2.add(btnExit);
          
      btnQuery.addActionListener(this);
      btnUpdate.addActionListener(this);
      btnReport.addActionListener(this);
      btnInsert.addActionListener(this);
      btnClear.addActionListener(this);
      btnExit.addActionListener(this);
       
      return panel2;
   }

   private JPanel createReportPanel()
   {
      JPanel panel3   = new JPanel();
      JScrollPane  jScrollPane2 = new JScrollPane();
      jListArea1      = new JList();
      jListArea1.setVisibleRowCount(3);    
      jScrollPane2.setPreferredSize(new Dimension(600, 200));
      jScrollPane2.setViewportView(jListArea1);
      panel3.add(jScrollPane2);
   
      return panel3;
   }
   
   private JPanel createPlayerPanel()
   {
      JPanel panel    = new JPanel();
       
      panel.setLayout(new GridLayout(4,4));
      jTextId         = new JTextField(5);
      jTextPosteCode  = new JTextField(5); 
      jTextName       = new JTextField(20);
      jTextLast       = new JTextField(20);
	
      panel.add(new Label("Id: "));
      panel.add(jTextId);
	        
      panel.add(new Label("Postal Code: "));
   	panel.add(jTextPosteCode);
        
      panel.add(new Label("First Name: "));
      panel.add(jTextName);
	
      panel.add(new Label("Last Name: "));
   	panel.add(jTextLast);      
	
      return panel;
   }
   
   private JPanel createGamePanel()
   {
      JPanel panel    = new JPanel();
      gameNames       = new JList(getGameNames());        
      gameNames.setVisibleRowCount(4);
      gameNames.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	
      panel.add(new Label("Games: "));
      panel.add(new JScrollPane(gameNames));

      return panel;		
   }
   
   private JPanel createNewGamePanel()
   {
      JPanel panel = new JPanel();
      btnAddGame = new JButton("Add Game");
      jTextGameTitle = new JTextField(20);
      panel.add(new Label("Type New Game: "));
      panel.add(jTextGameTitle);
      panel.add(btnAddGame);
      btnAddGame.addActionListener(this);
   
      return panel;
   }
   
   private  JList montaJogos()
   {
      gameNames       = new JList(getGameNames());        
      return gameNames;
   }
   
   private String[] getGameNames()
   {
      try 
      {
         return da.getGame();
      } 
      catch(Exception ee)
      {
         return new String[0];  //return an empty array
      }
   }   
   
   @Override
   public void actionPerformed(ActionEvent ae) 
   {
      if (ae.getSource() == btnQuery)
      {
         String id = jTextId.getText();
         if (id != null)
         { 
            try 
            {
               Player pl = da.findPlayer(id);               
               jTextName.setText(pl.getFirstName());
               jTextLast.setText(pl.getLastName());
               jTextId.setText(pl.getPlayerid());
               jTextPosteCode.setText(pl.getPostecode());
                    
               String games[] = pl.getGame();
               int idxs[] = new int[games.length];
               int i=0;
            
               for (String c: games)
               {
                  gameNames.setSelectedValue(c, true);
                  idxs[i]=gameNames.getSelectedIndex();
                  i++;
               }
               
               gameNames.setSelectedIndices(idxs);
            } 
            catch (Exception e) 
            {
               JOptionPane.showMessageDialog( this, "Please type one Code to Query", "Error", JOptionPane.ERROR_MESSAGE );
            
            }
        
         }
      } 
      else if (ae.getSource() == btnUpdate)
      {
         try 
         {
            List<String> list = gameNames.getSelectedValuesList();
            String games[] = new String[list.size()];                  
            Player pl = new Player(jTextName.getText(), jTextLast.getText(), 
            jTextId.getText(),jTextPosteCode.getText(), list.toArray(games));
            da.updatePlayerMethod(pl);
         }
         catch (Exception e) 
         {
            JOptionPane.showMessageDialog( this, "Nothing to Update or Fail", "Error", JOptionPane.ERROR_MESSAGE );
         }
      } 
      else if (ae.getSource() == btnInsert) 
      {
         try 
         {
            List<String> list = gameNames.getSelectedValuesList();
            String games[] = new String[list.size()];
            Player pl = new Player(jTextName.getText(), jTextLast.getText(), 
            jTextId.getText(),jTextPosteCode.getText(), 
            list.toArray(games));
            da.insertPlayerMethod(pl);
         } 
         catch (Exception e) 
         {
            e.printStackTrace();
         }
      }
      else if (ae.getSource() == btnClear)
      {               
         try 
         {
            //clear all fields
            jTextName.setText("");
            jTextLast.setText("");
            jTextId.setText("");
            jTextPosteCode.setText("");
            jTextGameTitle.setText("");        
            jListArea1.setModel(new DefaultListModel());//entender
            DefaultListModel limpa =  (DefaultListModel) jListArea1.getModel();
            limpa.removeAllElements();                  
            gameNames.clearSelection();
     
         } 
         catch (Exception ee) 
         {
            ee.printStackTrace();            
         }   
      }
      else if (ae.getSource() == btnReport)
      {
         try 
         {             
            String last = jTextLast.getText();
            System.out.println("last=" +last);
            System.out.println("jTextLast=" +jTextLast.getText());
            if (last.isEmpty())
            {
               String[] vazio = da.reportGamesAll(); 
               int i=0;
               DefaultListModel list = new DefaultListModel();
               
               for (String c: vazio)
               {
                  list.addElement(vazio[i]);
                  i++;
               }                       
               jListArea1.setModel(list);
            }
            else 
            {
               String[] ff = da.reportGames(last);  
               int i = 0;
               DefaultListModel list = new DefaultListModel();
      
               for (String c: ff)
               {
                  list.addElement(ff[i]);
                  i++;
               }      
                    
               jListArea1.setModel(list);
            }
             
         } 
         catch (Exception ex) 
         {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (ae.getSource() == btnExit)
        {
            System.out.println("Closed");
            try 
            {
               System.exit(0);
            } 
            catch (Exception ex) 
            {
               Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (ae.getSource()== btnAddGame)
        {
            System.out.println("add games pressed");
            try
            {
               String newGame = jTextGameTitle.getText();
               if (newGame.isEmpty())
               {
                  System.out.println("no game");
               }
               else
               {                  
                  da.addGame(newGame);

                  DefaultListModel dlm = new DefaultListModel();

                  for(int i = 0; i < gameNames.getModel().getSize(); i++) 
                  {
                     dlm.addElement(gameNames.getModel().getElementAt(i));
                  }
                  
                  dlm.addElement(newGame);
                  gameNames.setModel(dlm);
                  
               }              
            } 
            catch (Exception ex) 
            {
               Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   }   
}