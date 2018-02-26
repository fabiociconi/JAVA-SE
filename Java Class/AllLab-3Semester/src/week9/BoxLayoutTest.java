package week9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BoxLayoutTest extends Application {
	private TextField tf = new TextField(); // for firstname
	private TextField tf_ln = new TextField(); // for last name

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane and set its properties
		VBox pane = new VBox();
		pane.setPadding(new Insets(20, 20, 20, 20));

		pane.getChildren().add(getTitle());
		pane.getChildren().add(getFieldsPane());
		pane.getChildren().add(getButtonPane());

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("BoxLayoutTest"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private FlowPane getTitle() {
		FlowPane pane = new FlowPane();
		Label label = new Label("Entry Form");
		label.setFont(new Font(30));
		pane.getChildren().add(label);
		pane.setAlignment(Pos.CENTER);
		return pane;
	}

	private GridPane getFieldsPane() {
		GridPane pane = new GridPane();
		// Place nodes in the pane
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("First Name:"), 0, 0);
		pane.add(tf, 1, 0);
		pane.add(new Label("Last Name:"), 0, 1);
		pane.add(tf_ln, 1, 1);
//      pane.add(new Label ("test"),0,2);
//      pane.add(tf_ln, 1, 2);
		return pane;
	}

	// TRY - modify the code so that when cancel or next is pressed, you print
	// something
	private HBox getButtonPane() {
		HBox fpane = new HBox();
		fpane.setSpacing(5);

		fpane.getChildren().add(new Button("Cancel"));
		Button btn = new Button();
		btn.setText("Ok");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("entered : " + tf.getText() + " " + tf_ln.getText());
			}
		});

		fpane.getChildren().add(btn);
		fpane.getChildren().add(new Button("Next"));
		fpane.setAlignment(Pos.CENTER);
		return fpane;
	}

	public static void main(String[] args) {
		launch(args);
	}
}