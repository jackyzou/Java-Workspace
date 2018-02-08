/////////////Jacky Zou's Matrix Project//////////////
/////////////Jacky Zou's Matrix Project//////////////
/////////////Jacky Zou's Matrix Project//////////////
/////////////Jacky Zou's Matrix Project//////////////
import javax.swing.JOptionPane;


public class MatrixClass {
	



	 private static int array1[] [] = new int[] []  {{1,2,3},{4,8,7},{2,4,5}};//here manually change the matrix


	 private static int array2[] [] = new int[] []  {{8,4,2},{3,5,4},{0,9,2}};//here manually change the matrix

	
	private static int row;
	
	private static int col;
	
	
	private static int ans[][];
	
	public static void main(String []args)
	{

    array1();
    array2();
    MatrixAddition( array1,array2);
    MatrixSubtraction( array1,array2);
    MatrixMultiplication( array1,array2);//open the method and pass the arrays
    }
	
	public static void array1()
	{
		 System.out.println("The first matrix is: "+"\n");

		for( row = 0; row < array1.length;row++)
		{
			System.out.println("   ");
			for( col = 0; col <array1.length;col++)
			{
			

				System.out.print(array1[row][col]+"  ");//test the print
			
			}
			
			
		}
		System.out.println("   ");
	}
	
	public static void array2()
	{
		 System.out.println("The second matrix is: "+"\n");

		for( row = 0; row < array2.length;row++)
		{
			System.out.println("   ");
			for(col = 0; col <array2.length;col++)
			{
			

				System.out.print(array2[row][col]+"  ");//test the print
			
			}
			
			
		}
		System.out.println("   ");
	}
	
	public static int[][] MatrixAddition(int a[][], int b[][])
	{
	try{
		
	
		  System.out.println("The Matrices addition is: "+"\n");
		  for(int i=0; i<row; i++)
		  {
			    for(int j=0; j<col; j++)
			    {
			    	 int matrix[][]=new int [100][100];
			    	 matrix[i][j] = a[i][j] + b[i][j];
			        System.out.print(matrix[i][j]+"  ");
			    }System.out.println();
			    }
		 System.out.println("\n");
	

	}
	catch(Exception x)
	{//if col!=row, then do this
		 JOptionPane.showMessageDialog( null,
		            "THE MATRICES DO NOT MATCH",
		            "ERROR", JOptionPane.WARNING_MESSAGE );
	}
	return ans;
	}
	
	public static int[][] MatrixSubtraction(int a[][], int b[][])
	{
		try
		{
		System.out.println("The Matrices subtraction is: "+"\n");
		
		for(int i=0; i<row; i++)
		{
		    for(int j=0; j<col; j++)
		    {
		    	 int matrix[][]=new int [100][100];
		    	 matrix[i][j] = a[i][j] - b[i][j];
		        System.out.print(matrix[i][j]+"  ");
		    }
		    System.out.println();
		    }
		 System.out.println("\n");
		}
		catch(Exception x)
		{
			 JOptionPane.showMessageDialog( null,
			            "THE MATRICES DO NOT MATCH",
			            "ERROR", JOptionPane.WARNING_MESSAGE );
		}
	
return ans;

	}
	
	

	public static int[][] MatrixMultiplication(int a[][], int b[][])
	{
		try
		{
			System.out.println("The Matrices Multiplication is: "+"\n");
			
			 int matrice[][]=new int[10][10];
		 for(int i=0;i<row;i++)
			    {
     for(int j=0;j<col;j++)
		 {
			    for(int k=0;k<col;k++)
			    {
			    	matrice[i][j]+=a[i][k]*b[k][j];
			    }
			}
			    }

			  
			    for(int i=0;i<row;i++)
			    {
			    for(int j=0;j<col;j++)
			    {
			        System.out.print(matrice[i][j]+"  ");
			    }
			    System.out.println();//this make a new line every row
			   
			    }
			
			
		}
		catch(Exception x)
		{
			 JOptionPane.showMessageDialog( null,
			            "THE MATRICES DO NOT MATCH",
			            "ERROR", JOptionPane.WARNING_MESSAGE );
		}
	
return ans;

	}
	
public static void print()
{
	    for(int i=0;i<row;i++)
	    {
	    for(int j=0;j<col;j++)
	    {
	        System.out.print(ans[i][j]+"  ");
	    }
	    System.out.println();//this make a new line every row
	   
	    }
	

}
}
