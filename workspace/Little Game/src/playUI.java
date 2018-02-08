import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class playUI extends JPanel implements ActionListener, KeyListener { 
	
	
	Timer t = new Timer(5,this);

	double x=0 , y=0, velx=0, vely=0;
	double a=100 , b=400, vela=0, velb=0;

	public playUI()
	{
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
