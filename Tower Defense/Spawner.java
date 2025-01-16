/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner  
{
    private String type;
    private int spawnTime;
    
    public Spawner(String type, int time)
    {
        this.type = type;
        spawnTime = time;
    }
    
    public String getType()
    {
        return type;
    }
    
    public int getTime()
    {
        return spawnTime;
    }
}
