import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;

/**
 * Write a description of class Dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dart extends Projectile
{
    private int pierce;
    private LinkedList<Balloon> enemies;
    
    public void act()
    {
        super.act();
        Balloon e = (Balloon) this.getOneIntersectingObject(Balloon.class);
        
        // checks if there is an enemy and it hasn't already been hit
        if(e != null && enemies.indexOf(e) == -1)
        {
            enemies.add(e);
            pierce -=1;
            e.takeDamage("dart", damage);
            if(pierce == 0)
            {
                remove = true;
            }
        }
        
        // if(remove == true)
        // {
            // getWorld().removeObject(this);
        // }
        
        remove();
    }
    
    public Dart(int x, int y, int damage, int pierce)
    {
        super(x, y);
        this.damage = damage;
        this.pierce = pierce;
        enemies = new LinkedList<Balloon>();
    }
}
