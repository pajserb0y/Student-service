package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import model.AbstractTableModelStudent;
import view.student.StudentiJTable;




public class TabbedPane extends JTabbedPane{
	
	private static final long serialVersionUID = 1L;
	
	private static TabbedPane instance = null;

	public static TabbedPane getInstance() {
		if (instance == null) {
			instance = new TabbedPane();
		}
		return instance;
	}
	
	
	public static JTable tabelaStudenata;

	
	public TabbedPane() {
		//this.setBackground(new Color(169,169,69));

		tabelaStudenata=new StudentiJTable();
		
	
		JScrollPane scrollPaneS = new JScrollPane(tabelaStudenata);
		addTab("Student", scrollPaneS);

		
	}

}
