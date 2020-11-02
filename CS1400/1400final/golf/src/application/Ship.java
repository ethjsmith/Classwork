package application;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class Ship {
// this is the ship object... I don't usually code objects so this might be a little rough
	private double [] coords;
	private double angle,speed;
	//private int speed;
	// boolean variables for checking if the ship is currently moving in any direction.
	private boolean w=false,a=false,s=false,d=false,collide=false;
	private Polygon ship;
	private Translate t = new Translate();
	private Rotate r = new Rotate();
	
	public double [] getCoords() {
		return this.coords;
	}
	public void setCoords(double [] co) {
		this.coords = co;
	}
	public boolean getW() {
		return this.w;
	}
	public void setW(boolean w) {
		this.w = w;
	}
	public boolean getA() {
		return this.a;
	}
	public void setA(boolean a) {
		this.a = a;
	}
	public boolean getS() {
		return this.s;
	}
	public void setS(boolean s) {
		this.s = s;
	}
	public boolean getD() {
		return this.d;
	}
	public void setD(boolean d) {
		this.d = d;
	}
	public Polygon getShip() {
		return this.ship;
	}
	public void setShip(Polygon ship) {
		this.ship = ship;
	}
	public void setSpeed(double s) {
		this.speed = s;
	}
	public double getSpeed() {
		return this.speed;
	}
	// this method checks two circles ( the hitboxes for the ship and an asteroid) to see if they are colliding
	public boolean isColliding(Circle a, Circle b) {
// https://developer.mozilla.org/en-US/docs/Games/Techniques/2D_collision_detection
// this article helped me figure out the mechanics of collision detection, and I decided to go with
		// circle partly because it just makes sense, it's just the distance formula, and checking the radius of 2 circles
		// and it's also a bit more precise than drawing rectangles around the ships
		double xx = a.getCenterX() - b.getCenterX();
		double yy = a.getCenterY() - b.getCenterY();
		double dist = Math.sqrt(Math.pow(xx, 2) + Math.pow(yy,2));
		double totalr = a.getRadius() + b.getRadius();
		if (dist < totalr) {
			collide = true;
		}
		else {
			collide = false;
		}
		return collide;
	}
	public Polygon init(double[] coords) {
		// intialize the ship, add the transforms that will affect the ship
		this.setCoords(coords);
		Polygon a = new Polygon(this.getCoords());
		a.setFill(Color.WHITE);
		a.getTransforms().add(this.t);
		a.getTransforms().add(this.r);
		double mp[] = this.midpoint(coords);
		this.r.setPivotX(mp[0]);
		this.r.setPivotY(mp[1]);
		this.setSpeed(0);
		return a;
	}
	public double [] midpoint (double [] coords) {
		//roughly caclulate the midpoint of the ship, might be used for collision detection ( with a circle around the midpoint)
		double c1 =0,c2=0,count=0;
		for (int i=0;i<coords.length;i+=2) {
			c1 += coords[i];
			c2 += coords[i+1];
			count +=1;
		}
		double mp[] = {c1/count,c2/count};
		return mp;
	}
	public void rotateShip(Polygon ship,int rotation) {
		coords = this.getCoords();
		double mid[] = this.midpoint(coords);
		// gets the amount that the ship is currently transformed by, and adds the user input to that, using it as the new value
		// before I was just adding new transforms every time this ran, which was making the program lag. (I think... it stopped when I changed it to this way anyways)
		double currentrotate = this.r.getAngle();
		this.r.setAngle(currentrotate + rotation);
					//,coords[i],coords[i+1]));
		//}
		//System.out.println(this.ship.getTransforms());
	}
	public void moveShip(Polygon ship,double move) {
		//Translate t = new Translate();
		// similar to above, gets the amount that the ship is already offset by. and then add that later
		double currentx = this.t.getX();
		double currenty = this.t.getY();
		// this is wrong haha
		Point2D midd= this.ship.localToParent(this.midpoint(this.coords)[0],this.midpoint(this.coords)[1]);
		
		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html
		// the image examples really helped me to understand what I was doing wrong before, and I didn;t know about
		// local to parent, which i am using in the getAngle() function
		// I also looked at this for the math formulas, I was trying to use math.tan before. ( although I think that page is in a different language)
		// https://gamedev.stackexchange.com/questions/36046/how-do-i-make-an-entity-move-in-a-direction
			
		this.t.setX((Math.cos(this.getAngle())* move)+currentx);
		this.t.setY((Math.sin(this.getAngle())* move)+currenty);
		
		// this line for debugging.
		System.out.println(this.t.getX()+" "+ this.t.getY() +"=="+ this.getAngle()*(180/Math.PI));
		//this.t.setY(currenty+ move);
		//this.ship.setTranslateY(move + currenty);
		//this.ship.getTransforms().add(this.t);
	}
	//public double getAngle() {
	//	return this.angle;
	//}
	public void setAngle(double a) {
		this.angle = a;
	}
	public void direction() {
		double ang = this.getAngle();
		this.setAngle(ang);

	}
	public Boolean outofbounds () {
		Point2D mid = this.ship.localToParent(this.midpoint(this.coords)[0],this.midpoint(this.coords)[1]);
		Boolean a = false;
		// checks if the ship's midpoint is outside the bounds of the screen
		if (mid.getX() > 1000 || mid.getX() < 0 || mid.getY()  > 1000|| mid.getY() < 0) {
			a = true;
		}
		// a more asteroid-y way to do this is making the ship wrap around I think.... Ill try that instead ... less chance of getting stuck
		// like this 
		// yep that works great... I wonder if the asteroids should do that too! 
		if (mid.getX() > 1000) {
			this.t.setX(this.t.getX()-1000);
		}
		else if (mid.getX() < 0) {
			this.t.setX(this.t.getX()+1000);
		}
		if (mid.getY() > 1000) {
			this.t.setY(this.t.getY()-1000);
		}
		else if (mid.getY() < 0) {
			this.t.setY(this.t.getY()+1000);
		}
		
		return a;
	}
	public double getAngle() {
		// this point is the nose of the ship
		Point2D point1 = this.ship.localToParent(coords[2],coords[3]);
		// this point is the indent at the back of the ship
		Point2D point2 = this.ship.localToParent(coords[6],coords[7]);
		// the form a straight line, which you can use to get the angle the ship is pointing
		// https://stackoverflow.com/questions/21483999/using-atan2-to-find-angle-between-two-vectors
		// found the formula here, it's talking about vectors, but I just used points instead and it worked.
		double angle = Math.atan2(point2.getY()-point1.getY(), point2.getX()-point1.getX());
		return angle; //* (180 / Math.PI);
	}
}
