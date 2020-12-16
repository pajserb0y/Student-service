package model;

import java.util.ArrayList;
import java.util.Date;

public class Profesor extends Osoba {
	private String adresaKanc;
	private String titula;
	private String zvanje;
	private ArrayList<String> spisakPredmeta = new ArrayList<String>();

	public Profesor(String ime, String prezime, Date datRodj, String adresaStan, String brLicne, String telefon,
			String email, String adresaKanc, String titula, String zvanje, ArrayList<String> spisakPredmeta) {
		super(ime, prezime, datRodj, adresaStan, brLicne, telefon, email);
		this.adresaKanc = adresaKanc;
		this.titula = titula;
		this.zvanje = zvanje;
		this.spisakPredmeta = spisakPredmeta;
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

	public ArrayList<String> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(ArrayList<String> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
	
	
}
