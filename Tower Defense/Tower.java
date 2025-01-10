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
    
    public abstract void attack(Enemy e);
    
    public void act() 
    {
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        if(timer == 0)
        {
            enemies = (ArrayList<Enemy>) getObjectsInRange(range, Enemy.class);
            // temporary, later make it attack closest enemy
            attack(enemies.get(1));
        }
        
        timer ++;
    }
    
    public void findClosest()
    {
        
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
