
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.*;

	public class NewtonIterationWithGUI extends JFrame
	{
	   // JLabel and JTextField for user to input first number
	   private JLabel firstNumberJLabel;
	   private JTextField firstNumberJTextField;

	   // JLabel and JTextField for user to input second number
	   private JLabel secondNumberJLabel;
	   private JTextField secondNumberJTextField;
	   
	   // JLabel and JTextField to display result
	   private JLabel resultJLabel;
	   private JTextField resultJTextField;

	   // JButtons to initiate calculations
	   private JButton addJButton;
	   private JButton subtractJButton;
	   private JButton multiplyJButton;
	   private JButton divideJButton;
	   private JButton squarerootJButton;
	   private JButton clearJButton;
	   // no-argument constructor
	   public NewtonIterationWithGUI()
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
	      
	      clearJButton = new JButton();
	      clearJButton.setBounds( 164, 90, 81, 25);
	      clearJButton.setText( "Clear" );
	      contentPane.add( clearJButton );
	      clearJButton.addActionListener( 
	      
	         new ActionListener() // anonymous inner class
	         {
	            // method called when user clicks calculateJButton
	            public void actionPerformed( ActionEvent event )
	            {
	            	clearJButtonActionPerformed( event );
	            }
	            private void clearJButtonActionPerformed( ActionEvent event)
	     	   {
	            	firstNumberJTextField.setText( "0.00" );
	            	secondNumberJTextField.setText( "0.00" );
	     	      resultJTextField.setText( "0.00" );
	     	     secondNumberJTextField.setEditable(true);

	     	   } // end method clearResults
	         } // end anonymous inner class
	         
	      ); // end call to addActionListener

	      
	      // set up firstNumberJLabel
	      firstNumberJLabel = new JLabel();
	      firstNumberJLabel.setText( "Enter the number:" );
	      firstNumberJLabel.setBounds( 20, 20, 130, 25 );
	      contentPane.add( firstNumberJLabel );
	      
	      // set up firstNumberJTextField
	      firstNumberJTextField = new JTextField();
	      firstNumberJTextField.setText( "0" );
	      firstNumberJTextField.setBounds( 170, 20, 60, 25 );
	      firstNumberJTextField.setHorizontalAlignment(
	         JTextField.RIGHT );
	      contentPane.add( firstNumberJTextField );
	      firstNumberJTextField.addKeyListener(

	         new KeyAdapter() // anonymous inner class
	         {
	            // called when key pressed in firstNumberJTextField
	            public void keyPressed( KeyEvent event )
	            {
	               firstNumberJTextFieldKeyPressed( event );
	            }

	         } // end anonymous inner class

	      ); // end call to addKeyListener
	      firstNumberJTextField.addMouseListener(new MouseAdapter(){
	          public void mouseClicked(MouseEvent e){
	        	  firstNumberJTextField.setText("");
	      
	          }
	          });
	  
	      // set up secondNumberJLabel
	      secondNumberJLabel = new JLabel();
	      secondNumberJLabel.setText( "Enter second number:" );
	      secondNumberJLabel.setBounds( 20, 55, 140, 25 );
	      contentPane.add( secondNumberJLabel );
	      
	      // set up secondNumberJTextField
	      secondNumberJTextField = new JTextField();
	      secondNumberJTextField.setText( "0" );
	      secondNumberJTextField.setBounds( 170, 55, 60, 25 );
	      secondNumberJTextField.setHorizontalAlignment(
	         JTextField.RIGHT );
	      contentPane.add( secondNumberJTextField );
	      secondNumberJTextField.addKeyListener(

	         new KeyAdapter() // anonymous inner class
	         {
	            // called when key pressed in secondNumberJTextField
	            public void keyPressed( KeyEvent event )
	            {
	               secondNumberJTextFieldKeyPressed( event );
	            }

	         } // end anonymous inner class

	      ); // end call to addKeyListener
	      secondNumberJTextField.addMouseListener(new MouseAdapter(){
	          public void mouseClicked(MouseEvent e){
	        	  secondNumberJTextField.setText("");
	      
	          }
	          });
	      // set up resultJLabel
	      resultJLabel = new JLabel();
	      resultJLabel.setText( "Result:" );
	      resultJLabel.setBounds( 20, 120, 130, 25 );
	      contentPane.add( resultJLabel );
	                  
	      // set up resultJTextField
	      resultJTextField = new JTextField();
	      resultJTextField.setHorizontalAlignment( JTextField.RIGHT );
	      resultJTextField.setEditable( false );
	      resultJTextField.setBounds( 100, 120, 250, 25 );
	      contentPane.add( resultJTextField );
	      
	      // set up addJButton
	      addJButton = new JButton ();
	      addJButton.setText( "+" );
	      addJButton.setBounds( 250, 20, 41, 25 );
	      addJButton.setFont( new Font( "Monospaced", Font.PLAIN, 12 ) );
	      contentPane.add( addJButton );
	      addJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				  try
	    				  {
	    					  addJButtonActionPerformed( event );
	    				
	    				  }
	    				  catch
	    				  (Exception e)
	    	    		  {
	    	    			  JOptionPane.showMessageDialog(null,"Integer please","ERROR",
	    	    					  JOptionPane.ERROR_MESSAGE);
	    	    		  }
	    			  }
	    				  
	    		  }
	    		  
	    			  
	    		  );     
	      // set up subtractJButton
	      subtractJButton = new JButton ();
	      subtractJButton.setText( "-" );
	      subtractJButton.setBounds( 301, 20, 41, 25 );
	      subtractJButton.setFont( 
	         new Font( "Monospaced", Font.PLAIN, 12 ) );
	      contentPane.add( subtractJButton );
	      subtractJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				  try
	    				  {
	    					  subtractJButtonActionPerformed( event );
	    				
	    				  }
	    				  catch
	    				  (Exception e)
	    	    		  {
	    	    			  JOptionPane.showMessageDialog(null,"Integer please","ERROR",
	    	    					  JOptionPane.ERROR_MESSAGE);
	    	    		  }
	    			  }
	    				  
	    		  }
	    		  
	    			  
	    		  );     
	      // set up multiplyJButton
	      multiplyJButton = new JButton ();
	      multiplyJButton.setText( "*" );
	      multiplyJButton.setBounds( 250, 55, 41, 25 );
	      multiplyJButton.setFont( 
	         new Font( "Monospaced", Font.PLAIN, 12 ) );
	      contentPane.add( multiplyJButton );
	      multiplyJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				  try
	    				  {
	    					  multiplyJButtonActionPerformed( event );
	    				
	    				  }
	    				  catch
	    				  (Exception e)
	    	    		  {
	    	    			  JOptionPane.showMessageDialog(null,"Integer please","ERROR",
	    	    					  JOptionPane.ERROR_MESSAGE);
	    	    		  }
	    			  }
	    				  
	    		  }
	    		  
	    			  
	    		  );
	      // set up divideJButton
	      divideJButton = new JButton ();
	      divideJButton.setText( "/" );
	      divideJButton.setBounds( 301, 55, 41, 25 );
	      divideJButton.setFont( 
	         new Font( "Monospaced", Font.PLAIN, 12 ) );
	      contentPane.add( divideJButton );
	      divideJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				  try
	    				  {
	    					  divideJButtonActionPerformed( event );
	    				
	    				  }
	    				  catch
	    				  (Exception e)
	    	    		  {
	    	    			  JOptionPane.showMessageDialog(null,"Integer please","ERROR",
	    	    					  JOptionPane.ERROR_MESSAGE);
	    	    		  }
	    			  }
	    				  
	    		  }
	    		  
	    			  
	    		  );
	      squarerootJButton = new JButton ();
	      squarerootJButton.setText( "sqrt" );
	      squarerootJButton.setBounds( 254, 90, 81, 25 );
	      squarerootJButton.setFont( new Font( "Monospaced", Font.PLAIN, 12 ) );
	      contentPane.add( squarerootJButton );
	      squarerootJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				  try
	    				  {
	    					  squarerootJButtonPerformed( event );
	    				
	    				  }
	    				  catch
	    				  (Exception b)
	    	    		  {
	    	    			  JOptionPane.showMessageDialog(null,"Integer please","ERROR",
	    	    					  JOptionPane.ERROR_MESSAGE);
	    	    		  }
	    			  }

	    		  }	     
	     );       
	      // set properties of window
	      setTitle( "Calculator(square root version)" ); // set window title
	      setSize( 370, 200 );      // set window size
	      setVisible( true );       // display window
	   
	   } // end method createUserInterface
	   
	   // clear resultJTextField because the value is now invalid
	   private void firstNumberJTextFieldKeyPressed( KeyEvent event )
	   {
	      resultJTextField.setText( "" ); // clear resultJTextField
	      
	   } // end method firstNumberKeyTyped
	   
	   // clear resultJTextField because the value is now invalid
	   private void secondNumberJTextFieldKeyPressed( KeyEvent event )
	   {
	      resultJTextField.setText( "" ); // clear resultJTextField
	      
	   } // end method secondNumberJTextFieldKeyTyped
	   
	   // add the two numbers
	   private void addJButtonActionPerformed( ActionEvent event )
	   {DecimalFormat dollars = new DecimalFormat( "0.000000" );
	   double number;
	   double number1;
	   double result;
	   number = Double.parseDouble(firstNumberJTextField.getText());
	   number1 =Double.parseDouble(secondNumberJTextField.getText());
	  
	   result = number + number1   ;

	   resultJTextField.setText(dollars.format((result)));
	   } // end method addJButtonActionPerformed
	   
	   // subtract the two numbers
	   private void subtractJButtonActionPerformed( ActionEvent event )
	   {DecimalFormat dollars = new DecimalFormat( "0.000000" );
	   double number;
	   double number1;
	   double result;
		   number = Double.parseDouble(firstNumberJTextField.getText());
		   number1 =Double.parseDouble(secondNumberJTextField.getText());
		  
		   result = number - number1   ;
	
		   resultJTextField.setText(dollars.format((result)));
	   } // end method subtractJButtonActionPerformed
	   
	   // multiply the two numbers
	   private void multiplyJButtonActionPerformed( ActionEvent event )
	   { DecimalFormat dollars = new DecimalFormat( "0.000000" );
	   double number;
	   double number1;
	   double result;
		   number = Double.parseDouble(firstNumberJTextField.getText());
		   number1 =Double.parseDouble(secondNumberJTextField.getText());
		  
		   result = number * number1   ;
		
		   resultJTextField.setText(dollars.format((result)));
	   } // end method multiplyJButtonActionPerformed
	   
	   // divide the two numbers
	   private void divideJButtonActionPerformed( ActionEvent event )
	   {   DecimalFormat dollars = new DecimalFormat( "0.000000" );
	   double number;
	   double number1;
	   double result;
		   number = Double.parseDouble(firstNumberJTextField.getText());
		   number1 =Double.parseDouble(secondNumberJTextField.getText());
		  
		   result = number / number1   ;
		  
		   resultJTextField.setText(dollars.format((result)));
	   } // end method divideJButtonActionPerformed
	   
	   // main method
		
	   private double squarerootJButtonPerformed(ActionEvent event) 
		{
		   secondNumberJTextField.setEditable(false);
		   DecimalFormat dollars = new DecimalFormat( "0.000000" );
			    //change the number inside of print.
			   double number;

			  	   
			   number = Double.parseDouble(firstNumberJTextField.getText());

			
				    //change the number inside of print.
			
			    double x = 1;

			
				double temp = 1;
				if(number>0)
				{
				do
				{
				temp = x;
				x = 0.5*(x + number/x);
				}
				while(Math.abs(x - temp)>0.000001);
				System.out.printf("%.3f's square root is:%.3f",number,x); //打印n和它的平方根
				 resultJTextField.setText(dollars.format(x));
			
				return x;
				}
			

				
				else
				{
					JOptionPane.showMessageDialog(null,"Positive numbers please","ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				return number;
		}
	  
		     
	  
		  


	public static void main( String[] args )
	   {
		   NewtonIterationWithGUI application = new NewtonIterationWithGUI();
	      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	   } // end method main
	   
	} // end class SimpleCalculator







