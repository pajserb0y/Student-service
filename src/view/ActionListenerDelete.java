package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.PredmetController;
import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import model.Student;

public class ActionListenerDelete implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = TabbedPane.getInstance().getSelectedIndex();
		if(index == 2) //ti iznad stavi if-ove koji ti trebaju 
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
