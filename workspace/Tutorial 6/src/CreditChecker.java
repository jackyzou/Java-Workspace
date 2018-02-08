
// Exercise 6.13: CreditChecker.java// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// This application calculates a credit balance and 
// determines whether the credit limit has been exceeded.
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class CreditChecker extends JFrame
{
   // JLabel and JTextField for account number
   private JLabel accountNumberJLabel;
   private JTextField accountNumberJTextField;

   // JLabel and JTextField for starting balance
   private JLabel startBalanceJLabel;
   private JTextField startBalanceJTextField;
   
   // JLabel and JTextField for total charges
   private JLabel totalChargesJLabel;
   private JTextField totalChargesJTextField;
   
   // JLabel and JTextField for total credits
   private JLabel totalCreditsJLabel;
   private JTextField totalCreditsJTextField;
   
   // JLabel and JTextField for credit limit
   private JLabel creditLimitJLabel;
   private JTextField creditLimitJTextField;
   
   // JLabel and JTextField for displaying new balance
   private JLabel newBalanceJLabel;
   private JTextField newBalanceJTextField;
   
   // JTextField for displaying error message
   private JTextField errorJTextField;
   
   // JButton to initiate new balance calculation
   private JButton calculateJButton;
   
   // no-argument constructor
   public CreditChecker() 
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

      // set up accountNumberJLabel
      accountNumberJLabel = new JLabel();
      accountNumberJLabel.setBounds( 16, 16, 116, 21 );
      accountNumberJLabel.setText( "Account number:" );
      contentPane.add( accountNumberJLabel );
      
      // set up accountNumberJTextField
      accountNumberJTextField = new JTextField();
      accountNumberJTextField.setBounds( 130, 16, 96, 21 );
      accountNumberJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( accountNumberJTextField );
      accountNumberJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called when key pressed in 
            // accountNumberJTextField
            public void keyPressed( KeyEvent event )
            {
               accountNumberJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener
            
      // set up startBalanceJLabel
      startBalanceJLabel = new JLabel();
      startBalanceJLabel.setBounds( 16, 56, 106, 21 );
      startBalanceJLabel.setText( "Starting balance:" );
      contentPane.add( startBalanceJLabel );
      
      // set up startBalanceJTextField
      startBalanceJTextField = new JTextField();
      startBalanceJTextField.setBounds( 130, 56, 96, 21 );
      startBalanceJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( startBalanceJTextField );
      
      // set up totalChargesJLabel
      totalChargesJLabel = new JLabel();
      totalChargesJLabel.setBounds( 16, 96, 106, 21 );
      totalChargesJLabel.setText( "Total charges:" );
      contentPane.add( totalChargesJLabel );
      
      // set up totalChargesJTextField
      totalChargesJTextField = new JTextField();
      totalChargesJTextField.setBounds( 130, 96, 96, 21 );
      totalChargesJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( totalChargesJTextField );
      
      // set up totalCreditsJLabel
      totalCreditsJLabel = new JLabel();
      totalCreditsJLabel.setBounds( 16, 136, 106, 21 );
      totalCreditsJLabel.setText( "Total credits:" );
      contentPane.add( totalCreditsJLabel );
      
      // set up totalCreditsJTextField
      totalCreditsJTextField = new JTextField();
      totalCreditsJTextField.setBounds( 130, 136, 96, 21 );
      totalCreditsJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( totalCreditsJTextField );
      
      // set up creditLimitJLabel
      creditLimitJLabel = new JLabel();
      creditLimitJLabel.setBounds( 16, 176, 106, 21 );
      creditLimitJLabel.setText( "Credit limit:" );
      contentPane.add( creditLimitJLabel );
      
      // set up creditLimitJTextField
      creditLimitJTextField = new JTextField();
      creditLimitJTextField.setBounds( 130, 176, 96, 21 );
      creditLimitJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( creditLimitJTextField );
      
      // set up newBalanceJTextField
      newBalanceJTextField = new JTextField();
      newBalanceJTextField.setBounds( 130, 216, 96, 21 );
      newBalanceJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      newBalanceJTextField.setEditable( false );
      contentPane.add( newBalanceJTextField );
      
      // set up newBalanceJLabel
      newBalanceJLabel = new JLabel();
      newBalanceJLabel.setBounds( 16, 216, 156, 21 );
      newBalanceJLabel.setText( "New balance:" );
      contentPane.add( newBalanceJLabel );
      
      // set up errorJTextField
      errorJTextField = new JTextField();
      errorJTextField.setBounds( 16, 256, 210, 21 );
      errorJTextField.setHorizontalAlignment( JTextField.CENTER );
      errorJTextField.setEditable( false );
      contentPane.add( errorJTextField );
      
      // set up calculateJButton and register its event handler
      calculateJButton = new JButton();
      calculateJButton.setBounds( 90, 296, 136, 23 );
      calculateJButton.setText( "Calculate Balance" );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when calculateJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               calculateJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Credit Checker" ); // set title bar text
      setSize( 250, 360 );          // set window size
      setVisible( true );           // display window

   } // end method createUserInterface

   // method called when key pressed in accountNumberJTextField
   private void accountNumberJTextFieldKeyPressed( KeyEvent event )
   {
      // clear all JTextFields when account number is changed
      startBalanceJTextField.setText( "" );
      totalChargesJTextField.setText( "" );
      totalCreditsJTextField.setText( "" );
      creditLimitJTextField.setText( "" );
      newBalanceJTextField.setText( "" );
      errorJTextField.setText( "" );

   } // end method accountNumberJTextFieldKeyPressed

   // method called when user clicks calculateJButton
   private void calculateJButtonActionPerformed( ActionEvent event )
   {      
	  
	   
	   
	   try
	   {
	   double start  = Double.parseDouble(startBalanceJTextField.getText()); 
	   double charge =  Double.parseDouble(totalChargesJTextField.getText()); 
	   double credit  = Double.parseDouble(totalCreditsJTextField.getText()); 
	   double limit =  Double.parseDouble(creditLimitJTextField.getText()); 
	   
	   double newbalance = 0.0;
	   
	  
	   
	   newbalance = start+charge-credit;
	   
	   DecimalFormat dollars = new DecimalFormat("$0.00");
	   
       newBalanceJTextField.setText(String.valueOf(dollars.format(newbalance))); 
       
       if(newbalance>limit)
       {
    	   errorJTextField.setText("Credit Limit Exceeded!");
       }
	   }
	   catch(Exception b)
	   {
		   JOptionPane.showMessageDialog(null,"Rational Numbers please","ERROR",
					  JOptionPane.ERROR_MESSAGE);  
	   }
	   
 
   
   
   
   
   
   
   } // end method calculateJButtonActionPerformed

   // main method
   public static void main( String[] args ) 
   {
      CreditChecker application = new CreditChecker();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
   } // end method main

} // end class CreditChecker


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
