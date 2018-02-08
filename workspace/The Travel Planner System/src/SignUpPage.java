import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

public class SignUpPage extends JFrame {

	
private JLabel bottom,oritation,signup,thumb, map,calendar,calendar2,flight,hotel;

private JLabel thumbmap,thumbcal,thumbairhotel;

private JLabel accountNumberJLabel, passwordJLabel;	private JTextField accountNumberJTextField;	private JCheckBox loginJCheckBox;

private JButton homeJButton,helpJButton, aboutJButton, exitJButton, helpJButton1;

private JButton signUpJButton, loginJButton ;


private JTextField nameJTextField,  emailJTextField,  phoneJTextField,  addressJTextField;
private JComboBox genderJComboBox,countryJComboBox;
private JPasswordField passwordJPasswordField,newPasswordJPasswordField,retypeNewPasswordJPasswordField;
private JLabel hintforpassword,hintfornewpwd,l1,l2,l3,l4,l5;  
private JLabel nameJLabel, emailJLabel, phoneJLabel, addressJLabel, pass1, pass2,genderJLabel,countryJLabel;


Font gainFont = new Font("Tahoma", Font.PLAIN, 14);  
Font lostFont = new Font("Tahoma", Font.ITALIC, 14);


private String[] countryList = {"USA","India","Vietnam","Germany","Canada","Japan","Britain","France","China"};


/*private String[][] countryList = {{"USA", "us.png"},
								  {"India", "in.png"},
								  {"Vietnam", "vn.png"},
								  {"Germany", "de.png"},
								  {"Canada", "ca.png"},
								  {"Japan", "jp.png"},
								  {"Great Britain", "gb.png"},
								  {"France", "fr.png"}};
								  */
ImageIcon[] images;

private boolean flag = false;
private String name,email,password,phone,address,gender,country;
private boolean loginState;


	


	
	public SignUpPage()
	{
		 createUserInterface();

		 
	}
	
	public void getLoginState(boolean a)
	{
		loginState = a;
	}
	
	public void getPassword(String p)
	{
		password = p;
	}
	
	private void createUserInterface()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		l1 = new JLabel("*");
		l1.setBounds(430,288,15,15);
		l1.setForeground(Color.red);
		l1.setFont((new Font("Tahoma", Font.BOLD,20)));
		l1.setVisible(flag);
		contentPane.add( l1 );
		
		l2 = new JLabel("*");
		l2.setBounds(430,388,15,15);
		l2.setForeground(Color.red);
		l2.setFont((new Font("Tahoma", Font.BOLD,20)));
		l2.setVisible(flag);
		contentPane.add( l2 );
		
		l3 = new JLabel("*");
		l3.setBounds(430,588,15,15);
		l3.setForeground(Color.red);
		l3.setFont((new Font("Tahoma", Font.BOLD,20)));
		l3.setVisible(flag);
		contentPane.add( l3 );
		
		l4 = new JLabel("*");
		l4.setBounds(662,288,15,15);
		l4.setForeground(Color.red);
		l4.setFont((new Font("Tahoma", Font.BOLD,20)));
		l4.setVisible(flag);
		contentPane.add( l4 );
		
		l5 = new JLabel("*");
		l5.setBounds(662,388,15,15);
		l5.setForeground(Color.red);
		l5.setFont((new Font("Tahoma", Font.BOLD,20)));
		l5.setVisible(flag);
		contentPane.add( l5 );
		

		
		accountNumberJLabel = new JLabel("Enter your Name:");
		accountNumberJLabel.setBounds(610,-5,200,50);
		contentPane.add( accountNumberJLabel );
		
		passwordJLabel = new JLabel("Enter Password:");
		passwordJLabel.setBounds(620,25,200,50);
		contentPane.add( passwordJLabel );
		
		accountNumberJTextField = new JTextField();
		accountNumberJTextField.setBounds(750,10,100,20);
		contentPane.add( accountNumberJTextField );
		
