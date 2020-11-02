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

public class Wolf extends Enemy {
	public Wolf(int posx, int posy, BufferedImage bi, int imageW, int imageH, double vx, double vy, double hitPoints)
	{
		
		// fun fact, I actually drew all the sprites for the game ( and all their animations) myself... how's that for dedication?
		
		// that's why if you look closely, they actually look aweful :) 
		
		
		super(posx, posy, bi, imageW, imageH, vx, vy,hitPoints);
		this.hitPoints = hitPoints;
		// this stuff is for drawing the HP box
		t = new BufferedImage[4];
		this.maxHp = hitPoints;
		scale = imageW /maxHp;
		type = "wolf";
		value=2;
		ani_counter = (int)(Math.random()*20)+1;
		try {
			//wolf's animation frames.
		t[0] = ImageIO.read(new File("assets/wolf1.png"));
		t[1] = ImageIO.read(new File("assets/wolf2.png"));
		t[2] = ImageIO.read(new File("assets/wolf3.png"));
		t[3] = ImageIO.read(new File("assets/wolf4.png"));
		}
		catch (IOException e) {
			System.out.println("error my dude");
		}
	}

		public void animate() {
		if (ani_counter > 10) {
			animation++;
			if (animation >= t.length) {
				animation =0;
			}
			changeImage(t[animation]);
			ani_counter=0;
		}else {
			ani_counter++;
		}
	}
}
