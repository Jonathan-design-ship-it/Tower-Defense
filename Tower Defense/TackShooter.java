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
    
    public TackShooter()
    {
        this(1, 140, 80, 1);
    }
    
    public TackShooter(int damage, int range, int attackSpeed, int pierce)
    {
        super(damage, range, attackSpeed);
        this.pierce = pierce;
    }
    
    public void attack(Balloon e)
    {
        // middle of tower coordinates
        // int x = getX() + this.getImage().getWidth() / 2;
        // int y = getY() + this.getImage().getHeight() / 2;
        int x = getX();
        int y = getY();
        
        for(int i = 0; i < 360; i += 45)
        {
            this.getWorld().addObject(new Tack(x, y, damage, pierce, i), x, y);
        }
    }
}
