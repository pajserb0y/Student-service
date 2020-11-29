package view;

import view.MenuBar;
import view.Toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	
	
	private static final long serialVersionUID = 1L;

	public MainWindow(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize((screenWidth /4)*3,(screenHeight / 4)*3);
		
		setTitle("Studentska služba");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //postavlja prozor na centar ekrana
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.add(panel);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		Toolbar tb = new Toolbar();
		add(tb,BorderLayout.NORTH);
	}
}
