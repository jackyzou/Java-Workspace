package DropGame;
import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Drop  
{
   private Grid<Piece> theGrid;

   public Location dropLocationForColumn(int column)
   {
      for (int r = theGrid.getNumRows() - 1; r >= 0; r--)
      {
         Location nextLoc = new Location(r, column);
         if (theGrid.get(nextLoc) == null)
         {
            return nextLoc;
            
         }
      }
      return null;
      
   }


   public boolean dropMatchesNeighbors(int column, Color pieceColor)
   {
      Location loc = dropLocationForColumn(column);
      if (loc == null)
      {
         return false;
      }

      ArrayList<Piece> neighbors = theGrid.getNeighbors(loc);
      int sameColorCount = 0;
      for (Piece nextNbr : neighbors)
      {
         if (nextNbr.getColor().equals(pieceColor))
         {
        	 sameColorCount++;
         }
      }

      return (sameColorCount >= 4);
      
   }

  
   public Drop(Grid<Piece> gr)
   {
      theGrid = gr;
   }
}
