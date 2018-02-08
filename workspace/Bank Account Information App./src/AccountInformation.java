// Exercise 4.13: AccountInformation.java
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
   
   private JLabel withdrawalJLabel;
   private JTextField withdrawalJTextField;

   // JLabel and JTextField for balance
   private JLabel balanceJLabel;
   private JTextField balanceJTextField;
   
   private JLabel pictureJLabel;
   
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
      contentPane.setBackground(Color.BLUE);
      contentPane.setLayout( null );
      
      
    
      
      // set up enterJPanel
      enterJPanel = new JPanel();
      enterJPanel.setLayout( null );
      enterJPanel.setBounds( 16, 16, 152, 126 );
      enterJPanel.setBorder( 
         new TitledBorder( "Enter information" ) );
      contentPane.add( enterJPanel );
      
      
      pictureJLabel = new JLabel();
      pictureJLabel.setIcon(new ImageIcon("checkout-thankyou-title.png"));
      pictureJLabel.setBounds(0, -67, 152, 16);
      pictureJLabel.setHorizontalAlignment( JLabel.LEADING);
      pictureJLabel.setSize(250,200);
      enterJPanel.add( pictureJLabel );
      
      
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


      withdrawalJLabel = new JLabel();
      withdrawalJLabel.setText( "Withdrawal amount:" );
      withdrawalJLabel.setBounds( 16, 80, 150, 16 );
      enterJPanel.add( withdrawalJLabel );

      // set up withdrawalJTextField
      withdrawalJTextField = new JTextField();
      withdrawalJTextField.setText( "0" );
      withdrawalJTextField.setBounds( 16, 100, 120, 21 );
      withdrawalJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      enterJPanel.add( withdrawalJTextField );

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
               depositJTextField.setText("");
               withdrawalJTextField.setText("");
            }
           
            //public void keyPressed(KeyEvent event)
            //{
            //depositJTextField.setText("");
            //}
            //public void keyPressed(KeyEvent event)
            //{
            //	withdrawalJTextField.setText("");	
            //}
            
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
      nameJTextField.setText( "Jacky Zou" );
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
      setSize( 340, 225 );               // set window's size
      setVisible( true );                // display window

   } // end method createUserInterface

   // add previous balance to deposit and display result
   private void enterJButtonActionPerformed( ActionEvent event )
   {
	   
     double deposit ;//intÒ²¿ÉÒÔ
     double balance ;
     double withdraw ;
    
		  try
		  {
			  deposit = Double.parseDouble(depositJTextField.getText());
			  withdraw = Double.parseDouble(withdrawalJTextField.getText());
		  }
		  catch
		  (Exception e)
		  {
			  JOptionPane.showMessageDialog(null,"Please type in an appropriate number","INPUT ERRORS",
					  JOptionPane.ERROR_MESSAGE);
		  }
	 
		  
     deposit = Double.parseDouble(depositJTextField.getText());
     balance = Double.parseDouble(balanceJTextField.getText());
     withdraw = Double.parseDouble(withdrawalJTextField.getText());
     balance = deposit+balance-withdraw;
     
     balanceJTextField.setText(String.valueOf(balance));
     if(withdraw <= 500.0)
     {
    	 accountNumberJTextField.setText("ERROR");  
     }
     else
     {
    	 JOptionPane.showMessageDialog(null,"You cannot purchase over $500 one time","ERROR",
				  JOptionPane.INFORMATION_MESSAGE);
     }
     if(balance >= 0.0)
	  {
    	 accountNumberJTextField.setText("PROCESSING");  
    	 accountNumberJLabel.setText("Status");
		  
	  }
	  else
	  {
		  JOptionPane.showMessageDialog(null,"YOUR BALANCE CANNOT AFFORD IT","ERROR",
				  JOptionPane.ERROR_MESSAGE);
	  }
   } // end method enterJButtonActionPerformed

   // main method
   public static void main( String[] args ) 
   {
	
      AccountInformation application = new AccountInformation();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


	   

	   
   } // end method main

} // end class AccountInformation



/*
 To do control structure ,three broad topic. Highest java topic
 
 First, sequencial, write code ,do this then do this. STraight line
 
 
 Second, selection conditional logic(3type) not straight line
 1.if(single conditional) statement(conditional)
 2.if  else()  statement double(2not8byte) conditional
 3.switch -(many a lot too many)
 ¡ü
 can connect, do this, if true, while do this
 ¡ý

 Third,reputation logic(loops)
 1.while loop(while it is true,sequencely)(quiz question)
 2.do while loop(run once every time,do this then check)(ask if you wanna do)
 3.for loop(most java do this)(this has the ability to do 1and2,compat) 
 */

 


/**************************************************************************
  * MADE BY Jacky Zou*
  **************************************************************************/

/*

if (balance<=withdraw)
{
//perform action
}
else
{
//show JOptionPane, not enough balance
}
 

*/