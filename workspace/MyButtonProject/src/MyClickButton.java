//API

import java.awt.*;//abstruct window toolkid
import java.awt.event.*;//��ΪҪdo something
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
				
				new ActionListener()// ����Ƿ�����
				{
					public void actionPerformed(ActionEvent event)//new ActionListener()������������������
					{
					 	
					 contentPane.setBackground(Color.cyan);
					}
				}
				
				
				
				
				
				);//��ָ��İ�����ÿ�ζ��ո�,�ǵô�{}
		
		clickerJButton2 =new JButton("Click This one");
		clickerJButton2.setBounds(200,100,100,100);
		contentPane.add(clickerJButton2);
			
		clickerJButton2.addActionListener(
				
				new ActionListener()// ����Ƿ�����
				{
					public void actionPerformed(ActionEvent event)//new ActionListener()������������������
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
				
				new ActionListener()// ����Ƿ�����
				{
					public void actionPerformed(ActionEvent event)//new ActionListener()������������������
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
