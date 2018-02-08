import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class HomePage extends JFrame  // makes class
{

	
	private Container contentPane;
	
	private JPanel userBasic;
	private JTextField userNameJTextField;
	private JLabel userNameJLabel;
	private JTextField IDJTextField;
	private JLabel IDJLabel;
	private JTextField emailTextField;
	private JLabel emailJLabel;
	
	private JLabel profilePicture;
	
	private JPanel financialsJPanel;
	private JTextField totalBallanceJTF;
	private JLabel totalBallanceJL;
	private JLabel pieChart;
	private JLabel barGraph;
	
	private JPanel historyJPanel;
	private ArrayList<JTextField> historyArray = new ArrayList(100);
	
	private JPanel tabBar;
	private JButton goToEdit;
	private EditProfile EP;
	private JButton homePage;
	
    private JButton investment;
	
	// constructs objects this is called when 
	//screenController bjhsad = new screenController();
	public HomePage() 
	{
		createUserInterface();
	}
	
	public void calculateBallance(double deposit, double withdrawl)
	{
		Double beforeBallance = Double.parseDouble(totalBallanceJTF.getText());

	}
	
	public void changeUserName(String usn)
	{
		userNameJTextField.setText(usn);
	}
	
	public void changeEmail(String email)
	{
		emailTextField.setText(email);
	}
	
	
	//method
	private void createUserInterface()
	{
	
		
		//contentPane = what is in window
		contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		contentPane.setBackground(Color.white);
		

		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		userBasic = new JPanel();
		userBasic.setBounds(300,70,300, 220);
		userBasic.setLayout(null);
		userBasic.setBorder( new TitledBorder( "User Basic Information" ) );
		contentPane.add(userBasic);
		
		userNameJTextField = new JTextField("Abdacky");
		userNameJTextField.setBounds(100,245,130,30);
		userNameJTextField.setFont(new Font("Serif", Font.BOLD, 30));
		userNameJTextField.setEditable(false);
		contentPane.add(userNameJTextField);
		
		profilePicture = new JLabel();
		profilePicture.setIcon(new ImageIcon("Profile Picture.jpg"));
		profilePicture.setBounds( 10, 75, 230, 200 );
		contentPane.add(profilePicture);
		
		
		userNameJLabel = new JLabel("User Name: ");
		userNameJLabel.setBounds(10,65,100,30);
		userNameJLabel.setForeground(Color.BLACK);
		userBasic.add(userNameJLabel);
		
		userNameJTextField = new JTextField("Abdacky");
		userNameJTextField.setBounds(90,65,120,30);
		userNameJTextField.setEditable(false);
		userBasic.add(userNameJTextField);
		
		IDJLabel = new JLabel("ID Number:");
		IDJLabel.setBounds(10,100,120,30);
		IDJLabel.setForeground(Color.BLACK);
		userBasic.add(IDJLabel);
		
		IDJTextField = new JTextField("1234");
		IDJTextField.setBounds(90,100,120,30);
		IDJTextField.setEditable(false);
		userBasic.add(IDJTextField);
		

		emailJLabel = new JLabel("email: ");
		emailJLabel.setBounds(10,150,120,30);
		emailJLabel.setForeground(Color.BLACK);
		userBasic.add(emailJLabel);
		
		emailTextField = new JTextField("abdacky@gmail.com");
		emailTextField.setBounds(90,150,150,30);
		emailTextField.setEditable(false);
		userBasic.add(emailTextField);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		financialsJPanel = new JPanel();
		financialsJPanel.setBounds(10,300,650, 410);
		financialsJPanel.setLayout(null);
		financialsJPanel.setBorder( new TitledBorder( "Fianancial Information" ) );
		contentPane.add(financialsJPanel);
		
		pieChart = new JLabel();
		pieChart.setIcon(new ImageIcon("Pie chart.jpeg"));
		pieChart.setBounds( 15, 105, 300, 230 );
		financialsJPanel.add(pieChart);
		
		barGraph = new JLabel();
		barGraph.setIcon(new ImageIcon("Bar Graph.jpeg"));
		barGraph.setBounds( 360, 105, 300, 230 );
		financialsJPanel.add(barGraph);
		
		totalBallanceJL  = new JLabel("Total Ballance: ");
		totalBallanceJL.setBounds(10,50,120,30);
		totalBallanceJL.setForeground(Color.BLACK);
		financialsJPanel.add(totalBallanceJL);
		
		totalBallanceJTF = new JTextField("$1,000,000,000");
		totalBallanceJTF.setBounds(120,50,150,30);
		totalBallanceJTF.setEditable(false);
		financialsJPanel.add(totalBallanceJTF);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		historyJPanel = new JPanel();
		historyJPanel.setBounds(700,80,370, 580);
		historyJPanel.setLayout(null);
		historyJPanel.setBorder( new TitledBorder( "Recent History" ) );
		contentPane.add(historyJPanel);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		goToEdit = new JButton();
		goToEdit.setText( "Operate" );
		goToEdit.setBounds( 200, 20, 100, 35 );
		goToEdit.setVisible(true);
		contentPane.add( goToEdit );
		goToEdit.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	 EP = new EditProfile();
		             }

		         } 

		      );
		
		tabBar = new JPanel();
		tabBar.setBounds(0,5,1200, 45);
		tabBar.setLayout(null);
		tabBar.setBackground(Color.black);
		tabBar.setBorder( new TitledBorder( "Tab Bar" ) );
		contentPane.add(tabBar);
		

		
		investment = new JButton("Investment");
		investment.setBounds( 0, 10, 100, 15 );
		investment.setVisible(true);
		contentPane.add( investment );
		
		
		
		
		//window stuff
		setVisible(true);
		setSize(1100,750);
		setTitle("Home Page");
		

	}
}
