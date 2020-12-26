package model;

import javax.swing.table.AbstractTableModel;



public class AbstractTableModelStudent extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public AbstractTableModelStudent() {
	}
	// broj redova
	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
