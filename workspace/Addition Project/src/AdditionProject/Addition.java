package AdditionProject;

public class Addition {
	
	private double firstValue;
	private double secondValue;
	private double thirdValue;
	private double result;
	
	public Addition(double first, double second,double third)
	{
		firstValue = first;
		secondValue = second;
		thirdValue = third;
	}
	
	public  void sum()
	{
		 result = firstValue + secondValue+thirdValue;
	}

	
	public void printSum()
	{
		if(result<100)
		{
		System.out.println("The sum of"+" " + firstValue +" "+ "and"+" "+secondValue +"and"+" "+thirdValue +" "+ "is"+" " + result);
		}
		else
		{
			System.out.println("type in less than 100");
			
		}
	}
	
}
