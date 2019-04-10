import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Map extends JFrame {
    //array that represents the field :
    // have to decide resolution and stuff

    int gamearray [][];
    int mapx;
    int mapy;

    public Map() {
        super();
        mapx =10;
        mapy =10;
	}
    // prints out a visual representation of the map//
    // // // // // // // // // // // // // // // // //
    public void printmap() {
        for (int x=0;x<mapx;x++) {
            for (int y=0;y<mapy;y++) {
                System.out.print(gamearray[x][y] + " ");
            }
            System.out.println("");
        }
    }
	public int getPos(int x,int y) {
		return gamearray[x][y];
	}
}
