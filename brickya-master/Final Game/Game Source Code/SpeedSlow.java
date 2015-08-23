import greenfoot.*;

/**
 * Write a description of class SpeedSlow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedSlow extends PowerUps
{
    private int x;
    private int y;
    /**
     * Act - do whatever the SpeedSlow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        x = getX();
        y = getY();
        turnTowards(x, y+1);
        move(3);
        if(isTouching(Platform.class)){
            ball.getInstance().slowSpeed();
        }
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    } 
}
