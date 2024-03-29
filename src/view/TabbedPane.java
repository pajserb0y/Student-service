package view;


import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import model.AbstractTableModelPredmet;
import model.AbstractTableModelProfesor;
import model.AbstractTableModelStudent;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import view.predmet.PredmetJTable;
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
    public static JTable tabelaPredmeta;
	
	private TabbedPane() {
		
		tabelaStudenata = new StudentiJTable();
		tabelaProfesora = new ProfesorJTable();
		tabelaPredmeta = new PredmetJTable();
	
		JScrollPane scrollPaneS = new JScrollPane(tabelaStudenata);
		addTab("Student", scrollPaneS);
		
		JScrollPane scrollPaneP = new JScrollPane(tabelaProfesora);
		addTab("Profesor",scrollPaneP);
		
		JScrollPane scrollPanePred = new JScrollPane(tabelaPredmeta);
		addTab("Predmet",scrollPanePred);
	}
	
	public static void azurirajPrikaz(String akcija, int vrednost) {
		
		AbstractTableModelStudent modelStudent=(AbstractTableModelStudent) tabelaStudenata.getModel();
		modelStudent.setSpisakSt(BazaStudenata.getInstance().getStudenti());
		modelStudent.fireTableDataChanged();
		
		AbstractTableModelProfesor modelProfesor = (AbstractTableModelProfesor) tabelaProfesora.getModel();
		modelProfesor.setSpisakProf(BazaProfesora.getInstance().getProfesori());
		modelProfesor.fireTableDataChanged();
		
		AbstractTableModelPredmet modelPredmet = (AbstractTableModelPredmet) tabelaPredmeta.getModel();
		modelPredmet.setSpisakPred(BazaPredmeta.getInstance().getPredmeti());
		modelPredmet.fireTableDataChanged();
	}

}
