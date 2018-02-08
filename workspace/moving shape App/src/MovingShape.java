import java.awt.*;
import java.awt.event.*;

public class MovingShape extends Thread {
   private Shape shape;
   private Component drawingArea;
   private int dx, dy;  // change in position
   private boolean stopAnimating = false;
   private int sleepTime = 40;
   private Dimension bounds;

   public MovingShape( Shape s, Component c )
   {
      this ( s, c, 1, 1 );
   }

   public MovingShape( Shape s, Component c, int xChange, int yChange )
   {
      shape = s;
      drawingArea = c;
      bounds = drawingArea.getSize();
      dx = xChange;
      dy = yChange;

      drawingArea.addComponentListener(
         new ComponentAdapter() {
            public void componentResized( ComponentEvent e )
            {
               bounds = e.getComponent().getSize();

               if ( shape.getX1() > bounds.width ||
                    shape.getX2() > bounds.width)
                  translateX(
                     Math.max(shape.getX1(), shape.getX2()) - bounds.width + 1 );

               if ( shape.getY1() > bounds.height ||
                    shape.getY2() > bounds.height)
                  translateY(
                     Math.max(shape.getY1(), shape.getY2()) - bounds.height + 1);
            }

            public void translateX( int val )
            {
               shape.setX1( shape.getX1() - val );
               shape.setX2( shape.getX2() - val );
            }

            public void translateY( int val )
            {
               shape.setY1( shape.getY1() - val );
               shape.setY2( shape.getY2() - val );
            }
         }
      );
   }

   public final void setDX( int val ) { dx = val; }

   public final void setDY( int val ) { dy = val; }

   public final void stopBall() { stopAnimating = true; }

   public final void draw( Graphics g ) { shape.draw( g ); }

   public void run()
   {
      while ( !stopAnimating ) {
         shape.setX1( shape.getX1() + dx );
         shape.setY1( shape.getY1() + dy );
         shape.setX2( shape.getX2() + dx );
         shape.setY2( shape.getY2() + dy );

         if ( shape.getX1() <= 0 ||
              shape.getX2() <= 0 ||
              shape.getX1() >= bounds.width ||
              shape.getX2() >= bounds.width )
            dx = -dx;

         if ( shape.getY1() <= 0 ||
              shape.getY2() <= 0 ||
              shape.getY1() >= bounds.height ||
              shape.getY2() >= bounds.height)
            dy = -dy;

         try {
            Thread.sleep( sleepTime );
         }
         catch ( InterruptedException ex ) {
            ex.printStackTrace();
         }
      }
   }
}


 /**************************************************************************
  * (C) Copyright 1992-2004 by Deitel & Associates, Inc. and               *
  * Pearson Education, Inc. All Rights Reserved.                           *
  *                                                                        *
  * DISCLAIMER: The authors and publisher of this book have used their     *
  * best efforts in preparing the book. These efforts include the          *
  * development, research, and testing of the theories and programs        *
  * to determine their effectiveness. The authors and publisher make       *
  * no warranty of any kind, expressed or implied, with regard to these    *
  * programs or to the documentation contained in these books. The authors *
  * and publisher shall not be liable in any event for incidental or       *
  * consequential damages in connection with, or arising out of, the       *
  * furnishing, performance, or use of these programs.                     *
  **************************************************************************/
