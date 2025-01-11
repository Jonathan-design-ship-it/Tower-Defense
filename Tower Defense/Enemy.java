import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends SuperSmoothMover
{
    protected int health;
    protected double speed;
    protected boolean camo;
    protected boolean metal;
    protected boolean regen;
    protected int x,y;
    
    protected int actCount;

    //path
    protected Coordinate currentDestination;
    protected ArrayList<Coordinate> destinations;
    
    protected abstract void checkPop();
    protected abstract void takeDamage(int dmg);
    
    public void act() 
    {
        //currentDestination = this.getWorld().getDestination(0);
        actCount++;
        
        // Check if there is another destination for me if I don't have one
        if (currentDestination == null && destinations.size() > 0){
            currentDestination = getNextDestination ();
        }
        
        if (currentDestination != null){
            moveTowardsDestination();
        }
    }
    
    public void addDestination (Coordinate c){
        destinations.add(c);
    }
    
    protected Coordinate getNextDestination () {
        return destinations.get(0);
    }
    
    protected void moveTowardsDestination(){
        double distanceToDestination = getDistance (new Coordinate(getX(), getY()), currentDestination);
        if (distanceToDestination < speed){
            setLocation (currentDestination.getX(), currentDestination.getY());
            destinations.remove(currentDestination);
            currentDestination = null;
        } else {
            turnTowards (currentDestination.getX(), currentDestination.getY());
            move(speed);
        }
    }
    
     /**
     * Static method that gets the distance between the x,y coordinates of two Actors
     * using Pythagorean Theorum.
     *
     * @param a     First Actor
     * @param b     Second Actor
     * @return distance The distance from the center of a to the center of b.
     */
    public static double getDistance (Coordinate a, Coordinate b)
    {
        double distance;
        double xLength = a.getX() - b.getX();
        double yLength = a.getY() - b.getY();
        distance = Math.sqrt(Math.pow(xLength, 2) + Math.pow(yLength, 2));
        return distance;
    }
}
