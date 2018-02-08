import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


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
	private static logIn login;
	private static setupPage setup;

	public static PrintWriter  print;

	
	public MasterController()
	{
		setup = new setupPage();
		setup.setVisible(true);
		
		home = new HomePage();
		edit = new EditProfile();
		t = new transferA();
		login = new logIn();
			
		home.setVisible(false);
		edit.setVisible(false);
		t.setVisible(false);
		login.setVisible(false);
	}
	
	public static void inSetup(double b, String u, String p, String e, String f)
	{
		ballance = b;
		username = u;
		password = p;
		email = e;
		phoneN = f;
		
		WriteInfo();
	}
	
	public static void inPChange(String u, String p, String e, String ph)
	{
		username = u;
		password = p;
		email = e;
		phoneN = ph;
		
		//WriteInfo();
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
	
	public static void inBallance(double b)
	{
		ballance = b;
	}
	
	public static void inUsername(String u)
	{
		username = u;
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
	
	public static void openLogIN()
	{
		login.setVisible(true);
		setup.setVisible(false);
	}
	
	public static void openTransfer()
	{
		t.setVisible(true);
		edit.setVisible(false);
		t.changeStuff(username, ballance);
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
		t.changeStuff(username, ballance);
	}
	
	public static void logTOset()
	{
		setup.setVisible(true);
		login.setVisible(false);
	}
	
	public static void restart()
	{
		home.setVisible(false);
		setup.setVisible(true);
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
		  	try
		  	{
		  		// Create file 
		  		FileWriter fstream = new FileWriter(username+".txt");
		  		BufferedWriter out = new BufferedWriter(fstream);
		  		out.write(email+"\n");
		  		out.write(phoneN+"\n");
		  		out.write(ballance+"\n");
		  		out.write(password+"\n");
		  		
		  		out.close();  //Close the output stream
		   }
		  
		  catch (Exception e) //Catch exception if any
		  {
		  	System.err.println("Error: " + e.getMessage());
		  }
		  
		 
	}
	public static void ReadInfo(String userN) throws Exception
	{
		username = userN;
		System.out.println(userN);
		FileReader fstream = new FileReader(username+".txt");
		BufferedReader in = new BufferedReader(fstream);
		Scanner scan = new Scanner(in);
		
		
		String s = "";
		while(scan.hasNext())
		{
			s += scan.next() + ";";
		}
		
		String delim = ";";
		StringTokenizer t = new StringTokenizer(s,delim);
		ArrayList <String> list  = new ArrayList<String>();
		
		while(t.hasMoreTokens())
		{
			list.add(t.nextToken());
		}
	
		email = list.get(0);
		phoneN = list.get(1);
		ballance = Double.parseDouble(list.get(2));
		password = list.get(3);
		 

		System.out.println("list 0 is: " + list.get(0));
		System.out.println("list 1 is: " + list.get(1));
		System.out.println("list 2 is: " + list.get(2));
		System.out.println("list 3 is: " + list.get(3));
		System.out.print(s);	
		
		in.close();
		scan.close();
		
	}
}

