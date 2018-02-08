import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MasterController 
{
	private static double ballance;
	private static double deposit;
	private static double withdrawl;
	private static double transfer;
	
	private static String username;
	private static String password;
	private static String email;
	private static String phoneN;
	private static String fileName;
	
	private static HomePage home = new HomePage();
	private static EditProfile edit = new EditProfile();
	public static PrintWriter print;
    private static ManagerAccount manager = new ManagerAccount();
	
	public MasterController()
	{
		setupPage setup = new setupPage();
		setup.setVisible(true);
		
		home.setVisible(false);
		edit.setVisible(false);
		manager.setVisible(false);
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

	public static void openManagerAccount() 
	{
		home.setVisible(false);
		edit.setVisible(false);
		manager.setVisible(true);
	}

	public static void doLoan(double total)
	{
		home.setVisible(true);
		edit.setVisible(false);
		
		home.homeLoan(total);
	}
	
	public static void openManager()
	{
		manager.setVisible(true);
		
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
		fileName = new String(username);

	
		//more stuff here
		
		  try{
			  // Create file 
			  FileWriter fstream = new FileWriter(fileName+".txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(username);
			  out.write(String.valueOf(ballance));
			  out.write(email);
			
			  out.close();
			  //Close the output stream

			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
			
	}
	public static void ReadInfo() throws Exception
	{
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


		System.out.println(list);
		System.out.print(s);	
		
		in.close();
		scan.close();

	}

}

