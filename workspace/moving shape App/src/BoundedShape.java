import java.awt.*;

public abstract class BoundedShape extends Shape {
   public BoundedShape()
   {
      super();
   }

   public BoundedShape( int x1, int y1, int x2, int y2 )
   {
      super( x1, y1, x2, y2 );
   }

   public int getUpperLeftX()
   {
      return Math.min( getX1(), getX2() );
   }

   public int getUpperLeftY()
   {
      return Math.min( getY1(), getY2() );
   }

   public int getWidth()
   {
      return Math.abs( getX1() - getX2() );
   } 

   public int getHeight()
   {
      return Math.abs( getY1() - getY2() );
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

