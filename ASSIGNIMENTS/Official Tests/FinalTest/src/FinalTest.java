/*
 * 
 * 
 * ============================================================================
 * Name...: Fabio Alexandre Ciconi
 * Number.: 300930989
 * Java Final Test - 3rd Semester (Winter)
 */

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * @author ZeusAC
 * Final Test
 * @version 1.0
 */
class ConnectionTest
{
   private PreparedStatement xxxxxxx;   
   private final Connection CONN;
   private final String USER ="system";
   private final String PASS ="cifa410829";
   private PreparedStatement queryCity;
   private ResultSet resultset;
   
   /**
    * constructor
   */
   ConnectionTest() throws SQLException 
   {
      CONN = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", USER, PASS);
      queryCity    = CONN.prepareStatement("SELECT * FROM student_comp228 where student_comp228.city = ?");
   
      System.out.println("++++++Connected to JDBC++++++");
   } 
   public String[] reportAll(String city) throws Exception
   {
        
      queryCity.setString(1, city);     
      ArrayList <String> replis = new ArrayList();
      Statement statement = CONN.createStatement();
      resultset = queryCity.executeQuery();     
      ResultSetMetaData metadata = resultset.getMetaData();
      if (resultset != null) 
      {
         //Poderia ter usado um LOOP
         String colluns = metadata.getColumnName(1) +"\t"+ metadata.getColumnName(2)+"\t"+
                          metadata.getColumnName(3) +"\t"+ metadata.getColumnName(4);
           replis.add(colluns);    
           
         while (resultset.next()) 
         {
            String id = resultset.getString(1); // using index
            String fname = resultset.getString(2); // using column-name
            String lname = resultset.getString(3); // using column-name
       
            replis.add(id + "\t" + fname+ "\t" + lname + "\t" + city + "\t");
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
}

/*
*Interface - create screens, buttons and labels
*/
class UserInterface extends JPanel implements ActionListener 
{
   private JTextField  jTextCity;    
   private JButton      btnQuery;
   private JTextArea    jGameResult;
   
   //var type- connection
   private final ConnectionTest da;
    
   //constructor
   UserInterface(ConnectionTest da) 
   {
      this.da = da;        
      JPanel pannelLabelBoxes = createPlayerPanel();     
      JPanel panelReport = createNewGamePanel();   
      add(pannelLabelBoxes, BorderLayout.NORTH);
      add(panelReport, BorderLayout.SOUTH);
      
   }

    private JPanel createPlayerPanel()
   {
      JPanel panel    = new JPanel();
      btnQuery        = new JButton("Query"); 
      jTextCity       = new JTextField(30);      
      panel.add(new Label("City: "));
      panel.add(jTextCity);
      panel.add(btnQuery);
         
	   btnQuery.addActionListener(this);
      return panel;
   }
    private JPanel createNewGamePanel()
   {
      JPanel panel    = new JPanel();
      jGameResult     = new JTextArea(5,50);
      JScrollPane scrollText = new JScrollPane (jGameResult);
      panel.add(scrollText);  
      return panel;
   }

   
   @Override
   public void actionPerformed(ActionEvent ae) 
   {      
       if (ae.getSource() == btnQuery)
      {
        try 
         {                    
            String city = jTextCity.getText();
            System.out.println("city =" +city);    
            String[] ff = da.reportAll(city);  
           
            for (String c: ff)
            {                  
               jGameResult.append(c +"\n");
            }      
         } 
         catch (Exception ex) 
         {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
   }
}

//class City
//{
//   private String cityName;
//   private String fname;
//   private String lname;
//   private String id;
//
//   City(String cityName, String fname, String lname, String id) 
//   {
//      this.cityName = cityName;
//      this.fname = fname;
//      this.lname = lname;
//      this.id = id;
//   }
//
//   public String getLname() 
//   {
//      return lname;
//   }
//
//   public void setLname(String lname)
//   {
//      this.lname = lname;
//   }
//
//   public String getId() 
//   {
//      return id;
//   }
//
//   public void setId(String id) 
//   {
//      this.id = id;
//   }
//
//
//   public String getCityName() {
//      return cityName;
//   }
//
//   public void setCityName(String cityName) {
//      this.cityName = cityName;
//   }
//   
//     
//} 

/**
 * EXECUTE CLASS - MAIN CLASS
 */
class FinalTest extends JFrame 
{
   /**
    * Constructor
    */
   FinalTest() throws Exception 
   {
	try 
   {
      ConnectionTest da = new ConnectionTest();
      UserInterface ui = new UserInterface(da);
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
   public static void main(String[] args) throws Exception 
   {
      FinalTest.setDefaultLookAndFeelDecorated(true);  
      FinalTest frame = new FinalTest();
      frame.pack();
      frame.setSize(600, 200);  
      frame.setResizable(false);
      frame.setTitle("FABIO ALEXANDRE CICONI - 900390989");
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
   }
   
}
