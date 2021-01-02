package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar{

	private static final long serialVersionUID = 1L;

	public MenuBar() {
		// TODO Auto-generated constructor stub
		JMenu file = new JMenu("File");	
		file.setMnemonic('F');
		JMenuItem miNew = new JMenuItem("New");
		miNew.setIcon(new ImageIcon("images/new.png"));
		miNew.setMnemonic('N');
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miNew.addActionListener(new ActionListenerAdd());
		
		JMenuItem miClose = new JMenuItem("Close");
		miClose.setIcon(new ImageIcon("images/close.png"));
		miClose.setMnemonic('C');
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);

		JMenu edit = new JMenu("Edit");	
		edit.setMnemonic('E');
		JMenuItem miEdit = new JMenuItem("Edit");
		miEdit.setIcon(new ImageIcon("images/edit.jpg"));
		miEdit.setMnemonic('E');
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miEdit.addActionListener(new ActionListenerEdit());
	
		JMenuItem miDelete = new JMenuItem("Delete");
		miDelete.setIcon(new ImageIcon("images/delete.png"));
		miDelete.setMnemonic('D');
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miDelete.addActionListener(new ActionListenerDelete());
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		JMenu help = new JMenu("Help"); 
		help.setMnemonic('H');
		JMenuItem miHelp = new JMenuItem("Help");
		miHelp.setIcon(new ImageIcon("images/help.png"));
		miHelp.setMnemonic('H');
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
		miAbout.setIcon(new ImageIcon("images/about.png"));
		miAbout.setMnemonic('A');
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miAbout.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogAbout dialogAb = new DialogAbout();
				dialogAb.setVisible(true);
			}
		});
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
	}

}
