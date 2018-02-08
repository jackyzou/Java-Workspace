
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

public class FactoringTree2 extends JFrame
{
   // JLabel and JTextField for entering number to encrypt
   private JLabel enterJLabel;
   private JTextField enterJTextField;

   // JLabel and JTextField for displaying encrypted number
   private JLabel storeJLabel;
   private JTextField storeJTextField;

   // JButton to initiate encryption
   private JButton resultJButton;

   // no-argument constructor
   public FactoringTree2()
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
      
      // set up enterJLabel
      enterJLabel = new JLabel();
      enterJLabel.setText( "Enter a rational number:" );
      enterJLabel.setBounds( 20, 20, 190, 20 );
      contentPane.add( enterJLabel );
      
      // set up enterJTextField
      enterJTextField = new JTextField();
      enterJTextField.setBounds( 180, 20, 50, 20 );
      contentPane.add( enterJTextField );
      enterJTextField.addKeyListener(

         new KeyAdapter() // anonymous inner class
         {
            // called when key pressed in enterJTextField
            public void keyPressed( KeyEvent event )
            {
               enterJTextFieldKeyPressed( event );
            }

         } // end anonymous inner class

      ); // end call to addKeyListener

      // set up encryptedJLabel
      storeJLabel = new JLabel();
      storeJLabel.setText( "The result product number:" );
      storeJLabel.setBounds( 20, 50, 190, 20 );
      contentPane.add( storeJLabel );      
      
      // set up encryptedJTextField
      storeJTextField = new JTextField();
      storeJTextField.setEditable( false );
      storeJTextField.setBounds( 180, 50, 120, 20);
      contentPane.add( storeJTextField );
      
      // set up encryptJButton
      resultJButton = new JButton ();
      resultJButton.setText( "Encrypt" );
      resultJButton.setBounds( 250, 20, 80, 20 );
      contentPane.add( resultJButton );      
      resultJButton.addActionListener(
    		  
    		  new ActionListener()
    		  {
    			  public void actionPerformed( ActionEvent event)
    			  {
    				  try
    				  {
    					  resultJButtonActionPerformed( event );
    				
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
            

            
      // set properties of application's window
      setTitle( "Factoring Tree" ); // set title bar text
      setSize( 350, 120 );             // set window size
      setVisible( true );              // display window
      
   } // end method createUserInterface
      
   // encrypt number input by user 
   private void resultJButtonActionPerformed ( ActionEvent event )
   {
	   int n = Integer.parseInt(enterJTextField.getText());

	int i = 2;
	
if(n == 1)//check 1 first
{
	System.out.println(n+"*"+ "1");
	storeJTextField.setText(n+"*"+ "1");
}
else if (n == 2)//check 2 second
{
	System.out.println(n+"*"+"2");//if the number is 1 or 2 don't even bother looking for anything
	storeJTextField.setText(n+"*"+"1");
}
else if (n ==3)
{
	System.out.println(n+"*"+"3");
	storeJTextField.setText(n+"*"+"1");
}
else//the number is three or more b/c I checked 1 and 2 already 	
{

//this takes care of 3 or more
while(i<n)

	{
		if(n % i == 0)
		
		{
			System.out.println(n+" "+"Not Prime");
			
			 int k;
			 for(k=3;k<=n/2;k+=2)
			 {
					storeJTextField.setText(n+"*"+"2");
			 }
			
				  
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			break;
		
		}
	
		else
		{
			
			i++;
		}
		
		if(i == n)
		{
		System.out.println(n+" "+"1");
		storeJTextField.setText(n+" "+"1");
		}
	
	
	}//end while loop

}//end main method
   }
// clear encryptedJTextField because the value is now invalid
   private void enterJTextFieldKeyPressed( KeyEvent event )
   {
	   storeJTextField.setText("");
	   
	   
   } // end method enterJTextFieldKeyPressed

   // main method
   public static void main( String[] args )
   {
	   FactoringTree2 application = new FactoringTree2();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class SimpleEncryption



