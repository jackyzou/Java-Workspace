
public class LongDistanceCall extends PhoneCall 
{
private final double LongDRate = 6.0;
private int cost;

public LongDistanceCall(int duration)
{
	super(duration);
	calculationCost();


}
private int calculationCost()
{
	cost = (int)Math.round(LongDRate * super.Duration());
	return cost;

}
public double getRate()
{
	return LongDRate;
	
}
public String toString()
{
	return super.toString()+"LD";
}

	

}
