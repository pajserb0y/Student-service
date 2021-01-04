package view.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import controller.ProfesorController;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import view.ActionListenerEdit;
import view.TabbedPane;

public class ActionListenerEditProf implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String ime = "";
		String prz = "";
		String brLk = "";
		Date dat = null;
		String adr = "";
		String tel = "";
		String email = "";
		String adrKanc = "";
		String titula = "";
		String zvanje = "";
		ArrayList<Predmet> spisakPredmeta =  null;
		int rowView = TabbedPane.tabelaProfesora.getSelectedRow();
		int rowModel = TabbedPane.tabelaProfesora.convertRowIndexToModel(rowView);
		String staraLk = (String)BazaProfesora.getInstance().getRow(rowModel).getBrLicne();
		ime = EditProfesorDialog.txtIme.getText();
		prz = EditProfesorDialog.txtPrz.getText();
		brLk = EditProfesorDialog.txtBrLk.getText();
		tel = EditProfesorDialog.txtTel.getText();
		adr = EditProfesorDialog.txtAdr.getText();
		email = EditProfesorDialog.txtEmail.getText();
		adrKanc = EditProfesorDialog.txtAdrKanc.getText();
		titula = EditProfesorDialog.titula.getSelectedItem().toString();
		zvanje = EditProfesorDialog.zvanje.getSelectedItem().toString();
		String txtDat = EditProfesorDialog.txtDat.getText();
		
		
		if (!brLk.matches("[0-9]+") || brLk.length() != 9) {
			JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Broj lične karte treba da ima tačno 9 cifara!");
			return;
		}
		
		ArrayList<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
		
		if(!staraLk.equals(brLk))
		{
			for(Profesor p : profesori) 
				if(brLk.equals(p.getBrLicne()))
				{
					JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!\n"
							+ "\tNAPOMENA: Broj lične karte već postoji u bazi profesora!");
					return;
				}
		}
		
		if(!ime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") ) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Ime i prezime treba da se sastoje samo od slova!");
			return;
		}
		
		if(!prz.matches("[A-Za-zšđžćčŠĐŽČĆ]+") ) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Ime i prezime treba da se sastoje samo od slova!");
			return;
		}
			
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dat = formater.parse(txtDat);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
				+ "\tNAPOMENA: Datum uneti u formatu dd/mm/yyyy!\n");
			return;
		}
		
		if(!email.matches("[A-Za-z0-9.]+[A-Za-z0-9.]+@[A-Za-z.]+[A-Za-z.]+")) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Email uneti sa obaveznim znakom @.");
			return;
		}

		if(!tel.matches("[0-9]{3}/[0-9]{3,4}-[0-9]{3,4}") ) {
			JOptionPane.showMessageDialog(null," Obavezno je popunjavanje svih polja! \n"  
					+ "\tNAPOMENA: Telefon unositi kao niz brojeva formata xxx/xxx-xxx!\n");
			return;
		}
		
		if(ime.equals("") || prz.equals("") || adr.equals("") || email.equals("") || tel.equals("") ||
				adrKanc.equals("") || titula.equals("") || zvanje.equals("")) {
			JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!");
			return;
			}
		else {
			ProfesorController.getInstance().izmeniProfesora(staraLk,ime, prz, dat, adr, tel, email, adrKanc,brLk, titula, zvanje, spisakPredmeta);
			int  exit = JOptionPane.showConfirmDialog(null, "Profesor je izmenjen." , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION){
				ActionListenerEdit.dialogProf.setVisible(false);	
			}
		}
	}

}
