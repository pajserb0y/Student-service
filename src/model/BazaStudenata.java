package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Student.STATUS;






public class BazaStudenata {
	
	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private ArrayList<Student> studenti;
	private ArrayList<String> kolone;
	
	private BazaStudenata() {
		// TODO Auto-generated constructor stub
		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Broj indeksa");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
	}
	
	private ArrayList<Student> initStudente() {
//		String[] tokeni;
//
//		BufferedReader br = null;
//		try {
//			br = new BufferedReader(new FileReader("src\\baze\\bazastudenata.txt"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String linija = null;
//		STATUS s;
//		
//		try {
//			while((linija = br.readLine())!= null)
//			{
//				tokeni = linija.split(";");
//				
//				for(int i = 0; i < tokeni.length; i++)
//					tokeni[i] = tokeni[i].trim();
//				
//				SimpleDateFormat formater = new SimpleDateFormat("dd.mm.yyyy");
//				String datumString = tokeni[3];
//				Date datum = formater.parse(datumString);
//				
//				if (tokeni[9].equals("B"))
//					s = STATUS.B;
//				else
//					s = STATUS.S;
//				
//				ArrayList<String> predmeti = new ArrayList<String>();
//				
//				if(tokeni.length > 11)
//				{
//					String[] predmetiString = tokeni[11].split(",");
//					
//					for(int i  = 0; i < predmetiString.length; i++)
//						predmeti.add(predmetiString[i]);
//				}
//				int godUpisa = Integer.parseInt(tokeni[7]);
//				int trenutnaGod = Integer.parseInt(tokeni[8]);
//				double prosek = Double.parseDouble(tokeni[10]);
//				Student st = new Student(tokeni[0], tokeni[1], tokeni[2], datum, tokeni[4], tokeni[5], tokeni[6], godUpisa,	trenutnaGod, s, prosek, predmeti);
//				studenti.add(st);
//		
//			}
		studenti = new ArrayList<Student>();
		String[] tokens;
		String indeks;
		String ime;
		String prezime;
		Date datum;
		String adresa;
		String telefon;
		String email;
		int datumupisa;
		int godina;
		double prosek;
		STATUS status;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src\\baze\\bazastudenata.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				tokens = line.split(";");
				for(int i = 0; i < tokens.length; i++)
				{
					System.out.printf("%s \n", tokens[i]);
				}
				
				indeks = tokens[0].trim();
				ime = tokens[1].trim();
				prezime = tokens[2].trim();

				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String datumStr = tokens[3].trim();
				datum = formatter.parse(datumStr);

				adresa=tokens[4].trim();
				telefon=tokens[5].trim().trim();
				email=tokens[6].trim();
				datumupisa=Integer.parseInt(tokens[7].trim());
				godina=Integer.parseInt(tokens[8].trim());
				String pom;
				pom = tokens[9].trim();

				if (pom.equalsIgnoreCase("B"))
					status = STATUS.B;
				else
					status = STATUS.S;

				prosek = Double.parseDouble(tokens[10].trim());

				ArrayList<String> predmeti = new ArrayList<String>();
				if (tokens.length > 11) {
					String[] pomPred = tokens[11].trim().split(":");
					for (int i = 0; i < pomPred.length; i++) {
						predmeti.add(pomPred[i]);
					}
				}
				Student s = new Student(ime, prezime, datum, adresa, telefon, email, indeks, datumupisa,  godina, status, prosek, predmeti);
				studenti.add(s);
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
		return studenti;

	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return 6;
	}
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getColumnName(int column) {
		return this.kolone.get(column);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student s = this.studenti.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return s.getBrIndeksa();
		case 1:
			return s.getIme();
		case 2:
			return s.getPrezime();
		case 3:
			return Integer.toString(s.getTrenutnaGodStudija());
		case 4:
			return s.getStatus();
		case 5:
			return Double.toString(s.getProsek());
		default:
			return null;
		}
	}
	
	public void dodajStudenta(String ime, String prezime, Date datum, String adresa, String telefon,
			String email, String indeks, int godinaUpisa, int trenutnaGodina, STATUS status) {
		
		this.studenti.add(new Student(ime, prezime, datum, adresa, telefon, email, indeks, godinaUpisa, trenutnaGodina, status));
	}
	
}
