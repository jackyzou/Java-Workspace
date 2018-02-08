package info.girdworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.event.KeyEvent;
import java.util.Random;

public class Character extends Bug
{
Random pokemon;
public Character()
{

}

public void act(KeyEvent e)
{
        move(e);
        pokemon = new Random();
        if(pokemon.nextInt(10) == 5)
            System.out.println("It works!!");
}

public void move(KeyEvent e)
{
    Grid<Actor> gr = getGrid();
    Location loc = getLocation();
    if(gr == null)
        return;
    if( e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
        if(!(getDirection() == 90))
            setDirection(90);
        else
        {

            Location next = loc.getAdjacentLocation(getDirection());
            if (gr.isValid(next))
                moveTo(next);
            else
                removeSelfFromGrid();
        }
    }
    else if( e.getKeyCode() == KeyEvent.VK_LEFT)
    {
        if(!(getDirection() == 270))
            setDirection(270);
        else
        {

            Location next = loc.getAdjacentLocation(getDirection());
            if (gr.isValid(next))
                moveTo(next);
            else
                removeSelfFromGrid();
        }
    }
    else if( e.getKeyCode() == KeyEvent.VK_UP)
    {
        if(!(getDirection() == 0))
            setDirection(0);
        else
        {

            Location next = loc.getAdjacentLocation(getDirection());
            if (gr.isValid(next))
                moveTo(next);
            else
                removeSelfFromGrid();
        }
    }
    else if( e.getKeyCode() == KeyEvent.VK_DOWN)
    {
        if(!(getDirection() == 180))
            setDirection(180);
        else
        {

            Location next = loc.getAdjacentLocation(getDirection());
            if (gr.isValid(next))
                moveTo(next);
            else
                removeSelfFromGrid();
        }
    }

}}