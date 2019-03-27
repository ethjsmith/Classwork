
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MapDriver2 extends JFrame {
	public MapDriver2() {
		
		//1. Add a button manually
		
		//2. Add another button
		
		//Oh no they are on top of each other!
		
		//We have to incorporate a layout manager to help with placement
		//Like BorderLayout, FlowLayout, BoxLayout
		
		//3. Add the buttons on the EAST and WEST of a BorderLayout
		
		//4. Switch to GUI and try the different layouts and positions. Review the other
		//options available
		
		//5. Create a panel and create a West, Panel, East layout
			
		//6. Add the buttons to the panel instead
			
		//7. Move the panel to the west
			
		//8. Change the previous demo to a panel instead of a JFrame and place it in the center
			
		//9. Add 'listeners' to each button that print out a message to the console
			
		//10. Make it so that when a user clicks a button it puts a red dot on the map. 
			
		//11. Make it so that pushing a button creates a bullet
			
	}
	
	

	public static void main(String[] args) {
		
		MapDriver2 m = new MapDriver2();
		m.setSize(600, 600);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		
		
	}

}
