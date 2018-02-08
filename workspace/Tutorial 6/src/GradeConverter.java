// Exercise 6.16: GradeConverter.java// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// It is Jacky Zou's project,don't steal it
// Input a numeric grade from the user and 
// display the corresponding letter grade.
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GradeConverter extends JFrame 
{
   // JLabel and JTextField for numeric grade
   private JLabel numberGradeJLabel;
   private JTextField numberGradeJTextField;

   // JLabel and JTextField for equivalent letter grade
   private JLabel letterGradeJLabel;
   private JTextField letterGradeJTextField;
   
   // JButton to initiate conversion
   private JButton convertJButton;
   
   // no-argument constructor
   public GradeConverter()
   {
      createUserInterface();
   }   
   
   // create and position GUI components; register event handlers
   public void createUserInterface()
   {
      // get content pane and set its layout to null
      Container contentPane = getContentPane();
      contentPane.setLayout( null );
      
      // set up numberGradeJLabel
      numberGradeJLabel = new JLabel();
      numberGradeJLabel.setBounds( 16, 16, 130, 20 );
      numberGradeJLabel.setText( "Enter grade (0-100):" );
      contentPane.add( numberGradeJLabel );
      
      // set up numberGradeJTextField
      numberGradeJTextField = new JTextField();
      numberGradeJTextField.setBounds( 140, 16, 32, 20 );
      numberGradeJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      contentPane.add( numberGradeJTextField );
      numberGradeJTextField.addKeyListener(

 	         new KeyAdapter() // anonymous inner class
 	         {
 	            // event handler called when key pressed in 
 	            // accountNumberJTextField
 	            public void keyPressed( KeyEvent event )
 	            {
 	            	numberGradeJTextFieldPressed( event );
 	            }

					private void numberGradeJTextFieldPressed(KeyEvent event) {
						// TODO Auto-generated method stub
						letterGradeJTextField.setText("");
					}

 	         } // end anonymous inner class

 	      ); // end call to addKeyListener
 	     
      
      // set up letterGradeJLabel
      letterGradeJLabel = new JLabel();
      letterGradeJLabel.setBounds( 16, 56, 130, 20);
      letterGradeJLabel.setText( "Letter grade:" );
      contentPane.add( letterGradeJLabel );
      
      // set up letterGradeJTextField
      letterGradeJTextField = new JTextField();
      letterGradeJTextField.setBounds( 140, 56, 32, 20 );
      letterGradeJTextField.setHorizontalAlignment( 
         JTextField.CENTER );
      letterGradeJTextField.setEditable( false );
      contentPane.add( letterGradeJTextField );
      
      // set up convertJButton and register its event handler
      convertJButton = new JButton();
      convertJButton.setBounds( 57, 96, 90, 24 );
      convertJButton.setText( "Convert" );
      contentPane.add( convertJButton );
      convertJButton.addActionListener(
         
         new ActionListener() // anonymous inner class
         {
             // event handler called when convertJButton is pressed
             public void actionPerformed ( ActionEvent event )
             {
                convertJButtonActionPerformed( event );
             }

         } // end anonymous inner class

      ); // end call to addActionListener
            
      // set properties of application's window
      setTitle( "Grade Converter" );  // set title bar text
      setSize( 195, 165 );            // set window size
      setVisible( true );             // display window
      
   } // end method createUserInterface
   
   // method called when user clicks convertJButton
   public void convertJButtonActionPerformed( ActionEvent event )
   {
     try
     {
	   int grade = Integer.parseInt(numberGradeJTextField.getText() );
    if(grade<=100 && grade>=0)
    {
      if ( grade >= 90 )
      {
         letterGradeJTextField.setText( "A" );
      }
      else if ( grade >= 80 )
      {
         letterGradeJTextField.setText( "B" );
      }
      else if ( grade >= 70 )
      {
         letterGradeJTextField.setText( "C" );
      }
      else if ( grade >= 60 )
      {
         letterGradeJTextField.setText( "D" );
      }
      else
      {
         letterGradeJTextField.setText( "F" );
      }
    }
    else
    {
    	  JOptionPane.showMessageDialog(null,"Please type in a number that between 0 and 100 ","ERROR",
				  JOptionPane.ERROR_MESSAGE);  

    }
     }
     catch(Exception b)
	   {
		   JOptionPane.showMessageDialog(null,"Positive Rational Numbers please","ERROR",
					  JOptionPane.ERROR_MESSAGE);  
	   }
      
   } // end method convertJButtonActionPerformed
   
   // main method
   public static void main( String[] args )
   {
      GradeConverter application = new GradeConverter();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class GradeConverter


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
