import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class PHPOH extends JFrame
{
	JLabel equationJL, descriptionJL, variableJL, firstJL, secondJL;
	JComboBox variablesJCB, pagesJCB;;
	JButton solveJB;
	JTextField firstJTF, secondJTF; 
	double pH, pOH, H, OH;
	
	
	
	public PHPOH() 
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
		final Font font2 = new Font("SanSerif", Font.PLAIN, 20);
		final Font font3 = new Font("SanSerif", Font.PLAIN, 16);
		final Font font4 = new Font("SanSerif", Font.PLAIN, 14);
	    
	    
	    descriptionJL = new JLabel("pH and pOH Calculations");
	    descriptionJL.setBounds(175, 15, 600, 50);
	    descriptionJL.setFont(font1);
	    contentPane.add(descriptionJL);
	    
	    
	    descriptionJL = new JLabel("Acids are compounds that have a hydrogen ion connected to another ion. A base is a compound");
	    descriptionJL.setBounds(20, 65, 765 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("that has a hydroxide ion attached to another ion. The pH scale measures how acidic or basic a");
	    descriptionJL.setBounds(25, 80, 745 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("substance is. The pH scale ranges from 1 to 14. A pH of 7 is neutral, a pH less than 7 is acidic");
	    descriptionJL.setBounds(25, 95, 745 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("and a pH greater than 7 is basic.");
	    descriptionJL.setBounds(310, 110, 715 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    equationJL = new JLabel("The equations are as in the picture:");
	    equationJL.setBounds(245, 125, 400, 60);
	    equationJL.setFont(font2);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("");
	    equationJL.setBounds(250, 55, 700, 500);
	    equationJL.setIcon(new ImageIcon("pHpOH.gif"));
	    equationJL.setFont(font2);
	    contentPane.add(equationJL);
	    
	    descriptionJL = new JLabel("Choose which conversion you want to do:");
	    descriptionJL.setBounds(225, 425, 500, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("");
	    descriptionJL.setBounds(340, 475, 500, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    equationJL = new JLabel("");
	    equationJL.setBounds(325, 505, 600, 60);
	    equationJL.setFont(font2);
	    contentPane.add(equationJL);

		Color color = new Color(252,0,0);
		Color black = new Color(0,0,0);
		
		firstJL = new JLabel("X");
		firstJL.setBounds(290, 570, 600, 60);
		firstJL.setFont(font2);
	    contentPane.add(firstJL);
		
	    firstJTF = new JTextField();
	    firstJTF.setBounds(345, 580, 175, 35);
	    firstJTF.setForeground(black);
	    contentPane.add(firstJTF);
	    
	    secondJL = new JLabel("Y");
	    secondJL.setBounds(290, 610, 600, 60);
	    secondJL.setFont(font2);
	    contentPane.add(secondJL);
	    
	    secondJTF = new JTextField();
	    secondJTF.setEditable(false);
	    secondJTF.setBounds(345, 630, 175, 35);
	    secondJTF.setForeground(color);
	    contentPane.add(secondJTF);
	   
	    variablesJCB = new JComboBox();
	    variablesJCB.setBounds(310, 465, 175, 20);
	    variablesJCB.addItem("--Conversion--");
	    variablesJCB.addItem("pH -> pOH");
	    variablesJCB.addItem("pOH -> pH");
	    variablesJCB.addItem("pH -> [H+]");
	    variablesJCB.addItem("[H+] -> pH");
	    variablesJCB.addItem("[H+] -> [OH-]");
	    variablesJCB.addItem("[OH-] -> [H+]");
	    variablesJCB.addItem("[OH-] -> pOH");
	    variablesJCB.addItem("pOH -> [OH-]");
	    variablesJCB.setMaximumRowCount( 9 );
	    contentPane.add(variablesJCB);
	    variablesJCB.addActionListener(
	    		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				if (variablesJCB.getSelectedItem().equals("pH -> pOH"))
        				{
        					firstJL.setText("");
        					secondJL.setText("");
        					repaint();
        					
        					descriptionJL.setText("Your equation is:");
        					equationJL.setText("pOH = 14 - pH");
        					firstJL.setText("pH:");
        					secondJL.setText("pOH:");
        				    repaint();
        					
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("pOH -> pH"))
        				{
        					firstJL.setText("");
        					secondJL.setText("");
        					repaint();
        					
        					descriptionJL.setText("Your equation is:");
        					equationJL.setText("pH = 14 - pOH");
        					firstJL.setText("pOH:");
        					secondJL.setText("pH:");
        				    repaint();
        					
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("pH -> [H+]"))
        				{
        					firstJL.setText("");
        					secondJL.setText("");
        					repaint();
        					
        					descriptionJL.setText("Your equation is:");
        					equationJL.setText("[H+] = 10^(-pH)");
        					firstJL.setText("pH:");
        					secondJL.setText("[H+]:");
        				    repaint();
        				}
        				
        				else if(variablesJCB.getSelectedItem().equals("[H+] -> pH"))
        				{      					
        					firstJL.setText("");
        					secondJL.setText("");
        					repaint();
        					
        					descriptionJL.setText("Your equation is:");
        					equationJL.setText("pH = -log([H+])");
        					firstJL.setText("[H+]:");
        					secondJL.setText("pH:");
        				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("[H+] -> [OH-]"))
        				{
        					firstJL.setText("");
        					secondJL.setText("");
        					repaint();
        					
        					descriptionJL.setText("Your equation is:");
        					equationJL.setText("[OH-] = (10^-14)/[H+]");
        					firstJL.setText("[H+]:");
        					secondJL.setText("[OH-]:");
        				    repaint();
        					
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("[OH] -> [H+]"))
        				{
        					firstJL.setText("");
        					secondJL.setText("");
        					repaint();
        					
        					descriptionJL.setText("Your equation is:");
        					equationJL.setText("[H+] = (10^-14)/[OH-]");
        					firstJL.setText("[OH-]:");
        					secondJL.setText("[H+]:");
        				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("pOH -> [OH-]"))
        				{
        					firstJL.setText("");
        					secondJL.setText("");
        					repaint();
        					
        					descriptionJL.setText("Your equation is:");
        					equationJL.setText("[OH-] = 10^(-pOH)");
        					firstJL.setText("pOH:");
        					secondJL.setText("[OH-]:");
        				    repaint();
        				}
        				
        				else if(variablesJCB.getSelectedItem().equals("[OH-] -> pOH"))
        				{
        					firstJL.setText("");
        					secondJL.setText("");
        					repaint();
        					
        					descriptionJL.setText("Your equation is:");
        					equationJL.setText("pOH = -log([OH-])");
        					firstJL.setText("[OH-]:");
        					secondJL.setText("pOH:");
        				    repaint();
        				}
        			}
        		});

	    solveJB = new JButton("Convert");
	    solveJB.setBounds(275, 680, 250, 70);
	    contentPane.add(solveJB);
	    solveJB.addActionListener(
	    		new ActionListener()
	    		{
	    			public void actionPerformed(ActionEvent e)
	    			{
	    				
	    				try
	    				{
	    					if (variablesJCB.getSelectedItem().equals("pH -> pOH"))
	        				{
	    						pH = Double.parseDouble(firstJTF.getText());
	        					pOH = 14 - pH;
	        					secondJTF.setText(String.valueOf(pOH));
	        				}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("pOH -> pH"))
	        				{
	    						pH = Double.parseDouble(firstJTF.getText());
	        					pOH = 14 - pH;
	        					secondJTF.setText(String.valueOf(pOH));
	        				}

	    					else if (variablesJCB.getSelectedItem().equals("pH -> [H+]"))
	        				{
	    						pH = Double.parseDouble(firstJTF.getText());
	        					H = Math.pow(10, (-pH));
	        					secondJTF.setText(String.valueOf(H));
	        				}
        				
	    					else if(variablesJCB.getSelectedItem().equals("[H+] -> pH"))
	        				{
	    						H = Double.parseDouble(firstJTF.getText());
	        					pH = (-1) * (Math.log10(H));
	        					secondJTF.setText(String.valueOf(pH));
	        				}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("[H+] -> [OH-]"))
	        				{
	    						H = Double.parseDouble(firstJTF.getText());
	        					OH = (Math.pow(10,-14))/H;
	        					secondJTF.setText(String.valueOf(OH));
	        					
	        				}
	        				
	        				else if (variablesJCB.getSelectedItem().equals("[OH] -> [H+]"))
	        				{
	        					OH = Double.parseDouble(firstJTF.getText());
	        					H = (Math.pow(10,-14))/OH;
	        					secondJTF.setText(String.valueOf(H));
	        				}
	        				
	        				else if (variablesJCB.getSelectedItem().equals("pOH -> [OH-]"))
	        				{
	        					pOH = Double.parseDouble(firstJTF.getText());
	        					OH = Math.pow(10, (-pOH));
	        					secondJTF.setText(String.valueOf(OH));
	        				}
	        				
	        				else if(variablesJCB.getSelectedItem().equals("[OH-] -> pOH"))
	        				{
	        					OH = Double.parseDouble(firstJTF.getText());
	        					pOH = (-1) * (Math.log10(OH));
	        					secondJTF.setText(String.valueOf(pOH));
	        				}
	    					
	    					else if(variablesJCB.getSelectedItem().equals("--Conversion--"))
	    					{
	    						JOptionPane.showMessageDialog(null, "Please choose a conversion", "ERROR",
	    	    						
	    								JOptionPane.ERROR_MESSAGE);
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("--Variable--"))
	    					{
	    						JOptionPane.showMessageDialog(null, "Please choose a variable", "ERROR",
	    	    						
	    								JOptionPane.ERROR_MESSAGE);
	    					}
	    				}
	    				catch(Exception p)
	    				{
	    					if(firstJTF.getText().equals(""))
	    					{
	    						JOptionPane.showMessageDialog(null, "ERROR!!! Please fill in a number in the text fields", "ERROR",
    	    						
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
	    setTitle( "Colligative Properties" ); // set title bar text
		setSize( 800, 900 );     // set window size
		setVisible(false);
		setLayout(null);
		setResizable(false);
		setBackground(new Color(240, 100 ,30));
	}

}

