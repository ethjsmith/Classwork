/*
@ Author : Ethan Smith
@ Date : 4/14/29
@ Assignment : Tower defense
@ File: Tower
*/


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;

public class Tower extends MapObject{
	
	private Bullet1 b1;
	private int range;
	private ArrayList<Bullet1> bullets = new ArrayList<Bullet1>(0);
	private Enemy target;
	private int canfire=0;
	public Tower(int posx, int posy, BufferedImage bi, int imageW, int imageH)
	{
		super(posx, posy, bi, imageW, imageH);
		//b1 = new Bullet1(posx, posy, 10,10);
		range = (int)(hitboxRadius*5);
	}

	//Added this to override parent
	//Wanted it to draw a bullet when the tower was drawn
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,posx, posy,imageW,imageH,null);
		//draws all the bullets associated with a tower
		for ( int z=0;z<bullets.size();z++) {
			if (bullets.get(z).isOutside()) {
					bullets.remove(z);
				}
		}
		for ( int z=0;z<bullets.size();z++) {
			bullets.get(z).drawImage(g);
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
					enemies.get(z).takeDamage(1);
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
		return false;
	}
	//fires at an enemy?  
	public void fire() {
		//bullets.add(new bullet1(midX,midY,10,10));
		// i hate trig, almost as much as I hate Calc lmao fuck me 
		if (canfire >10) {
			double shootme = target.getMidY() + (target.getVy()*20);
			if (target != null) {
				double angle = Math.atan2((double)(shootme-midY),(double)(target.getMidX()-midX));
				double vx = 25*(Math.cos(angle));
				double vy = 25*(Math.sin(angle));
				bullets.add(new Bullet1(midX,midY,vx,vy));
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

