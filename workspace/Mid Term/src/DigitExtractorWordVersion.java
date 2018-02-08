
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class DigitExtractorWordVersion extends JFrame
{
   // JLabel and JTextField for user to input number
   private JLabel enterNumberJLabel;
   private JTextField enterNumberJTextField;

   // JLabel and JTextFields for displaying extracted digits
   private JLabel extractedDigitsJLabel;
   private JTextField firstNumberJTextField;
   private JTextField secondNumberJTextField;
   private JTextField thirdNumberJTextField;
   private JTextField fourthNumberJTextField;
   private JTextField fifthNumberJTextField;
   private JTextField sixthNumberJTextField;
   
   private JTextField convertedJTextField;
   private JLabel convertedJLabel;

   // JButton to initiate extraction of digits
   private JButton enterJButton;
   private JButton clearJButton;
   private JTextArea TextArea;
   

   public DigitExtractorWordVersion()
   {
      createUserInterface();
   }
   

   private void createUserInterface()
   {
      // get content pane for attaching GUI components
      Container contentPane = getContentPane();

      // enable explicit positioning of GUI components
      contentPane.setLayout( null );
   
      TextArea = new JTextArea ();
      TextArea.setLineWrap(true);
      JScrollPane scroller = new JScrollPane(TextArea);
      scroller.setBounds( 10, 109, 500, 70 );
      TextArea.setEditable(false);
      TextArea.append("This is the History");
      scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  
      contentPane.add(scroller, BorderLayout.CENTER);
     
  
      
      
      clearJButton = new JButton();
      clearJButton.setBounds( 360, 10, 70, 24 );
      clearJButton.setText( "Clear" );
      contentPane.add( clearJButton );
      clearJButton.addActionListener( 
      
         new ActionListener() 
         {
           
            public void actionPerformed( ActionEvent event )
            {
            	clearJButtonActionPerformed( event );
            }
            private void clearJButtonActionPerformed( ActionEvent event)
     	   {
            	enterNumberJTextField.setText( "" ); 
            	firstNumberJTextField.setText( "" ); 
            	secondNumberJTextField.setText( "" ); 
            	thirdNumberJTextField.setText( "" ); 
            	fourthNumberJTextField.setText( "" ); 
            	fifthNumberJTextField.setText( "" ); 
            	sixthNumberJTextField.setText( "" ); 
            	convertedJTextField.setText( "" ); 
            	
           
            	
        /*    	  Object[] obj2 ={ "Yes","No","Cancel" };  
        	      String s = (String) JOptionPane.showInputDialog(null,"Select the other currency:\n", "Select Currency", JOptionPane.PLAIN_MESSAGE, null, obj2, ""); 
        	      if(s.equals("Yes"))     
        	      {
        	      
        	      	TextArea.setText(String.valueOf(""));
        	
        	      }
        	      else if(s.equals("No"))     
        	      {String k =convertedJTextField.getText();
        	      	
        	    	  TextArea.setText(String.valueOf(k));
        	     
        	      }      
        	      else if(s.equals("Cancel"))
        		      {
        		 System.out.println("");
        		      }
        		      */
            	
            	
            	int x = JOptionPane.showConfirmDialog(null, 
        				" Are you Sure you want to clear the history? ", " Clear ", JOptionPane.YES_NO_CANCEL_OPTION);
        		
        		//System.out.print(x);
        		
        		if(x == 1)
        		{
        			
        			//Means NO
        			System.out.print("NO");
        		}
        		
        		else if(x == 2)
        		{
        			
        			//Means Cancel
        			System.out.print("Cancel");
        		}
        		else 
        		{
        			TextArea.setText(String.valueOf(""));
        			TextArea.setText("This is the History");
        			//Means Yes
        			System.out.print("Yes");
        		}
        	

            	
            	
            	
            	
            	
            	
     	   } // end method clearResults
         } // end anonymous inner class
         
      ); // end call to addActionListener
      

      
      
      // set up enterNumberJLabel
      enterNumberJLabel = new JLabel();
      enterNumberJLabel.setText( "Enter six-digit number:" );
      enterNumberJLabel.setBounds( 10, 10, 150, 24 );
      contentPane.add( enterNumberJLabel );

      // set up enterNumberJTextField
      enterNumberJTextField = new JTextField();
      enterNumberJTextField.setBounds( 160, 10, 110, 24 );
      contentPane.add( enterNumberJTextField );
      enterNumberJTextField.addKeyListener(
    	  
      new KeyAdapter()
        {
        public void keyPressed(KeyEvent event)
        {
        firstNumberJTextField.setText("");
                secondNumberJTextField.setText("");
                thirdNumberJTextField.setText("");
                fourthNumberJTextField.setText("");
                fifthNumberJTextField.setText("");	                
                sixthNumberJTextField.setText("");
                convertedJTextField.setText("");
        }
        }
     	  
      );
      

      // set up extractedDigitsJLabel
      extractedDigitsJLabel = new JLabel();
      extractedDigitsJLabel.setText( "Extracted digits:" );
      extractedDigitsJLabel.setBounds( 10, 45, 150, 24 );
      contentPane.add( extractedDigitsJLabel );

      // set up 1
      firstNumberJTextField = new JTextField();
      firstNumberJTextField.setEditable( false );
      firstNumberJTextField.setBounds( 130, 45, 30, 24 );
      firstNumberJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      contentPane.add( firstNumberJTextField );

      // set up 2
      secondNumberJTextField = new JTextField();
      secondNumberJTextField.setEditable( false );
      secondNumberJTextField.setBounds( 160, 45, 30, 24 );
      secondNumberJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      contentPane.add( secondNumberJTextField );

      // set up 3
      thirdNumberJTextField = new JTextField();
      thirdNumberJTextField.setEditable( false );
      thirdNumberJTextField.setBounds( 190, 45, 30, 24 );
      thirdNumberJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      contentPane.add( thirdNumberJTextField );

      // set up 4
      fourthNumberJTextField = new JTextField();
      fourthNumberJTextField.setEditable( false );
      fourthNumberJTextField.setBounds( 220, 45, 30, 24 );
      fourthNumberJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      contentPane.add( fourthNumberJTextField );

      // set up 5
      fifthNumberJTextField = new JTextField();
      fifthNumberJTextField.setEditable( false );
      fifthNumberJTextField.setBounds( 250, 45, 30, 24 );
      fifthNumberJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      contentPane.add( fifthNumberJTextField );
      
      // set up 6
      sixthNumberJTextField = new JTextField();
      sixthNumberJTextField.setEditable( false );
      sixthNumberJTextField.setBounds( 280, 45, 30, 24 );
      sixthNumberJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      contentPane.add( sixthNumberJTextField );
      
      convertedJLabel = new JLabel();
      convertedJLabel.setText( "Word Version: " );
      convertedJLabel.setBounds( 10, 80, 150, 24 );
      contentPane.add( convertedJLabel );
      
      convertedJTextField = new JTextField();
      convertedJTextField.setEditable( false );
      convertedJTextField.setBounds( 100, 80, 500, 24 );
      convertedJTextField.setHorizontalAlignment(
         JTextField.CENTER );
      contentPane.add( convertedJTextField );

      // set up enterJButton
      enterJButton = new JButton ();
      enterJButton.setText( "Enter" );
      enterJButton.setBounds( 280, 10, 70, 24 );
      enterJButton.addActionListener(
         
      new ActionListener() // anonymous inner class
    	         {
              
                public void actionPerformed( ActionEvent event )

                {
    	                 try
    	               {
                     
                    int number= Integer.parseInt(enterNumberJTextField.getText());
    	                
                    firstNumberJTextField.setText(String.valueOf(number/100000));
    	                
                    secondNumberJTextField.setText(String.valueOf((number/10000)%10));
    	                
                    thirdNumberJTextField.setText(String.valueOf((number/1000)%10));
    	                
                    fourthNumberJTextField.setText(String.valueOf(((number/100)%10)));
    	                
                    fifthNumberJTextField.setText(String.valueOf(((number/10)%10)));
    	                
                    sixthNumberJTextField.setText(String.valueOf(number%10));
    	                
    	                
    	                
                    int HundredThousands= Integer.parseInt(firstNumberJTextField.getText());
                    int TenThousands= Integer.parseInt(secondNumberJTextField.getText());
                    int Thousands= Integer.parseInt(thirdNumberJTextField.getText());
                    int Hundred= Integer.parseInt(fourthNumberJTextField.getText());
                    int Ten= Integer.parseInt(fifthNumberJTextField.getText());
                    int One= Integer.parseInt(sixthNumberJTextField.getText());
    	                
                    switch(HundredThousands)
                    {
                    case 9:convertedJTextField.setText("Nine hundred ");break;
                    case 8:convertedJTextField.setText("Eight hundred ");break;
                    case 7:convertedJTextField.setText("Seven hundred ");break;
                    case 6:convertedJTextField.setText("Six hundred ");break;
                    case 5:convertedJTextField.setText("Five hundred ");break;
                    case 4:convertedJTextField.setText("Four hundred ");break;
                    case 3:convertedJTextField.setText("Three hundred ");break;
                    case 2:convertedJTextField.setText("Two hundred ");break;
                    case 1:convertedJTextField.setText("one hundred ");break;
                    case 0:/*nothing*/ break;
    	                
                    }
    	                
                    switch(TenThousands)
                    {
                    case 0: /*nothing*/ break;
                    case 9: convertedJTextField.setText(convertedJTextField.getText() +"ninety ");break;
                    case 8: convertedJTextField.setText(convertedJTextField.getText() +"eighty ");break;
                    case 7: convertedJTextField.setText(convertedJTextField.getText() +"seventy ");break;
                    case 6: convertedJTextField.setText(convertedJTextField.getText() +"sixty ");break;
                    case 5: convertedJTextField.setText(convertedJTextField.getText() +"fifty ");break;
                    case 4: convertedJTextField.setText(convertedJTextField.getText() +"fourty ");break;
                    case 3: convertedJTextField.setText(convertedJTextField.getText() +"thirty ");break;
                    case 2: convertedJTextField.setText(convertedJTextField.getText() +"twenty ");break;
    	            case 1: switch(Thousands)//Go to next posibility
    	            {
                case 9: convertedJTextField.setText(convertedJTextField.getText() + "nineteen thousand ");break;
                case 8: convertedJTextField.setText(convertedJTextField.getText() + "eighteen thousand ");break;
                case 7: convertedJTextField.setText(convertedJTextField.getText() +"seventeen thousand ");break;
                case 6: convertedJTextField.setText(convertedJTextField.getText() +"sixteen thousand ");break;
                case 5: convertedJTextField.setText(convertedJTextField.getText() +"fifteen thousand ");break;
                case 4: convertedJTextField.setText(convertedJTextField.getText() +"fourteen thousand ");break;
                case 3: convertedJTextField.setText(convertedJTextField.getText() +"thirteen thousand ");break;
                case 2: convertedJTextField.setText(convertedJTextField.getText() +"twelve thousand ");break;
                case 1: convertedJTextField.setText(convertedJTextField.getText() +"eleven thousand ");break;
                case 0: convertedJTextField.setText(convertedJTextField.getText() +"ten thousand ");break;
    	            }
                   
                    }//THIS IS the end of ten thousands level
    	                
    	                
                    if(!(TenThousands==1))//Go to next posibility
                    {
                    switch(Thousands)
                    {
                    case 1:convertedJTextField.setText(convertedJTextField.getText() +"one thousand ");break;
                    case 2:convertedJTextField.setText(convertedJTextField.getText() +"two thousand ");break;
                    case 3:convertedJTextField.setText(convertedJTextField.getText() +"three thousand ");break;
                    case 4:convertedJTextField.setText(convertedJTextField.getText() +"four thousand ");break;
                    case 5:convertedJTextField.setText(convertedJTextField.getText() +"five thousand ");break;
                    case 6:convertedJTextField.setText(convertedJTextField.getText() +"six thousand ");break;
                    case 7:convertedJTextField.setText(convertedJTextField.getText() +"seven thousand ");break;
                    case 8:convertedJTextField.setText(convertedJTextField.getText() +"eight thousand ");break;
                    case 9:convertedJTextField.setText(convertedJTextField.getText() +"nine thousand ");break;
                    }
                    }
    	                
    	                
                    switch(Hundred)
                    {
                       case 1:convertedJTextField.setText(convertedJTextField.getText() +"one hundred ");break;
                       case 2:convertedJTextField.setText(convertedJTextField.getText() +"two hundred ");break;
                       case 3:convertedJTextField.setText(convertedJTextField.getText() +"three hundred ");break;
    	               case 4:convertedJTextField.setText(convertedJTextField.getText() +"four hundred ");break;
    	               case 5:convertedJTextField.setText(convertedJTextField.getText() +"five hundred ");break;
    	               case 6:convertedJTextField.setText(convertedJTextField.getText() +"six hundred ");break;
    	               case 7:convertedJTextField.setText(convertedJTextField.getText() +"seven hundred ");break;
    	               case 8:convertedJTextField.setText(convertedJTextField.getText() +"eight hundred ");break;
    	               case 9:convertedJTextField.setText(convertedJTextField.getText() +"nine hundred ");break;
                    }
                    switch(Ten)
                    {
                    case 9:convertedJTextField.setText(convertedJTextField.getText() +"ninety ");break;
                    case 8:convertedJTextField.setText(convertedJTextField.getText() +"eighty ");break;
    	            case 7:convertedJTextField.setText(convertedJTextField.getText() +"seventy ");break;
                    case 6:convertedJTextField.setText(convertedJTextField.getText() +"sixty ");break;
                    case 5:convertedJTextField.setText(convertedJTextField.getText() +"fivety ");break;
    	            case 4:convertedJTextField.setText(convertedJTextField.getText() +"fourty ");break;
                    case 3:convertedJTextField.setText(convertedJTextField.getText() +"thirty ");break;
                    case 2:convertedJTextField.setText(convertedJTextField.getText() +"twenty ");break;
                    case 1:switch(One)
                    {
                    case 9:convertedJTextField.setText(convertedJTextField.getText() +"nineteen ");break;
                    case 8:convertedJTextField.setText(convertedJTextField.getText() +"eighteen ");break;
                    case 7:convertedJTextField.setText(convertedJTextField.getText() +"seventeen ");break;
                    case 6:convertedJTextField.setText(convertedJTextField.getText() +"sixteen ");break;
                    case 5:convertedJTextField.setText(convertedJTextField.getText() +"fifteen ");break;
                    case 4:convertedJTextField.setText(convertedJTextField.getText() +"fourteen ");break;
                    case 3:convertedJTextField.setText(convertedJTextField.getText() +"thirteen ");break;
                    case 2:convertedJTextField.setText(convertedJTextField.getText() +"twelve ");break;
                    case 1:convertedJTextField.setText(convertedJTextField.getText() +"eleven ");break;
                    case 0:convertedJTextField.setText(convertedJTextField.getText() +"ten ");break;
                    }
                    };
                    if(!(Ten==1))
                    {
                    switch(One)
                    {
                    case 9:convertedJTextField.setText(convertedJTextField.getText() +"nine ");break;
                    case 8:convertedJTextField.setText(convertedJTextField.getText() +"eight ");break;
                    case 7:convertedJTextField.setText(convertedJTextField.getText() +"seven ");break;
                    case 6:convertedJTextField.setText(convertedJTextField.getText() +"six ");break;
                    case 5:convertedJTextField.setText(convertedJTextField.getText() +"five ");break;
                    case 4:convertedJTextField.setText(convertedJTextField.getText() +"four ");break;
                    case 3:convertedJTextField.setText(convertedJTextField.getText() +"three ");break;
                    case 2:convertedJTextField.setText(convertedJTextField.getText() +"two ");break;
                    case 1:convertedJTextField.setText(convertedJTextField.getText() +"one ");break;
                    }//END OF LEVEL ONE
                 
                    }
    	                
                    if(number==0)
                    {
                    convertedJTextField.setText("zero");
                    }
    	                
                    if(number>999999)
     	            	   {
     	            	   JOptionPane.showMessageDialog(null, "six digits maximum","ERROR", JOptionPane.ERROR_MESSAGE);
                   firstNumberJTextField.setText("");
         	                
                         secondNumberJTextField.setText("");
         	                
                         thirdNumberJTextField.setText("");
         	                
                         fourthNumberJTextField.setText("");
         	                
                         fifthNumberJTextField.setText("");
         	                
                         sixthNumberJTextField.setText("");
         	                
                         enterNumberJTextField.setText("");
                       
                         TextArea.setText("");
     	            	   }
                    if(number<0)
                    {
    	                	 JOptionPane.showMessageDialog(null, "No negative numbers","ERROR", JOptionPane.ERROR_MESSAGE);
                      firstNumberJTextField.setText("");
            	                
                            secondNumberJTextField.setText("");
            	                
                            thirdNumberJTextField.setText("");
            	                
                            fourthNumberJTextField.setText("");
            	                
                            fifthNumberJTextField.setText("");
            	                
                            sixthNumberJTextField.setText("");
            	                
                            enterNumberJTextField.setText("");
                            
                            TextArea.setText("");
                    }

                    String text = convertedJTextField.getText();
                    TextArea.append(String.valueOf("\n"+text));
                    TextArea.append(String.valueOf("\n"+"///////////////////////////////////////////////////"));
    	               }
    	               catch(Exception e)
    	               {
                   
    	            	   {
    	            		   if(enterNumberJTextField.getText() == "")
    	            		   {
    	            			   JOptionPane.showMessageDialog(null, "Please type in an integer, don't leave it blank","ERROR", JOptionPane.ERROR_MESSAGE);
    	    	            	   enterNumberJTextField.setText("");
    	            		   }
    	            		   else
    	            		   {
    	            		   JOptionPane.showMessageDialog(null, "Integers please","ERROR", JOptionPane.ERROR_MESSAGE);
    	            	   enterNumberJTextField.setText("");
    	            		   }
    	            	   }
    	        
    	               }
                }

    	         }

          );
      
      contentPane.add( enterJButton );
  
    
      // set properties of application's window
      setTitle( "Digit Extractor(word version)" ); // set title bar text
      setSize( 600, 230 );           // set window size
      setVisible( true );            // display window
   
   }
 
   
 
   public static void main( String[] args )
   {
  DigitExtractorWordVersion application = new DigitExtractorWordVersion();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   }
 
}