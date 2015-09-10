import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Bricks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bricks extends Actor
{
    private int size = 152;
    
    private static volatile Bricks instance;
    public static Bricks getInstance(){
        if (instance == null){
            instance = new Bricks();
        }
        
        return instance;
    }
    /**
     * Act - do whatever the Bricks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    
    public void updateSize(){
        size -= 1;
    }
    
    public int getSize(){
        return size;
    }
}
