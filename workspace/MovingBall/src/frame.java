import java.util.Timer;

import javax.swing.JFrame;


public class frame {

	public static void main(String args[])
	{
		Ball b = new Ball();
		JFrame f = new JFrame();
		f.add(b);
		f.setVisible(true);
		f.setTitle("Moving Shape");
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	}
	
