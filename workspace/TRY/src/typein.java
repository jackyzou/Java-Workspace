import java.util.*;

import javax.swing.JOptionPane;
public class typein {
	public static void main(String[] args)
	{
			Scanner input = new Scanner(System.in);
			System.out.print("type in the day of today£º");
			int n = input.nextInt();
			
			
			
	switch(n)
	{
	case 1:System.out.println("Monday");
	break;
	case 2:System.out.println("Tuesday");
	break;
	case 3:System.out.println("Wednesday");
	break;
	case 4:System.out.println("Thursday");
	break;
	case 5:System.out.println("Friday");
	break;
	case 6:System.out.println("Saturday");
	break;
	case 7:System.out.println("Sunday");
	break;
	}
	System.out.print("type in the month£º");
	int m = input.nextInt();
	
	
	switch(m)
	{
	case 1:System.out.println("Jan");
	break;
	case 2:System.out.println("Feb");
	break;
	case 3:System.out.println("Mar");
	break;
	case 4:System.out.println("Apr");
	break;
	case 5:System.out.println("May");
	break;
	case 6:System.out.println("Jun");
	break;
	case 7:System.out.println("Jul");
	break;
	case 8:System.out.println("Aug");
	break;
	case 9:System.out.println("Sep");
	break;
	case 10:System.out.println("Oct");
	break;
	case 11:System.out.println("Nov");
	break;
	case 12:System.out.println("Dec");
	break;
	}
	
	   Object[] obj2 ={ "1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15",
			            "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};  
	    String s = (String) JOptionPane.showInputDialog(null,"Select the day:\n", "Select today", JOptionPane.PLAIN_MESSAGE, null, obj2, "×ãÇò"); 
	
	    JOptionPane.showInputDialog(null,"Type in your name£º\n","NAME",JOptionPane.PLAIN_MESSAGE,null,null, "Type in here");  
	  Object[] options = {"Confirm", "Cancel"}; 
	  
	    JOptionPane.showOptionDialog(null, "R U sure you want to exit£¿", "EXIT", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]);
	
	 
	
	
	
	
	}
}
