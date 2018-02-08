//////////////////////////////////////Jacky's Project\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame
{
  
   private JLabel phone, localCall, LDCall, ReduceRateCall;
   private Container contentPane;
  
   private JLabel one;
   public GUI()
   {
      createUserInterface();
   }
   
 
   private void createUserInterface()
   {
	   contentPane = getContentPane();
	   contentPane.setLayout(null);
	   contentPane.setBackground(Color.white);
	
      phone = new JLabel();
      phone.setIcon(new ImageIcon("phone_icon.jpg"));
      phone.setBounds( 0, 0, 363, 579);
      phone.setVisible(true);
      contentPane.add( phone );
      


      localCall = new JLabel();
      localCall.setIcon(new ImageIcon("buystrip_call_icon.png"));
      localCall.setBounds(0 , 0 , 50 , 50);
      localCall.setSize(400,300);
      contentPane.add( localCall );
   
     
      
      setTitle( "Phone Call" ); 
      setSize( 363, 579 );        
      setVisible( true );          

   } 
   

   public static void main( String[] args )
   {
      GUI application = new GUI();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
   
}


