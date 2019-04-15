/*
@ Author : Ethan Smith
@ Date : 4/14/29
@ Assignment : Tower defense
@ File: Enemy
*/

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public class Enemy extends MovingObject{
	
	private int hitPoints;
	private int maxHp;
	private int scale;
	
	public Enemy(int posx, int posy, BufferedImage bi, int imageW, int imageH, double vx, double vy, int hitPoints)
	{
		super(posx, posy, bi, imageW, imageH, vx, vy);
		this.hitPoints = hitPoints;
		// this stuff is for drawing the HP box
		this.maxHp = hitPoints;
		scale = imageW /maxHp;
	}
	public boolean outside() {
		if (posy > 650)
			return true;
		return false;
	}
	public int getHitPoints()
	{
		return hitPoints;
	}
	public void takeDamage(int dmg) {
		//set hitpoints
		
		hitPoints -=dmg;
	}
	//overriding the child method 
	public void drawImage(Graphics g)
	{
		super.drawImage(g);
		//g.drawImage(bi,posx+=vx, posy+=vy,imageW,imageH,null);
		//midX+=vx;
		//midY+=vy;
		
		//draw a healthbar
		g.setColor(Color.RED);
		g.fillRect(posx,posy-5,imageW,5);
		g.setColor(Color.GREEN);
		if (hitPoints >= 0) {
			g.fillRect(posx,posy-5,scale*hitPoints,5);
		}
		else {
			g.fillRect(posx,posy-5,0,5);
		}
		//complex to think about
		//x/100 = n/10
		
		
	}
	public int getXpos()
	{
		return posx;
	}
	
	public int getYpos()
	{
		return posy;
	}

}
