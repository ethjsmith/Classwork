/*
@ Author : Ethan Smith
@ Date : 4/25/29
@ Assignment : Tower defense
@ File: WizardTower
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

public class WizardTower extends Tower{

	public WizardTower(int posx, int posy, BufferedImage bi, int imageW, int imageH) {
		super(posx, posy, bi, imageW, imageH);
		range = (int)(hitboxRadius*7);
		speed = 125;
		power = 100;
		velocity=8;
		bsize =3;
		try {
			//initalize all of the tower images and save them as files to be accessed
			t[0] = ImageIO.read(new File("assets/wizard1.png"));
			t[1] = ImageIO.read(new File("assets/wizard2.png"));
			t[2] = ImageIO.read(new File("assets/wizard3.png"));
			changeImage(t[0]);
		}
		catch (IOException e) {
			System.out.println("Unable to generate tower due to IO exception");
		}
	}
	//mostly the same as the upgrade function in tower
	public boolean upgrade() {
		if (level < 3) {
			level++;
			power+= 50;
			speed-= 20;
			velocity+=4;
			range +=(int)(hitboxRadius*1.2);
			this.changeImage(t[level-1]);
			return true;
		}else {
			System.out.println("MAX LEVEL ALREADY");
			return false;
		}
	}
	public void drawImage(Graphics g)
	{
		//draws some things differently
		g.drawImage(bi,posx, posy,imageW,imageH,null);
		//draws all the bullets associated with a tower
		for ( int z=0;z<bullets.size();z++) {
			if (bullets.get(z).isOutside()) {
					bullets.get(z);
					bullets.remove(z);
				}
		}
		//g.setColor(Color.CYAN);
		for ( int z=0;z<bullets.size();z++) {
			//g.setColor(Color.CYAN);
			bullets.get(z).drawImage(g,Color.CYAN);
			// this line is a line drawn between the projectile, and the tower, making it look like the wizard
			//tower is firing a laser
			
			
			// this is all basically a super overcomplicated way to make it look like wizards are shooting lightning
			double angle = Math.atan2((double)((int)bullets.get(z).getYpos()-midY),(double)((int)bullets.get(z).getXpos()-midX));
			//System.out.println(angle);
			double dis=Math.sqrt(Math.pow(((int)bullets.get(z).getXpos()-midX),2) + Math.pow(((int)bullets.get(z).getYpos()-midY),2));
			double vxx = dis/2*(Math.cos(angle+(Math.random()*.6)-.3));
			double vyy =dis/2*(Math.sin(angle+(Math.random()*.6)-.3));
			double vxx2 = dis*(Math.cos(angle+(Math.random()*.02)-.01));
			double vyy2 = dis*(Math.sin(angle+(Math.random()*.02)-.01));
			
			int mpx1 = midX + (int)vxx;
		    int mpy1 = midY + (int)vyy;
			int mpx2 = midX + (int)vxx2;
		    int mpy2 = midY + (int)vyy2;
			//(int)(Math.random()*5)-5;
			g.drawLine(midX,midY,mpx1,mpy1);
			g.drawLine(mpx1,mpy1,mpx2,mpy2);
			g.drawLine(mpx2,mpy2,(int)bullets.get(z).getXpos(),(int)bullets.get(z).getYpos());
			

		}
	}
}
