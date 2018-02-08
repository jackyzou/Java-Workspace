    import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	public class commonmultiple 
	{

	 public static void main(String[] args) 
	 {

	  int n1, n2, d;
	  String str;
	  try
	  {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   System.out.print("Type in an int n1：");
	   str = br.readLine();
	   n1 = Integer.parseInt(str);
	   System.out.print("Type in an int n2: ");
	   str = br.readLine();
	   n2 = Integer.parseInt(str);
	   if (n1 > n2) 
	   {
	    d = n1;
	   } 
	   else
	   {
	    d = n2;
	   }
	   for(int i = d; i <= n1 * n2; i ++) 
	   {
	    if(i % n1 == 0 && i % n2 == 0) 
	    {
	     System.out.println(n1 + "and" + n2 + "GCF:" + i);
	     break;
	    }
	   
	    }
	  } 
	   
	  catch (NumberFormatException e)
	  {
	   e.printStackTrace();
	  } catch (IOException e)
	  {
	   e.printStackTrace();
	  }
	 }

	}


/*
 * 
 * do{
     执行语句；
       }while（条件）；
这是一个循环语句；当条件为真时退出循环； 
 * 
 * 
*/
