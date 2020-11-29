package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
		btnNew.setIcon(new ImageIcon("images/Screenshot 2020-11-25 194909(1).png"));
		add(btnNew);
	
		addSeparator();
	
		JButton btnUredi = new JButton();
		btnUredi.setToolTipText("Edit");
		btnUredi.setIcon(new ImageIcon("images/Screenshot 2020-11-25 195241(1).png"));
		add(btnUredi);
	
		addSeparator();
	
		JButton btnObrisi = new JButton();
		btnObrisi.setToolTipText("Obriši");
		btnObrisi.setIcon(new ImageIcon("images/Screenshot 2020-11-25 195314(1).png"));
		add(btnObrisi);
		
		addSeparator();
		
		
		JPanel panCenter=new JPanel();
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.X_AXIS);
		panCenter.setLayout(boxCenter);

		Dimension dim=new Dimension(180,25);
		
		JPanel panSearch=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JTextField txtSearch=new JTextField();
        txtSearch.setPreferredSize(dim);
		
		panSearch.add(txtSearch);
		panCenter.add(panSearch);
        add(panCenter,BorderLayout.EAST);
        
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images/Screenshot 2020-11-25 195357(1).png"));
		add(btnSearch, BorderLayout.EAST);
	}
}
