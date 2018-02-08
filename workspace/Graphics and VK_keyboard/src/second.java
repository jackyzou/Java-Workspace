import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;


public class second extends JPanel implements ActionListener, KeyListener {
	
	Timer t = new Timer(5,this);

	double x=0 , y=0, velx=0, vely=0;
	double a=100 , b=400, vela=0, velb=0, k =40, z = 20;
	Thread th = new Thread();
	public second()
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
	
	
		Line2D line = new Line2D.Double(300,200,0,500);
		Rectangle2D rectangle =new Rectangle2D.Double(200,220,100,100);
		Ellipse2D oval = new Ellipse2D.Double(210,130,80,80);
	
		g2.draw(line);
		g2.setPaint(Color.blue);
		g2.fill(rectangle);
		g2.setPaint(Color.red);
		g2.fill(oval);
	

		
		Graphics2D g3= (Graphics2D) g;
		g3.setPaint(Color.green);
		g3.fill(new Ellipse2D.Double(x,y,20,40));
		g3.setPaint(Color.gray);
		g3.fill(new Ellipse2D.Double(a,b,k,z));
	  //  g2.setXORMode(Color.green);
	
	int x = t.getDelay();
	while(x%2 == 0)
	{	
		try {
			th.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	g2.setPaint(Color.ORANGE);	

	}
	x++;
	}
public void actionPerformed(ActionEvent e)
{
	if(x<0|| x>500)
{
	velx = -velx;
}
	if(a<0|| a>500)
	{
		vela = -vela;
	}

if(y<0 || y> 650)
{
	vely = -vely;
}
if(b<0 || b> 650)
{
	velb = -velb;
}
	repaint();
	x += velx;
	y += vely;
	a += vela;
	b += velb;
}


public void up()
{
	vely = -1.5;
	velx = 0;
}
public void down()
{
	vely = 1.5;
	velx = 0;
}
public void left()
{
	vely = 0;
	velx = -1.5;
}
public void right()
{
	
	vely = 0;
	velx = 1.5;
}
public void stop()
{
	velx = vely =0;
}
public void up1()
{
	velb = -1.5;
	vela = 0;
}
public void down1()
{
	velb = 1.5;
	vela = 0;
}
public void left1()
{
	velb = 0;
	vela = -1.5;
}
public void right1()
{
	
	velb = 0;
	vela = 1.5;
}
public void stop1()
{
	vela = velb =0;
}
public void kill()
{
	k = 200;
	z = 220;
}
public void slow()
{
	second k = new second();
	k.setVisible(true);
}

public void keyPressed(KeyEvent e)
{
	int code = e.getKeyCode();
	
	if(code == KeyEvent.VK_UP)
	{
		up();
		
	}
	if(code == KeyEvent.VK_DOWN)
	{
		down();
		
	}
	if(code == KeyEvent.VK_LEFT)
	{
		left();
		
	}
	if(code == KeyEvent.VK_RIGHT)
	{
		right();
		
	}
	
	if(code == KeyEvent.VK_U)
	{
		up1();
		
	}
	if(code == KeyEvent.VK_J)
	{
		down1();
		
	}
	if(code == KeyEvent.VK_H)
	{
		left1();
		
	}
	if(code == KeyEvent.VK_K)
	{
		right1();
		
	}
	if(code == KeyEvent.VK_SLASH)
	{
		kill();
		
	}
	 
	if(code == KeyEvent.VK_E)
	{
		slow();
		
	}
	
	if(code == KeyEvent.VK_C)
		
	{
		Menu m  = new Menu();
		m.setVisible(true);

		System.out.print(m.flag());
		
	}
	if(code == KeyEvent.VK_S)
	{
		stop();
		stop1();
	}
	

	
	
	
	
	
	
	
}
public void keyTyped(KeyEvent e){}

public void keyReleased(KeyEvent e){}
}
