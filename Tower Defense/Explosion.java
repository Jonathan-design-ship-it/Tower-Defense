import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private double percent;
    
    // explosion
    private GreenfootImage[] frames; // Array to store animation frames
    private int frameCount; // Total number of frames in the animation
    private int currentFrame; // Current frame being displayed
    private int frameDelay; // Delay between frames for smoother animation
    private int delayCount; // Counter for frame delay
    
    public Explosion()
    {
        frameCount = 16; // 4x4 grid
        frames = new GreenfootImage[frameCount];
        loadFrames();
        currentFrame = 0;
        frameDelay = 3; // speed of the animation
        delayCount = 0;
        percent = 1.0;
        setImage(frames[currentFrame]);
    }
    
    public void act()
    {
        animate();
        fadeOut();
    }
    
    private void loadFrames() {
        GreenfootImage spriteSheet = new GreenfootImage("exp2.png");
        int frameWidth = spriteSheet.getWidth() / 4;
        int frameHeight = spriteSheet.getHeight() / 4;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                GreenfootImage frame = new GreenfootImage(frameWidth, frameHeight);
                frame.drawImage(spriteSheet, -col * frameWidth, -row * frameHeight);
                frame.scale(200, 200);
                frames[row * 4 + col] = frame;
            }
        }
    }
    
    private void animate() {
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            currentFrame++;
            if (currentFrame < frameCount) {
                setImage(frames[currentFrame]);
            } else {
                getWorld().removeObject(this);
            }
        }
    }

    // Handle fading out the explosion
    private void fadeOut() {
        if (percent > 0) {
            percent -= 0.01;
            getImage().setTransparency((int) (percent * 255));
        }
    }
    
    public List getEnemiesInRange(int explosionRadius)
    {
        getImage().scale(explosionRadius * 2, explosionRadius * 2);
        return getObjectsInRange(explosionRadius, Balloon.class);
    }
}
