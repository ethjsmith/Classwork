/*
@ Author : Ethan Smith
@ Date : 4/14/29
@ Assignment : Tower defense
@ File: MovingObject
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MovingObject extends MapObject {
	
	private double vx;
	private double vy;
	
	public MovingObject(int posx, int posy, BufferedImage bi, int imageW, int imageH, double vx, double vy)
	{
		super(posx, posy, bi,  imageW, imageH);
		this.vx=vx;
		this.vy=vy;
	}
	
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,posx+=vx, posy+=vy,imageW,imageH,null);
		midX+=vx;
		midY+=vy;
	}
	public double getVx() {
		return vx;
	}
	public double getVy() {
		return vy;
	}

}
