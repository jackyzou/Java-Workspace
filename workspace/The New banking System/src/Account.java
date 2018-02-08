import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

//higher parent
public class Account extends Object 
{//instance variable

//data
//All the user informations
private  String UserName;	//the color became blue instance, in class all instance
	
private  String email;

private  String phone;

private  String address;

private  String password;

private  String balance;

private  String type;


 
private static  AccountHomePage ahp = new AccountHomePage();

private static EditUserInfo edit = new EditUserInfo();









//constructor





public void Account(String name, String email2, String phone2,
		String balance2, String address2, String password2, String type2) {
	// TODO Auto-generated method stub
    setName(name);
	
	setEmail(email2);
	
	setPhone(phone2);
	
	setAddress(address2);
	
	setPassword(password2);

	setBalance(balance2);
	
	setType(type2);

}





public Account(String n, String e,String tel,String a,String p, String b, boolean type)//dummy
{
	setName(n);
	
	setEmail(e);
	
	setPhone(tel);
	
	setAddress(a);
	
	setPassword(p);

	setBalance(b);
	
	setType(type);

	
}


private void setType(boolean type2) {

	
}


public Account()//this is a default constructor, in case that info not sufficient, set later
{
	setName("notset");
	setEmail("notset");
	setPhone("notset");
	setAddress("notset");
	setPassword("admin");
	setBalance("0.0");
    setType("notset");
	
}


////////////////////////////////////////////////////////////////SETTERS////////////////////////////////////////////////////////////////
public void setName(String n) {
	
	if(n!="")
	{
	UserName = n;  
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Please fill a name","ErRoR",JOptionPane.ERROR_MESSAGE);
	}
}

public  void setEmail(String e) {
	
	email = e;
	
}

public  void setType(String t) {
	type = t;
	
}


public  void setBalance(String b) {
	balance = b;
	
}

public void openVerification(){
	
	Verification v = new Verification(UserName, email, phone, address, password, balance, type);
	
}
public void setInfoToAccountPage()
{
	AccountHomePage ahp = new AccountHomePage(UserName, email, phone, balance,address, password, type);
}



public  void setPassword(String p) {
	int pp= p.length();
	if(pp > 15) 
	{
		  
			int k = JOptionPane.showConfirmDialog(null, 
    				" The password should be 15 characters or less! "
					, " ERROR ", JOptionPane.YES_OPTION);
			if(k == 1)
     		{
     			
     			//Means NO
     			System.out.print("NO");
     		}
     		
     		else if(k == 2)
     		{
     			
     			//Means Cancel
     			System.out.print("Cancel");
     		}
     		else 
     		{

     			//Means Yes
     			System.out.print("Yes");

		    }
	 }
			else
			{
 		
				password = p;
			}
			


}



public  void setAddress(String a) {
	address = a;
	
}



public  void setPhone(String tel) {
	phone = tel;
	
}






////////////////////////////////////////////////////////////////GETTERS////////////////////////////////////////////////////////////////
public String getName()
{
	return UserName;
}


public String getEmail() {
	
	return email;
	
}
public String getPhone() {
	
	return phone;
	
}
public String getAddress() {
	
	return address;
	
}
public String getPassword() {
	
	return password;
	
}
public String getBalance() {
	
	return balance;
	
}
public String getType() {
	
	return type;
	
}



public  void AHPEdit()
{
	
	edit.setVisible(false);
	
	ahp.setVisible(true);
	ahp.getUserBasicInfo(UserName,email,phone,balance,address,password,type);

}



public void readInfofromAcc(String userN) throws IOException
{
	UserName = userN;
	System.out.println(UserName);
	FileReader fstream = new FileReader(UserName+".txt");
	BufferedReader in = new BufferedReader(fstream);
	Scanner scan = new Scanner(in);
	
	
	String s = "";
	while(scan.hasNext())
	{
		s += scan.next() + "\n";
	}
	
	String delim = "\n";
	StringTokenizer t = new StringTokenizer(s,delim);
	ArrayList <String> list  = new ArrayList<String>();
	
	while(t.hasMoreTokens())
	{
		list.add(t.nextToken());
	}
	UserName = list.get(0);
	email = list.get(1);
	phone = list.get(2);
	balance = list.get(3);
	address = list.get(4);
	password = list.get(5);
	type = list.get(6);
	 

	System.out.println("list 0 is: " + list.get(0));
	System.out.println("list 1 is: " + list.get(1));
	System.out.println("list 2 is: " + list.get(2));
	System.out.println("list 3 is: " + list.get(3));
	System.out.println("list 4 is: " + list.get(4));
	System.out.println("list 5 is: " + list.get(5));
	System.out.println("list 6 is: " + list.get(6));
	
	System.out.print(s);	
	
	ahp.getUserBasicInfo(UserName,email,phone,balance,address,password,type);
	
	in.close();
	scan.close();
}





}
