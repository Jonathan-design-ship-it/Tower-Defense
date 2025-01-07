import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Red here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Red extends Enemy
{
    public Red(){
        health = 1; //1
        speed = 1;
    }
    public Red(int over){
        health = 1 - over; //1
        speed = 1;
    }
    protected void takeDamage(int dmg){
        health -= dmg;
    }
    protected void checkPop(){
        if (health <= 0){
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
