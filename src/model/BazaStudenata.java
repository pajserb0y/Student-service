package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import view.TabbedPane;
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
		ArrayList<Predmet> spisakPolIspitaISpisakOcena = null;
		ArrayList<Predmet> spisakNepolIspita = null;

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
				
				SimpleDateFormat formater = new SimpleDateFormat("dd/mm/yyyy");
				String datumString = tokeni[3];
				datum = formater.parse(datumString);
				
				if (tokeni[9].equals("B"))
					status = STATUS.B;
				else
					status = STATUS.S;
				

				
				studenti.add(new Student(ime, prezime, datum, adresa, telefon, email, indeks, godUpisa, trenutnaGod, status, prosek, spisakPolIspitaISpisakOcena, spisakNepolIspita));
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
			String email, String indeks, int godinaUpisa, int trenutnaGodina, STATUS status, double prosek, 
			ArrayList<Predmet> spisakPolIspitaISpisakOcena, ArrayList<Predmet> spisakNepolIspita) {
		
		this.studenti.add(new Student(ime, prezime, datum, adresa, telefon, email, indeks, godinaUpisa, trenutnaGodina, status, prosek, spisakPolIspitaISpisakOcena, spisakNepolIspita));
	}

	public void izmeniStudenta(String stariIndeks, String ime, String prezime, Date datum, String adresa, String telefon, String email, String indeks,
			int godinaUpisa, int trenutnaGodina, STATUS status, double prosek,
			ArrayList<Predmet> spisakPolIspitaISpisakOcena, ArrayList<Predmet> spisakNepolIspita) {
		
		for(Student s : studenti)
		{
			if(s.getBrIndeksa().equals(stariIndeks))
			{
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setDatRodj(datum);
				s.setAdresaStan(adresa);
				s.setTelefon(telefon);
				s.setEmail(email);
				s.setBrIndeksa(indeks);
				s.setGodUpisa(godinaUpisa);
				s.setTrenutnaGodStudija(trenutnaGodina);
				s.setStatus(status);
				s.setProsek(prosek);  
				s.setSpisakPolIspitaISpisakOcena(spisakPolIspitaISpisakOcena);
				s.setSpisakNepolIspita(spisakNepolIspita);
				
				return;
			}
		}
	}

	public void izbrisiStudenta(String brIndeksa) {
		
		for(Student s : studenti)
			if(brIndeksa.equals(s.getBrIndeksa())) {
				studenti.remove(s);
				break;
			}
	}

	public void pretraziStudenta(String ime, String prezime, String indeks) {
		// TODO Auto-generated method stub
		ArrayList<Student> lista = new ArrayList<Student>();
		ArrayList<Student> kopija = new ArrayList<Student>(studenti); //cuva originalnu listu
		
		if(!prezime.equals("")){
			if(!indeks.equals("")){
				for (Student s : studenti) 
					if(s.getPrezime().toLowerCase().contains(prezime) && s.getIme().toLowerCase().contains(ime) && s.getBrIndeksa().toLowerCase().contains(indeks)) 
						lista.add(s);
			}else if(!ime.equals("")){
				for (Student s : studenti) 
					if(s.getPrezime().toLowerCase().contains(prezime) && s.getIme().toLowerCase().contains(ime)) 
						lista.add(s);
			}else{ 
				for(Student s : studenti)
					if(s.getPrezime().toLowerCase().contains(prezime)) 
						lista.add(s);
			}
		}
		if(!lista.isEmpty()) {
			studenti = lista;
			TabbedPane.azurirajPrikaz(null, -1);
		
		}else if(!prezime.equals("")){	//slucaj kada je uneto prezime i ime koje nema u tabeli 
			studenti = new ArrayList<Student>();
			TabbedPane.azurirajPrikaz(null, -1);
		}else{
			TabbedPane.azurirajPrikaz(null, -1);
		}
		this.studenti = kopija;
	}	
}
