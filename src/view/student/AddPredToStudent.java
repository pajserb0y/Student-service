package view.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.AbstractTableModelDozvoljeniPredmetiStudent;
import model.AbstractTableModelSpisakNePolPredmetaZaStudenta;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Student;
import view.TabbedPane;

public class AddPredToStudent extends JDialog{
	
	private ArrayList<Predmet> spisakNePolPredmetaStudenta = new ArrayList<Predmet>();

	public AddPredToStudent(Frame parent, String title, boolean modal){
		
		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/5, 2*screenHeight/5);
		setLocationRelativeTo(null);
		setTitle("Odaberi predmet");
		
		int rowView = TabbedPane.tabelaStudenata.getSelectedRow();
		int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowView);
		if(rowModel != -1) {
			if(BazaStudenata.getInstance().getRow(rowModel).getSpisakNepolIspita() != null)
				spisakNePolPredmetaStudenta  =BazaStudenata.getInstance().getRow(rowModel).getSpisakNepolIspita();
			
			DozvoljeniPredmetiStudentJTable TabelaDozvoljenihPredmeta = new DozvoljeniPredmetiStudentJTable();
			JScrollPane scrollpane = new JScrollPane(TabelaDozvoljenihPredmeta);
			add(scrollpane);
			
			JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
			this.add(panelBtn, BorderLayout.SOUTH);
			JButton btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int rowView = TabelaDozvoljenihPredmeta.getSelectedRow();
					int rowModel = TabelaDozvoljenihPredmeta.convertRowIndexToModel(rowView);
					if(rowModel != -1) {
						
						ArrayList<Student> studentiNisuPolozili = new ArrayList<Student>();//studenti koji nisu polozili ovaj predmet(polje predmeta) ref zavisnost
						
						AbstractTableModelDozvoljeniPredmetiStudent mdp = (AbstractTableModelDozvoljeniPredmetiStudent) TabelaDozvoljenihPredmeta.getModel();
						String sifra = (String) mdp.getValueAt(rowModel,0);
						
						int rowStudView = TabbedPane.tabelaStudenata.getSelectedRow();
						int rowStudModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowStudView); //student kom dodajemo predmete
						
						for(Predmet p : BazaPredmeta.getInstance().getPredmeti())
							if(sifra.equals(p.getSifraPred())) {
								spisakNePolPredmetaStudenta.add(p);
								
								if(p.getStudentiNisuPolozili() == null) { //resavanje ref zavisnosti
									studentiNisuPolozili.add(BazaStudenata.getInstance().getRow(rowStudModel));
								}else {
									studentiNisuPolozili = p.getStudentiNisuPolozili();
									studentiNisuPolozili.add(BazaStudenata.getInstance().getRow(rowStudModel));
								}
								p.setStudentiNisuPolozili(studentiNisuPolozili);
							}
						
						BazaStudenata.getInstance().getRow(rowStudModel).setSpisakNepolIspita(spisakNePolPredmetaStudenta); //dodavanje studentu predmeta
						
						AbstractTableModelSpisakNePolPredmetaZaStudenta model =  (AbstractTableModelSpisakNePolPredmetaZaStudenta) SpisakNePolPredmetaPanel.tabelaNepolozenihPredmeta.getModel();
						model.fireTableDataChanged();
						
						int exit = JOptionPane.showConfirmDialog(null, "Predmet dodat." , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION) {
							setVisible(false);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Morate izabrati predmet pre izmene!");
					}
				}
			});
			JButton btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
				}
			});
			panelBtn.add(btnDodaj);
			panelBtn.add(btnOdustani);
			add(panelBtn, BorderLayout.SOUTH);
		}
	}
}
