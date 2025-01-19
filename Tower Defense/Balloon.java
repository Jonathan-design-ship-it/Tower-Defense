import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends SuperSmoothMover
{
    private int health;
    private double speed;
    private boolean camo;
    private boolean metal;
    private boolean regen;
    private int x,y;

    private int actCount;

    private String type;

    // for freeze
    private int freezeCount;
    private int freezeLength;
    private boolean isFrozen = false;
    private double originalSpeed;

    private double targetFirst;

    // length of pop image
    private int popCount;
    private boolean damagedByBomb = false;

    //path
    private Coordinate currentDestination;
    private ArrayList<Coordinate> map; //original map coordinates
    private ArrayList<Coordinate> destinations; // map coordinates after offset

    public Balloon(String type, ArrayList<Coordinate> map){
        this(type, map, 0);
    }

    public Balloon(String type, ArrayList<Coordinate> map, int over){
        health = 1 - over; //1
        this.map = map;
        this.type = type;
        destinations = randomize(map);
        setType(type);
    }

    public void act() 
    {
        actCount++;
        x = getX();
        y = getY();
        goDestination();
        checkFrozen();
        checkPop();
    }

    private void checkFrozen(){
        freezeCount ++;
        if (freezeCount >= freezeLength){
            isFrozen = false;
            speed = originalSpeed;
        }
    }

    public void freeze(int length){
        if (!isFrozen && !type.equals("white")){
            freezeLength = length;
            freezeCount = 0;
            speed = 0;
        }
    }

    public double getFirst(){
        return targetFirst;
    }

    private void setType(String type){
        switch(type){
            case "dead":
                return;
            case "red":
                speed = 2.9;
                break;
            case "blue":
                speed = 3.3;
                break;
            case "green":
                speed = 4.2;
                break;
            case "yellow":
                speed = 6;
                break;
            case "black":
                speed = 6;
                break;
            case "white":
                speed = 6;
                break;
        }
        setImage("balloon/" + type + ".png");
        enableStaticRotation();
        scale(0.8);
        
        originalSpeed = speed;
        if (freezeCount <= freezeLength){
            speed = 0;
            GreenfootImage frozenImage = new GreenfootImage("balloon/frozen.png");
            frozenImage.scale(getImage().getWidth(), getImage().getHeight());
            getImage().drawImage(frozenImage, 0, 0);
        }
    }

    protected void checkPop(){
        if (popCount > 0) {
            popCount--;
            return;
        }
        setType(type);
        if (health <= 0 || type.equals("dead")){
            int over = Math.abs(health);
            health = 1 - over;
            switch(type){
                case "dead":
                    getWorld().removeObject(this);
                    return;
                case "red":
                    type = "dead";
                    break;
                case "blue":
                    type = "red";
                    break;
                case "green":
                    type = "blue";
                    break;
                case "yellow":
                    type = "green";
                    break;
                case "black":
                    type = "yellow";
                    getWorld().addObject(new Balloon("yellow", destinations, over), getX(), getY());
                    break;
                case "white":
                    type = "yellow";
                    getWorld().addObject(new Balloon("yellow", destinations, over), getX(), getY());
                    break;
            }
            if (!damagedByBomb) {
                Greenfoot.playSound("popSound.mp3");
                setImage("pop.png");
                scale(0.8);
                popCount = 2;
            }
            // give 1 money per pop
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.money += 1;
        }
        popCount --;
        damagedByBomb = false;
    }

    public int endKill(){
        //type = "end";
        //health = 0;
        getWorld().removeObject(this);
        switch(type){
            case "red":
                return 1;
            case "blue":
                return 2;
            case "green":
                return 3;
            case "yellow":
                return 4;
            case "black":
                return 9;
            case "white":
                return 9;
            default:
                return 0; // wont be called
        }
    }

    protected void takeDamage(String projectile, int dmg){
        if (projectile.equals("bomb") && type.equals("black")){
            // dont damage
        } else if (freezeCount < freezeLength && !projectile.equals("bomb")){
            // dont damage
        } else {
            health -= dmg;
            if (projectile.equals("bomb")) {
                damagedByBomb = true;
            }
        }
    }

    protected void scale(double num){
        getImage().scale((int)(getImage().getWidth()*num), (int)(getImage().getHeight()*num));
    }

    protected ArrayList<Coordinate> randomize(ArrayList<Coordinate> map){
        destinations = new ArrayList<>(); // Create a new list for randomized coordinates
        Random random = new Random();
        for (Coordinate c : map) {
            // Create a copy of the original coordinate
            Coordinate newCoordinate = new Coordinate(c.getX(), c.getY());

            // Add a random offset to the new coordinate
            double randomX = -10 + (20 * random.nextDouble()); // Random between -10 and 10
            double randomY = -10 + (20 * random.nextDouble()); // Random between -10 and 10

            newCoordinate.dX(randomX);
            newCoordinate.dY(randomY);

            destinations.add(newCoordinate);
        }
        return destinations;
    }

    private void goDestination(){
        // Check if there is another destination for me if I don't have one
        if (currentDestination == null && destinations.size() > 0){
            currentDestination = getNextDestination ();
        }

        if (currentDestination != null){
            moveTowardsDestination();
        }
    }

    public void addDestination (Coordinate c){
        destinations.add(c);
    }

    protected Coordinate getNextDestination () {
        return destinations.get(0);
    }

    protected void moveTowardsDestination(){
        double distanceToDestination = getDistance (new Coordinate(getX(), getY()), currentDestination);
        if (distanceToDestination < speed){
            setLocation (currentDestination.getX(), currentDestination.getY());
            destinations.remove(currentDestination);
            map.remove(currentDestination);
            currentDestination = null;
        } else {
            turnTowards (currentDestination.getX(), currentDestination.getY());
            move(speed);
            targetFirst += speed;
        }
    }

    /**
     * Static method that gets the distance between the x,y coordinates of two Actors
     * using Pythagorean Theorum.
     *
     * @param a     First Actor
     * @param b     Second Actor
     * @return distance The distance from the center of a to the center of b.
     */
    public static double getDistance (Coordinate a, Coordinate b)
    {
        double distance;
        double xLength = a.getX() - b.getX();
        double yLength = a.getY() - b.getY();
        distance = Math.sqrt(Math.pow(xLength, 2) + Math.pow(yLength, 2));
        return distance;
    }
}
