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
    
    private double targetFirst;

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
        setImage(type.concat(".png"));
        enableStaticRotation();
        scale(1.5);
        destinations = randomize(map);
        switch(type){
            case "red":
                speed = 2.9;
                return;
            case "blue":
                speed = 3.3;
                return;
            case "green":
                speed = 4.2;
                return;
            case "yellow":
                speed = 6;
                return;
            case "black":
                speed = 6;
                return;
            case "white":
                speed = 6;
                return;
        }
    }

    public void act() 
    {
        actCount++;
        x = getX();
        y = getY();
        goDestination();
        checkPop();
    }
    
    public double getFirst(){
        return targetFirst;
    }
    
    protected void checkPop(){
        if (health <= 0){
            int over = Math.abs(health);
            switch(type){
                case "red":
                    getWorld().removeObject(this);
                    return;
                case "blue":
                    type = "red";
                    health = 1 - over;
                    setImage("red.png");
                    scale(1.5);
                    return;
                case "green":
                    type = "blue";
                    health = 1 - over;
                    setImage("blue.png");
                    scale(1.5);
                    return;
                case "yellow":
                    type = "green";
                    health = 1 - over;
                    setImage("green.png");
                    scale(1.5);
                    return;
                case "black":
                    type = "yellow";
                    health = 1 - over;
                    getWorld().addObject(new Balloon("yellow", destinations, over), getX(), getY());
                    setImage("yellow.png");
                    scale(1.5);
                    return;
                case "white":
                    type = "yellow";
                    health = 1 - over;
                    getWorld().addObject(new Balloon("yellow", destinations, over), getX(), getY());
                    setImage("yellow.png");
                    scale(1.5);
                    return;
            }
        }
    }

    protected void takeDamage(int dmg){
        health -= dmg;
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
