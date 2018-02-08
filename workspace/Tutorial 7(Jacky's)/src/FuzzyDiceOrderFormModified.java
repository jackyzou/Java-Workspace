// Exercise 7.13: FuzzyDiceOrderForm.java

// This application calculates the total cost of a
// purchase order for different colored fuzzy dice.
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
import java.awt.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;

public class FuzzyDiceOrderFormModified extends JFrame
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

	   // JLabel and JTextField for discount
	   private JLabel discountJLabel;
	   private JTextField discountJTextField;

	   // JLabel and JTextField for final total
	   private JLabel totalJLabel;
	   private JTextField totalJTextField;

	   // JButton to initiate calculate of user's bill
	   private JButton calculateJButton;
	   private JButton clearJButton;
	   
	   // no-argument constructor
	   public FuzzyDiceOrderFormModified()
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
	      clearJButton.setBounds( 170, 397, 87, 23 );
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
	            
	         } // end anonymous inner class
	         
	      ); // end call to addActionListener
	      
	      
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
	   	           	 discountJTextField.setText( "$0.00" );
	   	          }

	   	         } // end anonymous inner class

	   	      ); // end call to addKeyListener
	      orderNumberJTextField.addMouseListener(new MouseAdapter(){
	          public void mouseClicked(MouseEvent e){
	        	  orderNumberJTextField.setText("");
	      
	          }
	          });

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
	      whiteTypeJCheckBox.setBounds( 10, 227, 113, 21 );
	      whiteTypeJCheckBox.setText( "White/Black" );
	      contentPane.add( whiteTypeJCheckBox );
	      whiteTypeJCheckBox.addActionListener( 
	      
	         new ActionListener() // anonymous inner class
	         {
	            // event handler called when user selects
	            // or deselects whiteTypeJCheckBox
	            public void actionPerformed( ActionEvent event )
	            {
	               whiteTypeJCheckBoxActionPerformed( event );
	            }
	            
	         } // end anonymous inner class
	         
	      ); // end call to addActionListener
	      
	      // set up redTypeJCheckBox
	      redTypeJCheckBox = new JCheckBox(); 
	      redTypeJCheckBox.setBounds( 10, 252, 108, 21 );
	      redTypeJCheckBox.setText( "Red/Black" ); 
	      contentPane.add( redTypeJCheckBox );
	      redTypeJCheckBox.addActionListener( 
	      
	         new ActionListener() // anonymous inner class
	         {
	            // event handler called when user selects
	            // or deselects redTypeJCheckBox
	            public void actionPerformed( ActionEvent event )
	            {
	               redTypeJCheckBoxActionPerformed( event );
	            }
	            
	         } // end anonymous inner class
	         
	      ); // end call to addActionListener

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
	      whiteQuantityJTextField.addKeyListener(

		   	         new KeyAdapter() // anonymous inner class
		   	         {
		   	            // event handler called when key pressed in 
		   	            // accountNumberJTextField
		   	            public void keyPressed( KeyEvent event )
		   	            {
		   	            	whiteQuantityJTextFieldKeyPressed( event );
		   	            }

		   	           private void whiteQuantityJTextFieldKeyPressed( KeyEvent event )
		   	          {
		   	  
		   	   whiteTotalsJTextField.setText( "$0.00" );
		   	   redTotalsJTextField.setText( "$0.00" );
		   	  subtotalJTextField.setText( "$0.00" );
		   	 taxJTextField.setText( "$0.00" );
		   	  totalJTextField.setText( "$0.00" );
		  	discountJTextField.setText( "$0.00" );
		   	          }

		   	         } // end anonymous inner class

		   	      ); // end call to addKeyListener
	      whiteQuantityJTextField.addMouseListener(new MouseAdapter(){
	          public void mouseClicked(MouseEvent e){
	        	  whiteQuantityJTextField.setText("");
	      
	          }
	          });

	      // set up redQuantityJTextField
	      redQuantityJTextField = new JTextField();
	      redQuantityJTextField.setBounds( 111, 252, 64, 21 );
	      redQuantityJTextField.setText( "0" );
	      redQuantityJTextField.setHorizontalAlignment(
	         JTextField.RIGHT );
	      contentPane.add( redQuantityJTextField );
	      redQuantityJTextField.addKeyListener(

		   	         new KeyAdapter() // anonymous inner class
		   	         {
		   	            // event handler called when key pressed in 
		   	            // accountNumberJTextField
		   	            public void keyPressed( KeyEvent event )
		   	            {
		   	            	redQuantityJTextFieldKeyPressed( event );
		   	            }

		   	           private void redQuantityJTextFieldKeyPressed( KeyEvent event )
		   	          {
		   	  
		   	   whiteTotalsJTextField.setText( "$0.00" );
		   	   redTotalsJTextField.setText( "$0.00" );
		   	  subtotalJTextField.setText( "$0.00" );
		   	 taxJTextField.setText( "$0.00" );
		   	  totalJTextField.setText( "$0.00" );
		  	discountJTextField.setText( "$0.00" );
		   	          }

		   	         } // end anonymous inner class

		   	      ); // end call to addKeyListener
	      redQuantityJTextField.addMouseListener(new MouseAdapter(){
	          public void mouseClicked(MouseEvent e){
	        	  redQuantityJTextField.setText("");
	      
	          }
	          });

	      // set up priceJLabel
	      priceJLabel = new JLabel();
	      priceJLabel.setBounds( 196, 204, 72, 16 );
	      priceJLabel.setText( "Price:" );
	      contentPane.add( priceJLabel );

	      // set up whitePriceJLabel
	      whitePriceJLabel = new JLabel();
	      whitePriceJLabel.setBounds( 196, 228, 80, 21 );
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

	      // set up discountJLabel
	      discountJLabel = new JLabel();
	      discountJLabel.setBounds( 196, 341, 72, 16 );
	      discountJLabel.setText( "Discount:" );
	      contentPane.add( discountJLabel );

	      // set up discountJTextField
	      discountJTextField = new JTextField();
	      discountJTextField.setBounds( 267, 341, 87, 16 );
	      discountJTextField.setText( "$0.00" );
	      discountJTextField.setEditable( false );
	      discountJTextField.setHorizontalAlignment(
	         JTextField.RIGHT );
	      contentPane.add( discountJTextField );

	      // set up totalJLabel
	      totalJLabel = new JLabel();
	      totalJLabel.setBounds( 196, 365, 72, 16 );
	      totalJLabel.setText( "Total:" );
	      contentPane.add( totalJLabel );

	      // set up totalJTextField
	      totalJTextField = new JTextField();
	      totalJTextField.setBounds( 267, 365, 87, 16 );
	      totalJTextField.setText( "$0.00" );
	      totalJTextField.setEditable( false );
	      totalJTextField.setHorizontalAlignment(
	         JTextField.RIGHT );
	      contentPane.add( totalJTextField );
	      
	      // set up calculateJButton and register its event handler
	      calculateJButton = new JButton();
	      calculateJButton.setBounds( 267, 397, 87, 23 );
	      calculateJButton.setText( "Calculate" );
	      contentPane.add( calculateJButton );
	      calculateJButton.addActionListener( 
	      
	         new ActionListener() // anonymous inner class
	         {
	            // method called when user clicks calculateJButton
	            public void actionPerformed( ActionEvent event )
	            {
	               calculateJButtonActionPerformed( event );
	            }
	            
	         } // end anonymous inner class
	         
	      ); // end call to addActionListener
	      
	      // set properties of application's window
	      setTitle( "Fuzzy Dice Order Form" ); // set title bar string
	      setSize( 380, 466 );                 // set window size
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
	      if ( orderNumber.equals( "" ) || name.equals( "" ) || 
	         address1.equals( "" ) || address2.equals( "" ) ||
	         orderNumber.equals( "0" ) || 
	         name.equals( "Enter name here" ) || 
	         address1.equals( "Address Line 1" ) ||
	         address2.equals( "City, State, Zip" ) )
	      {
	         // display message
	         JOptionPane.showMessageDialog( null,
	            "Please fill out all information fields.", 
	            "Empty Fields", JOptionPane.WARNING_MESSAGE );
	      }
	      else if ( !whiteTypeJCheckBox.isSelected() && 
	         !redTypeJCheckBox.isSelected() )
	      {
	         // display message if no JCheckBox is
	         // selected and its quantity is 0
	         JOptionPane.showMessageDialog( null,
	            "Please select an item and enter a quantity.",
	            "No Item selected", JOptionPane.WARNING_MESSAGE );
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

	         // if subtotal is greater than $50 
	         // display message and give 7% discount
	         if ( subtotal > 50 )
	         {
	            JOptionPane.showMessageDialog( null, 
	              "7% discount will be applied.", "Discount Offer", 
	              JOptionPane.INFORMATION_MESSAGE );
	              
	            // calculate and display discount
	            double discount = subtotal * 0.07;
	            discountJTextField.setText( 
	               dollars.format( -discount ) );
	            
	            subtotal -= discount; // calculate new subtotal
	         }
	         else // no discount if subtotal is not greater than 50
	         {
	            discountJTextField.setText( "$0.00" );
	         }
	         
	         // calculate and display tax
	         double tax = subtotal * 0.05;
	         taxJTextField.setText( dollars.format( tax ) );
	            
	         // calculate and display total
	         totalJTextField.setText( 
	            dollars.format( subtotal + tax ) );
	         
	      } // end else

	   } // end method calculateJButtonActionPerformed

	   // modifying application when whiteTypeJCheckBox
	   // is selected or deselected
	   private void whiteTypeJCheckBoxActionPerformed(
	      ActionEvent event )
	   {
if(!whiteTypeJCheckBox.isSelected())
{
    whiteTotalsJTextField.setText( "$0.00" );
    redTotalsJTextField.setText( "$0.00" );
    subtotalJTextField.setText( "$0.00" );
    taxJTextField.setText( "$0.00" );
    discountJTextField.setText( "$0.00" );
    totalJTextField.setText( "$0.00" );
    whiteQuantityJTextField.setText( "0" );
}
	   } // end method whiteTypeJCheckBoxActionPerformed

	   // modifying application when redTypeJCheckBox
	   // is selected or deselected
	   private void redTypeJCheckBoxActionPerformed( ActionEvent event )
	   {
		   if(!redTypeJCheckBox.isSelected())
		   {
			    whiteTotalsJTextField.setText( "$0.00" );
			      redTotalsJTextField.setText( "$0.00" );
			      subtotalJTextField.setText( "$0.00" );
			      taxJTextField.setText( "$0.00" );
			      discountJTextField.setText( "$0.00" );
			      totalJTextField.setText( "$0.00" );
			      redQuantityJTextField.setText( "0" );
		   }
		   
	   } // end method redTypeJCheckBoxActionPerformed

	   // reset components
	   private void clearJButtonActionPerformed( ActionEvent event)
	   {
	      whiteTotalsJTextField.setText( "$0.00" );
	      redTotalsJTextField.setText( "$0.00" );
	      subtotalJTextField.setText( "$0.00" );
	      taxJTextField.setText( "$0.00" );
	      discountJTextField.setText( "$0.00" );
	      totalJTextField.setText( "$0.00" );

	   } // end method clearResults
	   
	   // main method
   public static void main( String[] args )
   {
	   FuzzyDiceOrderFormModified application = new FuzzyDiceOrderFormModified();
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
