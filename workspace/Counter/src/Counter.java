// Exercise 4.12: Counter.java
// This application displays a number which increments each time the
// Count JButton is pressed.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Counter extends JFrame
{
   // JTextField for displaying total count
   private JTextField countJTextField; 

   // JButton to initiate adding one to numeric value in JTextField
   private JButton countJButton;       
   
   // no-argument constructor
   public Counter() 
   {
      createUserInterface();
   }
   
   // create and position GUI components; register event handler
   private void createUserInterface()
   {
      // get content pane and set layout to null
      Container contentPane = getContentPane();
      contentPane.setLayout( null );
      
      // set up countJTextField
      countJTextField = new JTextField();
      countJTextField.setText("0");
      countJTextField.setBounds( 24, 24, 88, 21 );
      countJTextField.setEditable( false );
      countJTextField.setHorizontalAlignment(JTextField.CENTER);
      contentPane.add( countJTextField );
      
      // set up countJButton
      countJButton = new JButton();
      countJButton.setText("Count");
      countJButton.setBounds( 24, 64, 88, 24 );
      contentPane.add( countJButton );
      countJButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when countJButton is pressed
            public void actionPerformed( ActionEvent event )
            {
               countJButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      // set properties of application� window
      setTitle( "Counter" ); // set title bar text
      setSize( 144, 136 );   // set window size
      setVisible( true );    // display window

   } // end method createUserInterface

   // increment the count each time countJButton is pressed
   private void countJButtonActionPerformed( ActionEvent event )
   {
     int count;
     count = 1+Integer.parseInt(countJTextField.getText());
     countJTextField.setText(String.valueOf(count));
     
   } // end method countJButtonActionPerformed

   // main method
   public static void main( String[] args ) 
   {
      Counter application = new Counter();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Counter


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
