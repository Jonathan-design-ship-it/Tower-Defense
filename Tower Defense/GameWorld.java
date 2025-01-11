import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public static ArrayList<Coordinate> map1Path;
    public static ArrayList<Coordinate> map2Path;
    public static ArrayList<Coordinate> map3Path;
    private Coordinate c;
    private static int map;
    
    // wave spawning
    private int waveCount; // wave number
    private int spawnDelay; // delay between each spawning balloon
    private int redCount; // amount of red balloon
    private int blueCount; // amount of blue balloon
    private int greenCount; // amount of green balloon
    private int yellowCount;  // amount of yellow balloon
    
    private int actCount;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 842, 1, false);

        map1Path = new ArrayList<Coordinate>();
        map2Path = new ArrayList<Coordinate>();
        map3Path = new ArrayList<Coordinate>();

        map = 1;
        if (map == 1){
            setBackground(new GreenfootImage("Map1.png"));

            map1Path.add(new Coordinate (170,400));
            map1Path.add(new Coordinate (170,175));
            map1Path.add(new Coordinate (375,175));
            map1Path.add(new Coordinate (375,620));
            map1Path.add(new Coordinate (95,620));
            map1Path.add(new Coordinate (95,760));
            map1Path.add(new Coordinate (750,760));
            map1Path.add(new Coordinate (750,530));
            map1Path.add(new Coordinate (540,530));
            map1Path.add(new Coordinate (540,325));
            map1Path.add(new Coordinate (760,325));
            map1Path.add(new Coordinate (760,100));
            map1Path.add(new Coordinate (470,100));
            map1Path.add(new Coordinate (470,-30));            
        }
    }
    
    public void act(){
        actCount ++;
        if (actCount == 1){
            startWave(waveCount);
            waveCount++;
        }
    }
    
    private void startWave (int waveCount){
        switch(waveCount){
            case 0:
                redCount = 20;
                spawnDelay = 50;
                for (int i = 0; i < redCount*spawnDelay; i++){
                    addObject(new Red(map1Path), 0, 400);
                }
                // add a queue later on with (spawnCount for when to spawn and balloon type)
                break;
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
        }
        spawnDelay++;
    }

    public static Coordinate getDestination(int num){
        if (map == 1)
            return map1Path.get(num);
        if (map == 2)
            return map2Path.get(num);
        // if map == 3
        return map3Path.get(num);
    }
}
