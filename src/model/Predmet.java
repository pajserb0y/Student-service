package model;

import java.util.ArrayList;

public class Predmet {
	private String sifraPred;
	private String nazPred;
	private int godStud;
	private int semestar;
	private String profesor;
	private int espb;
	private ArrayList<String> studentiPolozili; 
	private ArrayList<String> studentiNisuPolozili;
	
	public Predmet(String sifraPred, String nazPred, int godStud, int semestar, String profesor, int espb) {
		super();
		this.sifraPred = sifraPred;
		this.nazPred = nazPred;
		this.godStud = godStud;
		this.semestar = semestar;
		this.profesor = profesor;
		this.espb = espb;
	}

	public Predmet(String sifraPred, String nazPred, int godStud, int semestar, String profesor, int espb,
			ArrayList<String> studentiPolozili, ArrayList<String> studentiNisuPolozili) {
		super();
		this.sifraPred = sifraPred;
		this.nazPred = nazPred;
		this.godStud = godStud;
		this.semestar = semestar;
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

	public int getGodStud() {
		return godStud;
	}

	public void setGodStud(int godStud) {
		this.godStud = godStud;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
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
	
	