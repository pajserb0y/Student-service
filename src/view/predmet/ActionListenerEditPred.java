package view.predmet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.ActionListenerEdit;
import view.TabbedPane;
import controller.PredmetController;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Profesor;
import model.Student;

public class ActionListenerEditPred implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String sifra  = "";
		String naziv = "";
		Profesor profesor = null;
		int espb = 0;
		String semestar = "";
		int god = 0;
		ArrayList<Student> studentiPolozili = null;
		ArrayList<Student> studentiNisuPolozili = null;
		
		int rowView = TabbedPane.tabelaPredmeta.getSelectedRow();
		int rowModel = TabbedPane.tabelaPredmeta.convertRowIndexToModel(rowView);
		String staraSifra = BazaPredmeta.getInstance().getRow(rowModel).getSifraPred();
		
		
		sifra = EditPredmetDialog.txtSif.getText();
		naziv = EditPredmetDialog.txtNaz.getText();
		String espbString = EditPredmetDialog.txtEspb.getText();
		semestar = EditPredmetDialog.semest.getSelectedItem().toString();
		god = (int) EditPredmetDialog.godStud.getSelectedItem();
		
		
		
		if(!sifra.matches("[A-Z0-9]+")) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Šifra mora biti sastojana od velikih slova i brojeva!");
			return;
		}  
		
//		ArrayList<Predmet> bazaPredmeta = BazaPredmeta.getInstance().getPredmeti();
//		for(Predmet p : bazaPredmeta) {
//			if(p.getSifraPred().equals(sifra)) {
//				JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!\n"
//						+ "\tNAPOMENA: Šifra predmeta već postoji u bazi predmeta!");
//				return;
//			}
//		}
		
		if(!espbString.matches("[0-9]+") || espbString.length() > 2) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: ESP bodovi su jednocifren ili dvocifren broj!");
			return;
		} 
		try {
			espb = Integer.parseInt(espbString);
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
		}

		
		
		
		
		ArrayList<Profesor> bazaProfesora = BazaProfesora.getInstance().getProfesori();
		for(Profesor p : bazaProfesora) 
			if(EditProfToPredDialog.getDodatProfesor() != null)
				if(p.getBrLicne().equals(EditProfToPredDialog.getDodatProfesor().getBrLicne())) 
					profesor = p;


		
		if (sifra.equals("") || naziv.equals("") || espbString.equals("")) {
				JOptionPane.showMessageDialog(null, "\"Obavezno je popunjavanje svih polja!");
				return;
		}
		else{
			PredmetController.getInstance().izmeniPredmet(staraSifra, sifra, naziv, god, semestar, profesor, espb, studentiPolozili, studentiNisuPolozili);
			int  exit = JOptionPane.showConfirmDialog(null, "Predmet izmenjen" , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION)
				ActionListenerEdit.dialogPred.setVisible(false);	
		}
		
	}
}