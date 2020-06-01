import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Projectile extends Actor
{
    public Projectile()
    {
        setImage(new GreenfootImage(10,2));
        getImage().setColor(Color.BLACK);
        getImage().fillRect(0,0,10,2);
    }
    public void act() 
    {
        move(10);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }    
}
