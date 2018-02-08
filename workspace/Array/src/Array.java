
import java.util.ArrayList;//this is faster than the thing below
import java.util.*;


public class Array {

public static void main( String[] args ) 
{
/*
int i = 20;
String people[] = new String[i];

people[0] = "Neha";
people[1] = "Louis";
people[2] = "Neel";
people[3] = "Jacky";
people[4] = "Lake";
//...
people[5] = "Neha";
people[6] = "Neha";
people[7] = "Neha";
people[8] = "Neha";
people[9] = "Neha";
*/
String arrayOfNames[] = {"Lake","Neha", "Bobby", "Shawn", "Tanvi","Jacky", "Neel","Abdulluh"/*...*/};



//alphabetical order
//Arrays.sort(arrayOfNames);

//use this to print everything in the Array
for(int i = 0; i<arrayOfNames.length; i+=5)
{
System.out.println(arrayOfNames[i]);

arrayOfNames[i] = "Lake";
}
//arrayOfNames[] = 10;


//System.out.println(arrayOfNames[0]);
ArrayList list=new ArrayList (100);

list.add(1);
list.add(2);
list.remove(0);//remove the 0 index
list.add(1,3);//first value is the index,and the second value is the number you wanted to add

System.out.println(list.get(0));
} 
}









