
public class A extends Object implements Sellable 
{
	
	public double sell()
	{
		return 2.0;
	}
	
	
	public A()
	{
		System.out.println("I am an A");
	}

	public void print()
	{
		System.out.println("I am an A printout");
	}
	
	public String toString()//在main叫的toString，一定要override Object
	{
		return super.toString()+"I am overriding Object's toString to say I am an A";
	}

	
}
