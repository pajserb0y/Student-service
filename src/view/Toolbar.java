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
		this.setFloatable(false);
		
		JButton btnNew = new JButton();
		btnNew.setToolTipText("New");
		btnNew.setIcon(new ImageIcon("images/new.png"));
		btnNew.addActionListener(new ActionListenerAdd());
		btnNew.setActionCommand("ADD");
		this.add(btnNew);
		
		this.addSeparator();
	
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("images/edit.jpg"));
		this.add(btnEdit);
	
		this.addSeparator();
	
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("images/delete.png"));
		this.add(btnDelete);
		
		this.addSeparator();
		
		
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
        
		this.addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images/search.png"));
		this.add(btnSearch, BorderLayout.EAST);
	}
}
