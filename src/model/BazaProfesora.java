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
//		kolone.add("DATUM RODJENJA");
//		kolone.add("ADRESA STANOVANJA");
//		kolone.add("BROJ LICNE KARTE");
//		kolone.add("TELEFON");
//		kolone.add("EMAIL");
//		kolone.add("ADRESA KANCELARIJE");
		kolone.add("Titula");
		kolone.add("Zvanje");
//      kolone.add("SPISAK PREDMETA");
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
				
				ArrayList<String> predmeti = new ArrayList<String>();
				
				if(tokeni.length > 10)
				{
					String[] predmetiString = tokeni[10].split(",");
					
					for(int i  = 0; i < predmetiString.length;++i)
						predmeti.add(predmetiString[i].trim());
				}
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
		case 4:
			return p.getSpisakPredmeta();
		default :
			return null;
		}
	}
}

