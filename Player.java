
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    private int speed = 3;
    private int time = 0;
    private int totalNyawa = 3;
    
    public Player(){
        setImage(new GreenfootImage(70,50));
        getImage().setColor(Color.YELLOW);
        getImage().fillOval(0, 0, 50, 50);
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 20, 70, 10);
    }
    
    public void act() 
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        terkenaVirus(); 
        
    }
    
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() != null)
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    
    //untuk memberikan fungsi gerak pada keyboard
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("w"))
            setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
            setLocation(getX() - speed, getY());
        if(Greenfoot.isKeyDown("s"))
            setLocation(getX(),getY() + speed);
        if(Greenfoot.isKeyDown("d"))
            setLocation(getX() + speed, getY());
    }
    
    //untuk membuat fungsi tembak
    public void fireProjectile()
    {
        if(Greenfoot.mousePressed(null)){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
        }
        
    }
    
    public void terkenaVirus()
    {
        Actor virus = getOneIntersectingObject(Virus.class);
        if(virus != null)
        {
            totalNyawa--;
            getWorld().removeObject(virus);
            
        }
        if(totalNyawa==0){
            getWorld().showText("Anda Kalah! - Kamu bertahan selama "+ (time/60)+ " detik", getWorld().getWidth()/2, getWorld().getHeight()/2);
            MyWorld world = (MyWorld)getWorld();
            Counter score = world.getScore();
            score.tampilScore();
            Greenfoot.stop();
        }
    }
 
    
}
