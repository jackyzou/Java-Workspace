import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI extends JFrame{

	private JLabel pic;
	
	public GUI ()
	{
		createGUI();
	}
	
	private void createGUI()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		pic = new JLabel(new ImageIcon("microwave oven.jpg"));
		pic.setBounds(0,0,50,50);
		contentPane.add(pic);
		
		setTitle("hey");
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		GUI g = new GUI();
		g.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

}
