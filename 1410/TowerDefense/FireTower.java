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

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;

import java.awt.Color;

public class FireTower extends Tower{

	public FireTower(int posx, int posy, BufferedImage bi, int imageW, int imageH) {
		super(posx, posy, bi, imageW, imageH);
		range = hitboxRadius*2;
		speed = 1;
		power = 1;
		try {
			//initalize all of the tower images and save them as files to be accessed
			t[0] = ImageIO.read(new File("fire1.png"));
			t[1] = ImageIO.read(new File("fire2.png"));
			changeImage(t[0]);
		}
		catch (IOException e) {
			System.out.println("Unable to generate tower due to IO exception");
		}
	}
	public void upgrade () {
		if (level < 2) {
			level++;
			//power++;
			speed++;
			range +=hitboxRadius;
			this.changeImage(t[level-1]);
		}else {
			System.out.println("MAX LEVEL ALREADY");
		}
	}
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,posx, posy,imageW,imageH,null);
		//draws all the bullets associated with a tower
		for ( int z=bullets.size()-1;z>0;z--) {
			if (bullets.get(z).isOutside()) {
					bullets.remove(z);
				}
		}
		for ( int z=0;z<bullets.size();z++) {
			double r = Math.random();
			Color c;
			if (r > .8) {
				c = Color.WHITE;
			}
			else if (r > .3) {
				c = Color.ORANGE;
			}
			else if (r > .1) {
				c = Color.YELLOW;
			}
			else {
				c = Color.RED;
			}

			bullets.get(z).drawImage(g,c);
		}
	}
	public void fire() {
		//bullets.add(new bullet1(midX,midY,10,10));
		// i hate trig, almost as much as I hate Calc lmao help
			//targets with a guess based on where the orc is moving
			// 20 can be changed if the tower is over or underfiring
			double predictedVy = target.getMidY() + (target.getVy()*3);
			double predictedVx = target.getMidX() + target.getVx()*3;
			if (target != null) {
				double angle = Math.atan2((double)(predictedVy-midY),(double)(predictedVx-midX));
				int zz = speed;
				while (zz > 0) {
					double vx = 1*(Math.cos(angle))+(Math.random()* .3);
					double vy = 1*(Math.sin(angle))+(Math.random()* .3);

					bullets.add(new Bullet1(midX,midY,vx,vy,this,42));
					zz--;
				}

		// is it fucking Trigonometry time ? I fucking hate everything
	}
}
}
