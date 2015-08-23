import greenfoot.*;

/**
 * Write a description of class Level_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_1 extends World
{

    /**
     * Constructor for objects of class Level_1.
     * 
     */
    
    public Level_1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }
    
    private void prepare(){
        addObject(Platform.getInstance(), 500, 595);
        layoutYellow1(86,100,36,24);  
        layoutYellow1(86,200,36,24);
        layoutYellow1(86,300,36,24);
        layoutRed1(86,150,36,24);
        layoutRed1(86,250,36,24);
        addObject(ball.getInstance(), 540, 574);
        

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
