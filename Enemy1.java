import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemy
{
    static final int CHG_RATE = 10; // adjust to suit
    int chgImgIn = 1; 
    int imgNum = 1;
    String[] imageNames = { "enemy1.gif", "enemy1-2.gif" };
    GreenfootImage[] images = new GreenfootImage[2];
    
    private static int numEnemyOnes = 0;
    
    private int enemyIdentifier;
    private int rowNumber;
    int getRandomNumber;
    
    
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
         imgNum = (imgNum + 1) % 2; // this will alternate {0, 1, 2, 0...}
         setImage(images[imgNum]);
       }
       
       Shoot();
    }
    
    public void Shoot()
    {
      
    }
    

    public Enemy1( int row)
    {
        numEnemyOnes++;
        
        for(int i = 0; i < imageNames.length; i++)
        {
            images[i] = new GreenfootImage( imageNames[i] );
            images[i].scale(15, 15);
        }
        
        setImage(images[0]);
        
        rowNumber = row;
        
        if( rowNumber == 1)
        {
            enemyIdentifier = numEnemyOnes;
        }
        else
        {
            enemyIdentifier = numEnemyOnes - 8;
        }
        
    }
    
    public int getID()
    {
        return enemyIdentifier;
    }
    
    public void resetCount()
    {
        numEnemyOnes = 0;
    }
    
}
