import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class OptionsPage extends JFrame
{
	JButton backJB;
	JButton colligativeJB, dilutionJB, 
	idealGasJB, molarityJB ,
	molarMassJB,percentErrorJB, 
	pHJB, waveJB; 
	JPanel everythingJP;
	JLabel titleJL, instructionsJL, horJL, vertJL;
	Line2D line;
	
	
	
	public OptionsPage() 
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
	    
	    
		Font font1 = new Font("SanSerif", Font.PLAIN, 40);
		Font font2 = new Font("SanSerif", Font.PLAIN, 18);
		Font font3 = new Font("SanSerif", Font.PLAIN, 13);

	    
	   
		titleJL = new JLabel();
		titleJL.setBounds(125, -15, 600, 100);
		titleJL.setText("Pick Your Type of Equation");
		titleJL.setFont(font1);
	    contentPane.add(titleJL);
	    
	    everythingJP = new JPanel();
	    everythingJP.setBounds(25, 75, 750, 475);
	    everythingJP.setVisible(true);
	    everythingJP.setLayout(null);
	    everythingJP.setBorder(new TitledBorder(""));
	    contentPane.add(everythingJP);
	    
	    horJL = new JLabel();
	    horJL.setBounds(-20, 0, 900, 4);
	    horJL.setIcon(new ImageIcon("horizontal.png"));
	    everythingJP.add(horJL);
	    
	    horJL = new JLabel();
	    horJL.setBounds(-20, 118, 900, 4);
	    horJL.setIcon(new ImageIcon("horizontal.png"));
	    everythingJP.add(horJL);
	    
	    horJL = new JLabel();
	    horJL.setBounds(-20, 236, 900, 4);
	    horJL.setIcon(new ImageIcon("horizontal.png"));
	    everythingJP.add(horJL);
	    
	    horJL = new JLabel();
	    horJL.setBounds(-20, 354, 900, 4);
	    horJL.setIcon(new ImageIcon("horizontal.png"));
	    everythingJP.add(horJL);
	    
	    horJL = new JLabel();
	    horJL.setBounds(-20, 471, 900, 4);
	    horJL.setIcon(new ImageIcon("horizontal.png"));
	    everythingJP.add(horJL);
	    
	    vertJL = new JLabel();
	    vertJL.setBounds(0,-5, 4, 600);
	    vertJL.setIcon(new ImageIcon("vertical.png"));
	    everythingJP.add(vertJL);
	    
	    vertJL = new JLabel();
	    vertJL.setBounds(187,-5, 4, 600);
	    vertJL.setIcon(new ImageIcon("vertical.png"));
	    everythingJP.add(vertJL);
	    
	    vertJL = new JLabel();
	    vertJL.setBounds(373,-5, 4, 600);
	    vertJL.setIcon(new ImageIcon("vertical.png"));
	    everythingJP.add(vertJL);
	    
	    vertJL = new JLabel();
	    vertJL.setBounds(560,-5, 4, 600);
	    vertJL.setIcon(new ImageIcon("vertical.png"));
	    everythingJP.add(vertJL);
	    
	    vertJL = new JLabel();
	    vertJL.setBounds(746,-5, 4, 600);
	    vertJL.setIcon(new ImageIcon("vertical.png"));
	    everythingJP.add(vertJL);
	    
	    colligativeJB = new JButton("Colligative Properties");
	    colligativeJB.setBounds(20, 25, 150, 75);
	    everythingJP.add(colligativeJB);
	    colligativeJB.addActionListener(
	    		new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						dispose();
						ColligativeProperties app2 = new ColligativeProperties();
						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						app2.setVisible(true);
					}
				}
	    		);
	    
	    
	    
	  
	    dilutionJB = new JButton("Dilutions");
	    dilutionJB.setBounds(390, 25, 150, 75);
	    everythingJP.add(dilutionJB);
	    dilutionJB.addActionListener(
	    		new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						dispose();
						Dilutions app2 = new Dilutions();
						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						app2.setVisible(true);
					}
				}
	    		);
	    
	    molarityJB = new JButton("Molarity");
	    molarityJB.setBounds(580, 140, 150, 75);
	    everythingJP.add(molarityJB);
	    molarityJB.addActionListener(
	    		new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						dispose();
						Molarity app2 = new Molarity();
						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						app2.setVisible(true);
					}
				}
	    		);
	    
	   
	    
	    idealGasJB = new JButton("Ideal Gases");
	    idealGasJB.setBounds(210, 140, 150, 75);
	    everythingJP.add(idealGasJB);
	    idealGasJB.addActionListener(
	    		new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						dispose();
						IdealGases app23 = new IdealGases();
						app23.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						app23.setVisible(true);
					}
				}
	    		);
	  
	    
	   
	    
	 
	    
	    molarMassJB = new JButton("Molar Mass");
	    molarMassJB.setBounds(20, 255, 150, 75);
	    everythingJP.add(molarMassJB);
	    molarMassJB.addActionListener(
	    		new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						dispose();
						MolarMass app2 = new MolarMass();
						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						app2.setVisible(true);
					}
				}
	    		);
	    
	   
	    percentErrorJB = new JButton("Percent Error");
	    percentErrorJB.setBounds( 390, 255, 150, 75);
	    everythingJP.add(percentErrorJB);
	    percentErrorJB.addActionListener(
	    new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				dispose();
				PercentError app8 = new PercentError();
				app8.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				app8.setVisible(true);
			}
		}
	    );
	   
	    
	    pHJB  = new JButton("pH and POH problems");
	    pHJB.setBounds(210, 370, 150, 75);
	    everythingJP.add(pHJB);
	    pHJB.addActionListener(
	    		new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						dispose();
						PHPOH app9 = new PHPOH();
						app9.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						app9.setVisible(true);
					}
				}
	    	);
	    
	    waveJB = new JButton("Wave Relation");
	    waveJB.setBounds(580, 370, 150, 75);
	    everythingJP.add(waveJB);
	    waveJB.addActionListener(
	    		new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						dispose();
						Wave app2 = new Wave();
						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						app2.setVisible(true);
					}
				}
	    		);
	  
	    
	 // set properties of application is window
	    setTitle( "Rithvik's Chemistry Calculcator" ); // set title bar text
		setSize( 800, 600 );     // set window size
		setVisible(false);
		setBackground(new Color(30,144,255));
	}

}
