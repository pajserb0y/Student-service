package view.student;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.AbstractTableModelStudent;


public class StudentiJTable extends JTable {

	private static final long serialVersionUID = 1L;
	TableRowSorter<TableModel> sorter;

	public StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Sama JTable komponenta je implementirana postujuci MVC arhitekturu.
		this.setModel(new AbstractTableModelStudent());
		this.getTableHeader().setReorderingAllowed(false);
//		this.setAutoCreateRowSorter(true);
		sorter = new TableRowSorter<TableModel>(this.getModel());
	    this.setRowSorter(sorter);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		// Svaka celija ima renderer, koji se poziva prilikom njenog iscrtavanja.
		// Podrazumevano se pozivaju prilikom inicijalnog iscrtavanja tabele.
		// Ukoliko korisnik selektuje neku celiju, dolazi do ponovnog
		// iscrtavanje svih celija u redu koji je selektovan, kao i u redu
		// koji je prethodno bio selektovan.
		// TODO: Probati na primeru!
		// System.out.println(row + " " + column);
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			if(row%2!=0)
				c.setBackground(new Color(230, 230, 230));
			else
				c.setBackground(Color.WHITE);
		}			
		return c;
	}
	
	
}
