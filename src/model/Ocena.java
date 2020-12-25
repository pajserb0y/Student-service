package model;

import java.util.Date;

public class Ocena {

	private Student student;
	private Predmet predmet;
	private int ocena;
	private Date datPolaganja;	
	
	public Ocena(Student student, Predmet predmet, int ocena, Date datPolaganja) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datPolaganja = datPolaganja;
	}
	

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Predmet getPredmet() {
		return predmet;
	}


	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}


	public int getOcena() {
		return ocena;
	}


	public void setOcena(int ocena) {
		this.ocena = ocena;
	}


	public Date getDatPolaganja() {
		return datPolaganja;
	}


	public void setDatPolaganja(Date datPolaganja) {
		this.datPolaganja = datPolaganja;
	}
	
	
}