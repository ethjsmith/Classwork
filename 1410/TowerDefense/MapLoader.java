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
import java.util.Scanner;

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
	//Tower t1;
	Enemy e1;

	public MapLoader(){

		int rows = 10;
		int cols = 10;

		MyCanvas myCanvas = null;
		myCanvas = new MyCanvas(rows, cols);
		try {
			//initalize all of the tower images and save them as files to be accessed
			t1 = ImageIO.read(new File("tower1.png"));
			t2 = ImageIO.read(new File("tower2.png"));
			t3 = ImageIO.read(new File("tower3.png"));
			t4 = ImageIO.read(new File("tower4.png"));
		}
		catch (IOException e) {
			System.out.println("Unable to generate tower due to IO exception");
		}
		//load tile images
		for (int x = 0; x< rows; x++)
			for (int y = 0; y < cols; y++)
				myCanvas.addPicture(x, y,"grass_02_RS.png");

		if (myCanvas != null){
			this.add(myCanvas);
		}
		this.setVisible(true);
	}


	//public void createTower(int x, int y, int style)
	public void upgradeTower(Tower t) {
		t.upgrade();
	}
	public Tower selectTower(int x,int y) {
		for (int z=0;z<towers.size();z++) {
			if (towers.get(z).isColliding(new MovingObject(x,y,8))) {
				return towers.get(z);
				//int pwr = towers.get(z).getPowerLevel();
				//towers.get(z).changeImage(t2);
				//towers.get(z).upgrade();
				//System.out.println("Upgrading tower");
			}
			//if (x > t.getX() && x < t.getX() + t.getWidth() && y > t.getY() && y < t.getY() + t.getHeight()) {
				// do some stuff to add some buttons and upgrade towers... idk

			//}
		}
		return null;
	}
	public void createEnemies(int z) {
		try {
			while ( z >= 0) {
				int enY = (int)((Math.random()*550)+10);
				enemies.add(new Enemy(0, enY, ImageIO.read(new File("orc1.png")), 40, 40, 1, 0, 3));
				z--;
			}
		}
		catch (IOException e) {
			System.out.println("IO ERROR");
		}
	}
	public void createTower(int x, int y)
	{
			Tower tow1 = new Tower(x,y,t1, 40,40);
			// don't put towers on top of each other!
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
				towers.add(new Tower(x,y,t1, 40,40));
			}
	}

	public void start()
	{

		//try {

	//	}
	//	catch (IOException e)
	//	{
			System.out.println("Unable to generate enemies due to IO exception");
	//	}
	}

	public void paint(Graphics g){
		super.paint(g);
		try{

		//bullet and enemy position
		int bx = 0;
		int by = 0;
		int ex = 999;
		int ey = 999;
				if (towers.size() > 0 ) {
					for (int z=0;z<towers.size();z++) {
						towers.get(z).drawImage(g);
						if (towers.get(z).checkForEnemy(enemies)) {
							towers.get(z).fire();
						}
					}
				}
				if (enemies.size() > 0) {
					for (int z=0;z<enemies.size();z++) {
						enemies.get(z).animate();
						enemies.get(z).drawImage(g);
						if (enemies.get(z).outside()) {
							enemies.remove(z);
						}
						if (enemies.get(z).getHitPoints() <= 0) {
							enemies.remove(z);
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

				if (e1 != null)
				{
					e1.drawImage(g);
					ex = e1.getXpos();
					ey = e1.getYpos();
					//System.out.println(ex);
					//System.out.println(ey);
				}

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
