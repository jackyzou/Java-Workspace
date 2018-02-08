import javax.swing.JOptionPane;


//object

public class RegularSavingAccount 

{

//withdraw = check

//every withdraw = $1 fee

//fee variable to hold fees and display accumulated amount of fees

//deposit = can't deposit less then $200 


//data - instance variables

	private String name;

	private double balance;

	private String address;

	private String email;

	private int phoneNumber;

	private int pinNumber;

	private int accountNumber;

	private double fee;


//constructor

	public RegularSavingAccount(String n, double bal,String a, String e, int f, int p, int ac, double fe)

	{	

		setName(n);

		setBalance(bal);

		setAddress(a);

		setEmail(e);

		setPhoneNumber(f);

		setPinNumber(p);

	    setAccountNumber(ac);
}


//methods

	// setter replace info,//getter retrieve info.
	// ...no return.......//return
	public String getName()
	{

		return name;

	}


	public String getEmail()

{

		return email;
	
}


		public String getAddress()

{

			return address;

}


		public double getBalance()

{

			return balance;

}


public int getphoneNumber()

{

return phoneNumber;

}


public int getpinNumber()

{

return pinNumber;

}


public double getFee()

{

return fee;

}


public void setPhoneNumber(int newNumber)

{

phoneNumber = newNumber;

}


public void setBalance(double newBalance)

{

	if(newBalance>0)
	{
		balance = newBalance;
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Only Positive Numbers","ErRoR",JOptionPane.ERROR_MESSAGE);
	}

}


public void setEmail(String newEmail)

{

email = newEmail;

}


public void setPinNumber(int Pin)

{

pinNumber = Pin;

}


public void setAccountNumber(int acc)

{

accountNumber = acc;

}


public void setName(String newName)

{
//connect to the social security number
name = newName;

}


public void setAddress(String newAddress)

{
//Make sure that the address is correct
address = newAddress;

}


public double check(double amount)

{

if(balance >= amount)

{

balance -= amount;

fee += 1;

balance -= 1;

}

else

{

JOptionPane.showMessageDialog(null,"Insufficient Funds!","ERROR",JOptionPane.ERROR_MESSAGE);

}

return balance;

}


public double deposit(double amount)

{

if(amount < 200)

{

JOptionPane.showMessageDialog(null,"You can only deposit $200 or more!","ERROR",JOptionPane.ERROR_MESSAGE);

}

else if(amount >= 10000)

{

JOptionPane.showMessageDialog(null,"Warning! High Deposit!","WARNING",JOptionPane.INFORMATION_MESSAGE);

}

else if(amount > 0)

{

balance += amount;

}

else

{

JOptionPane.showMessageDialog(null,"No Negative Deposits!","ERROR",JOptionPane.ERROR_MESSAGE);

}

return balance;

}




public void printStatement()

{

System.out.println("Name: " + name);

System.out.println("Account Number: " + accountNumber);

System.out.println("Balance: $" + balance);

System.out.println("Address: " + address);

System.out.println("Email: " + email);

System.out.println("Phone Number: " + phoneNumber);

System.out.println("Total Accumulated Fees: $" + fee);

}

}

