package view.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.BazaStudenata;
import model.Student;
import model.Student.STATUS;
import view.ActionListenerAdd;
import controller.StudentController;


public class ActionListenerAddSt implements ActionListener {

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
		STATUS status = STATUS.B;
		
		boolean f1=false;
		boolean f2=false;
		boolean f3=false;
		boolean f4=false;
		boolean f5=false;
		boolean f6=false;
		boolean f7=false;
		boolean f8=false;
		boolean f9=false;
		boolean f10=false;

		
		
		ime=AddStudentDialog.txtIme.getText();
		prz=AddStudentDialog.txtPrz.getText();	

		if(!ime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") ) {
			if(f1==false && f2==false && f3==false && f4==false && f5==false && f6==false && f7==false  && f8==false && f9==false) {
				JOptionPane.showMessageDialog(null,"Ime i prezime treba da se sastoje samo od slova!\n");
				f10=true;
			}
		}

		if(!prz.matches("[A-Za-zšđžćčŠĐŽČĆ]+") ) {
			if(f1==false && f2==false && f3==false && f4==false && f5==false && f6==false && f7==false  && f8==false && f9==false && f10==false) {
				JOptionPane.showMessageDialog(null,"Ime i prezime treba da se sastoje samo od slova!\n");
				f10=true;
			}
		}
		
		
		SimpleDateFormat format= new SimpleDateFormat("dd.mm.yyyy");		
		
		try {
			dat=format.parse(AddStudentDialog.txtDat.getText());			
		} catch(ParseException e1) {
			if(f2==false && f1==false && f4==false && f5==false && f6==false && f7==false  && f8==false && f9==false && f10==false) {
				JOptionPane.showMessageDialog(null,"Obavezno popuniti sva polja! \n"  
												+ " \t NAPOMENA: Datum uneti u formatu dd.mm.yyyy!\n");
				f3=true;
			}
		}
		
		
		adresa=AddStudentDialog.txtAdresa.getText();
		
		
		tel=AddStudentDialog.txtTel.getText();
		if(!tel.matches("[0-9]{3}/[0-9]{3,4}-[0-9]{3,4}") ) {
			if(f1==false && f2==false && f3==false && f4==false && f6==false && f7==false && f8==false && f9==false && f10==false) {
				JOptionPane.showMessageDialog(null,"Telefon unositi kao niz brojeva formata xxx/xxx-xxx!\\n");
				f5=true;
			}
		}
		
		email=AddStudentDialog.txtEmail.getText();
		if(!email.matches("[A-Za-z0-9.]+[A-Za-z0-9.]+@[A-Za-z.]+[A-Za-z.]+")) {
			if(f1==false && f2==false && f3==false && f4==false && f6==false && f7==false && f8==false && f10==false && f5==false) {
				JOptionPane.showMessageDialog(null,"Email uneti sa obaveznim znakom @!");
				f9=true;
			}
		}
		
		
		indeks=AddStudentDialog.txtIndeks.getText();
		if(!(indeks.matches("[A-Za-z]{2}-[0-9]{0,3}-20[0,1][0-9]"))){
			if(f1==false && f3==false && f4==false && f5==false && f6==false && f7==false && f8==false && f9==false  && f10==false) {
				JOptionPane.showMessageDialog(null,"Indeks unositi u formatu xx-bbb-yyyy!\n");
				f2=true;
			}
		}
		
		ArrayList<Student> listaStudenata = BazaStudenata.getInstance().getStudenti();
		for(Student s:listaStudenata) {
			if(indeks.equals(s.getBrIndeksa())) {
					f7=true;
					break;
				}
		}
		if(f1==false && f2==false && f3==false && f4==false && f5==false && f6==false && f7==true  && f8==false && f9==false && f10==false) {
			JOptionPane.showMessageDialog(null,"Broj indeksa već postoji!\n");
		}
		
		
		try{
			godUpisa = Integer.parseInt(AddStudentDialog.txtGodUpisa.getText());
		} catch(NumberFormatException ex){ 
		}
		
		int god=0;
		godStudija=AddStudentDialog.cbGodStudija.getSelectedItem().toString();
		if(godStudija.equals("I (prva)")) {
			god=1;
		}else if(godStudija.equals("II (druga)")) {
			god=2;
		}else if(godStudija.equals("III (treća)")) {
			god=3;
		}else if(godStudija.equals("IV (četvrta)")) {
			god=4;
		}
		
		
		if(AddStudentDialog.cbStatus.getSelectedItem().toString() == "Budžet" )
			status = STATUS.B;
		else
			status = STATUS.S;
		
		
		
	
		if( indeks.equals("") || ime.equals("") || prz.equals("") || adresa.equals("") || tel.equals("")
		|| email.equals("") || god==0 ) {
				if(f2==false && f3==false && f1==false && f4==false && f5==false && f6==false && f7==false && f8==false && f9==false && f10==false)
					JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!");
		}else if(f1==false && f2==false && f3==false && f4==false && f5==false && f6==false && f7==false && f8==false && f9==false && f10==false) {
			StudentController.getInstance().dodajStudenta(ime, prz, dat, adresa, tel, email, indeks, godUpisa, god, status);
			int  exit = JOptionPane.showConfirmDialog(null, "Student dodat" , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION){
				ActionListenerAdd.dialogStd.setVisible(false);			
			}
		}
	}

}
