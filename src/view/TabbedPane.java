package view;


import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


import model.AbstractTableModelStudent;
import model.BazaStudenata;
import view.profesor.ProfesorJTable;
import view.student.StudentiJTable;




public class TabbedPane extends JTabbedPane{
	
	private static final long serialVersionUID = 1L;
	
	private static TabbedPane instance = null;

	public static TabbedPane getInstance() {
		if (instance == null)
			instance = new TabbedPane();
		return instance;
	}
	
	public static JTable tabelaStudenata;
    public static JTable tabelaProfesora;
	
	public TabbedPane() {
		//this.setBackground(new Color(169,169,69));

		tabelaStudenata = new StudentiJTable();
		tabelaProfesora = new ProfesorJTable();
	
		JScrollPane scrollPaneS = new JScrollPane(tabelaStudenata);
		addTab("Student", scrollPaneS);
		
		JScrollPane scrollPaneP = new JScrollPane(tabelaProfesora);
		addTab("Profesor",scrollPaneP);
		
	}
	
	
	public static void azurirajPrikaz(String akcija, int vrednost) {
		
		AbstractTableModelStudent modelStudent=(AbstractTableModelStudent) tabelaStudenata.getModel();
		modelStudent.setListaStudenata(BazaStudenata.getInstance().getStudenti());
		
		modelStudent.fireTableDataChanged();
		

	}
}
