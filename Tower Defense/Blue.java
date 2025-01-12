import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Blue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blue extends Enemy
{
    public Blue(ArrayList<Coordinate> map){
        health = 1; //2
        speed = 3.3;
        enableStaticRotation();
        
        destinations = randomize(map);
    }
    public Blue(int over, ArrayList<Coordinate> map){
        health = 1 - over; //2
        speed = 3.3;
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
            getWorld().addObject(new Red(over, destinations), x, y);
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
