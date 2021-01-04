package controller;

import java.util.ArrayList;
import java.util.Date;

import view.TabbedPane;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;
import model.Student.STATUS;



public class StudentController {

	private static StudentController instance = null;

	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public void dodajStudenta(String ime, String prezime, Date datum, String adresa, String telefon,
			String email, String indeks, int godinaUpisa, int trenutnaGodina, STATUS status, double prosek, 
			ArrayList<Predmet> spisakPolIspitaISpisakOcena, ArrayList<Predmet> spisakNepolIspita) {
	
		BazaStudenata.getInstance().dodajStudenta(ime, prezime, datum, adresa, telefon, email, indeks, godinaUpisa, trenutnaGodina, status, prosek, 
				spisakPolIspitaISpisakOcena, spisakNepolIspita);
		TabbedPane.azurirajPrikaz("DODAT", -1);
	}

	public void izmeniStudenta(String stariIndeks, String ime, String prezime, Date datum, String adresa,
			String telefon, String email, String indeks, int godinaUpisa, int trenutnaGodina, STATUS status, double prosek,
			ArrayList<Predmet> spisakPolIspitaISpisakOcena, ArrayList<Predmet> spisakNepolIspita) {
		
		ArrayList<Predmet> predmetiPom = BazaPredmeta.getInstance().getPredmeti();
		for(Predmet predmet : predmetiPom)
			if(predmet.getStudentiPolozili() != null)
				for(Student s : predmet.getStudentiPolozili())
					if(stariIndeks.equals(s.getBrIndeksa())) 
					{						
						s.setIme(ime);
						s.setPrezime(prezime);
						s.setDatRodj(datum);
						s.setAdresaStan(adresa);
						s.setTelefon(telefon);
						s.setEmail(email);
						s.setBrIndeksa(indeks);
						s.setGodUpisa(godinaUpisa);
						s.setTrenutnaGodStudija(trenutnaGodina);
						s.setStatus(status);
						s.setProsek(prosek);  
						s.setSpisakPolIspitaISpisakOcena(spisakPolIspitaISpisakOcena);
						s.setSpisakNepolIspita(spisakNepolIspita);
					}
		for(Predmet predmet : predmetiPom)
			if(predmet.getStudentiNisuPolozili() != null)
				for(Student s : predmet.getStudentiNisuPolozili())
					if(stariIndeks.equals(s.getBrIndeksa())) 
					{						
						s.setIme(ime);
						s.setPrezime(prezime);
						s.setDatRodj(datum);
						s.setAdresaStan(adresa);
						s.setTelefon(telefon);
						s.setEmail(email);
						s.setBrIndeksa(indeks);
						s.setGodUpisa(godinaUpisa);
						s.setTrenutnaGodStudija(trenutnaGodina);
						s.setStatus(status);
						s.setProsek(prosek);  
						s.setSpisakPolIspitaISpisakOcena(spisakPolIspitaISpisakOcena);
						s.setSpisakNepolIspita(spisakNepolIspita);
					}
		
		BazaStudenata.getInstance().izmeniStudenta(stariIndeks, ime, prezime, datum, adresa, telefon, email, indeks, godinaUpisa, trenutnaGodina, status, prosek, 
				spisakPolIspitaISpisakOcena, spisakNepolIspita);
		TabbedPane.azurirajPrikaz("IZMENJEN", -1);
	}

	public void izbrisiStudenta(String brIndeksa) {
		BazaStudenata.getInstance().izbrisiStudenta(brIndeksa);
		TabbedPane.azurirajPrikaz("IZBRISAN", -1);
	}

}
