package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth /2,screenHeight / 2);
		
		setTitle("Studentska Sluzba");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //postavlja prozor na centar ekrana
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.add(panel);
	}
}
