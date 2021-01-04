package view.predmet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TabbedPane;
import view.profesor.ProfesorJTable;
import model.BazaProfesora;
import model.Profesor;

public class AddProfToPredDialog extends JDialog{
	
	private static Profesor dodatProfesor;

	public AddProfToPredDialog(Frame parent, String title, boolean modal){
		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/5, 2*screenHeight/5);
		setLocationRelativeTo(null);
		setTitle("Odaberi profesora");
		
		
		JTable tabelaProfesora = new ProfesorJTable();
		JScrollPane scrollPaneP = new JScrollPane(tabelaProfesora);
		add(scrollPaneP);
		
		JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(panelBtn, BorderLayout.SOUTH);
		JButton btnPotvrda = new JButton("Potvrdi");
		btnPotvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int index = tabelaProfesora.getSelectedRow();
				int rowModel = tabelaProfesora.convertRowIndexToModel(index);
				
				if(rowModel != -1)
				{
					dodatProfesor = BazaProfesora.getInstance().getRow(rowModel);
					
					String ime = dodatProfesor.getIme();
					String prezime = dodatProfesor.getPrezime();
					
					AddPredmetDialog.txtProf.setText(ime + " " + prezime);

					int exit = JOptionPane.showConfirmDialog(null, "Profesor dodat." , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION)
						setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Morate izabrati profesora pre izmene!");
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
	
	public static Profesor getDodatProfesor() {
		return dodatProfesor;
	}
	public static void setDodatProfesor(Profesor profesor) {
		dodatProfesor = profesor;
	}
}
