import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class storage extends JFrame{

	private Container contentPane;//object

	private EditProfile myProfile;
	
	private JTextField usernameJTF;
	private JTextField emailJTF;
	
	public storage()
	{
		createUserInterface();//this is method
	}
	
	public void setUserName(String u)
	{
		usernameJTF.setText(u);
	}
	public void setEmail(String e)
	{
		emailJTF.setText(e);
	}
	
	
	public void getUsername(String u) 
	{
		usernameJTF.setText(u);
	}
	
	public void getEmail() 
	{
		usernameJTF.setText("Fuck u guys");//blah
	}

	private void createUserInterface() {
		contentPane = getContentPane();
		contentPane.setLayout(null);
		

	
	   usernameJTF = new JTextField();
	   
	   emailJTF = new JTextField();
	      
	  
	      
	     
		
	setVisible(false);
	setSize(500,340);
	setTitle("TransferHistory");
	setLocationRelativeTo(null);
	}

}
