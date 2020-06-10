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
        getWorld().showText("Score kamu : "+ totalScore, getWorld().getWidth()/2, getWorld().getHeight()/3);
    }
}
