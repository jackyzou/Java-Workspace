
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.awt.Graphics;



public class Triangle1 extends JFrame{


	   private JLabel enterCoordinate1JLabel;
	   private JTextField enterCoordinate1JTextField;

	   private JLabel enterCoordinate2JLabel;
	   private JTextField enterCoordinate2JTextField;

	   private JLabel enterCoordinate3JLabel;
	   private JTextField enterCoordinate3JTextField;

	   private JLabel enterCoordinate4JLabel;
	   private JTextField enterCoordinate4JTextField;
	   
	   private JLabel enterCoordinate5JLabel;
	   private JTextField enterCoordinate5JTextField;
	   
	   private JLabel enterCoordinate6JLabel;
	   private JTextField enterCoordinate6JTextField;
	
	   
	   private JLabel enterCoordinate7JLabel;
	   private JTextField enterCoordinate7JTextField;
	   
	   private JLabel enterCoordinate8JLabel;
	   private JTextField enterCoordinate8JTextField;
	   
	   private JLabel enterCoordinate9JLabel;
	   private JTextField enterCoordinate9JTextField;
	   
	   private JLabel enterCoordinate10JLabel;
	   private JTextField enterCoordinate10JTextField;
	   
	   private JButton enterJButton;
	   
	   private JTextArea TextArea;
	   private JScrollPane scroller;
	
	   private JTextField angleTypeJTextField;
	   private JLabel andJLabel;
	   private JButton clearJButton;
	   // no-argument constructor
	  
	  
	

	   


	       
	    public Triangle1()
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
	     
	    
	     
	      
	      clearJButton = new JButton();
	      clearJButton.setBounds(  400, 40, 70, 24);
	      clearJButton.setText( "Clear" );
	      contentPane.add( clearJButton );
	      clearJButton.addActionListener( 
	      
	         new ActionListener() // anonymous inner class
	         {
	            // method called when user clicks calculateJButton
	            public void actionPerformed( ActionEvent event )
	            {
	            	clearJButtonActionPerformed( event );
	            }
	            private void clearJButtonActionPerformed( ActionEvent event)
	     	   {
	            	angleTypeJTextField.setText( "" ); 
	            	enterCoordinate1JTextField.setText( "" ); 
	            	enterCoordinate2JTextField.setText( "" ); 
	            	enterCoordinate3JTextField.setText( "" ); 
	            	enterCoordinate4JTextField.setText( "" ); 
	            	enterCoordinate5JTextField.setText( "" ); 
	            	enterCoordinate6JTextField.setText( "" ); 
					enterCoordinate7JTextField.setText( "" ); 
					enterCoordinate8JTextField.setText( "" ); 
					enterCoordinate9JTextField.setText( "" ); 
					enterCoordinate10JTextField.setText( "" );
					angleTypeJTextField.setText( "" );
					TextArea.setText("");

	     	   } // end method clearResults
	         } // end anonymous inner class
	         
	      ); // end call to addActionListener
	      
	      
	      
	      angleTypeJTextField = new JTextField();
	      angleTypeJTextField.setBounds( 370, 200, 100, 24 );
	  
	      angleTypeJTextField.setEditable(false);
	      contentPane.add( angleTypeJTextField );
	      angleTypeJTextField.addKeyListener(

	    	         new KeyAdapter() // anonymous inner class
	    	         {
	    	            // called when key pressed in firstNumberJTextField
	    	            public void keyPressed( KeyEvent event )
	    	            {
	    	            	angleTypeJTextFieldKeyPressed( event );
	    	            }

						private void angleTypeJTextFieldKeyPressed(
								KeyEvent event) {
							angleTypeJTextField.setText( "" ); 
							enterCoordinate7JTextField.setText( "" ); 
							enterCoordinate8JTextField.setText( "" ); 
							enterCoordinate9JTextField.setText( "" ); 
							enterCoordinate10JTextField.setText( "" );
							angleTypeJTextField.setText( "" );
							TextArea.setText("");
						}

	    	         } // end anonymous inner class

	    	      ); // end call to addKeyListener
	      
