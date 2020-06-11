import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NyawaBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NyawaBar extends Player
{
    private int nyawa = 4;
    private int lebarNyawaBar = 80;
    private int panjangNyawaBar = 15;
    private int pixelsPerNyawa = (int)lebarNyawaBar/nyawa;
    
    /**
     * Act - do whatever the NyawaBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public NyawaBar(){
        update();
    }
    public void act() 
    {
        update();
    }    
    
    public void update(){
        setImage(new GreenfootImage(lebarNyawaBar + 2,panjangNyawaBar + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, lebarNyawaBar + 1, panjangNyawaBar +1);     
        myImage.setColor(Color.RED);
        myImage.fillRect(1,1, nyawa*pixelsPerNyawa, panjangNyawaBar);
    }
    
    public void kurangNyawa(){
        nyawa--;
    }
    
    public int getNyawa(){
        return nyawa;
    }
}
