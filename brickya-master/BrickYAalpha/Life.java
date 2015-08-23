import greenfoot.*;

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    private int x;
    private int y;
    public int life = 3;
    
    /**
     * Act - do whatever the Life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        x = getX();
        y = getY();
        turnTowards(x, y+1);
        move(3);
        if(isTouching(Platform.class)){
            life++;
        }
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }    

}
