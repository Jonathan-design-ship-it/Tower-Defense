import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Green here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Green extends Enemy
{
    public Green(ArrayList<Coordinate> map){
        health = 1; //3
        speed = 4.2;
        enableStaticRotation();
        
        destinations = randomize(map);
    }
    public Green(int over, ArrayList<Coordinate> map){
        health = 1 - over; //3
        speed = 4.2;
        enableStaticRotation();
        
        destinations = randomize(map);
    }
    protected void takeDamage(int dmg){
        health -= dmg;
    }
    protected void checkPop(){
        if (health <= 0){
            int over = Math.abs(health);
            setLocation(10000, 10000);
            getWorld().addObject(new Blue(over, destinations), x, y);
            getWorld().removeObject(this);
        }
    }
    public void act() 
    {
        x = getX();
        y = getY();
        super.act();
        checkPop();
    }    
}