		passwordJPasswordField = new JPasswordField();
		passwordJPasswordField.setBounds(750,40,100,20);
		contentPane.add( passwordJPasswordField );
		
		loginJButton = new JButton(new ImageIcon("signIn.png"));
		loginJButton.setBounds(770,67,68,30);
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
						{
							String acc = accountNumberJTextField.getText();
							String psw = passwordJPasswordField.getText();
							MasterClass.sendPassforSUP(acc);

							 if(acc.equals(""))
							{
								 JOptionPane.showMessageDialog(null,"Please enter your account number to Login","ERROR",
		    	    					  JOptionPane.ERROR_MESSAGE);
							}
							if(acc.equals("Admin"))
							{
								File MC = new File("MasterClass.java");
								try {
									java.awt.Desktop.getDesktop().edit(MC);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if(psw.equals(""))
							{
								JOptionPane.showMessageDialog(null,"Please enter your password to Login","ERROR",
		    	    					  JOptionPane.ERROR_MESSAGE);
							}
							else if ( !(psw.equals(password)))
							{
								JOptionPane.showMessageDialog(null,"The Password you typed in doesn't match. Please try again!","ERROR",
		    	    					  JOptionPane.ERROR_MESSAGE);
							}
							/*else if(loginState==true)
								{
									setVisible(false);
									System.out.print("This will be always login!");
								}
							*/
							else
							{
								
								try {
									MasterClass.readInfo(acc);
									MasterClass.openAccountHomefromSignUp();
									dispose();
									
								} catch (Exception e) 
								{
									 JOptionPane.showMessageDialog(null, "NO SUCH DIRECTORY",
											 "ERROR", JOptionPane.ERROR_MESSAGE);
								}
								
							}
						
							
						}
					}
	    				  
					
					}	  
	    		  );
		
		loginJCheckBox = new JCheckBox("Keep me logged in");
		loginJCheckBox.setBounds(620,70,150,30);
		contentPane.add( loginJCheckBox );
		
		
		
		homeJButton = new JButton(new ImageIcon("hone.png"));
		homeJButton.setBounds(35,98,93,46);
		contentPane.add( homeJButton );
		homeJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  homeJButtonActionPerformed( event );
		
	    
	    			  }

					private void homeJButtonActionPerformed(ActionEvent event) 
					{
						MasterClass.goBackHome();
					}
	    		  }
	    		  );
		
		
		aboutJButton = new JButton(new ImageIcon("about.png"));
		aboutJButton.setBounds(180,100,106,40);
		contentPane.add( aboutJButton );
		aboutJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  aboutJButtonActionPerformed( event );
		
	    
	    			  }

					private void aboutJButtonActionPerformed(ActionEvent event) 
					{
						MasterClass.about();
					}
	    		  }
	    		  );
		
		exitJButton = new JButton(new ImageIcon("exit.png"));
		exitJButton.setBounds(600,110,106,33);
		contentPane.add( exitJButton );
		exitJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  exitJButtonActionPerformed( event );
		
	    
	    			  }

					private void exitJButtonActionPerformed(ActionEvent event) 
					{
						
		

										int x = JOptionPane.showConfirmDialog(null, 
					            				"Are you sure you want to Exit? "        
												, " Exit ", JOptionPane.YES_NO_CANCEL_OPTION);
					         		
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
					         		
					         			MasterClass.exit();
					         			//Means Yes
					         			System.out.print("Yes");
					         		}
					            	 
										
									}
					    				  
					    		  }
					    		  
					    			  
					    		  );
					
	    	
		
		helpJButton = new JButton(new ImageIcon("help.png"));
		helpJButton.setBounds(716,108,81,37);
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
	            				"Welcome to TPS! To create a new account, fill in sufficient info. More info by clicking 'about' button. "        
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
		
		helpJButton1= new JButton();
		helpJButton1.setBounds(845,705,15,15);
		helpJButton1.setText("?");
		contentPane.add( helpJButton1 );
		helpJButton1.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    					 createJButtonActionPerformed( event );
		
	    
	    			  }

					private void createJButtonActionPerformed(ActionEvent event) {

						int x = JOptionPane.showConfirmDialog(null, 
	            				" Fill out all the information by clicking the textfield and typing. Please use '_' as a space. If you already have an account, go to the top and login. More Information by clicking the 'ABOUT' button. " +
	            				"Thank you!"         
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
	
		/*bottom = new JLabel(new ImageIcon("bottom "));
		bottom.setBounds(0, 500, 1024, 420 );
		bottom.setVisible(true);
		contentPane.add( bottom );
	*/ 
	  
		nameJLabel = new JLabel("Name");
		nameJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		nameJLabel.setBounds(448,260,50,30);
		contentPane.add( nameJLabel );
		
		emailJLabel = new JLabel("Email");
		emailJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		emailJLabel.setBounds(448,360,50,30);
		contentPane.add( emailJLabel );
		
		pass1 = new JLabel("Password");
		pass1.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		pass1.setBounds(448,460,150,30);
		contentPane.add( pass1 );
		
		
		pass2 = new JLabel("Retype");
		pass2.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		pass2.setBounds(448,560,170,30);
		contentPane.add( pass2 );
		
		phoneJLabel = new JLabel("Phone");
		phoneJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		phoneJLabel.setBounds(679,260,55,30);
		contentPane.add( phoneJLabel );
		
		addressJLabel = new JLabel("Address");
		addressJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		addressJLabel.setBounds(679,360,70,30);
		contentPane.add( addressJLabel );
		
		genderJLabel= new JLabel("Gender");
		genderJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		genderJLabel.setBounds(679,460,70,30);
		contentPane.add( genderJLabel );
		
		countryJLabel = new JLabel("Country");
		countryJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		countryJLabel.setBounds(679,560,90,30);
		contentPane.add( countryJLabel );
		
		hintforpassword= new JLabel();
		hintforpassword.setText("Enter a password");
		hintforpassword.setBounds(450,475,185,40);
		hintforpassword.setFont(lostFont);  
		hintforpassword.setForeground(Color.GRAY);  
		contentPane.add( hintforpassword );
		
		hintfornewpwd= new JLabel();
		hintfornewpwd.setText("Enter the password again");
		hintfornewpwd.setBounds(450,575,185,40);
		hintfornewpwd.setFont(lostFont);  
		hintfornewpwd.setForeground(Color.GRAY);  
		contentPane.add( hintfornewpwd );
		
		
	    nameJTextField = new JTextField();
	    nameJTextField.setBounds(445,275,185,40); 
		contentPane.add( nameJTextField );
		nameJTextField.setText("Enter Your Name");  
		nameJTextField.setFont(lostFont);  
		nameJTextField.setForeground(Color.GRAY); 
		nameJTextField.addFocusListener(new FocusAdapter() 
		{  
	    	   
	        
	         public void focusGained(FocusEvent e) 
	         {  
	        	
	        	 if (nameJTextField.getText().equals("Enter Your Name")) {  
	        		 nameJTextField.setText("");  
	        		 nameJTextField.setFont(gainFont);  
	               } else {  
	            	   nameJTextField.setText(nameJTextField.getText());  
	            	   nameJTextField.setFont(gainFont);  
	               }  
	        	 
	         }
	         public void focusLost(FocusEvent e) 
	         {  
	        
	        	 
	        	 if ( nameJTextField.getText().equals("Enter Your Name")|| nameJTextField.getText().length()==0) {  
	        		 nameJTextField.setText("Enter Your Name");  
	        		 nameJTextField.setFont(lostFont);  
	        		 nameJTextField.setForeground(Color.GRAY);  
	               } else {  
	            	   nameJTextField.setText(nameJTextField.getText());  
	            	   nameJTextField.setFont(gainFont);  
	            	   nameJTextField.setForeground(Color.BLACK);  
	               }  
	         }
	         
		}      
	);
		nameJTextField.addKeyListener(

		   	         new KeyAdapter() 
		   	         {
		   	            
		   	            public void keyPressed( KeyEvent event )
		   	            {
		   	            	nameJTextFieldKeyPressed( event );
		   	            }

		   	           private void nameJTextFieldKeyPressed( KeyEvent event )
		   	          {
		   	        	flag = false;
		   	        	l1.setVisible(flag);
		   	          }

		   	         } 

		   	      ); 

		
		
		  
		
		
		    emailJTextField = new JTextField("email");
		    emailJTextField.setBounds(445,375,185,40);
			contentPane.add( emailJTextField );
			emailJTextField.setText("Enter Your Email");  
			emailJTextField.setFont(lostFont);  
			emailJTextField.setForeground(Color.GRAY); 
			emailJTextField.addFocusListener(new FocusAdapter() 
			{  
		    	   
		        
		         public void focusGained(FocusEvent e) 
		         {  
		        	
		        	 if (emailJTextField.getText().equals("Enter Your Email")) {  
		        		 emailJTextField.setText("");  
		        		 emailJTextField.setFont(gainFont);  
		               } else {  
		            	   emailJTextField.setText(emailJTextField.getText());  
		            	   emailJTextField.setFont(gainFont);  
		               }  
		        	 
		         }
		         public void focusLost(FocusEvent e) 
		         {  
		        
		        	 
		        	 if ( emailJTextField.getText().equals("Enter Your Email")|| emailJTextField.getText().length()==0) {  
		        		 emailJTextField.setText("Enter Your Email");  
		        		 emailJTextField.setFont(lostFont);  
		        		 emailJTextField.setForeground(Color.GRAY);  
		               } else {  
		            	   emailJTextField.setText(emailJTextField.getText());  
		            	   emailJTextField.setFont(gainFont);  
		            	   emailJTextField.setForeground(Color.BLACK);  
		               }  
		         }
		         
			}      
		);
			emailJTextField.addKeyListener(

		   	         new KeyAdapter() 
		   	         {
		   	            
		   	            public void keyPressed( KeyEvent event )
		   	            {
		   	            	emailJTextFieldKeyPressed( event );
		   	            }

		   	           private void emailJTextFieldKeyPressed( KeyEvent event )
		   	          {
		   	        	flag = false;
		   	        	l2.setVisible(flag);
		   	          }

		   	         } 

		   	      ); 

		
		
		newPasswordJPasswordField= new JPasswordField();
		newPasswordJPasswordField.setBounds(445,475,185,40);
		contentPane.add( newPasswordJPasswordField );
		newPasswordJPasswordField.addFocusListener(new FocusAdapter() 
		{  
	    	   
	        
	         public void focusGained(FocusEvent e) 
	         {  
	        	
	        	 if (hintforpassword.getText().equals("Enter a password")) {  
	        		 hintforpassword.setText("");  
	        		 
	               } 
	        	 else {  
	            	  
	               }  
	        	 
	         }
	         public void focusLost(FocusEvent e) 
	         {  
	        
	        	 
	        	 if ( newPasswordJPasswordField.getText().length()==0) {  
	        		 hintforpassword.setText("Enter a password");  
	        		 hintforpassword.setFont(lostFont);  
	        		 hintforpassword.setForeground(Color.GRAY);  
	               } else {  
	            	  
	               }  
	         }
	         
		}      
	);	
		
		
		
		retypeNewPasswordJPasswordField= new JPasswordField();
		retypeNewPasswordJPasswordField.setBounds(445,575,185,40);
		contentPane.add( retypeNewPasswordJPasswordField );
		retypeNewPasswordJPasswordField.addFocusListener(new FocusAdapter() 
		{  
	    	   
	        
	         public void focusGained(FocusEvent e) 
	         {  
	        	
	        	 if (hintfornewpwd.getText().equals("Enter the password again")) {  
	        		 hintfornewpwd.setText("");  
	        		 
	               } 
	        	 else {  
	            	  
	               }  
	        	 
	         }
	         public void focusLost(FocusEvent e) 
	         {  
	        
	        	 
	        	 if ( retypeNewPasswordJPasswordField.getText().length()==0) {  
	        		 hintfornewpwd.setText("Enter the password again");  
	        		 hintfornewpwd.setFont(lostFont);  
	        		 hintfornewpwd.setForeground(Color.GRAY);  
	               } else {  
	            	  
	               }  
	         }
	         
		}      
	);	
		retypeNewPasswordJPasswordField.addKeyListener(

	   	         new KeyAdapter() 
	   	         {
	   	            
	   	            public void keyPressed( KeyEvent event )
	   	            {
	   	            	retypeNewPasswordJPasswordFieldKeyPressed( event );
	   	            }

	   	           private void retypeNewPasswordJPasswordFieldKeyPressed( KeyEvent event )
	   	          {
	   	        	flag = false;
	   	        	l3.setVisible(flag);
	   	          }

	   	         } 

	   	      ); 

		phoneJTextField= new JTextField("phone");
		phoneJTextField.setBounds(675,275,185,40);
		contentPane.add( phoneJTextField );
		phoneJTextField.setText("Enter Your Phone#");  
		phoneJTextField.setFont(lostFont);  
		phoneJTextField.setForeground(Color.GRAY); 
		phoneJTextField.addFocusListener(new FocusAdapter() 
		{  
	    	   
	        
	         public void focusGained(FocusEvent e) 
	         {  
	        	
	        	 if (phoneJTextField.getText().equals("Enter Your Phone#")) {  
	        		 phoneJTextField.setText("");  
	        		 phoneJTextField.setFont(gainFont);  
	               } else {  
	            	   phoneJTextField.setText(phoneJTextField.getText());  
	            	   phoneJTextField.setFont(gainFont);  
	               }  
	        	 
	         }
	         public void focusLost(FocusEvent e) 
	         {  
	        
	        	 
	        	 if ( phoneJTextField.getText().equals("Enter Your Phone#")|| phoneJTextField.getText().length()==0) {  
	        		 phoneJTextField.setText("Enter Your Phone#");  
	        		 phoneJTextField.setFont(lostFont);  
	        		 phoneJTextField.setForeground(Color.GRAY);  
	               } else {  
	            	   phoneJTextField.setText(phoneJTextField.getText());  
	            	   phoneJTextField.setFont(gainFont);  
	            	   phoneJTextField.setForeground(Color.BLACK);  
	               }  
	         }
	         
		}      
	);
		phoneJTextField.addKeyListener(

	   	         new KeyAdapter() 
	   	         {
	   	            
	   	            public void keyPressed( KeyEvent event )
	   	            {
	   	            	phoneJTextFieldJPasswordFieldKeyPressed( event );
	   	            }

	   	           private void phoneJTextFieldJPasswordFieldKeyPressed( KeyEvent event )
	   	          {
	   	        	flag = false;
	   	        	l4.setVisible(flag);
	   	          }

	   	         } 

	   	      ); 

	
		
		addressJTextField= new JTextField("address");
		addressJTextField.setBounds(675,375,185,40);
		contentPane.add( addressJTextField );
		addressJTextField.setText("Enter Your Address");  
		addressJTextField.setFont(lostFont);  
		addressJTextField.setForeground(Color.GRAY); 
		addressJTextField.addFocusListener(new FocusAdapter() 
		{  
	    	   
	        
	         public void focusGained(FocusEvent e) 
	         {  
	        	
	        	 if (addressJTextField.getText().equals("Enter Your Address")) {  
	        		 addressJTextField.setText("");  
	        		 addressJTextField.setFont(gainFont);  
	               } else {  
	            	   addressJTextField.setText(phoneJTextField.getText());  
	            	   addressJTextField.setFont(gainFont);  
	               }  
	        	 
	         }
	         public void focusLost(FocusEvent e) 
	         {  
	        
	        	 
	        	 if ( addressJTextField.getText().equals("Enter Your Address")|| addressJTextField.getText().length()==0) {  
	        		 addressJTextField.setText("Enter Your Address");  
	        		 addressJTextField.setFont(lostFont);  
	        		 addressJTextField.setForeground(Color.GRAY);  
	               } else {  
	            	   addressJTextField.setText(addressJTextField.getText());  
	            	   addressJTextField.setFont(gainFont);  
	            	   addressJTextField.setForeground(Color.BLACK);  
	               }  
	         }
	         
		}      
	);
		addressJTextField.addKeyListener(

	   	         new KeyAdapter() 
	   	         {
	   	            
	   	            public void keyPressed( KeyEvent event )
	   	            {
	   	            	phoneJTextFieldJPasswordFieldKeyPressed( event );
	   	            }

	   	           private void phoneJTextFieldJPasswordFieldKeyPressed( KeyEvent event )
	   	          {
	   	        	flag = false;
	   	        	l5.setVisible(flag);
	   	          }

	   	         } 

	   	      ); 
		
		
		
		String gen[] = {"Male","Female","Other"};
		genderJComboBox = new JComboBox(gen);
		genderJComboBox.setBounds(675,470,185,40);
		contentPane.add( genderJComboBox );
		
		

	      
		countryJComboBox= new JComboBox(countryList);
		countryJComboBox.setBounds(675,570,185,40);
		contentPane.add( countryJComboBox );
		countryJComboBox.addItemListener(

				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
					if(e.getStateChange() == ItemEvent.SELECTED)
					{
						
						countryJComboBox.getSelectedItem();
					}
						
					}

		
				
				}
				
				);
		
		
		
		
		
		
		signup= new JLabel(new ImageIcon("SIGNUP.png"));
		signup.setBounds(500, 93, 500, 270 );
		signup.setVisible(true);
		contentPane.add( signup );
		
		thumb = new JLabel(new ImageIcon("thumb.png"));
		thumb.setBounds(390, 80, 270, 270 );
		thumb.setVisible(true);
		contentPane.add( thumb );
		
