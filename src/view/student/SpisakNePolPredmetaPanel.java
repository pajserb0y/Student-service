package view.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.predmet.PredmetJTable;

public class SpisakNePolPredmetaPanel extends JPanel{
	
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
		JButton btnObrisi = new JButton("Obriši");
		btnObrisi.setPreferredSize(dim);
		JButton btnPolaganje = new JButton("Polaganje");
		btnPolaganje.setPreferredSize(dim);					

		panelBtn.add(btnDodaj);
		panelBtn.add(btnObrisi);
		panelBtn.add(btnPolaganje);
		
		SpisakNePolPredmetaJTable tabelaPredmeta = new SpisakNePolPredmetaJTable();
		JScrollPane sp =  new JScrollPane(tabelaPredmeta);	
		panelNePolPredmeti.add(sp);
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panelBtn);
		boxCentar.add(panelNePolPredmeti);
		add(boxCentar, BorderLayout.NORTH);
		}
}
