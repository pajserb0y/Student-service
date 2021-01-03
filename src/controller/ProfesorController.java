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
		
			ArrayList<Predmet> spisakPredmeta = null; //predmeti koje nalaze kod profesora sa starom licnom kartom(ostace sacuvati tj prebaceni kod ovog sa novom)
			ArrayList<Predmet> predmetiPom = BazaPredmeta.getInstance().getPredmeti();
			
			for(Predmet predmet : predmetiPom)
			{
				if(predmet.getProfesor() != null)
					if(staraLk.equals(predmet.getProfesor().getBrLicne())) {
						 spisakPredmeta = predmet.getProfesor().getSpisakPredmeta();//sacuvacemo stari spisak predmeta pre prmene profesora jer
																								      //u ovom momentu promene spisaka jos nisu moguce
						predmet.setProfesor(new Profesor(ime, prezime, datumRodjenja, adresa, telefon, email, adresaK, brLicne, titula, zvanje, spisakPredmeta));
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
}
