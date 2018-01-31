import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version 3.141592653589793238462643383279502884197169399375105820974944..........
 */
public class Space extends World
{
    private int playerScore;

    private static Score player1Score;
    
    private boolean startGame = false;

    private Enemy[] rowOneEnemies = new Enemy [8];
    private Enemy[] rowTwoEnemies = new Enemy [8];
    private Enemy[] rowThreeEnemies = new Enemy [8];
    private Enemy[] rowFourEnemies = new Enemy [8];
    private Enemy[] rowFiveEnemies = new Enemy [8];
    private Enemy[] rowSixEnemies = new Enemy [8];

    private Enemy row1Leader;
    private Enemy row2Leader;
    private Enemy row3Leader;
    private Enemy row4Leader;
    private Enemy row5Leader;
    private Enemy row6Leader;

    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        int startingX = 30;

        int startingY1 = 30;

        int startingY2 = 60;

        int startingY3 = 90;

        Enemy1 enemy1;
        Enemy2 enemy2;
        Enemy3 enemy3;

        Wall wall1;
        Wall wall2;
        
        enemy1 = new Enemy1(1);
        enemy1.resetCount();

        for( int i = 0; i < 16; i++ )
        {
            if( i < 8 )
            {
                enemy1 = new Enemy1(1);
                rowOneEnemies[i] = enemy1;
                addObject( enemy1, startingX + i*20, startingY1 );
            }
            else
            {
                enemy1 = new Enemy1(2);
                rowOneEnemies[i-8] = enemy1;
                addObject( enemy1, startingX + (i-8)*20, startingY1 + 15 );
            }
        }
        
        row1Leader = rowOneEnemies[7];
        row2Leader = rowTwoEnemies[7];
        
        enemy2 = new Enemy2(3);
        enemy2.resetCount();

        for( int j = 0; j < 16; j++ )
        {
            if( j < 8 )
            {
                enemy2 = new Enemy2(3);
                rowThreeEnemies[j] = enemy2;
                addObject( enemy2, startingX + j*20, startingY2 );
            }
            else
            {
                enemy2 = new Enemy2(4);
                rowFourEnemies[j-8] = enemy2;
                addObject( enemy2, startingX + (j-8)*20, startingY2 + 15 );
            }
        }

        row3Leader = rowThreeEnemies[7];
        row4Leader = rowFourEnemies[7];
        
        enemy3 = new Enemy3(5);
        enemy3.resetCount();

        for( int k = 0; k < 16; k++ )
        {
            if( k < 8 )
            {
                enemy3 = new Enemy3(5);
                rowFiveEnemies[k] = enemy3;
                addObject( enemy3, startingX + k*20, startingY3 );
            }
            else
            {
                enemy3 = new Enemy3(6);
                rowFiveEnemies[k-8] = enemy3;
                addObject( enemy3, startingX + (k-8)*20, startingY3 + 15 );
            }
        }

        row5Leader = rowFiveEnemies[7];
        row6Leader = rowSixEnemies[7];

        for( int m = 0; m < getWidth()/12; m++ )
        {
            wall1 = new Wall();
            wall2 = new Wall();

            addObject( wall1, m*12 + 6, 6 );
            addObject( wall2, m*12 + 6, getHeight() - 6 );
        }

