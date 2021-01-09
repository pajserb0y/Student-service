package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import view.TabbedPane;

public class AbstractTableModelSpisakPolPredmetaZaStudenta extends AbstractTableModel {

	private String[] kolone = {"Šifra predmeta","Naziv predmeta","ESPB"
			,"Ocena", "Datum"};
	
	private ArrayList<Predmet> spisakPredmeta = null;//new ArrayList<Predmet>();
	private ArrayList<Ocena> spisakOcena = null;
	private String student = "";
	

	public AbstractTableModelSpisakPolPredmetaZaStudenta() {
		int rowView = TabbedPane.tabelaStudenata.getSelectedRow();
		int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowView);
		if(rowModel != -1){
			spisakPredmeta = BazaStudenata.getInstance().getRow(rowModel).getSpisakPolIspitaISpisakOcena();
			spisakOcena = BazaOcena.getInstance().getOcene();
			student = BazaStudenata.getInstance().getRow(rowModel).getBrIndeksa();
		}
	}
	
	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return kolone[arg0];
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Ocena ocena = null;
		for(Ocena o : spisakOcena)
			if(o.getStudent().getBrIndeksa().equals(student))
				ocena=o;
		
		switch(columnIndex) {
		case 0:
			return ocena.getPredmet().getSifraPred();
		case 1:
			return ocena.getPredmet().getNazPred();
		case 2:
			return ocena.getPredmet().getEspb();
		case 3:
			return ocena.getOcena();
		case 4:
			return ocena.getDatPolaganja();
		default :
			return null;
		}
	}	
}
