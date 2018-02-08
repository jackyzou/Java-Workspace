import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HomeScreen extends JFrame
{
		private JLabel chemistJL, chemJL, chemRatJL, dangerJL, instructionsJL;
		private JButton enterJB;
	
	
	
		public HomeScreen() 
		{
		      createUserInterface();
		}
		// create and position GUI components; register event handlers
		private void createUserInterface()
		{
		
			// get content pane for attaching GUI components
		    Container contentPane = getContentPane();

		    // enable explicit positioning of GUI components
		    contentPane.setLayout( null ); 
		   
		    
			Font font1 = new Font("SanSerif", Font.PLAIN, 30);
			Font font2 = new Font("SanSerif", Font.PLAIN, 18);
			Font font3 = new Font("SanSerif", Font.PLAIN, 13);
		    
		    
		    chemistJL = new JLabel();
		    chemistJL.setBounds(645,-35,100,400); //sets everything (x,y, width, height)
		    chemistJL.setHorizontalAlignment(JLabel.CENTER);
		    chemistJL.setIcon(new ImageIcon("chemProf.gif"));
			contentPane.add( chemistJL );
		    
			chemJL = new JLabel();
			chemJL.setBounds(500, 215,150,200); //sets everything (x,y, width, height)
		    chemJL.setHorizontalAlignment(JLabel.CENTER);
		    chemJL.setIcon(new ImageIcon("chem.gif"));
			contentPane.add( chemJL );
		    
			chemRatJL = new JLabel();
			chemRatJL.setBounds(0,10,200,200); //sets everything (x,y, width, height)
			chemRatJL.setHorizontalAlignment(JLabel.CENTER);
			chemRatJL.setIcon(new ImageIcon("chemRat.gif"));
			contentPane.add( chemRatJL );			
			
			dangerJL = new JLabel();
			dangerJL.setBounds(125,150,200,200); //sets everything (x,y, width, height)
			dangerJL.setHorizontalAlignment(JLabel.CENTER);
			dangerJL.setIcon(new ImageIcon("danger.gif"));
			contentPane.add( dangerJL );
			
			instructionsJL = new JLabel("Welcome to the Chemistry Calculator");
			instructionsJL.setBounds(145, -15, 575, 100);
			instructionsJL.setFont(font1);
			instructionsJL.setForeground(Color.BLACK);
			contentPane.add(instructionsJL);
			
			enterJB = new JButton();
			enterJB.setText("Click to enter a magical world of Chemistry calculations");
			enterJB.setBackground(Color.BLACK);
			enterJB.setBounds(215, 115, 375, 75);
			contentPane.add(enterJB);
			enterJB.addActionListener(
					
					new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{

							dispose();
							OptionsPage app1 = new OptionsPage();
							app1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							app1.setVisible(true);
							
						}
					}
				);
			
			
			
		 // set properties of application is window
		    setTitle( "Welcome to Rithvik's Chemistry Calculator" ); // set title bar text
			setSize( 800, 400 );     // set window size
			setVisible( true );      // display window
			setBackground(new Color(255,255,255));
		}
}
