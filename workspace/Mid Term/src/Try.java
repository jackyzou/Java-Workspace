import java.util.Scanner;

public class Try
{
  static boolean is_odd(int n)
  {
   if(n==2||n==3) return true;
   if(n%2==0) return false;
   int i;
   for(i=3;i<=n/2;i+=2)
    if(n%i==0) return false;
   return true;
  } 
 
  public static void main(String[] args)
  {
   Scanner in=new Scanner(System.in);
   System.out.println("type in£º");
   int n=in.nextInt();
   int i;
   System.out.print(n+"=");
   for(i=2;i<=n;i++)
   {
    if(!is_odd(i)) continue;
    if(n%i==0)
    {
     while(true)
     {
      System.out.print(i);
      n/=i;
      if(n!=1) System.out.print("*");
      if(n%i!=0) break;
     }
    }
   }
   System.out.println();
  }
}