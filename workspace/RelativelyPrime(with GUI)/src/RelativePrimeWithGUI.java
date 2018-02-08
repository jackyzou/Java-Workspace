import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RelativePrimeWithGUI extends JFrame 
  {
	private int firstNumber;
	private int secondNumber;

	private JLabel firstNumberJLabel;
	private JTextField firstNumberJTextField;

	private JLabel secondNumberJLabel;
	private JTextField secondNumberJTextField;

	private JButton calculateJButton;

	private JTextArea TextArea;
	private JScrollPane scroller;
    private JScrollPane scroller1;
    
    private JButton add;

	public RelativePrimeWithGUI(int first, int second) {
		firstNumber = first;
		secondNumber = second;
	}



	public RelativePrimeWithGUI() {
		createUserInterface();
	}
   

   
   // create and position GUI components; register event handlers
   private void createUserInterface()//void is send something£¬but no return
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
      
      add = new JButton("Add");
      add.setText("Add");
      
      // set up firstNumberJLabel
      firstNumberJLabel = new JLabel();
      firstNumberJLabel.setText( "Enter first number:" );
      firstNumberJLabel.setBounds( 20, 20, 125, 20 );
      contentPane.add( firstNumberJLabel );
      
      // set up firstNumberJTextField
      firstNumberJTextField = new JTextField();
      firstNumberJTextField.setText( "0" );
      firstNumberJTextField.setBounds( 165, 20, 40, 20 );
      firstNumberJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( firstNumberJTextField );

      // set up secondNumberJLabel
      secondNumberJLabel = new JLabel();
      secondNumberJLabel.setText( "Enter second number:" );
      secondNumberJLabel.setBounds( 20, 50, 150, 20 );
      contentPane.add( secondNumberJLabel );
      
      // set up secondNumberJTextField
      secondNumberJTextField = new JTextField();
      secondNumberJTextField.setText( "0" );
      secondNumberJTextField.setBounds( 165, 50, 40, 20 );
      secondNumberJTextField.setHorizontalAlignment( 
         JTextField.RIGHT );
      contentPane.add( secondNumberJTextField );

      
      // set up calculateJButton
      calculateJButton = new JButton ();
      calculateJButton.setText( "Calculate" );
      calculateJButton.setBounds( 225, 20, 90, 20 );
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener( 
    	      
 	         new ActionListener() // anonymous inner class
 	         {
 	            // method called when user clicks calculateJButton
 	            public void actionPerformed( ActionEvent event )
 	            {
 	            	try
  				  {
 	            		calculateJButtonActionPerformed( event );
  				
  				  }
  				  catch
  				  (Exception e)
  	    		  {
  	    			  JOptionPane.showMessageDialog(null,"Integer please","ERROR",
  	    					  JOptionPane.ERROR_MESSAGE);
  	    		  }
 	            }
 	           
 	            private void calculateJButtonActionPerformed( ActionEvent event)
 	     	   {
 	           	firstNumber = Integer.parseInt(firstNumberJTextField.getText());
				secondNumber = Integer.parseInt(secondNumberJTextField.getText());
				int smallest = Math.min(firstNumber, secondNumber);
				boolean flag = false;
				for (int counter = 2; counter <= smallest; counter++) {
					if (firstNumber % counter == 0 && secondNumber % counter == 0)// not
																					// relative
																					// prime
					{
						flag = true;
						break;
					}
				}

				if (!flag)// (flag == false)
				{
					System.out.println("\n"+"The firstNumber nubmer " + firstNumber
							+ " and the" + " second number " + secondNumber
							+ " are relatively prime");
					TextArea.append("\n"+"The firstNumber nubmer " + firstNumber
							+ " and the" + " second number " + secondNumber
							+ " are relatively prime");
				} else {
					System.out.println("\n"+"The firstNumber nubmer " + firstNumber
							+ " and the" + " second number " + secondNumber
							+ " are not relatively prime");
					TextArea.append("\n"+"The firstNumber nubmer " + firstNumber
							+ " and the" + " second number " + secondNumber
							+ " are not relatively prime");
				}

 	     	   } // end method clearResults
 	         } // end anonymous inner class
 	         
 	      ); // end call to addActionListener
   
      
      TextArea = new JTextArea ();
      TextArea.setText("The answer will be here");
      TextArea.append("\n"+"/////////////////////////");
      TextArea.setBounds(5, 80, 380, 90);
      TextArea.setEditable(false);
    
      JScrollPane scroller = new JScrollPane(TextArea);
      scroller.setBounds( 5, 80, 380, 90);
  
      scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      
  
      contentPane.add(scroller, BorderLayout.CENTER);

      
      
      // set properties of window
      setTitle( "Relatively Prime With GUI" ); // set window title
      setSize( 395, 250 );                 // set window size
      setVisible( true );                  // display window

   } // end method createUserInterface
   
   // calculate the average of the three values

			
			
		public static void main(String[] args) {
			
		RelativePrimeWithGUI application = new RelativePrimeWithGUI();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	} // end method main

} // end class Average