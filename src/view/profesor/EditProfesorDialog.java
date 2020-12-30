package view.profesor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditProfesorDialog extends JDialog {
	
	public static JTextField txtIme = new JTextField();
	public static JTextField txtPrz = new JTextField();
	public static JTextField txtDat = new JTextField();	
	public static JTextField txtAdr = new JTextField();	
	public static JTextField txtTel = new JTextField();	
	public static JTextField txtEmail= new JTextField();
	public static JTextField txtAdrKanc = new JTextField();		
	public static JTextField txtBrLk = new JTextField();		
	public static JTextField txtPred= new JTextField();
	public static JComboBox<String> zvanje = new JComboBox<String>();
	public static JComboBox<String> titula = new JComboBox<String>();
	
	public EditProfesorDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		// TODO Auto-generated constructor stub
		
		java.awt.Toolkit kit = java.awt.Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(3*screenWidth/8, 5*screenHeight/9);
		setLocationRelativeTo(parent);
		
		JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelPrz = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelDat = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelAdr = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelAdrKanc = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBrLk = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelBtn, BorderLayout.SOUTH);
		JButton btnPotvrda = new JButton("Potvrdi");
		btnPotvrda.addActionListener(new ActionListenerEditProf());
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		Dimension dimenzija = new Dimension(screenWidth/9,screenHeight/38);
		
		JLabel lblIme = new JLabel("Ime*: ");
		lblIme.setPreferredSize(dimenzija);
		JLabel lblPrz = new JLabel("Prezime*: ");
		lblPrz.setPreferredSize(dimenzija);
		JLabel lblDat = new JLabel("Datum rođenja*: ");
		lblDat.setPreferredSize(dimenzija);
		JLabel lblAdr = new JLabel("Adresa stanovanja*: ");
		lblAdr.setPreferredSize(dimenzija);
		JLabel lblTel = new JLabel("Broj telefona*: ");
		lblTel.setPreferredSize(dimenzija);
		JLabel lblEmail = new JLabel("Email*: ");
		lblEmail.setPreferredSize(dimenzija);
		JLabel lblAdrKanc = new JLabel("Adresa kancelarije*: ");
		lblAdrKanc.setPreferredSize(dimenzija);
		JLabel lblBrLk = new JLabel("Broj lične karte*: ");
		lblBrLk.setPreferredSize(dimenzija);
		JLabel lblTitula = new JLabel("Titula*: ");
		lblTitula.setPreferredSize(dimenzija);
		JLabel lblZvanje = new JLabel("Zvanje: ");
		lblZvanje.setPreferredSize(dimenzija);
		
		txtIme.setPreferredSize(dimenzija);
		txtPrz.setPreferredSize(dimenzija);
		txtDat.setPreferredSize(dimenzija);
		txtAdr.setPreferredSize(dimenzija);
		txtTel.setPreferredSize(dimenzija);
		txtEmail.setPreferredSize(dimenzija);
		txtAdrKanc.setPreferredSize(dimenzija);
		txtBrLk.setPreferredSize(dimenzija);
		
		titula.removeAllItems();
		titula.addItem("Dipl. Ing");
		titula.addItem("Mr");
		titula.addItem("Dr");
		titula.addItem("Prof. dr");
		
		zvanje.removeAllItems();
		zvanje.addItem("Saradnik u nastavi");
		zvanje.addItem("Asistent");
		zvanje.addItem("Docent");
		zvanje.addItem("Vanredni profesor");
		zvanje.addItem("Redovni profesor");
		zvanje.addItem("Profesor emeritius");
		
		panelIme.add(lblIme);
		panelIme.add(txtIme);
		
		panelPrz.add(lblPrz);
		panelPrz.add(txtPrz);
		
		panelDat.add(lblDat);
		panelDat.add(txtDat);
		
		panelAdr.add(lblAdr);
		panelAdr.add(txtAdr);
		
		panelTel.add(lblTel);
		panelTel.add(txtTel);
		
		panelEmail.add(lblEmail);
		panelEmail.add(txtEmail);
		
		panelAdrKanc.add(lblAdrKanc);
		panelAdrKanc.add(txtAdrKanc);
		
		panelBrLk.add(lblBrLk);
		panelBrLk.add(txtBrLk);
		
		panelTitula.add(lblTitula);
		panelTitula.add(titula);
		
		panelZvanje.add(lblZvanje);
		panelZvanje.add(zvanje);
		
		panelBtn.add(btnPotvrda);
		panelBtn.add(btnOdustani);
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		
		boxCentar.add(panelIme);
		boxCentar.add(panelPrz);
		boxCentar.add(panelDat);
		boxCentar.add(panelAdr);
		boxCentar.add(panelTel);
		boxCentar.add(panelEmail);
		boxCentar.add(panelAdrKanc);
		boxCentar.add(panelBrLk);
		boxCentar.add(panelTitula);
		boxCentar.add(panelZvanje);
		boxCentar.add(panelBtn);
		
		add(boxCentar, BorderLayout.NORTH);
	}
	
	
}
