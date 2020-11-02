/*
@ Author : Ethan Smith
@ Date : 4/25/29
@ Assignment : Tower defense
@ File: Corpse
*/

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Corpse extends MapObject {
	
	protected BufferedImage[] biz;
	protected int tmr = 4;
	protected int current=0;
	Corpse(int posx, int posy, BufferedImage bi, int imageW, int imageH,String type) {
		super(posx,posy,bi,imageW,imageH);
		try {
			// this is a bit weird, but the images get read into an array based on what type of enemy created the corpse
			if (type.equals("orc")) {
				biz = new BufferedImage[]{ImageIO.read(new File("assets/orcDie1.png")),ImageIO.read(new File("assets/orcDie2.png")),ImageIO.read(new File("assets/orcDie3.png")),ImageIO.read(new File("assets/orcDie4.png"))};
			}
			else if (type.equals("wolf")) {
				biz = new BufferedImage[]{ImageIO.read(new File("assets/wolfDie1.png")),ImageIO.read(new File("assets/wolfDie2.png")),ImageIO.read(new File("assets/wolfDie3.png"))};
			}
			else {
				biz = new BufferedImage[]{ImageIO.read(new File("assets/knightDie1.png")),ImageIO.read(new File("assets/knightDie2.png")),ImageIO.read(new File("assets/knightDie3.png")),ImageIO.read(new File("assets/knightDie4.png")),ImageIO.read(new File("assets/knightDie5.png"))};
			}
		changeImage(biz[0]);
		}
		catch (IOException e) {
			System.out.println("the death animation is messed up");
		}
	}
	// loops through the images once, making it look like the enemy is dieing
	public void drawImage(Graphics g) {
		g.drawImage(bi,posx, posy,imageW,imageH,null);
		tmr--;
		if (tmr < 0) {
			if (current < biz.length-1) {
				current++;
				changeImage(biz[current]);
				tmr = 4;
			}
		}
	}
	
	}