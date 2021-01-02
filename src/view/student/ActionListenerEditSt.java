package view.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import controller.StudentController;
import view.ActionListenerAdd;
import view.ActionListenerEdit;
import view.TabbedPane;
import model.BazaStudenata;
import model.Predmet;
import model.Student;
import model.Student.STATUS;

public class ActionListenerEditSt implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String ime="";
		String prz="";
		Date dat=null;
		int godUpisa =0;
		String adresa="";
		String tel="";
		String email="";
		String indeks="";
		String godStudija="I (prva)";
		double prosek=0.0;
		STATUS status= STATUS.B;
		ArrayList<Predmet> spisakPolIspitaISpisakOcena = null;
		ArrayList<Predmet> spisakNepolIspita = null;
		
		int rowView = TabbedPane.tabelaStudenata.getSelectedRow();
		int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowView);
		String stariIndeks = (String)BazaStudenata.getInstance().getRow(rowModel).getBrIndeksa();
		
		ime=EditStudentDialog.txtIme.getText();
		prz=EditStudentDialog.txtPrz.getText();	

		if(!ime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") ) {
			JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Ime treba da se sastoji samo od slova!\n");
			return;
		}

		if(!prz.matches("[A-Za-zšđžćčŠĐŽČĆ]+") ) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Prezime treba da se sastoji samo od slova!\n");
			return;
		}
		
		
		SimpleDateFormat format= new SimpleDateFormat("dd/mm/yyyy");		
		try {
			dat=format.parse(EditStudentDialog.txtDat.getText());			
		} catch(ParseException e1) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Datum uneti u formatu dd.mm.yyyy!\n");
			return;
		}
		
		
		adresa=EditStudentDialog.txtAdresa.getText();
		
		
		
		tel=EditStudentDialog.txtTel.getText();
		if(!tel.matches("[0-9]{3}/[0-9]{3,4}-[0-9]{3,4}") ) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Telefon unositi kao niz brojeva formata xxx/xxx-xxx!\\n");
			return;
		}
		
		email=EditStudentDialog.txtEmail.getText();
		if(!email.matches("[A-Za-zšđžćčŠĐŽČĆ0-9.]+[A-Za-zšđžćčŠĐŽČĆ0-9.]+@[A-Za-z.]+[A-Za-z.]+")) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Email uneti sa obaveznim znakom @!");
			return;
		}
		
		
		indeks=EditStudentDialog.txtIndeks.getText();		
		ArrayList<Student> listaStudenata = BazaStudenata.getInstance().getStudenti();
		if(!stariIndeks.equals(indeks))
		{
			for(Student s:listaStudenata) {
				if(indeks.equals(s.getBrIndeksa())) {
					JOptionPane.showMessageDialog(null,"Broj indeksa već postoji!\n");
					return;
				}
			}
		}
//		for(Student s:listaStudenata) {
//			if(indeks.equals(s.getBrIndeksa())) {
//				JOptionPane.showMessageDialog(null,"Broj indeksa već postoji!\n");
//				return;
//			}
//		}
		
		
		try{
			godUpisa = Integer.parseInt(EditStudentDialog.txtGodUpisa.getText());
		} catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Godina upisa mora biti broj!");
			return;
		}
		
		int god=0;
		godStudija=EditStudentDialog.cbGodStudija.getSelectedItem().toString();
		if(godStudija.equals("I (prva)")) {
			god=1;
		}else if(godStudija.equals("II (druga)")) {
			god=2;
		}else if(godStudija.equals("III (treća)")) {
			god=3;
		}else if(godStudija.equals("IV (četvrta)")) {
			god=4;
		}
		
		
		if(EditStudentDialog.cbStatus.getSelectedItem().toString() == "Budžet" )
			status = STATUS.B;
		else
			status = STATUS.S;
		
		
		
	
		if( indeks.equals("") || ime.equals("") || prz.equals("") || adresa.equals("") || tel.equals("")
		|| email.equals("") || god==0 ) {
			JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!");
			return;
		}else{
//			StudentController.getInstance().izmeniStudenta(ime, prz, dat, adresa, tel, email, indeks, godUpisa, god, status, prosek, spisakPolIspitaISpisakOcena, spisakNepolIspita);
			StudentController.getInstance().izmeniStudenta(ime, prz, dat, adresa, tel, email, indeks, godUpisa, god, status, prosek, new ArrayList<Predmet>(), new ArrayList<Predmet>());
			int  exit = JOptionPane.showConfirmDialog(null, "Student je izmenjen" , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION){
				ActionListenerEdit.dialogStd.setVisible(false);			
			}
		}
	}
}
