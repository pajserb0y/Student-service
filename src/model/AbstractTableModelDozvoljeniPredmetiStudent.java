package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import view.TabbedPane;

public class AbstractTableModelDozvoljeniPredmetiStudent extends AbstractTableModel{

	private String[] kolone = {"Šifra predmeta","Naziv predmeta","Godina izvodjenja"
			,"Semestar izvodjenja"};
	
	private  ArrayList<Predmet> spisakDozvoljenijhPredmeta = new ArrayList<>(BazaPredmeta.getInstance().getPredmeti());
	
	public AbstractTableModelDozvoljeniPredmetiStudent() {
		int rowView = TabbedPane.tabelaStudenata.getSelectedRow();
		int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowView);
		if(rowModel != -1) {
			ArrayList<Predmet> sviPredmeti = BazaPredmeta.getInstance().getPredmeti();
			ArrayList<Predmet> nepolPredmetiStudenta = BazaStudenata.getInstance().getStudenti().get(rowModel).getSpisakNepolIspita();
			ArrayList<Predmet> polozeniPredmetiStudenta = BazaStudenata.getInstance().getStudenti().get(rowModel).getSpisakPolIspitaISpisakOcena();
			
			
			if(nepolPredmetiStudenta != null) 
				for(Predmet p1 : sviPredmeti) 
					for(Predmet p2 : nepolPredmetiStudenta)
						if(p1.getSifraPred().equals(p2.getSifraPred()))
							spisakDozvoljenijhPredmeta.remove(p1);
			
			if(polozeniPredmetiStudenta != null) 
				for(Predmet p1 : sviPredmeti) 
					for(Predmet p2 : polozeniPredmetiStudenta)
						if(p1.getSifraPred().equals(p2.getSifraPred()))
							spisakDozvoljenijhPredmeta.remove(p1);
			
			ArrayList<Predmet> spisakDozvoljenijhPredmetaPom = new ArrayList<>(spisakDozvoljenijhPredmeta);
			Student student = BazaStudenata.getInstance().getRow(rowModel);
			
			if(!spisakDozvoljenijhPredmetaPom.isEmpty())
				for(Predmet p1 : spisakDozvoljenijhPredmetaPom) 
						if(p1.getGodStud() > student.getTrenutnaGodStudija())
							spisakDozvoljenijhPredmeta.remove(p1);
		}
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return spisakDozvoljenijhPredmeta.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Predmet p  = spisakDozvoljenijhPredmeta.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return p.getSifraPred();
		case 1:
			return p.getNazPred();
		case 2:
			return p.getGodStud();
		case 3:
			return p.getSemestar();
		default :
			return null;
		}
	}
	
}
