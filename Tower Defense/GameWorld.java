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
    public static ArrayList<Coordinate> mapPath;

    //private Coordinate c;
    private static int map;

    private boolean playing = true;
    // round spawning
    private Spawner s;
    private static Queue<Spawner> spawn = new LinkedList<Spawner>();
    private int spawnCounter; // a counter for when to spawn balloon
    private int redCount; // amount of red balloon
    private int blueCount; // amount of blue balloon
    private int greenCount; // amount of green balloon
    private int yellowCount;  // amount of yellow balloon

    private Text roundText;
    private int roundCount = 0; // round number

    private Text moneyText;
    public static int money; // start at 650
    private int endMoney = 101;

    private int actCount;

    private UI ui;
    private Tower selectedTower = null;
    private Tower towerBeingPlaced = null;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 842, 1, false);
        money = 650;

        mapPath = new ArrayList<Coordinate>();

        grid();

        map = 3;
        setBackground(new GreenfootImage("map/map" + map + ".png"));
        switch (map){
            case 1:
                mapPath.add(new Coordinate (-50,400));
                mapPath.add(new Coordinate (0,400));
                mapPath.add(new Coordinate (170,400));
                mapPath.add(new Coordinate (170,175));
                mapPath.add(new Coordinate (375,175));
                mapPath.add(new Coordinate (375,620));
                mapPath.add(new Coordinate (95,620));
                mapPath.add(new Coordinate (95,760));
                mapPath.add(new Coordinate (750,760));
                mapPath.add(new Coordinate (750,530));
                mapPath.add(new Coordinate (540,530));
                mapPath.add(new Coordinate (540,325));
                mapPath.add(new Coordinate (760,325));
                mapPath.add(new Coordinate (750,90));
                mapPath.add(new Coordinate (470,100));
                mapPath.add(new Coordinate (470, -70)); 
                addObject(new HealthZone(), 470, 10);
                break;
            case 2:
                mapPath.add(new Coordinate (-50,415));
                mapPath.add(new Coordinate (0,415));
                mapPath.add(new Coordinate (320,415));
                mapPath.add(new Coordinate (320,200));
                mapPath.add(new Coordinate (195,190));
                mapPath.add(new Coordinate (195,65));
                mapPath.add(new Coordinate (725,65));
                mapPath.add(new Coordinate (725,205));
                mapPath.add(new Coordinate (510,210));
                mapPath.add(new Coordinate (510,360));
                mapPath.add(new Coordinate (735,360));
                mapPath.add(new Coordinate (735,525));
                mapPath.add(new Coordinate (200,525));
                mapPath.add(new Coordinate (200,760));
                mapPath.add(new Coordinate (410,760));
                mapPath.add(new Coordinate (410,610));
                mapPath.add(new Coordinate (610,610));
                mapPath.add(new Coordinate (610,902));
                addObject(new HealthZone(), 610, 832);
                break;
            case 3:
                mapPath.add(new Coordinate (130,-50));
                mapPath.add(new Coordinate (130,0));
                mapPath.add(new Coordinate (130,340));
                mapPath.add(new Coordinate (280,340));
                mapPath.add(new Coordinate (280,520));
                mapPath.add(new Coordinate (115,520));
                mapPath.add(new Coordinate (115,695));
                mapPath.add(new Coordinate (435,695));
                mapPath.add(new Coordinate (435,160));
                mapPath.add(new Coordinate (750,160));
                mapPath.add(new Coordinate (750,340));
                mapPath.add(new Coordinate (590,340));
                mapPath.add(new Coordinate (590,520));
                mapPath.add(new Coordinate (735,520));
                mapPath.add(new Coordinate (735,902));
                addObject(new HealthZone(), 732, 832);
                break;
        }
        addObject(roundText = new Text(), 975, 30);
        addObject(moneyText = new Text(), 975, 65);

        ui = new UI();  
        addObject(ui, 900, 100);  

        // Add buttons for each tower
        addObject(new Button("bomb_button.png", 0), 900, 200);
        addObject(new Button("dart_button.png", 1), 900, 300);
        addObject(new Button("super_button.png", 2), 900, 400);
        addObject(new Button("ice_button.png", 3), 900, 500);
        addObject(new Button("tack_button.png", 4), 900, 600);
    }

    public void act(){
        actCount ++;
        /*
        if (actCount == 60){
        Random random = new Random();
        int num = random.nextInt(6);
        //int num = 0;
        if (num == 0)
        addObject(new Balloon("red", mapPath), 0, 400);
        if (num == 1)
        addObject(new Balloon("blue", mapPath), 0, 400);
        if (num == 2)
        addObject(new Balloon("green", mapPath), 0, 400);
        if (num == 3)
        addObject(new Balloon("yellow", mapPath), 0, 400);
        if (num == 4)
        addObject(new Balloon("white", mapPath), 0, 400);
        if (num == 5)
        addObject(new Balloon("black", mapPath), 0, 400);
        actCount = 0;
        }
         */

        int selectedTowerIndex = ui.getSelectedTower();
        // Handle tower selection and following the mouse
        if (selectedTowerIndex != -1 && towerBeingPlaced == null) {
            // Spawn the selected tower and make it follow the mouse
            towerBeingPlaced = createTower(selectedTowerIndex);
            addObject(towerBeingPlaced, Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        }

        if (towerBeingPlaced != null) {
            // Move the tower with the mouse
            towerBeingPlaced.setLocation(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());

            // Right-click to place the tower on the grid
            if (Greenfoot.mouseClicked(null)) {
                MouseInfo mouse = Greenfoot.getMouseInfo();
                int x = mouse.getX();
                int y = mouse.getY();

                // Calculate which grid cell was clicked
                int gridX = (x - 80) / 92;
                int gridY = (y - 51) / 92;

                // If the click is inside the grid
                if (gridX >= 0 && gridX < 9 && gridY >= 0 && gridY < 9) {
                    // Place the tower at the clicked grid position
                    placeTower(gridX, gridY, selectedTowerIndex);
                    removeObject(towerBeingPlaced); // Remove the temporary tower
                    towerBeingPlaced = null; // Reset the placement process
                }
            }
        }

        if (Greenfoot.isKeyDown("enter") && !playing) {
            roundCount++;
            addRound(roundCount);
            playing = true;
        }

        if (roundCount == 0){
            roundText.updateText("Round: 1");
        }else{
            roundText.updateText("Round: " + roundCount);            
        }
        moneyText.updateText("Money: " + money);

        if (playing)
            spawnRound();
    }

    public void addMoney(int money){
        this.money += money;
    }

    private void spawnRound (){
        if (spawn.size() > 0){
            if (spawn.peek().getTime() == spawnCounter){
                addObject(new Balloon(spawn.poll().getType(), mapPath), mapPath.get(0).getX(), mapPath.get(0).getY());
            }
            spawnCounter ++;
        } else {
            if (getObjects(Balloon.class).isEmpty()) {
                playing = false;
                if (roundCount > 0)
                    money += (endMoney -= 1);
            }
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
                break;
            case 12:
                break;
            case 50:
                Greenfoot.setWorld(new WinScreen());
                break;
        }
        spawnCounter = 0;
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

    private void placeTower(int x, int y, int towerIndex) {
        // Use the selected tower index to place the correct tower at the grid coordinates
        switch (towerIndex) {
            case 0:
                addObject(new BombTower(), x * 92 + 80, y * 92 + 51);
                break;
            case 1:
                addObject(new DartMonkey(), x * 92 + 80, y * 92 + 51);
                break;
            case 2:
                addObject(new SuperMonkey(), x * 92 + 80, y * 92 + 51);
                break;
            case 3:
                addObject(new IceMonkey(), x * 92 + 80, y * 92 + 51);
                break;
            case 4:
                addObject(new TackShooter(), x * 92 + 80, y * 92 + 51);
                break;
        }
    }

    private Tower createTower(int towerIndex) {
        switch (towerIndex) {
            case 0: return new BombTower();
            case 1: return new DartMonkey();
            case 2: return new SuperMonkey();
            case 3: return new IceMonkey();
            case 4: return new TackShooter();
            default: return null;
        }
    }

    public static Coordinate getDestination(int num) {
        return mapPath.get(num);
    }
}
