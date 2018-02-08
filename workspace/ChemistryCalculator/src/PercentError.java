
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class PercentError extends JFrame
{
	JLabel equationJL, descriptionJL, variableJL;
	JComboBox variablesJCB, pagesJCB;
	JButton solveJB;
	JTextField aVJTF, eVJTF, peJTF;
	JButton backJB;
	double aV, eV, pE;
	
	
	
	public PercentError() 
	{
	      createUserInterface();
	}
	// create and position GUI components; register event handlers
	private void createUserInterface()
	{
		// get content pane for attaching GUI components
	    final Container contentPane = getContentPane();

	    // enable explicit positioning of GUI components
	    contentPane.setLayout( null ); 
	    
	    Font font1 = new Font("SanSerif", Font.PLAIN, 40);
	    final Font fontf = new Font("SanSerif", Font.PLAIN, 24);
		final Font font2 = new Font("SanSerif", Font.PLAIN, 20);
		final Font font3 = new Font("SanSerif", Font.PLAIN, 16);
		final Font font4 = new Font("SanSerif", Font.PLAIN, 14);
	    
		
		
	    descriptionJL = new JLabel("Percent Error");
	    descriptionJL.setBounds(290, 15, 600, 50);
	    descriptionJL.setFont(font1);
	    contentPane.add(descriptionJL);
	    
	    
	    descriptionJL = new JLabel("The difference between Approximate and Exact Values, as a percentage of the Exact Value.");
	    descriptionJL.setBounds(35, 65, 750 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    equationJL = new JLabel("The equation is:");
	    equationJL.setBounds(295, 100, 400, 60);
	    equationJL.setFont(fontf);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("PE = (EV - AV)/AV");
	    equationJL.setBounds(275, 125, 550, 60);
	    equationJL.setFont(fontf);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where EV is the experimental value");
	    equationJL.setBounds(100, 150, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where AV is the accepted value");
	    equationJL.setBounds(400, 150, 700, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("");
	    equationJL.setBounds(385, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	   
	    
	    descriptionJL = new JLabel("Plug in the numbers");
	    descriptionJL.setBounds(265, 215, 400, 60);
	    descriptionJL.setFont(fontf);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("Accepted Value");
	    descriptionJL.setBounds(225, 255, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    aVJTF = new JTextField();
	    aVJTF.setBounds(350, 270, 175, 35);
	    contentPane.add(aVJTF);
	    
	    descriptionJL = new JLabel("Experimental Value");
	    descriptionJL.setBounds(195, 310, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    eVJTF = new JTextField();
	    eVJTF.setBounds(350, 325, 175, 35);
	    contentPane.add(eVJTF);
	    
	    descriptionJL = new JLabel("Percent Error:");
	    descriptionJL.setBounds(235, 365, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    peJTF = new JTextField();
	    peJTF.setBounds(350, 380, 175, 35);
	    peJTF.setEditable(false);
	    contentPane.add(peJTF);
	    
	   
	    solveJB = new JButton("Find percent Error");
	    solveJB.setBounds(265, 430, 250, 70);
	    contentPane.add(solveJB);
	    solveJB.addActionListener(
	    		new ActionListener()
	    		{
	    			public void actionPerformed(ActionEvent e)
	    			{
        				Color color = new Color(252,0,0);

	    				try
	    				{
	    					aV = Double.parseDouble(aVJTF.getText());
	    					eV = Double.parseDouble(eVJTF.getText());
	    					
	    					
	    					pE = ((eV - aV)/aV) * 100;
	    					peJTF.setText(String.valueOf(pE) + "%");
	    					peJTF.setForeground(color);
	    					
	    				}
	    				catch(Exception p)
	    				{
	    					if(eVJTF.getText().equals("") || aVJTF.getText().equals(""))
	    					{
	    						JOptionPane.showMessageDialog(null, "ERROR!!! Please fill in all the correct text fields", "ERROR",
	    	    						
	    	    						JOptionPane.ERROR_MESSAGE);
	    					}
	    					else 
	    					{
	    					JOptionPane.showMessageDialog(null, "ERROR!!! Go back and put in Integers ONLY!!!", "ERROR",
	    						
	    						JOptionPane.ERROR_MESSAGE);
	    					}
	    					
	    				}
	    			}
	    		}
	    	);
	    
	    pagesJCB = new JComboBox();
	    pagesJCB.setBounds(510, 5, 275, 20);
	    pagesJCB.addItem("Click to navigate to another page");
	    pagesJCB.addItem("Colligative Properties");
	    pagesJCB.addItem("Dilutions");
	    pagesJCB.addItem("Ideal Gas Laws");
	    pagesJCB.addItem("Molarity");
	    pagesJCB.addItem("Molar Mass");
	    pagesJCB.addItem("Percent Error");
	    pagesJCB.addItem("pH and pOH calculations");
	    pagesJCB.addItem("Wave Relations");
	    pagesJCB.setMaximumRowCount( 9 );
	    contentPane.add(pagesJCB);
	    pagesJCB.addActionListener(
	    		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				
        				if (pagesJCB.getSelectedItem().equals("Colligative Properties"))
        				{
        					dispose();
    						ColligativeProperties app2 = new ColligativeProperties();
    						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    						app2.setVisible(true);
        				}
        				
        				else if (pagesJCB.getSelectedItem().equals("Dilutions"))
        				{
        					dispose();
    						Dilutions app2 = new Dilutions();
    						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    						app2.setVisible(true);
        				}
        				
        				else if (pagesJCB.getSelectedItem().equals("Ideal Gas Laws"))
        				{
        					dispose();
    						IdealGases app2 = new IdealGases();
    						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    						app2.setVisible(true);
        				}
        				
        				else if (pagesJCB.getSelectedItem().equals("Molarity"))
        				{
        					dispose();
    						Molarity app2 = new Molarity();
    						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    						app2.setVisible(true);
        				}
        				
        				else if (pagesJCB.getSelectedItem().equals("Molar Mass"))
        				{
        					dispose();
    						MolarMass app2 = new MolarMass();
    						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    						app2.setVisible(true);
        				}
        				
        				else if (pagesJCB.getSelectedItem().equals("Molar Mass"))
        				{
        					dispose();
    						MolarMass app2 = new MolarMass();
    						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    						app2.setVisible(true);
        				}
        				
        				else if (pagesJCB.getSelectedItem().equals("Percent Error"))
        				{
        					dispose();
            				PercentError app8 = new PercentError();
            				app8.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            				app8.setVisible(true);
        				}
        				
        				else if (pagesJCB.getSelectedItem().equals("pH and pOH calculations"))
        				{
        					dispose();
        					PHPOH app9 = new PHPOH();
        					app9.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        					app9.setVisible(true);
        				}
        				
        				else if (pagesJCB.getSelectedItem().equals("Wave Relations"))
        				{
        					dispose();
    						Wave app2 = new Wave();
    						app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    						app2.setVisible(true);
        				}
        				
        			}
        		}
	    	);
	    // set properties of application is window
	    setTitle( "Molarity" ); // set title bar text
		setSize( 800, 550 );     // set window size
		setVisible(false);
		setLayout(null);
		setResizable(false);
		setBackground(new Color(240,210,30));
	}

}

