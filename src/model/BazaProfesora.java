package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import view.TabbedPane;



public class BazaProfesora {
	
	private static BazaProfesora instance = null;
	
	
	public static BazaProfesora getInstance()
	{
		if(instance == null)
			instance =  new BazaProfesora();
		return instance;
	}
	
	private ArrayList<Profesor> profesori;
	private ArrayList<String> kolone;
	
	private BazaProfesora()
	{
		initProfesora();
		
		this.kolone = new ArrayList<String>();
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Titula");
		kolone.add("Zvanje");
	}
	
	private ArrayList<Profesor> initProfesora()
	{
		this.profesori = new ArrayList<Profesor>();
		String[] tokeni;
		
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src\\baze\\bazaprofesora.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String linija = null;
		try {
			while((linija = br.readLine())!= null)
			{
				tokeni = linija.split(";");
				
				for(int i = 0; i < tokeni.length; ++i)
					tokeni[i] = tokeni[i].trim();
				
				String lk = tokeni[0].substring(1, tokeni[0].length() - 1);
				
				SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy.");
				String datumString = tokeni[3];
				Date datum = formater.parse(datumString);
				
				String titula = tokeni[8].substring(0, 1) + tokeni[8].substring(1).toLowerCase();
				if(titula.equals("Prof_dr"))
					titula = "Prof. dr";
				
				String zvanje = tokeni[9].substring(0, 1) + tokeni[9].substring(1).toLowerCase();
				if(zvanje.equals("Vanredni_profesor"))
					zvanje = "Vanredni profesor";
				if(zvanje.equals("Redovni_profesor"))
					zvanje = "Redovni profesor";
				
				ArrayList<Predmet> predmeti = null;
				
				profesori.add(new Profesor(tokeni[1], tokeni[2], datum, tokeni[4],tokeni[5],tokeni[6],tokeni[7],lk, titula, zvanje, predmeti));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profesori;
	}
	
	public ArrayList<Profesor> getProfesori()
	{
		return profesori;
	}
	
	public void setProfesori(List<Profesor> profesori)
	{
		this.profesori = (ArrayList<Profesor>)profesori;
	}
	
	public int getColumnCount()
	{
		return 4;
	}
	
	public String getColumnName(int index)
	{
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int row)
	{
		return this.profesori.get(row);
	}
	
	public Object getValueAt(int row,int col)
	{
		Profesor p = this.profesori.get(row);
		switch(col) {
		case 0:
			return p.getIme();
		case 1:
			return p.getPrezime();
		case 2:
			return p.getTitula();
		case 3:
			return p.getZvanje();
		default :
			return null;
		}
	}
	
	public void dodajProfesora(String ime, String prezime, Date datumRodjenja, String adresa, String telefon,String email ,String adresaK,
			 String brLicne,String titula, String zvanje ,ArrayList<Predmet> predmeti)
	{
		Profesor p = new Profesor(ime , prezime, datumRodjenja, adresa,
				telefon, email, adresaK, brLicne, titula, zvanje, predmeti);
		profesori.add(p);
	}

	public void izmeniProfesora(String staraLk, String ime, String prezime, Date datumRodjenja, String adresa,
			String telefon, String email, String adresaK, String brLicne, String titula, String zvanje,
			ArrayList<Predmet> predmeti) {
		for(Profesor p : profesori)
		{
			if(p.getBrLicne().equals(staraLk))
			{
				p.setIme(ime);
				p.setPrezime(prezime);
				p.setDatRodj(datumRodjenja);
				p.setAdresaStan(adresa);
				p.setTelefon(telefon);
				p.setEmail(email);
				p.setAdresaKanc(adresaK);
				p.setBrLicne(brLicne);
				p.setTitula(titula);
				p.setZvanje(zvanje);
				p.setSpisakPredmeta(predmeti);
				return;
			}
		}
	}

	public void izbrisiProfesora(String brLicne) {
		for(Profesor p : profesori) 
			if(brLicne.equals(p.getBrLicne())) {
				profesori.remove(p);
				break;
			}
	}

	public void pretraziProfesora(String ime, String prezime) {
		// TODO Auto-generated method stub
		ArrayList<Profesor> lista = new ArrayList<Profesor>();
		ArrayList<Profesor> kopija = new ArrayList<Profesor>(profesori); //kuva originalnu listu
		if(!prezime.equals(""))
			if(!ime.equals(""))
				for (Profesor p : profesori) {
					if(p.getPrezime().toLowerCase().contains(prezime) && p.getIme().toLowerCase().contains(ime)) 
						lista.add(p);
				}
			else 
				for(Profesor p : profesori)
					if(p.getPrezime().toLowerCase().contains(prezime)) 
						lista.add(p);
		if(!lista.isEmpty()) {
			profesori = lista;
			TabbedPane.azurirajPrikaz(null, -1);
		}else if(!prezime.equals("")){	//slucaj kada je uneto prezime i ime koje nema u tabeli 
			profesori = new ArrayList<Profesor>();
			TabbedPane.azurirajPrikaz(null, -1);
		}else{
			TabbedPane.azurirajPrikaz(null, -1);
		}
		this.profesori = kopija;
	}
}

