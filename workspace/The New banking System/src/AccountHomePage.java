import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AccountHomePage extends JFrame  // makes class
{

	private JPanel tabBar;	
	private JButton homePage;
	private JButton EPButton,transferJButton,depositAndWithdrawJButton,InvestementJButton,signOutJB;;

	private Container contentPane;
	//////userBasicInfo////////
	private JPanel userBasic;
	private JTextField userNameJTextField;
	private JLabel userNameJLabel;
	private JTextField IDJTextField;
	private JLabel IDJLabel;
	private JTextField emailTextField;
	private JLabel emailJLabel;
	private JLabel addressJLabel;
	private JTextField addressJTextField;
	private JLabel typeJLabel,logoJLabel;
	private JTextField typeJTextField;
	private JLabel profilePicture;
	//////	//////the rest of the parts	//////	//////
	private JPanel financialsJPanel;
	private JTextField totalBallanceJTF,phoneJTF;
	private JLabel totalBallanceJL,phoneJL;

///////////the history thing//////	///////////	/////
	private JPanel historyJPanel;
	private ArrayList<JTextField> historyArray = new ArrayList(100);

	private JTextArea historyJTA;
	private JScrollPane scroller;
	

	
	private Reader inputStream;
	
	
	private JButton saveJButton;
	private JButton tHistoryJButton;
	private int randomNum,minimum=1000,maximum=100000;

	private String name, email, phone, address,password;
	private String balance;
	private String type;
	
	private String history;
	private JLabel grass;
	private JLabel colored;
	private JLabel colored2;
	private JLabel lake;
  

	
	
	public AccountHomePage() 
	{
		createUserInterface();
		randomNum = minimum + (int)(Math.random()*maximum); 
		IDJTextField.setText(String.valueOf(randomNum));
	}
	
	
	public void getBalanceFromTransfer(double money)
	{
		System.out.print(balance+ " works");
		balance = String.valueOf(money);
		totalBallanceJTF.setText(balance);
		
		
	}
	
	public void getBalanceFromDW(double b)
	{
		balance = String.valueOf(b);
		totalBallanceJTF.setText(balance);
	}
	
	public AccountHomePage(String userName, String email2, String phone2, String balance2,
			String address2, String password2,  String type2) {
	
		name = userName;
		email = userName;
		phone = phone2;
		address = phone2;
		address = address2;
		balance= balance2;
		type = type2;
		
		userNameJTextField.setText(name);
		emailTextField.setText(email);
		phoneJTF.setText(phone);
		addressJTextField.setText(balance);
		totalBallanceJTF.setText(address);
		typeJTextField.setText(password);

		
	}



	public void getUserBasicInfo(String n,String e,String tel,String b,String a,String gg, String t)
	{
		name = n;
		email = e;
		phone = tel;
		address = a;
		password = gg;
		balance = b;
		type = t;
		
		userNameJTextField.setText(name);
		emailTextField.setText(email);
		phoneJTF.setText(phone);
		addressJTextField.setText(balance);
		totalBallanceJTF.setText((address));
		typeJTextField.setText(password);
		if(name.equals("Mr.Lake"))
		{
			lake.setVisible(true);
			profilePicture.setVisible(false);
		}
	}
	
	public void getUserBasicInfo1(String n,String e,String tel,String b,String a,String gg, String t)
	{
		name = n;
		email = e;
		phone = tel;
		address = a;
		password = gg;
		balance = b;
		type = t;
		
		userNameJTextField.setText(name);
		emailTextField.setText(email);
		phoneJTF.setText(phone);
		addressJTextField.setText(balance);
		totalBallanceJTF.setText((address));
		typeJTextField.setText(password);
		
		if(name.equals("Mr.Lake"))
		{
			lake.setVisible(true);
			profilePicture.setVisible(false);
		}
	}
	
	
	
	private void createUserInterface()
	{
		
		//contentPane = what is in window
		contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		contentPane.setBackground(Color.white);
		
		

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		userBasic = new JPanel();
		userBasic.setBounds(357,70,300, 220);
		userBasic.setLayout(null);
		userBasic.setBorder( new TitledBorder( "User Basic Information" ) );
		contentPane.add(userBasic);
		
		
		userNameJTextField = new JTextField("RPS BANK");
		userNameJTextField.setBounds(80,245,170,30);
		userNameJTextField.setFont(new Font("Serif", Font.BOLD, 30));
		userNameJTextField.setEditable(false);
		contentPane.add(userNameJTextField);
		
		profilePicture = new JLabel();
		profilePicture.setIcon(new ImageIcon("4623.png"));
		profilePicture.setBounds( 80, 75, 230, 200 );
		contentPane.add(profilePicture);
		
		
		lake = new JLabel();
		lake.setIcon(new ImageIcon("lake.jpg"));
		lake.setBounds( 80, 75, 230, 200 );
		contentPane.add(lake);
		
		
		userNameJLabel = new JLabel("User Name: ");
		userNameJLabel.setBounds(10,25,100,30);
		userNameJLabel.setForeground(Color.BLACK);
		userBasic.add(userNameJLabel);
		
		userNameJTextField = new JTextField();
		userNameJTextField.setBounds(90,25,120,30);
		userNameJTextField.setEditable(false);
		userBasic.add(userNameJTextField);
		
		IDJLabel = new JLabel("ID Number:");
		IDJLabel.setBounds(10,55,120,30);
		IDJLabel.setForeground(Color.BLACK);
		userBasic.add(IDJLabel);
		
		IDJTextField = new JTextField();
		IDJTextField.setBounds(90,55,120,30);
		IDJTextField.setEditable(false);
		userBasic.add(IDJTextField);
		

		emailJLabel = new JLabel("Email: ");
		emailJLabel.setBounds(10,85,120,30);
		emailJLabel.setForeground(Color.BLACK);
		userBasic.add(emailJLabel);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(90,85,150,30);
		emailTextField.setEditable(false);
		userBasic.add(emailTextField);
		
		
		phoneJL= new JLabel("Phone Num:");
		phoneJL.setBounds(10,115,150,30);
		phoneJL.setForeground(Color.BLACK);
		userBasic.add(phoneJL);
		
		phoneJTF= new JTextField();
		phoneJTF.setBounds(90,115,150,30);
		phoneJTF.setEditable(false);
		userBasic.add(phoneJTF);
		
		addressJLabel= new JLabel("Address:");
		addressJLabel.setBounds(10,145,150,30);
		addressJLabel.setForeground(Color.BLACK);
		userBasic.add(addressJLabel);
		
		addressJTextField= new JTextField();
		addressJTextField.setBounds(90,145,150,30);
		addressJTextField.setEditable(false);
		userBasic.add(addressJTextField);
		
		typeJLabel= new JLabel("Type of Acc:");
		typeJLabel.setBounds(10,175,150,30);
		typeJLabel.setForeground(Color.BLACK);
		userBasic.add(typeJLabel);
		
		typeJTextField= new JTextField();
		typeJTextField.setBounds(90,175,150,30);
		typeJTextField.setEditable(false);
		userBasic.add(typeJTextField);
		
		signOutJB = new JButton(new ImageIcon("QQ20130403-3.png"));
		signOutJB.setBounds( 630, 18, 110, 30 );
		signOutJB.setVisible(true);
		contentPane.add( signOutJB );
		signOutJB.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	name = userNameJTextField.getText();
		            	email =emailTextField.getText();
		            	phone = phoneJTF.getText();
		            	address = addressJTextField.getText();
		            	balance = totalBallanceJTF.getText();
		         	    type =	typeJTextField.getText();
		            	 
		            	
		            	 
		            	 dispose();
		             
		            	 
		         
		             }

		         } 

		      );
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		financialsJPanel = new JPanel();
		financialsJPanel.setBounds(20,300,700, 410);
		financialsJPanel.setLayout(null);
		financialsJPanel.setBorder( new TitledBorder( "Fianancial Information" ) );
		contentPane.add(financialsJPanel);
		
		totalBallanceJL  = new JLabel("Total Ballance: ");
		totalBallanceJL.setBounds(10,20,120,30);
		totalBallanceJL.setForeground(Color.BLACK);
		financialsJPanel.add(totalBallanceJL);
		
		totalBallanceJTF = new JTextField("0");
		totalBallanceJTF.setBounds(120,20,150,30);
		totalBallanceJTF.setEditable(false);
		financialsJPanel.add(totalBallanceJTF);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		saveJButton = new JButton();
		saveJButton.setText( "Save" );
		saveJButton.setBounds( 820, 660, 110, 30 );
		saveJButton.setVisible(true);
		contentPane.add( saveJButton );
		saveJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	
		             }

		         } 

		      );
		
		
		
		
	/*	tHistoryJButton = new JButton();
		tHistoryJButton.setText( "Read" );
		tHistoryJButton.setBounds( 920, 660, 110, 30 );
		tHistoryJButton.setVisible(true);
		contentPane.add( tHistoryJButton );
		tHistoryJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	 try {
						//	MasterController.ReadInfo();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		             }

		         } 

		      );*/
		
		
		historyJPanel = new JPanel();
		historyJPanel.setBounds(3,50,670, 350);
		historyJPanel.setLayout(null);
		historyJPanel.setBorder( new TitledBorder( "Recent History" ) );
		financialsJPanel.add(historyJPanel);
		

		historyJTA = new JTextArea();
		historyJTA.setEditable(false);
		scroller = new JScrollPane(historyJTA);
		scroller.setBounds(8, 20, 650, 320);
		historyJPanel.add(scroller);
		
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		homePage= new JButton(new ImageIcon("rps.png"));
		homePage.setText( "Home" );
		homePage.setBounds(0, -30, 170, 98 );
		homePage.setVisible(true);
		contentPane.add( homePage );
		homePage.addActionListener(
		         
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
		         			
		         			
		         			//Means Yes
		         			System.out.print("Yes");
		         			setVisible(false);
		         			  HomeScreen hs = new HomeScreen();
		         			
		         		}
		            	 
		             }

		         } 
		         
		      ); 
		
	
		
		EPButton = new JButton();
		EPButton.setText( "Edit" );
		EPButton.setBounds( 180, 17, 100, 35 );
		EPButton.setVisible(true);
		contentPane.add( EPButton );
		EPButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            
		            	 EditUserInfo eui = new EditUserInfo();
		            	 eui.setVisible(true);
		            	 eui.EditUserInfo(name,email,phone,balance,address,type);
		                 setVisible(false);
		             }

		         } 

		      );
		
		InvestementJButton = new JButton();
		InvestementJButton.setText( "Investment" );
		InvestementJButton.setBounds( 530, 17, 100, 35 );
		InvestementJButton.setVisible(true);
		contentPane.add( InvestementJButton );
		InvestementJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	 //myInvestment = new Investment();
		            	 //dispose(); //close this window
		            	Investment i = new Investment();
		            	i.changeUserName(name);
		            	 
		             }

		         } 

		      );
		transferJButton = new JButton();
		transferJButton.setText( "Transfer" );
		transferJButton.setBounds( 280, 17, 100, 35 );
		transferJButton.setVisible(true);
		contentPane.add( transferJButton );
		transferJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		              
		            	 Transfer t = new Transfer();
		            	 t.changeName(name);
		            	 t.getBalance(address);
		            	 t.getAccountNum(IDJTextField.getText());
		            	 t.setVisible(true);
		            	 
		            	 t.getInfo(name,email,phone,balance,addressJTextField.getText(),password, type);
		            	 
		            	 dispose();
		            	 
		             }

		         } 

		      );
		
		depositAndWithdrawJButton = new JButton();
		depositAndWithdrawJButton.setText( "Deposit/Withdraw" );
		depositAndWithdrawJButton.setBounds(380, 17, 150, 35 );
		depositAndWithdrawJButton.setVisible(true);
		contentPane.add( depositAndWithdrawJButton );
		depositAndWithdrawJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	 String bal = totalBallanceJTF.getText();
		            DepositWithdraw dw = new DepositWithdraw();
		            dw.getBalance(bal);
		            
		            dw.getInfo(name,email,phone,balance,addressJTextField.getText(),password, type);
		            
		            dispose();
		            	 
		             }

		         } 

		      );
		

		tabBar = new JPanel();
		tabBar.setBounds(179,5,1200, 45);
		tabBar.setLayout(null);
		tabBar.setBackground(Color.black);
		tabBar.setBorder( new TitledBorder( "Tab Bar" ) );
		contentPane.add(tabBar);
		
		colored= new JLabel(new ImageIcon("colored3.jpg"));
		colored.setBounds(-100, -200, 1000, 800 );
		colored.setVisible(true);
		contentPane.add( colored );
		

		
		grass = new JLabel(new ImageIcon("6--603810-Green Grass On White Background. Matte Channel..jpg"));
		grass.setBounds(0, 50, 1000, 800 );
		grass.setVisible(true);
		contentPane.add( grass );
		

		
		
		//window stuff
		setVisible(false);
		setSize(730,750);
		setTitle("Home Page");
		

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



	public void historyJTA(String his) {
		history += his;
		historyJTA.append(history+"\n");
		
	}
}
