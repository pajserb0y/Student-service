package view.predmet;

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


public class AddPredmetDialog extends JDialog {
	
	public static JTextField txtSif = new JTextField();
	public static JTextField txtNaz = new JTextField();
	public static JTextField txtProf = new JTextField();
	public static JTextField txtEspb = new JTextField();
	public static JComboBox<String> godStud = new JComboBox<String>();
	public static JComboBox<String> semest = new JComboBox<String>();
	
	public AddPredmetDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		// TODO Auto-generated constructor stub
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(2*screenWidth/8, 3*screenHeight/8);
		setLocationRelativeTo(parent);
		
		JPanel panelSif = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelNaz = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelProf = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelEspb = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelGodStud = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelSemest = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelBtn, BorderLayout.SOUTH);
		JButton btnPotvrda = new JButton("Potvrdi");
		btnPotvrda.addActionListener(new ActionListenerAddPred());
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		Dimension dimenzija = new Dimension(screenWidth/9,screenHeight/38);
		
		JLabel lblSif = new JLabel("Šifra*: ");
		lblSif.setPreferredSize(dimenzija);
		JLabel lblNaz = new JLabel("Naziv predmeta*: ");
		lblNaz.setPreferredSize(dimenzija);
		JLabel lblProf = new JLabel("Predmetni profesor: ");
		lblProf.setPreferredSize(dimenzija);
		JLabel lblEspb = new JLabel("Broj ESP bodova: ");
		lblEspb.setPreferredSize(dimenzija);
		JLabel lblSemest = new JLabel("Semestar*: ");
		lblSemest.setPreferredSize(dimenzija);
		JLabel lblGodStud= new JLabel("Godina studija izvodjenja*: ");
		lblGodStud.setPreferredSize(dimenzija);
		
		txtSif.setPreferredSize(dimenzija);
		txtNaz.setPreferredSize(dimenzija);
		txtProf.setPreferredSize(dimenzija);
		txtEspb.setPreferredSize(dimenzija);
		
		semest.removeAllItems();
		semest.addItem("Zimski");
		semest.addItem("Letnji");
		
		godStud.removeAllItems();
		godStud.addItem("Prva");
		godStud.addItem("Druga");
		godStud.addItem("Treća");
		godStud.addItem("Četvrta");
		
		panelSif.add(lblSif);
		panelSif.add(txtSif);

		panelNaz.add(lblNaz);
		panelNaz.add(txtNaz);

		panelSemest.add(lblSemest);
		panelSemest.add(semest);
		

		panelGodStud.add(lblGodStud);
		panelGodStud.add(godStud);
		
		panelEspb.add(lblEspb);
		panelEspb.add(txtEspb);

		panelProf.add(lblProf);
		panelProf.add(txtProf);
		
		panelBtn.add(btnPotvrda);
		panelBtn.add(btnOdustani);
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panelSif);
		boxCentar.add(panelNaz);
		boxCentar.add(panelEspb);
		boxCentar.add(panelProf);
		boxCentar.add(panelSemest);
		boxCentar.add(panelGodStud);
		boxCentar.add(panelBtn);

		add(boxCentar, BorderLayout.NORTH);
		
	}
	
}

