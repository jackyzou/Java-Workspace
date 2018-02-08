
public class RelativePrime {
	
	private int firstNumber;
	private int secondNumber;
	
	public RelativePrime(int first, int second)
	{
		firstNumber = first;
		secondNumber = second;
	}
	
	public void relativelyPrime()//void is a return type, does things inside
	{
		int smallest = Math.min(firstNumber,secondNumber);
		boolean flag =false;
		for(int counter =2; counter<=smallest; counter++)
		{
			if(firstNumber % counter == 0 && secondNumber % counter ==0)//not relative prime
			{
				flag = true;
				break;
			}
		}
		
		if(!flag)//(flag == false)
		{
		System.out.println("The firstNumber nubmer "+this.firstNumber+" and the" + " second number " 
		+ secondNumber +" are relatively prime");	
		}
		else
		{
			System.out.println("The firstNumber nubmer "+this.firstNumber+" and the" + " second number " 
					+ secondNumber +" are not relatively prime");	
		}
		
	}
	

	public static void main(String[] args) {
	
		RelativePrime primeObject = new RelativePrime(3,8);
		
		
		primeObject.relativelyPrime();//to tell it do it, create the object, but without it, not working
		
	}

}