	      andJLabel = new JLabel();
	      andJLabel.setText( "and");
	      andJLabel.setBounds( 348, 200, 50, 24 );
		      contentPane.add( andJLabel );

	      
	      TextArea = new JTextArea ();
	      TextArea.setLineWrap(true);
	      JScrollPane scroller = new JScrollPane(TextArea);
	      scroller.setBounds( 10, 109, 250, 70 );
	      TextArea.setEditable(false);
	      scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	      contentPane.add(scroller, BorderLayout.CENTER);
	   

	      
	      
	      
	      // set up enterNumberJLabel
	      enterCoordinate1JLabel = new JLabel();
	      enterCoordinate1JLabel.setText( "Please enter the first coordinate:(            ,        " +
	      		"    )" );
	      enterCoordinate1JLabel.setBounds( 10, 10, 550, 24 );
	      contentPane.add( enterCoordinate1JLabel );

	      // set up enterNumberJTextField
	      enterCoordinate1JTextField = new JTextField();
	      enterCoordinate1JTextField.setBounds( 220, 10, 48, 24 );
	      contentPane.add( enterCoordinate1JTextField );
	      enterCoordinate1JTextField.addKeyListener(

	    	         new KeyAdapter() // anonymous inner class
	    	         {
	    	            // called when key pressed in firstNumberJTextField
	    	            public void keyPressed( KeyEvent event )
	    	            {
	    	            	enterCoordinate1JTextFieldKeyPressed( event );
	    	            }

						private void enterCoordinate1JTextFieldKeyPressed(
								KeyEvent event) {
							enterCoordinate7JTextField.setText( "" ); 
							enterCoordinate8JTextField.setText( "" ); 
							enterCoordinate9JTextField.setText( "" ); 
							enterCoordinate10JTextField.setText( "" ); 
							angleTypeJTextField.setText( "" );
							TextArea.setText("");
							
						}

	    	         } // end anonymous inner class

	    	      ); // end call to addKeyListener
	 
	  //////////////////////////////////////////////////////////////////////////////   1111111   
	      
	      
	      enterCoordinate2JLabel = new JLabel();
	      enterCoordinate2JLabel.setText(  "Please enter the second coordinate:(             ,               )" );
	      enterCoordinate2JLabel.setBounds( 10, 38, 550, 24 );
	      contentPane.add( enterCoordinate2JLabel );

	      // set up enterNumberJTextField
	      enterCoordinate2JTextField = new JTextField();
	      enterCoordinate2JTextField.setBounds(  240, 40, 48, 24 );
	      contentPane.add( enterCoordinate2JTextField );
	      enterCoordinate2JTextField.addKeyListener(

	    	         new KeyAdapter() // anonymous inner class
	    	         {
	    	            // called when key pressed in firstNumberJTextField
	    	            public void keyPressed( KeyEvent event )
	    	            {
	    	            	enterCoordinate2JTextFieldKeyPressed( event );
	    	            }

						private void enterCoordinate2JTextFieldKeyPressed(
								KeyEvent event) {
							enterCoordinate7JTextField.setText( "" ); 
							enterCoordinate8JTextField.setText( "" ); 
							enterCoordinate9JTextField.setText( "" ); 
							enterCoordinate10JTextField.setText( "" ); 
							TextArea.setText("");
							angleTypeJTextField.setText( "" );
						}

	    	         } // end anonymous inner class

	    	      ); // end call to addKeyListener
////////////////////////////////////////////////////////////////////////////////////////////////////   2222
	      
	      
	      enterCoordinate3JLabel = new JLabel();
	      enterCoordinate3JLabel.setText(  "Please enter the third coordinate:(             ,               )");
	      enterCoordinate3JLabel.setBounds( 10, 66, 550, 24 );
	      contentPane.add( enterCoordinate3JLabel );

	      // set up enterNumberJTextField
	      enterCoordinate3JTextField = new JTextField();
	      enterCoordinate3JTextField.setBounds(   225, 70, 48, 24  );
	      contentPane.add( enterCoordinate3JTextField );
	      enterCoordinate3JTextField.addKeyListener(

	    	         new KeyAdapter() // anonymous inner class
	    	         {
	    	            // called when key pressed in firstNumberJTextField
	    	            public void keyPressed( KeyEvent event )
	    	            {
	    	            	enterCoordinate3JTextFieldKeyPressed( event );
	    	            }

						private void enterCoordinate3JTextFieldKeyPressed(
								KeyEvent event) {
							enterCoordinate7JTextField.setText( "" ); 
							enterCoordinate8JTextField.setText( "" ); 
							enterCoordinate9JTextField.setText( "" ); 
							enterCoordinate10JTextField.setText( "" ); 
							TextArea.setText("");
							angleTypeJTextField.setText( "" );
						}

	    	         } // end anonymous inner class

	    	      ); // end call to addKeyListener
	      
///////////////////////////////////////////////////////////////////////////////////////////////////////   333333
	      
	      


