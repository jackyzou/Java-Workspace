import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;


public class MasterController 
{
	private static double ballance;
	private static double deposit;
	private static double withdrawl;
	
	private static String username;
	private static String password;
	private static String email;
	private static String phoneN;
	private static String fileName;
	private static String dateA;
	
	private static HomePage home;
	private static EditProfile edit;
	private static transferA t;
	private static Date dateObject;

	public static PrintWriter  print;

	
	public MasterController()
	{
		setupPage setup = new setupPage();
		setup.setVisible(true);
		
		home = new HomePage();
		edit = new EditProfile();
		t = new transferA();
			
		home.setVisible(false);
		edit.setVisible(false);
		t.setVisible(false);;
	}
	
	public static void inSetup(double b, String u, String p, String e, String f)
	{
		ballance = b;
		username = u;
		password = p;
		email = e;
		phoneN = f;
	}
	
	public static void inPChange(String u, String p, String e, String ph)
	{
		username = u;
		password = p;
		email = e;
		phoneN = ph;
	}
	
	public static void inFChange(double d, double w)
	{
		deposit = d;
		withdrawl = w;
		
		ballance = deposit - withdrawl;
		
		System.out.println("deposit is: " + deposit);
		System.out.println("withdrawl is: " + withdrawl);
		System.out.println("ballance is: " + ballance);
	}
	
	public static void outHomeP()
	{
		WriteInfo();
		edit.setVisible(false);
		
		home.setVisible(true);
		home.changeUserName(username);
		home.changeEmail(email);
		home.changePhoneNumber(phoneN);
	}
	
	public static void outHomeB()
	{
		edit.setVisible(false);
		
		home.setVisible(true);
		home.changeBallance(ballance, deposit, withdrawl);
	}
	
	
	public static void openEdit()
	{
		edit.setVisible(true);
	}
	
	public static void openHomeCloseEdit()
	{
		home.setVisible(true);
		edit.setVisible(false);
	}
	
	public static void doLoan(double total)
	{
		home.setVisible(true);
		edit.setVisible(false);
		
		home.homeLoan(total);
	}
	
	public static void openTransfer()
	{
		t.setVisible(true);
		edit.setVisible(false);
	}
	
	public static void openDate()
	{
		dateObject = new Date();
	}
	
	public static void inDate(String dateB)
	{
		dateA = dateB;
		dateObject.dispose();
		transferA.showDate(dateB);
	}
	
	public static void doTransfer(double amount, String ID)
	{
		home.doHomeTransfer(dateA, amount, ID);
	}
	
	public static void printInfo()
	{
		System.out.println("ballance is " + ballance);
		System.out.println("username is " + username);
		System.out.println("email is " + email);
		System.out.println("phoneN is " + phoneN);
	}
	public static void WriteInfo()
	{
		fileName = new String(username + ".txt");
		try {
			 print = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print.write(username);
		print.write("\n");
		print.write(String.valueOf(ballance));
		print.write("\n");
		print.write(email);
		//more stuff here
	}
	public static void ReadInfo()
	{
		try {
			BufferedReader buff = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

