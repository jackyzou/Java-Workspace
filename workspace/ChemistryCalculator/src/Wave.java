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

public class Wave extends JFrame
{
	JLabel equationJL, descriptionJL, variableJL;
	JComboBox variablesJCB, pagesJCB;
	JButton solveJB;
	JTextField EJTF, lambdaJTF, cJTF; 
	double E, h, c, lambda;
	//E= h(constant)c/lambda
	//Energy = constant, velocity/ wavelength
	
	public Wave() 
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
	    
	    
	    descriptionJL = new JLabel("Wave");
	    descriptionJL.setBounds(315, 15, 600, 50);
	    descriptionJL.setFont(font1);
	    contentPane.add(descriptionJL);
	    
	    
	    descriptionJL = new JLabel("A wave is an example of periodic motion. The particles of the medium oscillate back and forth"); 
	    descriptionJL.setBounds(45, 55, 760 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	     
	    
	    descriptionJL = new JLabel("about a fixed position. As such, frequency is a rate quantity which describes the rate of"); 
	    descriptionJL.setBounds(65, 75, 750 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("oscillations or vibrations or cycles or waves on a per second basis"); 
	    descriptionJL.setBounds(125, 95, 750 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    equationJL = new JLabel("The equation is:");
	    equationJL.setBounds(295, 115, 400, 60);
	    equationJL.setFont(fontf);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("E = hc/lambda");
	    equationJL.setBounds(300, 145, 550, 60);
	    equationJL.setFont(fontf);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where h is a constant with the value of 6.626E-34 m^2kg/s");
	    equationJL.setBounds(25, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where c is the velocity of the wave");
	    equationJL.setBounds(25, 240, 700, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where E is the energy emitted by the wave.");
	    equationJL.setBounds(475, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where lambda is the frequency of the wave");
	    equationJL.setBounds(350, 240, 700, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    descriptionJL = new JLabel("Choose which variable you want to solve for:");
	    descriptionJL.setBounds(225, 275, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("Energy(E)");
	    descriptionJL.setBounds(200, 435, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    EJTF = new JTextField();
	    EJTF.setBounds(275, 450, 175, 35);
	    contentPane.add(EJTF);
	    
	    descriptionJL = new JLabel("Velocity(c)");
	    descriptionJL.setBounds(200, 490, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    cJTF= new JTextField();
	    cJTF.setBounds(275, 505, 175, 35);
	    contentPane.add(cJTF);
	    
	    descriptionJL = new JLabel("Frequency(lambda)");
	    descriptionJL.setBounds(130, 545, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    lambdaJTF = new JTextField();
	    lambdaJTF.setBounds(275, 560, 175, 35);
	    contentPane.add(lambdaJTF);
	    
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
	    variablesJCB.addItem("E");
	    variablesJCB.addItem("c");
	    variablesJCB.addItem("lambda");
	    variablesJCB.setMaximumRowCount( 4 );
	    contentPane.add(variablesJCB);
	    variablesJCB.addActionListener(
	    		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				Color color = new Color(252,0,0);
        				Color black = new Color(0,0,0);
        				
        				if (variablesJCB.getSelectedItem().equals("E"))
        				{
        					EJTF.setText(""); 
        					lambdaJTF.setText("");
        					cJTF.setText("");
        					
        					EJTF.setForeground(color); 
        					lambdaJTF.setForeground(black);
        					cJTF.setForeground(black);
        					
        					lambdaJTF.setEditable(true); 
        					cJTF.setEditable(true);
        					EJTF.setEditable(false);
        					
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("E = (h*c)/lambda");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("c"))
        				{
        					EJTF.setText(""); 
        					lambdaJTF.setText("");
        					cJTF.setText("");
        					
        					cJTF.setForeground(color); 
        					lambdaJTF.setForeground(black);
        					EJTF.setForeground(black);
        					
        					lambdaJTF.setEditable(true); 
        					cJTF.setEditable(false);
        					EJTF.setEditable(true);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("c = (E*lambda)/h");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("lambda"))
        				{
        					EJTF.setText(""); 
        					lambdaJTF.setText("");
        					cJTF.setText("");
        					
        					EJTF.setForeground(black); 
        					lambdaJTF.setForeground(color);
        					cJTF.setForeground(black);
        					
        					EJTF.setEditable(true); 
        					cJTF.setEditable(true);
        					lambdaJTF.setEditable(false);
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("lambda = (h*c)/E");
         				    repaint();
        				}
        				
        				
        				
        			}
        		});

	    solveJB = new JButton("Solve for the variable");
	    solveJB.setBounds(200, 600, 250, 70);
	    contentPane.add(solveJB);
	    solveJB.addActionListener(
	    		new ActionListener()
	    		{
	    			public void actionPerformed(ActionEvent e)
	    			{
	    				
	    				try
	    				{
	    					if (variablesJCB.getSelectedItem().equals("E") )
	    					{
	    						lambda = Double.parseDouble(lambdaJTF.getText());
	    	    				h = 6.626 * Math.pow(10,-26);
	    	    				c = Double.parseDouble(cJTF.getText());
	    	    				
	    	    				E = (h * c) / lambda;
	    	    				EJTF.setText(String.valueOf(E));
	
	    					}
	    					else if (variablesJCB.getSelectedItem().equals("lambda") ) 
	    					{
	    						E = Double.parseDouble(EJTF.getText());
	    						h = 6.626 * Math.pow(10,-26);
	    	    				c = Double.parseDouble(cJTF.getText());
	    	    				
	    	    				lambda = (c * h) / E;
	    	    				lambdaJTF.setText(String.valueOf(lambda));
	    	    				System.out.println("yOL2O");
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("c"))
	    					{
	    						E = Double.parseDouble(EJTF.getText());
	    						h = 6.626 * Math.pow(10,-26);
	    						lambda = Double.parseDouble(lambdaJTF.getText());
	    	    				
	    	    				c = (E * lambda)/h ;
	    	    				cJTF.setText(String.valueOf(c));
	    	    				System.out.println("yOL3O");
	    					}
	    				
	    					
	    					else if (variablesJCB.getSelectedItem().equals("--Variable--"))
	    					{
	    						JOptionPane.showMessageDialog(null, "Please choose a variable", "ERROR",
	    	    						
	    								JOptionPane.ERROR_MESSAGE);
	    					}
	    				}
	    				catch(Exception p)
	    				{
	    					if(EJTF.getText().equals("") || lambdaJTF.getText().equals("") || cJTF.getText().equals(""))
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
		setSize( 800, 750 );     // set window size
		setVisible(false);
		setLayout(null);
		setResizable(false);
		setBackground(new Color(235,25,25));
	}

}


