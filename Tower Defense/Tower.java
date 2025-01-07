import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends Actor
{
    protected int x;
    protected int y;
    protected int damage;
    protected int range;
    protected int attackSpeed;
    protected int timer;
    
    public void act() 
    {
        if(timer == 0)
        {
            // check if there is an enemy in range
            // attack first enemy
        }
        
        timer ++;
    }
    
    public Tower(int x, int y, int damage, int range, int attackSpeed)
    {
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.range = range;
        this.attackSpeed = attackSpeed;
        timer = 0;
    }
}
