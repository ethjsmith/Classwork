package application;

import javafx.scene.transform.Translate;

public class bullet {
	private double[] coords;
	private double angle;
	private double speed;
	private Translate t = new Translate();
	// this is the bullet class. you use it to shoot asteroids... simple enough I hope?
	// probably this will just be a lot of code that is pretty much the same as ship,( in fact angle will probably come straight from there )
	public double [] getCoords() {
		return this.coords;
	}
	public void setCoords(double[] point) {
		this.coords = point;
	}
	public double getAngle() {
		return this.angle;
	}
	public void setAngle(double a) {
		this.angle = a;
	}
	public double getSpeed() {
		return this.speed;
	}
	public void setSpeed(double s) {
		this.speed = s;
	}
	public void init(double [] origin, double angle) {
		this.setAngle(angle);
		// creates the bullet object at the origin of the ship
		
	}
	public void move() {
		// move the bullet based on 
		if (this.bounds()) {
			// do something here... idk stop the object from moving
			this.t.setX(-1000);
			this.t.setY(-1000);
		}
		else {
			// this is pretty much exacly the same as how it works for the ship
		double currentx = this.t.getX();
		double currenty = this.t.getY();
		
		this.t.setX(Math.cos((this.getAngle())*this.getSpeed()) + currentx);
		this.t.setY(Math.sin((this.getAngle())*this.getSpeed()) + currenty);
		}
	}
	public boolean bounds() {
		// this function checks if the bullet has left the screen
		double[] a  = this.getCoords();
		boolean out = false;
		if (a[0] > 1000 || a[0] < 0 || a[1] > 1000 || a[1] < 0) {
			// do something to stop / destroy the bullet :3
			out = true;
		}
		else {
			out = false;
		}
		return out;
		
	}
	
}
