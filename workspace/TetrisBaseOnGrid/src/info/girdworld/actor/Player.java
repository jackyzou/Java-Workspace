package info.girdworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
public class Player extends Bug {
	public JFrame FRAME;
	public Player(){
		
	}
	public void getParentFrame(){
		FRAME = super.getFrame();
		if(FRAME != null){
		FRAME.addKeyListener(new KeyAdapter(){
	    	public void keyPressed(KeyEvent e){
	    		 int key = e.getKeyCode();
	    		 if(key == KeyEvent.VK_UP){
	    			 System.out.println("U");
	  
	    			 turn();
	    		 }
	    		 if(key == KeyEvent.VK_DOWN){
	    			 System.out.println("D");
	    			 moveDown();
	    		 }
	    		 if(key == KeyEvent.VK_LEFT){
	    			 System.out.println("L");
	      			 moveLeft();
	    		 }
	    		 if(key == KeyEvent.VK_RIGHT){
	    			 System.out.println("R");
	    			
	    			 moveRight();
	    		 }
	    	}
	    });
		}
		else{
			System.err.println("Frame was NULL");
		}
	}
	public void moveLeft(){
		Location loc = super.getLocation();
		super.moveTo(new Location(loc.getRow(), loc.getCol()-1));
		FRAME.validate();
		FRAME.repaint();
	}
	public void moveRight(){
		Location loc = super.getLocation();
		super.moveTo(new Location(loc.getRow(), loc.getCol()+1));
		FRAME.validate();
		FRAME.repaint();
	}
	public void turn(){
		Location loc = super.getLocation();
		//super.moveTo(new Location(loc.getRow()-1, loc.getCol()));
		super.setDirection( getDirection() + Location.RIGHT);
		FRAME.validate();
		FRAME.repaint();
	}
	public void moveDown(){
		Location loc = super.getLocation();
		super.moveTo(new Location(loc.getRow()+1, loc.getCol()));
		FRAME.validate();
		FRAME.repaint();
	}
	
}
