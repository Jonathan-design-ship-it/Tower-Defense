import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Black here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Black extends Enemy
{
    public Black(ArrayList<Coordinate> map){
        health = 1; //9
        speed = 6;
        enableStaticRotation();
        
        destinations = randomize(map);
    }
    public Black(ArrayList<Coordinate> map, int over){
        health = 1 - over; //9
        speed = 6;
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
            getWorld().addObject(new Yellow(destinations, over), x, y);
            getWorld().addObject(new Yellow(destinations, over), x, y);
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
