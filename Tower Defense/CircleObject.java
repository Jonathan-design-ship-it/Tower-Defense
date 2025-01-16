import greenfoot.*;  // Import the Greenfoot library

public class CircleObject extends Actor
{
    private int radius;

    // Constructor to set the radius of the circle
    public CircleObject(int radius)
    {
        this.radius = radius;
        updateImage();
    }

    // This method draws the circle with the given radius
    public void updateImage()
    {
        GreenfootImage image = new GreenfootImage(2 * radius, 2 * radius); // Image size based on diameter
        image.setColor(Color.WHITE); // Set color of the circle to grey
        image.fillOval(0, 0, 2 * radius, 2 * radius); // Draw the circle

        setImage(image); // Set the image for this actor
    }

    // The act method to move the circle with the cursor and disappear on click
    public void act() 
    {
        // // Get the current mouse position
        // MouseInfo mouse = Greenfoot.getMouseInfo();
        
        // if (mouse != null)
        // {
            // // Set the position of the circle to the mouse's position
            // setLocation(mouse.getX(), mouse.getY());
        // }

        // // Check if the mouse has clicked on this actor (circle)
        // if (Greenfoot.mouseClicked(this))
        // {
            // // Remove this actor from the world (i.e., make it disappear)
            // getWorld().removeObject(this);
        // }
    }
}
