package model;

import java.util.ArrayList;
import java.util.Date;

public class Student extends Osoba {

	private String brIndeksa;
	private int godUpisa;
	private int trenutnaGodStudija;
	private enum Status {B, S} //budzet i samofinansiranje
	private Status status;
	private double prosek;
	private ArrayList<String> spisakPolIspitaISpisakOcena;
	private ArrayList<String> spisakNepolIspita;
	
	
	public Student(String ime, String prezime, Date datRodj, String adresaStan,
			String brLicne, String telefon, String email, String brIndeksa,
			int godUpisa, int trenutnaGodStudija, Status status, double prosek,
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


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
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
