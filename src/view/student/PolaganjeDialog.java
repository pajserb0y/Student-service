package view.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.AbstractTableModelSpisakNePolPredmetaZaStudenta;
import model.AbstractTableModelSpisakPolPredmetaZaStudenta;
import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Student;
import view.TabbedPane;

public class PolaganjeDialog extends JDialog{
	public static JTextField txtSifra = new JTextField();
	public static JTextField txtNaziv = new JTextField();
	public static JTextField txtDatum = new JTextField();
	public static JComboBox<String> cbOcena = new JComboBox<String>();
	
	public PolaganjeDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();

		setSize(screenSize.width/6, 4*screenSize.height/11);
		setLocationRelativeTo(null);
		setTitle("Unos Ocene");
		Dimension dim = new Dimension(screenSize.width/14, screenSize.height/38);
		
		JPanel panelNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		JPanel panelDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelOcena = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBtnPot_Odu = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		panelBtnPot_Odu.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(panelBtnPot_Odu, BorderLayout.SOUTH);	
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setEnabled(false);;
		
		txtDatum.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}
			public void changed() {
				Date dat;
				SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");		
				try {
					dat =  format.parse(txtDatum.getText());
					btnPotvrdi.setEnabled(true);
					
				} catch(ParseException e1) {
					//JOptionPane.showMessageDialog(null,"Datum uneti u formatu dd/mm/yyyy! \n");
					return;
				}
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ocena = Integer.parseInt((String) cbOcena.getSelectedItem());
				Date dat;
				SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");		
				try {
					dat =  format.parse(txtDatum.getText());
				} catch(ParseException e1) {
					JOptionPane.showMessageDialog(null,"Datum uneti u formatu dd/mm/yyyy! \n");
					return;
				}
				
				ArrayList<Predmet> spisakNepolPredmetaStudenta = new ArrayList<Predmet>();
				ArrayList<Predmet> spisakPolPredmetaStudenta = new ArrayList<Predmet>();
				ArrayList<Ocena> sveOcene = new ArrayList<Ocena>();
				ArrayList<Student> studentiNisuPolozili = new ArrayList<Student>(); //obelezja premeta referencijala zavisnost
				ArrayList<Student> studentiPolozili = new ArrayList<Student>(); //obelezja premeta referencijala zavisnost
				
				int rowStudView = TabbedPane.tabelaStudenata.getSelectedRow();
				int rowStudModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowStudView); 
				Student student = BazaStudenata.getInstance().getRow(rowStudModel); //student koji polaze predmet
				
				
				if(student.getSpisakNepolIspita() != null)
					spisakNepolPredmetaStudenta = student.getSpisakNepolIspita();
				
				if(student.getSpisakPolIspitaISpisakOcena() != null)
					spisakPolPredmetaStudenta = student.getSpisakPolIspitaISpisakOcena();
				
				if(BazaOcena.getInstance().getOcene() != null)
					sveOcene = BazaOcena.getInstance().getOcene();
				

					int rowView = SpisakNePolPredmetaPanel.tabelaNepolozenihPredmeta.getSelectedRow();
					int rowModel = SpisakNePolPredmetaPanel.tabelaNepolozenihPredmeta.convertRowIndexToModel(rowView);
					
					AbstractTableModelSpisakNePolPredmetaZaStudenta mdp = (AbstractTableModelSpisakNePolPredmetaZaStudenta) SpisakNePolPredmetaPanel.tabelaNepolozenihPredmeta.getModel();
					String sifra = (String) mdp.getValueAt(rowModel, 0);
					
					for(Predmet predmet : BazaPredmeta.getInstance().getPredmeti())
							if(sifra.equals(predmet.getSifraPred())) {
								spisakNepolPredmetaStudenta.remove(predmet);
								spisakPolPredmetaStudenta.add(predmet);
								sveOcene.add(new Ocena(student, predmet, ocena, dat));
								
								studentiNisuPolozili = predmet.getStudentiNisuPolozili(); //resavanje referencijalne zavisnosti
								studentiNisuPolozili.remove(student);
								if(predmet.getStudentiPolozili() == null)
									studentiPolozili.add(student);
								else {
									studentiPolozili = predmet.getStudentiPolozili();
									studentiPolozili.add(student);
								}
								predmet.setStudentiNisuPolozili(studentiNisuPolozili);
								predmet.setStudentiPolozili(studentiPolozili); //dovde
							}
					
					BazaOcena.getInstance().setOcene(sveOcene);
					student.setSpisakNepolIspita(spisakNepolPredmetaStudenta); //updateovanje liste
					student.setSpisakPolIspitaISpisakOcena(spisakPolPredmetaStudenta); //dodavanje na listu polozenih
					
					AbstractTableModelSpisakNePolPredmetaZaStudenta model =  (AbstractTableModelSpisakNePolPredmetaZaStudenta) SpisakNePolPredmetaPanel.tabelaNepolozenihPredmeta.getModel();
					model.fireTableDataChanged();
					AbstractTableModelSpisakPolPredmetaZaStudenta model2 = (AbstractTableModelSpisakPolPredmetaZaStudenta) SpisakPolPredmetaPanel.tabelaPolPredmeta.getModel();
					model2.fireTableDataChanged();
					
					int exit = JOptionPane.showConfirmDialog(null, "Predmet dodat." , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION) {
						setVisible(false);
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
		
		txtSifra.setPreferredSize(dim);
		txtNaziv.setPreferredSize(dim);		
		txtDatum.setPreferredSize(dim);
		cbOcena.setPreferredSize(dim);
		txtSifra.setEditable(false);
		txtNaziv.setEditable(false);
		
		
		JLabel lblSifra = new JLabel("Sifra*");
		lblSifra.setPreferredSize(dim);
		JLabel lblNaziv = new JLabel("Naziv*");
		lblNaziv.setPreferredSize(dim);		
		JLabel lblDatum = new JLabel("Datum*");
		lblDatum.setPreferredSize(dim);
		JLabel lblOcena = new JLabel("Ocena*");
		lblOcena.setPreferredSize(dim);
		
		cbOcena.removeAllItems();
		cbOcena.addItem("6");
		cbOcena.addItem("7");
		cbOcena.addItem("8");
		cbOcena.addItem("9");
		cbOcena.addItem("10");
		
		panelSifra.add(lblSifra);
		panelSifra.add(txtSifra);
		panelNaziv.add(lblNaziv);
		panelNaziv.add(txtNaziv);
		panelDatum.add(lblDatum);
		panelDatum.add(txtDatum);
		panelOcena.add(lblOcena);
		panelOcena.add(cbOcena);
		
		panelBtnPot_Odu.add(btnPotvrdi);
		panelBtnPot_Odu.add(btnOdustani);
		

		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		
		boxCentar.add(panelSifra);
		boxCentar.add(panelNaziv);
		boxCentar.add(panelOcena);
		boxCentar.add(panelDatum);
		boxCentar.add(panelBtnPot_Odu);
		
		add(boxCentar, BorderLayout.NORTH);
	}
}
