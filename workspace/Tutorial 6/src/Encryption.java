// Exercise 6.17: Encryption.java// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// Encrypts data given by user.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Encryption extends JFrame
{
   // JLabel and JTextField for inputting number
   private JLabel numberJLabel;
   private JTextField numberJTextField;

   // JLabel and JTextFields for displaying encrypted results
   private JLabel encryptedResultsJLabel;
   private JTextField encryptedDigit1JTextField;
   private JTextField encryptedDigit2JTextField;
   private JTextField encryptedDigit3JTextField;
   private JTextField encryptedDigit4JTextField;

   // JButton to initiate encryption
   private JButton encryptJButton;
   
   // no-argument constructor
   public Encryption()
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
      
      // set up numberJLabel
      numberJLabel = new JLabel();
      numberJLabel.setBounds( 10, 10, 140, 25 );
      numberJLabel.setText( "Enter 4-digit integer:" );
      contentPane.add( numberJLabel );
            
      // set up numberJTextField
      numberJTextField = new JTextField();
      numberJTextField.setBounds( 145, 10, 95, 25 );
      contentPane.add( numberJTextField );
      numberJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // event handler called when key pressed 
            // in numberJTextField
            public void keyPressed( KeyEvent event )
            {
               numberJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener

      // set up encryptedResultsJLabel
      encryptedResultsJLabel = new JLabel();
      encryptedResultsJLabel.setBounds( 10, 45, 140, 25 );
      encryptedResultsJLabel.setText( "Encrypted digits:" );
      contentPane.add( encryptedResultsJLabel );
            
      // set up encryptedDigit1JTextField
      encryptedDigit1JTextField = new JTextField();
      encryptedDigit1JTextField.setBounds( 145, 45, 25, 25 );
      encryptedDigit1JTextField.setHorizontalAlignment(
         JTextField.CENTER );
      encryptedDigit1JTextField.setEditable( false );
      contentPane.add( encryptedDigit1JTextField );
      
      // set up encryptedDigit2JTextField
      encryptedDigit2JTextField = new JTextField();
      encryptedDigit2JTextField.setBounds( 170, 45, 25, 25 );
      encryptedDigit2JTextField.setHorizontalAlignment(
         JTextField.CENTER );
      encryptedDigit2JTextField.setEditable( false );
      contentPane.add( encryptedDigit2JTextField );
      
      // set up encryptedDigit3JTextField
      encryptedDigit3JTextField = new JTextField();
      encryptedDigit3JTextField.setBounds( 195, 45, 25, 25 );
      encryptedDigit3JTextField.setHorizontalAlignment(
         JTextField.CENTER );
      encryptedDigit3JTextField.setEditable( false );
      contentPane.add( encryptedDigit3JTextField );
      
      // set up encryptedDigit4JTextField
      encryptedDigit4JTextField = new JTextField();
      encryptedDigit4JTextField.setBounds( 220, 45, 25, 25 );
      encryptedDigit4JTextField.setHorizontalAlignment(
         JTextField.CENTER );
      encryptedDigit4JTextField.setEditable( false );
      contentPane.add( encryptedDigit4JTextField );
      
      // set up encryptJButton and register its event handler
      encryptJButton = new JButton();
      encryptJButton.setText( "Encrypt" );
      encryptJButton.setBounds( 250, 10, 100, 25 );
      contentPane.add( encryptJButton );
      encryptJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when encryptJButton is pressed
             public void actionPerformed ( ActionEvent event )
             {
                encryptJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener
     
      // set properties of application's window
      setTitle( "Encryption" ); // set title bar text
      setSize( 370, 110 );      // set window size
      setVisible( true );       // display window
      
   } // end method createUserInterface

   // method called when key pressed in numberJTextField
   private void numberJTextFieldKeyPressed( KeyEvent event )
   {
      // clear JTextFields for encrypted digits when new number input
      encryptedDigit1JTextField.setText( "" );
      encryptedDigit2JTextField.setText( "" );
      encryptedDigit3JTextField.setText( "" );
      encryptedDigit4JTextField.setText( "" );

   } // end method numberJTextFieldKeyPressed
   
   // method called when user clicks encryptJButton
   private void encryptJButtonActionPerformed( ActionEvent event )
   {
	   
	   try
	   {
	   int number ;
	   number = Integer.parseInt(numberJTextField.getText());
	   if (number<10000)
	   {
	   encryptedDigit3JTextField.setText(String.valueOf(((number/1000)+7)%10));
	   encryptedDigit4JTextField .setText(String.valueOf((number%1000/100+7)%10));
	   encryptedDigit1JTextField .setText(String.valueOf((number%100/10+7)%10));
	   encryptedDigit2JTextField .setText(String.valueOf((number%10+7)%10));

  

  

	   }
	   
	   else
	   {
		   		JOptionPane.showMessageDialog(null,"Type in an integer that Smaller than 10000 ","ERROR",
			  JOptionPane.ERROR_MESSAGE);
	   }
	   
	   }
	   catch(Exception b)
	   {
	   	   JOptionPane.showMessageDialog(null,"Positive Rational Numbers please","ERROR",
	   				  JOptionPane.ERROR_MESSAGE);  
	   }
   } // end method encryptJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      Encryption application = new Encryption();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Encryption


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
