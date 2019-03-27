import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Driver {
    public static void main(String args[]) {
		
		// swing method which controls stuff IDK
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Tower Defense");
		
		frame.setSize(500,400);
		//makes the program end when you close it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//make it visible
		frame.setVisible(true);
			}
		});
		
        // do some things :3
        Map m1 = new Map();
        //m1.printmap();
		// the main window ( input is title)
		
		

    }
}
