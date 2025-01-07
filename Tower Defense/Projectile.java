import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    private int xDestination;
    private int yDestination;
    private int timer;
    protected boolean remove;
    protected int damage;
    
    public void act()
    {
        if(remove == true)
        {
            getWorld().removeObject(this);
        }
    }
    
    public Projectile(int x, int y, GreenfootImage image)
    {
        xDestination = x;
        yDestination = y;
        timer = 0;
        remove = false;
        setImage(image);
        turnTowards(xDestination, yDestination);
    }
    
    public boolean move()
    {
        if(timer == 60)
        {
            remove = true;
            return true;
        }
        else
        {
            move(15);
            timer ++;
        }
        return false;
    }
    
    public boolean getRemove()
    {
        return remove;
    }
}
