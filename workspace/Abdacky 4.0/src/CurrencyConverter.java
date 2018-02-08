import java.awt.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;

public class CurrencyConverter extends JFrame
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
   
   // no-argument constructor
   public CurrencyConverter()
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
      dollarJLabel.setBounds( 16, 16, 128, 21 );
      dollarJLabel.setText( "Dollars to convert:" );
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
      typeJLabel.setText( "Convert dollars to(click):" );
      contentPane.add( typeJLabel );
      
      // set up typeJTextField
      typeJTextField = new JTextField();
      typeJTextField.setBounds( 175, 56, 96, 21 );
      typeJTextField.setHorizontalAlignment( JTextField.RIGHT );
      contentPane.add( typeJTextField );
      typeJTextField.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
        	  Object[] obj2 ={  "Yen" ,"Pesos","Euros","RMB","HKD","AUD","CAD","GBP","THB","KRW","CHF","BRL","ZAR"};  
    	      String s = (String) JOptionPane.showInputDialog(null,"Select the other currency:\n", "Select Currency", JOptionPane.PLAIN_MESSAGE, null, obj2, ""); 

    	      typeJTextField.setText(String.valueOf(s));
    	      convertedJTextField.setText("");
          }
          });   
  
      // set up convertedJLabel
      convertedJLabel = new JLabel();
      convertedJLabel.setBounds( 16, 96, 130, 24 );
      convertedJLabel.setText( "Converted amount:" );
      contentPane.add( convertedJLabel );

      // set up convertedJTextField
      convertedJTextField = new JTextField();
      convertedJTextField.setBounds( 175, 96, 96, 21 );
      convertedJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      convertedJTextField.setEditable( false );
      contentPane.add( convertedJTextField );
      
      // set up convertJButton and register its event handler
      convertJButton = new JButton();
      convertJButton.setText( "Convert" );
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
	      
      
	       if(s.equals("Yen"))     
	      {
	      	moneyafter= dollar*(16703/200);//the rate dollar to Yen is 1:83.515
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	      	 System.out.println(moneyafter);
	      }
	      else if(s.equals("Pesos"))     
	      {
	      	moneyafter= dollar*(51/4);//the rate dollar to Pesos is 1:12.7495
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	      	 System.out.println(moneyafter);
	      }      
	      else if(s.equals("Euros"))
		      {
		      	moneyafter= dollar*(8/10);//the rate dollar to Euros is 1:0.7579
		     
		      	convertedJTextField.setText(String.valueOf(moneyafter));
		    	 System.out.println(moneyafter);
		      }
	      else if(s.equals("RMB"))
	      {
	      	moneyafter= dollar*(25/4);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	    	 System.out.println(moneyafter);
	      }
	      else if(s.equals("HKD"))
	      {
	      	moneyafter= dollar*(31/4);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	    	 System.out.println(moneyafter);
	      }
	      else if(s.equals("AUD"))
	      {
	      	moneyafter= dollar*(16/16);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	    	 System.out.println(moneyafter);
	      }
	      else if(s.equals("CAD"))
	      {
	      	moneyafter= dollar*(100/99);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	    	 System.out.println(moneyafter);
	      } 
	      else if(s.equals("GBP"))
	      {
	      	moneyafter= dollar*(7/11);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	    	 System.out.println(moneyafter);
	      } 
	      else if(s.equals("THB"))
	      {
	      	moneyafter= dollar*(2972/99);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	    	 System.out.println(moneyafter);
	      } 
	      else if(s.equals("KRW"))
	      {
	      	moneyafter= dollar*(1096/1);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	    	 System.out.println(moneyafter);
	      } 
	      else if(s.equals("CHF"))
	      {
	      	moneyafter= dollar*(91/100);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	    	 System.out.println(moneyafter);
	      } 
	      else if(s.equals("BRL"))
	      {
	      	moneyafter= dollar*(197/100);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	    	 System.out.println(moneyafter);
	      } 
	      else if(s.equals("ZAR"))
	      {
	      	moneyafter= dollar*(889/100);
	     
	      	convertedJTextField.setText(String.valueOf(moneyafter));
	    	 System.out.println(moneyafter);
	      } 
	       DecimalFormat dollars = new DecimalFormat("$0.00");
	      convertedJTextField.setText(String.valueOf(dollars.format( moneyafter))); 
     }
     catch(Exception b)
	   {
		   JOptionPane.showMessageDialog(null,"Rational Numbers please","ERROR",
					  JOptionPane.ERROR_MESSAGE);  
	   }
	     
      
   } // end method convertJButtonActionPerformed
   
   // main method
   
} // end class CurrencyConverter
