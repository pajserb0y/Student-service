package controller;

import java.util.ArrayList;
import java.util.Date;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import view.TabbedPane;

public class ProfesorController {
	
	private static ProfesorController instance = null;
	
	private ProfesorController() {}
	
	public static ProfesorController getInstance()
	{
		if(instance == null)
			instance = new ProfesorController();
		return instance;
	}
	
	public void dodajProfesora(String ime, String prezime, Date datumRodjenja, String adresa,String telefon,
			String email,String adresaK,String brLicne, String titula,String zvanje, ArrayList<Predmet> predmeti)
	{
		BazaProfesora.getInstance().dodajProfesora(ime, prezime, datumRodjenja, adresa, telefon, 
				email, adresaK, brLicne, titula, zvanje, predmeti);
		TabbedPane.azurirajPrikaz("DODAT", -1);
	}

	public void izmeniProfesora(String staraLk, String ime, String prezime, Date datumRodjenja, String adresa,String telefon,
			String email,String adresaK,String brLicne, String titula,String zvanje, ArrayList<Predmet> predmeti) {
		
			ArrayList<Predmet> predmetiPom = BazaPredmeta.getInstance().getPredmeti();
			
			for(Predmet predmet : predmetiPom)
			{
				if(predmet.getProfesor() != null)
					if(staraLk.equals(predmet.getProfesor().getBrLicne())) {
						predmet.setProfesor(new Profesor(ime, prezime, datumRodjenja, adresa, telefon, email, 
								adresaK, brLicne, titula, zvanje, predmeti));
					}
			}
			
		BazaProfesora.getInstance().izmeniProfesora(staraLk ,ime, prezime, datumRodjenja, adresa, telefon, 
				email, adresaK, brLicne, titula, zvanje, predmeti);
		TabbedPane.azurirajPrikaz("IZMENA", -1);
			
	}

	public void izbrisiProfesora(String brLicne) {
		BazaProfesora.getInstance().izbrisiProfesora(brLicne);
		TabbedPane.azurirajPrikaz("IZBRISAN", -1);
	}

	public void pretraziProfesora(String ime, String prezime) {
		// TODO Auto-generated method stub
		BazaProfesora.getInstance().pretraziProfesora(ime,prezime);
	}
}
