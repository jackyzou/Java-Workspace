
public class Checking extends Account {//implements here means have to doµÄÊÂ


	


	public Checking(String n, double w, double d, double i, double t, double b,
			double TAX, double c, String h, String s, String p)
	{
		super();
	}
	public Checking()
	{
		super();
	}

	public double deposit(double amount)
	{
		if(amount>300)
		{
		//	return super.setBalance(amount);//pass job to his parents
		}
		return 0.0;//default
	}
}
