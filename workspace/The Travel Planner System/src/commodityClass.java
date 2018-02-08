import java.awt.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;

public class commodityClass extends JFrame
{
   // JLabel and JTextField to input dollar amount
   private JLabel dollarJLabel;
   private JTextField dollarJTextField;
   
   // JLabel and JTextField to input currency type to convert to
   private JLabel typeJLabel;
   private JTextField typeJTextField;
   
   // JLabel and JTextField to display converted value
   private JLabel convertedJLabel;
   private JTextField convertedJTextField;
   
   // JButton to initiate conversion
   private JButton convertJButton;
   
   private Investment invest;
   
   // no-argument constructor
   public commodityClass()
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
      
      // set up dollarJLabel
      dollarJLabel = new JLabel();
      dollarJLabel.setBounds( 16, 16, 158, 21 );
      dollarJLabel.setText( "Currency amount:($)" );
      contentPane.add( dollarJLabel );
            
      // set up dollarJTextField
      dollarJTextField = new JTextField();
      dollarJTextField.setBounds( 175, 16, 96, 21 );
      dollarJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( dollarJTextField );
      dollarJTextField.addKeyListener(

    	         new KeyAdapter() // anonymous inner class
    	         {
    	            // event handler called when key pressed in 
    	            // accountNumberJTextField
    	            public void keyPressed( KeyEvent event )
    	            {
    	            	dollarJTextFieldKeyPressed( event );
    	            }

					private void dollarJTextFieldKeyPressed(KeyEvent event) {
						// TODO Auto-generated method stub
						convertedJTextField.setText("");
					}

    	         } // end anonymous inner class

    	      ); // end call to addKeyListener
    	            
      
      // set up typeJLabel
      typeJLabel = new JLabel();
      typeJLabel.setBounds( 16, 56, 155, 21 );
      typeJLabel.setText( "Which sort:" );
      contentPane.add( typeJLabel );
      
      // set up typeJTextField
      typeJTextField = new JTextField();
      typeJTextField.setBounds( 175, 56, 96, 21 );
      typeJTextField.setEditable(false);
      typeJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( typeJTextField );
      typeJTextField.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
        	  Object[] obj2 ={  "Gold" ,"Silver","Platinum","Oil"};  
    	      String s = (String) JOptionPane.showInputDialog(null,"Select the other currency:\n", "Select One", 
    	    		  JOptionPane.PLAIN_MESSAGE, null, obj2, ""); 

    	      typeJTextField.setText(String.valueOf(s));
    	      convertedJTextField.setText("");
          }
          });   
  
      // set up convertedJLabel
      convertedJLabel = new JLabel();
      convertedJLabel.setBounds( 16, 96, 130, 24 );
      convertedJLabel.setText( "Commodity(unit):" );
      contentPane.add( convertedJLabel );

      // set up convertedJTextField
      convertedJTextField = new JTextField();
      convertedJTextField.setBounds( 155, 96, 116, 21 );
      convertedJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      convertedJTextField.setEditable( false );
      contentPane.add( convertedJTextField );
      
      // set up convertJButton and register its event handler
      convertJButton = new JButton();
      convertJButton.setText( "Exchange" );
      convertJButton.setBounds( 175, 136, 96, 24 );
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
      setTitle( "Currency Converter" ); // set title bar text
      setSize( 300, 200 );              // set window size
      setVisible( true );               // display window
      
   } // end method createUserInterface
   
   // this method is called when the user clicks convertJButton

   private void convertJButtonActionPerformed( ActionEvent event )
   {
     try
     {
	   double dollar = Double.parseDouble(dollarJTextField.getText());
	
	
	   double moneyafter=0.00;
       String s = typeJTextField.getText() ;
	      
      
	       if(s.equals("Gold"))     
	      {
	    	invest = new Investment();
	    	invest.changePic("G");
	      	moneyafter= dollar/(1646);//the rate dollar to Yen is 1:83.515
	      	convertedJTextField.setText(String.valueOf(moneyafter)+" ounce");
	      	 System.out.println(moneyafter);
	      	 
	      	 DecimalFormat dollars = new DecimalFormat("0.000"+" ounce");
		      convertedJTextField.setText(String.valueOf(dollars.format( moneyafter))); 
	      }
	      else if(s.equals("Silver"))     
	      {
	    	  invest = new Investment();
		    	invest.changePic("S");
	      	moneyafter= dollar/(30.87);//the rate dollar to Pesos is 1:12.7495
	      	convertedJTextField.setText(String.valueOf(moneyafter)+" ounce");
	      	 System.out.println(moneyafter);
	      	 
	      	 DecimalFormat dollars = new DecimalFormat("0.000"+" ounce");
		      convertedJTextField.setText(String.valueOf(dollars.format( moneyafter))); 
	      }      
	      else if(s.equals("Platinum"))
		      {
	    	  invest = new Investment();
		    	invest.changePic("P");
	    	  
	    	  
		      	moneyafter= dollar/(1693);//the rate dollar to Euros is 1:0.7579
		     
		      	convertedJTextField.setText(String.valueOf(moneyafter)+" ounce");
		    	 System.out.println(moneyafter);
		    	 
		    	 DecimalFormat dollars = new DecimalFormat("0.000"+" ounce");
			      convertedJTextField.setText(String.valueOf(dollars.format( moneyafter))); 
		      }
	      else if(s.equals("Oil"))
	      {
	    	  invest = new Investment();
		    	invest.changePic("O");
	    	  
	      	moneyafter= dollar/(95);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter) + " barrel");
	    	 System.out.println(moneyafter);
	    	 DecimalFormat dollars = new DecimalFormat("0.000" + " barrel");
		      convertedJTextField.setText(String.valueOf(dollars.format( moneyafter))); 
	      }
	       
	      
     }
     catch(Exception b)
	   {
		   JOptionPane.showMessageDialog(null,"Rational Numbers please","ERROR",
					  JOptionPane.ERROR_MESSAGE);  
	   }
	     
      
   } // end method convertJButtonActionPerformed
   
   // main method
   
} // end class CurrencyConverter
