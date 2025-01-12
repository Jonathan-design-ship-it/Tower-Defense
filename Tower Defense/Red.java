import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Red here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Red extends Enemy
{
    public Red(ArrayList<Coordinate> map){
        health = 1; //1
        speed = 2.9;
        enableStaticRotation();
        
        destinations = randomize(map);
    }

    public Red(ArrayList<Coordinate> map, int over){
        health = 1 - over; //1
        speed = 2.9;
        enableStaticRotation();
        
        destinations = randomize(map);
    }

    protected void takeDamage(int dmg){
        health -= dmg;
    }

    protected void checkPop(){
        if (health <= 0){
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
