import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    

        super(800, 600, 1); 
        prepare();
    }
    
    private void prepare(){
        GreenfootImage gambar = new GreenfootImage("logo.png");
        Pictures logo = new Pictures(gambar);
        addObject(logo, getWidth()/2, 90);
        Play play = new Play();
        addObject(play,getWidth()/2, 545);
        Exit keluar = new Exit();
        addObject(keluar,745, 545);
    }
}
