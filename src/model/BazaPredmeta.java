package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BazaPredmeta {

		private static BazaPredmeta instance = null;
	
		public static BazaPredmeta getInstance() {
			if(instance == null)
				instance = new BazaPredmeta();
			return instance;
		}
		
		private ArrayList<Predmet> predmeti;
		private ArrayList<String> kolone;

		private BazaPredmeta() {
			
			initPredmet();
			
			this.kolone = new ArrayList<>();
			kolone.add("Šifra predmeta");
			kolone.add("Naziv predmeta");
			kolone.add("Broj ESPB bodova");
			kolone.add("Godina izvođenja");
			kolone.add("Semestar izvođenja");
			
		}
		
		private ArrayList<Predmet> initPredmet() {
			
			predmeti = new ArrayList<Predmet>();
			String[] tokeni;
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new FileReader("src\\baze\\bazapredmeta.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String linija = null;
			try {
				while((linija = br.readLine()) != null)
				{
					tokeni = linija.split(";");
					
					for(int i = 0;i < tokeni.length;++i)
						tokeni[i] = tokeni[i].trim();
					
					int godina = Integer.parseInt(tokeni[3]);
					String semestar = tokeni[2];
					int espb = Integer.parseInt(tokeni[4]);
					Profesor profesor = null;
					
					ArrayList<Student> polozili  = null;
					ArrayList<Student> nisu_polozili = null;
					
					
					
					Predmet p = new Predmet(tokeni[0], tokeni[1], godina, semestar,profesor , espb, polozili,nisu_polozili);
					predmeti.add(p);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return predmeti;
		}
		
		public ArrayList<Predmet> getPredmeti(){
			return predmeti;
		}
		
		public void setPredmeti(ArrayList<Predmet> predmeti){
			this.predmeti = predmeti;
		}
		
		public int getColumnCount() {
			return 5;
		}
		
		public String getColumnName(int index)
		{
			return kolone.get(index);
		}
		
		public Predmet getRow(int index)
		{
			return predmeti.get(index);
		}
		
		public Object getValueAt(int row,int col)
		{
			Predmet p  = predmeti.get(row);
			switch(col) {
			case 0:
				return p.getSifraPred();
			case 1:
				return p.getNazPred();
			case 2:
				return p.getEspb();
			case 3:
				return p.getGodStud();
			case 4:
				return p.getSemestar();
			default :
				return null;
			}
		}

		public void izbrisiPredmet(String sifraPred) {
			// TODO Auto-generated method stub
			for(Predmet p : predmeti) {
				if(sifraPred.equals(p.getSifraPred())) {
					predmeti.remove(p);
					break;
				}
			}
		}
		
		public void dodajPredmet(String sifraPred, String nazPred, int godStud, String semestar, Profesor profesor, int espb,
				ArrayList<Student> studentiPolozili, ArrayList<Student> studentiNisuPolozili)
		{
			Predmet p = new Predmet(sifraPred, nazPred, godStud, semestar, profesor, espb,studentiPolozili,studentiNisuPolozili);
			this.predmeti.add(p);
		}

		public void izmeniPredmet(String sifraPred, String nazPred,	int godStud, String semestar, Profesor profesor, int espb,
				ArrayList<Student> studentiPolozili, ArrayList<Student> studentiNisuPolozili) 
		{
			for(Predmet p : predmeti)
			{
				p.setSifraPred(sifraPred);
				p.setNazPred(nazPred);
				p.setGodStud(godStud);
				p.setSemestar(semestar);
				p.setEspb(espb);
				p.setProfesor(profesor);
				p.setStudentiPolozili(studentiPolozili); //msm da ovo treba da ostane ne pormenjeno jer se to sne moze izmeniti
				p.setStudentiNisuPolozili(studentiNisuPolozili); //msm da ovo treba da ostane ne pormenjeno jer se to sne moze izmeniti
				return;
			}
		}
}
