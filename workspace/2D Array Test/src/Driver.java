
public class Driver {
public static void main(String []args)
{
	/*int OneDimension [] = new int[1];
	int grid [] [] = new int [4][6];
	
	String array [] [] = new String [6][4];
	
	array[3][2] = "hi";
	String hold = "";
	
	for(int i = 0; i <grid.length;i++)
	{
		grid[i][0] = 67;
		for(int k = 0; k <grid.length;k++)
		{
			hold += String.valueOf(grid[i][k])+"      ";
			
			
		}
		System.out.println(hold);
		hold = "";
	}
	
	
	
	for(int i = 0; i <array.length;i++)
	{
		for(int k = 0; k <array[i].length;k++)
		{
  array [i][k] = "GoGoGodget";
		}

	}
	*/
	
	int one[] =new int[] {2};
	int two[] []  = new int[] [] {{1,2,3},{4,5,6},{7,8,9}};

	
	for(int row = 0; row <two.length;row++)
	{
		System.out.println("The row is: "+row);
		for(int col = 0; col <two.length;col++)
		{
		
		
			    
			if(row==0)
			{
				int store = two[col][1];
				two[col][1]=two[col][row];
				
				two[col][0]=two[col][2];
			
				two[col][2]=store;
			}
			if(row==1)
			{
			   int store = two[col][2];
			   
               two[col][2]=two[col][row];
               
               two[col][2]=store;      
			}
			
			if(row==2)
			{
				int store = two[col][2];
				two[col][0]=two[col][row];
				two[col][2]=store;

			}	
			
				
				
		
		
			
			System.out.print(two[row][col]+"  ");
			
//			System.out.println("HERE  "+ two[col][two.length-1]); // use this method to print the last one of the col
			
		}
		System.out.println(" ");
	}
	
	
	
}
}
