import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Verification extends JFrame{

	private JLabel nameJLabel , emailJLabel, phoneJLabel, addressJLabel, balanceJLabel, typeJLabel,logoJLabel,accountNumberJLabel, passwordJLabel;
	private JTextField nameJTextField, emailJTextField, phoneJTextField, addressJTextField, balanceJTextField,accountNumberJTextField;
	private JPasswordField passwordJPasswordField;
	private JButton nameJButton, emailJButton, phoneJButton, addressJButton, balanceJButton, submitJButton,loginJButton;
	private JMenu menu;
	private JMenuBar bar;
	private JRadioButtonMenuItem Checking, Saving;
	private JCheckBox sureJCheckBox,loginJCheckBox;
	Account a = new Account();//make a method to pass the info
	private HomeScreen hs;
	private String name, email, phone, address,password;
	private String balance;
	private String type;

	 AccountHomePage ahp= new AccountHomePage();
	private Component grass;
	private JSlider myJSlider;


	public Verification()
	{
		 createUserInterface();
		 
	}

	public Verification(String userName, String email2, String phone2,
			String address2, String password2, String balance2, String type2) {
		
		name = userName;
		email = email2;
		phone = phone2;
		address = address2;
		password = password2;
		//balance = Double.parseDouble(String.valueOf(b));
		type = type2;
	
		
	}

	public void getInfo(String n,String e,String tel,String a,String gg, String b,String t)
	{
		name = n;
		email = e;
		phone = tel;
		address = a;
		password = gg;
		balance = b;
		

		type = t;
		System.out.print(name);
		
	//	 balance = Double.parseDouble(balanceJTextfield.toString()); 
		nameJTextField.setText(name);
		emailJTextField.setText(email);
		phoneJTextField.setText(phone);
		addressJTextField.setText(address);
		balanceJTextField.setText((String.valueOf(balance)));
		menu.setText(type);
		
		
		 PrinterJob pj = PrinterJob.getPrinterJob();
		 System.out.print(pj);
	}
	
	
	private void createUserInterface()
	{

		Container contentPane1 = getContentPane();
		contentPane1.setLayout(null);
		contentPane1.setBackground(Color.white);
		
		
		
		logoJLabel = new JLabel(); 
		logoJLabel.setIcon(new ImageIcon("rps.jpg"));
		logoJLabel.setBounds(-50, -80, 270, 200);
		logoJLabel.setHorizontalAlignment( JLabel.CENTER);
	    contentPane1.add( logoJLabel );
	    
		
		nameJLabel = new JLabel("Your Name is:");
		nameJLabel.setBounds(40,120,150,30);
		nameJLabel.setForeground(Color.black);
		nameJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		contentPane1.add( nameJLabel );
		
		emailJLabel = new JLabel("Your Email is:");
		emailJLabel.setBounds(40,160,150,30);
		emailJLabel.setForeground(Color.black);
		emailJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		contentPane1.add( emailJLabel );
		
		phoneJLabel = new JLabel("Your phone NO. is:");
		phoneJLabel.setBounds(40,200,170,30);
		phoneJLabel.setForeground(Color.black);
		phoneJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		contentPane1.add( phoneJLabel );
		
		addressJLabel = new JLabel("Your address is:");
		addressJLabel.setBounds(40,240,170,30);
		addressJLabel.setForeground(Color.black);
		addressJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		contentPane1.add( addressJLabel );
		
		balanceJLabel = new JLabel("Your Balance is:");
		balanceJLabel.setBounds(40,280,170,30);
		balanceJLabel.setForeground(Color.black);
		balanceJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		contentPane1.add( balanceJLabel );
		
		typeJLabel = new JLabel("Your type of Account is:");
		typeJLabel.setBounds(40,320,220,30);
		typeJLabel.setForeground(Color.black);
		typeJLabel.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		contentPane1.add( typeJLabel );
		
		//////////////////////////////////////////////////
		
		nameJTextField = new JTextField();
       // nameJTextfield.setText(name);
		nameJTextField.setBounds(180,118,150,30);
		nameJTextField.setEditable(false);
		contentPane1.add( nameJTextField );
	
		emailJTextField = new JTextField(email);
		emailJTextField.setBounds(180,158,150,30);
		emailJTextField.setEditable(false);
		contentPane1.add( emailJTextField );
		
		phoneJTextField = new JTextField(phone);
		phoneJTextField.setBounds(220,198,150,30);
		phoneJTextField.setEditable(false);
		contentPane1.add( phoneJTextField );
		
		addressJTextField = new JTextField(address);
		addressJTextField.setBounds(190,238,150,30);
		addressJTextField.setEditable(false);
		contentPane1.add( addressJTextField );
		
		balanceJTextField = new JTextField();
		//balanceJTextfield.setText(balance);
		balanceJTextField.setBounds(200,278,150,30);
		balanceJTextField.setEditable(false);
		contentPane1.add( balanceJTextField );
		
		nameJButton = new JButton(new ImageIcon("QQ20130407-1.png"));
		nameJButton.setBounds(340,118,30,29);
		contentPane1.add( nameJButton );
		nameJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  nameJButtonActionPerformed( event );
		
	    
	    			  }

					private void nameJButtonActionPerformed(ActionEvent event) 
					{
						nameJTextField.setEditable(true); 
					}
	    		  }
					);
		emailJButton = new JButton(new ImageIcon("QQ20130407-1.png"));
		emailJButton.setBounds(340,158,30,29);
		contentPane1.add( emailJButton );
		emailJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  emailJButtonActionPerformed( event );
		
	    
	    			  }

					private void emailJButtonActionPerformed(ActionEvent event) 
					{
						emailJTextField.setEditable(true); 
					}
	    		  }
					);
		
		phoneJButton = new JButton(new ImageIcon("QQ20130407-1.png"));
		phoneJButton.setBounds(380,198,30,29);
		contentPane1.add( phoneJButton );
		phoneJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  phoneJButtonActionPerformed( event );
		
	    
	    			  }

					private void phoneJButtonActionPerformed(ActionEvent event) 
					{
						phoneJTextField.setEditable(true); 
					}
	    		  }
					);
		
		addressJButton = new JButton(new ImageIcon("QQ20130407-1.png"));
		addressJButton.setBounds(350,238,30,29);
		contentPane1.add( addressJButton );
		addressJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  addressJButtonActionPerformed( event );
		
	    
	    			  }

					private void addressJButtonActionPerformed(ActionEvent event) 
					{
						addressJTextField.setEditable(true); 
					}
	    		  }
					);
		
		balanceJButton = new JButton(new ImageIcon("QQ20130407-1.png"));
		balanceJButton.setBounds(360,278,30,29);
		contentPane1.add( balanceJButton );
		balanceJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  balanceJButtonActionPerformed( event );
		
	    
	    			  }

					private void balanceJButtonActionPerformed(ActionEvent event) 
					{
						balanceJTextField.setEditable(true); 
					}
	    		  }
					);
		submitJButton = new JButton("Start a easy life by using RPS Bank");
		submitJButton.setBounds(100,378,250,29);
		contentPane1.add( submitJButton );
		submitJButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  submitJButtonActionPerformed( event );
		
	    
	    			  }

					private void submitJButtonActionPerformed(ActionEvent event) 
					{
						if(sureJCheckBox.isSelected())
						{
							nameJTextField.setEditable(false);
							emailJTextField.setEditable(false);
							phoneJTextField.setEditable(false);
							addressJTextField.setEditable(false);
							balanceJTextField.setEditable(false);
							JOptionPane.showMessageDialog(null, "Congratulations! Login and experience an easy financing life now!","ERROR",

							    	   JOptionPane.INFORMATION_MESSAGE);
							
							accountNumberJLabel.setVisible(true);
							passwordJLabel.setVisible(true);
							accountNumberJTextField.setVisible(true);
							passwordJPasswordField.setVisible(true);
							loginJButton.setVisible(true);
							loginJCheckBox.setVisible(true);
							
							writeInfo();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Check the check box before move on.","ERROR",

							    	   JOptionPane.ERROR_MESSAGE);
						}
					}
	    		  }
					);
		sureJCheckBox = new JCheckBox("The information I typed is correct");
		sureJCheckBox.setBounds(100,348,250,30);
		contentPane1.add( sureJCheckBox );
		//////////////////////////Menu...\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		bar = new JMenuBar();
		menu = new JMenu("Account Type");
		
		bar.setBounds(250,318,150,30);
		Saving = new JRadioButtonMenuItem("Saving");
		Checking = new JRadioButtonMenuItem("Checking");

		bar.add(menu);

		menu.add(Checking);
		menu.add(Saving);
		contentPane1.add( bar );
		
		ButtonGroup group = new ButtonGroup();
		group.add(Checking);
		group.add(Saving);
		menu.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent e)
	    			  {
	    				
	    				  menuActionPerformed( e );
		
	    
	    			  }

					private void menuActionPerformed(ActionEvent e) 
					{
						String k = (String) e.getSource();
						if(k.equals(Checking))
						{
							menu.setText("Checking");
							System.out.print("Checking");
							setBackground(Color.RED);
						
						}
						if(e.getSource() == Saving)
						{
							menu.setText("Saving");
					
						}
					
					}
	    		  }
					);
		

		
		

	

		//////////////////////////Menu...\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		accountNumberJLabel = new JLabel("Enter your Name:");
		accountNumberJLabel.setBounds(260,-5,200,50);
		accountNumberJLabel.setVisible(false);
		contentPane1.add( accountNumberJLabel );
		
		passwordJLabel = new JLabel("Enter Password:");
		passwordJLabel.setBounds(270,25,200,50);
		passwordJLabel.setVisible(false);
		contentPane1.add( passwordJLabel );
		
		accountNumberJTextField = new JTextField();
		accountNumberJTextField.setBounds(400,10,100,20);
		accountNumberJTextField.setVisible(false);
		contentPane1.add( accountNumberJTextField );
		
		passwordJPasswordField = new JPasswordField();
		passwordJPasswordField.setBounds(400,40,100,20);
		passwordJPasswordField.setVisible(false);
		contentPane1.add( passwordJPasswordField );
		
		loginJButton = new JButton(new ImageIcon("QQ20130403-1.png"));
		loginJButton.setBounds(440,70,59,30);
		loginJButton.setVisible(false);
		contentPane1.add( loginJButton );
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
							
							
							////////the place it read the info///////
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
		loginJCheckBox.setVisible(false);
		contentPane1.add( loginJCheckBox );
		
		grass = new JLabel(new ImageIcon("6--603810-Green Grass On White Background. Matte Channel..jpg"));
		grass.setBounds(0, -150, 1000, 800 );
		grass.setVisible(true);
		contentPane1.add( grass );
		
		 
		
		  myJSlider = new JSlider();
	      myJSlider.setBounds( 200, 70, 150, 49 );
	      myJSlider.setPaintTicks( true );
	      myJSlider.setMajorTickSpacing( 10 );
	      myJSlider.setBackground( Color.PINK );
	      contentPane1.add( myJSlider);
		
		
		setSize(500,500);
		setTitle("Verification");
		//set it false at the end
		setVisible(false);//set it false at the end
		//set it false at the end
		setResizable(false);
		
	}
	public void writeInfo()
	{
		try
	  	{
	  		// Create file 
	  		FileWriter fstream = new FileWriter(name+".txt");
	  		BufferedWriter out = new BufferedWriter(fstream);
	  		out.write(name+"\n");
	  		out.write(email+"\n");
	  		out.write(phone+"\n");
	  		out.write(address+"\n");
	  		out.write(balance+"\n");
	  		out.write(type+"\n");
	  		
	  		out.close();  //Close the output stream
	   }
	  
	  catch (Exception e) //Catch exception if any
	  {
	  	System.err.println("Error: " + e.getMessage());
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
		type = list.get(6);
		 

		System.out.println("The user name is: " + list.get(0));
		System.out.println("The email is: " + list.get(1));
		System.out.println("The phone number is: " + list.get(2));
		System.out.println("The address is: " + list.get(3));
		System.out.println("The balance is: " + list.get(4));
		System.out.println("The account type is: " + list.get(5));
		System.out.println("list 6 is: " + list.get(6));
		
		System.out.print(s);	
		
		ahp.getUserBasicInfo(name,email,phone,balance,address,password,type);
		
		in.close();
		scan.close();
	}

}
