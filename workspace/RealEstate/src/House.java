
public class House implements Comparable

{
	private double price,size;
	
	public House(double p, double s)
	{
		price = p;
		size = s;
		
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int compareTo(Object other)//(House other)就只能compare house
	{
		House h = (House)other;
		
		if(this.getPrice()>h.getPrice())
		{
			return 1;
		}
		else if (this.getPrice()<h.getPrice())
		{
			return -1;
		}
		else
		{
			return 0;
		}
		
		
		
	}
	public int compareToI(Object other)
	{
		House h = (House)other;
		
		return (int)(this.getPrice() - h.getPrice());//一减就知道正负
		
		
	}

}
