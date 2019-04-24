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
		speed = 120;
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
	public void upgrade() {
		if (level < 3) {
			level++;
			power+= 50;
			speed-= 25;
			range +=(int)(hitboxRadius*1.2);
			this.changeImage(t[level-1]);
		}else {
			System.out.println("MAX LEVEL ALREADY");
		}
	}
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
		//g.setColor(Color.CYAN);
		for ( int z=0;z<bullets.size();z++) {
			//g.setColor(Color.CYAN);
			bullets.get(z).drawImage(g,Color.CYAN);
			g.drawLine(midX,midY,(int)bullets.get(z).getXpos(),(int)bullets.get(z).getYpos());

		}
	}
}
