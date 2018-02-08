//class definition
//¡ý¡ý¡ý¡ý¡ý¡ý¡ý¡ý¡ý¡ý¡ý¡ý
  public class FiveObject //public is can give it out to others and work, all is send me the file, and work. FiveObject walking around and find things to add 5.
{

	//data, do a data list declare
	private int value;//this is the value that add 5 to. private is not accessing outside of the class. Using other, can't change it.
	
	
	
	
	//constructor, it makes the object, have a way to construct, if don't, java make one for you, it's mandatory
	public FiveObject(int v)
	{
		//initialize the data, send(assign) value to something
		this.value = v;//coding, it's always 1, dummy do all the thing, and get kick out.
		
	}//data(made me), how(how made me), what to do
	//method(s)
	public void addFive()
	{
		value += 5;
	}
	public void printValue()
	{
		System.out.println("The value is:" + value);
	}
	
	
	
}
