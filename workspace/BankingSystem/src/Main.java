
//Driver
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Account Setup - construct a number of savings accounts
		RegularSavingAccount Pil=
				new RegularSavingAccount("Jess Pil", 500000.0, "2 Crab Street, Newtonville, NJ, 08844", "asdf@gmail.com",
						1112905, 1234, 2011112090, 30);//lives here right now

		RegularSavingAccount Tushar=
				new RegularSavingAccount("Tushar Gupta", 1000.0, "12 Pixie Dust, New York, NY, 09720", "coolboy@@rps.com", 
						1232000, 4321, 1000123456, 20);
		
		RegularSavingAccount Jesse = 
				new RegularSavingAccount("Jesse Johnson", 3000000.0, "39 Jesse Lane, Old Book, NJ 08839","jesse@hotmail.com",
						2017834, 1001, 2100000023, 20 );
		
		RegularSavingAccount allAccounts[] = new RegularSavingAccount[20];// 20 spot
		
		allAccounts[0] = Pil;
		allAccounts[1] = Tushar;
		allAccounts[2] = Jesse;
		
		for(int i = 0; i < 3; i++)
		{
			System.out.println("NAME: " + allAccounts[i].getName() + "    ADDRESS: " + allAccounts[i].getAddress());
		}
		
		
		
		
		
		
	}

}
