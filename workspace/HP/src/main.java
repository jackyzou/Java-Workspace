
public class main {


	public static void main(String[] args) {
		//A objectA = new A();
		//B objectB = new B();
		A object = new C();//AP EXAM!!从右往左读，C可以是B，new B不能 = C
		A object1 = new A();
		//C objectC = new B();//这个不行
		//C可以做A+B以及更多的东西，所以最末端的kid最capable
	
		Sellable b = new B();//对的
		//Sellable s = new Sellable();//这是错的， 因为interface 不是object
		b.sell();
		
		object.print();
		System.out.println(object1.toString());//toString() share by all object, it's extends object
	}

}
