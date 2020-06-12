import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private int totalScore = 0;
    
    public Counter(){
        setImage(new GreenfootImage("Score : 0", 24, Color.WHITE, Color.BLACK));
    }
    
    public void tambahScore(int jumlah){
        totalScore += jumlah;
        setImage(new GreenfootImage("Score : " + totalScore, 24, Color.WHITE, Color.BLACK));
    }
    
    public void tampilScore(){
        GreenfootImage skorImg = new GreenfootImage("Score kamu : "+ totalScore,24, Color.WHITE, Color.BLACK);
        Pictures picture = new Pictures(skorImg);
        getWorld().addObject(picture, 400, 180);
    }
}
