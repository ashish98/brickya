import greenfoot.*;

/**
 * Write a description of class LaserBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LaserBullet extends Actor
{
    GreenfootSound music1 = new GreenfootSound("explosion.wav");
    /**
     * Act - do whatever the LaserBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int hit = 0;
        turnTowards(getX(), getY() - 1);
        move(3);
        if(isTouching(Yellow1.class)){
            removeTouching(Yellow1.class);
            getWorld().removeObject(this);
            music1.play();
            hit = 1;
        }
        
        if(hit == 0 && isTouching(Red1.class)){
            removeTouching(Red1.class);
            music1.play();
            getWorld().removeObject(this);
            hit = 2;
        }
        
        
    }    
}
