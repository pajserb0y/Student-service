package controller;

import java.util.ArrayList;
import java.util.Date;

import view.TabbedPane;
import model.BazaStudenata;
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
			String email, String indeks, int godinaUpisa, int trenutnaGodina, STATUS status) {
	
		BazaStudenata.getInstance().dodajStudenta(ime, prezime, datum, adresa, telefon, email, indeks, godinaUpisa, trenutnaGodina, status);
		TabbedPane.getInstance().azurirajPrikaz(null, -1);
	}
}
