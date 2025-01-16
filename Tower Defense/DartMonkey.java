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
    private int expiryDate;
    
    /**
     * Act - do whatever the DartMonkey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }
    
    public DartMonkey(){
        this(1, 200, 40, 1, 15);
    }
    
    public DartMonkey(int damage, int range, int attackSpeed, int pierce, int expiryDate)
    {
        super(damage, range, attackSpeed);
        this.pierce = pierce;
        this.expiryDate = expiryDate;
    }
    
    public void attack(Balloon e)
    {
        turnTowards(e.getX(), e.getY());
        this.getWorld().addObject(new Dart(e.getX(), e.getY(), damage, pierce, expiryDate), getX(), getY());
    }
}
