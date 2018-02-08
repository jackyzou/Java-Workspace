import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EditProfile extends JFrame  // makes class
{

	
	private Container contentPane;
	
	private JPanel profileEditJPanel;
	private JLabel userNameJL;
	private JTextField userNameJTF;
	private JLabel passwordJL;
	private JTextField passwordJTF;
	private JLabel emailJL;
	private JTextField emailJTF;
	private JButton expandProfileJB;
	private JButton contrastProfileJB;
	
	
	private JPanel financialJPanel; 
	private JLabel depositJL;
	private JTextField depositJTF;
	private JLabel withdrawlJL;
	private JTextField withdrawlJTF;
	private JButton expandFinancialJB;
	private JButton contrastFinancialJB;
	
	private JButton submitJButton,homeBackPage;
	private HomePage homePage;
	private JButton transferJButton;
	private Transfer transfer;
	
	// constructs objects this is called when 
	//screenController bjhsad = new screenController();
	public EditProfile() 
	{
		createUserInterface();
	}
	
	//method
	private void createUserInterface()
	{
	
		
		//contentPane = what is in window
		contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		profileEditJPanel = new JPanel();
		profileEditJPanel.setBounds(0,0,500,630);
		profileEditJPanel.setLayout(null);
		profileEditJPanel.setBorder( new TitledBorder( "Edit Profile" ) );
		contentPane.add(profileEditJPanel);
		
		homeBackPage= new JButton();
		homeBackPage.setText( "Home" );
		homeBackPage.setBounds( 0, 650, 100, 15 );
		homeBackPage.setVisible(true);
		contentPane.add( homeBackPage );
		homeBackPage.addActionListener(
			         
			         new ActionListener() 
			         {
			            
			             public void actionPerformed ( ActionEvent event )
			             {
			            	
			            	 
			            	 int x = JOptionPane.showConfirmDialog(null, 
			         				" Are you Sure you want to leave this page? ", " Go back to HomePage ", JOptionPane.YES_NO_CANCEL_OPTION);
			         		
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
			         			 dispose(); 
			         			//Means Yes
			         			System.out.print("Yes");
			         		}
			            	 
			             }

			         } 
			         
			      ); 
		
		userNameJL = new JLabel("New User Name: ");
		userNameJL.setBounds(10,65,150,30);
		userNameJL.setForeground(Color.BLACK);
		profileEditJPanel.add(userNameJL);
		
		userNameJTF = new JTextField();
		userNameJTF.setBounds(120,65,70,30);
		userNameJTF.setEditable(true);
		profileEditJPanel.add(userNameJTF);
		userNameJTF.addMouseListener(new MouseAdapter(){
	          
	          public void mouseClicked(MouseEvent e)
	          {
	        	  userNameJTF.setBounds(120,65,150,30);
	        	  emailJTF.setBounds(120,180,70,30);
	        	  passwordJTF.setBounds(120,110,70,30);
	        	  withdrawlJTF.setBounds(120,110,70,30);
	        	  depositJTF.setBounds(120,65,70,30);
	          }
	          
	        }
		);
		
		passwordJL = new JLabel("New Password:");
		passwordJL.setBounds(10,110,150,30);
		passwordJL.setForeground(Color.BLACK);
		profileEditJPanel.add(passwordJL);
		
		passwordJTF = new JTextField();
		passwordJTF.setBounds(120,110,70,30);
		passwordJTF.setEditable(true);
		profileEditJPanel.add(passwordJTF);
		passwordJTF.addMouseListener(new MouseAdapter(){
	          
	          public void mouseClicked(MouseEvent e)
	          {
	        	  passwordJTF.setBounds(120,110,150,30);
	        	  emailJTF.setBounds(120,180,70,30);
	        	  userNameJTF.setBounds(120,65,70,30);
	        	  withdrawlJTF.setBounds(120,110,70,30);
	        	  depositJTF.setBounds(120,65,70,30);
	          }
	          
	        }
		);
		
		
		emailJL = new JLabel("New Email:");
		emailJL.setBounds(10,180,150,30);
		emailJL.setForeground(Color.BLACK);
		profileEditJPanel.add(emailJL);
		
		emailJTF = new JTextField();
		emailJTF.setBounds(120,180,70,30);
		emailJTF.setEditable(true);
		profileEditJPanel.add(emailJTF);
		emailJTF.addMouseListener(new MouseAdapter(){
	          
	          public void mouseClicked(MouseEvent e)
	          {
	        	  emailJTF.setBounds(120,180,150,30);
	        	  passwordJTF.setBounds(120,110,70,30);
	        	  userNameJTF.setBounds(120,65,70,30);
	        	  withdrawlJTF.setBounds(120,110,70,30);
	        	  depositJTF.setBounds(120,65,70,30);
	          }
	          
	        }
		);
		
		
		expandProfileJB = new JButton();
		expandProfileJB.setText( "Expand" );
	    expandProfileJB.setBounds( 350, 580, 96, 24 );
	    profileEditJPanel.add( expandProfileJB );
	    expandProfileJB.addActionListener(
	         
	         new ActionListener() 
	         {
	            
	             public void actionPerformed ( ActionEvent event )
	             {
	            	 financialJPanel.setVisible(false);
	            	 profileEditJPanel.setBounds(0, 0, 1200, 800);
	            	 contrastProfileJB.setVisible(true);
	            	 expandProfileJB.setVisible(false);
	             }

	         } 

	      ); 
	    
	    contrastProfileJB = new JButton();
	    contrastProfileJB.setText( "contrast" );
	    contrastProfileJB.setBounds( 990, 680, 100, 30 );
	    contrastProfileJB.setVisible(false);
	    profileEditJPanel.add( contrastProfileJB );
	    contrastProfileJB.addActionListener(
	         
	         new ActionListener() 
	         {
	            
	             public void actionPerformed ( ActionEvent event )
	             {
	            	 financialJPanel.setVisible(true);
	            	 profileEditJPanel.setBounds(0,0,500,630);
	            	 contrastProfileJB.setVisible(false);
	            	 expandProfileJB.setVisible(true);
	             }

	         } 

	      ); 
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		financialJPanel = new JPanel();
		financialJPanel.setBounds(520,0,500, 630);
		financialJPanel.setLayout(null);
		financialJPanel.setBorder( new TitledBorder( "Edit Financials" ) );
		contentPane.add(financialJPanel);
	
		depositJL = new JLabel("New Deposit:");
		depositJL.setBounds(10,65,150,30);
		depositJL.setForeground(Color.BLACK);
		financialJPanel.add(depositJL);
		
		depositJTF = new JTextField();
		depositJTF.setBounds(120,65,70,30);
		depositJTF.setEditable(true);
		financialJPanel.add(depositJTF);
		depositJTF.addMouseListener(new MouseAdapter(){
	          
	          public void mouseClicked(MouseEvent e)
	          {
	        	  depositJTF.setBounds(120,65,150,30);
	        	  emailJTF.setBounds(120,180,70,30);
	        	  passwordJTF.setBounds(120,110,70,30);
	        	  userNameJTF.setBounds(120,65,70,30);
	        	  withdrawlJTF.setBounds(120,110,70,30);
	          }
	          
	        }
		);
		
		withdrawlJL = new JLabel("New Withdraw:");
		withdrawlJL.setBounds(10,110,150,30);
		withdrawlJL.setForeground(Color.BLACK);
		financialJPanel.add(withdrawlJL);
		
		withdrawlJTF = new JTextField();
		withdrawlJTF.setBounds(120,110,70,30);
		withdrawlJTF.setEditable(true);
		financialJPanel.add(withdrawlJTF);
		withdrawlJTF.addMouseListener(new MouseAdapter(){
	          
	          public void mouseClicked(MouseEvent e)
	          {
	        	  withdrawlJTF.setBounds(120,110,150,30);
	        	  emailJTF.setBounds(120,180,70,30);
	        	  passwordJTF.setBounds(120,110,70,30);
	        	  userNameJTF.setBounds(120,65,70,30);
	        	  depositJTF.setBounds(120,65,70,30);
	          }
	          
	        }
		);
		
		expandFinancialJB = new JButton();
		expandFinancialJB.setText( "Expand" );
		expandFinancialJB.setBounds( 350, 580, 96, 24 );
		financialJPanel.add( expandFinancialJB );
	    expandFinancialJB.addActionListener(
	         
	         new ActionListener() 
	         {
	            
	             public void actionPerformed ( ActionEvent event )
	             {
	            	 profileEditJPanel.setVisible(false);
	            	 financialJPanel.setBounds(0, 0, 1200, 800);
	            	 contrastFinancialJB.setVisible(true);
	            	 expandFinancialJB.setVisible(false);
	             }

	         } 

	      ); 
	    
	    contrastFinancialJB = new JButton();
	    contrastFinancialJB.setText( "contrast" );
	    contrastFinancialJB.setBounds( 990, 680, 100, 30 );
	    contrastFinancialJB.setVisible(false);
	    financialJPanel.add( contrastFinancialJB );
	    contrastFinancialJB.addActionListener(
	         
	         new ActionListener() 
	         {
	            
	             public void actionPerformed ( ActionEvent event )
	             {
	            	 profileEditJPanel.setVisible(true);
	            	 financialJPanel.setBounds(520,0,500, 630);
	            	 contrastFinancialJB.setVisible(false);
	            	 expandFinancialJB.setVisible(true);
	             }

	         } 

	      ); 
		
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	    submitJButton = new JButton();
	    submitJButton.setText( "Submit" );
	    submitJButton.setBounds( 990, 680, 100, 30 );
	    submitJButton.setVisible(true);
	    contentPane.add( submitJButton );
	    submitJButton.addActionListener(
	         
	         new ActionListener() 
	         {
	            
	             public void actionPerformed ( ActionEvent event )
	             {
	            	
	            	 setVisible(false);
	            	 homePage.toFront();
	       
	            	 
	            	 String emailA = emailJTF.getText();
	            	 String username = userNameJTF.getText();
	            	 String password = passwordJTF.getText();
	            	 
	            	 Double depositA = Double.parseDouble(depositJTF.getText());
	            	 Double withdrawA = Double.parseDouble(withdrawlJTF.getText());
	            	 
	            	 homePage.changeUserName(username);
	            	 homePage.changeEmail(emailA);
	            	 homePage.calculateBallance(depositA, withdrawA);
	            	 
	            	 //close this window
	             }

	         } 

	      ); 
	    transferJButton = new JButton("transfer");
	    transferJButton.setBounds(100,300, 200, 20);
	    financialJPanel.add(transferJButton);
	    transferJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	 transfer = new Transfer();
		             }

		         } 

		      ); 
		
		
		
		//window stuff
		setVisible(true);
		setSize(1100,770);
		setTitle("Operation");
		

	}
}
