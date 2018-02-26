/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author ZeusAC
 */
public class FXFormStudent extends Application 
{

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) 
        {
            
		// Create a pane and set its properties
		VBox pane = new GuiBuilder();
		// Place nodes in the pane
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 800, 600);
                pane.setVisible(true);
		primaryStage.setTitle("Form Student"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
    /**
     *
     * @param args
     */
    public static void main(String[] args) 
    {
		launch(args);
    }
}


class GuiBuilder extends VBox implements EventHandler<ActionEvent> 
{

        private final TextField textName        = new TextField();
        private final TextField textAddress     = new TextField();
        private final TextField textProvince    = new TextField();
        private final TextField textCity        = new TextField();
        private final TextField textPostalCode  = new TextField();
        private final TextField textPhoneNumber = new TextField();
        private final TextField textEmail       = new TextField();
        private final ComboBox  comboLaguange   = new ComboBox();
	private final CheckBox cbs[] = {new CheckBox("Student Council"), new CheckBox("Volunteer Work")};
        private final RadioButton cbs1[] = {new RadioButton("Computer Science"), new RadioButton("Business")};
	private final TextArea result = new TextArea();
        private final ListCell listProgram = new ListCell();
        
	
	GuiBuilder ()
        {
		super(1);
		setPadding(new Insets(1,1,1,1));
		getChildren().add(getTopPane());
                getChildren().add(getTextareaPane());
//               getChildren().add(getTextareaPane1());
	}
       
	private GridPane getTopPane()
        {
		GridPane pane = new GridPane();            
		pane.add(getDataPane(), 0,0);		
		pane.setAlignment(Pos.TOP_LEFT);
                pane.setGridLinesVisible(true);
		return pane;
	}
	
	private GridPane getDataPane()
        {
		GridPane pane = new GridPane();
                pane.setGridLinesVisible(true);
		// Place nodes in the pane
		//pane.setPadding(new Insets(1,1,1,1));
		pane.add(new Label("First Name:"), 0,0);
		pane.add(textName,  1, 0);
		
                pane.add(new Label("Address:"), 0,1);
                pane.add(textAddress, 1, 1);
                                
                pane.add(new Label("City:"), 0,2);
                pane.add(textCity, 1, 2);
                                
                pane.add(new Label("Postal Code:"), 0,3);
                pane.add(textPostalCode, 1, 3);
                
                pane.add(new Label("Province:"), 0,4);
                pane.add(textProvince, 1, 4);
                
                pane.add(new Label("Phone Number:"), 0,5);
                pane.add(textPhoneNumber, 1, 5);
                
                pane.add(new Label("Email:"), 0,6);
                pane.add(textEmail, 1, 6);
                
                comboLaguange.getItems().addAll( "Java", "C#", "Cobol");
                pane.add(comboLaguange,10,8);
                
                pane.add(cbs1[0],10,0);
                pane.add(cbs1[1],9,0);
                
                pane.add(cbs[0],5,3);
                pane.add(cbs[1],5,5);
                
		Button btn= new Button("Display");
		btn.setOnAction(this);
		pane.add(btn, 1, 7);                
		return pane;
	}
//	private VBox getOptionsPane(){
//		VBox paneForCheckBoxes= new VBox();
////		Label label = new Label("Courses");
////		label.setFont(new Font(20));
////                
//		paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5));
//		paneForCheckBoxes.setStyle("-fx-border-color: green");
////		paneForCheckBoxes.getChildren().add(label);
//		listProgram.setAlignment(Pos.TOP_RIGHT);
////                
////                for (CheckBox cb:cbs){
////			paneForCheckBoxes.getChildren().add(cb);
////		}
//		return paneForCheckBoxes;
//	}
     
//        private GridPane languanges()
//        {
//            GridPane pane1 = new GridPane();      
//	   pane1.add(getDataPane(), 1,1);
//            pane1.setAlignment(Pos.TOP_RIGHT);
//            pane1.add(listProgram, 1, 1);
//            pane1.setVisible(true);
//            
//            return pane1;
//        }
	private ScrollPane getTextareaPane()
        {
            return new ScrollPane(result);
	}
	
    @Override
   public void handle(ActionEvent event) 
   {
    	String courses=" ";
		for (CheckBox cb:cbs)
                {
			if (cb.isSelected())
                        {
				courses += cb.getText()+"-";
			}
		}
    	String str = String.format("Name:%s%n"
                + "Adress:%s%n "
                + "City:%s%n"
                + "Province:%s%n"
                + "Postal Code:%s%n"
                + "Phone Number:%s%n"
                + "E-mail:%s%n"
                + "Courses:%s%n"
                + "type:%s%n",
                textName.getText(), textAddress.getText(),textCity.getText(),
                textProvince.getText(),textPostalCode.getText(), textPhoneNumber.getText(), 
                textEmail.getText(), 
                comboLaguange.getValue(),
                courses);
    	result.setText(str);
   }
}

