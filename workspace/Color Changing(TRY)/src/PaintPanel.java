import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public abstract class PaintPanel extends JPanel
                        implements MouseListener, MouseMotionListener,
                                   ActionListener {
 
   private Color currentColor = Color.black;
   Timer timer = new Timer( 40, this );

   public PaintPanel()
   {
     
      addMouseListener( this );
      addMouseMotionListener( this );
      setBackground( Color.white );
      timer.start();
   }

  
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      Shape current;
   }
  

   

   public void mouseClicked( MouseEvent e )
   {

   }

   public void mouseEntered( MouseEvent e )
   {

   }

   public void mouseExited( MouseEvent e )
   {

   }

   public void mouseMoved( MouseEvent e )
   {

   }

 
   public void setCurrentColor( Color c )
   {
      currentColor = c;
   }
}


