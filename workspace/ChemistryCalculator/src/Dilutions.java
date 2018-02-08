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


public class Dilutions extends JFrame
{
	JLabel equationJL, descriptionJL, variableJL;
	JComboBox variablesJCB, pagesJCB;
	JButton solveJB;
	JTextField M1JTF, V1JTF, M2JTF, V2JTF; 
	double M1, V1, M2, V2;
	
	
	
	public Dilutions() 
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
	    
	    
	    descriptionJL = new JLabel("Dilutions");
	    descriptionJL.setBounds(290, 15, 600, 50);
	    descriptionJL.setFont(font1);
	    
	    contentPane.add(descriptionJL);
	    
	    
	    descriptionJL = new JLabel("Diluting a solution is a common way of reducing the concentration of a solution");
	    descriptionJL.setBounds(65, 75, 650 ,50);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    equationJL = new JLabel("The equation is:");
	    equationJL.setBounds(295, 115, 400, 60);
	    equationJL.setFont(fontf);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("M1 * v1 = M2 * v2");
	    equationJL.setBounds(280, 145, 550, 60);
	    equationJL.setFont(fontf);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where M1 and M2 are the molarities of two solutions");
	    equationJL.setBounds(25, 200, 550, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	    equationJL = new JLabel("-> Where V1 and V2 are the volumes of the solutions, that have molarities M1 and M2, respectively");
	    equationJL.setBounds(25, 240, 700, 60);
	    equationJL.setFont(font4);
	    contentPane.add(equationJL);
	    
	   
	    
	    descriptionJL = new JLabel("Choose which variable you want to solve for:");
	    descriptionJL.setBounds(225, 275, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    descriptionJL = new JLabel("Molarity1");
	    descriptionJL.setBounds(195, 435, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    M1JTF = new JTextField();
	    M1JTF.setBounds(275, 450, 175, 35);
	    contentPane.add(M1JTF);
	    
	    descriptionJL = new JLabel("Volume1");
	    descriptionJL.setBounds(195, 490, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    V1JTF= new JTextField();
	    V1JTF.setBounds(275, 505, 175, 35);
	    contentPane.add(V1JTF);
	    
	    descriptionJL = new JLabel("Molarity2");
	    descriptionJL.setBounds(195, 545, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    M2JTF = new JTextField();
	    M2JTF.setBounds(275, 560, 175, 35);
	    contentPane.add(M2JTF);
	    
	    descriptionJL = new JLabel("Volume2");
	    descriptionJL.setBounds(195, 600, 400, 60);
	    descriptionJL.setFont(font3);
	    contentPane.add(descriptionJL);
	    
	    V2JTF = new JTextField();
	    V2JTF.setBounds(275, 615, 175, 35);
	    contentPane.add(V2JTF);
	    
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
	    variablesJCB.addItem("M1");
	    variablesJCB.addItem("v1");
	    variablesJCB.addItem("M2");
	    variablesJCB.addItem("v2");
	    variablesJCB.setMaximumRowCount( 5 );
	    contentPane.add(variablesJCB);
	    variablesJCB.addActionListener(
	    		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				Color color = new Color(252,0,0);
        				Color black = new Color(0,0,0);
        				
        				if (variablesJCB.getSelectedItem().equals("M1"))
        				{
        					M1JTF.setText(""); 
        					M2JTF.setText("");
        					V2JTF.setText("");
        					V1JTF.setText("");
        					
        					M1JTF.setForeground(color); 
        					M2JTF.setForeground(black);
        					V2JTF.setForeground(black);
        					V1JTF.setForeground(black);
        					
        					M2JTF.setEditable(true); 
        					V1JTF.setEditable(true);
        					V2JTF.setEditable(true);
        					M1JTF.setEditable(false);
        					
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("M1 = (M2 * v2)/ v1");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("v1"))
        				{
        					M1JTF.setText(""); 
        					M2JTF.setText("");
        					V2JTF.setText("");
        					V1JTF.setText("");
        					
        					V1JTF.setForeground(color); 
        					M2JTF.setForeground(black);
        					V2JTF.setForeground(black);
        					M1JTF.setForeground(black);
        					
        					M2JTF.setEditable(true); 
        					V1JTF.setEditable(false);
        					V2JTF.setEditable(true);
        					M1JTF.setEditable(true);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("v1 = (M2 * v2)/ M1");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("M2"))
        				{
        					M1JTF.setText(""); 
        					M2JTF.setText("");
        					V2JTF.setText("");
        					V1JTF.setText("");
        					
        					M1JTF.setForeground(black); 
        					M2JTF.setForeground(color);
        					V2JTF.setForeground(black);
        					V1JTF.setForeground(black);
        					
        					M1JTF.setEditable(true); 
        					V1JTF.setEditable(true);
        					V2JTF.setEditable(true);
        					M2JTF.setEditable(false);
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("M2 = (M1 * v1)/ v2");
         				    repaint();
        				}
        				
        				else if (variablesJCB.getSelectedItem().equals("v2"))
        				{
        					M1JTF.setText(""); 
        					M2JTF.setText("");
        					V2JTF.setText("");
        					V1JTF.setText("");
        					
        					M1JTF.setForeground(black); 
        					V2JTF.setForeground(color);
        					M2JTF.setForeground(black);
        					V1JTF.setForeground(black);
        					
        					M1JTF.setEditable(true); 
        					V1JTF.setEditable(true);
        					V2JTF.setEditable(false);
        					M2JTF.setEditable(true);
        					
        					
        					descriptionJL.setText("Your new equation is:");
        				    repaint();
        					
        				    variableJL.setBounds(280, 370, 600, 60);
        					variableJL.setText("v2 = (M1 * v1)/ M2");
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
	    					if (variablesJCB.getSelectedItem().equals("M1") )
	    					{
	    						M2 = Double.parseDouble(M2JTF.getText());
	    	    				V2 = Double.parseDouble(V2JTF.getText());
	    	    				V1 = Double.parseDouble(V1JTF.getText());
	    	    				
	    	    				M1 = (V2 * M2) / V1;
	    	    				M1JTF.setText(String.valueOf(M1));
	    	    				System.out.println("yOLO");
	    	    				
	    					}
	    					else if (variablesJCB.getSelectedItem().equals("M2") ) 
	    					{
	    						M1 = Double.parseDouble(M1JTF.getText());
	    						V2 = Double.parseDouble(V2JTF.getText());
	    	    				V1 = Double.parseDouble(V1JTF.getText());
	    	    				
	    	    				M2 = (V1 * M1) / V2;
	    	    				M2JTF.setText(String.valueOf(M2));
	    	    				System.out.println("yOL2O");
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("v2"))
	    					{
	    						M1 = Double.parseDouble(M1JTF.getText());
	    	    				M2 = Double.parseDouble(M2JTF.getText());
	    	    				V1 = Double.parseDouble(V1JTF.getText());
	    	    				
	    	    				V2 = (V1 * M1) / M2 ;
	    	    				V2JTF.setText(String.valueOf(V2));
	    	    				System.out.println("yOL3O");
	    					}
	    					else if (variablesJCB.getSelectedItem().equals("v1"))
	    					{
	    						M1 = Double.parseDouble(M1JTF.getText());
	    	    				M2 = Double.parseDouble(M2JTF.getText());
	    	    				V2 = Double.parseDouble(V2JTF.getText());
	    	    				
	    	    				V1 = (V2 * M2) / M1;
	    	    				V1JTF.setText(String.valueOf(V1));
	    	    				System.out.println("yOL4O");
	    					}
	    					
	    					else if (variablesJCB.getSelectedItem().equals("--Variable--"))
	    					{
	    						JOptionPane.showMessageDialog(null, "Please choose a variable", "ERROR",
	    	    						
	    								JOptionPane.ERROR_MESSAGE);
	    					}
	    				}
	    				catch(Exception p)
	    				{
	    					if(M1JTF.getText().equals("") || V1JTF.getText().equals("") || M2JTF.getText().equals("") || V2JTF.getText().equals(""))
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
		setBackground(new Color(100,80,200));
	}

}

