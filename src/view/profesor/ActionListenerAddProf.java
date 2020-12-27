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
import model.Profesor;
import view.ActionListenerAdd;

public class ActionListenerAddProf implements ActionListener{

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
		
		boolean f1 = false;
		boolean f2 = false;
		boolean f3 = false;
		boolean f4 = false;
		boolean f5 = false;
		boolean f6 = false;
		boolean f7 = false;
		
		ime = AddProfesorDialog.txtIme.getText();
		prz = AddProfesorDialog.txtPrz.getText();
		brLk = AddProfesorDialog.txtBrLk.getText();
		tel = AddProfesorDialog.txtTel.getText();
		adr = AddProfesorDialog.txtAdr.getText();
		email = AddProfesorDialog.txtEmail.getText();
		adrKanc = AddProfesorDialog.txtAdrKanc.getText();
		titula = AddProfesorDialog.titula.getSelectedItem().toString();
		zvanje = AddProfesorDialog.zvanje.getSelectedItem().toString();
		String txtDat = AddProfesorDialog.txtDat.getText();
		
		
		if (!brLk.matches("[0-9]+") || brLk.length() != 9) {
			if(f2==false && f3==false  && f4==false && f5==false && f6==false && f7==false)
			{
			JOptionPane.showMessageDialog(null, "Broj lične karte treba da ima tačno 9 cifara!");
			f1=true;
			return;
			}
		}
		
		ArrayList<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
		for(Profesor p : profesori) 
			if(brLk == p.getBrLicne())
			{
				f4=true;
				break;
			}
		if(f1==false && f2==false && f3==false && f4==true && f5==false && f6==false && f7==false) {
			JOptionPane.showMessageDialog(null, "Broj lične karte već postoji u bazi profesora!");
		}
		
		if(!ime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") ) {
			if(f1==false && f2==false && f3==false && f4==false && f5==false && f6==false && f7==false) {
				JOptionPane.showMessageDialog(null,"Ime i prezime treba da se sastoje samo od slova!");
				f7=true;
			}
		}
		
		if(!prz.matches("[A-Za-zšđžćčŠĐŽČĆ]+") ) {
			if(f1==false && f2==false && f3==false && f4==false && f5==false && f6==false && f7==false) {
				JOptionPane.showMessageDialog(null,"Ime i prezime treba da se sastoje samo od slova!");
				f7=true;
			}
		}
			
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dat = formater.parse(txtDat);
		} catch (ParseException e) {
			if(f1==false && f3==false && f4==false && f5==false && f6==false && f7==false)
			{
				JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "NAPOMENE: Datum uneti u formatu dd/mm/yyyy!\n");
				f2=true;
			}
		}
		
		if(!email.matches("[A-Za-z0-9.]+[A-Za-z0-9.]+@[A-Za-z.]+[A-Za-z.]+")) {
			if(f1==false && f2==false && f3==false && f4==false && f6==false && f7==false) {
				JOptionPane.showMessageDialog(null,"Email uneti sa obaveznim znakom @.");
				f5=true;
			}
		}

		if(!tel.matches("[0-9]{3}/[0-9]{3,4}-[0-9]{3,4}") ) {
			if(f1==false && f2==false && f3==false && f4==false && f5==false && f7==false) {
				JOptionPane.showMessageDialog(null," Obavezno je popunjavanje svih polja! \n"  
												+ " \t NAPOMENA:Telefon unositi kao niz brojeva formata xxx/xxx-xxx!\n");
				f6=true;
			}
		}
		
		if(ime.equals("") || prz.equals("") || adr.equals("") || email.equals("") || tel.equals("") ||
				adrKanc.equals("") || titula.equals("") || zvanje.equals("")) {
			if(f1==false && f2==false && f3==false  && f4==false && f5==false && f6==false && f7==false) {
				JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!");
			}
		}else if( f1==false && f2==false && f3==false  && f4==false && f5==false && f6==false && f7==false) {
			ProfesorController.getInstance().dodajProfesora(ime, prz, dat, adr, tel, email, adrKanc,brLk, titula, zvanje, new ArrayList<String>());
			int  exit = JOptionPane.showConfirmDialog(null, "Profesor dodat." , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION){
				ActionListenerAdd.dialogProf.setVisible(false);	
			}
		}
	}

}
