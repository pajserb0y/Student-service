package controller;

import java.util.ArrayList;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.TabbedPane;

public class PredmetController {
	
	public static PredmetController instance = null;
	
	public static PredmetController getInstance()
	{
		if(instance == null)
			instance = new PredmetController();
		return instance;
	}
	
	public void dodajPredmet(String sifraPred, String nazPred, int godStud, String semestar, Profesor profesor, int espb,
			ArrayList<Student> studentiPolozili, ArrayList<Student> studentiNisuPolozili)
	{
		studentiPolozili = null;
		studentiNisuPolozili = null;
		BazaPredmeta.getInstance().dodajPredmet(sifraPred, nazPred, godStud, semestar, profesor, espb, studentiPolozili, studentiNisuPolozili);
		TabbedPane.azurirajPrikaz("DODAT", -1);
	}

	public void izmeniPredmet(String staraSifra, String sifraPred, String nazPred, int godStud, String semestar, Profesor profesor, int espb,
			ArrayList<Student> studentiPolozili, ArrayList<Student> studentiNisuPolozili)
	{		
		ArrayList<Profesor> profesoriPom = BazaProfesora.getInstance().getProfesori();
		for(Profesor profesor1 : profesoriPom)
			if(profesor1.getSpisakPredmeta() != null)
				for(Predmet predmet : profesor1.getSpisakPredmeta())
					if(staraSifra.equals(predmet.getSifraPred()))
					{
						predmet.setSifraPred(sifraPred);
						predmet.setNazPred(nazPred);
						predmet.setGodStud(godStud);
						predmet.setSemestar(semestar);
						predmet.setEspb(espb);
						predmet.setProfesor(profesor);
						predmet.setStudentiPolozili(studentiPolozili); 
						predmet.setStudentiNisuPolozili(studentiPolozili); 
					}
		ArrayList<Student> studentiPom = BazaStudenata.getInstance().getStudenti();
		for(Student s : studentiPom)
			if(s.getSpisakPolIspitaISpisakOcena() != null)
				for(Predmet predmet : s.getSpisakPolIspitaISpisakOcena())
					if(staraSifra.equals(predmet.getSifraPred()))
					{
						predmet.setSifraPred(sifraPred);
						predmet.setNazPred(nazPred);
						predmet.setGodStud(godStud);
						predmet.setSemestar(semestar);
						predmet.setEspb(espb);
						predmet.setProfesor(profesor);
						predmet.setStudentiPolozili(studentiPolozili); 
						predmet.setStudentiNisuPolozili(studentiPolozili); 
					}
		for(Student s : studentiPom)
			if(s.getSpisakNepolIspita() != null)
				for(Predmet predmet : s.getSpisakNepolIspita())
					if(staraSifra.equals(predmet.getSifraPred()))
					{
						predmet.setSifraPred(sifraPred);
						predmet.setNazPred(nazPred);
						predmet.setGodStud(godStud);
						predmet.setSemestar(semestar);
						predmet.setEspb(espb);
						predmet.setProfesor(profesor);
						predmet.setStudentiPolozili(studentiPolozili); 
						predmet.setStudentiNisuPolozili(studentiPolozili); 
					}
		
		
		BazaPredmeta.getInstance().izmeniPredmet(staraSifra, sifraPred, nazPred, godStud, semestar, profesor, espb, studentiPolozili, studentiNisuPolozili);
		TabbedPane.azurirajPrikaz("IZMENJEN", -1);
	}
		
	public void izbrisiPredmet(String sifraPred) {
		// TODO Auto-generated method stub
		BazaPredmeta.getInstance().izbrisiPredmet(sifraPred);
		TabbedPane.azurirajPrikaz("IZBRISAN", -1);
	}
}
