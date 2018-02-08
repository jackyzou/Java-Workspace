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


public class ColligativeProperties extends JFrame
{
	JLabel equationJL, descriptionJL, variableJL;
	JComboBox variablesJCB, pagesJCB;;
	JButton solveJB;
	JTextField initialTempJTF, finalTempJTF, kfkBJTF, molalityJTF; 
	double initialTemp, finalTemp, kFkB, molality;
	
	
	
	public ColligativeProperties() 
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
	    
	    
	    descriptionJL = new JLabel("Colligative Properties");
	    descriptionJL.setBounds(175, 15, 600, 50);
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
	    
	    equationJL = new JLabel("The equations are:");
	    equationJL.setBounds(295, 145, 400, 60);
	    equationJL.setFont(font2);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("(TfF- TiF) = Kf * m  or (TfB - TiB) = Kb * m");
	    equationJL.setBounds(200, 175, 550, 60);
	    equationJL.setFont(font2);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where TfF/ TfB are the final freezing/boiling points");
	    equationJL.setBounds(25, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where TiF/ TiB are the initial freezing/boiling points");
	    equationJL.setBounds(415, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where Kf/ Kb are the molal constants");
	    equationJL.setBounds(25, 250, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where m is the molality of the solution");
	    equationJL.setBounds(415, 250, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    descriptionJL = new JLabel("Choose which variable you want to solve for:");
	    descriptionJL.setBounds(225, 275, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("Initial Temperature (TiF or TiB):");
	    descriptionJL.setBounds(35, 435, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    initialTempJTF = new JTextField();
	    initialTempJTF.setBounds(275, 450, 175, 35);
	    contentPane.add(initialTempJTF);
	    
	    descriptionJL = new JLabel("Final Temperature (TfF or TfB):");
	    descriptionJL.setBounds(35, 490, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    finalTempJTF= new JTextField();
	    finalTempJTF.setBounds(275, 505, 175, 35);
	    contentPane.add(finalTempJTF);
	    
	    descriptionJL = new JLabel("Kf or Kb:");
	    descriptionJL.setBounds(200, 545, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    kfkBJTF = new JTextField();
	    kfkBJTF.setBounds(275, 560, 175, 35);
	    contentPane.add(kfkBJTF);
	    
	    descriptionJL = new JLabel("Molality (m):");
	    descriptionJL.setBounds(180, 600, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    molalityJTF = new JTextField();
	    molalityJTF.setBounds(275, 615, 175, 35);
	    contentPane.add(molalityJTF);
	    
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
	    variablesJCB.addItem("TiF");
	    variablesJCB.addItem("TfF");
	    variablesJCB.addItem("TiB");
	    variablesJCB.addItem("TfB");
	    variablesJCB.addItem("Kf");
	    variablesJCB.addItem("Kb");
	    variablesJCB.addItem("m");
	    variablesJCB.setMaximumRowCount( 8 );
	    contentPane.add(variablesJCB);
	    variablesJCB.addActionListener(
	    		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				Color color = new Color(252,0,0);
        				Color black = new Color(0,0,0);
        				
        				if (variablesJCB.getSelectedItem().equals("TiF"))
        				{
        					initialTempJTF.setText(""); 
        					finalTempJTF.setText("");
        					molalityJTF.setText("");
        					kfkBJTF.setText("");
        					
        					initialTempJTF.setForeground(color); 
        					finalTempJTF.setForeground(black);
        					molalityJTF.setForeground(black);
        					kfkBJTF.setForeground(black);
        					
        					finalTempJTF.setEditable(true); 
        					kfkBJTF.setEditable(true);
        					molalityJTF.setEditable(true);
        					initialTempJTF.setEditable(false);
        					
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("TiF = -((kF * m) - TfF)");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("TiB"))
        				{
        					initialTempJTF.setText(""); 
        					finalTempJTF.setText("");
        					molalityJTF.setText("");
        					kfkBJTF.setText("");
        					
        					initialTempJTF.setForeground(color); 
        					finalTempJTF.setForeground(black);
        					molalityJTF.setForeground(black);
        					kfkBJTF.setForeground(black);
        					
        					finalTempJTF.setEditable(true); 
        					kfkBJTF.setEditable(true);
        					molalityJTF.setEditable(true);
        					initialTempJTF.setEditable(false);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("TiB = -((kB * m) - TfB)");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("TfF"))
        				{
        					initialTempJTF.setText(""); 
        					finalTempJTF.setText("");
        					molalityJTF.setText("");
        					kfkBJTF.setText("");
        					
        					initialTempJTF.setForeground(black); 
        					finalTempJTF.setForeground(color);
        					molalityJTF.setForeground(black);
        					kfkBJTF.setForeground(black);
        					
        					initialTempJTF.setEditable(true); 
        					kfkBJTF.setEditable(true);
        					molalityJTF.setEditable(true);
        					finalTempJTF.setEditable(false);
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("TfF = ((kF * m) + Tfi)");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("TfB"))
        				{
        					initialTempJTF.setText(""); 
        					finalTempJTF.setText("");
        					molalityJTF.setText("");
        					kfkBJTF.setText("");
        					
        					initialTempJTF.setForeground(black); 
        					finalTempJTF.setForeground(color);
        					molalityJTF.setForeground(black);
        					kfkBJTF.setForeground(black);
        					
        					initialTempJTF.setEditable(true); 
        					kfkBJTF.setEditable(true);
        					molalityJTF.setEditable(true);
        					finalTempJTF.setEditable(false);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("TfB = ((kB * m) + TBi)");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("m"))
        				{
        					initialTempJTF.setText(""); 
        					finalTempJTF.setText("");
        					molalityJTF.setText("");
        					kfkBJTF.setText("");
        					
        					initialTempJTF.setForeground(black); 
        					finalTempJTF.setForeground(black);
        					molalityJTF.setForeground(color);
        					kfkBJTF.setForeground(black);
        					
        					molalityJTF.setEditable(false);
        					initialTempJTF.setEditable(true); 
        					kfkBJTF.setEditable(true);
        					finalTempJTF.setEditable(true);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(200, 370, 600, 60);
        					variableJL.setText("m = (TfF - TiF)/ Kf or m = (TfB - TiB)/ Kb");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("Kf"))
        				{
        					initialTempJTF.setText(""); 
        					finalTempJTF.setText("");
        					molalityJTF.setText("");
        					kfkBJTF.setText("");
        					
        					initialTempJTF.setForeground(black); 
        					finalTempJTF.setForeground(black);
        					molalityJTF.setForeground(black);
        					kfkBJTF.setForeground(color);
        					
        					kfkBJTF.setEditable(false);
        					initialTempJTF.setEditable(true); 
        					molalityJTF.setEditable(true);
        					finalTempJTF.setEditable(true);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("Kf = ((TfF - TiF)/ m)");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("Kb"))
        				{
        					initialTempJTF.setText(""); 
        					finalTempJTF.setText("");
        					molalityJTF.setText("");
        					kfkBJTF.setText("");
        					
        					initialTempJTF.setForeground(black); 
        					finalTempJTF.setForeground(black);
        					molalityJTF.setForeground(black);
        					kfkBJTF.setForeground(color);
        					
        					kfkBJTF.setEditable(false);
        					initialTempJTF.setEditable(true); 
        					molalityJTF.setEditable(true);
        					finalTempJTF.setEditable(true);
        					 
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        				    
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("Kb = ((TfB - TiB)/ m)");
         				    repaint();
        				}
        			}
        		});

	    solveJB = new JButton("Solve for the variable");
	    solveJB.setBounds(200, 660, 250, 70);
	    contentPane.add(solveJB);
	    solveJB.addActionListener(
	    		new ActionListener()
	    		{
	    			public void actionPerformed(ActionEvent e)
	    			{
	    				
	    				try
	    				{
	    					if (variablesJCB.getSelectedItem().equals("TiF") || variablesJCB.getSelectedItem().equals("TiB"))
	    					{
	    						finalTemp = Double.parseDouble(finalTempJTF.getText());
	    	    				molality = Double.parseDouble(molalityJTF.getText());
	    	    				kFkB = Double.parseDouble(kfkBJTF.getText());
	    	    				
	    	    				initialTemp = -((kFkB * molality) - finalTemp);
	    	    				initialTempJTF.setText(String.valueOf(initialTemp));
	    	    				
	    					}
	    					else if (variablesJCB.getSelectedItem().equals("TfF") || variablesJCB.getSelectedItem().equals("TfB")) 
	    					{
	    						initialTemp = Double.parseDouble(initialTempJTF.getText());
	    						molality = Double.parseDouble(molalityJTF.getText());
	    	    				kFkB = Double.parseDouble(kfkBJTF.getText());
	    	    				
	    	    				finalTemp = (kFkB * molality) + initialTemp;
	    	    				finalTempJTF.setText(String.valueOf(finalTemp));
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("m"))
	    					{
	    						initialTemp = Double.parseDouble(initialTempJTF.getText());
	    	    				finalTemp = Double.parseDouble(finalTempJTF.getText());
	    	    				kFkB = Double.parseDouble(kfkBJTF.getText());
	    	    				
	    	    				molality = ((finalTemp - initialTemp)/kFkB) ;
	    	    				molalityJTF.setText(String.valueOf(molality));
	    					}
	    					else if (variablesJCB.getSelectedItem().equals("Kf") || variablesJCB.getSelectedItem().equals("Kb"))
	    					{
	    						initialTemp = Double.parseDouble(initialTempJTF.getText());
	    	    				finalTemp = Double.parseDouble(finalTempJTF.getText());
	    	    				molality = Double.parseDouble(molalityJTF.getText());
	    	    				
	    	    				kFkB = ((finalTemp - initialTemp)/molality);
	    	    				kfkBJTF.setText(String.valueOf(kFkB));
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("--Variable--"))
	    					{
	    						JOptionPane.showMessageDialog(null, "Please choose a variable", "ERROR",
	    	    						
	    								JOptionPane.ERROR_MESSAGE);
	    					}
	    					
	    				}
	    				catch(Exception p)
	    				{
	    					if(initialTempJTF.getText().equals("") || finalTempJTF.getText().equals("") || molalityJTF.getText().equals("") || kfkBJTF.getText().equals("") )
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
	    setTitle( "Colligative Properties" ); // set title bar text
		setSize( 800, 900 );     // set window size
		setVisible(false);
		setLayout(null);
		setResizable(false);
		setBackground(new Color(225,105,230));
	}

}

