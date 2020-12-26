package model;

import java.util.Date;

public class Osoba {
	private String ime;
	private String prezime;
	private Date datRodj;
	private String adresaStan;
	private String brLicne;
	private String telefon;
	private String email;
	
	public Osoba(String ime, String prezime, Date datRodj, String adresaStan, String brLicne, String telefon,
			String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datRodj = datRodj;
		this.adresaStan = adresaStan;
		this.brLicne = brLicne;
		this.telefon = telefon;
		this.email = email;
	}
	
	public Osoba(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Date getDatRodj() {
		return datRodj;
	}
	public void setDatRodj(Date datRodj) {
		this.datRodj = datRodj;
	}
	public String getAdresaStan() {
		return adresaStan;
	}
	public void setAdresaStan(String adresaStan) {
		this.adresaStan = adresaStan;
	}
	public String getBrLicne() {
		return brLicne;
	}
	public void setBrLicne(String brLicne) {
		this.brLicne = brLicne;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
