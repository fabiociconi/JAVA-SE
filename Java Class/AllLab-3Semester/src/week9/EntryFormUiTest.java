package week9;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EntryFormUiTest extends Application {

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane and set its properties
		VBox pane = new GuiBuilder();
		// Place nodes in the pane

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 350, 350);
		primaryStage.setTitle("GridPaneLayout"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}


class GuiBuilder extends VBox implements EventHandler<ActionEvent> {
	private TextField tf = new TextField(); // for firstname
	private TextField tf_ln = new TextField(); // for last name
	//initializing array
	private CheckBox cbs[] = {new CheckBox("Java"), new CheckBox("HTML"), new CheckBox("C#")};
	private TextArea ta = new TextArea();
	
	GuiBuilder (){
		super(20);
		setPadding(new Insets(10,10,10,10));
		getChildren().add(getTopPane());
		getChildren().add(getTextareaPane());
	}

	private GridPane getTopPane(){
		GridPane pane = new GridPane();
		pane.add(getDataPane(), 0,0);
		pane.add(getOptionsPane(), 1, 0);
		pane.setAlignment(Pos.CENTER_RIGHT);
		return pane;
	}
	
	private GridPane getDataPane(){
		GridPane pane = new GridPane();
		// Place nodes in the pane
		pane.setPadding(new Insets(10,10,10,10));
		pane.add(new Label("First Name:"), 0,0);
		pane.add(tf,  1, 0);
		pane.add(new Label("Last Name:"), 0,1);
		pane.add(tf_ln, 1, 1);
		Button btn= new Button("Test");
		btn.setOnAction(this);
		pane.add(btn, 1, 2);
		return pane;
	}
	private VBox getOptionsPane(){
		VBox paneForCheckBoxes= new VBox();
		Label label = new Label("Courses");
		label.setFont(new Font(20));
		paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5));
		paneForCheckBoxes.setStyle("-fx-border-color: green");
		paneForCheckBoxes.getChildren().add(label);
		for (CheckBox cb:cbs){
			paneForCheckBoxes.getChildren().add(cb);
		}
		return paneForCheckBoxes;
	}

	private ScrollPane getTextareaPane(){
		return new ScrollPane(ta);
	}
	
    @Override
   public void handle(ActionEvent event) {
    	String courses=" ";
		for (CheckBox cb:cbs){
			if (cb.isSelected()){
				courses += cb.getText()+", ";
			}
		}
    	String str = String.format("First Name:%s%n LastName: %s%n Courses:%s", tf.getText(), tf_ln.getText(),
    			courses);
    	ta.setText(str);
   }
}

