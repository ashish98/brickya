import greenfoot.*;

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends PowerUps
{
    private int x;
    private int y;
    public  static int life ;
    
    private static volatile Life instance;
    public Life(){
        life=3;
    }
    public static Life getInstance(){
        if (instance == null){
            instance = new Life();
        }
        
        return instance;
    }
    
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
            life += 1;
        }
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }    

    public int getLife(){
        return this.life;
    }
    
    public void updateLife(){
        life -= 1;
    }
}
