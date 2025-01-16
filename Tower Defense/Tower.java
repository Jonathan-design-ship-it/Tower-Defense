import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Tower extends Actor
{
    protected int x;
    protected int y;
    protected int damage;
    protected int range;
    protected int attackSpeed;
    protected int timer;
    private CircleObject rangeCircle;
    
    public abstract void attack(Balloon e);
    
    public void act() 
    {
        ArrayList<Balloon> enemies = new ArrayList<Balloon>();
        Balloon closest;
        if(timer == 0)
        {
            enemies = (ArrayList<Balloon>) getObjectsInRange(range, Balloon.class);
            
            if(enemies.size() > 0)
            {
                closest = enemies.get(0);
                for(Balloon b : enemies)
                {
                    if(b.getFirst() > closest.getFirst())
                    {
                        closest = b;
                    }
                }
                
                attack(closest);
            }
        }
        
        if(isMouseClickedOnLocation(getX(), getY(), getImage().getWidth() / 4, getImage().getHeight() / 4))
        {
            getWorld().addObject(rangeCircle, getX(), getY());
            rangeCircle.getImage().setTransparency(100);
        }
        else if(isMouseClickedOnLocation(0, 0, 832, 842))
        {
            rangeCircle.getImage().setTransparency(0);
        }
        
        timer ++;
        
        if(timer == attackSpeed)
        {
            timer = 0;
        }
    }
    
    protected void scale(double num){
        getImage().scale((int)(getImage().getWidth()*num), (int)(getImage().getHeight()*num));
    }
    
    public boolean isMouseClickedOnLocation(int x, int y, int xTolerance, int yTolerance)
    {
        if (Greenfoot.mouseClicked(null)) // Check if any object was clicked
        {
            MouseInfo mouse = Greenfoot.getMouseInfo(); // Get mouse info
            int mouseX = mouse.getX(); // Get the mouse's x-coordinate
            int mouseY = mouse.getY(); // Get the mouse's y-coordinate
            
            // Check if the mouse click is within the tolerance of the target location
            return Math.abs(mouseX - x) <= xTolerance && Math.abs(mouseY - y) <= yTolerance;
        }
        
        return false; // No click detected
    }
    
    public Tower(int damage, int range, int attackSpeed)
    {
        this.damage = damage;
        this.range = range;
        this.attackSpeed = attackSpeed;
        timer = 0;
        rangeCircle = new CircleObject(range);
        scale(1.6);
    }
}
