package info.gridworld.actor;
import info.gridworld.grid.Location; 

public class ZBug extends Bug 
{ 
 private int Length; 
 private int steps; 
 private int counter; 

 public ZBug(int length) 
 { 
 setDirection(Location.EAST); 
 steps = 0; 
 counter = 1; 
 Length = length; 
 } 
 public void act() 
 { 
 if (counter <= 3 && steps < Length) 
 { 
 if(canMove()) 
 { 
 move(); 
 steps++; 
 } 
 } 
 else if(counter == 1) 
 { 
 setDirection(Location.SOUTHWEST); 
 steps = 0; 
 counter++; 
 } 
 else if (counter == 2) 
 { 
 setDirection(Location.EAST); 
 steps = 0; 
 counter++; 
 } 

 } 
} 