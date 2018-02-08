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
	   private JCheckBox wholeWeekJCheckBox;
	 

       private JButton enterJButton;
       private JButton chooseDate;
	   private date viewDate;
	   
	   
	   private JButton transferHistory;
	   private TransferHistory transferHis;
   	     public Transfer()
	   {
	      createUserInterface();
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
	      nameJTextField.setText( "Abdacky" );
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
	      enterJPanel.setBounds( 160, 16, 152, 176 );
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
	      

	      
	      weekdaysJCheckBox = new JCheckBox();
	      weekdaysJCheckBox.setBounds( 16,112, 120, 30  );
	      weekdaysJCheckBox.setText( "Weekdays" );
	      enterJPanel.add( weekdaysJCheckBox );
	      
	      
	//selected BUG
	      
	      
	      wholeWeekJCheckBox = new JCheckBox();
	      wholeWeekJCheckBox.setBounds( 16,137, 120, 30  );
	      wholeWeekJCheckBox.setText( "week+weekend" );
	      enterJPanel.add( wholeWeekJCheckBox );
	      
	      
	      chooseDate = new JButton("Choose date");
	      chooseDate.setBounds( 168, 200, 152, 34 );
	      contentPane.add( chooseDate );
	      chooseDate.addActionListener(

	         new ActionListener() // anonymous inner class
	         {
	            // event handler called when enterJButton is pressed
	            public void actionPerformed( ActionEvent event )
	            {
	            	chooseDateActionPerformed( event );

	            }

				private void chooseDateActionPerformed(ActionEvent event) {
					
					viewDate= new date();
					
				}
	         }
	           );
	      
	      
	      
	      enterJButton = new JButton("Confirm");
	      enterJButton.setBounds( 16, 200, 152, 34 );
	      contentPane.add( enterJButton );
	      enterJButton.addActionListener(

	         new ActionListener() // anonymous inner class
	         {
	            // event handler called when enterJButton is pressed
	            public void actionPerformed( ActionEvent event )
	            {
	            	  enterJButtonActionPerformed( event );

	            }

				private void enterJButtonActionPerformed(ActionEvent event) {
					
					
					
				}
	         }
	           );
	      
	      transferHistory = new JButton("Transfer History");
	      transferHistory.setBounds( 92, 235, 152, 34 );
	      contentPane.add( transferHistory );
	      transferHistory.addActionListener(

	         new ActionListener() // anonymous inner class
	         {
	            // event handler called when enterJButton is pressed
	            public void actionPerformed( ActionEvent event )
	            {
	            	transferHistoryActionPerformed( event );

	            }

				private void transferHistoryActionPerformed(ActionEvent event) {
					
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