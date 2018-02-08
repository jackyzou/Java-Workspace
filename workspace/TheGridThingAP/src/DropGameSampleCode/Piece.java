package DropGameSampleCode;
import info.gridworld.actor.Bug;

import java.awt.Color;

public class Piece extends Bug
{
   private Color color;

   public Piece(Color color)
   {
      this.color = color;
   }

   // returns color of this Piece
   public Color getColor()
   {
      return color;
   }

   // There may be fields, constructors, and methods that are not shown.
}
