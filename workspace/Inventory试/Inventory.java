// Tutorial 3: Inventory.java
// Calculates the number of items in a shipment based on the number 
// of cartons received and the number of items per carton.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Inventory extends JFrame
{
   // JLabel and JTextField for cartons per shipment
   private JLabel cartonsJLabel;
   private JTextField cartonsJTextField;

   // JLabel and JTextField for items per carton
   private JLabel itemsJLabel;
   private JTextField itemsJTextField;
   
   // JLabel and JTextField for total items per shipment
   private JLabel totalJLabel;
   private JTextField totalResultJTextField;

   // JButton to initiate calculation of total items per shipment
   private JButton calculateJButton;

   // no-argument constructor
   public Inventory()
   {
      createUserInterface();
   }

   // create and position GUI components; register event handlers
   public void createUserInterface()
   {
      // get content pane and set layout to null
      Container contentPane = getContentPane();
      contentPane.setLayout( null ); 

      // set up cartonsJLabel
      cartonsJLabel = new JLabel();
      contentPane.add( cartonsJLabel );

      // set up itemsJLabel
      itemsJLabel = new JLabel();
      contentPane.add( itemsJLabel );

      // set up totalJLabel
      totalJLabel = new JLabel();
      contentPane.add( totalJLabel );

      // set up cartonsJTextField
      cartonsJTextField = new JTextField();
      contentPane.add( cartonsJTextField );

      // set up itemsJTextField
      itemsJTextField = new JTextField();
      contentPane.add( itemsJTextField );

      // set up totalResultJTextField
      totalResultJTextField = new JTextField();
      contentPane.add( totalResultJTextField );

      // set up calculateJButton
      calculateJButton = new JButton();
      contentPane.add( calculateJButton );

      // set properties of application’s window
      setTitle( "Inventory" ); // set title bar text
      setSize( 354, 112 );     // set window size
      setVisible( true );      // display window

   } // end method createUserInterface

   // main method
   public static void main( String[] args )
   {
      Inventory application = new Inventory();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Inventory


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