/////////////////////This is the button to create an account///////////////////////
/////////////////////This is the button to create an account///////////////////////
/////////////////////This is the button to create an account///////////////////////
/////////////////////This is the button to create an account///////////////////////
		signUpJButton = new JButton(new ImageIcon("Sign Up.png"));
		signUpJButton.setBounds(455,650,390,76);
		contentPane.add( signUpJButton );
		signUpJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  loginJButtonActionPerformed( event );
		
	    
	    			  }

					private void loginJButtonActionPerformed(ActionEvent event) 
					{
						name = nameJTextField.getText();
						email= emailJTextField.getText();
						password = newPasswordJPasswordField.getText();
						phone = phoneJTextField.getText();
						address = addressJTextField.getText();
						gender = genderJComboBox.getSelectedItem().toString();
						country = countryJComboBox.getSelectedItem().toString();
						String retypedPass = retypeNewPasswordJPasswordField.getText();
						
	/////////////////////check if the user type in sufficient info///////////////////
		         			if(name.equals("Enter Your Name")|| name.equals(""))
							{
		         				flag = true;
		         				l1.setVisible(flag);
								System.out.print("work");
							}
								if(email.equals("Enter Your Email")||email.equals(""))
								{
									flag = true;
									l2.setVisible(flag);
								}
								if(password.equals("Enter a password")||password.equals(""))
								{
									flag = true;
									l3.setVisible(flag);
								}
								
								if(phone.equals("Enter Your Phone#")||phone.equals(""))
								{
									flag = true;
									l4.setVisible(flag);
								}			
				
									
								if(address.equals("Enter Your Address")||address.equals(""))
								{
									flag = true;
									l5.setVisible(flag);
								}
											
						
						
								
								int gg1 = password.length();
								
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
								
								
								else if(!retypedPass.equals(password))
								{

									   JOptionPane.showMessageDialog(null, "The password you typed is not the same!","ERROR",

									    	   JOptionPane.ERROR_MESSAGE);
									
									
								}
			         			else
			         			{
			         				if(flag == false)
			         				{
			         					int e = JOptionPane.showConfirmDialog(null, 
					            				" Congratulations, Dear "+ name + ",you just created a TPS account. You can also use this account "+"\n"+"as your RPS Banking account for the convenience of payment."
												, " Congratulations ", JOptionPane.CANCEL_OPTION);
			         					setVisible(false);
			         					
			         					MasterClass.getAllInfo(name,email,password,phone,address,gender,country);
			         					MasterClass.writeInfo();
			         					MasterClass.login();
			         					
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
		
		
		map = new JLabel(new ImageIcon("388809427820169_484552950.png"));
		map.setBounds(-20, 200, 537, 180 );
		map.setVisible(true);
		contentPane.add( map );
		
		calendar = new JLabel(new ImageIcon("cal4.png"));
		calendar.setBounds(30, 430, 200, 200 );
		calendar.setVisible(true);
		contentPane.add( calendar );
		
		calendar2= new JLabel(new ImageIcon("cal3.png"));
		calendar2.setBounds(230, 430, 200, 200 );
		calendar2.setVisible(true);
		contentPane.add( calendar2 );
		
		flight = new JLabel(new ImageIcon("flight.png"));
		flight.setBounds(30, 620, 200, 200 );
		flight.setVisible(true);
		contentPane.add( flight );
		
		hotel = new JLabel(new ImageIcon("hotel.png"));
		hotel.setBounds(230, 620, 200, 200 );
		hotel.setVisible(true);
		contentPane.add( hotel );
		
		
		thumbmap= new JLabel(new ImageIcon("thumb small.png"));
		thumbmap.setText("Map, to make better trips");
		thumbmap.setFont (new Font("Bank Gothic", Font.PLAIN,21));
		thumbmap.setBounds(10, 160, 370, 50 );
		thumbmap.setVisible(true);
		contentPane.add( thumbmap );
		
		thumbcal= new JLabel(new ImageIcon("thumb small.png"));
		thumbcal.setText("Calendar, to be organized");
		thumbcal.setFont (new Font("Bank Gothic", Font.PLAIN,21));
		thumbcal.setBounds(10, 380, 390, 50 );
		thumbcal.setVisible(true);
		contentPane.add( thumbcal );  
		
		
		thumbairhotel= new JLabel(new ImageIcon("thumb small.png"));
		thumbairhotel.setBounds(10, 600, 390, 50 );
		thumbairhotel.setText("Reservation, to be leisured");
		thumbairhotel.setFont (new Font("Bank Gothic", Font.PLAIN,21));
		thumbairhotel.setVisible(true);
		contentPane.add( thumbairhotel );  
		
		
		oritation = new JLabel(new ImageIcon("back.png"));
		oritation.setBounds(0,0,865,855);
		oritation.setVisible(true);
		contentPane.add( oritation );
		
		
		
		
		
		
	
		
		
		
		
		
		setSize(865,887);
		setTitle("Welcome to the Travel Planner System");
		setVisible(true);
		setResizable(true);
		
	}
	 protected static ImageIcon createImageIcon(String path) {
	        java.net.URL imgURL = SignUpPage.class.getResource(path);
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	                return null;
	        }
	 }


}

