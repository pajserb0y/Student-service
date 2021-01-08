package view.profesor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import view.TabbedPane;

public class SpisakPredmetaPanel extends JPanel{

	public static JTable tabelaSpisakPredmeta = null;
	public SpisakPredmetaPanel() {
		
		// TODO Auto-generated constructor stub
		
		JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		panelBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(panelBtn, BorderLayout.NORTH);
		JButton btnDodajPredmet = new JButton("Dodaj predmet");
		panelBtn.add(btnDodajPredmet);
		JButton btnUkloniPredmet = new JButton("Ukloni predmet");
		panelBtn.add(btnUkloniPredmet);
		
		tabelaSpisakPredmeta = new SpisakPredmetaJTable();
		JScrollPane scrollPaneSP = new JScrollPane(tabelaSpisakPredmeta);
		add(scrollPaneSP);
		
		btnDodajPredmet.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddPredToProfDialog dialog = new AddPredToProfDialog(null, "Odaberi profesora", true);
				dialog.setVisible(true);
			}
		});

		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		
		boxCentar.add(panelBtn);
		boxCentar.add(scrollPaneSP);
		
		add(boxCentar, BorderLayout.NORTH);
	}

}
