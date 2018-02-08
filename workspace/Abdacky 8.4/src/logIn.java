import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class logIn extends JFrame
{
	private Container contentPane;

	private JTextField userNameJTF,passwordJTF;
	private JLabel userNameJL, passwordJL;
	private JButton submitJButton, backJB;
	
	
	public logIn()
	{
		createUserInterface();
	}
	
	public void createUserInterface()
	{
		contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		contentPane.setBackground(Color.white);
		
		userNameJL = new JLabel("Username: ");
		userNameJL.setBounds(10,25,150,30);
		userNameJL.setForeground(Color.BLACK);
		contentPane.add(userNameJL);
		
		userNameJTF = new JTextField();
		userNameJTF.setBounds(120,25,70,30);
		userNameJTF.setEditable(true);
		contentPane.add(userNameJTF);
		
		
		passwordJL = new JLabel("Password:");
		passwordJL.setBounds(10,75,150,30);
		passwordJL.setForeground(Color.BLACK);
		contentPane.add(passwordJL);
		
		passwordJTF = new JTextField();
		passwordJTF.setBounds(120,75,70,30);
		passwordJTF.setEditable(true);
		contentPane.add(passwordJTF);
		
		backJB = new JButton();
		backJB.setText( "Back" );
		backJB.setBounds( 10,170,90,30 );
		backJB.setVisible(true);
    	contentPane.add( backJB );
    	backJB.addActionListener(
         
         new ActionListener() 
         {
             public void actionPerformed ( ActionEvent event )
             {
            	 MasterController.logTOset();
             }

         } 

      ); 
	
		submitJButton = new JButton();
		submitJButton.setText( "Log In" );
		submitJButton.setBounds( 10,120,150,30 );
		submitJButton.setVisible(true);
    	contentPane.add( submitJButton );
    	submitJButton.addActionListener(
         
         new ActionListener() 
         {
             public void actionPerformed ( ActionEvent event )
             {
              try{
            	  	String usname = userNameJTF.getText();
            	  	//MasterController.inUsername(usname);
            	  
            		MasterController.ReadInfo(usname);
            		
            		MasterController.outHomeP();
        			MasterController.outHomeB();
        			MasterController.printInfo();
        			setVisible(false);
            	 }
            	 catch(Exception x)
            	 {
            		 JOptionPane.showMessageDialog(null, "NO SUCH DIRECTORY",
							 "ERROR", JOptionPane.ERROR_MESSAGE);
            	 }
             }

         } 

      ); 
	
	//window stuff
	setVisible(true);
	setSize(300,230);
	setTitle("Set Up screen");
}	
}
