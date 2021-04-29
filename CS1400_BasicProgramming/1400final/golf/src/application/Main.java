package application;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
	@Override


	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			// making some other elements besides the root border pane to help the game start
			
			// you ever put so many line breaks that you can't read your code? .... anyways....
			Label title = new Label("ASTEROIDS");
			Button start = new Button("click here to start the game lol");
			Button quit = new Button ("press this button to quit early");
//			//startGame.setLayoutX(0);
//	efficent		//startGame.setLayoutY(0);
//			quit.setLayoutX(0);
//			quit.setLayoutY(100);
			VBox menu = new VBox(title,start,quit);
			menu.setSpacing(10);
//			menu.getChildren().add(start);
//			menu.getChildren().add(quit);
			
			
			// back to the prebuilt javafx project stuff that I don't care about :)

			Label score = new Label ("14");
			score.setTextFill(Color.WHITE);
			Label life = new Label ("1 life remaining");
			life.setTextFill(Color.WHITE);
			life.setStyle("-fx-font: 25 arial;");
			VBox game = new VBox(root,score,life);
			
			Scene mainMenu = new Scene(menu,200,100,Color.BLACK);
			Scene scene = new Scene(game,1000,1000,Color.BLACK);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			primaryStage.setScene(mainMenu);

			// something stupid that I am trying
			// sometimes the shapes sort of leave a little trail behind... I thought it might be because 
			// the scene wasn't redrawing that area, so I added an object the size of the screen, so that the whole
			//screen is certainly redrawn... it didn't appear to fix the problem
			Rectangle abyss = new Rectangle();
			abyss.setX(0);
			abyss.setY(0);
			abyss.setWidth(1000);
			abyss.setHeight(1000);
			abyss.setFill(Color.BLACK);

			Ship ship = new Ship();
			// these are mostly for creating the ship... that doesn't seem great
			double shipcoords[] = {125,100,150,50,175,100,150,93};
			// order is           {x1, x2, y1, y2,z1, z2, a1, a2}
			ship.setShip(ship.init(shipcoords));

			// array of asteroids, so that I don't have to call new ones in the bad way that I was doing before :)
			// by referencing them one by one
			// http://www.javawithus.com/tutorial/array-of-objects
			// I used this site to figure out the syntax of making the array of asteroids.
			Asteroid[] ast = new Asteroid[7];
			// loop through assigning all the asteroids static 4 lines is better than 2(numAsteroids) number of line
			for (int z = 0;z<ast.length;z+=1) {
				ast[z] = new Asteroid();
				ast[z].setAsteroid(ast[z].init());
			}
			//Asteroid a1 = new Asteroid();
			//a1.setAsteroid(a1.init());
//			Asteroid a2 = new Asteroid();
//			a2.setAsteroid(a2.init());
//			Asteroid a3 = new Asteroid();
//			a3.setAsteroid(a3.init());
//			Asteroid a4 = new Asteroid();
//			a4.setAsteroid(a4.init());
//			Asteroid a5 = new Asteroid();
//			a5.setAsteroid(a5.init());
			// creates a bullet object, idont think this is how I want to do this in the end

			
			// this code is testing the size of the circle I might create for collision detection
			// it might be better to put this into the ship class somewhere... idk lol
			Circle test = new Circle();
			test.setRadius(25);
			//a1.setCoords(a1.mkpoint());

			root.getChildren().clear();

			// this is the controller for the button that starts the game... it's pretty much the same code as the handler for keypresses below... which is nice I guess
			start.setOnAction(new EventHandler<ActionEvent>()	{
					@Override public void handle(ActionEvent e) {
						//starts the game, by setting the stage to the scene with all the stuff in it... I hope
						primaryStage.setScene(scene);
					}
			});
			// this is the handler for the button that quits the program
			quit.setOnAction(new EventHandler<ActionEvent>()	{
				@Override public void handle(ActionEvent e) {
					// a google search for "java exit a program" gave me this line without even having to click a link... thanks google!
					System.exit(0);
				}
		});
			
		// this line from stackoverflow for how to write a keylistener for java ( the second answer, the first was too much stuff )
		// https://stackoverflow.com/questions/29962395/how-to-write-a-keylistener-for-javafx
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
		// Resume my original code here 
					if (event.getCode().equals(KeyCode.W)) {
						// move forward
						ship.setW(true);
					}
					else if (event.getCode().equals(KeyCode.S)) {
						// move backwards
						ship.setS(true);
					}
					if (event.getCode().equals(KeyCode.A)) {
						//rotate left
						ship.setA(true);
					}
					else if (event.getCode().equals(KeyCode.D)) {
						//rotate right
						ship.setD(true);
					}
					if (event.getCode().equals(KeyCode.SPACE)) {
						// create a bullet object 
					}
				}
			});
			scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
				public void handle(KeyEvent event) {
					if (event.getCode().equals(KeyCode.W)){
						ship.setW(false);
					}
					else if (event.getCode().equals(KeyCode.S)) {
						ship.setS(false);
					}
					if (event.getCode().equals(KeyCode.A)){
						ship.setA(false);
					}
					else if (event.getCode().equals(KeyCode.D)) {
						ship.setD(false);
					}

					
				}
				
			});
			root.getChildren().add(abyss);
			root.getChildren().add(ship.getShip());
			//root.getChildren().add(score);
			// loops through adding the existing asteroids to the screen dynamically
			for (int z = 0;z<ast.length;z+=1) {
				root.getChildren().add(ast[z].getAsteroid());
				}
			
			//root.getChildren().add(start);
