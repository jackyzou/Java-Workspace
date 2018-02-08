
public class MasterController 
{
	private double ballance;
	private double deposit;
	private double withdrawl;
	private double transfer;
	
	private String username;
	private String password;
	private String email;
	private String phoneN;
	
	private HomePage home;
	private EditProfile edit;
	private setupPage setup;

	
	public MasterController()
	{
		setup = new setupPage();
		
	}
	
	public void inSetup(double b, String u, String p, String e, String f)
	{
		ballance = b;
		username = u;
		password = p;
		email = e;
		phoneN = f;
	}
	
	public void outHome()
	{
		home = new HomePage();
		home.changeBallance(ballance);
		home.changeUserName(username);
		home.changeEmail(email);
		home.changePhoneNumber(phoneN);
	}
	

}

