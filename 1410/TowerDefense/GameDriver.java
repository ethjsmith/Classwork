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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.ImageIcon; //added
import java.awt.Image; //added

public class GameDriver extends JFrame{
	public int mx,my,midx,midy;
	public int money,lives,difficulty;
	public Tower t1;
	public GameDriver() {

	
		// there is literally nothing interesting in this file, just skip it, it's just a bunch of buttons being declared
		// and button click listeners that call functions in MapLoader() 
		
		
		super("Tower Defense"); //added
		lives = 10;
		money = 20;
		difficulty = 3;
		getContentPane().setLayout(null);

		JPanel Controls = new JPanel();
		Controls.setBounds(0, 0, 120, 500);
		getContentPane().add(Controls);
		Controls.setLayout(null);
		//Controls.setSize(200,600);
		
		// did this to make multiline jlabel text :) 
		JLabel insructions = new JLabel ("<html> Click anywhere<br> then click a button <br> to make a tower <br><br>click on tower <br> to delete or upgrade <br> them <br><br>Try to get High Score!</html>");
		insructions.setBounds(6,300,120,200);
		Controls.add(insructions);
		JLabel lblMoney = new JLabel("Money: " + money);
		lblMoney.setBounds(6, 5, 100, 16);
		Controls.add(lblMoney);

		JLabel lblLives = new JLabel("Lives: " + lives);
		lblLives.setBounds(6, 22, 100, 16);
		Controls.add(lblLives);
		JLayeredPane layers = new JLayeredPane();

		layers.setBounds(123,0,600,600);
		
		
		JLabel lblScore = new JLabel("Score: " + 0);
		lblScore.setBounds(6,250,100,16);
		Controls.add(lblScore);
		getContentPane().add(layers);

		JLabel lblInfo = new JLabel("x");
		lblInfo.setBounds(6,266,120,20);
		Controls.add(lblInfo);
		

		JPanel Map = new MapLoader(lblLives,lblMoney,lblScore,lblInfo);
		Map.setLayout(null);

		// the bounds appear to be relative
		Map.setBounds(0, 0, 600, 600);
		// the midpoints of the map ( used for making the buttons popups appear in the correct positions )
		midx = Map.getWidth()/2;
		midy = Map.getHeight()/2;


		layers.add(Map,JLayeredPane.DEFAULT_LAYER);


		Map.setLayout(new GridLayout(1, 1,0,0));
		//Map.setLayout(flow)(

		JButton btnUpgrade = new JButton("Upgrade tower");
		btnUpgrade.setLayout(null);
		btnUpgrade.setVisible(false);
		JButton btnDelete = new JButton("Delete tower");
		btnUpgrade.setLayout(null);
		btnUpgrade.setVisible(false);
		layers.add(btnDelete,JLayeredPane.POPUP_LAYER);
		layers.add(btnUpgrade,JLayeredPane.POPUP_LAYER);

		Map.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnUpgrade.setVisible(false);
				btnDelete.setVisible(false);
			mx = e.getX()-20;
			my = e.getY()-20;

			if (((MapLoader)Map).isTower(mx,my)) {
				t1 = ((MapLoader)Map).selectTower(mx,my);
				btnUpgrade.setBounds(e.getX(),e.getY(),125,20);
				btnUpgrade.setVisible(true);
				btnDelete.setBounds(e.getX(),e.getY()+20,125,20);
				btnDelete.setVisible(true);
			}
			System.out.println(mx +"-" + my);
			//Map.revalidate();
			}
		});

		// make the buttons appear on the screen instead of clipped off

		// determines button position based on these constraintss

		ImageIcon GIcon = new ImageIcon("assets/tower1.png");
		Image image = GIcon.getImage();
		Image newImage = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
		GIcon = new ImageIcon(newImage);

		ImageIcon GIcon2 = new ImageIcon("assets/fire1.png");
		Image image2 = GIcon2.getImage();
		Image newImage2 = image2.getScaledInstance(40,40, java.awt.Image.SCALE_SMOOTH);
		GIcon2 = new ImageIcon(newImage2);

		ImageIcon GIcon3 = new ImageIcon("assets/wizard1.png");
		Image image3 = GIcon3.getImage();
		Image newImage3 = image3.getScaledInstance(40,40, java.awt.Image.SCALE_SMOOTH);
		GIcon3 = new ImageIcon(newImage3);

		//JButton btnStart = new JButton("Tower 0");
		JButton btnStart = new JButton(GIcon);
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			((MapLoader)Map).createTower(mx,my,1);
			}
		});

		JButton tower2 = new JButton(GIcon2);
		tower2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			((MapLoader)Map).createTower(mx,my,2);
			}
		});
		Controls.add(tower2);
		tower2.setBounds(6,130,117,60);
		tower2.setVisible(true);

		JButton tower3 = new JButton(GIcon3);
		tower3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			((MapLoader)Map).createTower(mx,my,3);
			}
		});
		Controls.add(tower3);
		tower3.setBounds(6,190,117,60);
		tower3.setVisible(true);

		//upgrade a selected tower
		btnUpgrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			((MapLoader)Map).upgradeTower(t1);
			btnUpgrade.setVisible(false);
			btnDelete.setVisible(false);
			t1 = null;
			}
		});
		//delete a selected tower
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			((MapLoader)Map).removeTower(mx,my);
			btnUpgrade.setVisible(false);
			btnDelete.setVisible(false);
			t1 = null;
			}
		});
		btnStart.setBounds(6, 75, 117, 60);
		Controls.add(btnStart);


		JButton btnNewButton = new JButton("START");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//((MapLoader)Map).createEnemies(difficulty);
				((MapLoader)Map).start();
				difficulty++;
			}
		});
		//btnNewButton.setBounds(6, 74, 117, 29);
		btnNewButton.setBounds(6, 45, 117, 29);
		Controls.add(btnNewButton);
	}

	public static void main(String[] args) {


		GameDriver m = new GameDriver();
		m.setSize(760, 650);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);


	}
}
