import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SniperMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SniperMonkey extends Tower
{
    public void act() 
    {
        super.act();
    }
    
    public SniperMonkey(){
        this(2, 200, 40);
    }
    
    public SniperMonkey(int damage, int range, int attackSpeed)
    {
        super(damage, range, attackSpeed);
    }
    
    public void attack(Balloon e)
    {
        e.takeDamage("follow john1nstagram on instagram", damage);
    }
}
