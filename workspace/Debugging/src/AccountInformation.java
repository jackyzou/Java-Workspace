// Exercise 4.16: AccountInformation.java
// This application inputs and outputs account information.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AccountInformation extends JFrame
{
   // JPanel to group deposit components
   private JPanel enterJPanel;

   // JLabel and JTextField for deposits
   private JLabel depositJLabel;
   private JTextField depositJTextField;

   // JButton to initiate balance calculation
   private JButton enterJButton;

   // JPanel to group account information components
   private JPanel accountJPanel;

   // JLabel and JTextField for account holder's name
   private JLabel nameJLabel;
   private JTextField nameJTextField;

   // JLabel and JTextField for account number
   private JLabel accountNumberJLabel;
   private JTextField accountNumberJTextField;

   // JLabel and JTextField for balance
   private JLabel balanceJLabel;
   private JTextField balanceJTextField;
   private JPasswordField Fuckyou;
   // no-argument constructor
   public AccountInformation() 
   {
      createUserInterface();
   }
   
   // create and position GUI components; register event handlers
   private void createUserInterface()
   {
      // get content pane and set layout to null
      Container contentPane = getContentPane();
      contentPane.setLayout( null );
      
      // set up enterJPanel
      enterJPanel = new JPanel();
      enterJPanel.setLayout( null );
      enterJPanel.setBounds( 16, 16, 152, 126 );
      enterJPanel.setBorder( 
         new TitledBorder( "Enter information" ) );
      contentPane.add( enterJPanel );
      
      Fuckyou = new JPasswordField();
      Fuckyou.setText( "0" );
      Fuckyou.setBounds( 16, 56, 120, 21 );
      Fuckyou.setHorizontalAlignment( JTextField.RIGHT );
      enterJPanel.add( Fuckyou );
      
      // set up depositJLabel
      depositJLabel = new JLabel();
      depositJLabel.setText( "Deposit amount:" );
      depositJLabel.setBounds( 16, 40, 140, 16 );
      enterJPanel.add( depositJLabel );
      
      // set up depositJTextField
      depositJTextField = new JTextField();
      depositJTextField.setText( "0" );
      depositJTextField.setBounds( 16, 56, 120, 21 );
      depositJTextField.setHorizontalAlignment( JTextField.RIGHT );
      enterJPanel.add( depositJTextField );

      // set up enterJButton
      enterJButton = new JButton();
      enterJButton.setText( "Enter" );
      enterJButton.setBounds( 16, 150, 152, 34 );
      contentPane.add( enterJButton );
      enterJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when enterJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               enterJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set up accountJPanel
      accountJPanel = new JPanel();
      accountJPanel.setLayout( null );
      accountJPanel.setBounds( 180, 16, 136, 170 );
      accountJPanel.setBorder( 
         new TitledBorder( "Account information" ) );
      contentPane.add( accountJPanel );
      
      // set up nameJLabel
      nameJLabel = new JLabel();
      nameJLabel.setText( "Name:" );
      nameJLabel.setBounds( 16, 24, 100, 16 );
      accountJPanel.add( nameJLabel );

      // set up nameJTextField
      nameJTextField = new JTextField();
      nameJTextField.setText( "Sue Purple" );
      nameJTextField.setBounds( 16, 40, 104, 21 );
      nameJTextField.setEditable( false );
      accountJPanel.add( nameJTextField );

      // set up accountNumberJLabel
      accountNumberJLabel = new JLabel();
      accountNumberJLabel.setText( "Account Number:" );
      accountNumberJLabel.setBounds( 16, 70, 140, 16 );
      accountJPanel.add( accountNumberJLabel );

      // set up accountNumberJTextField
      accountNumberJTextField = new JTextField();
      accountNumberJTextField.setText( "12345" );
      accountNumberJTextField.setBounds( 16, 86, 104, 21 );
      accountNumberJTextField.setEditable( false );
      accountNumberJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      accountJPanel.add( accountNumberJTextField );

      // set up balanceJLabel
      balanceJLabel = new JLabel();
      balanceJLabel.setText( "Balance:" );
      balanceJLabel.setBounds( 16, 116, 100, 16 );
      accountJPanel.add( balanceJLabel );
      
      // set up balanceJTextField
      balanceJTextField = new JTextField();
      balanceJTextField.setText( "0" );
      balanceJTextField.setBounds( 16, 132, 104, 21 );
      balanceJTextField.setEditable( false );
      balanceJTextField.setHorizontalAlignment( JTextField.RIGHT );
      accountJPanel.add( balanceJTextField );
      
      // set properties of application's window
      setTitle( "Account Information" ); // set title bar text
      setSize( 340, 225 );               // set window size
      setVisible( true );                // display window

   } // end method createUserInterface

   // method called when enterJButton is pressed
   private void enterJButtonActionPerformed( ActionEvent event )
   {
      // display new balance
      balanceJTextField.setText( String.valueOf( 
         Integer.parseInt( balanceJTextField.getText() ) * 
         Integer.parseInt( depositJTextField.getText() ) ) );

      // clear depositJTextField
      depositJTextField.setText( "0" );    

   } // end method enterJButtonActionPerformed

   // main method
   public static void main( String[] args ) 
   {
      AccountInformation application = new AccountInformation();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class AccountInformation


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
