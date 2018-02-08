import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class Screen extends JFrame {

	//toLowerKeys, toHigherKeys
	
	//date
	private Container contentPane;//object
	private JTextField enterRJTextField,enterGJTextField,enterBJTextField;
	

	
//constructor
	public Screen()
	{
		
		createUserInterface();//this is method
	}
		
		private void createUserInterface()
		{
			contentPane = getContentPane();
			contentPane.setLayout(null);
			
			
		
			
		setVisible(true);
		setSize(500,500);
		setTitle("Screen");
		setLocationRelativeTo(null);
	}
public void changeSize(int sizeX, int sizeY )
{
	contentPane.setSize(sizeX,sizeY);
}
public void changeColor(String color)
{
	
	
	if(color.toLowerCase().equals("red"))
	{
		contentPane.setBackground(Color.red);
	}
	else if(color.toLowerCase().equals("blue"))
	{
		contentPane.setBackground(Color.blue);
	}
	else if(color.toLowerCase().equals("cyan"))
	{
		contentPane.setBackground(Color.cyan);
	}
	else if(color.toLowerCase().equals("green"))
	{
		contentPane.setBackground(Color.green);
	}
	else if(color.toLowerCase().equals("gray"))
	{
		contentPane.setBackground(Color.gray);
	}
	else if(color.toLowerCase().equals("yellow"))
	{
		contentPane.setBackground(Color.yellow);
	}
	else if(color.toLowerCase().equals("magenta"))
	{
		contentPane.setBackground(Color.magenta);
	}
	else if(color.toLowerCase().equals("lightGray"))
	{
		contentPane.setBackground(Color.lightGray);
	}
	else if(color.toLowerCase().equals("DARK_GRAY"))
	{
		contentPane.setBackground(Color.DARK_GRAY);
	}
	else if(color.toLowerCase().equals("orange"))
	{
		contentPane.setBackground(Color.orange);
	}
	else if(color.toLowerCase().equals("pink"))
	{
		contentPane.setBackground(Color.pink);
	}
	else if(color.toLowerCase().equals("white"))
	{
		contentPane.setBackground(Color.white);
	}

	else if(color.toLowerCase().equals("choose"))
	{
////////Color Panel		
	}
	else 
	{
	  
	     int x = JOptionPane.showConfirmDialog(null, 
 				"There is no such color,press checkRGB¡ú¡ú¡ú¡ú¡ú ", " Choose ", JOptionPane.YES_NO_CANCEL_OPTION);
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
		{      enterRJTextField.setVisible(true);
	      enterGJTextField.setVisible(true);
	      enterBJTextField.setVisible(true);
		//Means Yes
			System.out.print("Yes");
		}
	     contentPane.setBackground(Color.white);
	}
	
	

	    	  
	
	


	//string comparing
}

	
	
}
