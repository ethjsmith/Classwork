import javax.swing.*;
import java.awt.*;

public class Driver {
	//setting up main things
	
	private JFrame frame;
	private JPanel j;
	

    public static void main(String args[]) {
		
		// swing method which controls stuff IDK
		Driver d = new Driver();
		d.run();
		//SwingUtilities.invokeLater(new Runnable() {
	}
		public void run() {
				
				
				
			frame = new JFrame("Tower Defense");
			frame.setSize(600,600);
			//makes the program end when you close it
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//make it visible
			frame.setVisible(true);
			
			//setting up a jpannel to run the animations
			j = new JPanel();
			j.setBackground(Color.BLACK);
			frame.add(j);
				
				
				
				
			}
		//});
		
        // do some things :3
        Map m1 = new Map();
        //m1.printmap();
		// the main window ( input is title)
		
		

    //}
}
