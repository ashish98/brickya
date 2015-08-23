import greenfoot.*;

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseMoved(null)){
            int x = Greenfoot.getMouseInfo().getX();
            setLocation(x, 595);
        }

        if(atWorldEdgeRight()){
            setLocation(getWorld().getWidth() - 96, 595);
        }

        if(atWorldEdgeLeft()){
            setLocation(96, 595);
        }
    }   
    
    private boolean atWorldEdgeRight()
    {
        if(getX()> getWorld().getWidth() - 96)
            return true;
        else
            return false;
    }

    private boolean atWorldEdgeLeft(){
        if(getX() < 96 )
            return true;
        else
            return false;
    }
}
