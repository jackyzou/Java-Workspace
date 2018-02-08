import java.awt.*;//Abstract Windowing Toolkit=AWT
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Inventory extends JFrame
{
   // JLabel and JTextField for cartons per shipment
   private JLabel cartonsJLabel;
   private JTextField cartonsJTextField;

   // JLabel and JTextField for items per carton
   private JLabel itemsJLabel;
   private JTextField itemsJTextField;
   
   private JLabel shipmentJLabel;
   private JTextField shipmentJTextField;

   // JLabel and JTextField for total items per shipment
   private JLabel totalJLabel;
   private JTextField totalResultJTextField;
   
  
   // JButton to initiate calculation of total items per shipment
   private JButton calculateJButton;
   
   private JButton clearJButton;
   
   private JPanel sliderJPanel;
   private JSlider myJSlider;
   private JButton myExitJButton;

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
   
   // no-argument constructor
   public Inventory()
   {
      createUserInterface();
   }

   // create and position GUI components; register event handlers
   public void createUserInterface()//public:red word is key word, void:return type(do not sent back a value) method is an action
   {
      // get content pane and set layout to null
      Container contentPane = getContentPane();
      contentPane.setBackground(Color.cyan);
      contentPane.setLayout( null ); 

      // set up cartonsJLabel
      cartonsJLabel = new JLabel();
      cartonsJLabel.setText("Cartons per shipment:");
      cartonsJLabel.setBounds(16,20,130,21);
      cartonsJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,13));
      contentPane.add( cartonsJLabel );
      
      // set up cartonsJTextField
      cartonsJTextField = new JTextField();
      cartonsJTextField.setText("0");
      cartonsJTextField.setBounds(148,16,40,21);
      cartonsJTextField.setHorizontalAlignment(JTextField.RIGHT);
      contentPane.add( cartonsJTextField );
      cartonsJTextField.addKeyListener(
    		  
    		  new KeyAdapter()
    		  {
    			  public void keyPressed( KeyEvent event)
    			  {
    				  cartonsJTextFieldKeyPressed( event );
    			  }
    		  }
    		  
    		  );

      // set up itemsJLabel
      itemsJLabel = new JLabel();
      itemsJLabel.setText("Items per carton:");
      itemsJLabel.setBounds(16,48,104,21);
      itemsJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,13));
      contentPane.add( itemsJLabel );
 
      // set up itemsJTextField
      itemsJTextField = new JTextField();
      itemsJTextField.setText("0");
      itemsJTextField.setBounds(148,48,40,21);
      itemsJTextField.setHorizontalAlignment(JTextField.RIGHT);
      contentPane.add( itemsJTextField );
      itemsJTextField.addKeyListener(
    		  
    		  new KeyAdapter()
    		  {
    			  public void keyPressed( KeyEvent event)
    			  {
    				  itemsJTextFieldKeyPressed( event );
    			  }
    		  }
    		  
    		  );
      
      shipmentJLabel = new JLabel();
      shipmentJLabel.setText("Shipment this week:");
      shipmentJLabel.setBounds(16,80,110,30);
      shipmentJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,12));
      contentPane.add( shipmentJLabel );
 
      // set up itemsJTextField
      shipmentJTextField = new JTextField();
      shipmentJTextField.setText("0");
      shipmentJTextField.setBounds(148,80,50,21);
      shipmentJTextField.setHorizontalAlignment(JTextField.RIGHT);
      contentPane.add( shipmentJTextField );
      shipmentJTextField.addKeyListener(
    		  
    		  new KeyAdapter()
    		  {
    			  public void keyPressed( KeyEvent event)
    			  {
    				  shipmentJTextFieldKeyPressed( event );
    			  }
    		  }
    		  
    		  );
      
    //  sliderJPanel = new JPanel();
      //sliderJPanel.setLayout( null );
      //sliderJPanel.setBorder( new TitledBorder( "Background Control" ) );
      //sliderJPanel.setBounds( 200, 75, 250, 50 );
      //sliderJPanel.setBackground( Color.PINK );
      //contentPane.add( sliderJPanel );
      
      
      myJSlider = new JSlider();
      myJSlider.setBounds( 200, 70, 150, 49 );
      myJSlider.setPaintTicks( true );
      myJSlider.setMajorTickSpacing( 10 );
      myJSlider.setBackground( Color.PINK );
      contentPane.add( myJSlider);
      myJSlider.addChangeListener(
		         
		         new ChangeListener() 
		         {
		            
		
					public void stateChanged(ChangeEvent arg0) {
						// TODO Auto-generated method stub
					 	int value = myJSlider.getValue();
	            	 	System.out.print("Value is : "+value);

					}
		         }
		         );
      
      
      // set up totalJLabel
      totalJLabel = new JLabel();
      totalJLabel.setText("Total:");
      totalJLabel.setBounds(204,16,40,21);
      contentPane.add( totalJLabel );


     
      // set up totalResultJTextField
      totalResultJTextField = new JTextField();
      totalResultJTextField.setBounds(244,16,86,21);
      totalResultJTextField.setHorizontalAlignment(JTextField.RIGHT);
      totalResultJTextField.setEditable(false);
      contentPane.add( totalResultJTextField );
     
      totalResultJTextField.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e)
          {
              playSound("b.wav");
              
 
                  JOptionPane.showMessageDialog(null,"DO NOT ENTER HERE","ERROR",JOptionPane.ERROR_MESSAGE);
              }
 
          }
          );
      

      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setText("Calculate Total");
      calculateJButton.setBounds(204,48,126,24);
      calculateJButton.setEnabled(false);
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(
    		  
    		  new ActionListener()
    		  {
    			  public void actionPerformed( ActionEvent event)
    			  {
    				  try
    				  {
    				  calculateJButtonActionPerformed( event );
    				  //cartonsJTextField.setText("");
    				  //itemsJTextField.setText("");
    				  playSound("click.wav");
    				  }
    				  catch
    				  (Exception e)
    	    		  {
    	    			  JOptionPane.showMessageDialog(null,"YOU STUPID","ERROR",
    	    					  JOptionPane.ERROR_MESSAGE);
    	    		  }
    			  }
    				  
    		  }
    		  
    			  
    		  );

      
  
      
      clearJButton = new JButton();
      clearJButton.setText("Clear");
      clearJButton.setBounds(350,16,126,24);
      contentPane.add( clearJButton );
      clearJButton.addActionListener(
      		   new ActionListener()
      		
     		  {
     			  public void actionPerformed( ActionEvent event)
     			  {
     				 
     				  {
     				  
     				  cartonsJTextField.setText("");
     				  itemsJTextField.setText("");
     				  shipmentJTextField.setText("");
     				  totalResultJTextField.setText("");
     				  calculateJButton.setEnabled(false);
     				 playSound("set.wav"); 
     				  }
     				 
     				
     	    		 
     			  }
     				  
     		  }
     		  
     			  
       		   );	 
      
      
      myExitJButton = new JButton();
      myExitJButton.setText("Exit");
      myExitJButton.setBounds(350,48,126,24);
      myExitJButton.setEnabled(true);
      contentPane.add( myExitJButton );
     
      
     
      
      // set properties of application� window
      setTitle( "Inventory" ); // set title bar text
      setSize( 500, 150 );     // set window size
      setVisible( true );      // display window

   } // end method createUserInterface

   private void calculateJButtonActionPerformed(ActionEvent event)
   {
	   int cartons;
	   int items;
	   int shipment;
	   int result;
	   
	   cartons = Integer.parseInt(cartonsJTextField.getText());
	   items = Integer.parseInt(itemsJTextField.getText());
	   shipment = Integer.parseInt(shipmentJTextField.getText());
	   result = cartons*items*shipment;
	   
	   totalResultJTextField.setText(String.valueOf(result));
   }
   private void cartonsJTextFieldKeyPressed(KeyEvent event)
   {
	   totalResultJTextField.setText("");
	   calculateJButton.setEnabled(true);
	   
   }
   private void itemsJTextFieldKeyPressed(KeyEvent event)
   {
	   totalResultJTextField.setText("");
	   calculateJButton.setEnabled(true);
   }
   private void shipmentJTextFieldKeyPressed(KeyEvent event)
   {
	   totalResultJTextField.setText("");
	   calculateJButton.setEnabled(true);
   }
   
   
   
   
   // main method
   public static void main( String[] args )
   {
	   Inventory application = new Inventory();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

}