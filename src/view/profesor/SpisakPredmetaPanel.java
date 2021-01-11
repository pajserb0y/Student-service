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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.StudentController;
import model.AbstractTableModelDozvoljeniPredmeti;
import model.AbstractTableModelSpisakPredmetaZaProfesora;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Student;
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
		
		btnUkloniPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//DozvoljeniPredmetiJTable TabelaDozvoljenihPredmeta = new DozvoljeniPredmetiJTable();
				
				int rowView = tabelaSpisakPredmeta.getSelectedRow();
				int rowModel = tabelaSpisakPredmeta.convertRowIndexToModel(rowView);
				if(rowModel != -1){
					ArrayList<Predmet> spisakPredmetaProfesora = new ArrayList<Predmet>();
					int rowProfView = TabbedPane.tabelaProfesora.getSelectedRow();
					int rowProfModel = TabbedPane.tabelaProfesora.convertRowIndexToModel(rowProfView); //profesor kom uklanjamo predmet
					
					if(BazaProfesora.getInstance().getRow(rowProfModel).getSpisakPredmeta() != null)
						spisakPredmetaProfesora = BazaProfesora.getInstance().getRow(rowProfModel).getSpisakPredmeta();
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Ukloni predmet", JOptionPane.YES_NO_OPTION);
					if (izbor == JOptionPane.YES_OPTION) {
						
						AbstractTableModelSpisakPredmetaZaProfesora mdp = (AbstractTableModelSpisakPredmetaZaProfesora) tabelaSpisakPredmeta.getModel();
						String sifra = (String) mdp.getValueAt(rowModel, 0);

						for(Predmet p : BazaPredmeta.getInstance().getPredmeti())
							if(p.getProfesor() != null)
								if(sifra.equals(p.getSifraPred())) {
									spisakPredmetaProfesora.remove(p);
									p.setProfesor(null);
								}
								
						BazaProfesora.getInstance().getRow(rowProfModel).setSpisakPredmeta(spisakPredmetaProfesora); //dodavanje profesoru predmeta
						
						AbstractTableModelSpisakPredmetaZaProfesora model =  (AbstractTableModelSpisakPredmetaZaProfesora) SpisakPredmetaPanel.tabelaSpisakPredmeta.getModel();
						model.fireTableDataChanged();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Morate izabrati predmet pre izmene!");
				}
			}
		});
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		
		boxCentar.add(panelBtn);
		boxCentar.add(scrollPaneSP);
		
		add(boxCentar, BorderLayout.NORTH);
	}

}
