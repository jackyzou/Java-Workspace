package info.gridworld.actor;

import info.gridworld.actor.ActorWorld;

import java.awt.Color;




public class main {


	public static void main(String[] args) 
	{
	
			ActorWorld world = new ActorWorld();
			
	
			//Bug b= new DancingBug(new int [5]);
			Bug b = new Bug();
			Rock r = new Rock();
			Critter c = new Critter();
			Actor a = new Actor();
			b.setColor(Color.RED);
			//world.add(a);
			world.add(b);
			world.add(r);
			//world.add(c);
			world.show();
			
	}

}
