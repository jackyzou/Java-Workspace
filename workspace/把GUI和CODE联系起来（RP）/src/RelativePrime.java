

public class RelativePrime  
{

	private int firstNumber;
	private int secondNumber;
	
	
	public RelativePrime(int first, int second)
	{
		firstNumber =  first;
		secondNumber = second;
	
	} // end constructor
	
	
	//method relativelyPrime
	public void relativelyPrime()
	{
		
		int smallest = Math.min(firstNumber, secondNumber);
		boolean flag = false;
		
		
		for(int counter = 2; counter <= smallest; counter++)
		{
			if(firstNumber % counter == 0 && secondNumber % counter == 0)
			{
				flag = true;
				break;
			}
			
		}
		
		if(flag == false)
		{
			System.out.println("The first number " + firstNumber + " and the" +
					" second number " + secondNumber + " are relatively prime"  );
			
		}
		else
		{
			System.out.println("The first number " + firstNumber + " and the" +
					" second number " + secondNumber + " are NOT relatively prime"  );
			
			
		}
		
		
		
	}
	
	
}
