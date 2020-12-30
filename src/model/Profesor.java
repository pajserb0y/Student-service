package model;

import java.util.ArrayList;
import java.util.Date;

public class Profesor extends Osoba {
	private String adresaKanc;
	private String titula;
	private String zvanje;
	private ArrayList<Predmet> listaPredmeta = new ArrayList<Predmet>();

	public Profesor(String ime, String prezime, Date datRodj, String adresaStan, String telefon,
			String email, String adresaKanc, String brLicne, String titula, String zvanje, ArrayList<Predmet> listaPredmeta) {
		super(ime, prezime, datRodj, adresaStan, brLicne, telefon, email);
		this.adresaKanc = adresaKanc;
		this.titula = titula;
		this.zvanje = zvanje;
		this.listaPredmeta = listaPredmeta;
	}

	public String getAdresaKanc() {
		return adresaKanc;
	}

	public void setAdresaKanc(String adresaKanc) {
		this.adresaKanc = adresaKanc;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<Predmet> getSpisakPredmeta() {
		return listaPredmeta;
	}

	public void setSpisakPredmeta(ArrayList<Predmet> spisakPredmeta) {
		this.listaPredmeta = spisakPredmeta;
	}
	
	
}
