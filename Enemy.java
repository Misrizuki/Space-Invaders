import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    protected static int movementModifier = 1;
    
    private static int changeMoveDelay = 480;
    private static int changeMoveMax;
    
    private int actDelay = 24;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if( actDelay >= getWorld().getObjects(Enemy.class).size()/2)
        {
              changeMoveMax = 10 * getWorld().getObjects(Enemy.class).size();
              
              move();
              
              changeMoveDelay++;
              
              actDelay = 0;
        }
        
        actDelay++;
    }  
    
    public void move()
    {
        Space world = (Space)getWorld();
        
        if(this == world.getLeaderOne() || this == world.getLeaderTwo() || this == world.getLeaderThree()
            || this == world.getLeaderFour() || this == world.getLeaderFive() || this == world.getLeaderSix() )
        {
            checkForWall();
        }
        
        setLocation( getX() + 15*movementModifier, getY() );
    }
    
    private void checkForWall()
    {
        Space world = (Space)getWorld();
        List<Enemy> allEnemies = getWorld().getObjects(Enemy.class);
        Enemy currentEnemy;
        
        if( getObjectsInRange(20, Wall.class).size() > 0 && changeMoveDelay > changeMoveMax)
        {
            movementModifier = -movementModifier;
            
            for(int i = 0; i < allEnemies.size(); i++)
            {
                currentEnemy = allEnemies.get(i);
                currentEnemy.setLocation(currentEnemy.getX() - 15*movementModifier, currentEnemy.getY() ) ;
                currentEnemy.setLocation(currentEnemy.getX(), currentEnemy.getY() + 15);
            }
        
            correctMovement();
            
            for(int i = 1; i <= 6; i++)
            {
              world.setNewLeader(i, movementModifier);  
            }
            
            changeMoveDelay = 0;
        }
    }
    
    private void correctMovement()
    {
        Space world = (Space)getWorld();
        
        Enemy[] rowOneEnemies = world.getRowOne();
        Enemy[] rowTwoEnemies = world.getRowTwo();
        Enemy[] rowThreeEnemies = world.getRowThree();
        Enemy[] rowFourEnemies = world.getRowFour();
        Enemy[] rowFiveEnemies = world.getRowFive();
        Enemy[] rowSixEnemies = world.getRowSix();
        
        if(this == world.getLeaderOne() )
        {
            for(int i = 1; i < world.getLeaderOne().getID(); i++)
            {
                if( rowOneEnemies[i-1] !=null)
                {
                    rowOneEnemies[i-1].setLocation( rowOneEnemies[i-1].getX() + 30*movementModifier, rowOneEnemies[i-1].getY() );
                }
            }
        }
        else if(this == world.getLeaderTwo() )
        {
            for( int i = 0; i < rowOneEnemies.length; i++ )
            {
                if(rowOneEnemies[i] !=null)
                {
                    rowOneEnemies[i].setLocation(rowOneEnemies[i].getX() + 30*movementModifier, rowOneEnemies[i].getY() );
                }
            }
            
            for(int i = 1; i < world.getLeaderTwo().getID(); i++)
            {
                if( rowOneEnemies[i-1] !=null)
                {
                    rowTwoEnemies[i-1].setLocation( rowTwoEnemies[i-1].getX() + 30*movementModifier, rowTwoEnemies[i-1].getY());
                }
            }
        }
        else if(this == world.getLeaderThree() )
        {
            for( int i = 0; i < rowOneEnemies.length; i++ )
            {
                if(rowOneEnemies[i] !=null)
                {
                    rowOneEnemies[i].setLocation(rowOneEnemies[i].getX() + 30*movementModifier, rowOneEnemies[i].getY() );
                }
            }
            
            for( int i = 0; i < rowTwoEnemies.length; i++ )
            {
                if(rowTwoEnemies[i] !=null)
                {
                    rowTwoEnemies[i].setLocation(rowTwoEnemies[i].getX() + 30*movementModifier, rowTwoEnemies[i].getY() );
                }
            }
            
            for(int i = 1; i < world.getLeaderThree().getID(); i++)
            {
                if( rowThreeEnemies[i-1] !=null)
                {
                    rowThreeEnemies[i-1].setLocation( rowThreeEnemies[i-1].getX() + 30*movementModifier, rowThreeEnemies[i-1].getY());
                }
            }
        }
        else if(this == world.getLeaderFour() )
        {
            for( int i = 0; i < rowOneEnemies.length; i++ )
            {
                if(rowOneEnemies[i] !=null)
                {
                    rowOneEnemies[i].setLocation(rowOneEnemies[i].getX() + 30*movementModifier, rowOneEnemies[i].getY() );
                }
            }
            
            for( int i = 0; i < rowTwoEnemies.length; i++ )
            {
                if(rowTwoEnemies[i] !=null)
                {
                    rowTwoEnemies[i].setLocation(rowTwoEnemies[i].getX() + 30*movementModifier, rowTwoEnemies[i].getY() );
                }
            }
            
            for( int i = 0; i < rowThreeEnemies.length; i++ )
            {
                if(rowThreeEnemies[i] !=null)
                {
                    rowThreeEnemies[i].setLocation(rowThreeEnemies[i].getX() + 30*movementModifier, rowThreeEnemies[i].getY() );
                }
            }
            
            for(int i = 1; i < world.getLeaderFour().getID(); i++)
            {
                if( rowFourEnemies[i-1] !=null)
                {
                    rowFourEnemies[i-1].setLocation( rowFourEnemies[i-1].getX() + 30*movementModifier, rowFourEnemies[i-1].getY());
                }
            }
        }
        else if(this == world.getLeaderFive() )
        {
            for( int i = 0; i < rowOneEnemies.length; i++ )
            {
                if(rowOneEnemies[i] !=null)
                {
                    rowOneEnemies[i].setLocation(rowOneEnemies[i].getX() + 30*movementModifier, rowOneEnemies[i].getY() );
                }
            }
            
            for( int i = 0; i < rowTwoEnemies.length; i++ )
            {
                if(rowTwoEnemies[i] !=null)
                {
                    rowTwoEnemies[i].setLocation(rowTwoEnemies[i].getX() + 30*movementModifier, rowTwoEnemies[i].getY() );
                }
            }
            
            for( int i = 0; i < rowThreeEnemies.length; i++ )
            {
                if(rowThreeEnemies[i] !=null)
                {
                    rowThreeEnemies[i].setLocation(rowThreeEnemies[i].getX() + 30*movementModifier, rowThreeEnemies[i].getY() );
                }
            }
            
            for( int i = 0; i < rowFourEnemies.length; i++ )
            {
                if(rowFourEnemies[i] !=null)
                {
                    rowFourEnemies[i].setLocation(rowFourEnemies[i].getX() + 30*movementModifier, rowFourEnemies[i].getY() );
                }
            }
            
            for(int i = 1; i < world.getLeaderFive().getID(); i++)
            {
                if( rowFiveEnemies[i-1] !=null)
                {
                    rowFiveEnemies[i-1].setLocation( rowFiveEnemies[i-1].getX() + 30*movementModifier, rowFiveEnemies[i-1].getY());
                }
            }
        }
        else
        {
            for( int i = 0; i < rowOneEnemies.length; i++ )
            {
                if(rowOneEnemies[i] !=null)
                {
                    rowOneEnemies[i].setLocation(rowOneEnemies[i].getX() + 30*movementModifier, rowOneEnemies[i].getY() );
                }
            }
            
            for( int i = 0; i < rowTwoEnemies.length; i++ )
            {
                if(rowTwoEnemies[i] !=null)
                {
                    rowTwoEnemies[i].setLocation(rowTwoEnemies[i].getX() + 30*movementModifier, rowTwoEnemies[i].getY() );
                }
            }
            
            for( int i = 0; i < rowThreeEnemies.length; i++ )
            {
                if(rowThreeEnemies[i] !=null)
                {
                    rowThreeEnemies[i].setLocation(rowThreeEnemies[i].getX() + 30*movementModifier, rowThreeEnemies[i].getY() );
                }
            }
            
            for( int i = 0; i < rowFourEnemies.length; i++ )
            {
                if(rowFourEnemies[i] !=null)
                {
                    rowFourEnemies[i].setLocation(rowFourEnemies[i].getX() + 30*movementModifier, rowFourEnemies[i].getY() );
                }
            }
            
            for( int i = 0; i < rowFiveEnemies.length; i++ )
            {
                if(rowFiveEnemies[i] !=null)
                {
                    rowFiveEnemies[i].setLocation(rowFiveEnemies[i].getX() + 30*movementModifier, rowFiveEnemies[i].getY() );
                }
            }
            
            for(int i = 1; i < world.getLeaderSix().getID(); i++)
            {
                if( rowSixEnemies[i-1] !=null)
                {
                    rowSixEnemies[i-1].setLocation( rowSixEnemies[i-1].getX() + 30*movementModifier, rowSixEnemies[i-1].getY());
                }
            }
        }
    }
    
    public int getID()
    {
        return -1;
    }
    
}
