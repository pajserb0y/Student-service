package view.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.AbstractTableModelSpisakNePolPredmetaZaStudenta;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import view.TabbedPane;


import view.predmet.PredmetJTable;

public class SpisakNePolPredmetaPanel extends JPanel{
	
	public static JTable tabelaNepolozenihPredmeta = null;
	
	public SpisakNePolPredmetaPanel()
	{
		JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		JPanel panelNePolPredmeti = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		Dimension dim = new Dimension(screenSize.width/21, screenSize.height/40);
	
		panelBtn.setLayout(new FlowLayout(FlowLayout.LEADING));
		add(panelBtn, BorderLayout.NORTH);	
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setPreferredSize(dim);
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddPredToStudent dialog = new AddPredToStudent(null, "Odaberi predmete", true);
				dialog.setVisible(true);
			}
		});
		
		JButton btnObrisi = new JButton("Obriši");
		btnObrisi.setPreferredSize(dim);
//		btnObrisi.addActionListener(new ActionListener() {});
		
		JButton btnPolaganje = new JButton("Polaganje");
		btnPolaganje.setPreferredSize(dim);					
//		btnPolaganje.addActionListener(new ActionListener() {});
		panelBtn.add(btnDodaj);
		panelBtn.add(btnObrisi);
		panelBtn.add(btnPolaganje);
		
		tabelaNepolozenihPredmeta = new SpisakNePolPredmetaJTable();
		JScrollPane sp =  new JScrollPane(tabelaNepolozenihPredmeta);	
		panelNePolPredmeti.add(sp);
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panelBtn);
		boxCentar.add(panelNePolPredmeti);
		add(boxCentar, BorderLayout.NORTH);
		}
}
