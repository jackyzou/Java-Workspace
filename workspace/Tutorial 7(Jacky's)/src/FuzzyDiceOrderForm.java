// Exercise 7.12: FuzzyDiceOrderForm.java

// This application calculates the total cost of a
// purchase order for different colored fuzzy dice.
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
import java.awt.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;

public class FuzzyDiceOrderForm extends JFrame
{
   // JLabel that displays header on application window
   private JLabel fuzzyDiceJLabel;

   // JLabel and JTextField for order number
   private JLabel orderNumberJLabel;
   private JTextField orderNumberJTextField;

   // JLabel and JTextField for user's name
   private JLabel nameJLabel;
   private JTextField nameJTextField;

   // JLabel and JTextFields for user's address
   private JLabel addressJLabel;
   private JTextField addressJTextField1;
   private JTextField addressJTextField2;

   // JLabel and JCheckBoxes for die types
   private JLabel typeJLabel;
   private JCheckBox whiteTypeJCheckBox;
   private JCheckBox redTypeJCheckBox;

   // JLabel and JTextFields for die quantities
   private JLabel quantityJLabel;
   private JTextField whiteQuantityJTextField;
   private JTextField redQuantityJTextField;

   // JLabels for die prices
   private JLabel priceJLabel;
   private JLabel whitePriceJLabel;
   private JLabel redPriceJLabel;

   // JLabel and JTextFields for die subtotals
   private JLabel totalsJLabel;
   private JTextField whiteTotalsJTextField;
   private JTextField redTotalsJTextField;

   // JLabel and JTextField for total before tax
   private JLabel subtotalJLabel;
   private JTextField subtotalJTextField;
   
   // JLabel and JTextField for tax
   private JLabel taxJLabel;
   private JTextField taxJTextField;

   // JLabel and JTextField for final total
   private JLabel totalJLabel;
   private JTextField totalJTextField;

   // JButton to initiate calculate of user's bill
   private JButton calculateJButton;
   
   // no-argument constructor
   public FuzzyDiceOrderForm()
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
      
      // set up fuzzyDiceJLabel
      fuzzyDiceJLabel = new JLabel();
      fuzzyDiceJLabel.setBounds( 137, 16, 235, 24 );
      fuzzyDiceJLabel.setText( "Fuzzy Dice" );
      fuzzyDiceJLabel.setFont( 
         new Font( "Default", Font.PLAIN, 22 ) );
      contentPane.add( fuzzyDiceJLabel );

      // set up orderNumberJLabel
      orderNumberJLabel = new JLabel();
      orderNumberJLabel.setBounds( 15, 65, 100, 16 );
      orderNumberJLabel.setText( "Order Number:" );
      contentPane.add( orderNumberJLabel );

      // set up orderNumberJTextField
      orderNumberJTextField = new JTextField();
      orderNumberJTextField.setBounds( 111, 65, 48, 21 );
      orderNumberJTextField.setText( "0" );
      orderNumberJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( orderNumberJTextField );
      orderNumberJTextField.addKeyListener(

  	         new KeyAdapter() // anonymous inner class
  	         {
  	            // event handler called when key pressed in 
  	            // accountNumberJTextField
  	            public void keyPressed( KeyEvent event )
  	            {
  	            	orderNumberJTextFieldKeyPressed( event );
  	            }

  	           private void orderNumberJTextFieldKeyPressed( KeyEvent event )
  	          {
  	        	 addressJTextField1.setText("Address Line 1");
  	        	addressJTextField2.setText("City, State, Zip" );
  	       	nameJTextField.setText("Enter name here");
  	      whiteTypeJCheckBox.setSelected(false);
  	    redTypeJCheckBox.setSelected(false);
  	  whiteQuantityJTextField.setText("0");
  	  redQuantityJTextField.setText("0");
  	   whiteTotalsJTextField.setText( "$0.00" );
  	   redTotalsJTextField.setText( "$0.00" );
  	  subtotalJTextField.setText( "$0.00" );
  	 taxJTextField.setText( "$0.00" );
  	  totalJTextField.setText( "$0.00" );
  	          }

  	         } // end anonymous inner class

  	      ); // end call to addKeyListener
      

      // set up nameJLabel
      nameJLabel = new JLabel();
      nameJLabel.setBounds( 15, 105, 40, 16 );
      nameJLabel.setText( "Name:" );
      contentPane.add( nameJLabel );

      // set up nameJTextField
      nameJTextField = new JTextField();
      nameJTextField.setBounds( 111, 105, 245, 21 );
      nameJTextField.setText( "Enter name here" );
      contentPane.add( nameJTextField );

      // set up addressJLabel
      addressJLabel = new JLabel();
      addressJLabel.setBounds( 15, 129, 56, 16 );
      addressJLabel.setText( "Address:" );
      contentPane.add( addressJLabel );

      // set up addressJTextField1
      addressJTextField1 = new JTextField();
      addressJTextField1.setBounds( 111, 129, 245, 21 );
      addressJTextField1.setText( "Address Line 1" );
      contentPane.add( addressJTextField1 );

      // set up addressJTextField2
      addressJTextField2 = new JTextField();
      addressJTextField2.setBounds( 111, 153, 245, 21 );
      addressJTextField2.setText( "City, State, Zip" );
      contentPane.add( addressJTextField2 );

      // set up typeJLabel
      typeJLabel = new JLabel();
      typeJLabel.setBounds( 15, 204, 40, 16 );
      typeJLabel.setText( "Type:" );
      contentPane.add( typeJLabel );

      // set up whiteTypeJCheckBox
      whiteTypeJCheckBox = new JCheckBox();
      whiteTypeJCheckBox.setBounds( 16, 225, 100, 24 );
      whiteTypeJCheckBox.setText( "White Dice" );
      contentPane.add( whiteTypeJCheckBox );
      
      // set up redTypeJCheckBox
      redTypeJCheckBox = new JCheckBox();
      redTypeJCheckBox.setBounds( 16, 250, 90, 24 );
      redTypeJCheckBox.setText( "Red Dice" );
      contentPane.add( redTypeJCheckBox );

      // set up quantityJLabel
      quantityJLabel = new JLabel();
      quantityJLabel.setBounds( 111, 204, 72, 16 );
      quantityJLabel.setText( "Quantity:" );
      contentPane.add( quantityJLabel );

      // set up whiteQuantityJTextField
      whiteQuantityJTextField = new JTextField();
      whiteQuantityJTextField.setBounds( 111, 228, 64, 21 );
      whiteQuantityJTextField.setText( "0" );
      whiteQuantityJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( whiteQuantityJTextField );

      // set up redQuantityJTextField
      redQuantityJTextField = new JTextField();
      redQuantityJTextField.setBounds( 111, 252, 64, 21 );
      redQuantityJTextField.setText( "0" );
      redQuantityJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( redQuantityJTextField );

      // set up priceJLabel
      priceJLabel = new JLabel();
      priceJLabel.setBounds( 196, 204, 72, 16 );
      priceJLabel.setText( "Price:" );
      contentPane.add( priceJLabel );

      // set up whitePriceJLabel
      whitePriceJLabel = new JLabel();
      whitePriceJLabel.setBounds( 196, 228, 120, 21 );
      whitePriceJLabel.setText( "$6.25" );
      contentPane.add( whitePriceJLabel );

      // set up redPriceJLabel
      redPriceJLabel = new JLabel();
      redPriceJLabel.setBounds( 196, 252, 80, 21 );
      redPriceJLabel.setText( "$5.00" );
      contentPane.add( redPriceJLabel );

      // set up totalsJLabel
      totalsJLabel = new JLabel();
      totalsJLabel.setBounds( 267, 204, 72, 16 );
      totalsJLabel.setText( "Totals:" );
      contentPane.add( totalsJLabel );

      // set up whiteTotalsJTextField
      whiteTotalsJTextField = new JTextField();
      whiteTotalsJTextField.setBounds( 267, 228, 87, 16 );
      whiteTotalsJTextField.setText( "$0.00" );
      whiteTotalsJTextField.setEditable( false );
      whiteTotalsJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( whiteTotalsJTextField );

      // set up redTotalsJTextField
      redTotalsJTextField = new JTextField();
      redTotalsJTextField.setBounds( 267, 252, 87, 16 );
      redTotalsJTextField.setText( "$0.00" );
      redTotalsJTextField.setEditable( false );
      redTotalsJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( redTotalsJTextField );

      // set up subtotalJLabel
      subtotalJLabel = new JLabel();
      subtotalJLabel.setBounds( 196, 293, 72, 16 );
      subtotalJLabel.setText( "Subtotal:" );
      contentPane.add( subtotalJLabel );

      // set up subtotalJTextField
      subtotalJTextField = new JTextField();
      subtotalJTextField.setBounds( 267, 293, 87, 16 );
      subtotalJTextField.setText( "$0.00" );
      subtotalJTextField.setEditable( false );
      subtotalJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( subtotalJTextField );

      // set up taxJLabel
      taxJLabel = new JLabel();
      taxJLabel.setBounds( 196, 317, 72, 16 );
      taxJLabel.setText( "Tax:" );
      contentPane.add( taxJLabel );

      // set up taxJTextField
      taxJTextField = new JTextField();
      taxJTextField.setBounds( 267, 317, 87, 16 );
      taxJTextField.setText( "$0.00" );
      taxJTextField.setEditable( false );
      taxJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( taxJTextField );

      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setBounds( 196, 341, 72, 16 );
      totalJLabel.setText( "Total:" );
      contentPane.add( totalJLabel );

      // set up totalJTextField
      totalJTextField = new JTextField();
      totalJTextField.setBounds( 267, 341, 87, 16 );
      totalJTextField.setText( "$0.00" );
      totalJTextField.setEditable( false );
      totalJTextField.setHorizontalAlignment(
         JTextField.RIGHT );
      contentPane.add( totalJTextField );
      
      // set up calculateJButton and register its event handler
      calculateJButton = new JButton();
      calculateJButton.setBounds( 267, 373, 87, 23 );
      calculateJButton.setText( "Calculate" );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when user clicks calculateJButton
            public void actionPerformed( ActionEvent event )
            {
               calculateJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Fuzzy Dice Order Form" ); // set title bar string
      setSize( 380, 442 );                 // set window size
      setVisible( true );                  // display window
      
   } // end method createUserInterface
   
   // calculate the cost of the order
   private void calculateJButtonActionPerformed( ActionEvent event )
   {
      // get user inputs
      String orderNumber = orderNumberJTextField.getText();
      String name = nameJTextField.getText();
      String address1 = addressJTextField1.getText();
      String address2 = addressJTextField2.getText();

      // total of white/black dice ordered
      double whiteTotals = 0.0;

      // total of red/black dice ordered
      double redTotals = 0.0;

      // calculate price if white/black JCheckBox is selected
      if ( whiteTypeJCheckBox.isSelected() )
      {
    	  try{
         whiteTotals = Integer.parseInt( 
            whiteQuantityJTextField.getText() ) * 6.25;
    	  }
    	  catch(Exception b)
     	   {
     		   JOptionPane.showMessageDialog(null,"Rational Numbers in Quantity please","ERROR",
     					  JOptionPane.ERROR_MESSAGE);  
     	   }
      }

      // calculate price if red/black JCheckBox is selected
      if ( redTypeJCheckBox.isSelected() )
      {
    	  try{
         redTotals = Integer.parseInt(
            redQuantityJTextField.getText() ) * 5.00;
    	  }
    	  catch(Exception c)
     	   {
     		   JOptionPane.showMessageDialog(null,"Rational Numbers in Quantity please","ERROR",
     					  JOptionPane.ERROR_MESSAGE);  
     	   }
      }
       
      // display message if order number, name or address is empty
      
      
      if ( orderNumber.equals("0") || name.equals("Enter name here") || address1.equals("Address Line 1") ||  address2.equals("" +
      		"City, State, Zip"))
      {
    	  JOptionPane.showMessageDialog(null,"Please fill in all necessary data","Not enough information",
  					   JOptionPane.INFORMATION_MESSAGE); 
      }

      else // otherwise, calculate totals
      {
         // set display format
         DecimalFormat dollars = new DecimalFormat( "$0.00" );

         // display totals of dice ordered
         whiteTotalsJTextField.setText( dollars.format(
            whiteTotals ) );
         redTotalsJTextField.setText( dollars.format( redTotals ) );
         
         // calculate and display subtotal
         double subtotal = whiteTotals + redTotals;
         subtotalJTextField.setText( dollars.format( subtotal ) );
         
         // calculate and display tax
         double tax = subtotal * 0.05;
         taxJTextField.setText( dollars.format( tax ) );
            
         // calculate and display total
         totalJTextField.setText( 
            dollars.format( subtotal + tax ) );
         
      } // end else

   } // end method calculateJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      FuzzyDiceOrderForm application = new FuzzyDiceOrderForm();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class FuzzyDiceOrderForm

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
