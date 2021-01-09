package view.profesor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.ProfesorController;
import model.AbstractTableModelDozvoljeniPredmeti;
import model.AbstractTableModelPredmet;
import model.AbstractTableModelProfesor;
import model.AbstractTableModelSpisakPredmetaZaProfesora;
import model.AbstractTableModelStudent;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import view.TabbedPane;
import view.predmet.PredmetJTable;



public class AddPredToProfDialog extends JDialog{
	
	private ArrayList<Predmet> spisakPredmetaProfesora = new ArrayList<Predmet>();
	
	public AddPredToProfDialog(Frame parent, String title, boolean modal){
		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/5, 2*screenHeight/5);
		setLocationRelativeTo(null);
		setTitle("Odaberi predmet");
		int rowView = TabbedPane.tabelaProfesora.getSelectedRow();
		int rowModel = TabbedPane.tabelaProfesora.convertRowIndexToModel(rowView);
		if(rowModel != -1) {
			
			if(BazaProfesora.getInstance().getRow(rowModel).getSpisakPredmeta() != null)
				spisakPredmetaProfesora = BazaProfesora.getInstance().getRow(rowModel).getSpisakPredmeta();	
			
			DozvoljeniPredmetiJTable TabelaDozvoljenihPredmeta = new DozvoljeniPredmetiJTable();
			JScrollPane scrollpane = new JScrollPane(TabelaDozvoljenihPredmeta);
			add(scrollpane);

			JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
			this.add(panelBtn, BorderLayout.SOUTH);
			JButton btnPotvrda = new JButton("Potvrdi");	
			
			btnPotvrda.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub			
					int rowView = TabelaDozvoljenihPredmeta.getSelectedRow();
					int rowModel = TabelaDozvoljenihPredmeta.convertRowIndexToModel(rowView);
					if(rowModel != -1)
					{	
						AbstractTableModelDozvoljeniPredmeti mdp = (AbstractTableModelDozvoljeniPredmeti) TabelaDozvoljenihPredmeta.getModel();
						String sifra = (String) mdp.getValueAt(rowModel,0);
						
						int rowProfView = TabbedPane.tabelaProfesora.getSelectedRow();
						int rowProfModel = TabbedPane.tabelaProfesora.convertRowIndexToModel(rowProfView); //profesor kom dodajemo predmete
						
						for(Predmet p : BazaPredmeta.getInstance().getPredmeti())
							if(sifra.equals(p.getSifraPred())) {
								spisakPredmetaProfesora.add(p);
								p.setProfesor(BazaProfesora.getInstance().getRow(rowProfModel)); //postavljanja profesora na taj predmet referencijalna zavisnost
							}
						
						BazaProfesora.getInstance().getRow(rowProfModel).setSpisakPredmeta(spisakPredmetaProfesora); //dodavanje profesoru predmeta
						
						AbstractTableModelSpisakPredmetaZaProfesora model =  (AbstractTableModelSpisakPredmetaZaProfesora) SpisakPredmetaPanel.tabelaSpisakPredmeta.getModel();
						model.fireTableDataChanged();
						
						int exit = JOptionPane.showConfirmDialog(null, "Predmet dodat." , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION) {
							setVisible(false);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Morate izabrati predmet pre izmene!");
					}
				}
			});		
			JButton btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					setVisible(false);
				}
			});
			panelBtn.add(btnPotvrda);
			panelBtn.add(btnOdustani);
			add(panelBtn, BorderLayout.SOUTH);
			}
	}
}
