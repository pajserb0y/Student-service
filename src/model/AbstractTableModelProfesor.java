package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelProfesor extends AbstractTableModel {
	
	private ArrayList<Profesor> spisakProfesora = BazaProfesora.getInstance().getProfesori();
	
	public void setSpisakProf(ArrayList<Profesor> profesori) {
		spisakProfesora = profesori;
	}
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
		return spisakProfesora.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Profesor p = this.spisakProfesora.get(row);
		switch(col) {
		case 0:
			return p.getIme();
		case 1:
			return p.getPrezime();
		case 2:
			return p.getTitula();
		case 3:
			return p.getZvanje();
		default :
			return null;
		}
	}	
}
