package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPredmet extends AbstractTableModel {

	private ArrayList<Predmet> spisakPredmeta = BazaPredmeta.getInstance().getPredmeti();
	
	public void setSpisakPred(ArrayList<Predmet> predmeti) {
		spisakPredmeta = predmeti;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getColumnName(column);
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return spisakPredmeta.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Predmet p  = spisakPredmeta.get(row);
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

}
