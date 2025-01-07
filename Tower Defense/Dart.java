import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dart extends Projectile
{
    private int pierce;
    
    public void act()
    {
        super.act();
        Enemy e = (Enemy) this.getOneIntersectingObject(Enemy.class);
        if(e != null)
        {
            pierce -=1;
            // e.takeDamage(damage);
            if(pierce == 0)
            {
                remove = true;
            }
        }
    }
    
    public Dart(int x, int y, GreenfootImage image, int damage, int pierce)
    {
        super(x, y, image);
        this.damage = damage;
        this.pierce = pierce;
    }
}
