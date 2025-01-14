import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TackTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TackShooter extends Tower
{
    private int pierce;
    
    public void act()
    {
        super.act();
    }
    
    public TackShooter(int damage, int range, int attackSpeed, int pierce)
    {
        super(damage, range, attackSpeed);
        this.pierce = pierce;
    }
    
    public void attack(Balloon e)
    {
        // shoot up
        this.getWorld().addObject(new Tack(getX() + this.getImage().getWidth() / 2, getX() + this.getImage().getHeight() / 2, damage, pierce), getX(), getY());
    }
}
