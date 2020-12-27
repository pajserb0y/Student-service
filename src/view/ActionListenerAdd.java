package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.student.AddStudentDialog;


public class ActionListenerAdd implements ActionListener {

	public static AddStudentDialog dialogStd;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int index = TabbedPane.getInstance().getSelectedIndex();

		dialogStd = new AddStudentDialog(null, "Dodavanje studenta", true);
		 
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
	}

}
