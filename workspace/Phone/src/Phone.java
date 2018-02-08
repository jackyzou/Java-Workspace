// Exercise 2.14: Phone.java
// Creates the cell phone GUI.
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Phone extends JFrame
{
   private JLabel displayJLabel;
   private JPanel numberJPanel;
   private JButton oneJButton, twoJButton, threeJButton, 
      fourJButton, fiveJButton, sixJButton, sevenJButton, 
      eightJButton, nineJButton, starJButton, zeroJButton, 
      poundJButton, talkJButton, endJButton;
   private JButton clickerJButton;
   private Container contentPane;
   private JLabel pictureJLabel;
   // no-argument constructor
   public Phone()
   {
      createUserInterface();
   }
   
   // create and position GUI components
   private void createUserInterface()
   {
      // get content pane and set its layout
      contentPane = getContentPane();
      contentPane.setLayout( null );
      
      // set up displayJLabel
      displayJLabel = new JLabel();
      displayJLabel.setText( "AT&T iPhone" );
      displayJLabel.setBounds( 10, 65, 170, 100 );
    
      displayJLabel.setHorizontalAlignment( JLabel.CENTER );
      displayJLabel.setBackground( Color.black );
      displayJLabel.setOpaque( false );
      contentPane.add( displayJLabel );
      
      
      pictureJLabel = new JLabel();

   
      pictureJLabel.setHorizontalAlignment( JLabel.CENTER);
      pictureJLabel.setSize(128,90);
      contentPane.add(pictureJLabel);clickerJButton =new JButton(new ImageIcon("pinguo-logo.gif"));
		clickerJButton.setBounds(13,15,170,100);
		contentPane.add(clickerJButton);
			
		clickerJButton.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						System.out.println("Do not trust piratical phones");
					 	
					 contentPane.setBackground(Color.magenta);
					}
				}
				
				
				
				
				
				);
      
      // set up talkJButton
      talkJButton = new JButton();
      
      talkJButton.setText( "TALK" );
      talkJButton.setBounds( 10, 120, 80, 30 );
      contentPane.add( talkJButton );
		
	

			
		talkJButton.addActionListener(
				
				new ActionListener()// 这个是发令者
				{
					public void actionPerformed(ActionEvent event)//new ActionListener()发完令，就由这个来工作
					{
					 	
					 contentPane.setBackground(Color.cyan);
					}
				}
				);
      
      // set up endJButton
      endJButton = new JButton();
      endJButton.setText( "END" );
      endJButton.setBounds( 100, 120, 80, 30 );
      contentPane.add( endJButton );
      
		endJButton.addActionListener(
				
				new ActionListener()// 这个是发令者
				{
					public void actionPerformed(ActionEvent event)//new ActionListener()发完令，就由这个来工作
					{
					 	
					 contentPane.setBackground(Color.pink);
					}
				}
				);
      
      // set up numberJPanel
      numberJPanel = new JPanel();
      numberJPanel.setBounds( 10, 160, 170, 145 );
      numberJPanel.setBorder( new LineBorder( Color.BLACK ) );
      numberJPanel.setLayout( null );
      contentPane.add( numberJPanel );
      
      // set up oneJButton
      oneJButton = new JButton();
      oneJButton.setText( "1" );
      oneJButton.setBounds( 5, 5, 50, 30 );
      numberJPanel.add( oneJButton );
      
      // set up twoJButton
      twoJButton = new JButton();
      twoJButton.setText( "2" );
      twoJButton.setBounds( 60, 5, 50, 30 );
      numberJPanel.add( twoJButton );
      
      // set up threeJButton
      threeJButton = new JButton();
      threeJButton.setText( "3" );
      threeJButton.setBounds( 115, 5, 50, 30 );
      numberJPanel.add( threeJButton );
      
      // set up fourJButton
      fourJButton = new JButton();
      fourJButton.setText( "4" );
      fourJButton.setBounds( 5, 40, 50, 30 );
      numberJPanel.add( fourJButton );
      
      // set up fiveJButton
      fiveJButton = new JButton();
      fiveJButton.setText( "5" );
      fiveJButton.setBounds( 60, 40, 50, 30 );
      numberJPanel.add( fiveJButton );
      
      // set up sixJButton
      sixJButton = new JButton();
      sixJButton.setText( "6" );
      sixJButton.setBounds( 115, 40, 50, 30 );
      numberJPanel.add( sixJButton );
      
      // set up sevenJButton
      sevenJButton = new JButton();
      sevenJButton.setText( "7" );
      sevenJButton.setBounds( 5, 75, 50, 30 );
      numberJPanel.add( sevenJButton );
      
      // set up eightJButton
      eightJButton = new JButton();
      eightJButton.setText( "8" );
      eightJButton.setBounds( 60, 75, 50, 30 );
      numberJPanel.add( eightJButton );
      
      // set up nineJButton
      nineJButton = new JButton();
      nineJButton.setText( "9" );
      nineJButton.setBounds( 115, 75, 50, 30 );
      numberJPanel.add( nineJButton );
      
      // set up starJButton
      starJButton = new JButton();
      starJButton.setText( "*" );
      starJButton.setBounds( 5, 110, 50, 30 );
      numberJPanel.add( starJButton );
      
      // set up zeroJButton
      zeroJButton = new JButton();
      zeroJButton.setText( "0" );
      zeroJButton.setBounds( 60, 110, 50, 30 );
      numberJPanel.add( zeroJButton );
      
      // set up poundJButton
      poundJButton = new JButton();
      poundJButton.setText( "#" );
      poundJButton.setBounds( 115, 110, 50, 30 );
      numberJPanel.add( poundJButton );
      
      // set properties of application's window
      setTitle( "Phone" ); // set title bar text
      setSize( 198, 345 ); // set window size
      setVisible( true );  // display window
      
   } // end method createUserInterface
   
   // main method
   public static void main( String[] args ) 
   {
      Phone application = new Phone();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Phone


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

