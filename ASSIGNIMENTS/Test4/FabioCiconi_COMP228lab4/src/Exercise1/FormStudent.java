/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise1;
// JLabels with text and icons.
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import javax.swing.JTextArea;

/**
 *
 * @author ZeusAC
 */
public class FormStudent extends JFrame 
{
    private JTextField textName;
    private JTextField textAddress;
    private JTextField textProvince;
    private JTextField textCity;
    private JTextField textPostalCode;
    private JTextField textPhoneNumber;
    private JTextField textEmail;
    
    private JTextArea textResult;

    private JLabel labelName;
    private JLabel labelAddress;
    private JLabel labelProvince;
    private JLabel labelCity;
    private JLabel labelPostalCode;
    private JLabel labelPhoneNumber;
    private JLabel labelEmail;	
    
    private JRadioButton checkStudent[] = {new JRadioButton("Computer Science"), new JRadioButton("Business")};
    //private JCheckBox    checkCourse;
    //private JCheckBox    checkVolunteer;
    private final JCheckBox cbs[] = {new JCheckBox("Student Council"), new JCheckBox("Volunteer Work")};
    
    private JComboBox       comboBoxLanguage;
    
    private JList<String> listlanguages;
    
    private JButton buttonDisplay;
    
    /**
     *
     * @param title
     */
    public FormStudent(String title) 
    {
      super(title);
      buttonDisplay = new JButton("DISPLAY");
      buttonDisplay.setBounds(350, 320, 100, 30);
      add(buttonDisplay);
      
      buttonDisplay.addActionListener(new BtnClickHandler());

  
      
      //Name
      textName    = new JTextField("");
      textName.setBounds(120, 50, 200, 30);
      add(textName); 
      //Address
      textAddress = new JTextField("");
      textAddress.setBounds(120, 90, 200, 30);
      add(textAddress);
      //Province 
      textProvince = new JTextField("");
      textProvince.setBounds(120, 130, 200, 30);
      add(textProvince);
      //city
      textCity      = new JTextField("");
      textCity.setBounds(120, 170, 200, 30);
      add(textCity);
   
      //postal code 
      textPostalCode = new JTextField("");
      textPostalCode.setBounds(120, 210, 200, 30);
      add(textPostalCode);
   
      //phone     
      textPhoneNumber = new JTextField("");
      textPhoneNumber.setBounds(120, 250, 200, 30);
      add(textPhoneNumber);
       
      //email
      textEmail = new JTextField("");
      textEmail.setBounds(120, 290, 200, 30);
      add(textEmail);
      
      //isert labels
      labelName         = new JLabel("Name:");
      labelName.setBounds(0, 60, 80, 14);
      labelAddress 	= new JLabel("Address:");
      labelAddress.setBounds(0, 100, 80, 14);
      labelProvince     = new JLabel("Province:");
      labelProvince.setBounds(0, 140, 80, 14);
      labelCity         = new JLabel("City:");
      labelCity.setBounds(0, 180, 80, 14);
      labelPostalCode   = new JLabel("Postal Code:");
      labelPostalCode.setBounds(0, 220, 80, 14);
      labelPhoneNumber  = new JLabel("Phone:");
      labelPhoneNumber.setBounds(0, 260, 80, 14);
      labelEmail        = new JLabel("Email:");	  
      labelEmail.setBounds(0, 300, 80, 14);
	  
      add(labelName);       
      add(labelAddress);  
      add(labelCity);     
      add(labelProvince); 
      add(labelPostalCode); 
      add(labelPhoneNumber); 
      add(labelEmail);   
           
    //radios
    
    //JRadioButton checkCourse = new JRadioButton("Computer Science");
    checkStudent[0].setBounds(450, 0, 140, 30);
    //checkCourse.setBounds(450, 0, 140, 30);
    //JRadioButton checkStudent = new JRadioButton("Business");
    //JRadioButton.setBounds(600, 0, 120, 30);
    checkStudent[1].setBounds(600, 0, 120, 30);
    ButtonGroup br = new ButtonGroup();
    br.add(checkStudent[0]);
    br.add(checkStudent[1]);
    add(checkStudent[0]);
    add(checkStudent[1]);

    
    //checkboxes
   // checkStudent = new JCheckBox("Student");
    cbs[0].setBounds(320, 90, 200, 30);
    //checkStudent.setBounds(320, 90, 200, 30);
    //checkVolunteer = new JCheckBox("Volunteer");
    //checkVolunteer.setBounds(320, 250, 200, 30);
    cbs[1].setBounds(320, 250, 200, 30);
    add(cbs[0]);
    add(cbs[1]);
    
    
     listlanguages = new JList<String>(new DefaultListModel<String>());
     listlanguages.setBounds(580, 170, 200, 185);
     add(listlanguages);
    
    // Result
    textResult = new JTextArea();
    textResult.setBounds(0, 360, 790, 200);
     add(textResult);
    
  //combo
    comboBoxLanguage = new JComboBox();
    comboBoxLanguage.setVisible(true);
    comboBoxLanguage.addItem("Java");
    comboBoxLanguage.addItem("C++");
    comboBoxLanguage.addItem("PL/SQL");
    comboBoxLanguage.addItem("C#");
    comboBoxLanguage.addItem(".NET");
    comboBoxLanguage.addItem("COBOL");
    comboBoxLanguage.setBounds(580, 100, 200, 60);
    add(comboBoxLanguage);
    comboBoxLanguage.addItemListener((ItemEvent e) ->
      {
         if(e.getStateChange() == ItemEvent.SELECTED)
         {
            String item = comboBoxLanguage.getSelectedItem().toString();
            DefaultListModel model = (DefaultListModel)listlanguages.getModel();
            
            if (!model.contains(item))
            {
               model.addElement(item);
            }
         }
      });
     }

    /**
     *
     * @param args
     */
    public static void main(String[] args) 
    {
      FormStudent mf = new FormStudent("Exercise 1 - SWING");
      mf.setSize(800, 600);
      //setBounds(x, y, width, height) 
      //mf.setBounds(400, 100, 1024, 780);
  
      mf.getContentPane().setLayout(null);

      mf.setVisible(true);
      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }
   
private class BtnClickHandler implements ActionListener {


   @Override
   public void actionPerformed(ActionEvent event) 
   {
       
       String type=" ";
		for (JCheckBox cb:cbs){
			if (cb.isSelected()){
				type += cb.getText()+"-";
			}
		}
        
       String course=" ";
		for (JRadioButton cb1:checkStudent){
			if (cb1.isSelected()){
				course += cb1.getText()+"";
			}
		}
      
  
    int[] selectedIx = listlanguages.getSelectedIndices();
    //int[] selectedIx = listlanguages
    Object sel =null;
        for (int i = 0; i < selectedIx.length; i++)
    {
        sel = listlanguages.getModel().getElementAt(selectedIx[i]);
        
    }

      
      String str = String.format
            ( "First Name:%s%n"
            + "Adress:%s%n"   
            + "Province:%s%n"
            + "City:%s%n"
            + "Postal Code:%s%n"
            + "Phone Number:%s%n"
            + "E-mail:%s%n"
            + "Languange:%s%n"
            + "Type:%s%n"
            + "Couse:%s%n"
    
            , textName.getText()
            , textAddress.getText()
            , textProvince.getText()
            , textCity.getText()
            , textPostalCode.getText()
            , textPhoneNumber.getText()
            , textEmail.getText()
            , comboBoxLanguage.getSelectedItem()
            ,type
            ,course
            );
      
       textResult.setText(str);
   }
}
}