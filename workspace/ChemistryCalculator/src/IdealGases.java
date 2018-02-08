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


public class IdealGases extends JFrame
{
	JLabel equationJL, descriptionJL, variableJL;
	JComboBox variablesJCB, pagesJCB;
	JButton solveJB;
	JTextField volumeJTF, atmosphereJTF, molJTF, temperatureJTF, constantJTF; 
	double R, mol, temp, atm, vol;
	
	
	
	public IdealGases() 
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
	    
	    
	    descriptionJL = new JLabel("Ideal Gases");
	    descriptionJL.setBounds(250, 15, 600, 50);
	    descriptionJL.setFont(font1);
	    contentPane.add(descriptionJL);
	    
	    
	    descriptionJL = new JLabel("Colligative properties are those properties of solutions that depend on the");
	    descriptionJL.setBounds(100, 75, 615 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("number of dissolved particles in solution, but not on the identities of the solutes. ");
	    descriptionJL.setBounds(75, 100, 650 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    equationJL = new JLabel("The equation is:");
	    equationJL.setBounds(295, 145, 400, 60);
	    equationJL.setFont(font2);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("R*mol*K = L*atm");
	    equationJL.setBounds(275, 175, 550, 60);
	    equationJL.setFont(font2);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where L is the volume in Liters");
	    equationJL.setBounds(25, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where atm is the atmospheric pressure in atms");
	    equationJL.setBounds(415, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where mol is the number of moles");
	    equationJL.setBounds(25, 250, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where K is the temperature in Kelvin");
	    equationJL.setBounds(415, 250, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where R is the Ideal gas constant");
	    equationJL.setBounds(200, 225, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    descriptionJL = new JLabel("Choose which variable you want to solve for:");
	    descriptionJL.setBounds(225, 275, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("Volume(L)");
	    descriptionJL.setBounds(190, 435, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    volumeJTF = new JTextField();
	    volumeJTF.setBounds(275, 450, 175, 35);
	    contentPane.add(volumeJTF);
	    
	    descriptionJL = new JLabel("Atmospheric Pressure(atm)");
	    descriptionJL.setBounds(55, 490, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    atmosphereJTF= new JTextField();
	    atmosphereJTF.setBounds(275, 505, 175, 35);
	    contentPane.add(atmosphereJTF);
	    
	    descriptionJL = new JLabel("Moles(mol)");
	    descriptionJL.setBounds(190, 545, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    molJTF = new JTextField();
	    molJTF.setBounds(275, 560, 175, 35);
	    contentPane.add(molJTF);
	    
	    descriptionJL = new JLabel("Temperature(K)");
	    descriptionJL.setBounds(150, 600, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    temperatureJTF = new JTextField();
	    temperatureJTF.setBounds(275, 615, 175, 35);
	    contentPane.add(temperatureJTF);
	    
	    descriptionJL = new JLabel("Constant(R)");
	    descriptionJL.setBounds(180, 655, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    constantJTF = new JTextField();
	    constantJTF.setBounds(275, 670, 175, 35);
	    contentPane.add(constantJTF);
	    
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
	    variablesJCB.addItem("R");
	    variablesJCB.addItem("Volume(L)");
	    variablesJCB.addItem("Atm. Pressure(atm)");
	    variablesJCB.addItem("Temperature(K)");
	    variablesJCB.addItem("Moles(mol)");
	    variablesJCB.setMaximumRowCount( 6 );
	    contentPane.add(variablesJCB);
	    variablesJCB.addActionListener(
	    		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				Color color = new Color(252,0,0);
        				Color black = new Color(0,0,0);
        				
        				if (variablesJCB.getSelectedItem().equals("R"))
        				{
        					constantJTF.setText(""); 
        					volumeJTF.setText("");
        					temperatureJTF.setText("");
        					atmosphereJTF.setText("");
        					molJTF.setText("");
        					
        					constantJTF.setForeground(color);
        					volumeJTF.setForeground(black); 
        					atmosphereJTF.setForeground(black);
        					temperatureJTF.setForeground(black);
        					molJTF.setForeground(black);
        					
        					constantJTF.setEditable(false);
        					atmosphereJTF.setEditable(true); 
        					molJTF.setEditable(true);
        					temperatureJTF.setEditable(true);
        					volumeJTF.setEditable(true);
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("R =(L*atm)/(mol*K)");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("Volume(L)"))
        				{
        					constantJTF.setText("0.08206"); 
        					volumeJTF.setText("");
        					temperatureJTF.setText("");
        					atmosphereJTF.setText("");
        					molJTF.setText("");
        					
        					volumeJTF.setForeground(color); 
        					atmosphereJTF.setForeground(black);
        					temperatureJTF.setForeground(black);
        					molJTF.setForeground(black);
        					constantJTF.setForeground(color);
        					
        					atmosphereJTF.setEditable(true); 
        					molJTF.setEditable(true);
        					temperatureJTF.setEditable(true);
        					volumeJTF.setEditable(false);
        					constantJTF.setEditable(false);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("L = (R * mol* K)/atm");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("Atm. Pressure(atm)"))
        				{
        					volumeJTF.setText(""); 
        					atmosphereJTF.setText("");
        					temperatureJTF.setText("");
        					molJTF.setText("");
        					constantJTF.setText("0.08206");
        					
        					volumeJTF.setForeground(black); 
        					atmosphereJTF.setForeground(color);
        					temperatureJTF.setForeground(black);
        					molJTF.setForeground(black);
        					constantJTF.setForeground(black);
        					
        					volumeJTF.setEditable(true); 
        					molJTF.setEditable(true);
        					temperatureJTF.setEditable(true);
        					atmosphereJTF.setEditable(false);
        					constantJTF.setEditable(false);
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("atm = (R * mol* K)/L");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("Temperature(K)"))
        				{
        					volumeJTF.setText(""); 
        					atmosphereJTF.setText("");
        					temperatureJTF.setText("");
        					molJTF.setText("");
        					constantJTF.setText("0.08206");
        					
        					volumeJTF.setForeground(black); 
        					atmosphereJTF.setForeground(black);
        					temperatureJTF.setForeground(color);
        					molJTF.setForeground(black);
        					constantJTF.setForeground(black);
        					
        					volumeJTF.setEditable(true); 
        					molJTF.setEditable(true);
        					atmosphereJTF.setEditable(true);
        					temperatureJTF.setEditable(false);
        					constantJTF.setEditable(false);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("K = (L*atm)/(R*mol)");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("Moles(mol)"))
        				{
        					volumeJTF.setText(""); 
        					atmosphereJTF.setText("");
        					temperatureJTF.setText("");
        					molJTF.setText("");
        					constantJTF.setText("0.08206");
        					
        					volumeJTF.setForeground(black); 
        					atmosphereJTF.setForeground(black);
        					temperatureJTF.setForeground(black);
        					molJTF.setForeground(color);
        					constantJTF.setForeground(black);
        					
        					molJTF.setEditable(false);
        					volumeJTF.setEditable(true); 
        					temperatureJTF.setEditable(true);
        					atmosphereJTF.setEditable(true);
        					constantJTF.setEditable(false);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(200, 370, 600, 60);
        					variableJL.setText("mol = (L*atm)/(R*K)");
         				    repaint();
        				}
        				
        				
        			}
        		});

	    solveJB = new JButton("Solve for the variable");
	    solveJB.setBounds(450, 660, 250, 70);
	    contentPane.add(solveJB);
	    solveJB.addActionListener(
	    		new ActionListener()
	    		{
	    			public void actionPerformed(ActionEvent e)
	    			{
	    				
	    				try
	    				{
	    					if (variablesJCB.getSelectedItem().equals("R"))
	    					{
	    						atm = Double.parseDouble(atmosphereJTF.getText());
	    	    				temp = Double.parseDouble(temperatureJTF.getText());
	    	    				mol = Double.parseDouble(molJTF.getText());
	    	    				vol = Double.parseDouble(volumeJTF.getText());
	    	    				
	    	    				R = (vol*atm)/(mol*temp);
	    	    				constantJTF.setText(String.valueOf(R));
	    	    				
	    					}
	    					else if (variablesJCB.getSelectedItem().equals("Volume(L)")) 
	    					{
	    						R = 0.08206;
	    						temp = Double.parseDouble(temperatureJTF.getText());
	    	    				mol = Double.parseDouble(molJTF.getText());
	    	    				atm = Double.parseDouble(atmosphereJTF.getText());
	    	    				
	    	    				
	    	    				vol = (R * temp * mol)/atm;
	    	    				volumeJTF.setText(String.valueOf(vol));
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("Atm. Pressure(atm)"))
	    					{
	    						R = 0.08206;
	    						vol = Double.parseDouble(volumeJTF.getText());
	    	    				temp = Double.parseDouble(temperatureJTF.getText());
	    	    				mol = Double.parseDouble(molJTF.getText());
	    	    				
	    	    				atm = (R * temp * mol)/vol ;
	    	    				atmosphereJTF.setText(String.valueOf(atm));
	    					}
	    					else if ( variablesJCB.getSelectedItem().equals("Temperature(K)"))
	    					{
	    						R = 0.08206;
	    						vol = Double.parseDouble(volumeJTF.getText());
	    	    				atm = Double.parseDouble(atmosphereJTF.getText());
	    	    				mol = Double.parseDouble(molJTF.getText());
	    	    				
	    	    				temp = (vol*atm)/(R*mol);
	    	    				temperatureJTF.setText(String.valueOf(temp));
	    					}
	    					else if ( variablesJCB.getSelectedItem().equals("Moles(mol)"))
	    					{
	    						R = 0.08206;
	    						vol = Double.parseDouble(volumeJTF.getText());
	    	    				atm = Double.parseDouble(atmosphereJTF.getText());
	    	    				temp = Double.parseDouble(temperatureJTF.getText());
	    	    				
	    	    				mol = (vol*atm)/(R*temp);
	    	    				molJTF.setText(String.valueOf(mol));
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("--Variable--"))
	    					{
	    						JOptionPane.showMessageDialog(null, "Please choose a variable", "ERROR",
	    	    						
	    								JOptionPane.ERROR_MESSAGE);
	    					}
	    				}
	    				catch(Exception p)
	    				{
	    					if(atmosphereJTF.getText().equals("") || temperatureJTF.getText().equals("") || volumeJTF.getText().equals("") || constantJTF.getText().equals("") || molJTF.getText().equals(""))
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
	    setTitle( "Ideal Gas Laws" ); // set title bar text
		setSize( 800, 900 );     // set window size
		setVisible(false);
		setLayout(null);
		setResizable(false);
		setBackground(new Color(25,165,235));
	}

}

