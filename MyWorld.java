
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    int count = 0;
    //semakin besar spawn, semakin lama munculnya
    int spawnSpeed = 100;
    int randomSpawn;
    int sisaNyawa;
    private int totalNyawa = 3;
    boolean kenaVirus = false;
    private Counter score;
    private Player mainPlayer = new Player();
    NyawaBar nyawaBar = new NyawaBar();
    
    public MyWorld()
    {    
        
        super(800, 600, 1); 
        
        prepare();
    }

    public Counter getScore(){
        return score;
    }
    
    public NyawaBar getNyawaBar(){
        return nyawaBar;
    }

    public void act()
    {
        //Agar muncul secara berkala dan random
        count++;
        spawnVirus();
        gameOver();

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
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        score = new Counter();
        addObject(score,60,20);
        addObject(nyawaBar, 720, 20);
        VKdown vKdown = new VKdown();
        addObject(vKdown,108,530);
        VKup vKup = new VKup();
        addObject(vKup,106,400);
        vKup.setLocation(109,400);
        VKleft vKleft = new VKleft();
        addObject(vKleft,39,462);
        VKright vKright = new VKright();
        addObject(vKright,177,459);
        VKfire vKfire = new VKfire();
        addObject(vKfire,704,468);
    }
    
    public Player getPlayer(){
        return mainPlayer;
    }
    
    public void gameOver(){
        sisaNyawa = nyawaBar.getNyawa();
        GreenfootImage gambar = new GreenfootImage("kalah.png");
        Pictures picture = new Pictures(gambar);
        
        if(sisaNyawa <= 0){
            addObject(picture, getWidth()/2, 90);
            score.tampilScore();
        }
    }
    
}
