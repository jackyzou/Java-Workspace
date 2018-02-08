import java.util.Scanner;


public class switchforevenandodd {
	//switch on int and char
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("type in£º");
		int n = input.nextInt();

		
		switch(n % 2)
		{
		case 0: System.out.println("The value"+" "+ n +" "+"is even" );
		break;
		
		default:System.out.println("The value"+" "+ n +" " +"is odd" );
		}
		
		
}//end main
	
}