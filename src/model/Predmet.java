package model;

import java.util.ArrayList;

public class Predmet {
	private String sifraPred;
	private String nazPred;
	private String semestar;
	private String GodStud;
	private String profesor;
	private String espb;
	private ArrayList<String> studentiPolozili = new ArrayList<String>(); // DA LI TREBA OVDE DA SE NAPAVI VEC?
	private ArrayList<String> studentiNisuPolozili = new ArrayList<String>();
	
	public Predmet() {};
	
	public Predmet(String sifraPred, String nazPred, String semestar, String godStud, String profesor, String espb,
			ArrayList<String> studentiPolozili, ArrayList<String> studentiNisuPolozili) {
		super();
		this.sifraPred = sifraPred;
		this.nazPred = nazPred;
		this.semestar = semestar;
		GodStud = godStud;
		this.profesor = profesor;
		this.espb = espb;
		this.studentiPolozili = studentiPolozili;
		this.studentiNisuPolozili = studentiNisuPolozili;
	}

	public String getSifraPred() {
		return sifraPred;
	}

	public void setSifraPred(String sifraPred) {
		this.sifraPred = sifraPred;
	}

	public String getNazPred() {
		return nazPred;
	}

	public void setNazPred(String nazPred) {
		this.nazPred = nazPred;
	}

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}

	public String getGodStud() {
		return GodStud;
	}

	public void setGodStud(String godStud) {
		GodStud = godStud;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getEspb() {
		return espb;
	}

	public void setEspb(String espb) {
		this.espb = espb;
	}

	public ArrayList<String> getStudentiPolozili() {
		return studentiPolozili;
	}

	public void setStudentiPolozili(ArrayList<String> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}

	public ArrayList<String> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}

	public void setStudentiNisuPolozili(ArrayList<String> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}

}
