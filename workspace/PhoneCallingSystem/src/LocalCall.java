
public class LocalCall extends PhoneCall {

	private int callDuration;
	private int cost;
	private double rate;
	
	
	public LocalCall(int mins, double r)
	{
		super(mins);
		rate = r;
		//getRate();
		calculationCost();
	}
	
	private int calculationCost()
	{
		cost = (int)Math.round(rate * super.Duration());
		return cost;
	}
	public String toString()
	{
		return super.toString()+"LC";
	}

	public double getRate() {
		return rate;
	}
}