	      // set up enterNumberJTextField
	      enterCoordinate4JTextField = new JTextField();
	      enterCoordinate4JTextField.setBounds( 269, 10, 48, 24 );
	      contentPane.add( enterCoordinate4JTextField );
	      enterCoordinate4JTextField.addKeyListener(

	    	         new KeyAdapter() // anonymous inner class
	    	         {
	    	            // called when key pressed in firstNumberJTextField
	    	            public void keyPressed( KeyEvent event )
	    	            {
	    	            	enterCoordinate4JTextFieldKeyPressed( event );
	    	            }

						private void enterCoordinate4JTextFieldKeyPressed(
								KeyEvent event) {
							enterCoordinate7JTextField.setText( "" ); 
							enterCoordinate8JTextField.setText( "" ); 
							enterCoordinate9JTextField.setText( "" ); 
							enterCoordinate10JTextField.setText( "" ); 
							TextArea.setText("");
							angleTypeJTextField.setText( "" );
						}

	    	         } // end anonymous inner class

	    	      ); // end call to addKeyListener
	      
	      
///////////////////////////////////////////////////////////////////////////////////////////////////////   /4444444
	      
	      


	      // set up enterNumberJTextField
	      enterCoordinate5JTextField = new JTextField();
	      enterCoordinate5JTextField.setBounds(  300, 40, 48, 24);
	      contentPane.add( enterCoordinate5JTextField );
	      enterCoordinate5JTextField.addKeyListener(

	    	         new KeyAdapter() // anonymous inner class
	    	         {
	    	            // called when key pressed in firstNumberJTextField
	    	            public void keyPressed( KeyEvent event )
	    	            {
	    	            	enterCoordinate5JTextFieldKeyPressed( event );
	    	            }

						private void enterCoordinate5JTextFieldKeyPressed(
								KeyEvent event) {
							enterCoordinate7JTextField.setText( "" ); 
							enterCoordinate8JTextField.setText( "" ); 
							enterCoordinate9JTextField.setText( "" ); 
							enterCoordinate10JTextField.setText( "" ); 
							TextArea.setText("");
							angleTypeJTextField.setText( "" );
						}

	    	         } // end anonymous inner class

	    	      ); // end call to addKeyListener
	      
///////////////////////////////////////////////////////////////////////////////////////////////////////   /555555
	      
	      


	      // set up enterNumberJTextField
	      enterCoordinate6JTextField = new JTextField();
	      enterCoordinate6JTextField.setBounds( 280, 70, 48, 24  );
	      contentPane.add( enterCoordinate6JTextField );
	      enterCoordinate6JTextField.addKeyListener(

	    	         new KeyAdapter() // anonymous inner class
	    	         {
	    	            // called when key pressed in firstNumberJTextField
	    	            public void keyPressed( KeyEvent event )
	    	            {
	    	            	enterCoordinate6JTextFieldKeyPressed( event );
	    	            }

						private void enterCoordinate6JTextFieldKeyPressed(
								KeyEvent event) {
							enterCoordinate7JTextField.setText( "" ); 
							enterCoordinate8JTextField.setText( "" ); 
							enterCoordinate9JTextField.setText( "" ); 
							enterCoordinate10JTextField.setText( "" ); 
							TextArea.setText("");
							angleTypeJTextField.setText( "" );
						}

	    	         } // end anonymous inner class

	    	      ); // end call to addKeyListener
	      
///////////////////////////////////////////////////////////////////////////////////////////////////////   /666666
	      enterCoordinate7JLabel = new JLabel();
	      enterCoordinate7JLabel.setText( "Result:" );
	      enterCoordinate7JLabel.setBounds( 10, 200, 250, 24 );
	      contentPane.add( enterCoordinate7JLabel );

