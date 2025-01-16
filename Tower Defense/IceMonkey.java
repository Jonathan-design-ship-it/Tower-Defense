import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class IceMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IceMonkey extends Tower
{
    private int freezeDuration;
    
    public void act()
    {
        ArrayList<Balloon> enemies = new ArrayList<Balloon>();
        if(timer == 0)
        {
            enemies = (ArrayList<Balloon>) getObjectsInRange(range, Balloon.class);
            
            if(enemies.size() > 0)
            {
                for(Balloon b : enemies)
                {
                    attack(b);
                }
            }
        }
        
        timer ++;
        
        if(timer == attackSpeed)
        {
            timer = 0;
        }
    }
    
    public IceMonkey()
    {
        this(1, 120, 160, 120);
    }
    
    public IceMonkey(int damage, int range, int attackSpeed, int freezeDuration)
    {
        super(damage, range, attackSpeed);
        this.freezeDuration = freezeDuration;
    }
    
    public void attack(Balloon b)
    {
        b.freeze(freezeDuration);
    }
}
