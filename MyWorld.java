
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    int count = 0;
    //semakin besar spawn, semakin lama munculnya
    int spawnSpeed = 100;
    int randomSpawn;

    private Counter score;

    public Player mainPlayer = new Player();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        score = new Counter();
        addObject(score,60,20);

        prepare();
    }

    public Counter getScore(){
        return score;
    }

    public void act()
    {
        //Agar muncul secara berkala dan random
        count++;
        spawnVirus();

    }

    public void spawnVirus(){
        if(count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch(randomSpawn){
                case 0 : addObject(new Virus(mainPlayer), 0, 0); break;
                case 1 : addObject(new Virus(mainPlayer), getWidth()/2, 0); break;
                case 2 : addObject(new Virus(mainPlayer), getWidth(), 0); break;
                case 3 : addObject(new Virus(mainPlayer), 0, getHeight()/2); break;
                case 4 : addObject(new Virus(mainPlayer), getWidth(), getHeight()/2); break;
                case 5 : addObject(new Virus(mainPlayer), 0, getHeight()); break;
                case 6 : addObject(new Virus(mainPlayer), getWidth()/2, getHeight()); break;
                case 7 : addObject(new Virus(mainPlayer), getWidth(), getHeight()); break;
            }
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
