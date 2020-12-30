package model;

import java.util.ArrayList;
import java.util.Date;

//enum STATUS {B, S}; //budzet i samofinansiranje

public class Student extends Osoba {

	private String brIndeksa;
	private int godUpisa;
	private int trenutnaGodStudija;
	public enum STATUS {B,S};
	private STATUS status;
	private double prosek;
	private ArrayList<Predmet> spisakPolIspitaISpisakOcena;
	private ArrayList<Predmet> spisakNepolIspita;
	
	
	public Student(String ime, String prezime, Date datRodj, String adresaStan,
			String telefon, String email, String brIndeksa,
			int godUpisa, int trenutnaGodStudija, STATUS status, double prosek,
			ArrayList<Predmet> spisakPolIspitaISpisakOcena,
			ArrayList<Predmet> spisakNepolIspita) {
		super(ime, prezime, datRodj, adresaStan, telefon, email);
		this.brIndeksa = brIndeksa;
		this.godUpisa = godUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.status = status;
		this.prosek = prosek;
		this.spisakPolIspitaISpisakOcena = spisakPolIspitaISpisakOcena;
		this.spisakNepolIspita = spisakNepolIspita;
	}
	

	
	public Object toCell(int column) {
		switch(column) {
		case 0: return getBrIndeksa();
		case 1: return getIme();
		case 2: return getPrezime();
		case 3: return getTrenutnaGodStudija();
		case 4: return getStatus();
		case 5: return getProsek();
		default: return null;
		}
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


	public ArrayList<Predmet> getSpisakPolIspitaISpisakOcena() {
		return spisakPolIspitaISpisakOcena;
	}


	public void setSpisakPolIspitaISpisakOcena(
			ArrayList<Predmet> spisakPolIspitaISpisakOcena) {
		this.spisakPolIspitaISpisakOcena = spisakPolIspitaISpisakOcena;
	}


	public ArrayList<Predmet> getSpisakNepolIspita() {
		return spisakNepolIspita;
	}


	public void setSpisakNepolIspita(ArrayList<Predmet> spisakNepolIspita) {
		this.spisakNepolIspita = spisakNepolIspita;
	}

}