        for( int n = 0; n < getHeight()/12; n++ )
        {
            wall1 = new Wall();
            wall2 = new Wall();

            addObject( wall1, 6, n*12 + 6 );
            addObject( wall2, getWidth() - 6, n*12 + 6 );
        }
        Barrier barrier = new Barrier();
        addObject(barrier,82,310);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,302,315);
        barrier2.setLocation(302,311);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,531,318);
        barrier3.setLocation(535,312);
        barrier2.setLocation(296,309);
        barrier.setLocation(78,310);
        Ship ship = new Ship();
        addObject(ship,306,365);
        ship.setLocation(297,362);
    }

    public void setNewLeader(int row, int modifier)
    {
        if( row == 1 )
        {
            if(modifier == 1)
            {
                for(int i = 0; i < rowOneEnemies.length; i++)
                {
                    if( rowOneEnemies [i] != null)
                    {
                        row1Leader = rowOneEnemies[i];  
                    }
                }
            }
            else
            {
                for(int i = rowOneEnemies.length-1; i >= 0; i--)
                {
                    if( rowOneEnemies [i] != null)
                    {
                        row1Leader = rowOneEnemies[i];  
                    }
                }
            }
        }
        else if(row ==2 )
        {
            if(modifier == 1)
            {
                for(int i = 0; i < rowTwoEnemies.length; i++)
                {
                    if( rowTwoEnemies [i] != null)
                    {
                        row2Leader = rowTwoEnemies[i];  
                    }
                }
            }
            else
            {
                for(int i = rowTwoEnemies.length-1; i >= 0; i--)
                {
                    if( rowOneEnemies [i] != null)
                    {
                        row2Leader = rowTwoEnemies[i];  
                    }
                }
            }
        }
        else if(row == 3)
        {
            if(modifier == 1)
            {
                for(int i = 0; i < rowThreeEnemies.length; i++)
                {
                    if( rowThreeEnemies [i] != null)
                    {
                        row3Leader = rowThreeEnemies[i];  
                    }
                }
            }
            else
            {
                for(int i = rowThreeEnemies.length-1; i >= 0; i--)
                {
                    if( rowThreeEnemies [i] != null)
                    {
                        row3Leader = rowThreeEnemies[i];  
                    }
                }
            }
        }
        else if(row == 4)
        {
           if(modifier == 1)
            {
                for(int i = 0; i < rowFourEnemies.length; i++)
                {
                    if( rowFourEnemies [i] != null)
                    {
                        row4Leader = rowFourEnemies[i];  
                    }
                }
            }
            else
            {
                for(int i = rowFourEnemies.length-1; i >= 0; i--)
                {
                    if( rowFourEnemies [i] != null)
                    {
                        row4Leader = rowFourEnemies[i];  
                    }
                }
            } 
        }
        else if(row == 5)
        {
            if(modifier == 1)
            {
                for(int i = 0; i < rowFiveEnemies.length; i++)
                {
                    if( rowFiveEnemies [i] != null)
                    {
                        row5Leader = rowFiveEnemies[i];  
                    }
                }
            }
            else
            {
                for(int i = rowFiveEnemies.length-1; i >= 0; i--)
                {
                    if( rowFiveEnemies [i] != null)
                    {
                        row5Leader = rowFiveEnemies[i];  
                    }
                }
            }
        }
        else
        {
            if(modifier == 1)
            {
                for(int i = 0; i < rowSixEnemies.length; i++)
                {
                    if( rowSixEnemies [i] != null)
                    {
                        row6Leader = rowSixEnemies[i];  
                    }
                }
            }
            else
            {
                for(int i = rowSixEnemies.length-1; i >= 0; i--)
                {
                    if( rowSixEnemies [i] != null)
                    {
                        row6Leader = rowSixEnemies[i];  
                    }
                }
            }
        }
    }
    
    private void createBackground()
    {
        showText (" Press spacebar to begin the game!", 200, 550);
    }
    
     public void act()
    {

        if( startGame == false)
        {
            checkKeyPress();

        }

    }

    private void checkKeyPress()
    {

        if( Greenfoot.isKeyDown("up"))
        {
            startGame = true;  
            showText("", 200, 550);
        }

    }
    
    public void removeEnemy(int row, int index)
    {
        if(row == 1)
        {
            rowOneEnemies[index] = null;
        }
        else if(row ==2)
        {
            rowTwoEnemies[index] = null; 
        }
        else if(row == 3)
        {
            rowThreeEnemies[index] = null;
        }
        else if(row == 4)
        {
            rowFourEnemies[index] = null;
        }
        else if(row == 5)
        {
            rowFiveEnemies[index] = null;
        }
        else if(row == 6)
        {
            rowSixEnemies[index] = null;
        }
    }
    
    public Enemy getLeaderOne()
    {
        return row1Leader;
    }
    
    public Enemy getLeaderTwo()
    {
        return row2Leader;
    }
    
    public Enemy getLeaderThree()
    {
        return row3Leader;
    }
    
    public Enemy getLeaderFour()
    {
        return row4Leader;
    }
    
    public Enemy getLeaderFive()
    {
        return row5Leader;
    }
    
    public Enemy getLeaderSix()
    {
        return row6Leader;
    }
    
    public Enemy[] getRowOne()
    {
        return rowOneEnemies;
    }
    
    public Enemy[] getRowTwo()
    {
        return rowTwoEnemies;
    }
    
    public Enemy[] getRowThree()
    {
        return rowThreeEnemies;
    }
    
    public Enemy[] getRowFour()
    {
        return rowFourEnemies;
    }
    
    public Enemy[] getRowFive()
    {
        return rowFiveEnemies;
    }
    
    public Enemy[] getRowSix()
    {
        return rowSixEnemies;
    }
    
    /**
     * getStarted
     * 
     * @param
     * @return startGame
     */
    public boolean getStarted()
    {
        return startGame;
    }

}
