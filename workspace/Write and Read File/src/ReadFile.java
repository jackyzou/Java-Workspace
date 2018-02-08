import java.io.*;
import java.util.*;


public class ReadFile 
{
	
	public static void main(String args[])throws Exception
	{
		
		
		FileReader fstream = new FileReader("out.txt");
		BufferedReader in = new BufferedReader(fstream);
		Scanner scan = new Scanner(in);
	
		
		
		in.readLine();//every time only read one line, create a loop for this to read all
		
		
		
		String s = "";
		while( scan.hasNext())
		{
			s += scan.next() + " ";
		}
		
		StringTokenizer t = new StringTokenizer(s);//seperate each token by space
		ArrayList <String> list  = new ArrayList<String>();
		while(t.hasMoreTokens())
		{
			list.add(t.nextToken());
		}
		System.out.println(list);
		System.out.print(s);	
		
		in.close();
		scan.close();
		
	}
	

}