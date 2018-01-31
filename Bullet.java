import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    
    public Bullet(int rotation)
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
        setLocation( getX(), getY() -16);
        
        Actor Enemy1 = getOneIntersectingObject(Enemy1.class);
        Actor Enemy2 = getOneIntersectingObject(Enemy2.class);
        Actor Enemy3 = getOneIntersectingObject(Enemy3.class);
       
        if(Enemy1 != null)
        {
            getWorld().removeObject(Enemy1);
            getWorld().removeObject(this);
        }
        else if(Enemy2 != null)
        {
            getWorld().removeObject(Enemy2);
            getWorld().removeObject(this);
        }
        else if(Enemy3 != null)
        {
            getWorld().removeObject(Enemy3);
            getWorld().removeObject(this);
        }
        
    }
    
}

