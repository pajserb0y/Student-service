package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import view.TabbedPane;

public class AbstractTableModelSpisakPolPredmetaZaStudenta extends AbstractTableModel {

	private String[] kolone = {"Šifra predmeta","Naziv predmeta","ESPB"
			,"Ocena", "Datum"};
	
	private ArrayList<Predmet> spisakPredmeta = new ArrayList<Predmet>();
	private ArrayList<Ocena> spisakOcena;
	private Student student;
	

	public AbstractTableModelSpisakPolPredmetaZaStudenta() {
		int rowView = TabbedPane.tabelaStudenata.getSelectedRow();
		int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowView);
		if(rowModel != -1){
			student = BazaStudenata.getInstance().getRow(rowModel);
			if(student.getSpisakPolIspitaISpisakOcena() != null)
				spisakPredmeta = student.getSpisakPolIspitaISpisakOcena();
			spisakOcena = BazaOcena.getInstance().getOceneStudenta(student);
			
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
		int rowView = TabbedPane.tabelaStudenata.getSelectedRow();
		int rowModel = TabbedPane.tabelaStudenata.convertRowIndexToModel(rowView);
		if(rowModel != -1)
			if(BazaStudenata.getInstance().getRow(rowModel).getSpisakPolIspitaISpisakOcena() != null) {
				spisakPredmeta = BazaStudenata.getInstance().getRow(rowModel).getSpisakPolIspitaISpisakOcena();
				spisakOcena = BazaOcena.getInstance().getOceneStudenta(student);
			}
		return spisakPredmeta.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Ocena ocena = spisakOcena.get(rowIndex);
		
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
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			String strDate = formatter.format(ocena.getDatPolaganja());  
			return strDate;
		default :
			return null;
		}
	}	
}
