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


public class setupPage extends JFrame
{
	private Container contentPane;

	private JTextField userNameJTF,passwordJTF, emailJTF, phoneJTF, ballanceJTextField;
	private JLabel userNameJL, passwordJL, emailJL, phoneJL, ballanceJLabel;
	private JButton submitJButton, logInJButton;
	
	
	public setupPage()
	{
		createUserInterface();
	}
	
	public void createUserInterface()
	{
		contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		contentPane.setBackground(Color.white);
		
		userNameJL = new JLabel("New User Name: ");
		userNameJL.setBounds(10,25,150,30);
		userNameJL.setForeground(Color.BLACK);
		contentPane.add(userNameJL);
		
		userNameJTF = new JTextField();
		userNameJTF.setBounds(120,25,70,30);
		userNameJTF.setEditable(true);
		contentPane.add(userNameJTF);
		
		
		passwordJL = new JLabel("New Password:");
		passwordJL.setBounds(10,75,150,30);
		passwordJL.setForeground(Color.BLACK);
		contentPane.add(passwordJL);
		
		passwordJTF = new JTextField();
		passwordJTF.setBounds(120,75,70,30);
		passwordJTF.setEditable(true);
		contentPane.add(passwordJTF);
		
		
		emailJL = new JLabel("New Email:");
		emailJL.setBounds(10,125,150,30);
		emailJL.setForeground(Color.BLACK);
		contentPane.add(emailJL);
		
		emailJTF = new JTextField();
		emailJTF.setBounds(120,125,70,30);
		emailJTF.setEditable(true);
		contentPane.add(emailJTF);
		
		phoneJL= new JLabel("New PhoneNumber:");
		phoneJL.setBounds(10,175,150,30);
		phoneJL.setForeground(Color.BLACK);
		contentPane.add(phoneJL);
		
		phoneJTF= new JTextField();
		phoneJTF.setBounds(130,175,70,30);
		phoneJTF.setEditable(true);
		contentPane.add(phoneJTF);
	
	
		ballanceJLabel= new JLabel("Start up ballance:");
		ballanceJLabel.setBounds(10,225,150,30);
		ballanceJLabel.setForeground(Color.BLACK);
		contentPane.add(ballanceJLabel);
	
		ballanceJTextField= new JTextField();
		ballanceJTextField.setBounds(130,225,70,30);
		ballanceJTextField.setEditable(true);
		contentPane.add(ballanceJTextField);
	
		submitJButton = new JButton();
		submitJButton.setText( "Submit" );
		submitJButton.setBounds( 10,280,150,30 );
		submitJButton.setVisible(true);
    	contentPane.add( submitJButton );
    	submitJButton.addActionListener(
         
         new ActionListener() 
         {
            
             public void actionPerformed ( ActionEvent event )
             {
              try{
            		 double b = Double.parseDouble(ballanceJTextField.getText());
            		 String u =  userNameJTF.getText();
            		 String e =  emailJTF.getText();
            		 String f = phoneJTF.getText();
            		 String p = passwordJTF.getText();
            	 
        
            	 
            		 if(b < 0)
            		 {
	            	 		JOptionPane.showMessageDialog(null, 
	            	 			"Ballance must be positive", "ERROR", 
	            	 			JOptionPane.ERROR_MESSAGE);
            		 }
            		 
            		 else if(u.equals("") || e.equals("") || f.equals(""))
            		 {
            			 JOptionPane.showMessageDialog(null, 
 	            	 			"Please fill out everything", "ERROR", 
 	            	 			JOptionPane.ERROR_MESSAGE);
            		 }
            		 
            		 else
            		 {
            			MasterController.inSetup(b,u,p,e,f);//send info to MasterController
            			MasterController.outHomeP();
            			MasterController.outHomeB();
            			MasterController.printInfo();
            			setVisible(false);
            		 }
            	 }
            	 catch(Exception x)
            	 {
            		 JOptionPane.showMessageDialog(null, "Please fill out everything with sufficent things",
							 "ERROR", JOptionPane.ERROR_MESSAGE);
            	 }
             }

         } 

      ); 
    	
    	logInJButton = new JButton();
    	logInJButton.setText( "LOG IN" );
    	logInJButton.setBounds( 10,325,150,30 );
    	logInJButton.setVisible(true);
    	contentPane.add( logInJButton );
    	logInJButton.addActionListener(
         
         new ActionListener() 
         {
            
             public void actionPerformed ( ActionEvent event )
             {
              try{
            		MasterController.openLogIN(); 
            	 }
            	 catch(Exception x)
            	 {
            		 JOptionPane.showMessageDialog(null, "Please fill out everything with sufficent things",
							 "ERROR", JOptionPane.ERROR_MESSAGE);
            	 }
             }

         } 

      ); 
	
	//window stuff
	setVisible(true);
	setSize(300,400);
	setTitle("Set Up screen");
}	
}
