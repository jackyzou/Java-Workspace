
public class RP {
private int number1,number2;
	public RP(int n1, int n2)
	{
		setN1(n1);
		setN2(n2);
	}
	public RP()
	{
		setN1(0);
		setN2(0);
	}
	public void setN1(int n1)
	{
		number1=n1;
	}
	public void setN2(int n2)
	{
		number2=n2;
	}
	public int getN1()
	{
		return number1;
	}
	public int getN2()
	{
		return number2;
	}
	public void printInfo()
	{
		int smallest = Math.min(getN1(), getN2());
	
		boolean flag= false;
		for(int counter = 2; counter<=smallest; counter++)
		{
			if(getN1() % counter == 0 && getN2() % counter ==0)//not relative prime
			{
				flag = true;
				break;
			}
		}
		if(!flag)//(flag == false)
		{
		System.out.println("The firstNumber nubmer "+this.getN1()+" and the" + " second number " 
		+ getN2() +" are relatively prime");	
		}
		else
		{
			System.out.println("The firstNumber nubmer "+this.getN1()+" and the" + " second number " 
					+ getN2() +" are not relatively prime");	
		}
	
		
	}
	
}
