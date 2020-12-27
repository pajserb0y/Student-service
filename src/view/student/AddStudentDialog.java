package view.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddStudentDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	
	public static JTextField txtIme = new JTextField();
	public static JTextField txtPrz = new JTextField();
	public static JTextField txtDat = new JTextField();
	public static JTextField txtAdresa = new JTextField();
	public static JTextField txtTel = new JTextField();
	public static JTextField txtEmail = new JTextField();
	public static JTextField txtIndeks = new JTextField();
	public static JTextField txtGodUpisa = new JTextField();
	public static JComboBox<String> cbGodStudija = new JComboBox<String>();
	public static JComboBox<String> cbStatus = new JComboBox<String>();
	
	
	 public AddStudentDialog(Frame parent, String title, boolean modal) {
	    	super(parent, title, modal);
	    	
	    	Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;
			setSize(3*screenWidth/8, screenHeight/2);
			setTitle("Dodavanje studenta");
			setLocationRelativeTo(parent);
			Dimension dim = new Dimension(screenWidth/9, screenHeight/38);
			
			
			JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel panelPrz = new JPanel(new FlowLayout(FlowLayout.LEFT));		
			JPanel panelDat = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel panelAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel panelTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel panelIndeks = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel panelGodUpisa =  new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel panelGodStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel panelStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel panelBtnPot_Odu = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
			panelBtnPot_Odu.setLayout(new FlowLayout(FlowLayout.LEFT));
			getContentPane().add(panelBtnPot_Odu, BorderLayout.SOUTH);	
			JButton btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.addActionListener(new ActionListenerAddSt());
			JButton btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			}
			);
			
			txtIme.setPreferredSize(dim);
			txtPrz.setPreferredSize(dim);		
			txtDat.setPreferredSize(dim);
			txtAdresa.setPreferredSize(dim);
			txtTel.setPreferredSize(dim);
			txtEmail.setPreferredSize(dim);
			txtIndeks.setPreferredSize(dim);
			txtGodUpisa.setPreferredSize(dim);
			
				
			JLabel lblIme = new JLabel("Ime*");
			lblIme.setPreferredSize(dim);
			JLabel lblPrz = new JLabel("Prezime*");
			lblPrz.setPreferredSize(dim);		
			JLabel lblDat = new JLabel("Datum rođenja*");
			lblDat.setPreferredSize(dim);
			JLabel lblAdresa = new JLabel("Adresa stanovanja*");
			lblAdresa.setPreferredSize(dim);
			JLabel lblTel = new JLabel("Broj telefona*");
			lblTel.setPreferredSize(dim);
			JLabel lblEmail=new JLabel("E-mail adresa*");
			lblEmail.setPreferredSize(dim);
			JLabel lblIndeks = new JLabel("Broj indeksa*");
			lblIndeks.setPreferredSize(dim);	
			JLabel lblGodUpisa=new JLabel("Godina upisa*");
			lblGodUpisa.setPreferredSize(dim);
			JLabel lblGodStudija = new JLabel("Trenutna godina studija*");
			lblGodStudija.setPreferredSize(dim);
			JLabel lblStatus = new JLabel("Način finansiranja*");
			lblStatus.setPreferredSize(dim);

			
			cbGodStudija.removeAllItems();
			cbGodStudija.addItem("I (prva)");
			cbGodStudija.addItem("II (druga)");
			cbGodStudija.addItem("III (treća)");
			cbGodStudija.addItem("IV (četvrta)");
			
			cbStatus.removeAllItems();
			cbStatus.addItem("Budžet");
			cbStatus.addItem("Samofinansiranje");

			
			panelIme.add(lblIme);
			panelIme.add(txtIme);
			panelPrz.add(lblPrz);
			panelPrz.add(txtPrz);
			panelDat.add(lblDat);
			panelDat.add(txtDat);
			panelAdresa.add(lblAdresa);
			panelAdresa.add(txtAdresa);
			panelTel.add(lblTel);
			panelTel.add(txtTel);
			panelEmail.add(lblEmail);
			panelEmail.add(txtEmail);
			panelIndeks.add(lblIndeks);
			panelIndeks.add(txtIndeks);
			panelGodUpisa.add(lblGodUpisa);
			panelGodUpisa.add(txtGodUpisa);
			panelGodStudija.add(lblGodStudija);
			panelGodStudija.add(cbGodStudija);
			panelStatus.add(lblStatus);
			panelStatus.add(cbStatus);
			
			panelBtnPot_Odu.add(btnPotvrdi);
			panelBtnPot_Odu.add(btnOdustani);

			
			
			Box boxCentar = Box.createVerticalBox();
			boxCentar.add(Box.createVerticalStrut(20));
			boxCentar.add(panelIme);
			boxCentar.add(panelPrz);
			boxCentar.add(panelDat);
			boxCentar.add(panelAdresa);
			boxCentar.add(panelTel);
			boxCentar.add(panelEmail);
			boxCentar.add(panelIndeks);
			boxCentar.add(panelGodUpisa);
			boxCentar.add(panelGodStudija);
			boxCentar.add(panelStatus);
			boxCentar.add(panelBtnPot_Odu);
			
			add(boxCentar, BorderLayout.NORTH);
	} 
}
