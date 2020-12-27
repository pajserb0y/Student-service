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
		int godUpisa = 0;
		String adresa="";
		String tel="";
		String email="";
		String indeks="";
		String godStudija="I (prva)";
		STATUS status = STATUS.B;
		
		boolean flag1=false;
		boolean flag2=false;
		boolean flag3=false;
		boolean flag4=false;
		boolean flag5=false;
		boolean flag6=false;
		boolean flag7=false;
		boolean flag8=false;
		boolean flag9=false;
		boolean flag10=false;

		
		
		ime=AddStudentDialog.txtIme.getText();
		prz=AddStudentDialog.txtPrz.getText();	

		if(!ime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") ) {
			if(flag1==false && flag2==false && flag3==false && flag4==false && flag5==false && flag6==false && flag7==false  && flag8==false && flag9==false) {
				JOptionPane.showMessageDialog(null,"Ime i prezime treba da se sastoje samo od slova!\n");
				flag10=true;
			}
		}

		if(!prz.matches("[A-Za-zšđžćčŠĐŽČĆ]+") ) {
			if(flag1==false && flag2==false && flag3==false && flag4==false && flag5==false && flag6==false && flag7==false  && flag8==false && flag9==false && flag10==false) {
				JOptionPane.showMessageDialog(null,"Ime i prezime treba da se sastoje samo od slova!\n");
				flag10=true;
			}
		}
		
		
		SimpleDateFormat format= new SimpleDateFormat("dd.mm.yyyy");		
		
		try {
			dat=format.parse(AddStudentDialog.txtDat.getText());
			
			String datRS = null;
			datRS=format.format(dat);
			
			String[] tokens1=datRS.split("/");
			
		} catch(ParseException e1) {
			if(flag2==false && flag1==false && flag4==false && flag5==false && flag6==false && flag7==false  && flag8==false && flag9==false && flag10==false) {
				JOptionPane.showMessageDialog(null,"Obavezno popuniti sva polja! \n"  
												+ " \t NAPOMENA: Datum uneti u formatu dd.mm.yyyy!\n");
				flag3=true;
			}
		}
		
		
		adresa=AddStudentDialog.txtAdresa.getText();
		
		
		tel=AddStudentDialog.txtTel.getText();
		if(!tel.matches("[0-9]{3}/[0-9]{3,4}-[0-9]{3,4}") ) {
			if(flag1==false && flag2==false && flag3==false && flag4==false && flag6==false && flag7==false && flag8==false && flag9==false && flag10==false) {
				JOptionPane.showMessageDialog(null,"Telefon unositi kao niz brojeva formata xxx/xxx-xxx!\\n");
				flag5=true;
			}
		}
		
		email=AddStudentDialog.txtEmail.getText();
		if(!email.matches("[A-Za-z0-9.]+[A-Za-z0-9.]+@[A-Za-z.]+[A-Za-z.]+")) {
			if(flag1==false && flag2==false && flag3==false && flag4==false && flag6==false && flag7==false && flag8==false && flag10==false && flag5==false) {
				JOptionPane.showMessageDialog(null,"Email uneti sa obaveznim znakom @!");
				flag9=true;
			}
		}
		
		
		indeks=AddStudentDialog.txtIndeks.getText();
		if(!(indeks.matches("[A-Za-z]{2}-[0-9]{1,3}-20[0,1][0-9]"))){
			if(flag1==false && flag3==false && flag4==false && flag5==false && flag6==false && flag7==false && flag8==false && flag9==false  && flag10==false) {
				JOptionPane.showMessageDialog(null,"Indeks unositi u formatu xx-bb-yyyy!\n");
				flag2=true;
			}
		}
		
		ArrayList<Student> listaStudenata = BazaStudenata.getInstance().getStudenti();
		for(Student s:listaStudenata) {
			if(indeks.equals(s.getBrIndeksa())) {
					flag7=true;
					break;
				}
		}
		if(flag1==false && flag2==false && flag3==false && flag4==false && flag5==false && flag6==false && flag7==true  && flag8==false && flag9==false && flag10==false) {
			JOptionPane.showMessageDialog(null,"Broj indeksa već postoji!\n");
		}
		
		
		//godUpisa = AddStudentDialog.txtGodUpisa.getText();
		
		
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
		
		
		
		//status = AddStudentDialog.cbStatus.getSelectedItem().toString();
		
		
//		if(status.equals("Budžet")) {
//			god=1;
//		}else if(status.equals("Samofinansiranje")) {
//			god=2;
		
		
//		if(god==1) {
//			prosek=0.0;
//		}else {
//			try {
//				prosek=Double.parseDouble(DialogAddStudent.txtProsek.getText());
//					if(prosek>10 || prosek <6) {
//						if(flag2==false && flag1==false && flag4==false && flag5==false && flag3==false && flag7==false && flag8==false  && flag9==false && flag10==false) {
//							JOptionPane.showMessageDialog(null,"Prosek moze biti u intervalu 6-10.");
//							flag6=true;
//							}
//						}
//			
//			} catch (NumberFormatException e1) {
//				if(flag2==false && flag3==false && flag4==false  && flag5==false && flag6==false && flag7==false && flag8==false && flag9==false && flag10==false) {
//					JOptionPane.showMessageDialog(null," Obavezno je popunjavanje svih polja! \n"
//							+ "\t NAPOMENA:Prosek unositi isključivo kao broj.");
//					flag1=true;
//				}
//			}
//		}
//		
//		
//		ArrayList<String> predmeti=new ArrayList<String>();
//	
//		if( indeks.equals("") || ime.equals("") || prz.equals("") || adresa.equals("") || tel.equals("")
//		|| email.equals("") || god==0 || (b==false && s==false) ) {
//				if(flag2==false && flag3==false && flag1==false && flag4==false && flag5==false && flag6==false && flag7==false && flag8==false && flag9==false && flag10==false)
//					JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!");
//		}else if(flag1==false && flag2==false && flag3==false && flag4==false && flag5==false && flag6==false && flag7==false && flag8==false && flag9==false && flag10==false) {
//			StudentController.getInstance().dodajStudenta(indeks, ime, prezime, datum, adresa, telefon, email,datumUpisa, god, sts, prosek,predmeti);
//			int  exit = JOptionPane.showConfirmDialog(null, "Student dodat" , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
//			if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION){
//				ActionListenerAdd.dialogSt.setVisible(false);			
//			}
//		
//		}
	}

}
