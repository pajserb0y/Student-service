package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;

public class ActionListenerSearch implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = TabbedPane.getInstance().getSelectedIndex();
		if(index == 0){
			String unos = Toolbar.txtSearch.getText().toLowerCase().trim();
			String ime = "";
			String prezime = "";
			String indeks = "";
			
			if (unos.contains(" ")) {
				
				String[] tokensPom = unos.toLowerCase().split(" ");
				ArrayList<String> tokens = new ArrayList<>();
				
				for(int i = 0; i < tokensPom.length; ++i) //izbacivanje viska razmaka u sredni ako postoje
					if(!tokensPom[i].equals("")) 
						tokens.add(tokensPom[i]);

				if(tokens.size() > 3) {
					JOptionPane.showMessageDialog(null, "Morate pravilno da unesete parametre pretrage studenta!");
					return;
				}
				if(tokens.size() == 3){
					prezime = tokens.get(0);
					ime = tokens.get(1);
					indeks = tokens.get(2);
					if(!ime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") || !prezime.matches("[A-Za-zšđžćčŠĐŽČĆ]+")) {
						JOptionPane.showMessageDialog(null,"\tNAPOMENA: Parametri pretrage studenta su Prezime i Ime i sastoje se samo od slova!");
						return;
					}
				}else if(tokens.size() == 2){
					prezime = tokens.get(0);
					ime = tokens.get(1);
					if(!ime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") || !prezime.matches("[A-Za-zšđžćčŠĐŽČĆ]+")) {
						JOptionPane.showMessageDialog(null,"\tNAPOMENA: Parametri pretrage studenta su Prezime i Ime i sastoje se samo od slova!");
						return;
					}
				}else if(tokens.size() == 1){
					prezime = tokens.get(0);
					if(!ime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") || !prezime.matches("[A-Za-zšđžćčŠĐŽČĆ]+")) {
						JOptionPane.showMessageDialog(null,"\tNAPOMENA: Parametri pretrage studenta su Prezime i Ime i sastoje se samo od slova!");
						return;
					}
				}
			}else{
				prezime = unos;
				if(!prezime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") && !prezime.isEmpty()) {
					JOptionPane.showMessageDialog(null,"\tNAPOMENA: Parametri pretrage studenta su Prezime i Ime i sastoje se samo od slova!");
					return;
				}
			}
			StudentController.getInstance().pretraziStudenta(ime, prezime, indeks);
			
		}else if (index == 1) {
			String unos = Toolbar.txtSearch.getText().toLowerCase().trim();

			String ime ="";
			String prezime ="";
			
			if (unos.contains(" ")) {
				
				String[] tokensPom = unos.toLowerCase().split(" ");
				ArrayList<String> tokens = new ArrayList<>();
				
				for(int i = 0; i < tokensPom.length; ++i) //izbacivanje viska razmaka u sredni ako postoje
					if(!tokensPom[i].equals("")) 
						tokens.add(tokensPom[i]);

				if(tokens.size() > 2) {
					JOptionPane.showMessageDialog(null, "Morate pravilno da unesete parametre pretrage profesora!");
					return;
				}
				else {
					prezime = tokens.get(0);
					ime = tokens.get(1);
					if(!ime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") || !prezime.matches("[A-Za-zšđžćčŠĐŽČĆ]+")) {
						JOptionPane.showMessageDialog(null,"\tNAPOMENA: Parametri pretrage profesora su Ime i prezime i sastoje se samo od slova!");
						return;
					}
				}
			}else {
				prezime = unos;
				if(!prezime.matches("[A-Za-zšđžćčŠĐŽČĆ]+") && !prezime.isEmpty()) {
					JOptionPane.showMessageDialog(null,"\tNAPOMENA: Parametri pretrage profesora su Ime i prezime i sastoje se samo od slova!");
					return;
				}
			}
			ProfesorController.getInstance().pretraziProfesora(ime, prezime);
			
		}else if(index == 2) {		
			String naziv = Toolbar.txtSearch.getText().toLowerCase().trim();
			PredmetController.getInstance().pretraziPredmet(naziv);
		}
	}
}
