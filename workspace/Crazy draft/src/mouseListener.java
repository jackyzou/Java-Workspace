import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class mouseListener extends Applet implements MouseListener {

	boolean mouseEntered;
	
float hhh= 170.f;
	
	public mouseListener()
	{
		 addMouseListener(this); 
	}
	 public void paint(Graphics g)  
	 { 
		 

		  if (mouseEntered==true){
			  g.drawString("Mouse is in the applet area",20,160); 
			  //System.out.print(hhh);
		  }
		  else{
			  g.drawString("Mouse is outside the Applet area",20,160); 
		  }
	 }
	 public void mouseEntered (MouseEvent me) { 
		  // Will draw the "inside applet message" 
		  mouseEntered = true; 
		  repaint(); 
		 }

		 // When the Mouse leaves the applet. 
		 public void mouseExited (MouseEvent me) { 
		  // will draw the "outside applet message" 
		  mouseEntered = false; 
		  repaint(); 
		 } 
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		 System.out.print("clicked"+" ");
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
