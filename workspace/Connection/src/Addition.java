
public class Addition//Object
{

private int firstNumber;//object
private int secondNumber;

public Addition(int f,int s)
{
	firstNumber =f;
	secondNumber =s;
}

public String add()
{
	int sum =firstNumber + secondNumber;
	
	return "The sum of "+String.valueOf(firstNumber)+" and "+String.valueOf(secondNumber)+" is "+String.valueOf(sum);
}


}
