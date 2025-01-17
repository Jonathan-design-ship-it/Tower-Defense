import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor {
    private int towerType; // The type of tower this button represents

    // Constructor to set the image and the tower type
    public Button(String imagePath, int towerType) {
        setImage(new GreenfootImage(imagePath));  // Set the image for the button
        this.towerType = towerType;  // Store the tower type
    }

    // Getter for the tower type this button represents
    public int getTowerType() {
        return towerType;
    }

    public void act() {
        // Add any additional button-specific behavior here (e.g., hover effects)
    }
}

