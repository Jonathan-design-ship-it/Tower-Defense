import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DartMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DartMonkey extends Tower
{
    private int pierce;
    
    /**
     * Act - do whatever the DartMonkey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }
    
    public DartMonkey(int damage, int range, int attackSpeed, int pierce)
    {
        super(damage, range, attackSpeed);
        this.pierce = pierce;
    }
    
    public void attack(Enemy e)
    {
        turnTowards(e.getX(), e.getY());
        this.getWorld().addObject(new Dart(e.getX(), e.getY(), damage, pierce), getX(), getY());
    }
}
