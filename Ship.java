import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    private String leftKey;
    private String rightKey;
    
    private boolean spaceDown;
    
    static final int CHG_RATE = 10; // adjust to what looks right
    int chgImgIn = 1; 
    int imgNum = 1;
    String[] images = { "ship.gif", "shipdie.gif", "shipdie-2.gif" };
    
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        checkKeyPress();
        
        if(!spaceDown && Greenfoot.isKeyDown("space"))
        {
            spaceDown = true;
            getWorld().addObject(new Bullet(getRotation()), getX(), getY());  
        }
        else if(!spaceDown && !Greenfoot.isKeyDown("space"))
        {
            spaceDown = false;
        }

    }   
    
    public Ship()
    {
        leftKey = "left";
        rightKey = "right";
    }
    
    /**
     * checkKeyPress checks if the kry is being pressed down
     * 
     * @param
     * @return
     */
      private void checkKeyPress()
    {
     
        if( Greenfoot.isKeyDown (leftKey))
        {
          setLocation(getX()-4,getY());   
        }
        
        if( Greenfoot.isKeyDown (rightKey) )
        {
          setLocation(getX()+4,getY());   
        }
        
    }
    
    public void attackedAnimation()
    {
        
    }
    
}
