import java.awt.*;//Abstract Windowing Toolkit=AWT
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class DepositWithdraw extends JFrame
{


  
   private JPanel financialJPanel;
private JLabel depositJL;
private JTextField depositJTF;
private JLabel withdrawlJL;
private JTextField withdrawlJTF;
private JButton fSubmitJButton;
private JButton homePage;
private JRadioButton checkingJRadioButton;
private JRadioButton savingJRadioButton;
private JButton DepositJButton;
private JButton WithdrawJButton;
private JLabel grass;
private JLabel sky;
private JLabel sky2;
private JLabel colored;
private JLabel colored2;



private String bal;
private String name,email,phone,address,password, type;




public DepositWithdraw()
   {
      createUserInterface();
   }


public void getInfo(String n,String e,String p,String b,String a,String passwd,String type1) {
	    name=n;
   	
		email=e;
		phone=p;
		address=a;
		password = passwd;
		type=type1;
	
}


public void getBalance (String b)
{
	bal = b;
}

   public void createUserInterface()
   {
     
      Container contentPane = getContentPane();
      contentPane.setBackground(Color.white);
      contentPane.setLayout( null ); 

     
//////////////////////////////////////////////Financials///////////////////////////////////////////////////////////////////		
financialJPanel = new JPanel();
financialJPanel.setBounds(20,130,450, 260);
financialJPanel.setLayout(null);
financialJPanel.setBackground(Color.white);
financialJPanel.setBorder( new TitledBorder( "Edit Financials" ) );
contentPane.add(financialJPanel);

depositJL = new JLabel("Deposit money:($)");
depositJL.setBounds(10,70,150,30);
depositJL.setForeground(Color.BLACK);
financialJPanel.add(depositJL);

depositJTF = new JTextField("0");
depositJTF.setBounds(150,70,70,30);
depositJTF.setEditable(false);
financialJPanel.add(depositJTF);
depositJTF.addMouseListener(new MouseAdapter(){



public void mouseClicked(MouseEvent e)
{
depositJTF.setBounds(150,70,150,30);

withdrawlJTF.setBounds(150,115,70,30);
}

}
);

withdrawlJL = new JLabel("Withdraw money:($)");
withdrawlJL.setBounds(10,115,150,30);
withdrawlJL.setForeground(Color.BLACK);
financialJPanel.add(withdrawlJL);

withdrawlJTF = new JTextField("0");
withdrawlJTF.setBounds(150,115,70,30);
withdrawlJTF.setEditable(false);
financialJPanel.add(withdrawlJTF);
withdrawlJTF.addMouseListener(new MouseAdapter(){

public void mouseClicked(MouseEvent e)
{
withdrawlJTF.setBounds(150,115,150,30);
depositJTF.setBounds(150,70,70,30);
}

}
);

checkingJRadioButton = new JRadioButton("Deposit Money");
checkingJRadioButton.setBounds(10,20,150,40);
financialJPanel.add( checkingJRadioButton );
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
				 depositJTF.setEditable(true);

				withdrawlJTF.setEditable(false);
				WithdrawJButton.setVisible(false);
				  DepositJButton.setVisible(true);
			}

		  }
			  );

savingJRadioButton = new JRadioButton("Withdraw Money");
savingJRadioButton.setBounds(150,20,150,40);
financialJPanel.add( savingJRadioButton );
savingJRadioButton.addActionListener(
		  
		  new ActionListener()
		  {
			  public void actionPerformed( ActionEvent event)
			  {
				
				  savingJRadioButtonPerformed( event );
				

			  }

			private void savingJRadioButtonPerformed(ActionEvent event) {
				checkingJRadioButton.setSelected(false);
				  depositJTF.setEditable(false);
				  withdrawlJTF.setEditable(true);
				  DepositJButton.setVisible(false);
				  WithdrawJButton.setVisible(true);
			}

		  }
			  );


