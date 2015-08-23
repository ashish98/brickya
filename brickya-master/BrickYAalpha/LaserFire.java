import greenfoot.*;
import java.util.List;

/**
 * Write a description of class LaserFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LaserFire extends Actor
{
    private int time = 0;
    
    GreenfootSound music1 = new GreenfootSound("laser.wav");
    /**
     * Act - do whatever the LaserFire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseMoved(null) || Greenfoot.mouseDragged(null)){
            int x = Platform.getInstance().getX();
            int y = Platform.getInstance().getY();
            World world = getWorld();
            List<LaserFire> gun = world.getObjects(LaserFire.class); 
            for(int i=0; i< gun.size(); i++){
                if(i%2 == 0){
                    gun.get(i).setLocation(x-96, y-15);
                }
                else
                    gun.get(i).setLocation(x+96, y-15);
                }
            }

        if(Greenfoot.mouseDragged(null) || Greenfoot.mouseClicked(null)){
            fire();
        }
    }   

    private void fire(){
        time ++;
        if(time % 20 == 0){            
            music1.play();
            LaserBullet bullet1 = new LaserBullet();    
            LaserBullet bullet2 = new LaserBullet();
            World world = getWorld();
            List<LaserFire> gun = world.getObjects(LaserFire.class);
            int x1 = gun.get(0).getX();
            int x2 = gun.get(1).getX();
            int y1 = gun.get(0).getY();
            int y2 = gun.get(1).getY();
            world.addObject(bullet1, x1, y1 - 1);
            world.addObject(bullet2, x2, y2 - 1);
        }
    }
}
