import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VKright here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VKright extends VirtualKey
{
    /**
     * Act - do whatever the VKright wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            MyWorld world = (MyWorld)getWorld();
            Player player = world.getPlayer();
            player.virtualKey("Tright");
        }
    }    
}
