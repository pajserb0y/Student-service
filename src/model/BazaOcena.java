package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BazaOcena {
	
	private static BazaOcena instance = null;

	public static BazaOcena getInstance() {
		if (instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}
	
	private ArrayList<Ocena> ocene;
	private ArrayList<String> kolone;

	private BazaOcena() {
		
		initOcena();
		
		this.kolone = new ArrayList<>();
		kolone.add("Student");
		kolone.add("Predmet");
		kolone.add("Ocena");
		kolone.add("Datum polaganja");		
	}
	ArrayList<Ocena> initOcena(){
		ocene = new ArrayList<Ocena>();
		String[] tokeni;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("src\\baze\\bazaocena.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String linija = null;
		try {
			while((linija = br.readLine()) != null)
			{
				Student st = null;
				Predmet pr = null;
				tokeni = linija.split(";");
				
				for(int i = 0;i < tokeni.length;++i)
					tokeni[i] = tokeni[i].trim();
				
				int ocena = Integer.parseInt(tokeni[2]);
				
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				String datumString = tokeni[3];
				Date datum = null;
				try {
					datum = formater.parse(datumString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ArrayList<Student> studenti = BazaStudenata.getInstance().getStudenti();
				for(Student s : studenti) 
					if(s.getBrIndeksa().equals(tokeni[0])){
						st = s;	
						break;
					}
				
				ArrayList<Predmet> listaPolozenihPredmetaStudenta = new ArrayList<Predmet>();
				if(st.getSpisakPolIspitaISpisakOcena() != null)
					listaPolozenihPredmetaStudenta = st.getSpisakPolIspitaISpisakOcena();
				
				ArrayList<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
				for(Predmet p : predmeti) 
					if(p.getSifraPred().equals(tokeni[1])){
						pr = p;	
						break;
					}
				
				ArrayList<Student> listaStudenataKojiSuPolozili = new ArrayList<Student>();
				if(pr.getStudentiPolozili() != null)
					listaStudenataKojiSuPolozili = pr.getStudentiPolozili();
				
				listaPolozenihPredmetaStudenta.add(pr);
				listaStudenataKojiSuPolozili.add(st);
				
				st.setSpisakPolIspitaISpisakOcena(listaPolozenihPredmetaStudenta);
				pr.setStudentiPolozili(listaStudenataKojiSuPolozili);
				
				Ocena o = new Ocena(st, pr, ocena, datum);
				ocene.add(o);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ocene;
	}
	
	public ArrayList<Ocena> getOcene(){
		return ocene;
	}
	
	public void setOcene(ArrayList<Ocena> ocene){
		this.ocene = ocene;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index)
	{
		return kolone.get(index);
	}
	
	public Ocena getRow(int index)
	{
		return ocene.get(index);
	}
	
	public Object getValueAt(int row,int col)
	{
		Ocena o = ocene.get(row);
		switch(col) {
		case 0:
			return o.getStudent();
		case 1:
			return o.getPredmet();
		case 2:
			return o.getOcena();
		case 3:
			return o.getDatPolaganja();
		default :
			return null;
		}
	}

	public ArrayList<Ocena> getOceneStudenta(Student s) {
		// TODO Auto-generated method stub
		ArrayList<Ocena> oceneStudenta = new ArrayList<Ocena>();
//		if(s == null)
//			System.out.println("fdgdfg");
		for(Ocena o : ocene){ 
//			if(o.getStudent() == null)
//				System.out.println("fdgdfgdgfdgfgsfgsgsg");
			if(s.getBrIndeksa().equals(o.getStudent().getBrIndeksa()))
				oceneStudenta.add(o);
		}
		return oceneStudenta;
	}
	
	public float getProsekOcenaStudenta(Student s){
		int br = 0;
		int sum = 0;
		for(Ocena o : ocene) 
			if(s.getBrIndeksa().equals(o.getStudent().getBrIndeksa())){
				br++;
				sum += o.getOcena();
			}
		return (br != 0) ? (float)sum/br : 0;	
	}
	
	public int getUkupanEspbStudenta(Student s){
		int br = 0;
		for(Ocena o : ocene) 
			if(s.getBrIndeksa().equals(o.getStudent().getBrIndeksa()))
				br += o.getPredmet().getEspb();
		
		return br;	
	}
}
