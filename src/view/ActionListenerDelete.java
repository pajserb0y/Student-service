package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.PredmetController;
import controller.StudentController;
import model.BazaPredmeta;
import model.BazaStudenata;
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
				
					ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
					ArrayList<Student> studenti = new ArrayList<Student>();
				
					for(Predmet p : predmeti)
						if(p.getStudentiPolozili() != null)
							for(Student s : p.getStudentiPolozili())
								if(student.getBrIndeksa().equals(s.getBrIndeksa())) 
									p.getStudentiPolozili().remove(s);
					
					for(Predmet p : predmeti)
						if(p.getStudentiNisuPolozili() != null)
							for(Student s : p.getStudentiNisuPolozili())
								if(student.getBrIndeksa().equals(s.getBrIndeksa())) 
									p.getStudentiNisuPolozili().remove(s);

					
					StudentController.getInstance().izbrisiStudenta(student.getBrIndeksa());
					JOptionPane.showMessageDialog(null, "Student obrisan");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Morate selektovati studenta pre izmene!");
			}
		}
		
		else if(index == 1)
		{
			
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
				
					ArrayList<Profesor> profesori = new ArrayList<Profesor>();
					ArrayList<Student> studenti = new ArrayList<Student>();
				
					for(Profesor prof : profesori){
						if(prof.getSpisakPredmeta() != null)
							for(Predmet pred : prof.getSpisakPredmeta()){
								if(predmet.getSifraPred().equals(pred.getSifraPred())) {
									prof.getSpisakPredmeta().remove(pred);
								}
							}
					}
					for(Student s : studenti) {
						if(s.getSpisakNepolIspita() != null)
							for(Predmet pred : s.getSpisakNepolIspita()) {
								if(predmet.getSifraPred().equals(pred.getSifraPred())) {
									s.getSpisakNepolIspita().remove(pred);
								}
							}
					}
					
					for(Student s : studenti) {
						if(s.getSpisakPolIspitaISpisakOcena() != null)
							for(Predmet pred : s.getSpisakPolIspitaISpisakOcena()) {
								if(predmet.getSifraPred().equals(pred.getSifraPred())) {
									s.getSpisakPolIspitaISpisakOcena().remove(pred);
								}
							}
					}
					
					PredmetController.getInstance().izbrisiPredmet(predmet.getSifraPred());
					JOptionPane.showMessageDialog(null, "Predmet obrisan");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Morate selektovati predmet pre izmene!");
			}
		}
	}
}
