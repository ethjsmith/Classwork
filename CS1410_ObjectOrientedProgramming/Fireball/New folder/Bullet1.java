//stationary object to add to our window
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Color;

public class Bullet1 
{
	private int vx;
	private int vy;
	private int startx;
	private int starty;

	public Bullet1(int startx, int starty, int vx, int vy)
	{
		this.startx = startx;
		this.starty = starty;
		this.vx=vx;
		this.vy=vy;
	}
	
			
	//renders our object to the screen
	public void drawImage(Graphics g)
	{
		//because we added the bullet functions what should go here?
		
		// yo this line was happening twice wtf
		//g.setColor(Color.BLACK);
		// I hate using other people's code
		
		//BufferedImage fireball = ImageIO.read(new File("FireBall.png"));
		
		startx+=vx;
		starty+=vy;
		//g.fillOval(startx, starty, 20,20);
		//StationaryObject o1 = new StationaryObject(startx,starty, fireball, 20, 20);
		//vx+=vx;
		//vy+=vy;
	}
	

	
}