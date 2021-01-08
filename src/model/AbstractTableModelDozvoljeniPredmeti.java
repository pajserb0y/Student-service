package model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

import view.TabbedPane;
import view.profesor.AddPredToProfDialog;
import view.profesor.DozvoljeniPredmetiJTable;

public class AbstractTableModelDozvoljeniPredmeti extends AbstractTableModel {

	private String[] kolone = {"Šifra predmeta","Naziv predmeta","Godina izvodjenja"
			,"Semestar izvodjenja"};
	
	private  ArrayList<Predmet> spisakDozvoljenijhPredmeta = new ArrayList<>(BazaPredmeta.getInstance().getPredmeti());
	
	public AbstractTableModelDozvoljeniPredmeti() {
		int rowView = TabbedPane.tabelaProfesora.getSelectedRow();
		int rowModel = TabbedPane.tabelaProfesora.convertRowIndexToModel(rowView);
		if(rowModel != -1) {
			ArrayList<Predmet> sviPredmeti = BazaPredmeta.getInstance().getPredmeti();
			ArrayList<Predmet> predmetiProfesora = BazaProfesora.getInstance().getRow(rowModel).getSpisakPredmeta();
			if(predmetiProfesora != null) 
				for(Predmet p1 : sviPredmeti) 
					for(Predmet p2 : predmetiProfesora)
						if(p1.getSifraPred().equals(p2.getSifraPred()))
							spisakDozvoljenijhPredmeta.remove(p1);
		}
	}		

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return spisakDozvoljenijhPredmeta.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
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
