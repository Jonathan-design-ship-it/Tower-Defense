import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

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
    //private Coordinate c;
    private static int map;

    private boolean playing = true;
    // round spawning
    private int roundCount = 0; // round number
    private Spawner s;
    private static Queue<Spawner> spawn = new LinkedList<Spawner>();
    private int spawnCounter; // a counter for when to spawn balloon
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
        /*
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
         */
        if (Greenfoot.isKeyDown("enter") && !playing) {
            roundCount++;
            System.out.println("Round Count: " + roundCount);
            addRound(roundCount);
            playing = true;
        }

        if (playing)
            spawnRound();
    }

    private void spawnRound (){
        if (spawn.size() > 0){
            if (spawn.peek().getTime() == spawnCounter){
                addObject(new Balloon(spawn.poll().getType(), map1Path), 0, 400);
            }
            spawnCounter ++;
        } else {
            playing = false;
        }
    }

    private void addRound (int roundCount){
        switch(roundCount){
            case 1:
                // round 1, 12 red balloons
                for (int i = 0; i < 12; i++){
                    spawn.add(new Spawner("red", 20*i));
                }
                break;
            case 2:
                // round 2
                // 25 red balloons
                for (int i = 0; i < 25; i++){
                    spawn.add(new Spawner("red", 20*i));
                }
                break;
            case 3:
                // round 3
                // 12 red, on the 12th spawn 2 blue
                // 12 red, on the 12th spawn 3 blue
                for (int i = 0; i < 14; i++){
                    if (i < 12){
                        spawn.add(new Spawner("red", 20*i));
                    }else{
                        spawn.add(new Spawner("blue", 20*i));
                    }
                }
                for (int i = 15; i < 30; i++){
                    if (i < 27){
                        spawn.add(new Spawner("red", 20*i));
                    }else{
                        spawn.add(new Spawner("blue", 20*i));
                    }
                }
                break;
            case 4:
                // round 4
                // 5 red, on 5th spawn 12 blue
                // 5 red, on 5th spawn 12 blue
                for (int i = 0; i < 17; i++){
                    if (i < 5){
                        spawn.add(new Spawner("red", 20*i));
                    }else{
                        spawn.add(new Spawner("blue", 20*i));
                    }
                }
                for (int i = 18; i < 35; i++){
                    if (i < 23){
                        spawn.add(new Spawner("red", 20*i));
                    }else{
                        spawn.add(new Spawner("blue", 20*i));
                    }
                }
                break;
            case 5:
                // round 5
                // 15 red, on 15th spawn 10 blue
                // 15 red, on 15th spawn 15 blue
                for (int i = 0; i < 25; i++){
                    if (i < 15){
                        spawn.add(new Spawner("red", 20*i));
                    }else{
                        spawn.add(new Spawner("blue", 20*i));
                    }
                }
                for (int i = 26; i < 56; i++){
                    if (i < 41){
                        spawn.add(new Spawner("red", 20*i));
                    }else{
                        spawn.add(new Spawner("blue", 20*i));
                    }
                }
                break;
            case 6:
                // round 6
                // 15 green
                for (int i = 0; i < 15; i++){
                    spawn.add(new Spawner("green", 20*i));
                }
                break;
            case 7:
                // round 7
                // 75 blue
                for (int i = 0; i < 75; i++) {
                    spawn.add(new Spawner("blue", 20*i));
                }
                break;
            case 8:
                // round 8
                // 20 red, 30 blue
                // 30 red, 20 blue
                // 20 red, 20 blue
                for (int i = 0; i < 50; i++){
                    if (i < 20){
                        spawn.add(new Spawner("red", 20*i));
                    }else{
                        spawn.add(new Spawner("blue", 20*i));
                    }
                }
                for (int i = 51; i < 101; i++){
                    if (i < 81){
                        spawn.add(new Spawner("red", 20*i));
                    }else{
                        spawn.add(new Spawner("blue", 20*i));
                    }
                }
                for (int i = 102; i < 142; i++) {
                    if (i < 122) {
                        spawn.add(new Spawner("red", 20*i));
                    } else {
                        spawn.add(new Spawner("blue", 20*i));
                    }
                }
                break;
            case 9:
                // round 9
                // 25 blue, 15 green, 25 blue
                for (int i = 0; i < 65; i++){
                    if (i < 25){
                        spawn.add(new Spawner("blue", 20*i));
                    }else if (i < 40){
                        spawn.add(new Spawner("green", 20*i));
                    }else{
                        spawn.add(new Spawner("blue", 20*i));
                    }
                }
                break;
            case 10:
                // round 10
                // 35 green
                for (int i = 0; i < 35; i++) {
                    spawn.add(new Spawner("green", 20*i));
                }
                break;
            case 11:
                // round 11
                // 15 yellow
                for (int i = 0; i < 15; i++) {
                    spawn.add(new Spawner("yellow", 20*i));
                }
        }
        spawnCounter = 0;
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
