import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class savedTrip extends JFrame  // makes class
{
	private Container contentPane;
private JLabel wood;
private JLabel seperate;
private JButton rpsfinance;
private JButton logo;

private String name,email,phone,password,country,address,gender;
private JLabel logoLabel;
private JLabel startingPlace1;
private JLabel destination1;
private JLabel date1;
private JLabel feeJLabel;
private int randomNum;
private int minimum=500;
private int maximum=7000;

private static String fee;

private static String startplace;
private static String destination;
private static String dateOfSettingOff;

private JButton payButton;

	
	public savedTrip() 
	{
		createUserInterface();
		randomNum = minimum + (int)(Math.random()*maximum); 
		fee = String.valueOf(randomNum);
		
		
		feeJLabel.setText("Your Total Fee is:     $"+fee);
	}
	
	
	public void getUserBasicInfo(String n, String e, String pass, String p, String a, String g, String c)
	{
		name = n;
		email = e;
		password = pass;
		phone = p;
		address= a;
		gender= g;
		country= c;
		

	}
	public static void getTripInfo(String s,String d,String date)
	{
		startplace = s;
		destination = d;
		dateOfSettingOff = date;
	}
	
	private void createUserInterface()
	{
		
		//contentPane = what is in window
		contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		contentPane.setBackground(Color.white);
		
		
		  startingPlace1 = new JLabel("Starting Place:	     " + startplace);
		startingPlace1.setBounds(0,100,500,30);
		startingPlace1.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,25));
		startingPlace1.setForeground(Color.RED);
		contentPane.add(startingPlace1);

		  destination1 = new JLabel("Destination:	          " +destination);
		destination1.setBounds(0,200,500,30);
		destination1.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,25));
		destination1.setForeground(Color.RED);
		contentPane.add(destination1);
		
		  date1 = new JLabel("Date:	            " + dateOfSettingOff);
		date1.setBounds(0,300,700,30);
		date1.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,25));
		date1.setForeground(Color.RED);
		contentPane.add(date1);
		
		
		feeJLabel = new JLabel("Your Total Fee is:     "+fee);
		feeJLabel.setBounds(0,400,700,30);
		feeJLabel.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,25));
		feeJLabel.setForeground(Color.RED);
		contentPane.add(feeJLabel);
		
		payButton = new JButton(new ImageIcon("Pay now button.png"));
		payButton.setBounds(150,450,180,60);
		payButton.setOpaque(false);
		contentPane.add(payButton);
		payButton.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		
		payButton.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  payButtonPerformed( event );
		
	    
	    			  }

					private void payButtonPerformed(ActionEvent event) 
					{
						AccountHomePage ahp = new AccountHomePage();
						AccountHomePage.getUserBasicInfo(name,email,phone,password,country,address,gender);
						ahp.setVisible(true);
						ahp.getFee(fee);
						MasterClass.readBalance(name);
						
					}
	    		  }
	    		  );
		
		
		
	
		
		logo= new JButton(new ImageIcon("TPS-logo-med.png"));
		logo.setBounds(26, 21, 50, 60 );
		logo.setVisible(true);
		contentPane.add( logo );
		logo.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		
		logo.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  logoActionPerformed( event );
		
	    
	    			  }

					private void logoActionPerformed(ActionEvent event) 
					{
						{
							int k = JOptionPane.showConfirmDialog(null, 
		            				" Are you sure you want to go home? "
									, " Warning, might lose information! ", JOptionPane.YES_OPTION);
		         		
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
		         			MasterClass.goHome();
							dispose();
		         			//Means Yes
		         			System.out.print("Yes");
		         			
		         		}
						
						}
					}
	    		  }
		
						);
		
		logoLabel = new JLabel(new ImageIcon("TPS-logo-med.png"));
		logoLabel.setBounds(1, -1, 100, 104 );
		logoLabel.setVisible(true);
		contentPane.add( logoLabel );
		
		rpsfinance= new JButton(new ImageIcon("rpsFinance.png"));
		rpsfinance.setBounds(120, 20, 125, 62 );
		rpsfinance.setVisible(true);
		contentPane.add( rpsfinance );
		rpsfinance.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		
		rpsfinance.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  signoutPerformed( event );
		
	    
	    			  }

					private void signoutPerformed(ActionEvent event) 
					{
						AccountHomePage ahp = new AccountHomePage();
						AccountHomePage.getUserBasicInfo(name,email,phone,password,country,address,gender);
						ahp.setVisible(true);
						MasterClass.readBalance(name);
					}
	    		  }
	    		  );
		
		seperate= new JLabel(new ImageIcon("seperate.png"));
		seperate.setBounds(57, 0, 100, 104 );
		seperate.setVisible(true);
		contentPane.add( seperate );
		
		
		wood = new JLabel(new ImageIcon("wood_wallpaper_hp_png-1280x800.jpg"));
		wood.setBounds(0,0,960,600);
		contentPane.add(wood);
		

		setVisible(true);
		setSize(500,600);
		setResizable(false);
		setTitle("Saved Trip");
		

	}
	

}
