package model;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;



public class AbstractTableModelStudent extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private String[] kolone = {"Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek"};
	private ArrayList<Student> listaStudenata = new ArrayList<Student>();
	
//	for(int i=1; i<= listaStudenata.getRowCount(); i++)
//	{
//		if (row % 2 == 0) {
//			c.setBackground(Color.WHITE);
//		} else {
//		    c.setBackground(Color.LIGHT_GRAY);
//		}
//	}
	
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
	public int getRowCount() {
		return listaStudenata.size();
	}
	
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student=listaStudenata.get(rowIndex);
 		return student.toCell(columnIndex);
	}
	

}
