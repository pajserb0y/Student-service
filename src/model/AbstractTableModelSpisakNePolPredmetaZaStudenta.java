package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import view.TabbedPane;

public class AbstractTableModelSpisakNePolPredmetaZaStudenta extends AbstractTableModel{

	private String[] kolone = {"Šifra predmeta","Naziv predmeta","ESPB","Godina izvodjenja"
			,"Semestar izvodjenja"};
	
	private ArrayList<Predmet> spisakNePolPredmeta = new ArrayList<Predmet>();

	public AbstractTableModelSpisakNePolPredmetaZaStudenta() {
		int rowView = TabbedPane.tabelaStudenata.getSelectedRow();
		int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowView);
		if(rowModel != -1)
			if(BazaStudenata.getInstance().getRow(rowModel).getSpisakNepolIspita() != null)
				spisakNePolPredmeta = BazaStudenata.getInstance().getRow(rowModel).getSpisakNepolIspita();
	}

	@Override
	public int getRowCount() {
		int rowView = TabbedPane.tabelaStudenata.getSelectedRow();
		int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowView);
		if(rowModel != -1)
			if(BazaStudenata.getInstance().getRow(rowModel).getSpisakNepolIspita() != null)
				spisakNePolPredmeta = BazaStudenata.getInstance().getRow(rowModel).getSpisakNepolIspita();
		return spisakNePolPredmeta.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Predmet p  = spisakNePolPredmeta.get(rowIndex);
		switch(columnIndex) {
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

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}
	
}
