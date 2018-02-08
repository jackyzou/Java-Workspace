
public class ReducedRateCall extends LongDistanceCall{

public ReducedRateCall(int minutes)
{
	super(minutes);
}

public double getRate()
{
	return super.getRate()/2;
}

public String toString()
{
	return super.toString() + "RR"; 
}

}
