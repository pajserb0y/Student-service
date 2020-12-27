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
		this.studenti = new ArrayList<Student>();
		String[] tokeni;
		
		String indeks="";
		String ime="";
		String prezime="";
		Date datum = null;		
		String adresa="";
		String telefon="";
		String email="";
		int godUpisa=0;
		int trenutnaGod=0;
		double prosek=0.0;
		STATUS status= STATUS.B;

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src\\baze\\bazastudenata.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String linija = null;
		
		try {
			while((linija = br.readLine())!= null)
			{
				tokeni = linija.split(";");
				
				for(int i = 0; i < tokeni.length; i++)
					tokeni[i] = tokeni[i].trim();
				
				indeks = tokeni[0];
				ime = tokeni[1];
				prezime = tokeni[2];
				adresa = tokeni[4];
				telefon = tokeni[5];
				email = tokeni[6];
				godUpisa = Integer.parseInt(tokeni[7]);
				trenutnaGod = Integer.parseInt(tokeni[8]);
				prosek = Double.parseDouble(tokeni[10]);
				
				SimpleDateFormat formater = new SimpleDateFormat("dd.mm.yyyy");
				String datumString = tokeni[3];
				datum = formater.parse(datumString);
				
				if (tokeni[9].equals("B"))
					status = STATUS.B;
				else
					status = STATUS.S;
				
				
				ArrayList<String> predmeti = new ArrayList<String>();
				if(tokeni.length > 11)
				{
					String[] predmetiString = tokeni[11].split(",");
					
					for(int i  = 0; i < predmetiString.length; i++)
						predmeti.add(predmetiString[i]);
				}
				
				studenti.add(new Student(ime, prezime, datum, adresa, telefon, email, indeks,  godUpisa, trenutnaGod, status, prosek, predmeti));
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
