package view.predmet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.PredmetController;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import view.ActionListenerAdd;

public class ActionListenerAddPred implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String sifra  = "";
		String naziv = "";
		String profesor = null;
		int espb = 0;
		int semestar = 0;
		int god = 0;
		boolean f = false;
		
		sifra = AddPredmetDialog.txtSif.getText();
		naziv = AddPredmetDialog.txtNaz.getText();
		profesor = AddPredmetDialog.txtProf.getText();
		String espbString = AddPredmetDialog.txtEspb.getText();
		String semestarString = AddPredmetDialog.semest.getSelectedItem().toString();
		String godString = AddPredmetDialog.godStud.getSelectedItem().toString();
		
		
		if(!sifra.matches("[A-Z0-9]+")) {
			JOptionPane.showMessageDialog(null,"Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Šifra mora biti sastojana od velikih slova i brojeva!");
			return;
		}  
		
		ArrayList<Predmet> bazaPredmeta = BazaPredmeta.getInstance().getPredmeti();
		for(Predmet p : bazaPredmeta) {
			if(p.getSifraPred().equals(sifra)) {
				JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!\n"
						+ "\tNAPOMENA: Šifra predmeta već postoji u bazi predmeta!");
				return;
			}
		}
		
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
		
		if (!profesor.matches("[0-9]+") || profesor.length() != 9) {
				JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!\n"
						+ "\tNAPOMENA: Broj lične karte profesora treba da ima tačno 9 cifara!");
				return;
		}
		
		ArrayList<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
		for(Profesor p : profesori)
			if(profesor.equals(p.getBrLicne()))
			{
				f = true;
				break;
			}
		if(f != true) {
			JOptionPane.showMessageDialog(null, "Obavezno je popunjavanje svih polja!\n"
					+ "\tNAPOMENA: Broj lične karte profesora ne postoji u bazi profesora!");
			return;
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
		
		if (semestarString.equals("Zimski")) {
			if(god == 1) {
				semestar = 1;
			}else if(god == 2) {
				semestar = 3;
			}else if(god == 3) {
				semestar = 5;
			}else {
				semestar = 7;
			}
		}else if (semestarString.equals("Letnji")) {
			semestar = 2 * god;
		}
		
		if (sifra.equals("") || naziv.equals("") || espbString.equals("") || profesor.equals("")) {
				JOptionPane.showMessageDialog(null, "\"Obavezno je popunjavanje svih polja!");
				return;
		}
//		else{
//			PredmetController.getInstance().dodajPredmet(sifra, naziv, god, semestar, profesor, espb, new ArrayList<String>(), new ArrayList<String>());
//			int  exit = JOptionPane.showConfirmDialog(null, "Predmet dodat" , null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
//			if (exit == JOptionPane.YES_OPTION || exit == JOptionPane.CANCEL_OPTION || exit==JOptionPane.CLOSED_OPTION)
//				ActionListenerAdd.dialogPred.setVisible(false);	
//		}
	}
}
