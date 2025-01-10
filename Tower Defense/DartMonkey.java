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
        
    }
    
    public DartMonkey(int x, int y, int damage, int range, int attackSpeed, int pierce)
    {
        super(x, y, damage, range, attackSpeed);
        this.pierce = pierce;
    }
    
    public void attack(Enemy e)
    {
        
    }
}
