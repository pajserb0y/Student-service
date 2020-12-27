package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		String indeks;
		String ime;
		String prezime;
		int godina;
		STATUS status;
		double prosek;
		
		
		studenti.add(new Student("RA-111-2018", "Mika", "Mikic", 3, STATUS.B, (8.22)));
		studenti.add(new Student("RA-42-2018", "Zika", "Zikic", 4, STATUS.B, (9.87)));
		studenti.add(new Student("RA-110-2018", "Pera", "Mikic", 1, STATUS.S, (6.22)));

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
