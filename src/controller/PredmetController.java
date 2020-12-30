package controller;

import java.util.ArrayList;

import model.BazaPredmeta;
import view.TabbedPane;

public class PredmetController {
	
	public static PredmetController instance = null;
	
	public static PredmetController getInstance()
	{
		if(instance == null)
			instance = new PredmetController();
		return instance;
	}
	
	public void dodajPredmet(String sifraPred, String nazPred, int godStud, int semestar, String profesor, int espb,
			ArrayList<String> studentiPolozili, ArrayList<String> studentiNisuPolozili)
	{
		BazaPredmeta.getInstance().dodajPredmet(sifraPred, nazPred, godStud, semestar, profesor, espb, studentiPolozili, studentiNisuPolozili);
		TabbedPane.azurirajPrikaz("DODAT", -1);
	}
}