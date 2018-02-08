import java.util.Scanner;


public class Test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*int x = 1;
int n = 3; 
int nnn = 1;
int nn = 1;

while(x<n)
{
	
	
	
while(nn<=nnn)
{
	System.out.print("*");
	nn++;
}
System.out.print("\n");
x++;
nnn++;
}

*/
	
		System.out.println("type in:");
		Scanner scan1 = new Scanner (System.in);
		int i = scan1.nextInt();
		
		
		do
		{
			for(int j=0;j<i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
			i=i-2;
		}while(i>0);
	}

		

		

	}
	

