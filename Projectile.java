import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Projectile extends Actor
{
    public Projectile()
    {
        setImage(new GreenfootImage(10,2));
        //mungkin ini ga bisa ke droidfoot
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
    
    public boolean isAtEdge(){
        if(getX()<1||getX()>798||getY()<1||getY()>598){
            return true;
        }
        else{
            return false;
        }
    }
}
