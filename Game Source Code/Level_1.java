import greenfoot.*;

/**
 * Write a description of class Level_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_1 extends World
{
    public int points = 0;
    public int life = 3;
    
    GreenfootSound music1 = new GreenfootSound("WIN01.mp3");
    /*
     * Constructor for objects of class Level_1.
     * 
     */
    public void act(){
        
        points = ball.getInstance().getPoints();
        life = Life.getInstance().getLife();
        showText("Points :" + points, 100, 50);
        showText("Life :" + life, 400, 50);
        if(getObjects(Yellow1.class).isEmpty() && getObjects(Red1.class).isEmpty()){
            showText("Level Complete!!!", 500,300);
            ball.getInstance().returnMusic().pause();
            music1.play();
            Greenfoot.stop();
            //Greenfoot.setWorld(new Level_2());
        }
        
    }
    
    public Level_1()
    {    
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }
    
    private void prepare(){
        addObject(Platform.getInstance(), 500, 595);
        
        layoutYellow1(100,100,36,5);
        layoutRed1(100,118,36,5);
        layoutYellow1(100,136,36,5);
        layoutRed1(100, 154, 36,5);
        layoutYellow1(100,172,36,5);
        layoutRed1(100,190,36,5);
        layoutYellow1(100,208,36,5);
        layoutRed1(100, 226, 36,5);
        layoutYellow1(100,244,36,5);
        layoutRed1(100,262,36,5);
        
        layoutRed1(400,300,36,5);
        layoutYellow1(400,318,36,5);
        layoutRed1(400, 336, 36,5);
        layoutYellow1(400,354,36,5);
        layoutRed1(400,372,36,5);
        layoutYellow1(400,390,36,5);
        layoutRed1(400, 408, 36,5);
        layoutYellow1(400,426,36,5);
        layoutRed1(400,444,36,5);
        layoutYellow1(400,462,36,5);
        
        layoutYellow1(700,100,36,5);
        layoutRed1(700,118,36,5);
        layoutYellow1(700,136,36,5);
        layoutRed1(700, 154, 36,5);
        layoutYellow1(700,172,36,5);
        layoutRed1(700,190,36,5);
        layoutYellow1(700,208,36,5);
        layoutRed1(700, 226, 36,5);
        layoutYellow1(700,244,36,5);
        layoutRed1(700,262,36,5);
        
        addObject(ball.getInstance(), 540, 574); 
        showText("Points :" + points, 100, 50);
        showText("Life :" + life, 400, 50);

    }
    
    private void layoutYellow1(int initX, int initY, int increment, int noOfBricks){
        Yellow1[] yellow1 = new Yellow1[noOfBricks];
        for (int i=0; i<noOfBricks; i++){
            yellow1[i] = new Yellow1();
            addObject(yellow1[i],initX, initY);
            initX += increment;                        
        }
    }
    
    private void layoutRed1(int initX, int initY, int increment, int noOfBricks){
        Red1[] red1 = new Red1[noOfBricks];
        for (int i=0; i<noOfBricks; i++){
            red1[i] = new Red1();
            addObject(red1[i],initX, initY);
            initX += increment;                        
        }
    }
}
