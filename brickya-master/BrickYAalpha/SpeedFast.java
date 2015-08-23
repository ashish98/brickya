import greenfoot.*;

/**
 * Write a description of class SpeedFast here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedFast extends Actor
{
    private int x;
    private int y;
    
    /**
     * Act - do whatever the SpeedFast wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        x = getX();
        y = getY();
        turnTowards(x, y+1);
        move(3);
        if(isTouching(Platform.class)){
            ball.getInstance().increaseSpeed();
        }
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    
    } 
}