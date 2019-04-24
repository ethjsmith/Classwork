/*
@ Author : Ethan Smith
@ Date : 4/14/29
@ Assignment : Tower defense
@ File: Enemy
*/

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Enemy extends MovingObject{

	protected double hitPoints;
	protected double maxHp;
	protected double scale;
	protected int animation=1;
	protected int ani_counter;
	public BufferedImage[] t = new BufferedImage[2];

	public Enemy(int posx, int posy, BufferedImage bi, int imageW, int imageH, double vx, double vy, double hitPoints)
	{

		super(posx, posy, bi, imageW, imageH, vx, vy);
		this.hitPoints = hitPoints;
		// this stuff is for drawing the HP box
		this.maxHp = hitPoints;
		scale = imageW /maxHp;
		ani_counter = (int)(Math.random()*20)+1;
		try {
		t[0] = ImageIO.read(new File("assets/orc1.png"));
		t[1] = ImageIO.read(new File("assets/orc2.png"));
		changeImage(t[0]);
		}
		catch (IOException e) {
			System.out.println("error my dude");
		}
	}
	public boolean outside() {
		if (posy > 650)
			return true;
		return false;
	}
	public double getHitPoints()
	{
		return hitPoints;
	}
	public void takeDamage(int dmg) {
		//set hitpoints

		hitPoints -=dmg;
	}
	//overriding the child method
	// switch between 2 animations
	public void animate() {
		if (ani_counter > 20) {
			animation++;
			if (animation >= t.length) {
				animation =0;
			}
			changeImage(t[animation]);
			ani_counter=0;
		}else {
			ani_counter++;
		}

		/*if (ani_counter > 20) {
		if (animation == 1) {
			animation = 2;
			changeImage(t[1]);
		}
		else if (animation == 2) {
			animation = 1;
			changeImage(t[0]);
		}
		ani_counter=0;
		}else {
			ani_counter++;
		}*/
	}
	public void drawImage(Graphics g)
	{
		super.drawImage(g);
		//g.drawImage(bi,posx+=vx, posy+=vy,imageW,imageH,null);
		//midX+=vx;
		//midY+=vy;

		//draw a healthbar
		g.setColor(Color.RED);
		g.fillRect(posx,posy-3,(int)(scale*maxHp),2);
		g.setColor(Color.GREEN);
		if (hitPoints >= 0) {
			g.fillRect(posx,posy-3,(int)(scale*hitPoints),2);
		}
		else {
			g.fillRect(posx,posy-5,0,5);
		}


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
