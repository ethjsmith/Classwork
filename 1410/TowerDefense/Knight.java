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

public class Knight extends Enemy {
	public Knight(int posx, int posy, BufferedImage bi, int imageW, int imageH, double vx, double vy, double hitPoints)
	{
		super(posx, posy, bi, imageW, imageH, vx, vy,hitPoints);
		this.hitPoints = hitPoints;
		// this stuff is for drawing the HP box
		t = new BufferedImage[3];
		this.maxHp = hitPoints;
		scale = imageW /maxHp;
		ani_counter = (int)(Math.random()*20)+1;
		try {
		t[0] = ImageIO.read(new File("knight1.png"));
		t[1] = ImageIO.read(new File("knight2.png"));
		t[2] = ImageIO.read(new File("knight3.png"));
		}
		catch (IOException e) {
			System.out.println("error my dude");
		}
	}
/*	public void drawImage(Graphics g) {
		super.drawImage(g);
		//g.drawImage(bi,posx+=vx, posy+=vy,imageW,imageH,null);
		//midX+=vx;
		//midY+=vy;
		
		//draw a healthbar
		g.setColor(Color.RED);
		g.fillRect(posx,posy-3,scale*maxHp,2);
		g.setColor(Color.GREEN);
		if (hitPoints >= 0) {
			g.fillRect(posx,posy-3,scale*hitPoints,2);
		}
		else {
			g.fillRect(posx,posy-5,0,5);
		}
		
		
	}*/
}