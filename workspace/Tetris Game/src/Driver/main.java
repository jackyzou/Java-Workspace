package Driver;

import gridworld.actor.ActorWorld;
import gridworld.actor.Bug;



public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		
		Bug b = new Bug();
		
		world.show();
		world.add(b);
	}

}
