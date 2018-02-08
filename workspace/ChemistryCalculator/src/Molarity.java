
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


public class Molarity extends JFrame
{
	JLabel equationJL, descriptionJL, variableJL;
	JComboBox variablesJCB, pagesJCB;
	JButton solveJB;
	JTextField molarityJTF, molesJTF, volumeJTF;
	double molarity, mol, volume;
	
	
	
	public Molarity() 
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
	    
	    
	    descriptionJL = new JLabel("Molarity");
	    descriptionJL.setBounds(290, 15, 600, 50);
	    descriptionJL.setFont(font1);
	    contentPane.add(descriptionJL);
	    
	    
	    descriptionJL = new JLabel("Molarity is the number of moles of solute dissolved in one liter of solution.");
	    descriptionJL.setBounds(95, 65, 650 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("The units, therefore are moles per liter, specifically it's moles of solute per liter of solution.");
	    descriptionJL.setBounds(35, 85, 750 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    
	    
	    equationJL = new JLabel("The equation is:");
	    equationJL.setBounds(295, 115, 400, 60);
	    equationJL.setFont(fontf);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("M = n/v");
	    equationJL.setBounds(300, 145, 550, 60);
	    equationJL.setFont(fontf);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where M is the molarity");
	    equationJL.setBounds(150, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where n is the moles of solute");
	    equationJL.setBounds(150, 240, 700, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where v is the volume (in Liters) of solution");
	    equationJL.setBounds(385, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	   
	    
	    descriptionJL = new JLabel("Choose which variable you want to solve for:");
	    descriptionJL.setBounds(225, 275, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("Molarity(M)");
	    descriptionJL.setBounds(190, 435, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    molarityJTF = new JTextField();
	    molarityJTF.setBounds(275, 450, 175, 35);
	    contentPane.add(molarityJTF);
	    
	    descriptionJL = new JLabel("Moles(n)");
	    descriptionJL.setBounds(195, 490, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    molesJTF= new JTextField();
	    molesJTF.setBounds(275, 505, 175, 35);
	    contentPane.add(molesJTF);
	    
	    descriptionJL = new JLabel("Volume(v)");
	    descriptionJL.setBounds(190, 545, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    volumeJTF = new JTextField();
	    volumeJTF.setBounds(275, 560, 175, 35);
	    contentPane.add(volumeJTF);
	    
	    
	    descriptionJL = new JLabel("");
	    descriptionJL.setBounds(275, 345, 600, 60);
	    descriptionJL.setFont(font2);
	    contentPane.add(descriptionJL);
	    
	    variableJL = new JLabel("");
		variableJL.setBounds(280, 370, 600, 60);
		variableJL.setFont(font2);
		variableJL.setVisible(true);
		contentPane.add(variableJL);
	    repaint();
	   
	    
	    variablesJCB = new JComboBox();
	    variablesJCB.setBounds(310, 325, 135, 20);
	    variablesJCB.addItem("--Variable--");
	    variablesJCB.addItem("M");
	    variablesJCB.addItem("n");
	    variablesJCB.addItem("v");
	    variablesJCB.setMaximumRowCount( 4 );
	    contentPane.add(variablesJCB);
	    variablesJCB.addActionListener(
	    		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				Color color = new Color(252,0,0);
        				Color black = new Color(0,0,0);
        				
        				if (variablesJCB.getSelectedItem().equals("M"))
        				{
        					molarityJTF.setText(""); 
        					volumeJTF.setText("");
        					molesJTF.setText("");
        					
        					
        					molarityJTF.setForeground(color); 
        					volumeJTF.setForeground(black);
        					molesJTF.setForeground(black);
        					
        					
        					volumeJTF.setEditable(true); 
        					molesJTF.setEditable(true);
        					molarityJTF.setEditable(false);
        					
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("M = n/ v");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("v"))
        				{
        					molarityJTF.setText(""); 
        					volumeJTF.setText("");
        					molesJTF.setText("");
        				
        					
        					volumeJTF.setForeground(color);
        					molesJTF.setForeground(black);
        					molarityJTF.setForeground(black);
        					
        					volumeJTF.setEditable(false); 
        					molesJTF.setEditable(true);
        					molarityJTF.setEditable(true);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("v = M / n");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("n"))
        				{
        					molarityJTF.setText(""); 
        					volumeJTF.setText("");
        					molesJTF.setText("");
        					
        					
        					molarityJTF.setForeground(black); 
        					volumeJTF.setForeground(black);
        					molesJTF.setForeground(color);
        					
        					
        					molarityJTF.setEditable(true); 
        					molesJTF.setEditable(false);
        					volumeJTF.setEditable(true);
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("n = v * M");
         				    repaint();
        				}
        				
        			}
        		});

	    solveJB = new JButton("Solve for the variable");
	    solveJB.setBounds(200, 610, 250, 70);
	    contentPane.add(solveJB);
	    solveJB.addActionListener(
	    		new ActionListener()
	    		{
	    			public void actionPerformed(ActionEvent e)
	    			{
	    				
	    				try
	    				{
	    					if (variablesJCB.getSelectedItem().equals("M") )
	    					{
	    						volume = Double.parseDouble(volumeJTF.getText());
	    	    				mol = Double.parseDouble(molesJTF.getText());
	    	    				
	    	    				
	    	    				molarity = mol / volume;
	    	    				molarityJTF.setText(String.valueOf(molarity));
	    	    				
	    	    				
	    					}
	    					else if (variablesJCB.getSelectedItem().equals("n") ) 
	    					{
	    						molarity = Double.parseDouble(molarityJTF.getText());
	    						volume = Double.parseDouble(volumeJTF.getText());
	    	    				
	    	    				mol = molarity * volume;
	    	    				molesJTF.setText(String.valueOf(mol));
	    	    				System.out.println("yOL2O");
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("v"))
	    					{
	    						molarity = Double.parseDouble(molarityJTF.getText());
	    	    				mol = Double.parseDouble(molesJTF.getText());
	    	    				
	    	    				volume = mol / molarity ;
	    	    				volumeJTF.setText(String.valueOf(volume));
	    	    				
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("--Variable--"))
	    					{
	    						JOptionPane.showMessageDialog(null, "Please choose a variable", "ERROR",
	    	    						
	    								JOptionPane.ERROR_MESSAGE);
	    					}
	    					
	    				}
	    				catch(Exception p)
	    				{
	    					if(molarityJTF.getText().equals("") || molesJTF.getText().equals("") || volumeJTF.getText().equals(""))
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
		setSize( 800, 750 );     // set window size
		setVisible(false);
		setLayout(null);
		setResizable(false);
		setBackground(new Color(35,220,80));
	}

}

