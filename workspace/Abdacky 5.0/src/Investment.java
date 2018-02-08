
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Investment<myCalculator> extends JFrame
{
   private JButton stockJButton, insuranceJButton, goldJButton,
      currencyJButton, saveJButton, calculatorJButton;
  
   private JPanel windowJPanel, selectionJPanel;
   private JTextField displayJTextField;
   

   private CurrencyConverter myCurrencyConverter;
   private Calculator myCalculator;
   private JLabel money;
   private Save mySave;
   
   public Investment()
   {
      createUserInterface();
   }
   
    public void changeUserName(String username)
	{
		displayJTextField.setText(username);
		System.out.println(username);
	}
   private void createUserInterface()
   {
     
      Container contentPane = getContentPane();
      contentPane.setLayout( null );
      
 
      windowJPanel = new JPanel();
      windowJPanel.setBounds( 5, 20, 200, 230 );
      windowJPanel.setBorder( new LineBorder( Color.BLACK ) );
      windowJPanel.setLayout( null );
      contentPane.add( windowJPanel );
      
      money= new JLabel();
      money.setIcon(new ImageIcon("url-1.jpeg"));
      money.setBounds( 0, 0, 230, 230 );
      windowJPanel.add(money);
        
      // set up pushJButton
      calculatorJButton = new JButton();
      calculatorJButton.setText( "Calculator" );
      calculatorJButton.setBounds( 10, 265, 190, 30 );
      contentPane.add( calculatorJButton );
      calculatorJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	
		            	 myCalculator = new Calculator();
		            	 myCalculator.setVisible(true);
		            
		            	 myCalculator.setSize(300,300);
		             }

		         } 

		      );
      
      // set up displayJTextField
      displayJTextField = new JTextField();
      displayJTextField.setText( "User" );
      displayJTextField.setBounds( 210, 10, 170, 30 );
      displayJTextField.setEditable( false );
      displayJTextField.setHorizontalAlignment( JLabel.CENTER );
      contentPane.add( displayJTextField );
      
      
      // set up selectionJPanel
      selectionJPanel = new JPanel();
      selectionJPanel.setBounds( 210, 50, 170, 250 );
      selectionJPanel.setBorder( new TitledBorder( new EtchedBorder( 
         EtchedBorder.LOWERED ), "Please make selection" ) );
      selectionJPanel.setLayout( null );
      contentPane.add( selectionJPanel );
      
      // set up aJButton
      currencyJButton = new JButton();
      currencyJButton.setText( "Foreign Currency" );
      currencyJButton.setBounds( 15, 20, 142, 42 );
      selectionJPanel.add( currencyJButton );
      currencyJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	 myCurrencyConverter = new CurrencyConverter();
		            	 displayJTextField.setText("Forex");
		             }

		         } 

		      );
      
      // set up bJButton
      saveJButton = new JButton();
      saveJButton.setText( "Save" );
      saveJButton.setBounds( 15, 62, 142, 42  );
      selectionJPanel.add( saveJButton );
      saveJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	
		            	 mySave = new Save();
		            	 
		             	 displayJTextField.setText("Save and Interest");
		             }

		         } 

		      );
            
      // set up oneJButton
      stockJButton = new JButton();
      stockJButton.setText( "Stock" );
      stockJButton.setBounds( 15, 104, 142, 42 );
      selectionJPanel.add( stockJButton );
      stockJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	
		            	
		            	 
		             	 displayJTextField.setText("Stock");
		             }

		         } 

		      );
      
      // set up twoJButton
      insuranceJButton = new JButton();
      insuranceJButton.setText( "Real Estate" );
      insuranceJButton.setBounds( 15, 146, 142, 42 );
      selectionJPanel.add( insuranceJButton );
      insuranceJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	 
		             	 displayJTextField.setText("Real Estate"); 
		             }

		         } 

		      );
      
      // set up threeJButton
      goldJButton = new JButton();
      goldJButton.setText( "Gold" );
      goldJButton.setBounds( 15, 188, 142, 42 );
      selectionJPanel.add( goldJButton );
      goldJButton.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	
		            
		            	 
		             	 displayJTextField.setText("Commodity");
		             }

		         } 

		      );
           
      // set properties of application's window
      setTitle( "Investment" ); // set title bar text
      setSize( 395, 335 );          // set window size
      setVisible( true );           // display window

   } // end method createUserInterface
   
   // main method
   public static void main( String[] args ) 
   {
	   Investment application = new Investment();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main
   
} // end class VendingMachine
