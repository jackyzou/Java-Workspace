import javax.swing.JFrame;


public class Main
{

	public static void main(String[] args)
	{
		HomeScreen app = new HomeScreen();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		OptionsPage app1 = new OptionsPage();
		app1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		ColligativeProperties app2 = new ColligativeProperties();
		app2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		Dilutions app3 = new Dilutions();
		app3.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		Molarity app4 = new Molarity();
		app4.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		IdealGases app5 = new IdealGases();
		app5.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		Wave app6 = new Wave();
		app6.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		MolarMass app7 = new MolarMass();
		app7.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		PercentError app8 = new PercentError();
		app8.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		PHPOH app9 = new PHPOH();
		app9.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

}
