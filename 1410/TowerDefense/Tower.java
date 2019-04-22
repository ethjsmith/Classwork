/*
@ Author : Ethan Smith
@ Date : 4/14/29
@ Assignment : Tower defense
@ File: Tower
*/
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.*;

import java.awt.Color;

public class Tower extends MapObject{

	protected Bullet1 b1;
	protected int range;
	protected ArrayList<Bullet1> bullets = new ArrayList<Bullet1>(0);
	protected Enemy target;
	protected int canfire=0;
	public BufferedImage[] t = new BufferedImage[4];
	protected int velocity;

	// tower stats
	protected int power,speed,level;

	public Tower(int posx, int posy, BufferedImage bi, int imageW, int imageH)
	{
		super(posx, posy, bi, imageW, imageH);
		//b1 = new Bullet1(posx, posy, 10,10);
		range = (int)(hitboxRadius*5);
		speed = 60;
		power = 5;
		level = 1;
		velocity=15;
		try {
			//initalize all of the tower images and save them as files to be accessed
			t[0] = ImageIO.read(new File("tower1.png"));
			t[1] = ImageIO.read(new File("tower2.png"));
			t[2] = ImageIO.read(new File("tower3.png"));
			t[3] = ImageIO.read(new File("tower4.png"));
		}
		catch (IOException e) {
			System.out.println("Unable to generate tower due to IO exception");
		}
	}
	public int getPowerLevel() {
		return level;
	}
	public void upgrade () {
		if (level < 4) {
			level++;
			power+=3;
			speed-=12;
			range +=hitboxRadius;
			this.changeImage(t[level-1]);
		}else {
			System.out.println("MAX LEVEL ALREADY");
		}
	}
	//Added this to override parent
	//Wanted it to draw a bullet when the tower was drawn
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,posx, posy,imageW,imageH,null);
		//draws all the bullets associated with a tower
		for ( int z=0;z<bullets.size();z++) {
			if (bullets.get(z).isOutside()) {
					bullets.get(z);
					bullets.remove(z);
				}
		}
		for ( int z=0;z<bullets.size();z++) {
			bullets.get(z).drawImage(g,Color.BLACK);
		}
	}
	//checks if there is an enemy within range of the tower
	public boolean isInRange(MapObject m) {
		//System.out.println("checking range");
		int distance = (int)Math.sqrt(Math.pow((midX-m.getMidX()),2)+Math.pow((midY-m.getMidY()),2));
		if (distance <= range + m.getRadius()) {
			return true;
		}
		return false;
	}
	public void hitEnemy(ArrayList<Enemy> enemies) {
		for (int z=0;z<enemies.size();z++) {
			for (int r=0;r<bullets.size();r++) {
				if (bullets.get(r).isColliding(enemies.get(z))) {
					bullets.remove(r);
					enemies.get(z).takeDamage(power);
					System.out.println("hit");
				}
			}
		}
	}
	public boolean checkForEnemy(ArrayList<Enemy> enemies) {
		//checks if there are any enemies within range of the tower... returns true as soon as it is seen
		hitEnemy(enemies);
		for (int z=0;z<enemies.size();z++) {
			if (this.isInRange(enemies.get(z))) {
				target = enemies.get(z);
				//System.out.println("firing");
				fire();

				return true;
			}
		}
		target=null;
		// stops the fire towers from breaking as enemies pass them
		for (int r=bullets.size()-1;r>=0;r--) {
			bullets.remove(r);
		}
		return false;
	}
	//fires at an enemy?
	public void fire() {
		//bullets.add(new bullet1(midX,midY,10,10));
		// i hate trig, almost as much as I hate Calc lmao help
		if (canfire >speed) {
			//targets with a guess based on where the orc is moving
			// 20 can be changed if the tower is over or underfiring
			double predictedVy = target.getMidY() + (target.getVy()*15);
			double predictedVx = target.getMidX() + target.getVx()*15;
			if (target != null) {
				double angle = Math.atan2((double)(predictedVy-midY),(double)(predictedVx-midX));
				double vx = velocity*(Math.cos(angle));
				double vy = velocity*(Math.sin(angle));
				bullets.add(new Bullet1(midX,midY,vx,vy,this,300));
				canfire=0;
			}
		}else {
			canfire++;
		}

		// is it fucking Trigonometry time ? I fucking hate everything
	}
	//Got to return the bullet to check the position
	public Bullet1 getBullet()
	{
		return b1;
	}

	public void destroyBullet()
	{
		b1 = null;
	}
	public ArrayList<Bullet1> getBullets() {
		return bullets;
	}

}
