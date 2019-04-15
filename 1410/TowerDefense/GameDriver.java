/*
@ Author : Ethan Smith
@ Date : 4/14/29
@ Assignment : Tower defense
@ File: Game Driver
*/


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon; //added
import java.awt.Image; //added

public class GameDriver extends JFrame{
	public int mx,my;
	public int money,lives;
	public GameDriver() {
		
		super("Tower Defense"); //added
		lives = 10;
		money = 20;
		getContentPane().setLayout(null);
		
		JPanel Controls = new JPanel();
		Controls.setBounds(0, 0, 120, 278);
		getContentPane().add(Controls);
		Controls.setLayout(null);
		//Controls.setSize(200,600);
		
		JLabel lblMoney = new JLabel("Money:" + money);
		lblMoney.setBounds(6, 5, 45, 16);
		Controls.add(lblMoney);
		
		JLabel lblLives = new JLabel("Lives: " + lives);
		lblLives.setBounds(6, 22, 40, 16);
		Controls.add(lblLives);
		
		JPanel Map = new MapLoader();
		Map.setBounds(123, 0, 600, 600);
		getContentPane().add(Map);
		Map.setLayout(new GridLayout(1, 0, 0, 0));
		Map.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//click on the map to save X and Y coords for making a tower
			//Point p = MouseInfo.getPointerInfo().getLocation();
			//mx = p.x;
			//my = p.y;
			//lazy midpoint workaround for now
			mx = e.getX()-20;
			my = e.getY()-20;
			}
		});
		//added
		ImageIcon GIcon = new ImageIcon("Tower1.png");
			Image image = GIcon.getImage();
			Image newImage = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
			GIcon = new ImageIcon(newImage);
		
		//JButton btnStart = new JButton("Tower 0");
		JButton btnStart = new JButton(GIcon);
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			((MapLoader)Map).createTower(mx,my);
			}
		});
		//btnStart.setBounds(6, 45, 117, 29);
		btnStart.setBounds(6, 45, 117, 60);
		Controls.add(btnStart);
		
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		//btnNewButton.setBounds(6, 74, 117, 29);
		btnNewButton.setBounds(6, 105, 117, 29);
		Controls.add(btnNewButton);
	}

	public static void main(String[] args) {
	
		//1. Answer the questions found in Questions.txt
		
		GameDriver m = new GameDriver();
		m.setSize(760, 650);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		

	}
}
