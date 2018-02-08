import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;



	public class ManagerAccount extends JFrame  // makes class
	{
		   // JLabel that displays prompt
		   private JLabel selectJLabel,userNameJLabel;


		   private JButton CheckUserInfoJButton;
		   private JButton CheckForUsersJButton;

		   private JButton HomeJButton;
		   
		   private JButton smallback;
		   
		   private JTextArea TextArea;
		   private JScrollPane scroller;
		   
			private static double ballance;
			private static String username;
			private static String password;
			private static String email;
			private static String phoneN;
			private static String fileName;
			
		   
		   // no-argument constructor
		   public ManagerAccount()
		   {
		      createUserInterface();
		   }
			public static void inSetup(double b, String u, String p, String e, String f)
			{
				ballance = b;
				username = u;
				password = p;
				email = e;
				phoneN = f;
		
			}
		   // create and position GUI components; register event handlers
		   private void createUserInterface()
		   {
		      // get content pane for attaching GUI components
		      Container contentPane = getContentPane();

		      // enable explicit positioning of GUI components
		      contentPane.setLayout( null );
		      userNameJLabel = new JLabel("Check Users Info");
		      userNameJLabel.setBounds(380,42,250,30);
		      userNameJLabel.setFont(new Font("Serif", Font.BOLD, 30));
		     
				contentPane.add(userNameJLabel);

		      selectJLabel = new JLabel();
		      selectJLabel.setText(
		         "Dear Abdacky, Please select the opreation:" );
		      selectJLabel.setBounds( 12, 16, 270, 50 );
		      contentPane.add( selectJLabel );

		      TextArea = new JTextArea ();
		      TextArea.setLineWrap(true);
		 
		      final JScrollPane scroller = new JScrollPane(TextArea);
		      scroller.setBounds( 10, 70, 950, 700 );
		      TextArea.setEditable(false);
		      scroller.setVisible(false);
		      scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		      contentPane.add(scroller, BorderLayout.CENTER);
		      TextArea.append("  User Name:"+"\t"+"\t"+"Email:"+"\t"+"\t"+"Phone Number:"+"\t"+"\t"+"Balance:");

		      CheckUserInfoJButton = new JButton();
		      CheckUserInfoJButton.setText( "CheckUserInfo" );
		      CheckUserInfoJButton.setBounds( 70, 56, 108, 21 );
		      contentPane.add( CheckUserInfoJButton );
		      CheckUserInfoJButton.addActionListener(
				      new ActionListener() 
				         {
				            
				             public void actionPerformed ( ActionEvent event )
				             {
				            	 smallback.setVisible(true);
				            	 HomeJButton.setVisible(false);
				            	 selectJLabel.setVisible(false);
				            	 CheckUserInfoJButton.setVisible(false); 
				            	 CheckForUsersJButton.setVisible(false);
				            	 setSize(1000,1000);
				            	 setTitle( "Check Info" );
				            	 TextArea.setVisible(true);
				            	 scroller.setVisible(true);
				            	 TextArea.append("\n"+"  "+username+"\t"+"\t"+email+"\t"+"\t"+phoneN+"\t"+"\t"+"\t"+ballance);
				             }
				             
				             
				             }
				      );
		      
		     
		     
		      
		      
		      
		      CheckForUsersJButton = new JButton();
		      CheckForUsersJButton.setText( "Search" );
		      CheckForUsersJButton.setBounds( 77, 96, 88, 21 );
		      contentPane.add( CheckForUsersJButton );
		      CheckForUsersJButton.addActionListener(
				      new ActionListener() 
				         {
				            
				             public void actionPerformed ( ActionEvent event )
				             {
				            	
				             }
				             
				             
				             }
				      );

		      smallback  = new JButton();
		      smallback.setText( "BacktoSelect" );
		      smallback.setBounds( 3, 770, 120, 23 );
		      contentPane.add( smallback );
		      smallback.setVisible(false);
		      smallback.addActionListener(
		      new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            
		            	 selectJLabel.setVisible(true);
		            	 CheckUserInfoJButton.setVisible(true); 
		            	 CheckForUsersJButton.setVisible(true);
		            	 smallback.setVisible(true);
		            	 HomeJButton.setVisible(true);
		            	 setSize(280, 240 );
		            	 setTitle( "STAFF ONLY" );
		            	 TextArea.setVisible(false);
		            	 scroller.setVisible(false);
		            	 
		             }
 
		         }
		      );
		      
		      HomeJButton = new JButton();
		      HomeJButton.setText( "Back" );
		      HomeJButton.setBounds( 3, 196, 70, 23 );
		      contentPane.add( HomeJButton );
		      HomeJButton.addActionListener(
		      new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	
		            	 
		            	 int x = JOptionPane.showConfirmDialog(null, 
		            				" Are you sure you want to go back to the set UP? ", " Go back to SetUp ", JOptionPane.YES_NO_CANCEL_OPTION);
		         		
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
		         			MasterController a = new MasterController();
		         			setVisible(false);
		         			//Means Yes
		         			System.out.print("Yes");
		         		}
		            	 
		             }

		         } 
		         
		      ); 
		   
		      // set properties of application's window
		      setTitle( "STAFF ONLT" ); // set title bar string
		      setSize( 280, 240 );          // set window size
		      setVisible( true );           // display window
		      
		   } // end method createUserInterface
		   
		   // display message based on user selection
	
		   // main method
		   public static void main( String[] args )
		   {
			   ManagerAccount application = new ManagerAccount();
		      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		   }
		   
		} // end class SiblingSurvey