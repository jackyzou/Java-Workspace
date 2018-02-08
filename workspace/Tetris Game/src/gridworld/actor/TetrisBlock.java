package gridworld.actor;

import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color; 


public class TetrisBlock extends TetrisBug {

  protected int rotationPos;


  protected ArrayList<TetrisBug> blocks;

  protected Grid<Actor> gr;

  public TetrisBlock() {
    super(Color.blue);
    rotationPos = 0;
    gr = TetrisGame.world.getGrid();

    if (gr.get(new Location(0, 5)) != null
        || gr.get(new Location(1, 5)) != null) {
      javax.swing.JOptionPane.showMessageDialog(null, "Score: "
          + TetrisGame.score, "GAME OVER!", 0);
      System.exit(0);
    }
    putSelfInGrid(gr, new Location(1, 5));

    blocks = new ArrayList<TetrisBug>();
    TetrisBug a;

    a = new TetrisBug(Color.red);
    a.putSelfInGrid(gr, new Location(0, 5));
    blocks.add(a);


  } 

  public void act() {
    setDirection(180);
    for (TetrisBug tb : blocks)
      tb.setDirection(180);
    if (canMoveDown())
      moveDown();
    else
 {
      if (!TetrisGame.currentBlock.canMoveDown())
        TetrisGame.nextTetrisBlock();
    }
  }

  public void moveDown() {
    if (rotationPos == 0) {
      move();
      blocks.get(0).move();
    } else if (rotationPos == 1) {
      blocks.get(0).move();
      move();
    }
  }

 
  public boolean canMoveDown() {
    if (rotationPos == 0)
      return canMove();
    else if (rotationPos == 1)
      return canMove() && blocks.get(0).canMove();
    else
      return true;
  } 
  
  public void moveRight() {
    setDirection(90);
   
    for (TetrisBug tb : blocks)
      tb.setDirection(90); 
   
    if (rotationPos == 0) {
     
    	if (canMove() && blocks.get(0).canMove()) {
        blocks.get(0).move();
        move();
      } 
    } 
    
    else if (rotationPos == 1) {
      if (canMove()) {
        move();
        blocks.get(0).move();
      }
    }
  }


  public void moveLeft() {
  
    setDirection(270);
   
    for (TetrisBug tb : blocks)
      tb.setDirection(90); 
   
    if (rotationPos == 0) {
      if (canMove() && blocks.get(0).canMove()) {
        blocks.get(0).move();
        move();
      } 
    } 
    
    else if (rotationPos == 1) {
      if (canMove()) {
        move();
        blocks.get(0).move();
      }
    }
  }

  public void rotate() {
    Location nextLoc; 
    if (rotationPos == 0) {
      // only one block must move 
      nextLoc = new Location(getLocation().getRow() - 1,
          getLocation().getCol() + 1); 
      if (gr.isValid(nextLoc) && gr.get(nextLoc) == null) {
        moveTo(nextLoc);
        rotationPos = (rotationPos + 1) % 2;// will be % 4 with 4 blocks
      } 
    } else if (rotationPos == 1) 
    {

    
    	
    }
  }
}