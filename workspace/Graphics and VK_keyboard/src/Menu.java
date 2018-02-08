import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


public class Menu extends JFrame implements ActionListener {

	private JMenu menu;
	private JMenuBar bar;
	private JRadioButtonMenuItem red;
	private JRadioButtonMenuItem blue;
	private JRadioButtonMenuItem black;
    private String flag;

	
	public Menu()
	{
		
	bar = new JMenuBar();
	menu = new JMenu("Colors");
	
	red = new JRadioButtonMenuItem("Red");
	blue = new JRadioButtonMenuItem("Blue");
	black = new JRadioButtonMenuItem("Black");
	
	setLayout(new FlowLayout());
	setSize(300,250);
	setTitle("Colors");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	bar.add(menu);

	menu.add(red);
	menu.add(blue);
	menu.add(black);
	
	ButtonGroup group = new ButtonGroup();
	group.add(red);
	group.add(blue);
	group.add(black);
	
	red.addActionListener(this);
    blue.addActionListener(this);
	black.addActionListener(this);
	
	add(bar);
	
	System.out.println(flag());
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == red)
		{
			setBackground(Color.RED);
			flag = "red";
		}
		if(e.getSource() == blue)
		{
			setBackground(Color.blue);
			flag = "blue";
		}
		if(e.getSource() == black)
		{
			setBackground(Color.BLACK);
			flag = "black";
		}
	
	}
	public String flag()
	{
		return flag;
		
	}

	


	
}


