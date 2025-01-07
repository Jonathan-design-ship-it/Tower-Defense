import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Actor
{
    protected int health;
    protected double speed;
    protected boolean camo;
    protected boolean metal;
    protected boolean regen;
    protected int x,y;
    
    protected abstract void checkPop();
    protected abstract void takeDamage(int dmg);
    
    public void act() 
    {
        // Add your action code here.
    }    
}