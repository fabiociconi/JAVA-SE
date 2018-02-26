import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShapeTest extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		// Create a pane and set its properties
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(11, 12, 13, 14));
		
		Rectangle r1 = new Rectangle(25, 10, 60, 30);
		r1.setFill(Color.BLUE);
		pane.setCenter(r1);
		
        Button btn = new Button();
        btn.setText("Clear");
        ActionHandler handler = new ActionHandler(pane, btn, r1);
        btn.setOnAction(handler);
        pane.setBottom(btn);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("ShapesTest"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) {
		launch(args);
	}
}

class ActionHandler implements EventHandler<ActionEvent>{
	private BorderPane pane;
	private Button btn;
	private boolean bon = true;
	private Rectangle r1;
	
	ActionHandler(BorderPane pane, Button btn, Rectangle r1){
		this.pane=pane;
		this.btn=btn;
		this.r1=r1;
	}
    @Override
   public void handle(ActionEvent event) {
      if (bon){
   	   pane.setCenter(null);
   	   btn.setText("Show");
       }else{
       	pane.setCenter(r1);
       	btn.setText("Clear");
       }
      bon = !bon;
   }
}
