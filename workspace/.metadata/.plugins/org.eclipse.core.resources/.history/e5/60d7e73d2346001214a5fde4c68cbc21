// Exercise 6.12: WageCalculator.java
// This application inputs the hourly wage and number of hours
// worked for an employee, then calculates the employee's gross 
// wages, federal taxes and net wages.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class WageCalculator extends JFrame 
{
   // JLabel and JTextField for wage per hour
   private JLabel hourlyWageJLabel;
   private JTextField hourlyWageJTextField;

   // JLabel and JTextField for hours worked in a week
   private JLabel hoursWorkedJLabel;
   private JTextField hoursWorkedJTextField;
   
   // JLabel and JTextField for gross wages
   private JLabel grossWagesJLabel;
   private JTextField grossWagesJTextField;
   
   // JLabel and JTextField for federal taxes
   private JLabel federalTaxesJLabel;
   private JTextField federalTaxesJTextField;
   
   // JLabel and JTextField for net wages
   private JLabel netWagesJLabel;
   private JTextField netWagesJTextField;
   
   // JButton to initiate wage calculation
   private JButton calculateJButton;
   
   // no-argument constructor
   public WageCalculator()
   {
      createUserInterface();
   }   
   
   // create and position GUI components; register event handlers
   public void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null ); 

      // set up hourlyWageJLabel
      hourlyWageJLabel = new JLabel();
      hourlyWageJLabel.setBounds( 16, 16, 90, 21 );
      hourlyWageJLabel.setText( "Hourly wage:" );
      contentPane.add( hourlyWageJLabel );
      
      // set up hourlyWageJTextField
      hourlyWageJTextField = new JTextField();
      hourlyWageJTextField.setBounds( 120, 16, 90, 21 );
      hourlyWageJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( hourlyWageJTextField );
      hourlyWageJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called when user types 
            // in hourlyWageJTextField
            public void keyPressed( KeyEvent event )
            {
               hourlyWageJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener 
      
      // set up hoursWorkedJLabel
      hoursWorkedJLabel = new JLabel();
      hoursWorkedJLabel.setBounds( 16, 56, 90, 21 );
      hoursWorkedJLabel.setText( "Hours worked:" );
      contentPane.add( hoursWorkedJLabel );
      
      // set up hoursWorkedJTextField
      hoursWorkedJTextField = new JTextField();
      hoursWorkedJTextField.setBounds( 120, 56, 90, 21 );
      hoursWorkedJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( hoursWorkedJTextField );
      hoursWorkedJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called when user types 
            // in hoursWorkedJTextField
            public void keyPressed( KeyEvent event )
            {
               hoursWorkedJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener       
      
      // set up grossWagesJLabel
      grossWagesJLabel = new JLabel();
      grossWagesJLabel.setBounds( 16, 96, 90, 21 );
      grossWagesJLabel.setText( "Gross wages:" );
      contentPane.add( grossWagesJLabel );
      
      // set up grossWagesJTextField
      grossWagesJTextField = new JTextField();
      grossWagesJTextField.setBounds( 120, 96, 90, 21 );
      grossWagesJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      grossWagesJTextField.setEditable( false );
      contentPane.add( grossWagesJTextField );
      
      // set up federalTaxesJLabel
      federalTaxesJLabel = new JLabel();
      federalTaxesJLabel.setBounds( 16, 136, 120, 21 );
      federalTaxesJLabel.setText( "Federal taxes:" );
      contentPane.add( federalTaxesJLabel );
      
      // set up federalTaxesJTextField
      federalTaxesJTextField = new JTextField();
      federalTaxesJTextField.setBounds( 120, 136, 90, 21 );
      federalTaxesJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      federalTaxesJTextField.setEditable( false );
      contentPane.add( federalTaxesJTextField );
      
      // set up netWagesJLabel
      netWagesJLabel = new JLabel();
      netWagesJLabel.setBounds( 16, 176, 90, 21 );
      netWagesJLabel.setText( "Net wages:" );
      contentPane.add( netWagesJLabel );

      // set up netWagesJTextField
      netWagesJTextField = new JTextField();
      netWagesJTextField.setBounds( 120, 176, 90, 21 );
      netWagesJTextField.setHorizontalAlignment( JTextField.RIGHT );
      netWagesJTextField.setEditable( false );
      contentPane.add( netWagesJTextField );

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 120, 216, 90, 24 );
      calculateJButton.setText( "Calculate" );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {          
             // event handler called when calculateJButton is pressed
             public void actionPerformed ( ActionEvent event )
             {
                calculateJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Wage Calculator" ); // set title bar text
      setSize( 230, 280 );           // set window size
      setVisible( true );            // display window
      
   } // end method createUserInterface

   // method called when uses types in hourlyWageJTextField
   private void hourlyWageJTextFieldKeyPressed( KeyEvent event )
   {
      // clear output JTextFields when key pressed
      grossWagesJTextField.setText( "" );
      federalTaxesJTextField.setText( "" );
      netWagesJTextField.setText( "" );

   } // end method hourlyWageJTextFieldKeyPressed
   
   // method called when uses types in hoursWorkedJTextField
   private void hoursWorkedJTextFieldKeyPressed( KeyEvent event )
   {
      // clear output JTextFields when key pressed
      grossWagesJTextField.setText( "" );
      federalTaxesJTextField.setText( "" );
      netWagesJTextField.setText( "" );

   } // end method hoursWorkedJTextFieldKeyPressed
   
   // method called when user presses calculateJButton
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      // get hourly wage
      double hourlyWage = 
         Double.parseDouble( hourlyWageJTextField.getText() );

      // get number of hours worked this week
      double hoursWorked = 
         Double.parseDouble( hoursWorkedJTextField.getText() );
      
      // constant for maximum hours employee can  
      // work before being paid for overtime
      final double HOUR_LIMIT = 40.0; 
      
      // gross wages for week; calculated in if...else statement
      double wages; 

      // determine gross wages
      if ( hoursWorked <= HOUR_LIMIT ) 
      {
         // regular wages for HOUR_LIMIT (40) hours or less
         wages = ( hoursWorked * hourlyWage ); 
      }
      else // worked more than HOUR_LIMIT (40) hours
      {
         // wage for first HOUR_LIMIT (40) hours
         wages = HOUR_LIMIT * hourlyWage;

         // add time-and-a-half for hours above HOUR_LIMIT (40)
         wages += 
            ( hoursWorked - HOUR_LIMIT ) * ( 1.5 * hourlyWage );
      }

      // specify output format
      DecimalFormat dollars = new DecimalFormat( "$0.00" );

      // display gross wages 
      grossWagesJTextField.setText( dollars.format( wages ) );
      
   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      WageCalculator application = new WageCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class WageCalculator


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
