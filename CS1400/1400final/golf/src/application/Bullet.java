package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;

public class Bullet {
	private double [] coords;
	private double speed,angle;
	private Circle proj;
	private Translate t = new Translate();
	private boolean visible = false;
	public void setCoords(double[] coords) {
		this.coords = coords;
	}
	public double [] getCoords() {
		return this.coords;
	}
	public double getSpeed() {
		return this.speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getAngle() {
		return this.angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public Circle getCircle() {
		return this.proj;
	}
	public Circle init(double angle,double [] shipcoords) {
		// creates the bullet based on the current angle and position of the ship, (which are passed in at the start)
		this.setAngle(angle);
		this.setSpeed(10);
		// gets the front tip of the ship, from the coordinates passed in
		double [] bcoords = {shipcoords[2],shipcoords[3]};
		this.setCoords(bcoords);
		// a lot of this works the same as for the ship class.
		Circle a = new Circle();
		a.setFill(Color.GREEN);
		a.getTransforms().add(this.t);
		a.setRadius(3);
		this.proj = a;
		this.visible = true;
		return a;
		
	}
	public void movement() {
		if (this.visible) {
		// this is pretty much exactly how it works in the ship class, copies from there.
		double currentx = this.t.getX();
		double currenty = this.t.getY();
		
		this.t.setX((Math.cos(this.getAngle())* this.getSpeed())+currentx);
		this.t.setY((Math.sin(this.getAngle())* this.getSpeed())+currenty);
		}
		else {
			// dont do anything I guess
		}
	}
	
}
