import java.sql.*;
import java.awt.*;
import java.util.*;
import java.text.*;
import javax.swing.*;

import java.awt.event.*;

public class date
{
	private Container contentPane;//object
	private Transfer transfer;
	
    static String months[]={"Month","Jan","Feb","Mar","App","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};//months array filled with months
    
    static int getMonth(String month)
    {
    	for(int i = 0; i<12; i++) 
    	{
    		if(month == months[i])//If string month = month[i] return i
    							  // Ex is Feb = month[1], no.   Is Feb = month[2], yes
    			return i;		 // Return i which is 2
    	}
    	return 0;
    }
    public static void main(String args[])
    {	
    	date get = new date();
    	
    }
    public date()
    {
    	contentPane = getContentPane();
    	
    	JFrame f = new JFrame();
    	
    	f.getContentPane().setLayout(null);
    	
    	final JComboBox day = new JComboBox();
    	
    	final JComboBox month = new JComboBox();
    	
    	final JComboBox year = new JComboBox();	
    	
    	JButton button= new JButton("Submit");

		day.addItem("Day");
	
		year.addItem("Year");
		
		for(int i=1;i<=31;i++)
		{
			day.addItem(i);//fills day with numbers from 1 to 31
		}
		day.setBounds(10,10,10,10);
		
		for(int j=0;j<months.length;j++)
		{
			month.addItem(months[j]);
		}
		for(int k=1980;k<=2012;k++)
		{
			year.addItem(k);// fills years with numbers from 1980 to 2012
		}
	
		day.setBounds(135,50,80,20);
		month.setBounds(50,50,90,20);
		year.setBounds(210,50,90,20);
		
		button.setBounds(50,80,100,20);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				Object ob1 = day.getSelectedItem();
				Object ob2 = month.getSelectedItem();
				Object ob3 = year.getSelectedItem();
				
				if(ob1.equals("Day") || ob2.equals("Month") || ob3.equals("Year"))
				{
					
					 JOptionPane.showMessageDialog(null,"Please choose a date","ERROR",
	    					  JOptionPane.ERROR_MESSAGE);
				
					
				}
				else
				{
					
					int d = Integer.parseInt(ob1.toString());
				
					String mon = ob2.toString();
				
					int m = getMonth(mon);
					int y = Integer.parseInt(ob3.toString());
				
					Calendar cal = GregorianCalendar.getInstance();
					cal.set(y, m-1, d);  
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					System.out.println(sdf.format(cal.getTime()));
					transfer = new Transfer();
					transfer.getDate(sdf.format(cal.getTime()));
					
					
					
					
				}
			
			}	
		}
	);

	f.add(day);
	f.add(month);
	f.add(year);
	f.add(button);
	f.setVisible(true);
	f.setSize(300,200);

}
private Container getContentPane() {
	// TODO Auto-generated method stub
	
	return null;
}
}