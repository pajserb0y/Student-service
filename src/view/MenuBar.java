package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		// TODO Auto-generated constructor stub
		JMenu file = new JMenu("File");	
		file.setMnemonic('F');
		JMenuItem miNew = new JMenuItem("New");
		ImageIcon imageIcon = new ImageIcon("images/Screenshot 2020-11-25 194909(1).png");
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(18, 18,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		miNew.setIcon(imageIcon);
		
		
		JMenuItem miClose = new JMenuItem("Close");
		ImageIcon imageIcon1 = new ImageIcon("images/close.png");
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

		Image image1 = imageIcon1.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon1 = new ImageIcon(newimg1);
		miClose.setIcon(imageIcon1);
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);

		JMenu edit = new JMenu("Edit");	
		edit.setMnemonic('E');
		JMenuItem miEdit = new JMenuItem("Edit");
		miEdit.setIcon(new ImageIcon("images/Screenshot 2020-11-25 195241(1).png"));
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	
		JMenuItem miDelete = new JMenuItem("Delete");
		miDelete.setIcon(new ImageIcon("images/Screenshot 2020-11-25 195314(1).png"));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		JMenu help = new JMenu("Help"); 
		help.setMnemonic('H');
		JMenuItem miHelp = new JMenuItem("Help");
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miHelp.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogHelp dialogHe = new DialogHelp();
				dialogHe.setVisible(true);
			}
		});		
		
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
	}

}
