package model;

import java.util.ArrayList;
import java.util.Date;

enum STATUS {B, S}; //budzet i samofinansiranje

public class Student extends Osoba {

	private String brIndeksa;
	private int godUpisa;
	private int trenutnaGodStudija;
	private STATUS status;
	private double prosek;
	private ArrayList<String> spisakPolIspitaISpisakOcena;
	private ArrayList<String> spisakNepolIspita;
	
	
	public Student(String ime, String prezime, Date datRodj, String adresaStan,
			String brLicne, String telefon, String email, String brIndeksa,
			int godUpisa, int trenutnaGodStudija, STATUS status, double prosek,
			ArrayList<String> spisakPolIspitaISpisakOcena,
			ArrayList<String> spisakNepolIspita) {
		super(ime, prezime, datRodj, adresaStan, brLicne, telefon, email);
		this.brIndeksa = brIndeksa;
		this.godUpisa = godUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.status = status;
		this.prosek = prosek;
		this.spisakPolIspitaISpisakOcena = spisakPolIspitaISpisakOcena;
		this.spisakNepolIspita = spisakNepolIspita;
	}
	
	public Student(String brIndeksa, String ime, String prezime, int trenutnaGodStudija, STATUS status, double prosek) {
		super(ime, prezime);
		this.brIndeksa = brIndeksa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.status = status;
		this.prosek = prosek;
	}

	public String getBrIndeksa() {
		return brIndeksa;
	}


	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}


	public int getGodUpisa() {
		return godUpisa;
	}


	public void setGodUpisa(int godUpisa) {
		this.godUpisa = godUpisa;
	}


	public int getTrenutnaGodStudija() {
		return trenutnaGodStudija;
	}


	public void setTrenutnaGodStudija(int trenutnaGodStudija) {
		this.trenutnaGodStudija = trenutnaGodStudija;
	}


	public STATUS getStatus() {
		return status;
	}


	public void setStatus(STATUS status) {
		this.status = status;
	}


	public double getProsek() {
		return prosek;
	}


	public void setProsek(double prosek) {
		this.prosek = prosek;
	}


	public ArrayList<String> getSpisakPolIspitaISpisakOcena() {
		return spisakPolIspitaISpisakOcena;
	}


	public void setSpisakPolIspitaISpisakOcena(
			ArrayList<String> spisakPolIspitaISpisakOcena) {
		this.spisakPolIspitaISpisakOcena = spisakPolIspitaISpisakOcena;
	}


	public ArrayList<String> getSpisakNepolIspita() {
		return spisakNepolIspita;
	}


	public void setSpisakNepolIspita(ArrayList<String> spisakNepolIspita) {
		this.spisakNepolIspita = spisakNepolIspita;
	}

	
}
