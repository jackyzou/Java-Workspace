package DropGame;
import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
//override move and override act
public class DropGrid extends World<Piece>
{
   private Drop round;
   private Color currentColor;
   private boolean gameOver;
   
   public static void main(String[] args)
   {
      DropGrid world = new DropGrid(10, 10);
      world.show();
   }
   
   public DropGrid(int rows, int cols)
   {
      super(new BoundedGrid<Piece>(rows, cols));
     
      round = new Drop(getGrid());
      
      currentColor = Color.WHITE;//white go first
      
      flip();
   }
   

   public void flip()
   {
      if (currentColor.equals(Color.WHITE))
      {
         currentColor = Color.BLACK;
         setMessage("Black's turn");
      }
      else
      {
         currentColor = Color.WHITE;
         setMessage("White's turn");
      }         
   }
   
 
   
   	//override
   public boolean locationClicked(Location loc)
   {
	   
	   
      if (gameOver) return false;
      Location dropLoc = round.dropLocationForColumn(loc.getCol());

      
      if (dropLoc == null) 
         setMessage("Try again");
      else
      {
         if (round.dropMatchesNeighbors(loc.getCol(), currentColor))
         {
      
            setMessage("You won!!!");
            gameOver = true;
            
         }
         
        
        getGrid().put(dropLoc, new Piece(currentColor));
         System.out.println(dropLoc);
         
      }
      if (!gameOver) flip();
      return true;
   }     
}
