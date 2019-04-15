/*
@ Author : Ethan Smith
@ Date : 4/14/29
@ Assignment : Tower defense
@ File: Bullet1
@ Why TF doesn't this inherit from movingobject? 
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.*;

public class Bullet1  {
	private double vx;
	private double vy;
	private double posX;
	private double posY;
	private int midX,midY,hitboxRadius;

	public Bullet1(int posX, int posY, double vx, double vy) {
		this.posX = (double)posX;
		this.posY = (double)posY;
		this.vx=vx;
		this.vy=vy;
		midX=posX+4;
		midY=posY+4;
		hitboxRadius = 10;
	}
	//renders our object to the screen
	public void drawImage(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval((int)(posX +=vx), (int)(posY+=vy), 7,7);
		midX +=vx;
		midY += vy;
	}
	//If we are going to be able to have enemies take damage, we need a way to know the bullet position
	public double getXpos() {
		return posX;
	}
	
	public double getYpos() {
		return posY;
	}
	public boolean isColliding (MapObject m) {
		//checks if this object and another object are colliding
		// returns true if colliding, otherwise false
		int distance = (int)Math.sqrt(Math.pow((midX-m.getMidX()),2)+Math.pow((midY-m.getMidY()),2));
		if (distance <= hitboxRadius + m.getRadius()) {
			return true;
		}
		return false;
	}
	public boolean isOutside() {
		// if the bullet is outside the boundaries of the map, destroy it 
		if (posX < -10 || posX > 610 || posY < -10 || posX > 610) {
			return true;
		}
		return false;
	}
}