import java.util.*;
public class switchs {
	public static void main(String[] args)
{
		Scanner input = new Scanner(System.in);
		System.out.print("type in：");
		int n = input.nextInt();
	
	
	switch(n*3%2)
	{//case could be string
	
	case 1: 
		System.out.println("I am doing case 1");//do something then break,danger:do something can be while loop, it can be another switch
		switch(n + 1)
		{
		case 6:System.out.println("I am doing case 2 in the case 1");
			break;
		case 4:
			break;
		case 1:
			break;
		default:System.out.println("I am doing nothing in case 1");
		}
		break;//如果没有这个break，那么这一项和下一项的输出结果就相同
	case 2:
		System.out.println("I am doing case 2");
		
		break;
	case 3:
		System.out.println("I am doing case 3");
		break;
	case 6:
		System.out.println("I am doing case 6");
		break;
	case 7:
		switch(n - 3)
		{
		case 0:
			break;
		case 4:
			break;
		case 1:
			break;
		}
		default:System.out.println("I am doing nothing");//do something
			//default is like an else
	}
}
}
