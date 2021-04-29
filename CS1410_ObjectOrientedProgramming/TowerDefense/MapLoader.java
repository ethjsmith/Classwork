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
// pretty sure some of these imports are duplicates... whoops

import java.util.*;
@SuppressWarnings({ "serial", "unused" })
public class MapLoader extends JPanel {

	//Instance variables
	// arraylists for holding different types of objects
	//bullet lists are within the individual towers
	public ArrayList<Tower> towers = new ArrayList<Tower>(0);
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>(0);
	public ArrayList<Corpse> dead = new ArrayList<Corpse>(0);
	public BufferedImage t1,t2,t3,t4;
	public int timer;
	public boolean running;
	public BufferedImage[] images;
	public int score =0;
	//Tower t1;
	Enemy e1;
	int money,lives;
	public String info;
	public JLabel lblLives,lblMoney,lblScore,lblInfo;
	public MapLoader(JLabel l, JLabel m,JLabel s,JLabel i){
		// all the labels are passed in here, so that they can be updated anytime
		lblInfo = i;
		lblLives = l;
		lblMoney = m;
		lblScore = s;
		info ="";
		int rows = 10;
		int cols = 10;

		money = 800;
		lives = 20;

		MyCanvas myCanvas = null;
		myCanvas = new MyCanvas(rows, cols);
		try {
			//initalize all of the tower images and save them as files to be accessed
			// and by all, I mean like 4 
			t1 = ImageIO.read(new File("assets/tower1.png"));
			t2 = ImageIO.read(new File("assets/tower2.png"));
			t3 = ImageIO.read(new File("assets/tower3.png"));
			t4 = ImageIO.read(new File("assets/tower4.png"));
			// I could improve performance by initalizing all the images in a single array right here, and then passing them into all the objects, instead of having each object create it's images when
			// it's created, but that sounds like a huge pain in every single way.
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
	public void upgradeTower(Tower t) {
		int cost = t.getPowerLevel()*25;
		if (money > cost) {
			if (t.upgrade()) {
				money-=cost;
			}
			else {
				info = "Tower at max level already!";
			}
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
	//remove a tower from the array of towers, killing it 
	public void removeTower(int x,int y) {
		for (int z=0;z<towers.size();z++) {
			if (towers.get(z).isColliding(new MovingObject(x+5,y+15,6))) {
				//get a partial refund when you destroy a tower
				int refund = towers.get(z).getPowerLevel()*20 -15;
				towers.remove(z);
				money += refund;
			}
		}
	}
	//selects a tower, 
	public Tower selectTower(int x,int y) {
		for (int z=0;z<towers.size();z++) {
			if (towers.get(z).isColliding(new MovingObject(x+5,y+15,6))) {
				return towers.get(z);
			}
		}
		return null;
	}
	//creates random different enemies
	public void createEnemies(int z) {
		// Z is the difficulty and shows how often enemies appear, and affects some of their other stats
		// Z no longer does that
		z = (int)(z/2) + 1;
			double enemyseed = Math.random();
			int enY = (int)((Math.random()*550)+10);
			if (enemyseed > .5) {
				enemies.add(new Enemy(0, enY, t1, 40, 40, 1, 0, (int)(Math.random()*30)+50));
				timer = (int)45/z;
			} else if (enemyseed > .25){
				enemies.add(new Wolf(0, enY, t1, 40, 30, 2, 0, (int)(Math.random()*10)+30));
				timer = (int)20/z;
			}
			else {
				enemies.add(new Knight(0, enY, t1, 60, 60, 1, 0, (int)(Math.random()*200)+500));
				timer = (int)150/z;
			}
	}
	//create a tower based on which button was pressed
	public void createTower(int x, int y, int type) {
		Tower tow1=null;
		if (type == 1) {
			if (money > 10) {
				money-=10;
				tow1 = new Tower(x,y,t1, 40,40);
			}
			else {
				info = "Not enough money !";
				System.out.println("not enough money");
			}
		}
		else if (type == 2){
			if (money > 15) {
				money-=15;
				tow1 = new FireTower(x,y,t1, 40,40);
			}
			else {
				info = "Not enough money !";
				System.out.println("not enough money");
			}
		}
		else {
			if (money > 20) {
				money-=20;
				tow1 = new WizardTower(x,y,t1, 40,40);
			}
			else {
				info = "Not enough money !";
				System.out.println("not enough money");
			}
		}
		if (tow1 != null) {
			boolean place = true;
			if (towers.size() > 0) {
				for (int z=0;z<towers.size();z++) {
					if (tow1.isColliding(towers.get(z))) {
						info = "close to other tower!";
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
	//14 : Start the game already (starts enemies being created in the paint loop
	public void start()
	{
		if (running) {
			running = false;
		}else {
			running = true;
		}
		timer = 10;
		// this is a commented out try/catch block
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
			//checks if you're dead
		if (lives < 0) {
			info = "You died !";
			System.out.println("You died, noob");
			System.out.println("Your Score was : " + score);
			if (score > 1000) {
				System.out.println("That's pretty good");
			}
			if (score > 10000) {
				System.out.println("get a life loser");
			}
			System.exit(0);
		}
		//updates labels based on your current values
		lblMoney.setText("Money: " + money);
		lblLives.setText("Lives: " + lives);
		lblScore.setText("Score: " + score);
		lblInfo.setText(info);

		timer--;
		//creates enemies occasionally
		if (running) {
			if (timer < 0) {
				// diff makes more enemies spawn as the game continues
				int diff = (int) score/25;
				if (diff > 50) {
					diff = 50;
				}
				createEnemies(diff);
				//timer = 200;
			}
		}		//draws the corpses
				if (dead.size() > 0 ) {
					for(int z=0;z<dead.size();z++) {
						dead.get(z).drawImage(g);
						
					}
					//removes corpses if there are more than 25
					if (dead.size() > 25) {
						dead.remove(0);
					}
				}
				// draws enemies and checks if they're dead
				if (enemies.size() > 0) {
					for (int z=0;z<enemies.size();z++) {
						enemies.get(z).animate();
						enemies.get(z).drawImage(g);
						if (enemies.get(z).isOutside()) {
							lives--;
							enemies.remove(z);
						}
						// if enemies died to tower, make a corpse and give you a score bonus and money
						else if (enemies.get(z).getHitPoints() <= 0) {
							Enemy tmp = enemies.get(z);
							Corpse c = new Corpse(tmp.getX(),tmp.getY(),t1,tmp.getHeight(),tmp.getWidth(),tmp.getType());
							score += enemies.get(z).getScore();
							money +=enemies.get(z).getScore();
							enemies.remove(z);
							dead.add(c);
						}
					}
				}
				//draw the towers, and have the towers fire
				if (towers.size() > 0 ) {
					for (int z=0;z<towers.size();z++) {
						towers.get(z).drawImage(g);
						//tower.get(z).hitEnemy(enemies);
						if (towers.get(z).checkForEnemy(enemies)) {
							towers.get(z).fire();
						}
					}
				}
				// some commented code that afaik isn't mine lol wtf 
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
				//add a delay so the game isn't running hyperspeed mode ( it's already pretty fast) 
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
// None of this is mine, Ignore it 
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
