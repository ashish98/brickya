import greenfoot.*;

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    GreenfootSound music1 = new GreenfootSound("genericPowerup.wav");
    
    private static volatile Platform instance;
    public static Platform getInstance(){
        if(instance == null){
            instance = new Platform();
        }
        return instance;
    }
    
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int presentX;
        if (Greenfoot.mouseMoved(null) || Greenfoot.mouseDragged(null)){
            presentX = Greenfoot.getMouseInfo().getX();
            setLocation(presentX, 595);
        }

        if(atWorldEdgeRight()){
            presentX = getWorld().getWidth() - 96;
            setLocation(presentX, 595);
        }

        if(atWorldEdgeLeft()){
            presentX = 96;
            setLocation(presentX, 595);
        }
        
        if(isTouching(SpeedSlow.class)){
            music1.play();
            removeTouching(SpeedSlow.class);
        }
        
        if(isTouching(SpeedFast.class)){
            music1.play();
            removeTouching(SpeedFast.class);
        }
        
        if(isTouching(Laser.class)){
            music1.play();
            removeTouching(Laser.class);
        }
        
        if(isTouching(Life.class)){
            music1.play();
            removeTouching(Life.class);
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