	      // set up enterNumberJTextField
	      enterCoordinate7JTextField = new JTextField();
	      enterCoordinate7JTextField.setBounds( 250, 200, 100, 24 );
	      enterCoordinate7JTextField.setEditable(false);
	      contentPane.add( enterCoordinate7JTextField );
	      enterCoordinate7JTextField.addKeyListener(

	    	         new KeyAdapter() // anonymous inner class
	    	         {
	    	            // called when key pressed in firstNumberJTextField
	    	            public void keyPressed( KeyEvent event )
	    	            {
	    	            	enterCoordinate7JTextFieldKeyPressed( event );
	    	            }

						private void enterCoordinate7JTextFieldKeyPressed(
								KeyEvent event) {
							enterCoordinate7JTextField.setText( "" ); 
							enterCoordinate8JTextField.setText( "" ); 
							enterCoordinate9JTextField.setText( "" ); 
							enterCoordinate10JTextField.setText( "" ); 
							TextArea.setText("");	angleTypeJTextField.setText( "" );
						}

	    	         } // end anonymous inner class

	    	      ); // end call to addKeyListener
	      
///////////////////////////////////////////////////////////////////////////////////////////////////////   /0000000
	      enterCoordinate8JLabel = new JLabel();
	      enterCoordinate8JLabel.setText( "Angle 1 equals:" );
	      enterCoordinate8JLabel.setBounds( 10, 240, 250, 24 );
	      contentPane.add( enterCoordinate8JLabel );

	      // set up enterNumberJTextField
	      enterCoordinate8JTextField = new JTextField();
	      enterCoordinate8JTextField.setBounds( 250, 240, 200, 24 );
	      enterCoordinate8JTextField.setEditable(false);
	      contentPane.add( enterCoordinate8JTextField );
	      enterCoordinate8JTextField.addKeyListener(

	    	         new KeyAdapter() // anonymous inner class
	    	         {
	    	            // called when key pressed in firstNumberJTextField
	    	            public void keyPressed( KeyEvent event )
	    	            {
	    	            	enterCoordinate8JTextFieldKeyPressed( event );
	    	            }

						private void enterCoordinate8JTextFieldKeyPressed(
								KeyEvent event) {
							enterCoordinate7JTextField.setText( "" ); 
							enterCoordinate8JTextField.setText( "" ); 
							enterCoordinate9JTextField.setText( "" ); 
							enterCoordinate10JTextField.setText( "" ); 
							TextArea.setText("");
							angleTypeJTextField.setText( "" );
						}

	    	         } // end anonymous inner class

	    	      ); // end call to addKeyListener
	      
///////////////////////////////////////////////////////////////////////////////////////////////////////   /0000000
	      enterCoordinate9JLabel = new JLabel();
	      enterCoordinate9JLabel.setText( "Angle 2 equals:" );
	      enterCoordinate9JLabel.setBounds( 10, 270, 250, 24 );
	      contentPane.add( enterCoordinate9JLabel );

	      // set up enterNumberJTextField
	      enterCoordinate9JTextField = new JTextField();
	      enterCoordinate9JTextField.setBounds( 250, 270, 200, 24 );
	      enterCoordinate9JTextField.setEditable(false);
	      contentPane.add( enterCoordinate9JTextField );
	      enterCoordinate9JTextField.addKeyListener(

	    	         new KeyAdapter() // anonymous inner class
	    	         {
	    	            // called when key pressed in firstNumberJTextField
	    	            public void keyPressed( KeyEvent event )
	    	            {
	    	            	enterCoordinate9JTextFieldKeyPressed( event );
	    	            }

						private void enterCoordinate9JTextFieldKeyPressed(
								KeyEvent event) {
							enterCoordinate7JTextField.setText( "" ); 
							enterCoordinate8JTextField.setText( "" ); 
							enterCoordinate9JTextField.setText( "" ); 
							enterCoordinate10JTextField.setText( "" ); 
							TextArea.setText("");
							angleTypeJTextField.setText( "" );
						}

	    	         } // end anonymous inner class

	    	      ); // end call to addKeyListener
	      
///////////////////////////////////////////////////////////////////////////////////////////////////////   /0000000
	      enterCoordinate10JLabel = new JLabel();
	      enterCoordinate10JLabel.setText( "Angle 3 equals:" );
	      enterCoordinate10JLabel.setBounds( 10, 300, 250, 24 );
	      contentPane.add( enterCoordinate10JLabel );

