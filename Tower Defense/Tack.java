import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tack extends Dart
{
    public Tack(int x, int y, int damage, int pierce)
    {
        super(x, y, damage, pierce);
        this.setImage(new GreenfootImage("images/barrel.png"));
    }
}
