package application;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Translate;

public class Asteroid {
	private double [] coords;
	private Polygon asteroid;
	private Circle hitbox = new Circle();
	private double xx,yy,diff=.05;
	private Translate t = new Translate();
	
	public double [] getCoords() {
		return this.coords;
	}
	public void setCoords(double [] coords) {
		this.coords = coords;
	}
	public double r() {
		// save me some time not having to rewrite this line 1000 times and then change it a lot
		return (Math.random()*25)-12;
	}
	public double [] mkpoint(int point) {
		// this is really stupid, and the p1,p2 variables only exist so that I could better visualize the data zZz
		// that being said, I think it's pretty cool
		
		// it picks a random number, (between 5 and 8) and uses one of the cases below 
		// to generate the asteroid... making it(the point) random using the method "R" above
		int p1 = point,p2 = point;
		// this bit is kind of dumb too, it originally worked differently 
		int z = (int)Math.floor(Math.random()*4+4);

		if (z == 4) {
			double [] a = {
					this.r()+p1-20,		this.r()+p2-20,
					this.r()+p1,		this.r()+p2-30,
					this.r()+p1+20,		this.r()+p2-20,
					this.r()+p1+30,		this.r()+p2,
					this.r()+p1+20,		this.r()+p2+20,
					this.r()+p1,		this.r()+p2+30,
					this.r()+p1-20,		this.r()+p2+20,
					this.r()+p1-30,		this.r()+p2
					};
			return a;
		}
		else if (z == 5) {
			double [] a = {
					this.r()+p1-20,		this.r()+p2-20,
					this.r()+p1,		this.r()+p2-30,
					this.r()+p1+20,		this.r()+p2-20,
					this.r()+p1+20,		this.r()+p2+20,
					this.r()+p1-20,		this.r()+p2+20
				};
			return a;
		}
		else if (z == 6) {
			double [] a = {
					this.r()+p1-20,		this.r()+p2-20,
					this.r()+p1,		this.r()+p2-30,
					this.r()+p1+20,		this.r()+p2-20,
					this.r()+p1+30,		this.r()+p2,
					this.r()+p1+20,		this.r()+p2+20,
					this.r()+p1-20,		this.r()+p2+20
				};
			return a;
		}
		else {
			double [] a = {
					this.r()+p1-20,		this.r()+p2-20,
					this.r()+p1,		this.r()+p2-30,
					this.r()+p1+20,		this.r()+p2-20,
					this.r()+p1+30,		this.r()+p2,
					this.r()+p1+20,		this.r()+p2+20,
					this.r()+p1,		this.r()+p2+30,
					this.r()+p1-20,		this.r()+p2+20
				};
			return a;
		}

	}
	public Polygon init() {
		// this is the part of the class that creates the asteroid
		int p =(int)Math.floor(Math.random()*800+100);
		this.setCoords(this.mkpoint(p));
		Polygon aster = new Polygon(this.getCoords());
		aster.setFill(Color.BROWN);
		aster.getTransforms().add(this.t);
		this.setxx(Math.random()*5);
		this.setyy(Math.random()*5);
		//this.setHitbox();
		// running this line doesn't work lol  /\ it tried to call asteroid before it's ... "initalized" haha
		this.hitbox.setFill(Color.GREEN);
		return aster;
	}
	// these two methods get and set the hitbox... one is more interesting than the other!
	public Circle getHitbox() {
		return this.hitbox;
	}
	public void setHitbox() {
		double total=0,count=0;
		double [] m = this.midpoint(this.getCoords());
		Point2D mp= this.asteroid.localToParent(m[0],m[1]);
		this.hitbox.setCenterX(mp.getX());
		this.hitbox.setCenterY(mp.getY());
		// get a rough radius, so that the hitbox is about the right size
		for (int i=0;i<coords.length;i+=2) {
			double rad = Math.sqrt(Math.pow((m[0]-this.coords[i] ),2) + Math.pow((m[1]-this.coords[i+1]),2));
			total +=rad;
			count +=1;
		}
		// this is the average distance of every point on the asteroid (-2 because they still felt a little big sometimes)
		this.hitbox.setRadius(total/count-2);
		
	}
	// this sets the hitbox color... for testing mostly for now
	public void collision(Boolean c) {
		if (c) {
			//this.hitbox.setFill(Color.rgb(255, 0, 0,0.2));
			this.asteroid.setFill(Color.GREEN);
		}
		else {
			this.asteroid.setFill(Color.rgb(105,35,5));

		}
	}
	
