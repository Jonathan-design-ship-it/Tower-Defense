import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tack extends Dart
{
    public Tack(int x, int y, int damage, int pierce, int angle, int expiryDate)
    {
        super(angleToDirectionX(x, angle), angleToDirectionY(y, angle), damage, pierce, expiryDate);
        setImage("projectile/tack.png");
        getImage().scale(30,20);
    }
    
    public static int angleToDirectionX(int x, int angle)
    {
        if(angle != 0 && angle <= 135)
        {
            return x + 1;
        }
        else if(angle >= 225)
        {
            return x - 1;
        }
        else
        {
            return x;
        }
    }
    
    public static int angleToDirectionY(int y, int angle)
    {
        if(angle >= 315 || angle <= 45)
        {
            return y - 1;
        }
        else if(angle >= 135 && angle <= 225)
        {
            return y + 1;
        }
        else
        {
            return y;
        }
    }
}
