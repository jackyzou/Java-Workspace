package info.gridworld.actor;
import info.gridworld.actor.Bug; 
public class SpiralBug extends Bug 
{ 
 private int steps; 
 private int sideLength; 
 public SpiralBug(int n) 
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
 sideLength ++;
 } 
 } 
} 