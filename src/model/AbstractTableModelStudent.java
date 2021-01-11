package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;



public class AbstractTableModelStudent extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Student> spisakStudenata = BazaStudenata.getInstance().getStudenti();

	public void setSpisakSt(ArrayList<Student> studenti) {
		spisakStudenata = studenti;
	}
	
	@Override
	public int getRowCount() {
		return spisakStudenata.size();
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
		Student s = this.spisakStudenata.get(row);
		switch(col) {
		case 0:
			return s.getBrIndeksa();
		case 1:
			return s.getIme();
		case 2:
			return s.getPrezime();
		case 3:
			return s.getTrenutnaGodStudija();
		case 4:
			return s.getStatus();
		case 5:
			return s.getProsek();
		default :
			return null;
		}
	}
	

}
