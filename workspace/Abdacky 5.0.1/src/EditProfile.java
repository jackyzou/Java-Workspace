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
	
	private JPanel loanJPanel;
	private JCheckBox mortgageRB;
	private JCheckBox otherLoanRB;
	private JLabel intrestMJLabel;
	private JLabel intrestLJLabel;
	
	private JLabel loanAmontJLabel;
	private JTextField loanAmountJTextField;
	private JTextField mortgageJTextField;
	private JLabel creditJLabel;
	private JTextField creditJTextField;
	private JButton lSubmitJButton;
	
	private JButton homeBackPage;
	private JButton fSubmitJButton;
	private JButton pSubmitJButton;
	private HomePage homePage;
	
	private JButton transferJButton;
	private JLabel transferJLabel;
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
		profileEditJPanel.setBounds(10,10,330,330);
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
		            				" Are you sure you want to go back to the home page? ", " Go back to HomePage ", JOptionPane.YES_NO_CANCEL_OPTION);
		         		
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
		         			homePage = new HomePage();
		         			
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
	        	  withdrawlJTF.setBounds(120,85,70,30);
	        	  depositJTF.setBounds(120,40,70,30);
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
	        	  withdrawlJTF.setBounds(120,85,70,30);
	        	  depositJTF.setBounds(120,40,70,30);
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
	        	  withdrawlJTF.setBounds(120,85,70,30);
	        	  depositJTF.setBounds(120,40,70,30);
	          }
	          
	        }
		);
		
		
		expandProfileJB = new JButton();
		expandProfileJB.setText( "Expand" );
	    expandProfileJB.setBounds( 220, 280, 96, 24 );
	    profileEditJPanel.add( expandProfileJB );
	    expandProfileJB.addActionListener(
	         
	         new ActionListener() 
	         {
	            
	             public void actionPerformed ( ActionEvent event )
	             {
	            	 loanJPanel.setVisible(false);
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
	            	 loanJPanel.setVisible(true);
	            	 financialJPanel.setVisible(true);
	            	 profileEditJPanel.setBounds(0,0,330,330);
	            	 contrastProfileJB.setVisible(false);
	            	 expandProfileJB.setVisible(true);
	             }

	         } 

	      ); 
	   
	   
		
		
