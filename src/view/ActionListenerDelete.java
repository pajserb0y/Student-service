package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import view.predmet.EditPredmetDialog;
import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;

public class ActionListenerDelete implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = TabbedPane.getInstance().getSelectedIndex();
		
		if(index == 0)
		{
			int rowView = TabbedPane.tabelaStudenata.getSelectedRow();
			if(rowView != -1) {
				
				int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowView);
				Student student = BazaStudenata.getInstance().getRow(rowModel);
				
				int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete studenta?", "Obriši studenta", JOptionPane.YES_NO_OPTION);
				if (izbor == JOptionPane.YES_OPTION) {
				
					ArrayList<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
                    ArrayList<Ocena> ocene = new ArrayList<>(BazaOcena.getInstance().getOcene());//DODATO
                    ArrayList<Ocena> oceneBris = BazaOcena.getInstance().getOcene();//DODATO

				
					for(Predmet p : predmeti)
						if(p.getStudentiPolozili() != null)
							for(Student s : p.getStudentiPolozili())
								if(student.getBrIndeksa().equals(s.getBrIndeksa())) {
									p.getStudentiPolozili().remove(s);
									break;
								}
					
					for(Predmet p : predmeti)
						if(p.getStudentiNisuPolozili() != null)
							for(Student s : p.getStudentiNisuPolozili())
								if(student.getBrIndeksa().equals(s.getBrIndeksa())){
									p.getStudentiNisuPolozili().remove(s);
									break;
								}
					
					 if(ocene != null)             //DODATA FOR PETLJA
	                        for(Ocena o : ocene)
	                            if(o.getStudent().getBrIndeksa().equals(student.getBrIndeksa())){ //IZMENJENO
	                                oceneBris.remove(o);
	                            }
					
					
					StudentController.getInstance().izbrisiStudenta(student.getBrIndeksa());
					JOptionPane.showMessageDialog(null, "Student obrisan!");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Morate selektovati studenta pre izmene!");
			}
		}
		
		else if(index == 1)
		{
			int rowView = TabbedPane.tabelaProfesora.getSelectedRow();
			if(rowView != -1) {
				
				int rowModel = TabbedPane.tabelaProfesora.convertRowIndexToModel(rowView);
				Profesor profesor = BazaProfesora.getInstance().getRow(rowModel);
				
				int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete profesora?",
						"Obriši profesora", JOptionPane.YES_NO_OPTION);
				if (izbor == JOptionPane.YES_OPTION) {
				
					ArrayList<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
				
					for(Predmet pred : predmeti)
						if(pred.getProfesor() != null)
							if(profesor.getBrLicne().equals(pred.getProfesor().getBrLicne())) {
								pred.setProfesor(null);
							}
						
					ProfesorController.getInstance().izbrisiProfesora(profesor.getBrLicne());
					JOptionPane.showMessageDialog(null, "Profesor obrisan!");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Morate selektovati predmet pre izmene!");
			}
		}
		
		else if(index == 2)
		{
			int rowView = TabbedPane.tabelaPredmeta.getSelectedRow();
			if(rowView != -1) {
				
				int rowModel = TabbedPane.tabelaPredmeta.convertRowIndexToModel(rowView);
				Predmet predmet = BazaPredmeta.getInstance().getRow(rowModel);
				
				int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete predmet?",
						"Obriši predmet", JOptionPane.YES_NO_OPTION);
				if (izbor == JOptionPane.YES_OPTION) {
				
					ArrayList<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
					ArrayList<Student> studenti = BazaStudenata.getInstance().getStudenti();
                    ArrayList<Ocena> ocene = new ArrayList<>(BazaOcena.getInstance().getOcene()); //NAPRAVLJENA BAS KOPIJA ZA PROLAZAK
                    ArrayList<Ocena> oceneBris = BazaOcena.getInstance().getOcene(); //OVO JE ZA BRISANJE
				
					for(Profesor prof : profesori){
						if(prof.getSpisakPredmeta() != null)
							for(Predmet pred : prof.getSpisakPredmeta()){
								if(predmet.getSifraPred().equals(pred.getSifraPred())) {
									prof.getSpisakPredmeta().remove(pred);
									break;
								}
							}
					}
					for(Student s : studenti) {
						if(s.getSpisakNepolIspita() != null)
							for(Predmet pred : s.getSpisakNepolIspita()) {
								if(predmet.getSifraPred().equals(pred.getSifraPred())) {
									s.getSpisakNepolIspita().remove(pred);
									break;
								}
							}
					}
					
					for(Student s : studenti) {
						if(s.getSpisakPolIspitaISpisakOcena() != null)
							for(Predmet pred : s.getSpisakPolIspitaISpisakOcena()) {
								if(predmet.getSifraPred().equals(pred.getSifraPred())) {
									s.getSpisakPolIspitaISpisakOcena().remove(pred);
									break;
								}
							}
					}
					
                    if(ocene != null)
                        for(Ocena o : ocene)
                            if(o.getPredmet().getSifraPred().equals(predmet.getSifraPred())){
                                oceneBris.remove(o);            //PROMENJENO U OCENEBRIS
                            }                            //OBRSIAN BREAK;
					
					
					PredmetController.getInstance().izbrisiPredmet(predmet.getSifraPred());
					JOptionPane.showMessageDialog(null, "Predmet obrisan!");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Morate selektovati predmet pre izmene!");
			}
		}
	}
}
