package player;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Window;
import platform.Platform;
import platform.PlatformManager;

public class Player {
    int x;
    int y;

    public double yspeed;
    public double xspeed;

    public boolean left;
    public boolean right;

    PlayerPoint playerPointA;
    PlayerPoint playerPointB;

    public boolean walking;
    public boolean walkingFlag;

    public boolean up;
    public boolean jumping;
    public boolean jumpingFlag;
    public boolean inAir;

    PlatformManager platformManager;
    public Player(PlatformManager platformManager){
        this.platformManager = platformManager;

        this.x = 64;
        this.y = 737;

        this.yspeed = 0;
        this.xspeed = 0;

        this.left = false;
        this.right = false;

        this.walking = false;
        this.walkingFlag = false;

        this.up = false;
        this.jumping = false;
        this.jumpingFlag = false;
        this.inAir = false;

        this.playerPointA = new PlayerPoint(x, y+Window.sprite_size*2);
        this.playerPointB = new PlayerPoint(x+Window.sprite_size, y+Window.sprite_size*2);
    }

    public void move(){

        //left right movement
    

        if(left && right || !left && !right) xspeed *= 0.8;
        else if (left && !right) xspeed--;
        else if (!left && right) xspeed++;

        if(xspeed>0 && xspeed < 0.75) xspeed = 0;
        if(xspeed < 0 && xspeed > -0.75) xspeed = 0;
        if(xspeed > 7 ) xspeed = 7;
        if(xspeed < -7 ) xspeed = -7;

        //gravity

        if(!walking && !jumping){
            walkingFlag = true;
            if(yspeed <7){
                yspeed++;
            }
            if(yspeed>7){
                yspeed = 7;
            }
        }
        else{
            if(walkingFlag){
                yspeed = 0;
                walkingFlag = false;
            }
        }

        //jumping

        if(up && !jumpingFlag && !inAir){
            jumpingFlag=true;
            jumping = true;
            Runnable r = new JumpingRunnable(this);
            Thread jump = new Thread(r);
            jump.start();
        }

        //adding values to player location

        x+=xspeed;
        y+=yspeed;

        

        updatePlayerPoints();
        checkIfWalking();
    }

    public void updatePlayerPoints(){
        playerPointA.updatePlayerPoint(x-1, y+Window.sprite_size*2);
        playerPointB.updatePlayerPoint(x+Window.sprite_size+1, y+Window.sprite_size*2);
    }

    public void drawPlayer(Graphics2D g2d){
        g2d.setColor(Color.blue);
        g2d.fillRect(x, y, 64, 128);    
    }

    public void checkIfWalking(){
        boolean flag = false;
        for(Platform plt : platformManager.platformList){
            if(plt.checkIfInside(playerPointA.x, playerPointA.y)){
                walking = true;
                flag = true;
            }

            if(plt.checkIfInside(playerPointB.x, playerPointB.y)){
                walking = true;
                flag = true;
            }
        }
        if(!flag){
            walking = false;
        }
    }

    public boolean ifOnBlock(){
        for(Platform plt : platformManager.platformList){
            if(plt.checkIfInside(playerPointA.x, playerPointA.y)){
                return true;
            }

            if(plt.checkIfInside(playerPointB.x, playerPointB.y)){
                return true;
            }
        }
        return false;
    }

    public void checkIfInAir(){
        boolean odp = ifOnBlock();
        if(odp){
            inAir = false;
        }
        else{
            inAir = true;
        }
    }
}
