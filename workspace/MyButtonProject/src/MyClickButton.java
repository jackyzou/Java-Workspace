//API

import java.awt.*;//abstruct window toolkid
import java.awt.event.*;//因为要do something
import javax.swing.*;


public class MyClickButton extends JFrame //'extends JFrame' is very important.
{
	private JButton clickerJButton;
	private JButton clickerJButton2;
	private JButton clickerJButton3;
	private Container contentPane;
	
	public MyClickButton()
{
    createUserInterface();	
    
}
	private void createUserInterface()
{
		contentPane =getContentPane();
    	contentPane.setLayout(null);
		
		clickerJButton =new JButton(new ImageIcon("0008.gif"));
		clickerJButton.setBounds(100,100,100,100);
		contentPane.add(clickerJButton);
			
		clickerJButton.addActionListener(
				
				new ActionListener()// 这个是发令者
				{
					public void actionPerformed(ActionEvent event)//new ActionListener()发完令，就由这个来工作
					{
					 	
					 contentPane.setBackground(Color.cyan);
					}
				}
				
				
				
				
				
				);//被指令的按键，每次多点空格,记得打{}
		
		clickerJButton2 =new JButton("Click This one");
		clickerJButton2.setBounds(200,100,100,100);
		contentPane.add(clickerJButton2);
			
		clickerJButton2.addActionListener(
				
				new ActionListener()// 这个是发令者
				{
					public void actionPerformed(ActionEvent event)//new ActionListener()发完令，就由这个来工作
					{
					 System.out.println("CLOSE IT");	
					 contentPane.setBackground(Color.yellow);
					}
				}

				);
		clickerJButton3 =new JButton(new ImageIcon("phone_icon.jpg"));
		clickerJButton3.setBounds(300,100,100,100);
		contentPane.add(clickerJButton3);
			
		clickerJButton3.addActionListener(
				
				new ActionListener()// 这个是发令者
				{
					public void actionPerformed(ActionEvent event)//new ActionListener()发完令，就由这个来工作
					{
					 	
					 contentPane.setBackground(Color.RED);
					}
				}
				
				
				
				
				
				);
        setSize(500,500);
		setVisible(true);
		setTitle("Click the button!");
		setResizable(false);
}
		public static void main(String args[])
		
{
			MyClickButton app = new MyClickButton();
			app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
}	
	
                                                                          }
