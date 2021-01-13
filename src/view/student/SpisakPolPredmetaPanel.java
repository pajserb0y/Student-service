package view.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.AbstractTableModelSpisakNePolPredmetaZaStudenta;
import model.AbstractTableModelSpisakPolPredmetaZaStudenta;
import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Student;
import view.TabbedPane;

public class SpisakPolPredmetaPanel extends JPanel {
	
	public static JTable tabelaPolPredmeta = null;
	public static JTextField txtProsek = null; //ovo ako budes prepreavljao vrv ce morati biti oba null jer ce pokazivati isti prosek za svakog studenta!
	public static JTextField txtEspb = null;
	
	public SpisakPolPredmetaPanel() {
		
		JPanel panelBtnPonisti = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelPolPredmeti = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		JPanel panelProsek = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel panelEspb = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
		panelBtnPonisti.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(panelBtnPonisti, BorderLayout.NORTH);	
		JButton btnPonisti = new JButton("Poništi ocenu");
		btnPonisti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int rowStudView = TabbedPane.tabelaStudenata.getSelectedRow();
				int rowStudModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowStudView); 
				Student student = BazaStudenata.getInstance().getRow(rowStudModel); //student koji polaze predmet
				
				int rowView = tabelaPolPredmeta.getSelectedRow();
				int rowModel = tabelaPolPredmeta.convertRowIndexToModel(rowView);
				if(rowModel != -1){
					AbstractTableModelSpisakPolPredmetaZaStudenta mdp = (AbstractTableModelSpisakPolPredmetaZaStudenta) tabelaPolPredmeta.getModel();		
					
					ArrayList<Predmet> spisakNepolPredmetaStudenta = new ArrayList<Predmet>();
					ArrayList<Predmet> spisakPolPredmetaStudenta = new ArrayList<Predmet>();
					ArrayList<Ocena> sveOcene = new ArrayList<Ocena>();
					ArrayList<Student> studentiNisuPolozili = new ArrayList<Student>(); //obelezja premeta referencijala zavisnost
					ArrayList<Student> studentiPolozili = new ArrayList<Student>(); //obelezja premeta referencijala zavisnost
								
					if(student.getSpisakNepolIspita() != null)
						spisakNepolPredmetaStudenta = student.getSpisakNepolIspita();
					
					if(student.getSpisakPolIspitaISpisakOcena() != null)
						spisakPolPredmetaStudenta = student.getSpisakPolIspitaISpisakOcena();
					
					if(BazaOcena.getInstance().getOcene() != null)
						sveOcene = BazaOcena.getInstance().getOcene();
					
					
					String sifra = (String) mdp.getValueAt(rowModel, 0);
					
					for(Predmet predmet : BazaPredmeta.getInstance().getPredmeti())
						if(sifra.equals(predmet.getSifraPred())) {
							spisakNepolPredmetaStudenta.add(predmet);
							spisakPolPredmetaStudenta.remove(predmet);
							
							for(Ocena o : BazaOcena.getInstance().getOcene())
								if(o.getPredmet().getSifraPred().equals(predmet.getSifraPred()) && o.getStudent().getBrIndeksa().equals(student.getBrIndeksa()))
								{
									sveOcene.remove(o);
									break;
								}
							
							if(predmet.getStudentiNisuPolozili() != null)
								studentiNisuPolozili = predmet.getStudentiNisuPolozili(); //resavanje referencijalne zavisnosti
							studentiNisuPolozili.add(student);

							if(predmet.getStudentiPolozili() != null){
								studentiPolozili = predmet.getStudentiPolozili();
								studentiPolozili.remove(student);
							}
							predmet.setStudentiNisuPolozili(studentiNisuPolozili);
							predmet.setStudentiPolozili(studentiPolozili); //dovde
						}
					
					BazaOcena.getInstance().setOcene(sveOcene);
					student.setSpisakNepolIspita(spisakNepolPredmetaStudenta); //updateovanje liste
					student.setSpisakPolIspitaISpisakOcena(spisakPolPredmetaStudenta); //dodavanje na listu polozenih
					
					txtProsek.setText(Double.toString(student.getProsek()));
					txtEspb.setText(Integer.toString(student.espb()));
					
					AbstractTableModelSpisakNePolPredmetaZaStudenta model =  (AbstractTableModelSpisakNePolPredmetaZaStudenta) SpisakNePolPredmetaPanel.tabelaNepolozenihPredmeta.getModel();
					model.fireTableDataChanged();
					AbstractTableModelSpisakPolPredmetaZaStudenta model2 = (AbstractTableModelSpisakPolPredmetaZaStudenta) SpisakPolPredmetaPanel.tabelaPolPredmeta.getModel();
					model2.fireTableDataChanged();
					
					JOptionPane.showConfirmDialog(null, "Ocena je poništena." , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}else {
						JOptionPane.showMessageDialog(null, "Morate izabrati predmet koji je položen!");
				}
			}
		});
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		Dimension dim = new Dimension(screenSize.width/9, screenSize.height/38);
		
		txtProsek = new JTextField();
		txtEspb = new JTextField();
		txtProsek.setPreferredSize(dim);
		txtProsek.setEditable(false);
		txtEspb.setPreferredSize(dim);
		txtEspb.setEditable(false);
		
	
		JLabel lblProsek = new JLabel("Prosečna ocena");
		lblProsek.setPreferredSize(dim);
		JLabel lblEspb = new JLabel("Ukupno ESPB");
		lblEspb.setPreferredSize(dim);					


		panelBtnPonisti.add(btnPonisti);
		panelProsek.add(lblProsek);
		panelProsek.add(txtProsek);
		panelEspb.add(lblEspb);
		panelEspb.add(txtEspb);
		
		tabelaPolPredmeta = new SpisakPolPredmetaJTable();
		JScrollPane sp = new JScrollPane(tabelaPolPredmeta);
		panelPolPredmeti.add(sp);
		
		int index = TabbedPane.tabelaStudenata.getSelectedRow();
		int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(index);
		if(rowModel != -1){
			Student student = BazaStudenata.getInstance().getRow(rowModel);
			txtProsek.setText(Double.toString(student.getProsek()));
			txtEspb.setText(Integer.toString(student.espb()));
		}
		
		Box boxCentar1 = Box.createVerticalBox();
		boxCentar1.add(Box.createVerticalStrut(20));
		boxCentar1.add(panelBtnPonisti);
		boxCentar1.add(panelPolPredmeti);
		boxCentar1.add(panelProsek);
		boxCentar1.add(panelEspb);
		add(boxCentar1, BorderLayout.NORTH);
	}
}
