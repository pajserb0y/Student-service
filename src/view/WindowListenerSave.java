package view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;
import model.Student.STATUS;

public class WindowListenerSave implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		JFrame prozor = (JFrame) e.getComponent();
		int izbor = JOptionPane.showConfirmDialog(prozor, "Da li ste sigurni da želite da zatvorite aplikaciju?",
				"ZATVARANJE APLIKACIJE", JOptionPane.YES_NO_OPTION);
		if (izbor != JOptionPane.YES_OPTION) {
			prozor.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else {
			prozor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			cuvanjeStudenata(BazaStudenata.getInstance().getStudenti());
			cuvanjePredmeta(BazaPredmeta.getInstance().getPredmeti());
			cuvanjeProfesora(BazaProfesora.getInstance().getProfesori());

		}
	}
	public static void cuvanjeStudenata(ArrayList<Student> listaStudenata) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.");
		String datumRodj;
		BufferedWriter bw = null;
			try { 
				bw = new BufferedWriter(new FileWriter("src\\baze\\bazastudenata.txt"));
				for (Student s : listaStudenata) {
					Date datum = s.getDatRodj();
					datumRodj = formatter.format(datum);
					STATUS status = s.getStatus();
					String statusStr = (status == STATUS.S) ? "S" : "B";
					
					bw.write(s.getBrIndeksa() + ";" + s.getIme() + ";" + s.getPrezime() + ";" + s.getTrenutnaGodStudija() + ";" + datumRodj + ";" 
							+ s.getAdresaStan() + ";" + s.getTelefon() + ";" + s.getEmail() + ";" + statusStr + ";"
							+ s.getGodUpisa() + ";" + s.getProsek());
				
					bw.write("\n");
				}
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void cuvanjeProfesora(ArrayList<Profesor> listaProfesora) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.");
		String datumRodj;
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("src\\baze\\bazaprofesora.txt"));
			for (Profesor p : listaProfesora) {
				Date datum = p.getDatRodj();
				datumRodj = formatter.format(datum);
				bw.write(p.getBrLicne() + ";" + p.getIme() + ";" + p.getPrezime() + ";" + datumRodj + ";" + p.getAdresaStan() + ";" + p.getTelefon()
						+ ";" + p.getEmail() + ";" + p.getAdresaKanc() + ";" + p.getTitula() + ";" + p.getZvanje());

				bw.write("\n");
			}
			bw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public  static void cuvanjePredmeta(ArrayList<Predmet> listaPredmeta) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("src\\baze\\bazapredmeta.txt"));
			for (Predmet p : listaPredmeta) {

				bw.write(p.getSifraPred() + ";" + p.getNazPred() + ";" + p.getGodStud() + ";" + p.getEspb() + ";" + p.getSemestar());

				bw.write("\n");
			}
			bw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
