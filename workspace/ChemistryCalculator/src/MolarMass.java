
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


public class MolarMass extends JFrame
{
	JLabel equationJL, descriptionJL, variableJL;
	JComboBox variablesJCB, pagesJCB;
	JButton solveJB;
	JTextField molarMassJTF, gramsJTF, molJTF;
	double molarMass, mol, grams;
	
	
	
	public MolarMass() 
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
	    
	    
	    descriptionJL = new JLabel("Molar Mass");
	    descriptionJL.setBounds(290, 15, 600, 50);
	    descriptionJL.setFont(font1);
	    contentPane.add(descriptionJL);
	    
	    
	    descriptionJL = new JLabel("In chemistry, the molar mass is a physical property. It is defined as the mass of a given substance ");
	    descriptionJL.setBounds(25, 45, 775 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("(chemical element or chemical compound)divided by its amount of substance.[1] The base SI unit for ");
	    descriptionJL.setBounds(5, 65, 850 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel(" molar mass is kg/mol. However, for historical reasons, molar masses are almost always expressed in");
	    descriptionJL.setBounds(0, 85, 950 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("g/mol.");
	    descriptionJL.setBounds(350, 105, 950 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    
	    equationJL = new JLabel("The equation is:");
	    equationJL.setBounds(295, 135, 400, 60);
	    equationJL.setFont(fontf);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("MM = m/n");
	    equationJL.setBounds(300, 155, 550, 60);
	    equationJL.setFont(fontf);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where MM is the molar mass");
	    equationJL.setBounds(100, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where m is the mass of substance");
	    equationJL.setBounds(100, 240, 700, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where n is the number of mols of substance");
	    equationJL.setBounds(385, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	   
	    
	    descriptionJL = new JLabel("Choose which variable you want to solve for:");
	    descriptionJL.setBounds(225, 275, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("Molar Mass(MM)");
	    descriptionJL.setBounds(150, 435, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    molarMassJTF = new JTextField();
	    molarMassJTF.setBounds(275, 450, 175, 35);
	    contentPane.add(molarMassJTF);
	    
	    descriptionJL = new JLabel("Mass(m)");
	    descriptionJL.setBounds(215, 490, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    gramsJTF= new JTextField();
	    gramsJTF.setBounds(275, 505, 175, 35);
	    contentPane.add(gramsJTF);
	    
	    descriptionJL = new JLabel("Moles(n)");
	    descriptionJL.setBounds(210, 545, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    molJTF = new JTextField();
	    molJTF.setBounds(275, 560, 175, 35);
	    contentPane.add(molJTF);
	    
	    
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
	    variablesJCB.addItem("MM");
	    variablesJCB.addItem("m");
	    variablesJCB.addItem("n");
	    variablesJCB.setMaximumRowCount( 4 );
	    contentPane.add(variablesJCB);
	    variablesJCB.addActionListener(
	    		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				Color color = new Color(252,0,0);
        				Color black = new Color(0,0,0);
        				
        				if (variablesJCB.getSelectedItem().equals("MM"))
        				{
        					molarMassJTF.setText(""); 
        					molJTF.setText("");
        					gramsJTF.setText("");
        					
        					
        					molarMassJTF.setForeground(color); 
        					molJTF.setForeground(black);
        					gramsJTF.setForeground(black);
        					
        					
        					molJTF.setEditable(true); 
        					gramsJTF.setEditable(true);
        					molarMassJTF.setEditable(false);
        					
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("MM = m/n");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("n"))
        				{
        					molarMassJTF.setText(""); 
        					molJTF.setText("");
        					gramsJTF.setText("");
        				
        					
        					molJTF.setForeground(color);
        					gramsJTF.setForeground(black);
        					molarMassJTF.setForeground(black);
        					
        					molJTF.setEditable(false); 
        					gramsJTF.setEditable(true);
        					molarMassJTF.setEditable(true);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("n = m/MM");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("m"))
        				{
        					molarMassJTF.setText(""); 
        					molJTF.setText("");
        					gramsJTF.setText("");
        					
        					
        					molarMassJTF.setForeground(black); 
        					molJTF.setForeground(black);
        					gramsJTF.setForeground(color);
        					
        					
        					molarMassJTF.setEditable(true); 
        					gramsJTF.setEditable(false);
        					molJTF.setEditable(true);
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("m = n * MM");
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
	    					if (variablesJCB.getSelectedItem().equals("MM") )
	    					{
	    						mol = Double.parseDouble(molJTF.getText());
	    	    				grams = Double.parseDouble(gramsJTF.getText());
	    	    				
	    	    				
	    	    				molarMass = grams / mol;
	    	    				molarMassJTF.setText(String.valueOf(molarMass));
	    	    				
	    	    				
	    					}
	    					else if (variablesJCB.getSelectedItem().equals("n") ) 
	    					{
	    						molarMass = Double.parseDouble(molarMassJTF.getText());
	    						grams = Double.parseDouble(gramsJTF.getText());
	    	    				
	    	    				mol = grams/molarMass;
	    	    				molJTF.setText(String.valueOf(mol));
	    	    				System.out.println("yOL2O");
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("m"))
	    					{
	    						molarMass = Double.parseDouble(molarMassJTF.getText());
	    	    				mol = Double.parseDouble(molJTF.getText());
	    	    				
	    	    				grams = mol * molarMass ;
	    	    				gramsJTF.setText(String.valueOf(grams));
	    	    				
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("--Variable--"))
	    					{
	    						JOptionPane.showMessageDialog(null, "Please choose a variable", "ERROR",
	    	    						
	    								JOptionPane.ERROR_MESSAGE);
	    					}
	    					
	    				}
	    				catch(Exception p)
	    				{
	    					if(molarMassJTF.getText().equals("") || gramsJTF.getText().equals("") || molJTF.getText().equals(""))
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
		setBackground(new Color(220,240,30));
	}

}

