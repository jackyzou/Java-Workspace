import java.awt.*;
import java.awt.event.*;
import java.io.File;
 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Port;
import javax.swing.*;
import javax.swing.border.TitledBorder;

   public class Snippet extends JFrame
   {
   
      private static final int CENTER = 0;


	private JPanel enterJPanel;


      private JLabel pointJLabel;
      private JTextField pointJTextField;


      private JButton enterJButton;

      private JPanel informationJPanel;


      private JLabel nameJLabel;
      private JTextField nameJTextField;

      private JLabel studentNumberJLabel;
      private JTextField studentNumberJTextField;
      
    
      private JLabel gradeJLabel;
      private JTextField gradeJTextField;
      
      private JButton saveJButton;
      private JButton LastJButton;
      
      private JTextField store1JTextField;
      private JTextField store2JTextField;
      
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

      public Snippet() 
      {
         createUserInterface();
      }
      
      // create and position GUI components; register event handlers
      private void createUserInterface()
      {
         // get content pane and set layout to null
         Container contentPane = getContentPane();
         contentPane.setBackground(Color.PINK);
         contentPane.setLayout( null );
         
         
       
         
         // set up enterJPanel
         enterJPanel = new JPanel();
         enterJPanel.setLayout( null );
         enterJPanel.setBounds( 16, 16, 152, 126 );
         enterJPanel.setBorder( 
            new TitledBorder( "Enter information" ) );
         contentPane.add( enterJPanel );
         
         
        
         
         
         // set up depositJLabel
         pointJLabel = new JLabel();
         pointJLabel.setText( "%POINT%:" );
         pointJLabel.setBounds( 16, 40, 140, 16 );
         enterJPanel.add( pointJLabel );
         
         // set up depositJTextField
         pointJTextField = new JTextField("");
         pointJTextField.setText( "Enter P.t. here" );
         pointJTextField.setBounds( 10, 56, 100, 21 );
         pointJTextField.setHorizontalAlignment( JTextField.RIGHT );
         enterJPanel.add( pointJTextField );
         pointJTextField.addMouseListener(new MouseAdapter(){
             public void mouseClicked(MouseEvent e){
            	 pointJTextField.setText("");
                
    
             }
             }
         );
  
         pointJTextField.addKeyListener(
       		  
       		  new KeyAdapter()
       		  {
       			  public void keyPressed( KeyEvent event)
       			  {
       				pointJTextFieldKeyPressed( event );
       			  }
       		  }
       		  
       		  );


         // set up enterJButton
         enterJButton = new JButton();
         enterJButton.setText( "Enter to get GRADE" );
         enterJButton.setBounds( 16, 150, 152, 34 );
         contentPane.add( enterJButton );
         
         enterJButton.addActionListener(

            new ActionListener() // anonymous inner class
            {
               // event handler called when enterJButton is pressed
               public void actionPerformed( ActionEvent event )
               {
               	
                  enterJButtonActionPerformed( event );
                  pointJTextField.setText("");
             
               }
              
               //public void keyPressed(KeyEvent event)
               //{
               //depositJTextField.setText("");
               //}
               //public void keyPressed(KeyEvent event)
               //{
               //	withdrawalJTextField.setText("");	
               //}
               
            } // end anonymous inner class

         ); // end call to addActionListener
         
         // set up accountJPanel
         informationJPanel = new JPanel();
         informationJPanel.setLayout( null );
         informationJPanel.setBounds( 180, 16, 136, 170 );
         informationJPanel.setBorder( 
            new TitledBorder( "Student information" ) );
         contentPane.add( informationJPanel );
         
         // set up nameJLabel
         nameJLabel = new JLabel();
         nameJLabel.setText( "Name:" );
         nameJLabel.setBounds( 16, 24, 100, 16 );
         informationJPanel.add( nameJLabel );

         // set up nameJTextField
         nameJTextField = new JTextField();
         nameJTextField.setText( "Mr. Lake" );
         nameJTextField.setBounds( 16, 40, 104, 21 );
         nameJTextField.setEditable( true );
         informationJPanel.add( nameJTextField );

         // set up accountNumberJLabel
         studentNumberJLabel = new JLabel();
         studentNumberJLabel.setText( "Student ID:" );
         studentNumberJLabel.setBounds( 16, 70, 140, 16 );
         informationJPanel.add( studentNumberJLabel );

         // set up accountNumberJTextField
         studentNumberJTextField = new JTextField();
         studentNumberJTextField.setText( "9879879" );
         studentNumberJTextField.setBounds( 16, 86, 104, 21 );
         studentNumberJTextField.setEditable( false );
         studentNumberJTextField.setHorizontalAlignment( 
            JTextField.RIGHT );
         informationJPanel.add( studentNumberJTextField );

         // set up balanceJLabel
         gradeJLabel = new JLabel();
         gradeJLabel.setText( "Grade:" );
         gradeJLabel.setBounds( 16, 116, 100, 16 );
         informationJPanel.add( gradeJLabel );
         
         // set up balanceJTextField
         gradeJTextField = new JTextField("");
         gradeJTextField.setText( "-" );
         gradeJTextField.setBounds( 16, 132, 104, 21 );
         gradeJTextField.setEditable( false );
         gradeJTextField.setHorizontalAlignment( JTextField.RIGHT );
         informationJPanel.add( gradeJTextField );
         
         
         store1JTextField = new JTextField("");
         store1JTextField.setBounds(1000, 70, 200, 20);
         store1JTextField.setEditable(false);
         store1JTextField.setVisible(false);
         store1JTextField.setHorizontalAlignment(CENTER);
          contentPane.add( store1JTextField );
          
          
          store2JTextField = new JTextField("");
          store2JTextField.setBounds(1000, 90, 200, 20);
          store2JTextField.setEditable(false);
          store2JTextField.setVisible(false);
          store2JTextField.setHorizontalAlignment(CENTER);
          contentPane.add( store2JTextField );
          
         
         saveJButton = new JButton();
         saveJButton.setText("Save");
         saveJButton.setBounds(1, 95, 70, 24);
         enterJPanel.add( saveJButton );
         saveJButton.addActionListener(
        		   new ActionListener()
        		
       		  {
       			  public void actionPerformed( ActionEvent event)
       			  {
       				 
       				  {
       				  
       					  pointJTextField.setText("0");
       					  nameJTextField.setText("Neel Drain");
       					  studentNumberJTextField.setText("5242345");
       					  gradeJTextField.setText("-");
       					  enterJButton.setEnabled(false);
       				
       				  }
       				 
       				
       	    		 
       			  }
       				  
       		  }
       		  
       			  
         		   );	 
         
         LastJButton = new JButton();
         LastJButton.setText("Return");
         LastJButton.setBounds(74, 95, 70, 24);
         enterJPanel.add( LastJButton );
          LastJButton.addActionListener(
                 
              new ActionListener()
                                     {
                                 public void actionPerformed(ActionEvent event)
                                 {
                                     int i = Integer.parseInt(store1JTextField.getText());
                                 String ii = (store2JTextField.getText());
                                 gradeJTextField.setText(String.valueOf(ii));
                                     pointJTextField.setText(String.valueOf(i));
                             }
                             }
                         );
             
             
        
          
          
         // set properties of application's window
         setTitle( "GRADE" ); // set title bar text
         setSize( 340, 225 );               // set window's size
         setVisible( true );                // display window

      } // end method createUserInterface

      // add previous balance to deposit and display result
      private void pointJTextFieldKeyPressed(KeyEvent event)
      {
    	  studentNumberJLabel.setText("Student ID"); 
    	  studentNumberJTextField.setText("9879879");
    	  gradeJTextField.setText("-");
   	   enterJButton.setEnabled(true);
      }
      
      private void studentNumberJLabelKeyPressed(KeyEvent event)
      {
    	  
      }
   	   
      private void enterJButtonActionPerformed( ActionEvent event )
      {
   	   
        double point ;//int也可以
        double grade  ;
        
       
   		  try
   		  {
   			  point = Double.parseDouble(pointJTextField.getText());
   			
   		  }
   		  catch
   		  (Exception e)
   		  {
   			  playSound("Int No.caf");
   			  JOptionPane.showMessageDialog(null,"Please type in an appropriate number","INPUT ERRORS",
   					  JOptionPane.ERROR_MESSAGE);
   		  }
   	 
   		  
   	
   		

   		  {

   			  {     

   			  point = Double.parseDouble(pointJTextField.getText());
             //Nesting  F(g(r(x))) nesting is bad
   			  if(point > 89)//the answer to left is a boolean, just true or false
   			  {
   				  gradeJTextField.setText("A");
   			   String lastr = gradeJTextField.getText();
               int laste = Integer.parseInt(pointJTextField.getText());
               store2JTextField.setText(String.valueOf(lastr));
                store1JTextField.setText(String.valueOf(laste));
   			  }
   			  else if(point > 79)//NO ; AFTER STRUCTURE
   			  {
   				  gradeJTextField.setText("B");
   				  String lastr = gradeJTextField.getText();
                  int laste = Integer.parseInt(pointJTextField.getText());
                  store2JTextField.setText(String.valueOf(lastr));
                   store1JTextField.setText(String.valueOf(laste));
   			  }
   			  else if(point > 69)//NO ; AFTER STRUCTURE
   			  {
   				  gradeJTextField.setText("C");
   				  String lastr = gradeJTextField.getText();
                  int laste = Integer.parseInt(pointJTextField.getText());
                  store2JTextField.setText(String.valueOf(lastr));
                   store1JTextField.setText(String.valueOf(laste));
   			  }
   			  else if(point > 59)//NO ; AFTER STRUCTURE
   			  {
   				  gradeJTextField.setText("D");
   				  String lastr = gradeJTextField.getText();
                  int laste = Integer.parseInt(pointJTextField.getText());
                  store2JTextField.setText(String.valueOf(lastr));
                   store1JTextField.setText(String.valueOf(laste));
   			  }

   			  else if(point < 58)
   			  // default to else
   			  {
   				  gradeJTextField.setText("F");
   				  String lastr = gradeJTextField.getText();
                  int laste = Integer.parseInt(pointJTextField.getText());
                  store2JTextField.setText(String.valueOf(lastr));
                   store1JTextField.setText(String.valueOf(laste));
   			  }


   			  }

   			  }
        

        if(point < 101)
        {
        	
       	 studentNumberJTextField.setText("ERROR");  
        }
        else
        {
        	playSound("High score.caf");
       	 gradeJTextField.setText("-");
       	 JOptionPane.showMessageDialog(null,"You cannot give the student such a high score","ERROR",
   				  JOptionPane.INFORMATION_MESSAGE);
        }
        if(point >= 0.0)
   	  {
       	 studentNumberJTextField.setText("ID PROTECTING");  
       	 studentNumberJLabel.setText("Warning");
   		  
   	  }
   	  else
   	  {
   		playSound("Mercy.caf");
   		 gradeJTextField.setText("-");
   		  JOptionPane.showMessageDialog(null,"Please show your mercy to the student","ERROR",
   				  JOptionPane.ERROR_MESSAGE);
   	  }
      } // end method enterJButtonActionPerformed

   
		// TODO Auto-generated method stub
		
	

	// main method
      public static void main( String[] args ) 
      {
   	
   	   Snippet application = new Snippet();
         application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

  	   
         //Repeat after me!
        int counter = 8;//counter is the one tell integer what to do
        while(counter < 10)//while, more than once. if,just once.
        {
     	   System.out.println("What's up");
     	   
     	   //counter = counter + 1;
           counter++;   
         //  counter = counter+2;//counter += 2;(这个是short cut of左边的，但记住是等号在后)
           for(int i =0; i<10; i++)//counter is called i(that means start at 0, end at 10)
           {
        	   System.out.println(i);
           }
        }
   	   
       
      } 

   } 



   /*
    To do control structure ,three broad topic. Highest java topic
    
    First, sequential , write code ,do this then do this. STraight line
    
    
    Second, selection conditional logic(3type) not straight line
    1.if(single conditional) statement(conditional)
    2.if  else()  statement double(2not8byte) conditional
    3.switch -(many a lot too many)
    ↑
    can connect, do this, if true, while do this
    ↓

    Third,reputation logic(loops)
    1.while loop(while it is true,sequencely)(quiz question)
    2.do while loop(run once every time,do this then check)(ask if you wanna do)
    3.for loop(most java do this)(this has the ability to do 1and2,compat) 
    */

   
   
   
   

   
   
   
   
   
   
   
   /**************************************************************************
     * MADE BY Jacky Zou*
     **************************************************************************/
//6%0(undefined)
   //3%6(3前比后小取前的)  
