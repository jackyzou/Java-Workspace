import javax.swing.*;

import java.awt.*;
import java.awt.event.*;//data ||| how to make it ||| what can it do

public class RelativelyPrimeGUI extends JFrame
{
	private JButton submitJButton,add;
	private JTextField firstNumberJTextField, secondNumberJTextField;
	private JLabel firstJLabel, secondJLabel;
	private JTextArea outputJTextArea;
	private JScrollPane scroller;
	
	private JButton clearJButton;

	private RelativePrime1 prime;
	private Addition addMaster;
	
	
	public RelativelyPrimeGUI()
	{
		createUserInterface();
	} // end constructor
	
	private void createUserInterface()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.RED);
		
		add = new JButton();
		add.setBounds( 10, 260, 180, 60 );
		add.setText("Add");
	    contentPane.add( add );
		add.addActionListener(
				new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							getAdditionInfo();
						}

						private void getAdditionInfo() {
						
							try
							{
								
								int first = Integer.parseInt(firstNumberJTextField.getText());
								int second = Integer.parseInt(secondNumberJTextField.getText());
								
							    addMaster = new Addition(first, second);
								String s =  addMaster.add();//send back 
								outputJTextArea.append("\n"+s+"\n\n");
								
								
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, 
										"Please enter an integer in each field " +
										"and press the submit button to find out if the integers are " +
										"relatively prime.", 
										"ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					
					);
		
		   clearJButton = new JButton();
		      clearJButton.setBounds( 10, 320, 180, 60 );
		      clearJButton.setText( "Clear" );
		      contentPane.add( clearJButton );
		      clearJButton.addActionListener( 
		      
		         new ActionListener() 
		         {
		           
		            public void actionPerformed( ActionEvent event )
		            {
		            	clearJButtonActionPerformed( event );
		            }
		            private void clearJButtonActionPerformed( ActionEvent event)
		     	   {
		    
		            	firstNumberJTextField.setText( "" ); 
		            	secondNumberJTextField.setText( "" ); 
		            
		        
		            	int x = JOptionPane.showConfirmDialog(null, 
		        				" Are you Sure you want to clear the history? ", " Clear ", JOptionPane.YES_NO_CANCEL_OPTION);
		        		
		        		//System.out.print(x);
		        		
		        		if(x == 1)
		        		{
		        			
		        			//Means NO
		        			System.out.print("NO");
		        		}
		        		
		        		else if(x == 2)
		        		{
		        			
		        			//Means Cancel
		        			System.out.print("Cancel");
		        		}
		        		else 
		        		{
		        			outputJTextArea.setText(String.valueOf(""));
		        			outputJTextArea.setText("This is the History");
		        			//Means Yes
		        			System.out.print("Yes");
		        		}
		        	

		            	
		            	
		            	
		            	
		            	
		            	
		     	   } // end method clearResults
		         } // end anonymous inner class
		         
		      ); // end call to addActionListener
		      

		
		submitJButton = new JButton("Test Relatively Prime");
		submitJButton.setBounds(10, 200, 180, 60);
		contentPane.add(submitJButton);
		submitJButton.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						getRelativePrimeInfo();
					}
				}
				
				);
		
		 firstNumberJTextField = new JTextField();
		 firstNumberJTextField.setBounds(150, 10, 50, 50);
		 contentPane.add(firstNumberJTextField);
		 
		 
		 firstJLabel = new JLabel("Enter First Integer:"); 
		 firstJLabel.setBounds(30, 10, 150, 50);
		 contentPane.add(firstJLabel);
		 
		 secondNumberJTextField = new JTextField();
		 secondNumberJTextField.setBounds(150, 110, 50, 50);
		 contentPane.add(secondNumberJTextField);

		 secondJLabel = new JLabel("Enter Second Integer:");
		 secondJLabel.setBounds(14, 110, 150, 50);
		 contentPane.add(secondJLabel);
		 
		 outputJTextArea = new JTextArea();
		 outputJTextArea.setEditable(false);
		 scroller  =  new JScrollPane(outputJTextArea);
		 scroller.setBounds(208, 10, 480, 400);
		 contentPane.add(scroller);
		 
		
		setSize(700, 500);
		setTitle("Relatively Prime");
		setVisible(true);
		setResizable(false);
	}// end createUserInterface
	
	public void getRelativePrimeInfo()
	{
		try
		{
			
			int first = Integer.parseInt(firstNumberJTextField.getText());
			int second = Integer.parseInt(secondNumberJTextField.getText());
			
			prime = new RelativePrime1(first, second);
			String s = prime.relativelyPrime();
			outputJTextArea.append("\n"+s+"\n\n");
			
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, 
					"Please enter an integer in each field " +
					"and press the submit button to find out if the integers are " +
					"relatively prime.", 
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	

}