//////////////////////////////////////////////Financials///////////////////////////////////////////////////////////////////		
		financialJPanel = new JPanel();
		financialJPanel.setBounds(520,10,450, 250);
		financialJPanel.setLayout(null);
		financialJPanel.setBorder( new TitledBorder( "Edit Financials" ) );
		contentPane.add(financialJPanel);
	
		depositJL = new JLabel("New Deposit:");
		depositJL.setBounds(10,40,150,30);
		depositJL.setForeground(Color.BLACK);
		financialJPanel.add(depositJL);
		
		depositJTF = new JTextField();
		depositJTF.setBounds(120,40,70,30);
		depositJTF.setEditable(true);
		financialJPanel.add(depositJTF);
		depositJTF.addMouseListener(new MouseAdapter(){
	          
	          public void mouseClicked(MouseEvent e)
	          {
	        	  depositJTF.setBounds(120,40,150,30);
	        	  emailJTF.setBounds(120,180,70,30);
	        	  passwordJTF.setBounds(120,110,70,30);
	        	  userNameJTF.setBounds(120,65,70,30);
	        	  withdrawlJTF.setBounds(120,85,70,30);
	          }
	          
	        }
		);
		
		withdrawlJL = new JLabel("New Withdraw:");
		withdrawlJL.setBounds(10,85,150,30);
		withdrawlJL.setForeground(Color.BLACK);
		financialJPanel.add(withdrawlJL);
		
		withdrawlJTF = new JTextField();
		withdrawlJTF.setBounds(120,85,70,30);
		withdrawlJTF.setEditable(true);
		financialJPanel.add(withdrawlJTF);
		withdrawlJTF.addMouseListener(new MouseAdapter(){
	          
	          public void mouseClicked(MouseEvent e)
	          {
	        	  withdrawlJTF.setBounds(120,85,150,30);
	        	  emailJTF.setBounds(120,180,70,30);
	        	  passwordJTF.setBounds(120,110,70,30);
	        	  userNameJTF.setBounds(120,65,70,30);
	        	  depositJTF.setBounds(120,40,70,30);
	          }
	          
	        }
		);
		
		expandFinancialJB = new JButton();
		expandFinancialJB.setText( "Expand" );
		expandFinancialJB.setBounds(330, 210, 95, 30);
		financialJPanel.add( expandFinancialJB );
	    expandFinancialJB.addActionListener(
	         
	         new ActionListener() 
	         {
	            
	             public void actionPerformed ( ActionEvent event )
	             {
	            	 homeBackPage.setVisible(false);
	            	 profileEditJPanel.setVisible(false);
	            	 loanJPanel.setVisible(false);
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
	            	 homeBackPage.setVisible(true);
	            	 loanJPanel.setVisible(true);
	            	 profileEditJPanel.setVisible(true);
	            	 financialJPanel.setBounds(520,0,450, 250);
	            	 contrastFinancialJB.setVisible(false);
	            	 expandFinancialJB.setVisible(true);
	             }

	         } 

	      ); 
	    
	    
	    transferJLabel = new JLabel();
	    transferJLabel.setText("Make a Transfer: ");
	    transferJLabel.setBounds(10,125,150,30);
	    financialJPanel.add(transferJLabel);
	    
	    
	    transferJButton = new JButton("Click to Transfer");
	    transferJButton.setBounds(120,125,150,30);
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
	    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    loanJPanel = new JPanel();
	    loanJPanel.setBounds(300,400,650, 250);
	    loanJPanel.setLayout(null);
	    loanJPanel.setBorder( new TitledBorder( "Make a Loan" ) );
		contentPane.add(loanJPanel);
		
	    loanJLabel = new JLabel();
	    loanJLabel.setText( "Make A loan: " );
	    loanJLabel.setFont(new Font("Serif", Font.BOLD, 18));
	    loanJLabel.setBounds( 15,30,200,30);
	    loanJLabel.setVisible(true);
	    loanJPanel.add( loanJLabel );
	    
	    			///////////////////////////////////////////	////////////////////////////
	    

		otherLoanRB = new JCheckBox("Reguler loan:");
	    otherLoanRB.setBounds(15,90,150,30);
	    otherLoanRB.setFont(new Font("Serif", Font.BOLD, 14));		    
	    loanJPanel.add(otherLoanRB);
	    otherLoanRB.addActionListener( 
		    	      
	            new ActionListener() 
	            {
		              public void actionPerformed( ActionEvent event )
		              {
		            	  mortgageRB.setSelected(false);
		            	  intrestLJLabel.setVisible(true);
		           	   
		            	  intrestMJLabel.setVisible(false);
		           	   
		            	  if(!(otherLoanRB.isSelected()))
		            	  {
		            		  intrestLJLabel.setVisible(false);
		            	  }
		               }
		               
		            } 
		            
		         ); 
		    
		    
	    intrestLJLabel = new JLabel();
	    intrestLJLabel.setText("The intrest rate of a reguler loan is 1%");
	    intrestLJLabel.setBounds(15,130,250,30);
	    intrestLJLabel.setVisible(false);
	    loanJPanel.add(intrestLJLabel);
		    
		    
		    ///////////////////////// 															/////////////////////////
		    
	    

	    
	    mortgageRB = new JCheckBox("Mortgage:");
	    mortgageRB.setBounds(410,90,150,30);
	    mortgageRB.setFont(new Font("Serif", Font.BOLD, 14));
	    loanJPanel.add(mortgageRB);
	    mortgageRB.addActionListener( 
	    	      
	            new ActionListener() 
	            {
	               public void actionPerformed( ActionEvent event )
	               {
	            	   otherLoanRB.setSelected(false);
	            	   intrestMJLabel.setVisible(true);
	            	   
	            	   intrestLJLabel.setVisible(false);
	            	   
	            	   if(!(mortgageRB.isSelected()))
	            	   {
	            		   intrestMJLabel.setVisible(false);
	            	   }
	               }
	               
	            } 
	            
	         ); 
	    
	    intrestMJLabel = new JLabel();
	    intrestMJLabel.setText("The intrest rate for mortgage is 2%");
	    intrestMJLabel.setBounds(410,130,250,30);
	    intrestMJLabel.setVisible(false);
	    loanJPanel.add(intrestMJLabel);
	    
	    
	    /////////////																	//////////
	   
	   
	    loanAmountJLabel = new JLabel();
	    loanAmountJLabel.setText( "Loan Amount: " );
	    loanAmountJLabel.setBounds( 130,30,200,30);
	    loanAmountJLabel.setVisible(true);
	    loanJPanel.add( loanAmountJLabel );
	    
	    
	    
	    loanJTextField = new JTextField();
	    loanJTextField.setBounds( 220,30,100,30 );
	    loanJTextField.setVisible(true);
	    loanJTextField.setEditable(true);
	    loanJPanel.add( loanJTextField );
	    
	    
	    creditJLabel = new JLabel();
	    creditJLabel.setBounds(385,30,150,30);
	    creditJLabel.setText("Enter your credit score:");
	    loanJPanel.add(creditJLabel);
	    
	    creditJTextField = new JTextField();
	    creditJTextField.setBounds(530,30,100,30);
	    loanJPanel.add(creditJTextField);

		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	    fSubmitJButton = new JButton();
	    fSubmitJButton.setText( "Submit Fiancial Changes" );
	    fSubmitJButton.setBounds( 20, 180, 250, 30 );
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
	    pSubmitJButton.setBounds( 10, 240, 200, 30 );
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
		            	 			transfer.setVisible(true);
		            	 			transfer.changeName(username);
		            	 			//dispose();
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
	    
	    lSubmitJButton = new JButton();
	    lSubmitJButton.setText("Submit loans");
	    lSubmitJButton.setBounds( 220,180,150,30);
	    loanJPanel.add(lSubmitJButton);
	    lSubmitJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	try{
		            		double amount = Double.parseDouble(loanJTextField.getText());
		            		double creditScore = Double.parseDouble(creditJTextField.getText());
		            	
		            		if(creditScore > 500)
		            		{
		            			if(mortgageRB.isSelected())
		            			{
		            				double total = amount + (amount * 0.2);
		            		
		            				JOptionPane.showMessageDialog(null, "The total is " + total + ".",
		            						"Total", JOptionPane.PLAIN_MESSAGE);
		            			}
		            			else if(otherLoanRB.isSelected())
		            			{
		            				double total = amount + (amount * 0.1);
			            		
		            				JOptionPane.showMessageDialog(null, "The total is " + total + ".",
	    							 "Total", JOptionPane.PLAIN_MESSAGE);
		            			}
		            			else
		            			{
		            				JOptionPane.showMessageDialog(null, "Please select the type of loan",
			    							 "ERROR", JOptionPane.ERROR_MESSAGE);
		            			}
		            		}
		            		else
		            		{
	    					 JOptionPane.showMessageDialog(null, "Your credit rate is too low, Sorry.",
	    							 "Problem", JOptionPane.ERROR_MESSAGE);
		            		}
		             
		             }
		         
		             catch(Exception x)
		             {
		            	 JOptionPane.showMessageDialog(null, "ERROR",
    							 "ERRor", JOptionPane.ERROR_MESSAGE);
		             }
		             
		             }
		         } 

		      ); 
	    
		
		
		
		//window stuff
		setVisible(true);
		setSize(1100,770);
		setTitle("Operation");
		

	}
}
