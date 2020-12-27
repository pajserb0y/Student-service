package controller;

import java.util.ArrayList;
import java.util.Date;

import model.BazaProfesora;
import view.TabbedPane;

public class ProfesorController {
	
	private static ProfesorController instance = null;
	
	private ProfesorController() {}
	
	public ProfesorController getInstance()
	{
		if(instance == null)
			instance = new ProfesorController();
		return instance;
	}
	
	public void dodajProfesora(String ime, String prezime, Date datumRodjenja, String adresa,String telefon,
			String email,String adresaK,String brLicne, String titula,String zvanje, ArrayList<String> predmeti)
	{
		BazaProfesora.getInstance().dodajProfesora(ime, prezime, datumRodjenja, adresa, telefon, email, adresaK, brLicne, titula, zvanje, predmeti);
		TabbedPane.azurirajPrikaz("DODAT", -1);
	}
}
