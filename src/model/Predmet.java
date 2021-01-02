package model;

import java.util.ArrayList;

public class Predmet {
	private String sifraPred;
	private String nazPred;
	private int godStud;
	private String semestar;
	private Profesor profesor;
	private int espb;
	private ArrayList<Student> studentiPolozili; 
	private ArrayList<Student> studentiNisuPolozili;
	
	public Predmet(String sifraPred, String nazPred, int godStud, String semestar, Profesor profesor, int espb,
			ArrayList<Student> studentiPolozili, ArrayList<Student> studentiNisuPolozili) {
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

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar2) {
		this.semestar = semestar2;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public ArrayList<Student> getStudentiPolozili() {
		return studentiPolozili;
	}

	public void setStudentiPolozili(ArrayList<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}

	public ArrayList<Student> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}

	public void setStudentiNisuPolozili(ArrayList<Student> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}
}
	
	