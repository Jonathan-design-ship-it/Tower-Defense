import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor {
    public Text() {
        
    }

    public void act() {
        
    }

    /**
     * Updates the image to display the current text.
     */
    public void updateText(String text) { 
        GreenfootImage textImage = new GreenfootImage(text , 24, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(textImage);
    }
}

