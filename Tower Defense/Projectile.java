import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends SuperSmoothMover
{
    private int xDestination;
    private int yDestination;
    private int timer;
    private int expiryDate;
    protected boolean remove;
    protected int damage;
    private boolean turned = false;
    
    public void act()
    {
        if(!turned)
        {
            turnTowards(xDestination, yDestination);
            turned = true;
        }
        move(); 
    }
    
    public Projectile(int x, int y, int expiryDate)
    {
        xDestination = x;
        yDestination = y;
        timer = 0;
        this.expiryDate = expiryDate;
        remove = false;
    }
    
    public void move()
    {
        if(timer == expiryDate)
        {
            remove = true;
        }
        else
        {
            move(15);
            timer ++;
        }
    }
    
    public boolean getRemove()
    {
        return remove;
    }
    
    public void remove()
    {
        if(remove == true)
        {
            getWorld().removeObject(this);
        }
    }
}
