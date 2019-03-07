package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	Label c_label;
	Label f_label;
	TextField c_field;
	TextField f_field;
	Button c_button;
	Button f_button;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();// ctrl + shift + o to import all stuff
			Scene scene = new Scene(root,500,100); //set size
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			// our code goes here 
			
			//init components
			c_label = new Label("celcius");
			f_label = new Label("farenheight");
			
			c_field = new TextField();
			f_field = new TextField();
			
			c_button = new Button("convert to C");
			f_button = new Button("convert to F");
			
			// add components to screen
			root.add(c_label, 0, 0);
			root.add(f_label, 0, 1);
			root.add(c_field, 1, 0);
			root.add(f_field, 1, 1);
			root.add(c_button,2, 0);
			root.add(f_button,2, 1);
			
			f_button.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e) {
				// the stuff that the button does goes here 
					double cel = Double.parseDouble(c_field.getText());
					double far = cel * 1.8 + 32;
					f_field.setText(far + "");
				}
			});
			c_button.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e) {
				// the stuff that the button does goes here 
					double far = Double.parseDouble(f_field.getText());
					double cel = (far - 32) / 1.8;
					c_field.setText(cel + "");
				}
			});
			primaryStage.show();// makes the screen show
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
