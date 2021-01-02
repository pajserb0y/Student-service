package model;

import javax.swing.table.AbstractTableModel;



public class AbstractTableModelStudent extends AbstractTableModel {

	private static final long serialVersionUID = 1L;	

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
		
	}
	
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
	public Object getValueAt(int row, int col) {
 		return BazaStudenata.getInstance().getValueAt(row, col);
	}
	

}
