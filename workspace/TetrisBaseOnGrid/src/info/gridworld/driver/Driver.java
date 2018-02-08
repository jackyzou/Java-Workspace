package info.gridworld.driver;
import info.girdworld.actor.Actor;
import info.girdworld.actor.ActorWorld;
import info.girdworld.actor.Player;
import info.gridworld.grid.Location;

public class Driver {
	public static void main(String[] args){
		ActorWorld world = new ActorWorld();
		Player player = new Player();
	//	Character ch = new Character(ch);
		Location loc = new Location(0,4);
		Location loc1 = new Location(3,5);
		world.add(loc, player);
	
		player.getParentFrame();
	
	}
}
