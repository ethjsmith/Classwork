//package general;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main extends JFrame{
	public Main() {
		getContentPane().setLayout(null);
		
		JPanel pGame = new JPanel();
		pGame.setBounds(111, 68, 701, 575);
		getContentPane().add(pGame);
		
		JPanel pGUI = new JPanel();
		pGUI.setBounds(0, 0, 111, 643);
		getContentPane().add(pGUI);
		pGUI.setLayout(null);
		
		JLabel lblLives = new JLabel("Lives:10");
		lblLives.setBounds(7, 5, 46, 14);
		pGUI.add(lblLives);
		
		JLabel lblMoney = new JLabel("Money:0");
		lblMoney.setBounds(7, 30, 46, 14);
		pGUI.add(lblMoney);
		
		JButton btnQuit = new JButton("Quit Game");
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(7, 609, 89, 23);
		pGUI.add(btnQuit);
		
		JButton btnTower1 = new JButton("Make tower(10G)");
		btnTower1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnTower1.setBounds(7, 580, 89, 23);
		pGUI.add(btnTower1);
		
		JPanel pSky = new JPanel();
		pSky.setBounds(111, 0, 701, 69);
		getContentPane().add(pSky);
	}
	
	
	public static void main(String args[]) {
		System.out.println("test boys");
		Main m = new Main();
		m.setSize(1000,1000);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		System.out.println(m.getWidth() + m.getHeight());
	}
}
