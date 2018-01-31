import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy3 extends Enemy
{
    static final int CHG_RATE = 10; // adjust to what looks right
    int chgImgIn = 1; 
    int imgNum = 1;
    String[] imageNames = { "enemy3.gif", "enemy3-2.gif" };
    GreenfootImage[] images = new GreenfootImage[2];
    
    private static int numEnemyThrees =0;
    
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
    
    public Enemy3(int row)
    {
        numEnemyThrees++;
        
        for(int i = 0; i < imageNames.length; i++)
        {
            images[i] = new GreenfootImage( imageNames[i] );
            images[i].scale(15, 15);
        }
        
        setImage(images[0]);
        
        rowNumber = row;
        
        if( rowNumber == 5)
        {
            enemyIdentifier = numEnemyThrees;
        }
        else
        {
            enemyIdentifier = numEnemyThrees - 8;
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
        numEnemyThrees = 0;
    }
}
