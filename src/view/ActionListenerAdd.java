package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.predmet.AddPredmetDialog;
import view.profesor.AddProfesorDialog;
import view.student.AddStudentDialog;


public class ActionListenerAdd implements ActionListener {

	public static AddStudentDialog dialogStd;
	public static AddProfesorDialog dialogProf;
	public static AddPredmetDialog dialogPred;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int index = TabbedPane.getInstance().getSelectedIndex();

		dialogStd = new AddStudentDialog(null, "Dodavanje studenta", true);
		dialogProf = new AddProfesorDialog(null,"Dodavanje profesora",true);
		dialogPred = new AddPredmetDialog(null, "Dodavanje predmeta", true);
		 
		if(index == 0) {
			
			dialogStd.setVisible(true);
			AddStudentDialog.txtIme.setText("");
			AddStudentDialog.txtPrz.setText("");
			AddStudentDialog.txtDat.setText("");
			AddStudentDialog.txtAdresa.setText("");
			AddStudentDialog.txtTel.setText("");
			AddStudentDialog.txtEmail.setText("");
			AddStudentDialog.txtIndeks.setText("");
			//AddStudentDialog.txtProsek.setText("");
			AddStudentDialog.txtGodUpisa.setText("");

		}	
		else if(index == 1){
			dialogProf.setVisible(true);
			AddProfesorDialog.txtIme.setText("");
			AddProfesorDialog.txtPrz.setText("");
			AddProfesorDialog.txtDat.setText("");
			AddProfesorDialog.txtTel.setText("");
			AddProfesorDialog.txtAdr.setText("");
			AddProfesorDialog.txtAdrKanc.setText("");
			AddProfesorDialog.txtBrLk.setText("");
			AddProfesorDialog.txtEmail.setText("");
			AddProfesorDialog.titula.removeAllItems();
			AddProfesorDialog.zvanje.removeAllItems();
		}else if(index == 2) {
			dialogPred.setVisible(true);
			AddPredmetDialog.txtNaz.setText("");
			AddPredmetDialog.txtSif.setText("");
			AddPredmetDialog.txtProf.setText("");
			AddPredmetDialog.txtEspb.setText("");
			AddPredmetDialog.godStud.removeAllItems();
			AddPredmetDialog.semest.removeAllItems();
		}
	}

}
