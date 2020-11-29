package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

public class StatusBar extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusBar() {
		// TODO Auto-generated constructor stub
		
		this.setLayout(new BorderLayout());
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JPanel levi= new JPanel();
		levi.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		
		JLabel naziv= new JLabel("StatusBar");
		naziv.setText("Studentska sluzba");
		levi.add(naziv);
		
		JPanel desni=new JPanel();
		desni.setLayout(new FlowLayout(FlowLayout.RIGHT,10,5));
		
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm  dd.MMM.yyyy");
		JLabel vreme=new JLabel(sdf.format(new GregorianCalendar().getTime()));
		Timer timer=new Timer(500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vreme.setText(DateFormat.getDateTimeInstance().format(new Date()));
				
			}
		});
		
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.start();          
		desni.add(vreme);
		
		this.add(levi, BorderLayout.WEST);
        this.add(desni, BorderLayout.EAST);
		
	}

}
