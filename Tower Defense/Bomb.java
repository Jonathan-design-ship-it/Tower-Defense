import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class BombTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Projectile
{
    private int explosionRadius;
    
    public void act()
    {
        super.act();
        Balloon e = (Balloon) this.getOneIntersectingObject(Balloon.class);
        if(e != null)
        {
            Explosion exp = new Explosion();
            this.getWorld().addObject((Actor) exp, getX(), getY());
            ArrayList<Balloon> enemies = (ArrayList<Balloon>) exp.getEnemiesInRange(explosionRadius);
            for(Balloon enemy : enemies)
            {
                enemy.takeDamage("bomb", damage);
            }
            remove = true;
        }
        
        remove();
    }
    
    public Bomb(int x, int y, int damage, int explosionRadius, int expiryDate)
    {
        super(x, y, expiryDate);
        this.damage = damage;
        this.explosionRadius = explosionRadius;
        getImage().scale(63,52);
    }
}
