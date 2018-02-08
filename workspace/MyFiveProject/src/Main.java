
public class Main 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiveObject Jacky= new FiveObject(10);//construct a new five object called Jacky
		FiveObject Needy =new FiveObject(20);
		Needy.printValue();
        Jacky.printValue();
        Jacky.addFive();
        Jacky.printValue();
	}//can't do value++ because it cannot access it, private

}
