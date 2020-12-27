package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;



public class AbstractTableModelStudent extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private String[] kolone = {"Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek"};
	
	
	private ArrayList<Student> listaStudenata = new ArrayList<Student>();
	
	public AbstractTableModelStudent() {
 		ArrayList<Student> listaStudenata= BazaStudenata.getInstance().getStudenti(); 
 		this.listaStudenata = listaStudenata;
 	}
	
	
 	public ArrayList<Student> getListaStudenata() {
		return listaStudenata;
	}

	public void setListaStudenata(ArrayList<Student> listaStudenata) {
		this.listaStudenata = listaStudenata;
	}
	
	@Override
 	public boolean isCellEditable(int row,int column) {
 		return column==11;
 		
 	}
	// broj redova
	@Override
	public int getRowCount() {
		//return BazaStudenata.getInstance().getStudenti().size();
		return listaStudenata.size();
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		//return BazaStudenata.getInstance().getColumnCount();
		return kolone.length;
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		//return BazaStudenata.getInstance().getColumnName(column);
		return kolone[column];
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		Student student=listaStudenata.get(rowIndex);
 		return student.toCell(columnIndex);
	}
	

}
