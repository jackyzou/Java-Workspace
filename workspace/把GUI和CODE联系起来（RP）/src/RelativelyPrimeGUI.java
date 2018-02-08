import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RelativelyPrimeGUI extends JFrame
{
	private JButton submitJButton;
	private JTextField firstNumberJTextField, secondNumberJTextField;
	private JLabel firstJLabel, secondJLabel;
	private JTextArea outputJTextArea;
	private JScrollPane scroller;
	private RelativePrime prime;
	
	
	public RelativelyPrimeGUI()
	{
		createUserInterface();
	} // end constructor
	
	private void createUserInterface()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.green);
		
		submitJButton = new JButton("Test Relatively Prime");
		submitJButton.setBounds(10, 200, 180, 60);
		contentPane.add(submitJButton);
		submitJButton.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						getRelativePrimeInfo();
					}
				}
				
				);
		
		 firstNumberJTextField = new JTextField();
		 firstNumberJTextField.setBounds(150, 10, 50, 50);
		 contentPane.add(firstNumberJTextField);
		 
		 
		 firstJLabel = new JLabel("Enter First Integer:"); 
		 firstJLabel.setBounds(30, 10, 150, 50);
		 contentPane.add(firstJLabel);
		 
		 secondNumberJTextField = new JTextField();
		 secondNumberJTextField.setBounds(150, 110, 50, 50);
		 contentPane.add(secondNumberJTextField);

		 secondJLabel = new JLabel("Enter Second Integer:");
		 secondJLabel.setBounds(14, 110, 150, 50);
		 contentPane.add(secondJLabel);
		 
		 outputJTextArea = new JTextArea();
		 scroller  =  new JScrollPane(outputJTextArea);
		 scroller.setBounds(208, 10, 480, 400);
		 contentPane.add(scroller);
		 
		
		setSize(700, 500);
		setTitle("Relatively Prime");
		setVisible(true);
		setResizable(false);
	}// end createUserInterface
	
	public void getRelativePrimeInfo()
	{
		try
		{
			int first = Integer.parseInt(firstNumberJTextField.getText());
			int second = Integer.parseInt(secondNumberJTextField.getText());
			
			prime = new RelativePrime(first, second);
			 prime.relativelyPrime();
			
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, 
					"Please enter an integer in each field " +
					"and press the submit button to find out if the integers are " +
					"relatively prime.", 
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) 
	{
		
		RelativelyPrimeGUI app  = new RelativelyPrimeGUI();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
