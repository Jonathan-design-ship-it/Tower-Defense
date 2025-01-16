import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperMonkey extends DartMonkey
{
    public void act()
    {
        super.act();
    }
    
    public SuperMonkey()
    {
        this(1, 280, 8, 1, 100);
    }
    
    public SuperMonkey(int damage, int range, int attackSpeed, int pierce, int expiryDate)
    {
        super(damage, range, attackSpeed, pierce, expiryDate);
    }
}
