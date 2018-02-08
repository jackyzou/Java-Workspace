// Exercise 7.16: SiblingSurvey.java


// This application gives the user three options regarding their
// siblings and displays the results in a pop up box.
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SiblingSurvey extends JFrame
{
   // JLabel that displays prompt
   private JLabel selectSiblingsJLabel;

   // JCheckBoxes for user options
   private JCheckBox brotherJCheckBox;
   private JCheckBox sisterJCheckBox;
   private JCheckBox noSiblingsJCheckBox;

   // JButton for user to submit input
   private JButton submitSurveyJButton;
   
   // no-argument constructor
   public SiblingSurvey()
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
      
      // set up selectSiblingsJLabel
      selectSiblingsJLabel = new JLabel();
      selectSiblingsJLabel.setText(
         "Please select the siblings you have:" );
      selectSiblingsJLabel.setBounds( 12, 16, 224, 23 );
      contentPane.add( selectSiblingsJLabel );

      // set up brotherJCheckBox
      brotherJCheckBox = new JCheckBox();
      brotherJCheckBox.setText( "Brother(s)" );
      brotherJCheckBox.setBounds( 16, 56, 108, 21 );
      contentPane.add( brotherJCheckBox );
      
      // set up sisterJCheckBox
      sisterJCheckBox = new JCheckBox();
      sisterJCheckBox.setText( "Sister(s)" );
      sisterJCheckBox.setBounds( 16, 96, 88, 21 );
      contentPane.add( sisterJCheckBox );
      
      // set up noSiblingsJCheckBox
      noSiblingsJCheckBox = new JCheckBox();
      noSiblingsJCheckBox.setText( "No Siblings" );
      noSiblingsJCheckBox.setBounds( 16, 136, 108, 21 );
      contentPane.add( noSiblingsJCheckBox );
      
      // set up submitSurveyJButton  
      submitSurveyJButton = new JButton();
      submitSurveyJButton.setText( "Submit Survey" );
      submitSurveyJButton.setBounds( 56, 176, 116, 23 );
      contentPane.add( submitSurveyJButton );
      submitSurveyJButton.addActionListener( 
      
         new ActionListener() // anonymous inner class
         {
            // event handler called when submitSurveyJButton
            // is clicked
            public void actionPerformed( ActionEvent event )
            {
               submitSurveyJButtonActionPerformed( event );
            }
            
         } // end anonymous inner class
         
      ); // end call to addActionListener
      
      // set properties of application's window
      setTitle( "Sibling Survey" ); // set title bar string
      setSize( 236, 240 );          // set window size
      setVisible( true );           // display window
      
   } // end method createUserInterface
   
   // display message based on user selection
   public void submitSurveyJButtonActionPerformed(
      ActionEvent event )
   {
      // check if user selects brothers or sisters and no siblings
      if ( noSiblingsJCheckBox.isSelected() && 
         ( brotherJCheckBox.isSelected() && 
         sisterJCheckBox.isSelected() ) || noSiblingsJCheckBox.isSelected() && sisterJCheckBox.isSelected() 
         ||noSiblingsJCheckBox.isSelected() && brotherJCheckBox.isSelected())
      {
         JOptionPane.showMessageDialog( null, 
            "Selected combination is not possible.",
            "Invalid Input", JOptionPane.WARNING_MESSAGE );
      }
      
    
      else if ( !noSiblingsJCheckBox.isSelected() && 
         !brotherJCheckBox.isSelected() && 
         !sisterJCheckBox.isSelected() )
      {
         // if user has not selected a JCheckBox
         JOptionPane.showMessageDialog( null, 
            "Please select at least one option.", "Invalid Input",
            JOptionPane.WARNING_MESSAGE );
      }
      else if ( brotherJCheckBox.isSelected() && 
         sisterJCheckBox.isSelected() )
      {
         // if user has brothers and sisters
         JOptionPane.showMessageDialog( null, 
            "You have at least one brother and one sister.",
            "Siblings", JOptionPane.INFORMATION_MESSAGE );
      }
      else if ( brotherJCheckBox.isSelected() &&  !noSiblingsJCheckBox.isSelected())
      {
         // if user has brothers
         JOptionPane.showMessageDialog( null, 
            "You have at least one brother.", "Siblings",
            JOptionPane.INFORMATION_MESSAGE );
      }
      else if ( sisterJCheckBox.isSelected() && !noSiblingsJCheckBox.isSelected())
      {
         // if user has sisters
         JOptionPane.showMessageDialog( null, 
            "You have at least one sister.", "Siblings",
            JOptionPane.INFORMATION_MESSAGE );
      }
      else // user has no siblings
      {
         JOptionPane.showMessageDialog( null,
            "You have no siblings.", "Siblings",
            JOptionPane.INFORMATION_MESSAGE );
      }

   } // end method submitSurveyJButtonActionPerformed 
   
   // main method
   public static void main( String[] args )
   {
      SiblingSurvey application = new SiblingSurvey();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
   
} // end class SiblingSurvey

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
