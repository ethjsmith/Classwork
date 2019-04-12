/*
@
@ Author/edited by : Ethan Smith
@ Date : 4/3/19
@ Assignment : File IO
@ Favorite Color : Red
@ I don't know why I add that, but it makes me chuckle
@
*/

// ***********************************************************************************************************

// IMPORTANT RUN THIS PROGRAM BY PASSING THE FILENAME OF THE MAZE YOU WANT TO CREATE AS A COMMANDLINE ARGUMENT

// LIKE THIS `java FileReader Maze[number].txt`

// ***********************************************************************************************************

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings({ "serial", "unused" })
public class FileReader extends JFrame {

	public FileReader(String[] args){
		super("Maze");
		try {
		// make scanner based on a file ( preparring for optimization lab) 
		Scanner z = new Scanner(new File(args[0]));
		// I don't like colums and rows... but set them here based on the first 2 characters in the file
		
		int numCols = z.nextInt();
		int numRows = z.nextInt();
		MyCanvas myCanvas = new MyCanvas(numCols, numRows);
		// Don't tell me what to do -_- 
		//Do Not Make Any Changes Above This Line

		
		//loops through all the values in the file ( based on the dimensions from the first 2 characters)
		// and creates an image for each of them
		for(int x = 0;x<numCols;x++) {
			for (int y =0;y<numRows;y++) {
				myCanvas.addPicture(x, y, z.next() + ".png");
			}

		}
		
		
		

		// I didn't make any of this code, so expect no snarky comments here
		
		//You can change the size of the Frame if you want
		this.setSize(600, 600);

		//Do Not Make Any Changes Below This Line
		if (myCanvas != null){
			this.add(myCanvas);
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		}
	catch (FileNotFoundException e){
			// Don't do this
			System.out.println("ERR");
		}
	catch (ArrayIndexOutOfBoundsException e) {
		// if you don't read the instructions, or if you try to run the program before looking at the code
		// then you get to look at this nice little message 
		System.out.println("==============================================");
		System.out.println("Pass the maze you want rendered as a commandline argument");
		System.out.println("Like this `java FileReader Maze1.txt`");
		System.out.println("==============================================");
	}
	}

	public static void main(String[] args) {
		new FileReader(args);
	}

 
}

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
				g.drawImage(imgs[i][j], j*tileSize, i*tileSize, null);
			}
		}
	}
}