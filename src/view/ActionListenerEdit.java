package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.AbstractTableModelProfesor;
import model.BazaProfesora;
import view.profesor.EditProfesorDialog;



public class ActionListenerEdit implements ActionListener{
	
	public static EditProfesorDialog dialogProf;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		dialogProf = new EditProfesorDialog(null,"Izmena profesora", true);
		int index = TabbedPane.getInstance().getSelectedIndex();
		
		if(index == 1) //kad budes dodavao studenta promeni ovo u else if samo a ti stavi iznad if(index == 0)
		{
			int rowView = TabbedPane.tabelaProfesora.getSelectedRow();
			int rowModel = TabbedPane.tabelaProfesora.convertRowIndexToModel(rowView);
			if(rowModel != -1)
			{
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				
				String ime = BazaProfesora.getInstance().getRow(rowModel).getIme();
				String prz = BazaProfesora.getInstance().getRow(rowModel).getPrezime();
				Date dat = BazaProfesora.getInstance().getRow(rowModel).getDatRodj();
				String adr = BazaProfesora.getInstance().getRow(rowModel).getAdresaStan();
				String tel = BazaProfesora.getInstance().getRow(rowModel).getTelefon();
				String email = BazaProfesora.getInstance().getRow(rowModel).getEmail();
				String adrKanc = BazaProfesora.getInstance().getRow(rowModel).getAdresaKanc();
				String brLk = BazaProfesora.getInstance().getRow(rowModel).getBrLicne();
				String titula = BazaProfesora.getInstance().getRow(rowModel).getTitula();
				String zvanje = BazaProfesora.getInstance().getRow(rowModel).getZvanje();
				
							
				EditProfesorDialog.txtIme.setText(ime);
				EditProfesorDialog.txtPrz.setText(prz);
				EditProfesorDialog.txtAdr.setText(adr);
				EditProfesorDialog.txtEmail.setText(email);
				EditProfesorDialog.txtAdrKanc.setText(adrKanc);
				EditProfesorDialog.txtDat.setText(formater.format(dat));
				EditProfesorDialog.txtTel.setText(tel);
				EditProfesorDialog.txtBrLk.setText(brLk);
				EditProfesorDialog.titula.getModel().setSelectedItem(titula);
				EditProfesorDialog.titula.updateUI();
				EditProfesorDialog.zvanje.getModel().setSelectedItem(zvanje);
				EditProfesorDialog.zvanje.updateUI();
				
				dialogProf.setVisible(true);
				dialogProf.pack();
			}else {
				JOptionPane.showMessageDialog(null, "Morate izabrati profesora pre izmene!");
			}
		}
	}
	
}
