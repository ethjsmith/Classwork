/*
@ Author : Ethan Smith
@ Date : 4/14/29
@ Assignment : Tower defense
@ File: MapObject
*/
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class MapObject
{
	protected int posx; 
	protected int posy;
	protected BufferedImage bi; 
	protected int imageW;
	protected int imageH;
	protected int midX,midY;
	protected int hitboxRadius;

	MapObject(int x,int y,int z) {
		// this trash is only here because this method is abstract...
		// I don't like abstract methods, because I needed a generic object and couldn't use
		// this one 
	}
	MapObject(int posx, int posy, BufferedImage bi, int imageW, int imageH)
	{
		this.posx = posx;
		this.posy = posy; 
		this.bi= bi;
		this.imageW = imageW; 
		this.imageH = imageH;
		
		// midpoint to base the hitbox circle upon
		midX = posx + (int)(imageW * .5);
		midY = posy + (int)(imageH * .5);
		// the radius of the circle that will be the hitbox of everything
		// probably a bit clunky
		hitboxRadius = (int)(((imageW * .5) + (imageH * .5)) / 2); 
	}
	public void changeImage(BufferedImage b) {
		bi = b;
	}
	public int getRadius() {
		return hitboxRadius;
	}
	public int getMidX() {
		return midX;
	}
	public int getMidY() {
		return midY;
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
	//renders our object to the screen
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,posx, posy,imageW,imageH,null);
	}
	public int getX() {
		return posx;
	}
	public int getY() {
		return posy;
	}
	public int getWidth() {
		return imageW;
	}
	public int getHeight() {
		return imageH;
	}
}