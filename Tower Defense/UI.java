import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class UI extends Actor {
    private int selectedTower = -1; // -1 means no tower selected

    public void act() {
        // Check for button clicks and set selected tower
        if (Greenfoot.mouseClicked(this)) {
            Actor clicked = Greenfoot.getMouseInfo().getActor();

            // Check if the clicked actor is a Button and set the selected tower accordingly
            if (clicked instanceof Button) {
                Button clickedButton = (Button) clicked;
                selectedTower = clickedButton.getTowerType(); // Set selected tower based on button's tower type
            }
        }
    }

    // Getter to retrieve the selected tower type
    public int getSelectedTower() {
        return selectedTower;
    }
}
