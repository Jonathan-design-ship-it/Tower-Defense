import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private double percent;
    
    public Explosion()
    {
        percent = 1.0;
    }
    
    public void act()
    {
        if(percent > 0)
        {
            percent -= 0.01;
            getImage().setTransparency((int)(percent * 255));
        }
        else
        {
            getWorld().removeObject(this);
        }
    }
    
    public List getEnemiesInRange(int explosionRadius)
    {
        getImage().scale(explosionRadius * 2, explosionRadius * 2);
        return getObjectsInRange(explosionRadius, Balloon.class);
    }
}
