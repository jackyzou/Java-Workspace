import java.awt.*;
import java.awt.event.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class DrawPad extends JPanel implements MouseListener{

	//private boolean ;
	private int x,y,xDrag,yDrag,currentX,currentY,width,height,size;
	private int rect,brush,circle,tri;
	Graphics2D graphics2D;
	Image image;
	private Rectangle recta;
	private boolean drawing;
   
	public DrawPad()
	{
		
		size = 1;
		this.setLayout(null);
		//addMouseListener(this);
		brush = 1;
	    addMouseListener(new MouseAdapter() { //when the mouse is pressed down...
	        public void mousePressed(MouseEvent e) { //^
	          x = e.getX(); // x cordinate of mouse in frame/window
	          y = e.getY();// y cordinate of mouse in frame/windows
	          System.out.println(x+ " " +y);
	          //drawing = true;
	          
	        }
	      });
	    

	    final Rectangle recta = new Rectangle();
	    
	    addMouseMotionListener(new MouseMotionAdapter() {
	        public void mouseDragged(MouseEvent e) { //when the mouse is dragged and pressed
	        	
	          currentX = e.getX(); //get the x cord if the mouse
	          currentY = e.getY(); //get the y cord
	          //if (graphics2D != null) //dont worry about this
	        	 //graphics2D.drawLine(x, y, currentX, currentY); //draw line from where the mouse is pressed to where it is dragged and released
	          //repaint(); //refresh the screen so everything is displayed
	          //x = currentX; //set the old to new
	          //y = currentY; //set the old to new
	          System.out.println(currentX+ " " +currentY+" "+rect+" "+brush);
	            if(rect ==1)
	            {
		         graphics2D.fillRect(x, y, currentX-x, currentY-y);

	            }
	            if(brush == 1)
	            {
	            	graphics2D.setStroke(new BasicStroke(size));
	            	graphics2D.drawLine(x, y, currentX, currentY);
	            	//graphics2D.fillOval(x ,  y, size-1 ,size-1);
	            	x=currentX;
	            	y=currentY;
	            }
	            if(circle == 1)
	            {
	            	int ox = (int) Math.sqrt(Math.pow(currentX-x,2)+Math.pow(currentY-y, 2));
	            	int oy = (int) Math.sqrt(Math.pow(currentX-x,2)+Math.pow(currentY-y, 2));
	            	int a = Math.abs(x-currentX)/2;
	            	int b = Math.abs(y-currentY)/2;
	            	
	            	graphics2D.fillOval(x-a ,  y-b, ox ,oy);
	            }
	            if(tri ==1)
	            {

	            	int r = (int) Math.sqrt(Math.pow(currentX-x,2)+Math.pow(currentY-y, 2));
	            	
					//Dimension size = temp.getSize();
	            	Point p1 = new Point(x,y-r);
	        		Point p2 = new Point((int) (x+((Math.sqrt(3))*r)/2),y+(r/2));
	        		Point p3 = new Point((int) (x-((Math.sqrt(3))*r)/2),y+(r/2));

	        		int[] xs = { p1.x, p2.x, p3.x };
	        		int[] ys = { p1.y, p2.y, p3.y };
	        		Polygon triangle = new Polygon(xs, ys, xs.length);

	        		graphics2D.fillPolygon(triangle);
	            }
	            
	          repaint();
	          
	        }
	      });
	   

	    

	    
	    
	}
	
	
	
	  public void paintComponent(Graphics g) { // painting things on the frame
		  super.paintComponent(g);
			//Graphics2D graphics = (Graphics2D) g;
		    if (image == null) {
		      image = createImage(getSize().width, getSize().height); // creating a new image the size of the fem
		      graphics2D = (Graphics2D) image.getGraphics(); //putting it on the frame
		      graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		          RenderingHints.VALUE_ANTIALIAS_ON);
		      clear();
		    }
		    g.drawImage(image, 0, 0, null);
		   // ((Graphics2D) g).draw(rect);
		  }
	  
	  public void clear() {
		    graphics2D.setPaint(Color.white);
		    graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		    graphics2D.setPaint(Color.black);
		    repaint();
		  }
	  
	  public void color(Color col)
	  {
		  graphics2D.setPaint(col);
		  repaint();

	  }
	/*public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D) g;
		
		if(drawRectangle = true)
		{
            graphics.fillRect(x, y, xDrag-x, yDrag-y);
            //drawRectangle = false;
		}
		
	}*/
	//@Override
	
	/*public void mouseClicked(MouseEvent e) {
		
		 x = e.getXOnScreen();
		 y = e.getYOnScreen();
	}*/
	
	

    
	/*public void mouseDragged(MouseEvent e) {
		xDrag = e.getXOnScreen();
		yDrag = e.getYOnScreen();
        
        drawRectangle = true;
	}*/
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//width = e.getX();
        //height = e.getY();
       
         //graphics2D.fillRect(x, y, width-x, height-y);
        // repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public void setRect()
	{
		rect = 1;
		brush = 0;
		tri = 0;
		circle = 0;
	}
	
	public void setBrush()
	{
		rect = 0;
		brush = 1;
		tri = 0;
		circle = 0;
	}
	
	public void setTri()
	{
		rect = 0;
		brush = 0;
		tri = 1;
		circle = 0;
	}
	
	public void setCircle()
	{
		rect = 0;
		brush = 0;
		tri = 0;
		circle = 1;
	}
	
	public void setBrushSize(int b)
	{
        size = b;
	}
	
	public void saveImage()
	{
		
		
		JFileChooser chooser = new JFileChooser();
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    int option = chooser.showSaveDialog(null);
	    String file = chooser.getSelectedFile() + ".jpg";  
	    
	    if (option == JFileChooser.APPROVE_OPTION)
	    {
			
				try {
					ImageIO.write((RenderedImage) image, "JPEG", new File(file));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
	    }

	}

}