	      // set up enterNumberJTextField
	      enterCoordinate10JTextField = new JTextField();
	      enterCoordinate10JTextField.setBounds( 250, 300, 200, 24 );
	      enterCoordinate10JTextField.setEditable(false);
	      contentPane.add( enterCoordinate10JTextField );

///////////////////////////////////////////////////////////////////////////////////////////////////////   /0000000
	    
	      
	      
	      enterCoordinate4JLabel = new JLabel();
	      enterCoordinate4JLabel.setText( "You typed in:" );
	      enterCoordinate4JLabel.setBounds( 10, -180, 250, 554 );
	      contentPane.add( enterCoordinate4JLabel );
	     

	   
	    	         
	    	         
	    	         
	    	         
	    	         
	    	         
	    	         
	    	         
	    	         
	    	         
	    	         
	    	         
	    	         
	      // set up enterJButton 
	      enterJButton = new JButton ();
	      enterJButton.setText( "Enter" );
	      enterJButton.setBounds( 400, 10, 70, 24 );
	      contentPane.add( enterJButton );
	      enterJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				 try
	    				  {
	    				  enterJButtonActionPerformed( event );
	    				
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
	      setTitle( "Triangle Judging Machine" ); // set title bar text
	      setSize( 550, 550 );           // set window size
	      setVisible( true );            // display window
	   
	   } // end method createUserInterface
	   
