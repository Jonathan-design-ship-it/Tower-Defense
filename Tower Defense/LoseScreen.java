import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseScreen extends World
{
    /**
     * Constructor for objects of class LoseScreen.
     * 
     */
    public LoseScreen()
    {    
        super(600, 400, 1);
        Text loose;
        addObject(loose = new Text(), getWidth()/2, getHeight()/2);
        loose.updateText("YOU LOST");
    }
}
