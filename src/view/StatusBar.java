package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

public class StatusBar extends JPanel{

	private static final long serialVersionUID = -7960319300551657388L;


	public StatusBar() {
		// TODO Auto-generated constructor stub
		
		
		this.setLayout(new BorderLayout());
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JPanel left = new JPanel();
		left.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		
		JLabel naziv = new JLabel("StatusBar");
		naziv.setText("Studentska sluzba");
		left.add(naziv);
		
		JPanel right = new JPanel();
		right.setLayout(new FlowLayout(FlowLayout.RIGHT,10,5));
		
		/**REFERENCA: https://stackoverflow.com/ 
		 * 			  http://www.java2s.com/Tutorial/Java/0040__Data-Type/FourdifferentdateformatsforfourcountriesUSUKGERMANYFRANCE.htm*/
		
		
	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm  dd.mm.yyyy");
		JLabel time = new JLabel(sdf.format(new GregorianCalendar().getTime()));
		Timer timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				time.setText(DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRENCH).format(new Date()) 
						   + "    " 
						   + DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMANY).format(new Date()));
				
			}
		});
		
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.start();          
		right.add(time);
		
		this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
		
	}

}
