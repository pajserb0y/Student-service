package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import view.TabbedPane;

public class AbstractTableModelSpisakPredmetaZaProfesora extends AbstractTableModel {

	private String[] kolone = {"Šifra predmeta","Naziv predmeta","Godina izvodjenja"
			,"Semestar izvodjenja"};
	
	private ArrayList<Predmet> spisakPredmeta = null;//new ArrayList<Predmet>();
	

	public AbstractTableModelSpisakPredmetaZaProfesora() {
		int rowView = TabbedPane.tabelaProfesora.getSelectedRow();
		int rowModel = TabbedPane.tabelaProfesora.convertRowIndexToModel(rowView);
		if(rowModel != -1)
			spisakPredmeta = BazaProfesora.getInstance().getRow(rowModel).getSpisakPredmeta();
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		
		return kolone[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(spisakPredmeta != null)
			return spisakPredmeta.size();
		else
			return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Predmet p  = spisakPredmeta.get(rowIndex);
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
