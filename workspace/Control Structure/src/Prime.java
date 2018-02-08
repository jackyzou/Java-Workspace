
public class Prime 
{
public static void main(String[] args)
{
	int number = 15;
	int i = 2;
	
if(number == 1)//check 1 first
{
	System.out.println(number+" "+ "Prime");
}
else if (number == 2)//check 2 second
{
	System.out.println(number+" "+"Prime");//if the number is 1 or 2 don't even bother looking for anything
}
	
else//the number is three or more b/c I checked 1 and 2 already 	
{

//this takes care of 3 or more
while(i<number)

	{
		if(number % i == 0)
		
		{
			System.out.println(number+" "+"Not Prime");
			break;
		}
		
		else
		{
			
			i++;
		}
		if(i == number)
		{
		System.out.println(number+" "+"Prime");
		}
		
	
	
	}//end while loop

}//end main method

}
}