// Exercise 2.16: Radio.java
// Creates the radio GUI.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Radio extends JFrame
{
   private JButton oneJButton, twoJButton, threeJButton, 
      fourJButton, fiveJButton, sixJButton, powerJButton;
   private JPanel tuningJPanel, speakersJPanel, presetJPanel, 
      volumeControlJPanel;
   private JRadioButton amJRadioButton, fmJRadioButton;
   private JTextField stationJTextField;
   private JCheckBox muteJCheckBox, frontJCheckBox, rearJCheckBox;
   private JSlider volumeJSlider;

   // no-argument constructor
   public Radio()
   {
      createUserInterface();
   }
   
   // create and position GUI components
   private void createUserInterface()
   {
      // get contentPane and set layout to null
      Container contentPane = getContentPane();
      contentPane.setBackground( Color.magenta );
      contentPane.setLayout( null );
      
      // set up presetJPanel
      presetJPanel = new JPanel();
      presetJPanel.setLayout( null );
      presetJPanel.setBorder( new TitledBorder( 
         "Pre-set Stations" ) );
      presetJPanel.setBounds( 10, 10, 355, 75 );
      presetJPanel.setBackground( Color.blue );
      contentPane.add( presetJPanel );
      
      // set up oneJButton
      oneJButton = new JButton();
      oneJButton.setBounds( 16, 22, 42, 42 );
      oneJButton.setText( "1" );
      oneJButton.setBackground( Color.CYAN );
      presetJPanel.add( oneJButton );
      
      // set up twoJButton
      twoJButton = new JButton();
      twoJButton.setBounds( 72, 22, 42, 42 );
      twoJButton.setText( "2" );
      twoJButton.setBackground( Color.ORANGE );
      presetJPanel.add( twoJButton );
      
      // set up threeJButton
      threeJButton = new JButton();
      threeJButton.setBounds( 128, 22, 42, 42 );
      threeJButton.setText( "3" );
      threeJButton.setBackground( Color.ORANGE );
      presetJPanel.add( threeJButton );
      
      // set up fourJButton
      fourJButton = new JButton();
      fourJButton.setBounds( 184, 22, 42, 42 );
      fourJButton.setText( "4" );
      fourJButton.setBackground( Color.ORANGE );
      presetJPanel.add( fourJButton );
      
      // set up fiveJButton
      fiveJButton = new JButton();
      fiveJButton.setBounds( 240, 22, 42, 42 );
      fiveJButton.setText( "5" );
      fiveJButton.setBackground( Color.green );
      presetJPanel.add( fiveJButton );
      
      // set up sixJButton
      sixJButton = new JButton();
      sixJButton.setBounds( 296, 22, 42, 42 );
      sixJButton.setText( "6" );
      sixJButton.setBackground( Color.YELLOW );
      presetJPanel.add( sixJButton );
      
      // set up volumeControlJPanel
      volumeControlJPanel = new JPanel();
      volumeControlJPanel.setLayout( null );
      volumeControlJPanel.setBorder( new TitledBorder( 
         "Volume Control" ) );
      volumeControlJPanel.setBounds( 10, 95, 250, 90 );
      volumeControlJPanel.setBackground( Color.PINK );
      contentPane.add( volumeControlJPanel );
      
      // set up muteJCheckBox
      muteJCheckBox = new JCheckBox();
      muteJCheckBox.setBounds( 16, 24, 60, 42 );
      muteJCheckBox.setText( "Mute" );
      muteJCheckBox.setBackground( Color.PINK );
      volumeControlJPanel.add( muteJCheckBox );
      
      // set up volumeJSlider
      volumeJSlider = new JSlider();
      volumeJSlider.setBounds( 86, 24, 150, 50 );
      volumeJSlider.setPaintTicks( true );
      volumeJSlider.setMajorTickSpacing( 10 );
      volumeJSlider.setBackground( Color.PINK );
      volumeControlJPanel.add( volumeJSlider );
      
      // set up speakersJPanel
      speakersJPanel = new JPanel();
      speakersJPanel.setLayout( null );
      speakersJPanel.setBorder( new TitledBorder( "Speakers" ) );
      speakersJPanel.setBounds( 375, 10, 182, 75 );
      speakersJPanel.setBackground( Color.PINK );
      contentPane.add( speakersJPanel );
      
      // set up frontJCheckBox
      frontJCheckBox = new JCheckBox();
      frontJCheckBox.setBounds( 16, 28, 70, 30 );
      frontJCheckBox.setText( "Front" );
      frontJCheckBox.setBackground( Color.ORANGE );
      speakersJPanel.add( frontJCheckBox );
      
      // set up rearJCheckBox
      rearJCheckBox = new JCheckBox();
      rearJCheckBox.setBounds( 96, 28, 70, 30 );
      rearJCheckBox.setText( "Rear" );
      rearJCheckBox.setBackground( Color.ORANGE );
      speakersJPanel.add( rearJCheckBox );
      
      // set up tuningJPanel
      tuningJPanel = new JPanel();
      tuningJPanel.setLayout( null );
      tuningJPanel.setBorder( new TitledBorder( "Tuning" ) );
      tuningJPanel.setBounds( 270, 95, 166, 90 );
      tuningJPanel.setBackground( Color.PINK );
      contentPane.add( tuningJPanel );
      
      // set up stationJTextField
      stationJTextField = new JTextField();
      stationJTextField.setBounds( 16, 20, 50, 55 );
      stationJTextField.setText( "92.9" );
      stationJTextField.setEditable( false );
      stationJTextField.setHorizontalAlignment( JLabel.CENTER );
      stationJTextField.setBackground( Color.ORANGE );
      tuningJPanel.add( stationJTextField );
      
      // set up amJRadioButton
      amJRadioButton = new JRadioButton();
      amJRadioButton.setBounds( 80, 20, 70, 25 );
      amJRadioButton.setText( "AM" );
      amJRadioButton.setBackground( Color.ORANGE );
      tuningJPanel.add( amJRadioButton );
      
      // set up fmJRadioButton
      fmJRadioButton = new JRadioButton();
      fmJRadioButton.setBounds( 80, 50, 70, 25 );
      fmJRadioButton.setText( "FM" );
      fmJRadioButton.setBackground( Color.ORANGE );
      tuningJPanel.add( fmJRadioButton );
      
      // set up powerJButton
      powerJButton = new JButton();
      powerJButton.setBounds( 446, 95, 111, 90 );
      powerJButton.setText( "Power On/Off" );
      powerJButton.setBackground( Color.PINK );
      contentPane.add( powerJButton );
      
  
      
      // set properties of application's window
      setTitle( "Radio" ); // set title bar text
      setSize( 575, 220 ); // set window size
      setVisible( true );  // display window

   } // end method createUserInterface
   
   // main method
   public static void main( String[] args ) 
   {
      Radio application = new Radio();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Radio

