import java.awt.*;

public abstract class Shape extends Object {
   private int x1, y1, x2, y2;
   private Color color = Color.black;

   public Shape()
   {
      setX1( 0 );
      setY1( 0 );
      setX2( 0 );
      setY2( 0 );
   }

   public Shape( int x1, int y1, int x2, int y2 )
   {
      setX1( x1 );
      setY1( y1 );
      setX2( x2 );
      setY2( y2 );
   }

   public final void setX1( int x ) { x1 = x; }

   public final int getX1() { return x1; }

   public final void setY1( int y ) { y1 = y; }

   public final int getY1() { return y1; }

   public final void setX2( int x ) { x2 = x; }

   public final int getX2() { return x2; }

   public final void setY2( int y ) { y2 = y; }

   public final int getY2() { return y2; }

   public void setColor( Color c ) { color = c; }

   public Color getColor() { return color; }

   public abstract void draw( Graphics g );   
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
