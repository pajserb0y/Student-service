package model;

import java.util.ArrayList;

public class BazaOcena {
	
	private static BazaOcena instance = null;

	public static BazaOcena getInstance() {
		if (instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}
	
	private ArrayList<Ocena> ocene = new ArrayList<Ocena>();
	private ArrayList<String> kolone;

	private BazaOcena() {

		this.kolone = new ArrayList<>();
		kolone.add("Student");
		kolone.add("Predmet");
		kolone.add("Ocena");
		kolone.add("Datum polaganja");		
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
		for(Ocena o : ocene) 
			if(s.getBrIndeksa().equals(o.getStudent().getBrIndeksa()))
				oceneStudenta.add(o);
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
