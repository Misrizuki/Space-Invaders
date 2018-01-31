import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EBullet extends Actor
{

    public EBullet(int rotation)
    {
        setRotation(rotation);
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setLocation( getX(), getY() +5);
        
        Actor Ship = getOneIntersectingObject(Ship.class);
        if(Ship != null)
        {
            getWorld().removeObject(Ship);
            getWorld().removeObject(this);
        }
       
    }
    
}
