package view.predmet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.ActionListenerAdd;
import controller.PredmetController;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class ActionListenerEditPred implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String sifra  = "";
		String naziv = "";
		Profesor profesor = null;
		int espb = 0;
		String semestar = "";
		int god = 0;
		
		
		sifra = EditPredmetDialog.txtSif.getText();
		naziv = EditPredmetDialog.txtNaz.getText();
		String espbString = EditPredmetDialog.txtEspb.getText();
		semestar = EditPredmetDialog.semest.getSelectedItem().toString();
		String godString = EditPredmetDialog.godStud.getSelectedItem().toString();
		
		
		
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

		
		if (godString.equals("Prva")) {
			god = 1;
		}else if(godString.equals("Druga")) {
			god = 2;
		}else if(godString.equals("Treća")) {
			god = 3;
		}else if(godString.equals("Četvrta")) {
			god = 4;
		}
		
		
		ArrayList<Profesor> bazaProfesora = BazaProfesora.getInstance().getProfesori();
		for(Profesor p : bazaProfesora) {
			if(AddProfToPredDialog.getDodatProfesor() != null)
				if(p.getBrLicne().equals(AddProfToPredDialog.getDodatProfesor().getBrLicne())) {
					profesor = p;
					return;
				}
		}

		
		if (sifra.equals("") || naziv.equals("") || espbString.equals("")) {
				JOptionPane.showMessageDialog(null, "\"Obavezno je popunjavanje svih polja!");
				return;
		}
		else{
			PredmetController.getInstance().izmeniPredmet(sifra, naziv, god, semestar, profesor, espb, null, null);
			int  exit = JOptionPane.showConfirmDialog(null, "Predmet dodat" , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION)
				ActionListenerAdd.dialogPred.setVisible(false);	
		}
		
	}
}