import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Yellow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yellow extends Enemy
{
    public Yellow(){
        health = 1; //4
        speed = 3;
    }
    public Yellow(int over){
        health = 1 - over; //4
        speed = 3;
    }
    protected void takeDamage(int dmg){
        health -= dmg;
    }
    protected void checkPop(){
        if (health <= 0){
            int over = Math.abs(health);
            setLocation(10000, 10000);
            getWorld().addObject(new Green(over), x, y);
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
