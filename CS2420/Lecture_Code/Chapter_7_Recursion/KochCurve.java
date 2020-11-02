import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class KochCurve extends JPanel {

	private final int recursionDepthDontUseInYourCode;
	
	public KochCurve(int recursionDepth) {
		this.recursionDepthDontUseInYourCode = recursionDepth;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//10 percent to the right, and 10 percent to the left
		int x1 = (int)(this.getWidth()*.1); 
		int x2 = (int)(this.getWidth()*.9);
		
		int y1 = (int)(this.getHeight()/2);
		int y2 = y1;
		
		drawKochCurve(x1, y1, x2, y2, recursionDepthDontUseInYourCode, (Graphics2D) g);
	}
	
	
	//TODO:  Finish this method
	private void drawKochCurve(int x1, int y1, int x2, int y2, int recursionDepth, Graphics2D g) {
		//This is how you draw a line - Somehow we have to work recursion into it
		g.drawLine(x1, y1, x2, y2);
	}
	
	
	public static void main(String[] args) {
		
		//TODO: You can change the recursion here: 
		int recursiveDepth = 0;
		KochCurve k = new KochCurve(0);
		
		
		//Don't change these things, as it just sets up the GUI
		JFrame f = new JFrame();
		f.add(k);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		f.setVisible(true);
		
		
		
		
	}

}
