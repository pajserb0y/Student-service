package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Profesor;
import view.predmet.EditPredmetDialog;
import view.profesor.EditProfesorDialog;
import view.student.EditStudentDialog;


public class ActionListenerEdit implements ActionListener{
	
	public static EditStudentDialog dialogStd;
	public static EditProfesorDialog dialogProf;
	public static EditPredmetDialog dialogPred;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		int index = TabbedPane.getInstance().getSelectedIndex();
		
		dialogStd = new EditStudentDialog(null, "Izmena studenta", true);
		dialogProf = new EditProfesorDialog(null, "Izmena profesora", true);
		dialogPred = new EditPredmetDialog(null, "Izmena predmeta", true);
		
		
		if(index == 0)
		{
			try{
			int rowView = TabbedPane.tabelaStudenata.getSelectedRow();
			int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowView);
			
			if(rowModel != -1)
			{
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				
				String ime = BazaStudenata.getInstance().getRow(rowModel).getIme();
				String prz = BazaStudenata.getInstance().getRow(rowModel).getPrezime();
				Date dat = BazaStudenata.getInstance().getRow(rowModel).getDatRodj();
				String adr = BazaStudenata.getInstance().getRow(rowModel).getAdresaStan();
				String tel = BazaStudenata.getInstance().getRow(rowModel).getTelefon();
				String email = BazaStudenata.getInstance().getRow(rowModel).getEmail();
				String indeks = BazaStudenata.getInstance().getRow(rowModel).getBrIndeksa();
				int godUpisa = BazaStudenata.getInstance().getRow(rowModel).getGodUpisa();
				
				
				EditStudentDialog.txtIme.setText(ime);
				EditStudentDialog.txtPrz.setText(prz);
				EditStudentDialog.txtDat.setText(formater.format(dat));
				EditStudentDialog.txtAdresa.setText(adr);
				EditStudentDialog.txtTel.setText(tel);
				EditStudentDialog.txtEmail.setText(email);
				EditStudentDialog.txtIndeks.setText(indeks);
				EditStudentDialog.txtGodUpisa.setText(Integer.toString(godUpisa));
				
				dialogStd.setVisible(true);
				dialogStd.pack();
			}else {
				JOptionPane.showMessageDialog(null, "Morate izabrati studenta pre izmene!");
			}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Morate izabrati studenta pre izmene!");
			}
		}
		
		else if(index == 1) //kad budes dodavao studenta promeni ovo u else if samo a ti stavi iznad if(index == 0)
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
		else if(index == 2)
		{
			int rowView = TabbedPane.tabelaPredmeta.getSelectedRow();
			int rowModel = TabbedPane.tabelaPredmeta.convertRowIndexToModel(rowView);
			if(rowModel != -1)
			{				
				String sifra = BazaPredmeta.getInstance().getRow(rowModel).getSifraPred();
				String naziv = BazaPredmeta.getInstance().getRow(rowModel).getNazPred();
				int god = BazaPredmeta.getInstance().getRow(rowModel).getGodStud();
				String semestar = BazaPredmeta.getInstance().getRow(rowModel).getSemestar();
				Profesor profesor = BazaProfesora.getInstance().getRow(rowModel);
				int espb = BazaPredmeta.getInstance().getRow(rowModel).getEspb();

							
				EditPredmetDialog.txtSif.setText(sifra);
				EditPredmetDialog.txtNaz.setText(naziv);
				EditPredmetDialog.godStud.getModel().setSelectedItem(god);
				EditPredmetDialog.godStud.updateUI();
				EditPredmetDialog.semest.getModel().setSelectedItem(semestar);
				EditPredmetDialog.semest.updateUI();
				EditPredmetDialog.txtEspb.setText(Integer.toString(espb));
				EditPredmetDialog.txtProf.setText(profesor.getIme() + " " + profesor.getPrezime());
				
				dialogPred.setVisible(true);
				dialogPred.pack();
			}else {
				JOptionPane.showMessageDialog(null, "Morate izabrati predmet pre izmene!");
			}
		}
	}
	
}
