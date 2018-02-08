
public class AND {
public static void main(String args[])
{
	// && means and
	// || means or
	// ! means not - negation
	/*
	 * For an AND connective all statements must be true - to get a true result
	 */
	/*
	 * For OR connecton one statement needs to be true - to get one true result
	 */
	/* Statement is not a variable, can be x<5
	 * Truth Table: Statement A,B then Results are A&&B. If statement A, B are true,then A&&B are true. If one of A,B is not true, then results are not true, If A B are false, then result is false.
	 * Use boolean to represent A B true or false, true 1, false 0. A B的 true false 乘在一起，if the result is 0 ,then false.
	 */
	/* short circuit, one false, all false
	 * OR statements A B true, A||B True. A B false, A||B false. otherwise, false(A B opposite)
	 * !&&=|| (not and = or)
	 */
	int x=3,y=4,z=5;
	
/*	if(!(x==3))
	{
		System.out.println("sdfs"); 
	}
	if(!(x<5))
	{
		System.out.println("8888"); 
	}
	if(x>=5)
	{
		System.out.println("kkkk"); 
	}*/

if((x>3)&&(x<7))//short circuit with false
{
	
}

//↓↓↓ EQUALS TO ↓↓↓
if(x==4 || x==5 || x==6)//short circuit with true
{
	
}

if(x>3)
{
	if(x<7)
{

}
}


}
}
