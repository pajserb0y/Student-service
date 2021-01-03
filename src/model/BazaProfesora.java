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
				
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				String datumString = tokeni[2];
				Date datum = formater.parse(datumString);
				
				ArrayList<Predmet> predmeti = null;
				
				profesori.add(new Profesor(tokeni[0],tokeni[1],datum,tokeni[3],tokeni[4],tokeni[5],tokeni[6],tokeni[7],
						tokeni[8],tokeni[9],predmeti));
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
				p.setSpisakPredmeta(p.getSpisakPredmeta()); //msm da ovo treba da ostane ne pormenjeno jer se to ne moze izmeniti ovdeza sada
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

}

