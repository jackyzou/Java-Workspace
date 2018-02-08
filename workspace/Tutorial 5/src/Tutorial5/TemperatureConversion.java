package Tutorial5;

 // Exercise 5.12 TemperatureConversion.java
// Application that converts a Celsius temperature to its equivalent
// Fahrenheit temperature.
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class TemperatureConversion extends JFrame
{
   // JLabel and JTextField for Celsius input
   private JLabel celsiusJLabel;
   private JTextField celsiusJTextField;

   // JLabel and JTextField for Fahrenheit output
   private JLabel fahrenheitJLabel;
   private JTextField fahrenheitJTextField;
   
   private JLabel  kelvinJLabel;
   private JTextField  kelvinJTextField;
   // JButton to initiate Celsius to Fahrenheit conversion
   private JButton convertJButton;
   private JButton convertJButton1;
   private JButton convertJButton2;
   
   private JMenu helpMenu;
   // no-argument constructor
   public TemperatureConversion()
   {
      createUserInterface();
   }
   
   // create and position GUI componments; register event handlers
   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      

      class help extends JDialog{
      	/**
		 * 
		 */

		JLabel titleLabel = new JLabel("Help");
      	JTextArea contentArea;
      	JButton closeButton;
      	Dimension dimension = new Dimension(300,250);
      	
      	JPanel titlePanel = new JPanel();
      	JPanel centerPanel = new JPanel();
      	JPanel downPanel = new JPanel();
		private Container menuBar;
		private JMenuItem helpItem;
      	
      	public  help(JFrame frame){
//      	
      		super(frame,true);
      		this.setTitle("HELP");
      		
      		this.setSize(dimension);
      		
      		init();
      		Dimension screenSize = this.getToolkit().getScreenSize();
//      		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      		this.setLocation((int)(screenSize.width-dimension.width)/2, 
      				(int)(screenSize.height-dimension.height)/2);
      		setVisible(true);
      		this.setResizable(true);
      		
      		
      	}

      	public void init(){
      		Container contentPane = this.getContentPane();
      		contentPane.setLayout(new BorderLayout());

    		menuBar.add(helpMenu);

    		helpMenu.add(helpItem);
      		titlePanel.add(titleLabel);
      		contentPane.add(titlePanel,BorderLayout.NORTH);
      		
      		String string = "1、Press Convert C to convert Celcius to other forms\n"+"2Press Convert F to convert fahrenheit to other forms\n"+
      					"3、Press Convert K to convert Kelvin to other forms\n"+"4、.....\n"
      					;
      		contentArea = new JTextArea();
      		contentArea.setSize(300, 180);
      		contentArea.setText(string);
      		contentArea.setEditable(false);
      		centerPanel.add(contentArea);
      		contentPane.add(centerPanel,BorderLayout.CENTER);
      		
      		closeButton = new JButton("Close");
      		downPanel.add(closeButton);
      		contentPane.add(downPanel,BorderLayout.SOUTH);
      		/*事件处理*/
      		closeButton.addActionListener(new ActionListener()
      		{
      			public void actionPerformed(ActionEvent ae){
//      				System.exit(0);	
      				dispose();
      			}
      		});
      	}
      /*	
      	public static void main(String args[]){
      		
      		new Help(new JFrame());
      	}
      */	
      }

      
      
      
      
      
      
      
      
      
      
      
      
      // set up celsiusJLabel
      celsiusJLabel = new JLabel();
      celsiusJLabel.setText( "Celsius temperature:" );
      celsiusJLabel.setBounds( 10, 10, 170, 24 );
      contentPane.add( celsiusJLabel );
      
      // set up celsiusJTextField
      celsiusJTextField = new JTextField();
      celsiusJTextField.setBounds( 180, 10, 100, 24 );
      contentPane.add( celsiusJTextField );
      celsiusJTextField.addKeyListener(
         
         new KeyAdapter() // anonymous inner class
         {
            // called when key pressed in celsiusJTextField
            public void keyPressed( KeyEvent event )
            {
               celsiusJTextFieldKeyPressed( event );
            }
            
         } // end anonymous inner class
      
      ); // end call to addKeyListener
            
      // set up fahrenheitJLabel
      fahrenheitJLabel = new JLabel();
      fahrenheitJLabel.setText( "Fahrenheit temperature:" );
      fahrenheitJLabel.setBounds( 10, 40, 170, 24 );
      contentPane.add( fahrenheitJLabel );
      
      // set up fahrenheitJTextField
      fahrenheitJTextField = new JTextField();
      fahrenheitJTextField.setEditable( true );
      fahrenheitJTextField.setBounds( 180, 40, 100, 24 );
      contentPane.add( fahrenheitJTextField );
      fahrenheitJTextField.addKeyListener(
    	         
    	         new KeyAdapter() // anonymous inner class
    	         {
    	            // called when key pressed in celsiusJTextField
    	            public void keyPressed( KeyEvent event )
    	            {
    	            	fahrenheitJTextFieldKeyPressed( event );
    	            }

    			
    	            
    	         } // end anonymous inner class
    	      
    	      ); // end call to addKeyListener
      
     
      kelvinJLabel = new JLabel();
      kelvinJLabel.setText( "Kelvin temperature:" );
      kelvinJLabel.setBounds( 10, 70, 170, 24 );
      contentPane.add(  kelvinJLabel);
      
      kelvinJTextField = new JTextField();
      kelvinJTextField.setBounds( 180, 70, 100, 24 );
      contentPane.add( kelvinJTextField );
      kelvinJTextField.addKeyListener(
    	         
    	         new KeyAdapter() // anonymous inner class
    	         {
    	            // called when key pressed in celsiusJTextField
    	            public void keyPressed( KeyEvent event )
    	            {
    	            	kelvinJTextFieldKeyPressed( event );
    	            }

    			
    	            
    	         } // end anonymous inner class
    	      
    	      ); // end call to addKeyListener

      convertJButton = new JButton ();
      convertJButton.setText( "Convert C" );
      convertJButton.setBounds( 290, 10, 89, 24 );
      contentPane.add( convertJButton );
      convertJButton.addActionListener(
    		  
    		  new ActionListener()
    		  {
    			  public void actionPerformed( ActionEvent event)
    			  {
    				  try
    				  {
    					  convertJButtonActionPerformed( event );
    				
    				  }
    				  catch
    				  (Exception e)
    	    		  {
    	    			  JOptionPane.showMessageDialog(null,"Integer please","ERROR",
    	    					  JOptionPane.ERROR_MESSAGE);
    	    		  }
    			  }
    				  
    		  }
    		  
    			  
    		  );
      convertJButton1 = new JButton ();
      convertJButton1.setText( "Convert F" );
      convertJButton1.setBounds( 370, 10, 90, 24 );
      contentPane.add( convertJButton1 );
      convertJButton1.addActionListener(
    		  
    		  new ActionListener()
    		  {
    			  public void actionPerformed( ActionEvent event)
    			  {
    				  try
    				  {
    					  convertJButton1ActionPerformed( event );
    				
    				  }
    				  catch
    				  (Exception e)
    	    		  {
    	    			  JOptionPane.showMessageDialog(null,"Integer please","ERROR",
    	    					  JOptionPane.ERROR_MESSAGE);
    	    		  }
    			  }
    				  
    		  }
    		  
    			  
    		  );
      
      
      convertJButton2 = new JButton ();
      convertJButton2.setText( "Convert K" );
      convertJButton2.setBounds( 370, 40, 90, 24 );
      contentPane.add( convertJButton2 );
      convertJButton2.addActionListener(
    		  
    		  new ActionListener()
    		  {
    			  public void actionPerformed( ActionEvent event)
    			  {
    				  try
    				  {
    					  convertJButton2ActionPerformed( event );
    				
    				  }
    				  catch
    				  (Exception e)
    	    		  {
    	    			  JOptionPane.showMessageDialog(null,"Integer please","ERROR",
    	    					  JOptionPane.ERROR_MESSAGE);
    	    		  }
    			  }

			
    				  
    		  }
    		  
    			  
    		  );
      // set properties of application's window
      setTitle( "Temperature Conversion" ); // set title bar text
      setSize( 480, 150 );                  // set window size
      setVisible( true );                   // display window
   
   } // end method createUserInterface
   
   // clear fahrenheitJTextField because the value is now invalid
   private void celsiusJTextFieldKeyPressed( KeyEvent event )
   {    kelvinJTextField.setText("0");
	   fahrenheitJTextField.setText("0");
   } // end method celsiusJTextFieldKeyTyped
   // convert Celsius value to Fahrenheit value
	private void kelvinJTextFieldKeyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		fahrenheitJTextField.setText("0");
		celsiusJTextField.setText("0");
	}
	private void fahrenheitJTextFieldKeyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		kelvinJTextField.setText("0");
		celsiusJTextField.setText("0");
	}

   private void convertJButtonActionPerformed( ActionEvent event )
   {
	  double K;
	      double C;
	      double F;
	      C = Double.parseDouble(celsiusJTextField.getText());  
 
	      F= (9*C/5) + 32;
	      K = (273+C);
	      kelvinJTextField.setText(String.valueOf(K)); 
	      fahrenheitJTextField.setText(String.valueOf(F)); 
	   
   } // end method convertJButtonActionPerformed
   
   private void convertJButton1ActionPerformed( ActionEvent event )
   {
		  double K;
	      double C;
	      double F;
	      F = Double.parseDouble(fahrenheitJTextField.getText());  
 
	      C= 5*(F-32)/9;
	      K = (273+C);
	      kelvinJTextField.setText(String.valueOf(K)); 
	      celsiusJTextField.setText(String.valueOf(C)); 
	   
   } // end method convertJButtonActionPerformed
	private void convertJButton2ActionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		  double K;
	      double C;
	      double F;
	      K = Double.parseDouble(kelvinJTextField.getText());  
 
	      C= K-273;
          F=(9*K)/5+(1440/45)-(2457/5);
          celsiusJTextField.setText(String.valueOf(C)); 
	      fahrenheitJTextField.setText(String.valueOf(F)); 
	   
	}
   // main method
   public static void main( String[] args )
   {
      TemperatureConversion application = 
         new TemperatureConversion();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class TemperatureConversion


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
