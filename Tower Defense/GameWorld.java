import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

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
    
    // round spawning
    private int roundCount; // round number
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
        
        grid();

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
            map1Path.add(new Coordinate (470, -70)); //change y to -70       
        }
    }
    
    public void act(){
        actCount ++;
        
        if (actCount == 60){
            Random random = new Random();
            int num = random.nextInt(6);
            //int num = 0;
            if (num == 0)
                addObject(new Balloon("red", map1Path), 0, 400);
            if (num == 1)
                addObject(new Balloon("blue", map1Path), 0, 400);
            if (num == 2)
                addObject(new Balloon("green", map1Path), 0, 400);
            if (num == 3)
                addObject(new Balloon("yellow", map1Path), 0, 400);
            if (num == 4)
                addObject(new Balloon("white", map1Path), 0, 400);
            if (num == 5)
                addObject(new Balloon("black", map1Path), 0, 400);
            actCount = 0;
        }
        /*
        if (actCount == 1){
            startRound(roundCount);
            roundCount++;
        }
        */
    }
    
    private void startRound (int roundCount){
        switch(roundCount){
            case 0:
                // round 1, 12 red balloons
                redCount = 20;
                spawnDelay = 50;
                for (int i = 0; i < redCount*spawnDelay; i++){
                    //addObject(new Red(map1Path), 0, 400);
                }
                // add a queue later on with (spawnCount for when to spawn and balloon type)
                break;
            case 1:
                // round 2
                // 25 red balloons
                break;
            case 2:
                // round 3
                // 12 red, on the 12th spawn 2 blue
                // small pause
                // 12 red, on the 12th spawn 3 blue
                break;
            case 3:
                // round 4
                // 5 red, on 5th spawn 12 blue
                // 5 red, on 5th spawn 12 blue
                break;
            case 4:
                // round 5
                // 15 red, on 15th spawn 10 blue
                // 15 red, on 15th spawn 15 blue
                break;
            case 5:
                // round 6
                // 15 green
                break;
            case 6:
                // round 7
                // 75 blue
                break;
            case 7:
                // round 8
                // 20 red, 30 blue
                // 30 red, 20 blue
                // 20 red, 20 blue
                break;
            case 8:
                // round 9
                // 25 blue, 15 green, 25 blue
                break;
            case 9:
                // round 10
                // 35 green
                break;
            case 10:
                // round 11
                // 15 yellow
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
    
    public void grid()
    {
        Coordinate[][] positions = new Coordinate[9][9];
        for(int i = 0; i < 9; i++)
        {
            for(int n = 0; n < 9; n++)
            {
                positions[n][i] = new Coordinate(80 + (92 * i), 51 + (92 * n));
            }
        }
        
        Integer[][] remove = {{4, 6, 7, 8},
                              {1, 2, 3, 4, 6, 8},
                              {1, 6, 8},
                              {1, 2, 3, 4, 5, 6, 8},
                              {0, 8},
                              {0, 3, 4, 5, 8},
                              {0, 3, 5, 8},
                              {0, 1, 2, 3, 5, 6, 7, 8},
                              {0, 1, 2, 3, 4, 5, 6, 7, 8}
                             };
        
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                if(!Arrays.asList(remove[j]).contains(i))
                {
                    // if int == max value, inaccesible
                    positions[i][j].setX(Integer.MAX_VALUE);
                    positions[i][j].setY(Integer.MAX_VALUE);
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
