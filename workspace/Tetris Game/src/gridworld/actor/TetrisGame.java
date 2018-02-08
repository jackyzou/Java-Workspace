package gridworld.actor;

//TetrisGame.java
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color; 

public class TetrisGame {


  public static ActorWorld world = new ActorWorld(new BoundedGrid(19, 12));
  

  public static TetrisBlock currentBlock;

  public static int score;

  public static void main(String[] args) {
 
    //set up world
    for (int i = 0; i < 19; i++) {
      world.add(new Location(i,11),new Rock());
      world.add(new Location(i,0),new Rock());
    }
    nextTetrisBlock();
    //needed code for keyboard event handling
    java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager() .addKeyEventDispatcher(new java.awt.KeyEventDispatcher() {
       
          public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) {
            String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString(); 
            if (key.equals("pressed UP"))
              currentBlock.rotate(); 
            if (key.equals("pressed RIGHT"))
              currentBlock.moveRight(); 
            if (key.equals("pressed DOWN"))
              currentBlock.act(); 
            if (key.equals("pressed LEFT"))
             
            	
            currentBlock.moveLeft();
            world.show(); 
            return true;
          }
        });
    world.show();
  } 
  /**
   * Calls removeCompleteRows and chooses a new TetrisBlock at random
   */ 
  public static void nextTetrisBlock() {
    
    removeCompleteRows(); 
    TetrisBlock randomBlock = new TetrisBlock();
    
    int randNum = (int)(Math.random()*7)+1;//random number between 1 and 7
   // if(randNum == 1)
     // randomBlock = new TetrisBlockO();
    //if(randNum == 2)
    //  randomBlock = new TetrisBlockI(); 
    //if(randNum == 3)
    //  randomBlock = new TetrisBlockT();
    //if(randNum == 4)
    //  randomBlock = new TetrisBlockL();
    //if(randNum == 5)
    //  randomBlock = new TetrisBlock_L();
    //if(randNum == 6)
    //  randomBlock = new TetrisBlockZ();
    //if(randNum == 7)
    //  randomBlock = new TetrisBlock_Z();
    
    currentBlock = randomBlock;
  }

  public static void removeCompleteRows() {
    Grid<Actor> gr = world.getGrid();
   if( gr.getNumRows()==19)
   {
	 
   }
    
  
    
  }
}  