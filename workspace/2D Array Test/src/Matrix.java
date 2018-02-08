import java.lang.reflect.Array;

import javax.swing.JButton;

public class Matrix 
{
	
	JButton[] button = new JButton[100];//the number in the braket shows how many buttons in the array
	
	int array[] = new int []{1,2,3,4,5};
	//OR
	int a1[]= {1,2,3,4,5};
	
	array[0]= array[1]+array[2];
	array[4]+=array[2];
	array[0]+=array[0];
	
	private int[][] array1;
	private int[][] array2;
	
	
	public Matrix(int [][]a1, int [][]a2)
	{
		setArray1(a1);
		setArray2(a2);
	}
	
	public void setArray1(int[][] a)
	{
		array1 = a;
	}
	
	public void setArray2(int[][] a)
	{
		array2 = a;
	}
	
	public int[][] add()
	{
		//Check to make sure that array1 can be added to array2
		//If array1 is NOT the same size as array2, they cannot be added
		//Otherwise make a local array variable to hold the sum and return it after adding
		
	}
	
	public int[][] subtract()
	{
		//Check to make sure that array2 can be subtract from array1
		//If array1 is NOT the same size as array2, they cannot be subtracted
		//Otherwise make a local array variable to hold the difference and return it after subtracting

		
	}
	public int[][] multiply()
	{
		//Check to make sure that array1 can be multiplied by array2
		//If the column of array1 is NOT the same size as the row of array2, they cannot be multiplied
		//Otherwise make a local array variable to hold the product and return it after multiplying

	}
	
	
	
	
	
}