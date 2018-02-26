import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GridPaneTest extends Application {
	private TextField tf = new TextField(); // for firstname
	private TextField tf_ln = new TextField(); // for last name
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane and set its properties
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setHgap(5);
		pane.setVgap(5);
		
		// Place nodes in the pane
		pane.add(new Label("First Name:"), 0,0);
		pane.add(tf,  1, 0);
		pane.add(new Label("Last Name:"), 0,1);
		pane.add(tf_ln, 1, 1);

        Button btn = new Button();
        btn.setText("Submit");
        btn.setOnAction(new EventHandler<ActionEvent>() {
             @Override
            public void handle(ActionEvent event) {
                System.out.println("entered : "+tf.getText()+" "+tf_ln.getText());
            }
        });
        pane.add(btn, 1,2);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("GridPaneLayout"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) {
		launch(args);
	}
}