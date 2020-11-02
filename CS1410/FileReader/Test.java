import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test{
	public Test(String[] args) {	
	try {
		File f = new File(args[0]);
		Scanner z = new Scanner(f);
		int numRows = 0;
		int numCols = 0;
		String s = "A";
		numCols = z.nextInt();
		numRows = z.nextInt();
		
		//main logic
		for(int x = 0;x<numCols;x++) {
			for (int y =0;y<numRows;y++) {
				s = z.next();
				if (s.contains("+")) {
					break;
				}
				System.out.print(s);
				//myCanvas.addPicture(x, y, s + ".png");
			}
			System.out.println("");
		}
		
		
		//myCanvas.addPicture(0, 0, s + ".png");
		}
		catch (FileNotFoundException e){
			// fuck
			System.out.println("ERR");
		}
	}
	public static void main(String[] args) {
		new Test(args);
	}
}