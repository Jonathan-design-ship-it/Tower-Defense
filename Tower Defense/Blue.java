import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blue extends Enemy
{
    public Blue(){
        health = 1; //2
        speed = 1.2;
    }
    public Blue(int over){
        health = 1 - over; //2
        speed = 1.2;
    }
    protected void takeDamage(int dmg){
        health -= dmg;
    }
    protected void checkPop(){
        if (health <= 0){
            int over = Math.abs(health);
            setLocation(10000, 10000);
            getWorld().addObject(new Red(over), x, y);
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
