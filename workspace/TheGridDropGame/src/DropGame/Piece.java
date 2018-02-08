package DropGame;
import info.gridworld.actor.Actor;
import info.gridworld.actor.BoxBug;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Piece extends Bug
{
   private Color color;


   public Piece(Color color)
   {
      this.color = color;
      
      if (canMove())
          move();//call move
      act();
   }
   


   public Color getColor()
   {
      return color;
   }
   
  
  
	
   private int steps; 


   public void act() 
   { 
   if (canMove()) 
   { 
   move(); 
   steps++; 
   } 
   else 
   { 
   turn(); 
   steps = 0; 
   } 
   }  
 
   
   public void move()
   {
   
       Grid<Actor> gr = getGrid();
       if (gr == null)
           return;
       Location loc = getLocation();
       Location next = loc.getAdjacentLocation(Location.SOUTH);
     
      
       if (gr.isValid(next))
           moveTo(next);
      
   }

   public boolean canMove()
   {
       Grid<Actor> gr = getGrid();
       if (gr == null)
           return false;
       Location loc = getLocation();
       Location next = loc.getAdjacentLocation(Location.SOUTH);
      
       if (!gr.isValid(next))
          return false;
       
       
       Actor neighbor = gr.get(next);
       return (neighbor == null) || (neighbor instanceof Flower);
       // ok to move into empty location or onto flower
       // not ok to move onto any other actor
   }
   
   
   // There may be fields, constructors, and methods that are not shown.
}
