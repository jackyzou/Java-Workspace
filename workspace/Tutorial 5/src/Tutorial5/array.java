package Tutorial5;

import java.util.*;
import javax.swing.*;

public class array 

{
private static final int Neha = 0;

public static void main(String args[])
{

	
	int array[] = new int[3];//array is just a name, can be changed,[] can be in front of the name.
	array [0] = 1;
	array [1]= 2;
	array [2]= 	array [0] + array [1];
	
	System.out.println(array [2]);
	
	
	//how to access the array
	//indices OFF BY ONE,so 0 is index, is the first one, 1 is actually the second one.
	
	String[] people = new String[11];//the last index is 10
	people[0] = "Neha";
	people[1] = "Ben";
	people[2] = "Bobby";
	people[3] = "Nidhi";
	people[4] = "Shawn";
	people[5] = "Tenci";
	people[6] = "Louis";
	people[7] = "Neel";
	people[8] = "Jacky";
	people[9] = "Jesse";
	people[10] = "Lake";
	
	for(int i = 0; i< people.length;i++)
	{
		System.out.println(people[i]);
		people[i] = "Lake";
		
	}

	
	String arrayOfNames[]={"Neha","Ben","Bobby"};

	System.out.println(arrayOfNames  [Neha]);

	ArrayList list=new ArrayList(100);

	list.add(1);
	list.add(2);
	list.remove(0);//remove the 0 index
	list.add(1,3);//first value is the index,and the second value is the number you wanted to add
	System.out.println(list);


}
}
