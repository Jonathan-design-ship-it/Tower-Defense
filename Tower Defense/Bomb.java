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
        Enemy e = (Enemy) this.getOneIntersectingObject(Enemy.class);
        if(e != null)
        {
            Explosion exp = new Explosion();
            this.getWorld().addObject((Actor) exp, getX(), getY());
            ArrayList<Enemy> enemies = (ArrayList<Enemy>) exp.getEnemiesInRange(explosionRadius);
            for(Enemy enemy : enemies)
            {
                enemy.takeDamage(damage);
            }
            remove = true;
        }
    }
    
    public Bomb(int x, int y, int damage, int explosionRadius)
    {
        super(x, y);
        this.damage = damage;
        this.explosionRadius = explosionRadius;
    }
}
