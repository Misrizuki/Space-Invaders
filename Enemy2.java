import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemy
{
    static final int CHG_RATE = 10; // adjust to suit
    int chgImgIn = 1; 
    int imgNum = 1;
    String[] imageNames = { "enemy2.gif", "enemy2-2.gif" };
    GreenfootImage[] images = new GreenfootImage[2];
    
    private static int numEnemyTwos =0;
    
    private int enemyIdentifier;
    private int rowNumber;
    
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        super.act();
        
       chgImgIn--;
       if (chgImgIn == 0)
       {
         chgImgIn = CHG_RATE; // reset countdown
         imgNum = (imgNum + 1) % 2; // this will alternate {1, 2, 1, 2...}
         setImage(images[imgNum]);
       }
       
       Shoot();
    }
    

    
    public Enemy2(int row)
    {
        numEnemyTwos++;
        
        for(int i = 0; i < imageNames.length; i++)
        {
            images[i] = new GreenfootImage( imageNames[i] );
            images[i].scale(15, 15);
        }
        
        setImage(images[0]);
        
        rowNumber = row;
        
        if( rowNumber == 3)
        {
            enemyIdentifier = numEnemyTwos;
        }
        else
        {
            enemyIdentifier = numEnemyTwos - 8;
        }
        
    }
    
    public void Shoot()
    {
       
    }
    
    public int getID()
    {
        return enemyIdentifier;
    }
    
    public void resetCount()
    {
        numEnemyTwos = 0;
    }
}
