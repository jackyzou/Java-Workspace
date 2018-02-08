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
	private JLabel loanJLabel;
	private JLabel loanAmountJLabel;
	private JTextField loanJTextField;
	private JButton expandFinancialJB;
	private JButton contrastFinancialJB;
	
	
	private JButton homeBackPage;
	private JButton fSubmitJButton;
	private JButton pSubmitJButton;
	private HomePage homePage;
	
	private JButton transferJButton;
	private Transfer transfer;
	private storage myStorage;
	

	
	// constructs objects this is called when 
	//screenController bjhsad = new screenController();
	public EditProfile() 
	{
		createUserInterface();
	}
	
	public void getOldPersonal(String username, String email)
	{
		String USERNAME = username;
		String EMAIL = email;
		
		 homePage.changeUserName(USERNAME);
    	 homePage.changeEmail(EMAIL); 
    	 transfer.changeUN(USERNAME);
		
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
		homeBackPage.setText( "Exit" );
		homeBackPage.setBounds( 0, 650, 100, 15 );
		homeBackPage.setVisible(true);
		contentPane.add( homeBackPage );
		homeBackPage.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	
		            	 
		            	 int x = JOptionPane.showConfirmDialog(null, 
		         				" Are you Sure you want to exit? ", " Go back to HomePage ", JOptionPane.YES_NO_CANCEL_OPTION);
		         		
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
		         			System.exit(0);
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
	    
	    
	    transferJButton = new JButton("Make a Transfer");
	    transferJButton.setBounds(260,70, 150, 60);
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
	    
	    
	    
	   
	    
	    loanJLabel = new JLabel();
	    loanJLabel.setText( "Make A loan: " );
	    loanJLabel.setFont(new Font("Serif", Font.BOLD, 17));
	    loanJLabel.setBounds( 30,250,200,30);
	    loanJLabel.setVisible(true);
	    financialJPanel.add( loanJLabel );
	    
	    loanAmountJLabel = new JLabel();
	    loanAmountJLabel.setText( "Loan Amount: " );
	    loanAmountJLabel.setBounds( 10,290,200,30);
	    loanAmountJLabel.setVisible(true);
	    financialJPanel.add( loanAmountJLabel );
	    
	    loanJTextField = new JTextField();
	    loanJTextField.setBounds( 110,290,100,30);
	    loanJTextField.setVisible(true);
	    financialJPanel.add( loanJTextField );
	    loanJTextField.addMouseListener(
	    		  new MouseAdapter()
	    		  {
	    			  public void mouseClicked(MouseEvent e)
	    			  {
	    				  try
	    				  {
	    					String creditString = JOptionPane.showInputDialog("What is your credit score");
	    				  
	    					 double credit = Double.parseDouble(creditString);
	    					 
	    					 if(credit > 500)
	    					 {
	    						 String amount = JOptionPane.showInputDialog("Input the amount of the loan");
	    						 loanJTextField.setText(amount);
	    					 }
	    					 else
	    					 {
	    						 JOptionPane.showMessageDialog(null, "Your credit rate is too low, Sorry.",
	    								 "Problem", JOptionPane.ERROR_MESSAGE);
	    					 }
	    				  }
	    				  catch(Exception x)
	    				  {
	    					  
	    				  }
	    				  
	    			  }
	    		  }
	    		  );
	    
	    
		
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	    fSubmitJButton = new JButton();
	    fSubmitJButton.setText( "Submit Fiancial Changes" );
	    fSubmitJButton.setBounds( 100, 380, 250, 30 );
	    fSubmitJButton.setVisible(true);
	    financialJPanel.add( fSubmitJButton );
	    fSubmitJButton.addActionListener(
	         
	         new ActionListener() 
	         {
	            
	             public void actionPerformed ( ActionEvent event )
	             {
	            	 
	            	 String depositS = depositJTF.getText();
	            	 String withdrawlS =  withdrawlJTF.getText();
	            	 String loanAmountS = loanJTextField.getText();
	            	 
	            	 double deposit = Double.parseDouble(depositJTF.getText());
	            	 double withdrawl =  Double.parseDouble(withdrawlJTF.getText());
	            	 double loanAmount = Double.parseDouble(loanJTextField.getText());
	            	
	            	 
	            	 if(depositS.equals("") || withdrawlS.equals("") || loanAmountS.equals(""))
	            	 {

		            	 	int x = JOptionPane.showConfirmDialog(null, 
		            	 			" Are you Sure you do want to leave that blank?", " Hmmm ", 
		            	 			JOptionPane.YES_NO_OPTION);
		         		
		            	 
		         		
		            	 		if(x == 1)
		            	 		{		
		            	 			//Means NO
		            	 			System.out.print("NO");
		            	 			//stay on the edit screen
		         			
		            	 		}
		         		
		            	 		else 
		            	 		{
		            	 			//Means Yes
		            	 			System.out.print("Yes");
		            	 			
		            	 		    homePage = new HomePage();
		        	                homePage.setVisible(true);
		            	 			homePage.calculateBallance(deposit,withdrawl);
		            	 		}
		            	 
	            		
	            	 }
	            	 

	            	 else
	            	 {
	            		homePage = new HomePage();
		            	homePage.setVisible(true);
		            	homePage.calculateBallance(deposit,withdrawl);
	            	 }
	           
 
	            		 //close this window
	             }

	         } 

	      ); 
	    
	    pSubmitJButton = new JButton();
	    pSubmitJButton.setText( "Submit Personal Changes" );
	    pSubmitJButton.setBounds( 100, 380, 250, 30 );
	    pSubmitJButton.setVisible(true);
	    profileEditJPanel.add( pSubmitJButton );
	    pSubmitJButton.addActionListener(
	         
	         new ActionListener() 
	         {
	            
	             public void actionPerformed ( ActionEvent event )
	             {
	            	 
	            	 
	            	
	            	 
	            	 String emailA = emailJTF.getText();
	            	 String username = userNameJTF.getText();
	            	 String password = passwordJTF.getText();
	            	
	            	

	            	 
	            	 if(emailA.equals("") || username.equals(""))
	            	 {

		            	 	int x = JOptionPane.showConfirmDialog(null, 
		            	 			" Are you Sure you do want to leave that blank?", " Hmmm ", 
		            	 			JOptionPane.YES_NO_OPTION);
		         		
		            	 
		         		
		            	 		if(x == 1)
		            	 		{		
		            	 			//Means NO
		            	 			System.out.print("NO");
		            	 			//stay on the edit screen
		         			
		            	 		}
		         		
		            	 		else 
		            	 		{
		            	 			//Means Yes
		            	 			System.out.print("Yes");
		            	 			
		            	 		    homePage = new HomePage();
		        	                homePage.setVisible(true);
		            	 			homePage.changeEmail(emailA);
		            	 			homePage.changeUserName(username);
		            	 			
		            	 			transfer = new Transfer();
		            	 			transfer.setVisible(false);
		            	 			transfer.changeName(username);
		            	 			dispose();
		            	 		}
		            	 
	            		
	            	 }
	            	 

	            	 else
	            	 {
	            		homePage = new HomePage();
		            	homePage.setVisible(true);
         	 			homePage.changeEmail(emailA);
         	 			homePage.changeUserName(username);
         	 			
         	 			transfer = new Transfer();
        	 			transfer.setVisible(false);
        	 			transfer.changeName(username);
         	 			dispose();
	            	 }
	           
 
	            		 //close this window
	             }

	         } 

	      ); 
		
		
		
		//window stuff
		setVisible(true);
		setSize(1100,770);
		setTitle("Operation");
		

	}
}
