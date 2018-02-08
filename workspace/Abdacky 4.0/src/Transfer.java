import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Transfer extends JFrame {
	
	   // JPanel to group account information components
	   private JPanel accountJPanel;

	   // JLabel and JTextField for account holder's name
	   private JLabel nameJLabel;
	   private JTextField nameJTextField;

	   // JLabel and JTextField for account number
	   private JLabel accountNumberJLabel;
	   private JTextField accountNumberJTextField;
	
	   
	   private JLabel balanceJLabel;
	   private JTextField balanceJTextField;
	/////////////////////////////////////////////   

	   
	   private JPanel enterJPanel;

	   private JLabel transferToJLabel;
	   private JTextField transferToJTextField;
	   
	   private JLabel transferAmountJLabel;
	   private JTextField transferAmountJTextField;
	   
	   private JLabel weekdaysJLabel;
	   private JCheckBox weekdaysJCheckBox;
	

	
	   private JLabel wholeWeekJLabel;
	   private JCheckBox wholeWeekJCheckBox,onlyWeekendCheckBox;
	 

       private JButton enterJButton;
       private JButton chooseDate;
	   private date viewDate;
	   private JLabel dateJL;
	   private JTextField dateJTF;
	   
	   private JButton transferHistory;
	   private TransferHistory transferHis;

   	     public Transfer()
   	     {
   	    	 createUserInterface();
   	     }
   	     
   	     public void changeName(String Name)
   	     {
   	    	nameJTextField.setText(Name);
   	     }
   	     
   	     public void getDate(String date)
   	     {
   	    	 dateJTF.setText(date);
   	     }
   	
   	     public void changeUN(String username)
  	{
   		nameJTextField.setText(username);
  	
  	}
   	   
	   
	   // create and position GUI components; register event handlers
	   private void createUserInterface()
	   {
		   
		   
	      // get content pane for attaching GUI components
	      Container contentPane = getContentPane();

	      // enable explicit positioning of GUI components
	      contentPane.setLayout( null );
	      
	   
	      accountJPanel = new JPanel();
	      accountJPanel.setLayout( null );
	      accountJPanel.setBounds( 20, 16, 136, 170 );
	      accountJPanel.setBorder( 
	         new TitledBorder( "Account information" ) );
	      contentPane.add( accountJPanel );
	      
	      nameJLabel = new JLabel();
	      nameJLabel.setText( "Name:" );
	      nameJLabel.setBounds( 16, 24, 100, 16 );
	      accountJPanel.add( nameJLabel );

	      // set up nameJTextField
	      nameJTextField = new JTextField();
	      nameJTextField.setBounds( 16, 40, 104, 21 );
	      nameJTextField.setEditable( false );
	      accountJPanel.add( nameJTextField );
	      
	      accountNumberJLabel = new JLabel();
	      accountNumberJLabel.setText( "Account Number:" );
	      accountNumberJLabel.setBounds( 16, 70, 140, 16 );
	      accountJPanel.add( accountNumberJLabel );

	      // set up accountNumberJTextField
	      accountNumberJTextField = new JTextField();
	      accountNumberJTextField.setText( "12345" );
	      accountNumberJTextField.setBounds( 16, 86, 104, 21 );
	      accountNumberJTextField.setEditable( false );
	      accountNumberJTextField.setHorizontalAlignment( 
	         JTextField.RIGHT );
	      accountJPanel.add( accountNumberJTextField );
	      
	      balanceJLabel = new JLabel();
	      balanceJLabel.setText( "Balance:" );
	      balanceJLabel.setBounds( 16, 116, 100, 16 );
	      accountJPanel.add( balanceJLabel );
	      
	      // set up balanceJTextField
	      balanceJTextField = new JTextField();
	      balanceJTextField.setText( "0" );
	      balanceJTextField.setBounds( 16, 132, 104, 21 );
	      balanceJTextField.setEditable( false );
	      balanceJTextField.setHorizontalAlignment( JTextField.RIGHT );
	      accountJPanel.add( balanceJTextField );
	   
	      enterJPanel = new JPanel();
	      enterJPanel.setLayout( null );
	      enterJPanel.setBounds( 160, 16, 152, 260 );
	      enterJPanel.setBorder( 
	         new TitledBorder( "Enter information" ) );
	      contentPane.add( enterJPanel );
	      
	      transferToJLabel = new JLabel ();
	      transferToJLabel.setText( "ID-Transfer To:" );
	      transferToJLabel.setBounds( 16,24, 100, 30);
	      enterJPanel.add( transferToJLabel );
	      
	      transferToJTextField = new JTextField();
	      transferToJTextField.setText( "**** **** **** ****" );
	      transferToJTextField.setBounds( 16,45, 122, 21 );
	      transferToJTextField.setHorizontalAlignment( JTextField.RIGHT );
	      enterJPanel.add( transferToJTextField );
	      transferToJTextField.addMouseListener(new MouseAdapter(){
	          public void mouseClicked(MouseEvent e){
	        	  transferToJTextField.setText("");
	         }
	          }
	      );
	      
	      transferAmountJLabel = new JLabel ();
	      transferAmountJLabel.setText( "Type in the money:" );
	      transferAmountJLabel.setBounds( 16,66, 120, 30 );
	      enterJPanel.add( transferAmountJLabel );
	      
	      
	      transferAmountJTextField = new JTextField();
	      transferAmountJTextField.setText( " " );
	      transferAmountJTextField.setBounds( 16,96, 122, 21  );
	      transferAmountJTextField.setHorizontalAlignment( JTextField.RIGHT );
	      enterJPanel.add( transferAmountJTextField );
	      
	      
	      dateJL = new JLabel ();
	      dateJL.setText( "Date:" );
	      dateJL.setBounds( 16,120, 230, 30 );
	      enterJPanel.add( dateJL );
	      
	      
	      dateJTF = new JTextField("");
	      dateJTF.setBounds( 16,144, 120, 21  );
	      dateJTF.setHorizontalAlignment( JTextField.RIGHT );
	      dateJTF.setEditable(false);
	      enterJPanel.add( dateJTF );
	      dateJTF.addMouseListener(
	    		  new MouseAdapter()
	    		  {
	    			  public void mouseClicked(MouseEvent e)
	    			  {
	    				  viewDate= new date();
	    				  
	    			  }
	    		  }
	    		  );

	      
	      weekdaysJCheckBox = new JCheckBox();
	      weekdaysJCheckBox.setBounds( 16,172, 140, 30  );
	      weekdaysJCheckBox.setText( "Weekdays" );
	      enterJPanel.add( weekdaysJCheckBox );
	      
	      

	      
	      onlyWeekendCheckBox =  new JCheckBox();
	      onlyWeekendCheckBox.setBounds( 16,200, 150, 30  );
	      onlyWeekendCheckBox.setText( "Weekends" );
	      enterJPanel.add( onlyWeekendCheckBox );
	      
	      enterJButton = new JButton("Confirm");
	      enterJButton.setBounds( 8, 200, 152, 34 );
	      contentPane.add( enterJButton );
 
	      enterJButton.addActionListener(

	         new ActionListener() // anonymous inner class
	         {
	            // event handler called when enterJButton is pressed
	            public void actionPerformed( ActionEvent event )
	            {
	            	try
	            	{
	            		String date = dateJTF.getText();
	            	  String money = transferAmountJTextField.getText();
	            	  String ID = transferToJTextField.getText();
	            	  double dough = Double.parseDouble(transferAmountJTextField.getText());
	            	  
	            	  
	            	  if(dough < 0)
	            	  {
	            		  JOptionPane.showMessageDialog( null, 
	            		            "No Negatives", "Error",
	            		            JOptionPane.ERROR_MESSAGE );
	            	  }
	            	  
///////////////////////////////BUG CHECK LETTERS/////////////////////	            	 
	            	else if( date.equals("")||money.equals(""))
	            	{
	            		 JOptionPane.showMessageDialog( null, 
	            		            "You should fill out everything", "Error",
	            		            JOptionPane.ERROR_MESSAGE );
	            	}
	            	
	            	else if(!weekdaysJCheckBox.isSelected() && !onlyWeekendCheckBox.isSelected())
	            	{
	            		JOptionPane.showMessageDialog( null, 
            		            "You should fill out everything", "Error",
            		            JOptionPane.ERROR_MESSAGE );
	            	}
	            	  
	            	else if(ID.equals("**** **** **** ****"))
	            	{
	            		JOptionPane.showMessageDialog( null, 
            		            "Fill out the ID please", "Error",
            		            JOptionPane.ERROR_MESSAGE );
	            	}
	            	  
	            	else if(ID.equals(""))
	            	{
	            		JOptionPane.showMessageDialog( null, 
            		            "Fill out the ID please", "Error",
            		            JOptionPane.ERROR_MESSAGE );
	            	}
	            	else// one that works
	            	{
	            		transferHis = new TransferHistory();
	            		transferHis.setHistory(dough, date, ID);
	            	}
	            }
	            	catch(Exception x)
	            	{
	            		JOptionPane.showMessageDialog( null, 
            		            "SomeThing is wrong", "Error",
            		            JOptionPane.ERROR_MESSAGE );
	            	}
	            	
	            }
	         }
	           );
	      
	      transferHistory = new JButton("Transfer History");
	      transferHistory.setBounds( 8, 235, 152, 34 );
	      contentPane.add( transferHistory );
	      transferHistory.addActionListener(

	         new ActionListener() // anonymous inner class
	         {
	            // event handler called when enterJButton is pressed
	            public void actionPerformed( ActionEvent event )
	            {
	            	transferHistoryActionPerformed( event );
	            }

				private void transferHistoryActionPerformed(ActionEvent event) 
				{
					transferHis = new TransferHistory();	
				}
	         }
	           );
	      
	      setTitle("Transfer");
	      setVisible(true);
	      setSize(320,300);
	      setLocationRelativeTo(null);
	   }
	   
	   
	public static void main(String[] args) {

		Transfer application = new Transfer();
	    application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}
