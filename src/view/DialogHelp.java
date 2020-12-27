package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JTextArea;

public class DialogHelp extends JDialog{

	private static final long serialVersionUID = 1L;

	public DialogHelp(){
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(2*screenWidth/5, 2*screenHeight/3);
		setLocationRelativeTo(null);
		setTitle("Help");
		
		/**REFERENCA: https://docs.oracle.com/javase/tutorial/uiswing/components/ */
		
		
	    JTextArea textArea = new JTextArea(20, 30);
	    textArea.setEditable(false);
	    textArea.append("Za domaci 1 je uradjen glavni prozor u kome pozivamo objekte toolbara, menubara i statusbara, cije su \n"
	    				+ "funkcije implementirane u posebnim klasama. \n"
	    				+ "U menubaru postoje 3 polja (File, Edit, Help) a u okviru svakog od njih ima jos stavki: \n"
	    				+  "-File: New i Close \n"
	    				+  "-Edit: Edit i Delete \n"
	    				+  "-Help: Help i About \n"
	    				+ "Precice su date u okviru mnemonika za svaku stavku. \n"
	    				+ "Sve stavke koje se nalaze u menubaru se nalaze i u implementiranom toolbaru, zajedno sa text fieldom i button-om za search. \n"
	    				+ "Statusbar sadrzi naslov aplikacije i in-time promenu vremena i datuma. \n"
	    				+ "kasnije ce se dodatno implementirati i ostale sve metode i zadaci projekta. \n"
	    				+ "-------------------------------------------------------------\n"
	    				+ "Za domaci 2 je omogucen prikaz i dodavanje novi studenata i profesora. \n"
	    				+ "Dodati su ActionListeneri na toolbar i menubar. \n");
	    
	    getContentPane().add(textArea); 
	}
}

