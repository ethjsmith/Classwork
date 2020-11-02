package application;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;


public class Main extends Application {
	@Override


	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,1000,Color.BLACK);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			Ship shippy = new Ship();
			
			double shipcoords[] = {125,100,150,50,175,100,150,93};
			// order is           {x1, x2, y1, y2,z1, z2, a1, a2}
			shippy.setCoords(shipcoords);
			
			
			Polygon ship = new Polygon(shipcoords[0],shipcoords[1],shipcoords[2],shipcoords[3],shipcoords[4],shipcoords[5],shipcoords[6],shipcoords[7]);
			ship.setFill(Color.WHITE);
			root.getChildren().clear();
			// this line from stackoverflow for how to write a keylistener for java ( the second answer, the first was too much stuff )
			// https://stackoverflow.com/questions/29962395/how-to-write-a-keylistener-for-javafx
			// I think if I also set a keylistener for keyrelease then I could make the ship move more than just every time the button is pressed 
			// ill try that after I make everything correct as far as objects work


			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
				// Resume my original code here 
					if (event.getCode().equals(KeyCode.W)) {
						// move forward
						shippy.setW(true);
					}
					else if (event.getCode().equals(KeyCode.S)) {
						// move backwards
						shippy.setS(true);
					}
					if (event.getCode().equals(KeyCode.A)) {
						//rotate left
						// this part was found in the java documentation... do I have to cite that? 
						shippy.setA(true);
					}
					else if (event.getCode().equals(KeyCode.D)) {
						//rotate right
						shippy.setD(true);
					}
					if (shippy.getW()== true){
						Translate tran = new Translate();
						tran.setY(-10);
						ship.getTransforms().add(tran);
					}
					else if (shippy.getS()== true) {
						Translate tran = new Translate();
						tran.setY(10);
						ship.getTransforms().add(tran);
					}
					if (shippy.getA()== true) {
						ship.getTransforms().add(new Rotate(-6,shipcoords[0],shipcoords[1]));
						ship.getTransforms().add(new Rotate(-6,shipcoords[2],shipcoords[3]));
						ship.getTransforms().add(new Rotate(-6,shipcoords[4],shipcoords[5]));
						ship.getTransforms().add(new Rotate(-6,shipcoords[6],shipcoords[7]));
					}
					else if (shippy.getD()==true ) {
						ship.getTransforms().add(new Rotate(6,shipcoords[0],shipcoords[1]));
						ship.getTransforms().add(new Rotate(6,shipcoords[2],shipcoords[3]));
						ship.getTransforms().add(new Rotate(6,shipcoords[4],shipcoords[5]));
						ship.getTransforms().add(new Rotate(6,shipcoords[6],shipcoords[7]));
					}
					
					//ship.relocate(shipcoords[0],shipcoords[1],shipcoords[2],shipcoords[3],shipcoords[4],shipcoords[5]);
				}
			});
			scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
				public void handle(KeyEvent event) {
					if (event.getCode().equals(KeyCode.W)){
						shippy.setW(false);
					}
					else if (event.getCode().equals(KeyCode.S)) {
						shippy.setS(false);
					}
					if (event.getCode().equals(KeyCode.A)){
						shippy.setA(false);
					}
					else if (event.getCode().equals(KeyCode.D)) {
						shippy.setD(false);
					}

					
				}
				
			});
			
			root.getChildren().add(ship);
			
			// end our code yAfEEl? 
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	// need to turn this whole thing into an object or pass ship into these before I can impliment my code in this way.

	public static void main(String[] args) {
		launch(args);
	}
}
