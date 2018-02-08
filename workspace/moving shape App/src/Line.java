import java.awt.*;

public class Line extends Shape {
   public Line()
   {
      super();
   }

   public Line( int x1, int y1, int x2, int y2 )
   {
      super( x1, y1, x2, y2 );
   }

   public void draw( Graphics g )
   {
      Color c = g.getColor();  // get previous color
      g.setColor( this.getColor() );
      g.drawLine( getX1(), getY1(), getX2(), getY2() );
      g.setColor( c );         // reset previous color
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
