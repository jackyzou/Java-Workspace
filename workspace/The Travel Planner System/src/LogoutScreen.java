import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LogoutScreen extends JWindow {
	//private static final long serialVersionUID = 1L;
	
	private JLabel saving,tps,rps,seperate,byJacky,thankyou;

	JPanel panel = new JPanel();
	JProgressBar progressBar = new JProgressBar();

	private JLabel wood;

	public LogoutScreen() {
		
		
		
		panel.setBackground(Color.YELLOW);
		panel.setLayout(null);
		panel.add(progressBar, BorderLayout.SOUTH);
		panel.setFocusable(true);
		
		
		thankyou= new JLabel("Thanks for using!");
		thankyou.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,80));
		thankyou.setBounds(0,120,670,460);
		thankyou.setForeground(Color.RED);
		thankyou.setVisible(true);
		panel.add( thankyou );
		
		tps = new JLabel(new ImageIcon("TPS-logo-med.png"));
		tps.setBounds(1, -1, 100, 104 );
		tps.setVisible(true);
		panel.add( tps );
		
		rps= new JLabel(new ImageIcon("rpsFinance.png"));
		rps.setBounds(120, 20, 125, 62 );
		rps.setVisible(true);
		panel.add( rps );
		
		seperate= new JLabel(new ImageIcon("seperate.png"));
		seperate.setBounds(57, 0, 100, 104 );
		seperate.setVisible(true);
		panel.add( seperate );
		
		byJacky= new JLabel(new ImageIcon("outthing.png"));
		byJacky.setBounds(-100, 130, 800, 776 );
		byJacky.setVisible(true);
		panel.add( byJacky );
		
		
		
		
		progressBar.setStringPainted(true);
		progressBar.setBounds(0,440,640,60);
		saving = new JLabel("Saving...");
		saving.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,20));
		saving.setBounds(0,420,170,60);
		panel.add(saving);
		add(panel);
		

		Timer timer = new Timer(50, new ActionListener() {
			int i = 0;

			public void actionPerformed(ActionEvent evt) {
				progressBar.setValue(i);
				i++;
				panel.repaint();
				
				if(i==50)
				{
					byJacky.setVisible(false);
					thankyou.setBounds(0,110,670,460);
				}
				if(i==55)
				{
			
					thankyou.setBounds(0,100,670,460);
				}
				if(i==60)
				{
	
					thankyou.setBounds(0,90,670,460);
				}
				if(i==65)
				{
	
					thankyou.setBounds(0,80,670,460);
				}
				if(i==70)
				{
			
					thankyou.setBounds(0,70,670,460);
				}
				if(i==75)
				{
				
					thankyou.setBounds(0,60,670,460);
				}
				if(i==80)
				{
				
					thankyou.setBounds(0,50,670,460);
				}
				if(i==85)
				{
					thankyou.setBounds(0,40,670,460);
				}
				if(i==90)
				{
					thankyou.setBounds(0,35,670,460);
				}
				if(i==95)
				{
					thankyou.setBounds(0,30,670,460);
				}
				
				
				if (i == 100) {
					((Timer) evt.getSource()).stop();
					dispose();
					
			System.exit(0);
					
				}
			}
		});
		timer.start();
		wood = new JLabel(new ImageIcon("wood_wallpaper_hp_png-1280x800.jpg"));
		wood.setBounds(0,0,960,600);
		panel.add(wood);
	}

	
}