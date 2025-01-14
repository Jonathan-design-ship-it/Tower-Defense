import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Tower extends Actor
{
    protected int x;
    protected int y;
    protected int damage;
    protected int range;
    protected int attackSpeed;
    protected int timer;
    
    public abstract void attack(Balloon e);
    
    public void act() 
    {
        ArrayList<Balloon> enemies = new ArrayList<Balloon>();
        Balloon closest;
        if(timer == 0)
        {
            enemies = (ArrayList<Balloon>) getObjectsInRange(range, Balloon.class);
            
            if(enemies.size() > 0)
            {
                closest = enemies.get(0);
                for(Balloon b : enemies)
                {
                    if(b.getFirst() > closest.getFirst())
                    {
                        closest = b;
                    }
                }
                
                attack(closest);
            }
        }
        
        timer ++;
        
        if(timer == attackSpeed)
        {
            timer = 0;
        }
    }
    
    //int x, int y, 
    public Tower(int damage, int range, int attackSpeed)
    {
        // this.x = x;
        // this.y = y;
        this.damage = damage;
        this.range = range;
        this.attackSpeed = attackSpeed;
        timer = 0;
    }
}
