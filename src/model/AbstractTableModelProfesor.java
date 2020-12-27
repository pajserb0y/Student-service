package model;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelProfesor extends AbstractTableModel {

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getColumnName(column);
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getValueAt(row, col);
	}	
}
