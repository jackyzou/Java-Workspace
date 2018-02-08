package Tutorial5;

// Exercise 5.16: Average.java
// Application that finds the average of three integers.
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Average extends JFrame
{
   // JLabel and JTextField for user to input first number
   private JLabel firstNumberJLabel;
   private JTextField firstNumberJTextField;

   // JLabel and JTextField for user to input second number
   private JLabel secondNumberJLabel;
   private JTextField secondNumberJTextField;
   
   // JLabel and JTextField for user to input third number
   private JLabel thirdNumberJLabel;
   private JTextField thirdNumberJTextField;
   
   // JLabel and JTextField to display average
   private JLabel averageJLabel;
   private JTextField averageJTextField;
   
   // JButton to initiate average calculation
   private JButton calculateJButton;
   
   // no-argument constructor
   public Average()
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
      
      // set up firstNumberJLabel
      firstNumberJLabel = new JLabel();
      firstNumberJLabel.setText( "Enter first number:" );
      firstNumberJLabel.setBounds( 20, 20, 125, 20 );
      contentPane.add( firstNumberJLabel );
      
      // set up firstNumberJTextField
      firstNumberJTextField = new JTextField();
      firstNumberJTextField.setText( "0" );
      firstNumberJTextField.setBounds( 165, 20, 40, 20 );
      firstNumberJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( firstNumberJTextField );
      firstNumberJTextField.addKeyListener(
    	         
    	         new KeyAdapter() // anonymous inner class
    	         {
    	            // called when key pressed in celsiusJTextField
    	            public void keyPressed( KeyEvent event )
    	            {
    	            	firstNumberJTextFieldKeyPressed( event );
    	            }
    	            
    	         } // end anonymous inner class
    	      
    	      ); // end call to addKeyListener

      // set up secondNumberJLabel
      secondNumberJLabel = new JLabel();
      secondNumberJLabel.setText( "Enter second number:" );
      secondNumberJLabel.setBounds( 20, 50, 125, 20 );
      contentPane.add( secondNumberJLabel );
      
      // set up secondNumberJTextField
      secondNumberJTextField = new JTextField();
      secondNumberJTextField.setText( "0" );
      secondNumberJTextField.setBounds( 165, 50, 40, 20 );
      secondNumberJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( secondNumberJTextField );
      secondNumberJTextField.addKeyListener(
 	         
 	         new KeyAdapter() // anonymous inner class
 	         {
 	            // called when key pressed in celsiusJTextField
 	            public void keyPressed( KeyEvent event )
 	            {
 	            	secondNumberJTextFieldPressed( event );
 	            }
 	            
 	         } // end anonymous inner class
 	      
 	      ); // end call to addKeyListener

      // set up thirdNumberJLabel
      thirdNumberJLabel = new JLabel();
      thirdNumberJLabel.setText( "Enter third number:" );
      thirdNumberJLabel.setBounds( 20, 80, 125, 20 );
      contentPane.add( thirdNumberJLabel );
      
      // set up thirdNumberJTextField
      thirdNumberJTextField = new JTextField();
      thirdNumberJTextField.setText( "0" );
      thirdNumberJTextField.setBounds( 165, 80, 40, 20 );
      thirdNumberJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( thirdNumberJTextField );
      thirdNumberJTextField.addKeyListener(
  	         
  	         new KeyAdapter() // anonymous inner class
  	         {
  	            // called when key pressed in celsiusJTextField
  	            public void keyPressed( KeyEvent event )
  	            {
  	            	thirdNumberJTextFieldKeyPressed( event );
  	            }
  	            
  	         } // end anonymous inner class
  	      
  	      ); // end call to addKeyListener

      // set up averageJLabel
      averageJLabel = new JLabel();
      averageJLabel.setText( "Average is:" );
      averageJLabel.setBounds( 20, 110, 130, 20 );
      contentPane.add( averageJLabel );
      
      // set up averageJTextField
      averageJTextField = new JTextField();
      averageJTextField.setText( "0" );
      averageJTextField.setEditable( false );
      averageJTextField.setBounds( 165, 110, 200, 20 );
      averageJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( averageJTextField );
      
      // set up calculateJButton
      calculateJButton = new JButton ();
      calculateJButton.setText( "Calculate" );
      calculateJButton.setBounds( 225, 20, 90, 20 );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(
    		  
    		  new ActionListener()
    		  {
    			  public void actionPerformed( ActionEvent event)
    			  {
    				  try
    				  {
    					  calculateJButtonActionPerformed( event );
    				
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
      // set properties of window
      setTitle( "Average Three Numbers" ); // set window title
      setSize( 335, 180 );                 // set window size
      setVisible( true );                  // display window

   } // end method createUserInterface
   
   // calculate the average of the three values
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      // get values input by user
      double number1 = Double.parseDouble( 
         firstNumberJTextField.getText() );
      double number2 = Double.parseDouble( 
         secondNumberJTextField.getText() );
      double number3 = Double.parseDouble( 
         thirdNumberJTextField.getText() );
      
      // sum number1, number2 and number3 and divide by 3
      double result = (number1 + number2 + number3 )/ 3;
      
      // display the result
      averageJTextField.setText( String.valueOf( result ) );
   
   } // end method calculateJButtonActionPerformed
   private void firstNumberJTextFieldKeyPressed( KeyEvent event )
   {
	   averageJTextField.setText("");
	   
	   
   } // end method enterJTextFieldKeyPressed
   private void secondNumberJTextFieldPressed( KeyEvent event )
   {
	   averageJTextField.setText("");
	   
	   
   } // end method enterJTextFieldKeyPressed
   private void thirdNumberJTextFieldKeyPressed( KeyEvent event )
   {
	   averageJTextField.setText("");
	   
	   
   } // end method enterJTextFieldKeyPressed

     // main method
   public static void main( String[] args )
   {
      Average application = new Average();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
  
} // end class Average


 /**************************************************************************
  * (C) Copyright 1992-2004 by Deitel & Associates, Inc. and               *
  * Pearson Education, Inc. All Rights Reserved.                           *
  *                                                                        *
  * DISCLAIMER: The authors and publisher of this book have used their     *
  * best efforts in preparing the book. These efforts include the          *
  * development, research, and testing of the theories and programs        *
  * to determine their effectiveness. The authors and publisher make       *
  * no warranty of any kind, expressed or implied, with regard to these    *
  * programs or to the documentation contained in these books. The authors *
  * and publisher shall not be liable in any event for incidental or       *
  * consequential damages in connection with, or arising out of, the       *
  * furnishing, performance, or use of these programs.                     *
  **************************************************************************/