DepositJButton = new JButton(new ImageIcon("Deposit-Button1.gif"));
DepositJButton.setBounds( 20, 150, 150, 100 );
DepositJButton.setVisible(true);
financialJPanel.add( DepositJButton );
DepositJButton.addActionListener(
     
     new ActionListener() 
     {
        
         public void actionPerformed ( ActionEvent event )
         {
          try{

        	 
        		 double deposit = Double.parseDouble(depositJTF.getText());
        		 double withdrawl =  Double.parseDouble(withdrawlJTF.getText());
        	 
    
        	 
        		 if(deposit < 0 || withdrawl < 0)
        		 {
            	 		JOptionPane.showConfirmDialog(null, 
            	 			"Positive numbers only", "ERROR", 
            	 			JOptionPane.ERROR_MESSAGE);
        		 }
        		 if(deposit == 0 && withdrawl == 0)
        		 {
        			 JOptionPane.showConfirmDialog(null, 
             	 			"Please select the thing you want to do by selecting the radio button.", "ERROR", 
             	 			JOptionPane.ERROR_MESSAGE);
        		 }
        		 
        		 else
        		 {
        			// MasterController.inFChange(deposit, withdrawl);
        			// MasterController.outHomeB();
        			 
        			 System.out.println("deposit is: " + deposit);
        				System.out.println("withdrawl is: " + withdrawl);
        				
        				double balance = Double.parseDouble(bal);
        				double newbal = balance + deposit;
        				AccountHomePage ahp = new AccountHomePage();
        				ahp.getBalanceFromDW(newbal);
        				ahp.setVisible(true);
    	            	ahp.getUserBasicInfo1(name,email,phone,address,String.valueOf(newbal), password,type);
    	            	ahp.historyJTA("Deposit/Withdraw successfully!");
        				

        		 }
        	 }
        	 catch(Exception x)
        	 {
        		 JOptionPane.showMessageDialog(null, "Please fill out everything with sufficent numbers",
						 "ERROR", JOptionPane.ERROR_MESSAGE);
        	 }
       

        		 //close this window
         }

     } 

  ); 

WithdrawJButton = new JButton(new ImageIcon("withdrawCashButton.gif"));
WithdrawJButton.setBounds( 180, 165, 230, 70 );
WithdrawJButton.setVisible(true);
financialJPanel.add( WithdrawJButton );
WithdrawJButton.addActionListener(
     
     new ActionListener() 
     {
        
         public void actionPerformed ( ActionEvent event )
         {
          try{

        	 
        		 double deposit = Double.parseDouble(depositJTF.getText());
        		 double withdrawl =  Double.parseDouble(withdrawlJTF.getText());
        	 
    
        	 
        		 if(deposit < 0 || withdrawl < 0)
        		 {
            	 		JOptionPane.showConfirmDialog(null, 
            	 			"Positive numbers only", "ERROR", 
            	 			JOptionPane.ERROR_MESSAGE);
        		 }
        		 if(deposit == 0 && withdrawl == 0)
        		 {
        			 JOptionPane.showConfirmDialog(null, 
             	 			"Please select the thing you want to do by selecting the radio button.", "ERROR", 
             	 			JOptionPane.ERROR_MESSAGE);
        		 }
        		 
        		 else
        		 {
        			// MasterController.inFChange(deposit, withdrawl);
        			// MasterController.outHomeB();
        			 
        			 System.out.println("deposit is: " + deposit);
        				System.out.println("withdrawl is: " + withdrawl);
        				
        				double balance = Double.parseDouble(bal);
        				double newbal = balance - withdrawl;
        				AccountHomePage ahp = new AccountHomePage();
        				ahp.setVisible(true);
        				ahp.getBalanceFromDW(newbal);
        				ahp.setVisible(true);
    	            	ahp.getUserBasicInfo1(name,email,phone,address,String.valueOf(newbal), password,type);
    	            	ahp.historyJTA("Deposit/Withdraw successfully!");
        				
        		 }
        	 }
        	 catch(Exception x)
        	 {
        		 JOptionPane.showMessageDialog(null, "Please fill out everything with sufficent numbers",
						 "ERROR", JOptionPane.ERROR_MESSAGE);
        	 }
       

        		 //close this window
         }

     } 

  ); 

      
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
         			AccountHomePage ahp = new AccountHomePage();
         			
         		}
            	 
             }

         } 
         
      ); 
sky = new JLabel(new ImageIcon("cloud-background-resized3-vail-blue-sky-limo.jpg"));
sky.setBounds(0, 80, 600, 280 );
sky.setVisible(true);
contentPane.add( sky );
colored= new JLabel(new ImageIcon("Wide_San_Diego_Night.jpg"));
colored.setBounds(0, -530, 500, 1040 );
colored.setVisible(true);
contentPane.add( colored );
   
colored2= new JLabel(new ImageIcon("colored2.jpg"));
colored2.setBounds(-1000, 0, 1000, 80 );
colored2.setVisible(true);
contentPane.add( colored2 );

grass = new JLabel(new ImageIcon("6--603810-Green Grass On White Background. Matte Channel..jpg"));
grass.setBounds(0, -150, 1000, 800 );
grass.setVisible(true);
contentPane.add( grass );





      
      setTitle( "Deposit and Withdraw" ); // set title bar text
      setSize( 500, 540 );     // set window size
      setVisible( true );      // display window

   }

   public static void main(String[] args) 
	{
		DepositWithdraw AH = new DepositWithdraw();
		AH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}




}