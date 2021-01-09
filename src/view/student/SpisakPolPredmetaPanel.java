package view.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SpisakPolPredmetaPanel extends JPanel {
	
	public static JTable tabelaSpisakPredmeta = null;
	public static JTextField txtProsek = new JTextField();
	public static JTextField txtEspb = new JTextField();
	
	public SpisakPolPredmetaPanel() {
		
		JPanel panelBtnPonisti = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelPolPredmeti = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		JPanel panelProsek = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel panelEspb = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
		panelBtnPonisti.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(panelBtnPonisti, BorderLayout.NORTH);	
		JButton btnPonisti = new JButton("Poništi ocenu");
//		btnPonisti.addActionListener(new ActionListener());
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		Dimension dim = new Dimension(screenSize.width/9, screenSize.height/38);
		
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
		
		JTable tabelaPolPredmeta = new SpisakPolPredmetaJTable();
		JScrollPane sp = new JScrollPane(tabelaPolPredmeta);
		panelPolPredmeti.add(sp);
		
		Box boxCentar1 = Box.createVerticalBox();
		boxCentar1.add(Box.createVerticalStrut(20));
		boxCentar1.add(panelBtnPonisti);
		boxCentar1.add(panelPolPredmeti);
		boxCentar1.add(panelProsek);
		boxCentar1.add(panelEspb);
		add(boxCentar1, BorderLayout.NORTH);
	}
}
