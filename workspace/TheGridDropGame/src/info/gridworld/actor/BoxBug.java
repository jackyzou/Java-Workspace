package info.gridworld.actor;
public class BoxBug extends Bug 
{ 
 private int steps; 
 private int sideLength; 
 public BoxBug(int n) 
 { 
 sideLength = n; 
 } 
 public void act() 
 { 
 if (steps < sideLength && canMove()) 
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
}