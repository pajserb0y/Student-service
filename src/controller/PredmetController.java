package controller;

import java.util.ArrayList;

import model.BazaPredmeta;
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
	
	public void dodajPredmet(String sifraPred, String nazPred, int godStud, int semestar, Profesor profesor, int espb,
			ArrayList<Student> studentiPolozili, ArrayList<Student> studentiNisuPolozili)
	{
		studentiPolozili = null;
		studentiNisuPolozili = null;
		BazaPredmeta.getInstance().dodajPredmet(sifraPred, nazPred, godStud, semestar, profesor, espb, studentiPolozili, studentiNisuPolozili);
		TabbedPane.azurirajPrikaz("DODAT", -1);
	}

	public void izbrisiPredmet(String sifraPred) {
		// TODO Auto-generated method stub
		BazaPredmeta.getInstance().izbrisiPredmet(sifraPred);
		TabbedPane.azurirajPrikaz("IZBRISAN", -1);
	}
}
