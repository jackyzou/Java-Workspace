// Tutorial 6: WageCalculator.java
// This application inputs the hourly wage and number of hours
// worked for an employee, then calculates the employee's gross 
// wages (with overtime for hours worked over 40 hours).
// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
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
   
   // JButton to initiate wage calculation
   private JButton calculateJButton;
   
   
   
   //hourly wage max hours
   private final double MAX_HOURS = 40.0;//�»��ߣ�final��ȫ�Ĳ��ܸ��ĵ�
   

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
      
      // set up hoursWorkedJLabel
      hoursWorkedJLabel = new JLabel();
      hoursWorkedJLabel.setBounds( 16, 56, 95, 21 );
      hoursWorkedJLabel.setText( "Hours worked:" );
      contentPane.add( hoursWorkedJLabel );
      
      // set up hoursWorkedJTextField
      hoursWorkedJTextField = new JTextField();
      hoursWorkedJTextField.setBounds( 120, 56, 90, 21 );
      hoursWorkedJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( hoursWorkedJTextField );
      
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
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setBounds( 120, 136, 90, 24 );
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
      setSize( 230, 200 );           // set window size
      setVisible( true );            // display window
      
   } // end method createUserInterface
   
   // method called when user presses calculateJButton
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
	  
	   
	   try
	   {

		   
   double dough  = Double.parseDouble(hourlyWageJTextField.getText()); 
   double hours =  Double.parseDouble(hoursWorkedJTextField.getText()); 
   double wage = 0.0;
   if(dough > 0 && hours >0)
   {
  
   if(hours>MAX_HOURS)
   {
	   wage = MAX_HOURS * dough + (hours - MAX_HOURS)*dough*1.5;
   }
   else
   {
	   wage = hours * dough;
   }
   

   DecimalFormat dollars = new DecimalFormat("$0.00");
   
   
    grossWagesJTextField.setText(String.valueOf(dollars.format( wage))); 
    }  //dollars.format(wage)
	   }

	   catch(Exception b)
	   {
		   JOptionPane.showMessageDialog(null,"Positive Rational Numbers please","ERROR",
					  JOptionPane.ERROR_MESSAGE);  
	   }
	     
    

   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      WageCalculator application = new WageCalculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class WageCalculator