	   // extract and display individual digits

	
	
	
	   private void enterJButtonActionPerformed( ActionEvent event )
	   { 
       double x1,x2,x3,y1,y2,y3;
       x1 = Integer.parseInt(enterCoordinate1JTextField.getText());
       x2 = Integer.parseInt(enterCoordinate2JTextField.getText());
       x3 = Integer.parseInt(enterCoordinate3JTextField.getText());
       y1 = Integer.parseInt(enterCoordinate4JTextField.getText());
       y2 = Integer.parseInt(enterCoordinate5JTextField.getText());
       y3 = Integer.parseInt(enterCoordinate6JTextField.getText());
       
       TextArea.setText(String.valueOf(TextArea.getText() + "( "+x1+" , "+y1+" )"));
       TextArea.setText(String.valueOf(TextArea.getText() +"\n"+ "( "+x2+" , "+y2+" )"));
       TextArea.setText(String.valueOf(TextArea.getText() + "\n"+"( "+x3+" , "+y3+" )"));
       TextArea.setText(String.valueOf(TextArea.getText()+"\n"+"////////////////////////////////"));
		   
    
       double distanceAB, distanceAC, distanceBC; 
       double slope1=0,slope2=0,slope3=0;

  
       distanceBC = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
	 
	

       TextArea.setText(String.valueOf(TextArea.getText()+"\n"+"The Lengths of 3 sides are:"));

       distanceAB=Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
       
       DecimalFormat decform= new DecimalFormat("0.00");
       
       TextArea.setText(String.valueOf(TextArea.getText() +"\n"+"The Length of AB"+":"+" "+decform.format(distanceAB)));
     
       distanceAC=Math.sqrt(Math.pow((x3-x1),2)+Math.pow((y3-y1),2));
       TextArea.setText(String.valueOf(TextArea.getText() +"\n"+"The Length of AC"+":"+" "+decform.format(distanceAC)));
       distanceBC = Math.sqrt(Math.pow((x3-x2),2)+Math.pow((y3-y2),2));

       TextArea.setText(String.valueOf(TextArea.getText() +"\n"+"The Length of BC"+":"+" "+decform.format(distanceBC)));

	   
       slope1 = (y1-y2)/(x1-x2);

       slope2 = (y1-y3)/(x1-x3);

       slope3 = (y2-y3)/(x2-x3);


       System.out.println("//////////////////////////");

       System.out.println(slope1);

       System.out.println(slope2);

       System.out.println(slope3);

       

       if((x1==x2 && x2==x3 && x1==x3) || (y1==y2 && y2==y3 && y1==y3) ||

       (slope1==slope2) || (slope1==slope3) || (slope2==slope3))


       {

       JOptionPane.showMessageDialog(null, "These coornates do not form a triangle","ERROR",

       JOptionPane.ERROR_MESSAGE);

       }

       else

       {

       if(distanceAB==distanceAC && distanceAB==distanceBC && distanceAC==distanceBC)

       {

    	   enterCoordinate7JTextField.setText(String.valueOf("equilateral"));


       }

       else if((distanceAB == distanceAC))

       {


    	   enterCoordinate7JTextField.setText(String.valueOf("isosceles"));

       }

       else if(distanceAB == distanceBC)

       {
    	   enterCoordinate7JTextField.setText(String.valueOf("isosceles"));
    	

       }

       else if(distanceAC == distanceBC)

       {

    	   enterCoordinate7JTextField.setText(String.valueOf("isosceles"));

       }

       else if(!(distanceAC==distanceAB) && !(distanceAB==distanceBC) && !(distanceBC==distanceAC))

       {
    	   enterCoordinate7JTextField.setText(String.valueOf("Scalene"));
    	   

       }

       else

       {

       System.err.print("ERROR");

       }

       }

     
       
       try{

    	   Double a = distanceAB;

    	   Double b = distanceBC;

    	   Double c = distanceAC;

    	   
    	   DecimalFormat decform1= new DecimalFormat("0.00");



    	   double A = ((((a * a) - ((b * b) + (c * c))) / ((-2.0) * c * b)));

    	   double angleA = Math.acos(A) * (180/Math.PI);


    	   enterCoordinate8JTextField.setText(String.valueOf(decform1.format(angleA)));



    	   double B = ((((b * b) - ((a * a) + (c * c))) / ((-2.0) * c * a)));

    	   double angleB = Math.acos(B) * (180/Math.PI);


    	   enterCoordinate9JTextField.setText(String.valueOf(decform1.format(angleB)));


    	   double C = ((((c * c) - ((b * b) + (a * a))) / ((-2.0) * a * b)));

    	   double angleC = Math.acos(C) * (180/Math.PI);


    	   enterCoordinate10JTextField.setText(String.valueOf(decform1.format(angleC)));


    	 


    	   }


    	   catch(Exception x)

    	   {

    	   JOptionPane.showMessageDialog(null, "you need to have three valid coordnates","ERROR",

    	   JOptionPane.ERROR_MESSAGE);

    	   }
	   
     try{

    	   Double angle1 =Double.parseDouble(enterCoordinate8JTextField.getText());

    	   Double angle2 =Double.parseDouble(enterCoordinate9JTextField.getText());

    	   Double angle3 =Double.parseDouble(enterCoordinate10JTextField.getText());


    	   if(angle1 > 90 || angle2 > 90 || angle3 > 90)

    	   {

    		   angleTypeJTextField.setText(String.valueOf("obtuse"));

    	   }

    	   else if(angle1 == 90 || angle2 == 90 || angle3 == 90 )

    	   {

    		   angleTypeJTextField.setText(String.valueOf("right"));

    	   }

    	   else

    	   {

    		   angleTypeJTextField.setText(String.valueOf("acute"));

    	   }
     }
     catch(Exception x)

     {

     JOptionPane.showMessageDialog(null, "you need to calculate all 3 angle measures","ERROR",

     JOptionPane.ERROR_MESSAGE);

     }
    	  
	   
     {
    	 double A1 = Double.parseDouble(enterCoordinate8JTextField.getText());
    	 double A2 = Double.parseDouble(enterCoordinate9JTextField.getText());
    	 double A3 = Double.parseDouble(enterCoordinate10JTextField.getText());
    	 DecimalFormat decform2= new DecimalFormat("0.00бу");
    	 enterCoordinate8JTextField.setText(String.valueOf(decform2.format(A1)));
    	 enterCoordinate9JTextField.setText(String.valueOf(decform2.format(A2)));
    	 enterCoordinate10JTextField.setText(String.valueOf(decform2.format(A3)));
     }
	   
	   
	  
	   
  
	   
	   
	   }



    
	   

  
	   
	   
	   
	   
	   
 

	  
	   
	   
	   
	   
	   
	   
	   
	   
	   public static void main( String[] args )
	   {
		   Triangle1 application = new Triangle1();
	      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	   } // end method main
	}
