import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VKleft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VKleft extends VirtualKey
{
    /**
     * Act - do whatever the VKleft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            MyWorld world = (MyWorld)getWorld();
            Player player = world.getPlayer();
            player.virtualKey("Tleft");
        }
    }    
}
