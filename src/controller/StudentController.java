package controller;

import java.util.ArrayList;
import java.util.Date;

import view.TabbedPane;
import model.BazaStudenata;
import model.Predmet;
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
		
		
		BazaStudenata.getInstance().izmeniStudenta(stariIndeks, ime, prezime, datum, adresa, telefon, email, indeks, godinaUpisa, trenutnaGodina, status, prosek, 
				spisakPolIspitaISpisakOcena, spisakNepolIspita);
		TabbedPane.azurirajPrikaz("IZMENJEN", -1);
	}

	public void izbrisiStudenta(String brIndeksa) {
		BazaStudenata.getInstance().izbrisiStudenta(brIndeksa);
		TabbedPane.azurirajPrikaz("IZBRISAN", -1);
	}

}
