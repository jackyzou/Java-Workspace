
public class Quiz13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	String array[] = {"c","o","m","p","u","t","e","r","s"};
		String array2[]=new String[9];
	
			for(int i = 8; i >=0;i--)
			{
			array2[i]=array[i];
			System.out.print(array2[i]);
			}
	*/
		int array[]= new int[50];
		

		int i = 2;
		int c = 0;
		int num = 0;
		
		while(num>=0)
		{
			while(i<num)

			{
				while(!(num % i == 0))
				{
					while(c<array.length)
					{
						array[c]= array[num];
						c++;
						System.out.print(array[c]);
					}
				
					
				}
			i++;
			}
			num++;
		}		
			
			
	


	}
}
