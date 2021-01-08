package view.profesor;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.AbstractTableModelProfesor;


public class ProfesorJTable extends JTable{
	
	public ProfesorJTable()
	{
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesor());
		this.getTableHeader().setReorderingAllowed(false);
		this.setAutoCreateRowSorter(true);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
		Component c = super.prepareRenderer(renderer, row, col);
		if(isRowSelected(row))
			c.setBackground(Color.LIGHT_GRAY);
		else{
			if(row%2!=0)
				c.setBackground(new Color(230, 230, 230));
			else
				c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	
}
