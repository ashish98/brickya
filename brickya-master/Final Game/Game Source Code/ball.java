import greenfoot.*;

/**
 * Write a description of class ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ball extends Actor
{
    public int init = 0;
    public int prevX;
    public int prevY;
    public int presX;
    public int presY;
    public int presMx = 0;
    public int prevMx = 0;
    public int mouseSpeed;
    public int speed = 8;
    public int points = 0;
    public int temp = 0;
    
    GreenfootSound music1 = new GreenfootSound("INTRO01.mp3");
    GreenfootSound music2 = new GreenfootSound("SONG01.mp3");
    GreenfootSound music3 = new GreenfootSound("boink1.wav");
    GreenfootSound music4 = new GreenfootSound("brickHit.wav");
    GreenfootSound music5 = new GreenfootSound("GAMEOVER01.mp3");
    GreenfootSound music6 = new GreenfootSound("createPowerup.wav");
    GreenfootSound music7 = new GreenfootSound("genericPowerup.wav");    
    GreenfootSound music8 = new GreenfootSound("boink2.wav");
    GreenfootSound music9 = new GreenfootSound("paddleBreak.wav");
    
    private static volatile ball instance;
    public static ball getInstance(){
        if (instance == null){
            instance = new ball();
        }
        
        return instance;
    }
    /*
    public ball(int direction)
    {
    setRotation(direction);
    }
     */
    /**
     * Act - do whatever the ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        if(init==0){
            music1.play();
            if (Greenfoot.mouseMoved(null)){
                presMx = Greenfoot.getMouseInfo().getX();
                setLocation(presMx + 40, 574);
            }

            if(atWorldEdgeRight()){
                presMx = getWorld().getWidth() - 56;
                setLocation(presMx, 574);
            }

            if(atWorldEdgeLeft()){
                presMx = 136;
                setLocation(presMx, 574);
            }

            if(Greenfoot.mouseClicked(null)){               
                setRotation(315);
                init++;
                temp++;
            }
        }

        if(init == 1 && temp>0){     
            music1.pause();
            music2.playLoop();
            previousCordi();           
            move(speed);
            if(isAtEdge())
            {
                presentCordi();
                reflectWall(prevX,prevY,presX,presY);

            }

            if(isTouching(Yellow1.class) || isTouching(Red1.class))
            {                                
                
                presentCordi();
                reflect_eat(prevX, prevY, presX, presY);
                int tmp = Greenfoot.getRandomNumber(15);  
                //int tmp = 5;
                if(tmp == 5){
                   int temp = Greenfoot.getRandomNumber(4);
                   //int temp = 2; 
                   World world = getWorld();
                   music6.play();
                   switch(temp){
                       case 0:  SpeedSlow slow = new SpeedSlow();
                                world.addObject(slow, presX, presY);
                                break;
                                
                       case 1:  SpeedFast fast = new SpeedFast();
                                world.addObject(new SpeedFast(), presX, presY);
                                break;
                       case 2:  Laser laser = new Laser();
                                world.addObject(new Laser(), presX, presY);
                                break;
                                
                       case 3:  Life life = new Life();
                                world.addObject(new Life(), presX, presY);
                                break;
                   }
                }
                
            }
            
            if(isTouching(Platform.class))
            {
                music8.play();
                presentCordi();
                reflectPlatform(prevX, prevY, presX, presY, mouseSpeed);                
            }
            
            temp++;
        }
        
        if(temp == 30){
               prevMx = presMx;
               temp = 1;
        }
        mouseSpeed = (presMx - prevMx)*100;

    } 

    /**
     * It will save previous cordinates of ball.
     */
    public void previousCordi()
    {
        prevX=getX();
        prevY=getY();
    }

    /**
     * it will save present cordinates of ball
     */
    public void presentCordi()
    {
        presX=getX();
        presY=getY();
    }

    /**
     * formula for reflection through walls.
     */
    public void reflectWall(int prevX, int prevY, int presX, int presY)
    {
        music3.play();
        int a = 20; // distance to be left from the end of the walls
        int c = getWorld().getWidth()-a;
        int d = getWorld().getHeight()-a;
        int nextX=0;
        int nextY=0;
        if( presX >= c )
        {
            nextX=prevX;
            nextY=2*presY-prevY;
            turn(prevX, prevY, nextX, nextY);
        }
        else if(presX <= a )
        {
            nextX=prevX;
            nextY=2*presY-prevY;
            turn(prevX, prevY, nextX, nextY);
        }
        else if(presY <= a )
        {
            nextY=prevY;
            nextX=2*presX-prevX;
            turn(prevX, prevY, nextX, nextY);
        }
        else if (presY >= d) 
        {
            music2.pause();
            music9.play();
            Life.getInstance().updateLife();
            boolean check = isGameOver();
            if(!check){
                init = 0;
            }
            else{
                music5.play();
                getWorld().showText("Game Over" , 500, 300);
                Greenfoot.stop();
            }
            
        }

        
    }
    
    public GreenfootSound returnMusic(){
        return music5;
    }
    
    public boolean isGameOver(){
        if(Life.getInstance().getLife() == 0){
            return true;
        }
        return false;
    }
    
    public void turn(int prevX, int prevY, int nextX, int nextY){
        if(prevX == nextX && prevY == nextY){
            turn(190);
        }
        else{
            turnTowards(nextX, nextY);
        }
    }
    
    /**
     * reflect through platform
     */
    public void reflectPlatform(int prevX, int prevY, int presX, int presY, int mouseSpeed)
    {
        
        int nextX=0;
        int nextY=0;
        Actor b = getOneIntersectingObject(Platform.class);
        int yrange =b.getY();
        int xrange =b.getX();
        if(prevX>xrange)
        {
            if((presY > yrange-15) && (presX <= xrange+96))
            {
                nextX=prevX;
                nextY=2*presY-prevY;
            }
            else
            {
                nextY=prevY;
                nextX=2*presX-prevX + mouseSpeed;
            }
        }
        else if(prevX<xrange)
        {
            if((presY > yrange-15) && (presX >= xrange-96))
            {
                nextX=prevX;
                nextY=2*presY-prevY;
            }
            else
            {
                nextY=prevY;
                nextX=2*presX-prevX + mouseSpeed;
            }
        }
        turnTowards(nextX, nextY);
    }

    /**
     * reflecting and destroying the obsticle.
     */
    public void reflect_eat(int prevX, int prevY, int presX, int presY)
    {
        int nextX=0;
        int nextY=0;
        Actor b;
        if(isTouching(Yellow1.class)){
            b = getOneIntersectingObject(Yellow1.class);
        }
        else if(isTouching(Red1.class)){
            b = getOneIntersectingObject(Red1.class);
        }
        else{
            b = null;
        }
        int yrange = b.getY();
        int xrange = b.getX();
        if((presY > yrange - 9)&&(presX >= xrange - 18) && (presY < yrange + 9)&&(presX <= xrange + 18))
        {
            nextX=prevX;
            nextY=2*presY-prevY;
        }
        else if((presY==yrange)&&(presX==xrange))
        {
            nextX=prevX;
            nextY=prevY;
        }
        else
        {
            nextY=prevY;
            nextX=2*presX-prevX;
        }
        removeTouching(null);
        updatePoints();
        Bricks.getInstance().updateSize();
        music4.play();
        turnTowards(nextX, nextY);
    }

    private boolean atWorldEdgeRight()
    {
        if(getX()> getWorld().getWidth() - 56)
            return true;
        else
            return false;
    }

    private boolean atWorldEdgeLeft(){
        if(getX() < 136 )
            return true;
        else
            return false;
    }
    
    public void slowSpeed(){
        if (speed >= 6){
            speed = speed - 2;
        }
    }
    
    public void increaseSpeed(){
        if (speed <= 12){
            speed = speed + 2;
        }
    }
    
    public void updatePoints()
    {
        points += 2;
    }
    
    public int getPoints(){
        return points;
    }
}    
