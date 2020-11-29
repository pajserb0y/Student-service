package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		// TODO Auto-generated constructor stub
		JMenu file = new JMenu("File");
		JMenuItem miNew = new JMenuItem("New     Ctrl+N");
		ImageIcon imageIcon = new ImageIcon("images/Screenshot 2020-11-25 194909(1).png");

		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(18, 18,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		miNew.setIcon(imageIcon);
		
		
		JMenuItem miClose = new JMenuItem("Close     Ctrl+C");
		ImageIcon imageIcon1 = new ImageIcon("images/close.png");

		Image image1 = imageIcon1.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon1 = new ImageIcon(newimg1);
		miClose.setIcon(imageIcon1);
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);

		JMenu edit = new JMenu("Edit");
		JMenuItem miEdit = new JMenuItem("Edit");
		miEdit.setIcon(new ImageIcon("images/Screenshot 2020-11-25 195241(1).png"));
		JMenuItem miDelete = new JMenuItem("Delete");
		miDelete.setIcon(new ImageIcon("images/Screenshot 2020-11-25 195314(1).png"));
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		JMenu help = new JMenu("Help"); 
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
	}

}
