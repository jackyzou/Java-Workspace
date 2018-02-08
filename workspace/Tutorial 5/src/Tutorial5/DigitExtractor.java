package Tutorial5;

// Exercise 5.17 DigitExtractor.java
// Application that separates a five-digit number into digits.
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DigitExtractor extends JFrame
{
   // JLabel and JTextField for user to input number
   private JLabel enterNumberJLabel;
   private JTextField enterNumberJTextField;

   // JLabel and JTextFields for displaying extracted digits
   private JLabel extractedDigitsJLabel;
   private JTextField firstNumberJTextField;
   private JTextField secondNumberJTextField;
   private JTextField thirdNumberJTextField;
   private JTextField fourthNumberJTextField;
   private JTextField fifthNumberJTextField;

   // JButton to initiate extraction of digits
   private JButton enterJButton;
   
   // no-argument constructor
   public DigitExtractor()
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
      
      // set up enterNumberJLabel
      enterNumberJLabel = new JLabel();
      enterNumberJLabel.setText( "Enter five-digit number:" );
      enterNumberJLabel.setBounds( 10, 10, 150, 24 );
      contentPane.add( enterNumberJLabel );

      // set up enterNumberJTextField
      enterNumberJTextField = new JTextField();
      enterNumberJTextField.setBounds( 160, 10, 110, 24 );
      contentPane.add( enterNumberJTextField );

      // set up extractedDigitsJLabel
      extractedDigitsJLabel = new JLabel();
      extractedDigitsJLabel.setText( "Extracted digits:" );
      extractedDigitsJLabel.setBounds( 10, 45, 150, 24 );
      contentPane.add( extractedDigitsJLabel );

      // set up firstNumberJTextField
      firstNumberJTextField = new JTextField();
      firstNumberJTextField.setEditable( false );
      firstNumberJTextField.setBounds( 160, 45, 25, 24 );
      firstNumberJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( firstNumberJTextField );

      // set up secondNumberJTextField
      secondNumberJTextField = new JTextField();
      secondNumberJTextField.setEditable( false );
      secondNumberJTextField.setBounds( 180, 45, 25, 24 );
      secondNumberJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( secondNumberJTextField );

      // set up thirdNumberJTextField
      thirdNumberJTextField = new JTextField();
      thirdNumberJTextField.setEditable( false );
      thirdNumberJTextField.setBounds( 200, 45, 25, 24 );
      thirdNumberJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( thirdNumberJTextField );

      // set up fourthNumberJTextField
      fourthNumberJTextField = new JTextField();
      fourthNumberJTextField.setEditable( false );
      fourthNumberJTextField.setBounds( 220, 45, 25, 24 );
      fourthNumberJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( fourthNumberJTextField );

      // set up fifthNumberJTextField
      fifthNumberJTextField = new JTextField();
      fifthNumberJTextField.setEditable( false );
      fifthNumberJTextField.setBounds( 240, 45, 25, 24 );
      fifthNumberJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( fifthNumberJTextField );

      // set up enterJButton 
      enterJButton = new JButton ();
      enterJButton.setText( "Enter" );
      enterJButton.setBounds( 280, 10, 70, 24 );
      enterJButton.addActionListener(
    		  
    		  new ActionListener()
    		  {
    			  public void actionPerformed( ActionEvent event)
    			  {
    				  try
    				  {
    					  enterJButtonActionPerformed( event );
    				
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
            

      
      contentPane.add( enterJButton );
      
      // set properties of application's window
      setTitle( "Digit Extractor" ); // set title bar text
      setSize( 370, 105 );           // set window size
      setVisible( true );            // display window
   
   } // end method createUserInterface
   
   // extract and display individual digits

   
   private void enterJButtonActionPerformed( ActionEvent event )
   { 
	   int number ;
	   number = Integer.parseInt(enterNumberJTextField.getText());
if (number<100000)
{
 
 
   fifthNumberJTextField.setText(String.valueOf(number%10));
   fourthNumberJTextField.setText(String.valueOf(number%100/10));
   thirdNumberJTextField.setText(String.valueOf(number%1000/100));
   secondNumberJTextField.setText(String.valueOf(number%10000/1000));
   firstNumberJTextField.setText(String.valueOf(number/10000));
	   
}
else
{
	 JOptionPane.showMessageDialog(null,"Type in an integer that Smaller than 100000 ","ERROR",
			  JOptionPane.ERROR_MESSAGE);
}
} // end method enterJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      DigitExtractor application = new DigitExtractor();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
  
} // end class DigitExtractor

