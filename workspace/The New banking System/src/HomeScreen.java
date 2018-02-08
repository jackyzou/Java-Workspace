import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HomeScreen extends JFrame {

	
	private JButton createJButton, loginJButton,helpJButton;
	private JLabel accountNumberJLabel, passwordJLabel, logoJLabel,thumbJLabel,SIGNJLabel,l1,l2,l3,l4,l5,l6;
	private JLabel hintforbalance,hintforname,hintforaddress,hintforphone,hintforemail,hintforpassword,hintfornewpwd;
	private JTextField accountNumberJTextField;
	private JPasswordField passwordJPasswordField,newPasswordJPasswordField,retypeNewPasswordJPasswordField;
	private JCheckBox loginJCheckBox;
	private JTextField nameJTextField,  emailJTextField,  phoneJTextField,  addressJTextField, startBalanceJTextField;
	private JRadioButton checkingJRadioButton, savingJRadioButton;
	private boolean flag = false;
	private boolean type = null != null;
	
	private ArrayList accountList;
	Account a = new Account();
	Verification v = new Verification();
	 AccountHomePage ahp = new AccountHomePage();
	 String name;
	 private String  email, phone, address,password;
		private String balance;
		private String sort;
		private JLabel grass;
		private JLabel sky;

	
	public HomeScreen()
	{
		 createUserInterface();
		 
	}
	
	
	
	private void createUserInterface()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		//set up accountNumberJLabel
		
		l1 = new JLabel("*");
		l1.setBounds(40,290,15,15);
		l1.setForeground(Color.red);
		l1.setVisible(flag);
		contentPane.add( l1 );
		
		l2 = new JLabel("*");
		l2.setBounds(40,340,15,15);
		l2.setForeground(Color.red);
		l2.setVisible(flag);
		contentPane.add( l2 );
		
		l3 = new JLabel("*");
		l3.setBounds(40,390,15,15);
		l3.setForeground(Color.red);
		l3.setVisible(flag);
		contentPane.add( l3 );
		
		l4 = new JLabel("*");
		l4.setBounds(40,440,15,15);
		l4.setForeground(Color.red);
		l4.setVisible(flag);
		contentPane.add( l4 );
		
		l5 = new JLabel("*");
		l5.setBounds(240,390,15,15);
		l5.setForeground(Color.red);
		l5.setVisible(flag);
		contentPane.add( l5 );
		
		l6 = new JLabel("*");
		l6.setBounds(240,340,15,15);
		l6.setForeground(Color.red);
		l6.setVisible(flag);
		contentPane.add( l6 );
		
		
		
		hintforbalance = new JLabel("Enter a starting balance");
		hintforbalance.setBounds(255,375,185,40);
		contentPane.add( hintforbalance );
		
		hintforname = new JLabel("Enter a Name");
		hintforname.setBounds(55,275,185,40);
		contentPane.add( hintforname );
		
		hintforaddress= new JLabel("Enter an address");
		hintforaddress.setBounds(55,425,185,40);
		contentPane.add( hintforaddress );
		
		hintforphone= new JLabel("Enter a phone number");
		hintforphone.setBounds(55,375,185,40);
		contentPane.add( hintforphone );
		
		hintforemail= new JLabel("Enter an email address");
		hintforemail.setBounds(55,325,185,40);
		contentPane.add( hintforemail );
		
		
		hintforpassword= new JLabel("Enter a password");
		hintforpassword.setBounds(255,275,185,40);
		contentPane.add( hintforpassword );
		
		hintfornewpwd= new JLabel("Retype in your password");
		hintfornewpwd.setBounds(255,325,185,40);
		contentPane.add( hintfornewpwd );
		
		
		
		accountNumberJLabel = new JLabel("Enter your Name:");
		accountNumberJLabel.setBounds(260,-5,200,50);
		contentPane.add( accountNumberJLabel );
		
		passwordJLabel = new JLabel("Enter Password:");
		passwordJLabel.setBounds(270,25,200,50);
		contentPane.add( passwordJLabel );
		
		accountNumberJTextField = new JTextField();
		accountNumberJTextField.setBounds(400,10,100,20);
		contentPane.add( accountNumberJTextField );
		
		passwordJPasswordField = new JPasswordField();
		passwordJPasswordField.setBounds(400,40,100,20);
		contentPane.add( passwordJPasswordField );
		
		loginJButton = new JButton(new ImageIcon("QQ20130403-1.png"));
		loginJButton.setBounds(440,70,59,30);
		contentPane.add( loginJButton );
		loginJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  loginJButtonActionPerformed( event );
		
	    
	    			  }

					private void loginJButtonActionPerformed(ActionEvent event) 
					{
						name = accountNumberJTextField.getText();
						String pw = passwordJPasswordField.getText();
						if(pw.equals(""))
						{
							 JOptionPane.showMessageDialog(null,"Please enter your ID number and password","ERROR",
	    	    					  JOptionPane.ERROR_MESSAGE);
						}
						else if(name.equals(""))
						{
							 JOptionPane.showMessageDialog(null,"Please enter your ID number","ERROR",
	    	    					  JOptionPane.ERROR_MESSAGE);
							
						}
						else
						{
							try {
								
										
							
								a.readInfofromAcc(name);
								readInfo(name);	
								
								setVisible(false);
								ahp.setVisible(true);
								
							    } 
							catch (IOException e) {

								 JOptionPane.showMessageDialog(null, "NO SUCH DIRECTORY",
										 "ERROR", JOptionPane.ERROR_MESSAGE);
									setVisible(true);
									ahp.setVisible(false);
							}
							
						}
						
					}
	    				  
					
					}	  
	    		  );
		
		
		loginJCheckBox = new JCheckBox("Keep me logged in");
		loginJCheckBox.setBounds(280,70,150,30);
		contentPane.add( loginJCheckBox );
		
		
		checkingJRadioButton = new JRadioButton("Checking Account");
		checkingJRadioButton.setBounds(65,225,185,40);
		contentPane.add( checkingJRadioButton );
		checkingJRadioButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  checkingJRadioButtonPerformed( event );
		
	    
	    			  }

					private void checkingJRadioButtonPerformed(ActionEvent event)
					{
						savingJRadioButton.setSelected(false);
						type = true;
	
					}

	    		  }
	    			  );
		
		savingJRadioButton = new JRadioButton("Saving Account");
		savingJRadioButton.setBounds(250,225,185,40);
		contentPane.add( savingJRadioButton );
		savingJRadioButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  savingJRadioButtonPerformed( event );
		
	    
	    			  }

					private void savingJRadioButtonPerformed(ActionEvent event) {
						checkingJRadioButton.setSelected(false);
						type = false;

					}

	    		  }
	    			  );
		
		
		
		
		
		logoJLabel = new JLabel(); 
		logoJLabel.setIcon(new ImageIcon("rps.png"));
		logoJLabel.setBounds(-50, -80, 270, 200);
		logoJLabel.setHorizontalAlignment( JLabel.CENTER);
	    contentPane.add( logoJLabel );
	    
	    thumbJLabel = new JLabel(); 
	    thumbJLabel.setIcon(new ImageIcon("thumb.png"));
	    thumbJLabel.setBounds(30, 125, 100, 100);
	    thumbJLabel.setHorizontalAlignment( JLabel.CENTER);
	    contentPane.add( thumbJLabel );
	   
	    
	    SIGNJLabel= new JLabel(); 
	    SIGNJLabel.setIcon(new ImageIcon("signUP.png"));
	    SIGNJLabel.setBounds(40, 110, 500, 150);
	    SIGNJLabel.setHorizontalAlignment( JLabel.CENTER);
	    contentPane.add( SIGNJLabel );
	    
		
	    nameJTextField = new JTextField();
	    nameJTextField.setBounds(50,275,185,40);
		contentPane.add( nameJTextField );
		nameJTextField.addMouseListener(
				
				new MouseAdapter()
		{
	    public void mouseClicked(MouseEvent e){
	    hintforname.setText("");
	     	flag = false;
			l1.setVisible(flag);
		   }
	    
		}
				
		);	
		
		  
		
		
		emailJTextField = new JTextField();
		emailJTextField.setBounds(50,325,185,40);
			contentPane.add( emailJTextField );
		emailJTextField.addMouseListener(
				
					new MouseAdapter()
			{
		    public void mouseClicked(MouseEvent e){
		    	hintforemail.setText("");
		     	flag = false;
				l2.setVisible(flag);
			   }
		    
			}
					
			);	
		phoneJTextField= new JTextField();
		phoneJTextField.setBounds(50,375,185,40);
		contentPane.add( phoneJTextField );
		phoneJTextField.addMouseListener(
			
				new MouseAdapter()
		{
	    public void mouseClicked(MouseEvent e){
	    	hintforphone.setText("");
	     	flag = false;
			l3.setVisible(flag);
		   }
	    
		}
				
		);	
		
		addressJTextField= new JTextField();
		addressJTextField.setBounds(50,425,185,40);
		contentPane.add( addressJTextField );
		addressJTextField.addMouseListener(
			
				new MouseAdapter()
		{
	    public void mouseClicked(MouseEvent e){
	    	hintforaddress.setText("");
	     	flag = false;
			l4.setVisible(flag);
		   }
	    
		}
				
		);	
		
		newPasswordJPasswordField= new JPasswordField();
		newPasswordJPasswordField.setBounds(250,275,185,40);
		contentPane.add( newPasswordJPasswordField );
		newPasswordJPasswordField.addMouseListener(
			
				new MouseAdapter()
		{
	    public void mouseClicked(MouseEvent e){
	    	hintforpassword.setText("");
	   
		   }
	    
		}
				
		);	
		
		
		retypeNewPasswordJPasswordField= new JPasswordField();
		retypeNewPasswordJPasswordField.setBounds(250,325,185,40);
		contentPane.add( retypeNewPasswordJPasswordField );
		retypeNewPasswordJPasswordField.addMouseListener(
			
				new MouseAdapter()
		{
	    public void mouseClicked(MouseEvent e){
	    	hintfornewpwd.setText("");
	     	flag = false;
			l5.setVisible(flag);
		   }
	    
		}
				
		);	
		
		startBalanceJTextField= new JTextField();
		startBalanceJTextField.setBounds(250,375,185,40);
		contentPane.add( startBalanceJTextField );
		startBalanceJTextField.addMouseListener(
			
				new MouseAdapter()
		{
	    public void mouseClicked(MouseEvent e){
	    	hintforbalance.setVisible(false);
	    	flag = false;
			l6.setVisible(flag);
		   }
	    
		}
				
		);	
	    
	
	    createJButton = new JButton(new ImageIcon("QQ20130403-2.png"));
		createJButton.setBounds(260,425,175,40);
		createJButton.setText("Create");
		contentPane.add( createJButton );
		createJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    					 createJButtonActionPerformed( event );
		
	    
	    			  }

					private void createJButtonActionPerformed(ActionEvent event) 
					{
						String gg = newPasswordJPasswordField.getText();
						String ggg = retypeNewPasswordJPasswordField.getText();
						
						String name = nameJTextField.getText();
						String email = emailJTextField.getText();
						String phone = phoneJTextField.getText();
						String address = addressJTextField.getText();
						String balance = startBalanceJTextField.getText();
					    
						
						
						
					//////////////////////////////type of account////////////////////////////
			
						if(type == true)
						{
                          sort ="Checking Account";
                          
						}
						else
						{
							sort = "Saving Account";
						}
						
	/////////////////////check if the user type in sufficient info///////////////////
	         			if(name.equals("Click to Type in your name")|| name.equals(""))
						{
	         				flag = true;
	         				l1.setVisible(flag);
							System.out.print("work");
						}
							if(email.equals("Email Address")||email.equals(""))
							{
								flag = true;
								l2.setVisible(flag);
							}
								if(phone.equals("Phone Number")||phone.equals(""))
								{
									flag = true;
									l3.setVisible(flag);
								}
									if(address.equals("Mailing Address")||address.equals(""))
									{
										flag = true;
										l4.setVisible(flag);
									}
										if(ggg.equals("Retype your Password")||ggg.equals(""))
										{
											flag = true;
											l5.setVisible(flag);
										}
											if(startBalanceJTextField.getText().equals("Enter a starting Balance")||startBalanceJTextField.getText().equals(""))
											{
												flag = true;
												l6.setVisible(flag);
											}
	         			
	         		
				
				
					
										
						int gg1 = gg.length();
					
						if(gg1 > 15) 
						{
							  
								int k = JOptionPane.showConfirmDialog(null, 
			            				" The password should be 15 characters or less! "
										, " ERROR ", JOptionPane.YES_OPTION);
			         		
			         		//System.out.print(x);
			         		
			         		if(k == 1)
			         		{
			         			
			         			//Means NO
			         			System.out.print("NO");
			         		}
			         		
			         		else if(k == 2)
			         		{
			         			
			         			//Means Cancel
			         			System.out.print("Cancel");
			         		}
			         		else 
			         		{
	
			         			//Means Yes
			         			System.out.print("Yes");
			         			
			         		}
						}
						
						
						else if(!gg.equals(ggg))
						{

							   JOptionPane.showMessageDialog(null, "The password you typed is not the same!","ERROR",

							    	   JOptionPane.ERROR_MESSAGE);
							
							
						}
	         			else
	         			{
	         				if(flag == false)
	         				{
	         					a.setName(name);
		         				a.setEmail(email);
		         				a.setPhone(phone);
		         				a.setAddress(address);
		         				a.setPassword(ggg);
		         				a.setBalance(balance);
		         			    a.setType(sort);
		         			   
		         			    
	         				setVisible(false);
	         				a.openVerification();
	         			
	         				v.setVisible(true);

	         				 
	         		
		         				
	         				ArrayList<Account>accountList = new ArrayList<Account>(10);
	         				Account c = new Account();
	         				accountList.add(new Account(a.getName(),a.getEmail(),a.getPhone(),a.getAddress(),gg,a.getBalance(),type));
	         				accountList.add(new Account(name, email, phone, address,gg,balance,type));
	         				accountList.add(c);
	         				accountList.add(c);
	         				accountList.add(new Account());
	         				
	         				System.out.println(accountList);
		         				
	         				
	         				///////////////////////////////////Sent the Info to Verification Class/////////////////////////////////////////////////
	         				
	         				a.openVerification();
	         				v.getInfo(a.getName(), a.getEmail(), a.getPhone(), a.getAddress(),gg,a.getBalance(),a.getType());
	         				

	         				
	         				/////////Print from Account////////////
	         				 System.out.println(a.getName());
	         				 System.out.println(a.getEmail());
	         				 System.out.println(a.getAddress());
	         				 System.out.println(a.getPhone());
	         				 System.out.println(a.getType());
	         				 System.out.println(a.getBalance());
	         				
	         				}
	         				else
	         				{
	         					int e = JOptionPane.showConfirmDialog(null, 
			            				" Information not sufficient! "
										, " ERROR ", JOptionPane.CANCEL_OPTION);
	         				}
	         			}
	         		}
						
				
	
					
					
					
					
					
					}
	    				  
					
						  
	    		  );
		
	  

		
		helpJButton = new JButton();
		helpJButton.setBounds(447,445,15,15);
		helpJButton.setText("?");
		contentPane.add( helpJButton );
		helpJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    					 createJButtonActionPerformed( event );
		
	    
	    			  }

					private void createJButtonActionPerformed(ActionEvent event) {

						int x = JOptionPane.showConfirmDialog(null, 
	            				" Fill out all the information by clicking the textfield and typing. Please use '_' as a space. If you already have an account, go to the top and login. "
								, " Help ", JOptionPane.YES_NO_CANCEL_OPTION);
	         		
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
	         		
	         			
	         			//Means Yes
	         			System.out.print("Yes");
	         		}
	            	 
						
					}
	    				  
	    		  }
	    		  
	    			  
	    		  );
		   

		sky = new JLabel(new ImageIcon("cloud-background-resized3-vail-blue-sky-limo.jpg"));
		sky.setBounds(0, 0, 600, 268 );
		sky.setVisible(true);
		contentPane.add( sky );
		
		grass = new JLabel(new ImageIcon("6--603810-Green Grass On White Background. Matte Channel..jpg"));
		grass.setBounds(0, -150, 1000, 800 );
		grass.setVisible(true);
		contentPane.add( grass );
		
		
		
		
		
		setSize(500,500);
		setTitle("Welcome to RPS Bank");
		setVisible(true);
		setResizable(false);
		
	}
	
	
	public void hideInstruction()
	{
		if(flag == false)
		{
			//nameJTextField.setText("");
		}
		else
		{
		  flag = true;
		}
		
	}
	
	public void readInfo(String userN) throws IOException
	{
		
		name = userN;
		System.out.println(name);
		FileReader fstream = new FileReader(name+".txt");
		BufferedReader in = new BufferedReader(fstream);
		Scanner scan = new Scanner(in);
		
		
		String s = "";
		while(scan.hasNext())
		{
			s += scan.next() + "\n";
		}
		
		String delim = "\n";
		StringTokenizer t = new StringTokenizer(s,delim);
		ArrayList <String> list  = new ArrayList<String>();
		
		while(t.hasMoreTokens())
		{
			list.add(t.nextToken());
		}
		
		name = list.get(0);
		email = list.get(1);
		phone = list.get(2);
		balance = list.get(3);
		address = list.get(4);
		password = list.get(5);
		sort = list.get(6);
		 

		System.out.println("list 0 is: " + list.get(0));
		System.out.println("list 1 is: " + list.get(1));
		System.out.println("list 2 is: " + list.get(2));
		System.out.println("list 3 is: " + list.get(3));
		System.out.println("list 4 is: " + list.get(4));
		System.out.println("list 5 is: " + list.get(5));
		System.out.println("list 6 is: " + list.get(6));
		
		System.out.print(s);	
		
		ahp.getUserBasicInfo(name,email,phone,balance,address,password,sort);
		
		in.close();
		scan.close();
	}
	


}
