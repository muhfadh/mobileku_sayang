import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Virus extends Actor
{
    private int health = 3;
    Player player;
    public Virus(Player mainPlayer)
    {
        player = mainPlayer;
        setImage("Red_Virus.png");
        getImage().scale(40, 40);
    }
    public void act() 
    {
        moveAround();
        hitByProjectile();
    }
    
    public void moveAround()
    {
        move(1);
        turnTowards(player.getX(), player.getY());
    }
    
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        if(health ==0){
            MyWorld world = (MyWorld)getWorld();
            Counter score = world.getScore();
            score.tambahScore(10);
            getWorld().removeObject(this);
        }
    }
}
