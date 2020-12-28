package model;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPredmet extends AbstractTableModel {

	
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
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getValueAt(row, col);
	}

}
