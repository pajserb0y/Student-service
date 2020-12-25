package view;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class TabbedPane extends JTabbedPane{

	public TabbedPane() {
		// TODO Auto-generated constructor stub
		JLabel TableTab = new JLabel();
		
		JPanel panel1= new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3= new JPanel();
		
		addTab("Studenti", panel1);
		
		addTab("Profesori", panel2);
		
		addTab("Predmeti", panel3);
	}

}
