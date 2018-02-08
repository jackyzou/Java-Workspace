import java.util.Scanner;
import javax.swing.JOptionPane;

public class FactoringTree {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("type in£º");
		int number = input.nextInt();
	 int i;
	
	 
		if(number>0)
		{
	
		if(number % 2==0 && number % 3==0 && number%5==0 && number%7 ==0)
		{
			System.out.println("2"+" "+"3"+" "+"5"+" "+"7");	
			
		}
			else if(number % 2==0 && number % 3==0 && number%5==0)
			{
				System.out.println("2"+" "+"3"+" "+"5");	
			}
			else if(number % 2==0 && number % 3==0)
			{
				System.out.println("2"+" "+"3");	
			}

			else if(number%2==0)
			{
				System.out.println("2");
			}
		//end of the 2 started one
	
         
		}
	 
	 
		else if(number>0)
		{
	 if(number%7==0 &&number%5==0 && number%3==0)
		{
			System.out.println("3"+" "+"5"+" "+"7");	
		}
	 else if(number%5==0 &&number%3==0)
		{
			System.out.println("3"+" "+"5");	
		}
	 else if(number%3==0)
		{
			System.out.println("3");	
		}
	 
		}
	//end of the 3 started one
		else if(number>0)
{
		if(number%7==0&&number%5==0)
		{
			System.out.println("5"+" "+"7");	
		}
		
	 else if(number%5==0)
	{
		System.out.println("5");	
	}
		}
	//end of the 5 started one
		if(number>0)
		{	
	if(number%7==0)
	{
		System.out.println("7");	
	}//end of the 7 started one
		
}//´óif½áÊø
else
		{
			  JOptionPane.showMessageDialog(null,"Positive Numbers please","ERROR",
 					  JOptionPane.ERROR_MESSAGE);  
		}
}//end main
	
}