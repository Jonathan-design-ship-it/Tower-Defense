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

    //path
    protected Coordinate currentDestination;
    //protected static ArrayList<Coordinate> destinations;
    protected int destinations = 0;
    
    protected abstract void checkPop();
    protected abstract void takeDamage(int dmg);
    
    public void act() 
    {
        currentDestination = this.getWorld().getDestination(0);
    }
    
}
