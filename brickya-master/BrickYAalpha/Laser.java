import greenfoot.*;

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    private int x,y;
    private boolean hit = false;
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turnTowards(getX(), getY()+1);
        move(3);        
        if(hit == false && isTouching(Platform.class)){
            World world = getWorld();
            int x = Platform.getInstance().getX();
            int y = Platform.getInstance().getY();
            LaserFire gun1 = new LaserFire();
            LaserFire gun2 = new LaserFire();
            world.addObject(gun1, x - 96, y - 15);
            world.addObject(gun2, x + 96, y - 15);
            hit = true;
        }

        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    } 
}

