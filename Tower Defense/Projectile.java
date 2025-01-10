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
    
    public Projectile(int x, int y)
    {
        xDestination = x;
        yDestination = y;
        timer = 0;
        remove = false;
    }
    
    public void move()
    {
        if(timer == 15)
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
}
