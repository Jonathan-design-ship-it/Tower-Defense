import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombTower extends Tower
{
    private int explosionRadius;
    
    public void act()
    {
        super.act();
    }
    
    public BombTower()
    {
        this(1, 240, 120, 100);
        scale(1.1);
    }
    
    public BombTower(int damage, int range, int attackSpeed, int explosionRadius)
    {
        super(damage, range, attackSpeed);
        this.explosionRadius = explosionRadius;
    }
    
    public void attack(Balloon e)
    {
        turnTowards(e.getX(), e.getY());
        this.getWorld().addObject(new Bomb(e.getX(), e.getY(), damage, explosionRadius), getX(), getY());
    }
}
