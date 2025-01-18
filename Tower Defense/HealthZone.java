import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthZone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthZone extends Actor
{
    public static int health;
    private boolean added = false;
    private Text healthText;
    
    public HealthZone() {
        health = 40;
        GreenfootImage blackRectangle = new GreenfootImage(100, 100);
        blackRectangle.setColor(Color.BLACK);
        blackRectangle.fill();
        setImage(blackRectangle);
    }
    
    public void act()
    {
        if (!added){
            getWorld().addObject(healthText = new Text(), 975, 100);
            added = !added;
        }
        
        // detects if a balloon touched the end
        Balloon b = (Balloon) this.getOneIntersectingObject(Balloon.class);
        if (b != null)
        {
            this.health -= b.endKill();
        }
        
        // updates the health text
        healthText.updateText("Health: " + health);
        
        // ends game if dead
        if (health <= 0)
            Greenfoot.setWorld(new LoseScreen());
    }
} 