import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class UI extends Actor {
    private int selectedTower = -1; // -1 means no tower selected

    public void act() {
        // Check for button clicks and set selected tower
        if (Greenfoot.mouseClicked(this)) {
            Actor clicked = Greenfoot.getMouseInfo().getActor();

            if (clicked instanceof BombButton) {
                selectedTower = 0; // BombTower
            } else if (clicked instanceof DartMonkeyButton) {
                selectedTower = 1; // DartMonkey
            } else if (clicked instanceof SuperMonkeyButton) {
                selectedTower = 2; // SuperMonkey
            } else if (clicked instanceof IceMonkeyButton) {
                selectedTower = 3; // IceMonkey
            } else if (clicked instanceof TackShooterButton) {
                selectedTower = 4; // TackShooter
            }
        }
    }

    // Getter to retrieve the selected tower type
    public int getSelectedTower() {
        return selectedTower;
    }
}
