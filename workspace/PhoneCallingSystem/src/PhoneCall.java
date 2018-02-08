
public abstract class PhoneCall 
{
private int callDuration;
public abstract double getRate();

public PhoneCall(int mins)
{
	callDuration = mins;
	toString();
	}

public int Duration()
{
	return callDuration;
	
}

private int calculateCost()
{
	int cost;
	cost = (int)Math.round(callDuration*getRate());
	return cost;
}

public String toString()
{
	String statement = "Duration "+ callDuration+ " Rate "+ getRate()+" Total "+ calculateCost();
	System.out.print(statement);
	return statement;
}


//private method is a helper(just to pass stuff)

}
