package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Toolbar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnNew = new JButton();
		btnNew.setToolTipText("Open");
		btnNew.setIcon(new ImageIcon("images/Screenshot 2020-11-25 194909.png"));
		add(btnNew);
	
		addSeparator();
	
		JButton btnUredi = new JButton();
		btnUredi.setToolTipText("Edit");
		btnUredi.setIcon(new ImageIcon("images/Screenshot 2020-11-25 195241.png"));
		add(btnUredi);
	
		addSeparator();
	
		JToggleButton tglObrisi = new JToggleButton();
		tglObrisi.setToolTipText("Delete");
		tglObrisi.setIcon(new ImageIcon("images/Screenshot 2020-11-25 195314.png"));
		add(tglObrisi);
		
		addSeparator();
		
		JTextField txtSearch = new JTextField();
		txtSearch.setSize(10, 10);
		add(txtSearch);
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images/Screenshot 2020-11-25 195357.png"));
		add(btnSearch, BorderLayout.EAST);
	}
}
