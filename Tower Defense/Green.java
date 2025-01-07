import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Green here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Green extends Enemy
{
    public Green(){
        health = 1; //3
        speed = 1.5;
    }
    public Green(int over){
        health = 1 - over; //3
        speed = 1.5;
    }
    protected void takeDamage(int dmg){
        health -= dmg;
    }
    protected void checkPop(){
        if (health <= 0){
            int over = Math.abs(health);
            setLocation(10000, 10000);
            getWorld().addObject(new Blue(over), x, y);
            getWorld().removeObject(this);
        }
    }
    public void act() 
    {
        x = getX();
        y = getY();
        checkPop();
    }    
}
