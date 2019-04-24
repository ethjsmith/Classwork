/*
@ Author : Ethan Smith
@ Date : 4/14/29
@ Assignment : Tower defense
@ File: Map Loader
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.*;
@SuppressWarnings({ "serial", "unused" })
public class MapLoader extends JPanel {

	//Instance variables
	public ArrayList<Tower> towers = new ArrayList<Tower>(0);
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>(0);
	public BufferedImage t1,t2,t3,t4;
	public int timer;
	public boolean running;
	public BufferedImage[] images;
	//Tower t1;
	Enemy e1;
	int money,lives;
	public JLabel lblLives,lblMoney;
	public MapLoader(JLabel l, JLabel m){
		lblLives = l;
		lblMoney = m;
		int rows = 10;
		int cols = 10;

		money = 1000;
		lives = 20;

		MyCanvas myCanvas = null;
		myCanvas = new MyCanvas(rows, cols);
		try {
			//initalize all of the tower images and save them as files to be accessed
			t1 = ImageIO.read(new File("assets/tower1.png"));
			t2 = ImageIO.read(new File("assets/tower2.png"));
			t3 = ImageIO.read(new File("assets/tower3.png"));
			t4 = ImageIO.read(new File("assets/tower4.png"));
		}
		catch (IOException e) {
			System.out.println("Unable to generate tower due to IO exception");
		}
		//load tile images
		for (int x = 0; x< rows; x++)
			for (int y = 0; y < cols; y++)
				myCanvas.addPicture(x, y,"assets/grass_02_RS.png");

		if (myCanvas != null){
			this.add(myCanvas);
		}
		this.setVisible(true);
		//JPopupMenu upgrade = new JPopupMenu("upgrade");
		//this.add(upgrade);
	}


	//public void createTower(int x, int y, int style)
//	public void initImages() {
//		images = new BufferedImage[21];
//		images[0] = ImageIO.read()
//	}
	public void upgradeTower(Tower t) {
		int cost = t.getPowerLevel()*25;
		if (money > cost) {
			t.upgrade();
			money-=cost;
		}
		//t.upgrade();
		else {
			System.out.println("Not enough money");
		}
	}
	public boolean isTower(int x,int y) {
		// is there a tower where you are clicking?
		for (int z=0;z<towers.size();z++) {
			// this is pretty crappy adding the extra to these parameters
			if (towers.get(z).isColliding(new MovingObject(x+5,y+15,6))) {
				return true;
			}
		}
		return false;
	}
	public void removeTower(int x,int y) {
		for (int z=0;z<towers.size();z++) {
			if (towers.get(z).isColliding(new MovingObject(x+5,y+15,6))) {
				//get a partial refund when you destroy a tower
				int refund = towers.get(z).getPowerLevel()*20 -15;
				towers.remove(z);
				money += refund;
			}
			//if (x > t.getX() && x < t.getX() + t.getWidth() && y > t.getY() && y < t.getY() + t.getHeight()) {
				// do some stuff to add some buttons and upgrade towers... idk

			//}
		}
	}
	public Tower selectTower(int x,int y) {
		for (int z=0;z<towers.size();z++) {
			if (towers.get(z).isColliding(new MovingObject(x+5,y+15,6))) {
				return towers.get(z);
			}
			//if (x > t.getX() && x < t.getX() + t.getWidth() && y > t.getY() && y < t.getY() + t.getHeight()) {
				// do some stuff to add some buttons and upgrade towers... idk

			//}
		}
		return null;
	}
	public void createEnemies(int z) {
			double enemyseed = Math.random();
			int enY = (int)((Math.random()*550)+10);
			if (enemyseed > .5) {
				enemies.add(new Enemy(0, enY, t1, 40, 40, 1, 0, 40));
				timer = 45;
			} else if (enemyseed > .25){
				enemies.add(new Wolf(0, enY, t1, 40, 30, 2, 0, 40));
				timer = 20;
			}
			else {
				enemies.add(new Knight(0, enY, t1, 60, 60, 1, 0, 500));
				timer = 150;
			}
			//while ( z >= 0) {
			//	int enY = (int)((Math.random()*550)+10);
		//		enemies.add(new Enemy(0, enY, t1, 40, 40, 1, 0, 40));
		//		enY = (int)((Math.random()*550)+10);
		//		enemies.add(new Wolf(0, enY, t1, 40, 30, 2, 0, 40));
		//		z--;
		//	}
		//	int enY = (int)((Math.random()*550)+10);
	//		enemies.add(new Knight(0, enY, t1, 60, 60, 1, 0, 500));
	}

	public void createTower(int x, int y, int type) {
		Tower tow1=null;
		if (type == 1) {
			if (money > 10) {
				money-=10;
				tow1 = new Tower(x,y,t1, 40,40);
			}
			else {
				System.out.println("not enough money");
			}
		}
		else if (type == 2){
			if (money > 15) {
				money-=15;
				tow1 = new FireTower(x,y,t1, 40,40);
			}
			else {
				System.out.println("not enough money");
			}
		}
		else {
			if (money > 20) {
				money-=20;
				tow1 = new WizardTower(x,y,t1, 40,40);
			}
			else {
				System.out.println("not enough money");
			}
		}
		if (tow1 != null) {
			boolean place = true;
			if (towers.size() > 0) {
				for (int z=0;z<towers.size();z++) {
					if (tow1.isColliding(towers.get(z))) {
						System.out.println("too close to another tower");
						place = false;
					}

				}
				if (place) {
					towers.add(tow1);
				}
				else {
					tow1 = null;
				}
			}
			else {
				towers.add(tow1);
			}
		}
	}
	public void start()
	{
		if (running) {
			running = false;
		}else {
			running = true;
		}
		timer = 150;
		//try {

	//	}
	//	catch (IOException e)
	//	{
	//		System.out.println("Unable to generate enemies due to IO exception");
	//	}
	}

	public void paint(Graphics g){
		super.paint(g);
		try{
		if (lives < 0) {
			System.out.println("You died, noob");
			System.exit(0);
		}
		//bullet and enemy position
		lblMoney.setText("Money: " + money);
		lblLives.setText("Lives: " + lives);
		//int bx = 0;
		//int by = 0;
		//int ex = 999;
		//int ey = 999;
		timer--;
		if (running) {
			if (timer < 0) {
				createEnemies(1);
				//timer = 200;
			}
		}
				if (enemies.size() > 0) {
					for (int z=0;z<enemies.size();z++) {
						enemies.get(z).animate();
						enemies.get(z).drawImage(g);
						if (enemies.get(z).isOutside()) {
							lives--;
							enemies.remove(z);
						}
						else if (enemies.get(z).getHitPoints() <= 0) {
							enemies.remove(z);
							money+=5;
						}
					}
				}
				if (towers.size() > 0 ) {
					for (int z=0;z<towers.size();z++) {
						towers.get(z).drawImage(g);
						//tower.get(z).hitEnemy(enemies);
						if (towers.get(z).checkForEnemy(enemies)) {
							towers.get(z).fire();
						}
					}
				}

				/*if(t1 != null)
				{
					t1.drawImage(g);

					if (t1.getBullet() != null)
					{
						bx = t1.getBullet().getXpos();
						by = t1.getBullet().getYpos();
						//System.out.println(bx);
						//System.out.println(by);
					}
				}*/

				//if (e1 != null)
				//{
				//	e1.drawImage(g);
				//	ex = e1.getXpos();
				//	ey = e1.getYpos();
					//System.out.println(ex);
					//System.out.println(ey);
				//}

				/*//check bullet and enemy position
				if (((ex >= (bx - 5)) && (ex <= (bx + 5))) && ((ey >= (by - 5)) && (ey <= (by + 5))) )
				{
					e1 = null;
					//t1.destroyBullet();
				}*/

				Thread.sleep(15);
				repaint();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}


//MyCanvas taken from file reader lab
//Notice that this too is a panel
@SuppressWarnings("serial")
class MyCanvas extends JPanel{
	private BufferedImage[][] imgs;
	private int rows;
	private int cols;
	private final int tileSize = 64;
	public MyCanvas(int rows, int cols){
		super();
		this.rows = rows;
		this.cols = cols;
		imgs = new BufferedImage[rows][cols];
	}
	public void addPicture(int x, int y, String filename){
		if (x < 0 || x >= rows){
			System.err.println("There is no row " + x);
		}
		else if (y < 0 || y >= cols){
			System.err.println("There is no col " + y);
		}
		else{
				try {
					imgs[x][y] = ImageIO.read(new File(filename));
				} catch (IOException e) {
					System.err.println("Unable to read the file: " + filename);
				}
		}
	}
	public void paint(Graphics g){
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				g.drawImage(imgs[i][j], j*tileSize, i*tileSize,null);
			}
		}
	}
}
