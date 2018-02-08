import java.io.IOException;


public class FuckArray {
	public static void main(String []args)
	{

int two[] [] = new int[] []  {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};


	for(int row = 0; row <two.length;row++)
	{
		System.out.println("The row is: "+row);
		for(int col = 0; col <two.length;col++)
		{
			int store = two[col][two.length-1];
			
			for(int i=1;i<=two.length;i++)
			{
				  two[1][row]= two[0][row];
			      two[2][row]= two[1][row];
			      two[3][row]= two[2][row];
			      two[4][row]= two[3][row];
			      two[0][row]= store;
		     

			}
			int m[][]=new int[two.length][two[0].length];

			System.out.print(two[row][col]+"  ");
			//System.out.println(two[col][two.length-1]);
		}
		
		System.out.println(" ");
	}

	}
}