import java.util.ArrayList;

import javax.swing.JFrame;


public class main {
	private static double balance ;
// two problems: 1. the name doesn't contain characters   2. the first login thing doesn't work
	public static void ahpSETbalance(double newBalance)
	{
		balance = newBalance;
		
	}
	public static void main(String[] args) {
		HomeScreen app = new HomeScreen();
		Verification v= new Verification();
		Account a = new Account();
		AccountHomePage ahp = new AccountHomePage();
		EditUserInfo eui = new EditUserInfo();
		Transfer r = new Transfer();

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<Account>accountList = new ArrayList<Account>(10);
		
		ahp.getBalanceFromTransfer(balance);
		
		a.getName();
	    a.getEmail();
		a.getAddress();
	    a.getPhone();
		a.getType();
		a.getBalance();
		
		accountList.add(a);
		
		
		//Get the text from all text fields
		//Store the values locally
		//Example -> String name = nameJTextField.getText(); // Do every single one
		//Do for all fields
		//Make and add the account -> accountList.add(new Account(name, balance, password, address, phone));
		
}
	

}