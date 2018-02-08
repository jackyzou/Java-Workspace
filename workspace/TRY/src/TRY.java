// Tutorial 3: Inventory.java
// Calculates the number of items in a shipment based on the number 
// of cartons received and the number of items per carton.
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class TRY extends JFrame
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
   private JButton musicJButton;
   private JButton aJButton;

   //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
   public void playSound(String soundName)
   {
     try 
     {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
      Clip clip = AudioSystem.getClip( );
      clip.open(audioInputStream);
      clip.start( );
     }
     catch(Exception ex)
     {
       System.out.println("Error with playing sound.");
       ex.printStackTrace( );
     }
   }
   //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
   
   // no-argument constructor
   public TRY()
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
      cartonsJLabel.setText("Gartons per Shipment:");
      cartonsJLabel.setBounds(12, 10, 150, 30);
      contentPane.add( cartonsJLabel );
     

      // set up itemsJLabel
      itemsJLabel = new JLabel("Items per Gallon:");
      itemsJLabel.setBounds( 12, 105,150, 30);
      contentPane.add( itemsJLabel );

      // set up totalJLabel
      totalJLabel = new JLabel("Total:");
      totalJLabel.setBounds(310, 0, 300, 40);
      contentPane.add( totalJLabel );

      // set up cartonsJTextField
      cartonsJTextField = new JTextField();
      cartonsJTextField.setBounds(165, 15, 50, 20);
      contentPane.add( cartonsJTextField );

      // set up itemsJTextField
      itemsJTextField = new JTextField();
      itemsJTextField.setBounds(165, 110, 50, 20);
      contentPane.add( itemsJTextField );
 //     itemsJTextField.addKeyListener(
 //   	   
 //   	   new KeyAdapter()
 //   	   {
   // 	   public void keyPressed(KeyEvent event)
 //   	   {
  //  	   totalResultJTextField.setText("");
  //  	   
   // 	   cartonsJTextField.setText("");
  //  	   }
  //  	   }
   // 	   
   // 	   );

      // set up totalResultJTextField
      totalResultJTextField = new JTextField();
      totalResultJTextField.setBounds(350, 10, 60, 20);
      contentPane.add( totalResultJTextField );

      // set up clear button
      clearJButton = new JButton();
      clearJButton.setText("Clear");
      clearJButton.setBounds(300, 80, 200, 20);
      contentPane.add( clearJButton );
      clearJButton.addActionListener(
    	   
    	   new ActionListener()
    	   {
    	   public void actionPerformed(ActionEvent event)
    	   {
    	   
    	   playSound("set.wav");  
    	    totalResultJTextField.setText("");
    	    itemsJTextField.setText("");
    	    cartonsJTextField.setText("");
    	   
    	   
    	       }
    	   
    	   }
    	   
    	   
    	   
    	   );
      //------------------------------
      totalResultJTextField.addMouseListener(new MouseAdapter(){
    	  public void mouseClicked(MouseEvent e)
  {
    	   playSound("b.wav");

  JOptionPane.showMessageDialog(null,"DO NOT ENTER HERE","ERROR",
  
  JOptionPane.ERROR_MESSAGE);
  }

    	  }
    	  );
      
      //------------------------------
      cartonsJTextField.addMouseListener(new MouseAdapter(){
    	  public void mouseClicked(MouseEvent e){
    	   totalResultJTextField.setText("");

    	  }
    	  });
      

      
      
      //------------------------------
      itemsJTextField.addMouseListener(new MouseAdapter(){
    	  public void mouseClicked(MouseEvent e){
    	   totalResultJTextField.setText("");

    	  }
    	  });
      
      //+++++++++++++++++++++++++++++++++++++++++++++++++
   // set up clear button
      musicJButton = new JButton();
      musicJButton.setText("Music (Can't be stopped)");
      musicJButton.setBounds(200, 250, 200, 20);
      contentPane.add( musicJButton );
      musicJButton.addActionListener(
    	   
    	   new ActionListener()
    	   {
    	   public void actionPerformed(ActionEvent event)
    	   {
    	   playSound("abc.wav");
    	       }
    	   
    	   }
    	   
    	   
    	   
    	   );
      //+++++++++++++++++++++++++++++++++++++++++++++++++
   // set up clear button
      aJButton = new JButton();
      aJButton.setText("Help");
      aJButton.setBounds(300, 50, 200, 20);
      contentPane.add( aJButton );
      aJButton.addActionListener(
    	   
    	   new ActionListener()
    	   {
    	   public void actionPerformed(ActionEvent event)
    	   {
    	   
    	   playSound("a.wav");
    	   JOptionPane.showMessageDialog(null,"Please enter the numbers you wish to enter, and press calculate total.");
    	   
    	   

    	       }
    	   
    	   }
    	   
    	   
    	   
    	   );
      
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setText("Calculate total");
      calculateJButton.setBounds(300, 110, 200, 20);
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(
    	   
    	   new ActionListener()
    	   {
    	   public void actionPerformed(ActionEvent event)
    	   {
    	   try
    	   {
    	   totalResultJTextField.setText("");
    	   
    	   int items = Integer.parseInt(itemsJTextField.getText());
    	   
    	   int cartons = Integer.parseInt(cartonsJTextField.getText());
    	   
    	   totalResultJTextField.setText(String.valueOf(items*cartons));
                      
    	   playSound("click.wav");
    	   
    	   
    	   }//syntax error will pick it up before i start
    	   //syntax error- this code will not run there should be uppercase
    	   catch(Exception e)
    	   {
    	   playSound("b.wav");
    	   JOptionPane.showMessageDialog(null,"ERROR","ERROR",
    	   
    	   JOptionPane.ERROR_MESSAGE);
    	   totalResultJTextField.setText("");
    	    	    itemsJTextField.setText("");
    	    	    cartonsJTextField.setText("");
    	   }
    	   
    	   
    	   //logic error runs BUT NOT quite right
    	       }
    	   
    	   }
    	   
    	   );

      // set properties of application抯 window
      setTitle( "Inventory" ); // set title bar text
      setSize( 650, 500 );     // set window size
      setVisible( true );      // display window

   } // end method createUserInterface

   // main method
   public static void main( String[] args )
   {
      TRY application = new TRY();
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