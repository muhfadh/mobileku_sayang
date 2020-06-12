import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    private int speed = 3;
    private int time = 0;
    private int totalNyawa = 3;
    private boolean kenaVirus = false;
    private String arahPlayer="up";
    private boolean onMove=false;
    
    public Player(){
        setRotation(-90);
    }
    
    public void autoMove(){
        if(onMove){
            if(arahPlayer.equalsIgnoreCase("up")){
                bergerak("up");
            }
            
            if(arahPlayer.equalsIgnoreCase("down")){
                bergerak("down");
            }
        }
    }
    
    public void bergerak(String arah){
        if(arah.equalsIgnoreCase("up")){
            move(1);
        }
        if(arah.equalsIgnoreCase("down")){
            move(-1);
        }
    }
    
    public void virtualKey(String key){
        if(key.equalsIgnoreCase("up")){
            onMove=true;
            arahPlayer = "up";
            
        }
        
        if(key.equalsIgnoreCase("down")){
            onMove=true;
            arahPlayer = "down";
            
        }
        
        if(key.equalsIgnoreCase("Tleft")){
           turn(-10);     
        }
        
        if(key.equalsIgnoreCase("Tright")){
           turn(10);
        }
        
        if(key.equalsIgnoreCase("stop")){
            onMove=false;
        }
        
        if(key.equalsIgnoreCase("fire")){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
        }
    }
    
    public void act() 
    {
        time++;
        //utk droidfoot
        autoMove();
        //ini utk greenfoot
        //turnAround();
        //moveAround();
        //fireProjectile();
        terkenaVirus(); 
        
    }
    
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() != null)
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    
    public void kendaliPlayer(){
        if("up".equals(Greenfoot.getKey())){
            virtualKey("up");
        }
        
        if("down".equals(Greenfoot.getKey())){
            virtualKey("down");
        }
        
        if("s".equals(Greenfoot.getKey())){
            virtualKey("stop");
        }
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
            MyWorld world = (MyWorld)getWorld();
            Counter score = world.getScore();
            NyawaBar nyawaBar = world.getNyawaBar();
            Ulang ulang = new Ulang();
            Back back = new Back();
           
            if(kenaVirus == false){
                nyawaBar.kurangNyawa();
                kenaVirus = true;
                if(nyawaBar.getNyawa() <= 0){
                    getWorld().removeObject(virus);
                    world.addObject(ulang, 360, world.getHeight()/2);   
                    world.addObject(back, 460, world.getHeight()/2);
                }
            }
        }
        else{
            kenaVirus = false;
        }
   
    }
    
    public boolean getKenaVirus(){
        return kenaVirus;
    }
    
    public int getTime(){
        return time;
    }
 
    
}
