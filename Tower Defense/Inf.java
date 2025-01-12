import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Inf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inf extends Enemy
{
    public Inf(){
        health = Integer.MAX_VALUE;
    }
    
    protected void takeDamage(int dmg){
        health -= dmg;
    }
    
    protected void checkPop(){
        // do nothing because inf hp
    }
    
    public void act() 
    {
        x = getX();
        y = getY();
    }    
}