	public Polygon getAsteroid() {
		return this.asteroid;
	}
	public void setAsteroid(Polygon aster) {
		this.asteroid = aster;
	}
	public double [] midpoint (double [] coords) {
		// c1 is the X value
		//c2 is the Y value
		double c1 =0,c2=0,count=0;
		for (int i=0;i<coords.length;i+=2) {
			c1 += coords[i];
			c2 += coords[i+1];
			count +=1;
		}
		double mp[] = {c1/count,c2/count};
		return mp;
	}

	//public Polygon movement(Polygon asteroid) {
	//	// movement is a bad name for this method, it just rotates the asteroid
	//	coords = this.getCoords();
	//	for (int i=0;i<coords.length;i+=2) {
	//		this.asteroid.getTransforms().add(new Rotate(0.25,coords[i],coords[i+1]));
	//	}

		
	//	return asteroid;
	//}
	
	//public void move(Polygon asteroid, int mov) {
	//	coords = this.getCoords();
	//	for (int i=0;i<coords.length;i++) {
	//		coords[i]+=1;
	//	}
	//	
	//	this.setCoords(coords);
	//}
	public double getxx() {
		return this.xx;
	}
	public void setxx(double xx) {
		this.xx=xx;
	}
	public double getyy() {
		return this.yy;
	}
	public void setyy(double yy) {
		this.yy=yy;
	}
	public void movement(Polygon asteroid) {
		coords = this.getCoords();

		// get the current amount that the transform is moving
		double currentx = this.t.getX();
		double currenty = this.t.getY();
			//if (this.asteroid.getTransforms().isEmpty()) {
				//get the midpoint of the asteroid (roughly) with the method written above
				double mid[] = this.midpoint(coords);
				mid[0] += currentx;
				mid[1] += currenty;
				//System.out.println(this.asteroid.getTransforms());
				// set the direction of the asteroid ( so that it moves a little differently every time)
				// and so that it turns around when it hits walls
				
				//if (mid[0] > 1000) {
				//	this.diff = this.diff + .02;
				//	this.setxx((Math.random()+this.diff)*-1);
				//}
				//else if(mid[0] < 0) {
			/*		this.diff = this.diff + .02;
					this.setxx((Math.random()+this.diff)*1);
				}
				if (mid[1] > 1000) {
					this.diff = this.diff + .02;
					this.setyy((Math.random()+this.diff)*-1);
				}
				else if (mid[1] < 0) {
					this.diff = this.diff + .02;
					this.setyy((Math.random()+this.diff)*1);
			*/	//}
				
				//really the above is great, but I think I just want the asteroids to wrap around like the ship does
				if (mid[0] > 1000) {
					this.t.setX(currentx + this.getxx() -1000);
				}
				else if (mid[0] < 0) {
					this.t.setX(currentx +this.getxx() + 1000);
				}
				else {
					this.t.setX(currentx + this.getxx());
				}
				if (mid[1] > 1000) {
					this.t.setY(currenty +this.getyy() -1000);
				}
				else if (mid[1] < 0) {
					this.t.setY(currenty +this.getyy() + 1000);
				}
				else {
					this.t.setY(currenty+this.getyy());
				}
				


				this.setHitbox();
				//t.setY(mid[2]);
				//this.asteroid.getTransforms().add(t);
			//}
			//else {
				
			//}
		}
		
		
	}