//			root.getChildren().add(a1.getAsteroid());
//			root.getChildren().add(a2.getAsteroid());
//			root.getChildren().add(a3.getAsteroid());
//			root.getChildren().add(a4.getAsteroid());
//			root.getChildren().add(a5.getAsteroid());
//			//root.getChildren().add(test);
			
			 
			primaryStage.show();
			//https://netopyr.com/2012/06/14/using-the-javafx-animationtimer/ used this as reference for the example timer
			// I didn't directly copy it, but mine is pretty similar to this one.
			new AnimationTimer() {
				//@override
				public void handle(long now) {
					// resume my own fully original code
					if (ship.getW()== true){
						ship.setSpeed(ship.getSpeed()-.24);
						//ship.moveShip(ship.getShip(), ship.getSpeed());
					}
					else if (ship.getS()== true) {
						ship.setSpeed(ship.getSpeed()+.24);
						//ship.moveShip(ship.getShip(), ship.getSpeed());
					}
					if (ship.getA()== true) {
						ship.rotateShip(ship.getShip(),-3);

					}
					else if (ship.getD()==true ) {
						ship.rotateShip(ship.getShip(),3);

					}
					// speed handler
					if (ship.getSpeed()>= .1){
						ship.setSpeed(ship.getSpeed()-.1);
					}
					else if (ship.getSpeed() <= -.1) {
						ship.setSpeed(ship.getSpeed()+.1);
					}
					else 
					{
						ship.setSpeed(0);
					}
					// checks if the ship is outside the bounds
					ship.outofbounds();
					//if (ship.outofbounds())
					//{
						// sets the movespeed to exactly negative ( with a little extra) 
					//	ship.setSpeed(ship.getSpeed()*-1);
					//}
					// checks if the ship is colliding with the first asteroid
					
				for (int z = 0;z<ast.length;z+=1) {
					boolean scorecheck = ship.isColliding(test, ast[z].getHitbox());
					ast[z].collision(scorecheck);
						if (scorecheck) {
							// converting a string to an int, to add, then convert back to string lmao, im sure there's a better way to do this
							score.setText(Integer.toString((Integer.parseInt(score.getText())+ 1)));
						}
					}
				
//					a1.collision(ship.isColliding(test, a1.getHitbox()));
//					a2.collision(ship.isColliding(test, a2.getHitbox()));
//					a3.collision(ship.isColliding(test, a3.getHitbox()));
//					a4.collision(ship.isColliding(test, a4.getHitbox()));
//					a5.collision(ship.isColliding(test, a5.getHitbox()));

					ship.moveShip(ship.getShip(), ship.getSpeed());
					for (int z = 0;z<ast.length;z+=1) {
						ast[z].movement(ast[z].getAsteroid());
						}
//					a1.movement(a1.getAsteroid());
//					//a1.move(al1.getAsteroid(),5);
//					a2.movement(a2.getAsteroid());
//					a3.movement(a3.getAsteroid());
//					a4.movement(a4.getAsteroid());
//					a5.movement(a5.getAsteroid());

					
					//double x[] = ship.midpoint(this.ship.localToParent(this.midpoint(this.coords)[0],this.midpoint(this.coords)[1]););
					Point2D x = ship.getShip().localToParent(ship.midpoint(ship.getCoords())[0],ship.midpoint(ship.getCoords())[1]);

					test.setCenterX(x.getX());
					test.setCenterY(x.getY());

				}
				
			}.start();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
