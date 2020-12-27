package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class DialogAbout extends JDialog{
	
	private static final long serialVersionUID = 1L;

	
	public DialogAbout(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(2*screenWidth/5, 2*screenHeight/3);
		setLocationRelativeTo(null);
		setTitle("About");
		
		JTextArea textArea = new JTextArea(20, 30);
	    textArea.setEditable(false);
	    textArea.append("Aplikacija koja simulira rad studentske sluzbe. Verzija 32.0\n"
	    		+ "Aplikaciju su napravili Nikola Kajtes (student1) i Marko Nikolic (student2).\n\n"
	    		+ "Nikola Kajtes je student treće godine Fakulteta Tehničkih Nauka, rodjen u\n "
	    		+ "Novom Sadu, završio gimnaziju <Jovan Jovanovic Zmaj> i 2018. godine upisao\n"
	    		+ "FTN, smer Računarstvo i automatika. \n\n"
	    		+ "Marko Nikolic je student treće godine Fakulteta Tehničkih Nauka, rodjen u\n "
	    		+ "Novom Sadu, završio gimnaziju <Jovan Jovanovic Zmaj> i 2018. godine upisao\n"
	    		+ "FTN, smer Računarstvo i automatika. \n\n");
	    
	    getContentPane().add(textArea);
	}
}
