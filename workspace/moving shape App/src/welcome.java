// Tutorial 2: Welcome.java
// This application welcomes the user to Java programming.
//comments
//This is a single sentence comment
/*
 * This is a paragraph type of comment
 * I can continue to make notes 
 */
import java.awt.*;//This is the API（Abstract Window Toolkit=AWT）
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.*;

public class welcome extends JFrame//Making object
{
   private static final Component HAHA = null;
   private JLabel textJLabel;    // JLabel that displays text
   private JLabel myTextJLabel;  //object's data
   private JLabel pictureJLabel; // JLabel that displays an image
   private ImageObserver observer;
   private JLabel textJLabel1;
   private JButton clickerJButton;
   private Container contentPane;

   
   // no-argument constructor. Constructs the Welcome object
   public welcome()
   
   
   //create object,the things we can do: method!
   //object is an instance of a class  Ex: Human lake =new human(); 
   //lake.setColor(White);
   //lake.setEyeColor(blue);
   //Ball soccerBall=new Ball
   //method is the object's behavior
   //object.action(nons.verb)    
   
   //binary
   
   
   
   
   
   
   
   
   
   
   {
      createUserInterface();
   }

   // create and position GUI components; register event handlers
    private void createUserInterface()
   {
      // get content pane and set layout to null
      contentPane = getContentPane();
      contentPane.setBackground(Color.gray);
      contentPane.setLayout( null );
   
      
      // set up textJLabel
      textJLabel = new JLabel();
      textJLabel.setText("He is not a good boy");
      textJLabel.setBounds(300,275,550,190);//sets everything(x,y, width 80_);
      textJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,40));
      textJLabel.setHorizontalAlignment(HEIGHT);
      contentPane.add( textJLabel );
      
      textJLabel1 = new JLabel();
      textJLabel1.setText("BUT,I am definitely a good boy!"); 
      textJLabel1.setBounds(650,0,500,250);//sets everything(x,y, width 80_);
      textJLabel1.setFont (new Font("Papyrus", Font.ROMAN_BASELINE,30));
      textJLabel1.setHorizontalAlignment(HEIGHT);
      contentPane.add( textJLabel1 ); 
 
      
      
      
      // set up pictureJLabel
      
      
      pictureJLabel = new JLabel();
      
      pictureJLabel.setBounds(120, 100, 0, 0);//sets everything(x,y, width 80_);
      pictureJLabel.setHorizontalAlignment( JLabel.CENTER);
      pictureJLabel.setSize(500,300);
      contentPane.add( pictureJLabel );
      
		clickerJButton =new JButton(new ImageIcon("0008.gif"));
		clickerJButton.setBounds(300,100,0,0);
		clickerJButton.setSize(169,169);
		contentPane.add(clickerJButton);
			
		clickerJButton.addActionListener(
				
				new ActionListener()// 这个是发令者
				{
					public void actionPerformed(ActionEvent event)//new ActionListener()发完令，就由这个来工作
					{
					
					 contentPane.setBackground(Color.pink);
					}
				}
				
				
				
				
				
				);
      
      pictureJLabel = new JLabel();
      pictureJLabel.setIcon(new ImageIcon("IMG_2225.jpg"));
      pictureJLabel.setBounds(700, 150, 70, 70);//sets everything(x,y, width 80_);
      pictureJLabel.setHorizontalAlignment( JLabel.LEADING);
      pictureJLabel.setSize(500,500);
      contentPane.add( pictureJLabel );

      pictureJLabel = new JLabel();
      pictureJLabel.setIcon(new ImageIcon("IMG_0010.JPG"));
      pictureJLabel.setBounds(0, 0, 1500, 12500);//sets everything(x,y, width 80_);
      pictureJLabel.setHorizontalAlignment( JLabel.CENTER);
      pictureJLabel.setSize(1450,800);
      contentPane.add( pictureJLabel );
      
      
      // set properties of application's window
      setTitle("Jacky's Welcome Page");   // set JFrame's title bar string
      setSize( 5000, 5000 );   // set width and height of JFrame
      setVisible( true );    // display JFrame on screen
      //this is the object itself, the welcome object
   } // end method createUserInterface

   // main method
   public static void main( String[] args )//every program should have this one, it's the end of the app, whithout this one will not work.
   {
      welcome application = new welcome();//Construct new object application
      
      System.out.println("Hello1 ");// \n 可以使中间隔一行
      System.out.print("Hello2");
      
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} // end class Welcome


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
