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
   
   private JButton clearJButton;

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
      cartonsJLabel.setText("Cartons per shipment:");
      cartonsJLabel.setBounds(16,20,130,21);
      cartonsJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,13));
      contentPane.add( cartonsJLabel );

      // set up itemsJLabel
      itemsJLabel = new JLabel();
      itemsJLabel.setText("Items per carton:");
      itemsJLabel.setBounds(16,48,104,21);
      itemsJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,13));
      contentPane.add( itemsJLabel );

      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setText("Total:");
      totalJLabel.setBounds(204,16,40,21);
      contentPane.add( totalJLabel );

      // set up cartonsJTextField
      cartonsJTextField = new JTextField();
      cartonsJTextField.setText("0");
      cartonsJTextField.setBounds(148,16,40,21);
      cartonsJTextField.setHorizontalAlignment(JTextField.RIGHT);
      contentPane.add( cartonsJTextField );

      // set up itemsJTextField
      itemsJTextField = new JTextField();
      itemsJTextField.setText("0");
      itemsJTextField.setBounds(148,48,40,21);
      itemsJTextField.setHorizontalAlignment(JTextField.RIGHT);
      contentPane.add( itemsJTextField );

      // set up totalResultJTextField
      totalResultJTextField = new JTextField();
      totalResultJTextField.setBounds(244,16,86,21);
      totalResultJTextField.setHorizontalAlignment(JTextField.RIGHT);
      totalResultJTextField.setEditable(false);
      contentPane.add( totalResultJTextField );

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setText("Calculate Total");
      calculateJButton.setBounds(204,48,126,24);
      contentPane.add( calculateJButton );

      // set properties of application� window
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
