package view.profesor;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.AbstractTableModelSpisakPredmetaZaProfesora;

public class SpisakPredmetaJTable extends JTable {
	public SpisakPredmetaJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelSpisakPredmetaZaProfesora());
		this.getTableHeader().setReorderingAllowed(false);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		// TODO Auto-generated method stub
		Component c = super.prepareRenderer(renderer, row, column);
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
