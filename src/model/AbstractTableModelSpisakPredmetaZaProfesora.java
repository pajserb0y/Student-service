package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import view.TabbedPane;
import view.profesor.AddPredToProfDialog;

public class AbstractTableModelSpisakPredmetaZaProfesora extends AbstractTableModel {

	private String[] kolone = {"Šifra predmeta","Naziv predmeta","Godina izvodjenja"
			,"Semestar izvodjenja"};
	
	private ArrayList<Predmet> spisakPredmeta = new ArrayList<Predmet>();
	
	
	public AbstractTableModelSpisakPredmetaZaProfesora() {
		int rowView = TabbedPane.tabelaProfesora.getSelectedRow();
		if(rowView > -1){
			int rowModel = TabbedPane.tabelaProfesora.convertRowIndexToModel(rowView);
			if(rowModel != -1)
				if(BazaProfesora.getInstance().getRow(rowModel).getSpisakPredmeta() != null)
					spisakPredmeta = BazaProfesora.getInstance().getRow(rowModel).getSpisakPredmeta();
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
		int rowView = TabbedPane.tabelaProfesora.getSelectedRow();
		int rowModel = TabbedPane.tabelaProfesora.convertRowIndexToModel(rowView);
		if(rowModel != -1)
			if(BazaProfesora.getInstance().getRow(rowModel).getSpisakPredmeta() != null)
				spisakPredmeta = BazaProfesora.getInstance().getRow(rowModel).getSpisakPredmeta();
		return spisakPredmeta.size();			
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
