
/*
@ Author (EDITED BY) Ethan Smith
@ DATE 3/28/19
@ Project : Fireball
@ Favorite Color : Red

*/
//stationary object to add to our window

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public class MovingObject extends StationaryObject
{
//Create instants variables to hold the needed velocities
private int vx;
private int vy;

	public MovingObject(int posx, int posy, BufferedImage bi, int imageW, int imageH, int vx, int vy)
	{
		//call the super constructor and then set the velocities
		super(posx, posy, bi, imageW, imageH);
		this.vx = vx;
		this.vy = vy;
		
	}
	
			
	//renders our object to the screen
	public void drawImage(Graphics g)
	{
		//because we added the bullet functions what should go here?
		//I intentionally left something out here for you to figure out
		posx += vx;
		posy += vy;
		g.drawImage(bi,posx, posy,imageW,imageH,null);
		//debugging the best way \/ 
		//System.out.println(posx+","+posy);
	
	}
	

	
}