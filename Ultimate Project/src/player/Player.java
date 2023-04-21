package player;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Window;
import platform.Platform;
import platform.PlatformManager;

public class Player {
    int x;
    int y;

    int yspeed;
    int xspeed;

    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;

    PlayerPoint playerPointA;
    PlayerPoint playerPointB;

    public boolean walking;

    PlatformManager platformManager;
    public Player(PlatformManager platformManager){
        this.platformManager = platformManager;

        this.x = 100;
        this.y = 100;

        this.yspeed = 0;
        this.xspeed = 0;

        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;

        this.walking = false;

        this.playerPointA = new PlayerPoint(x, y+Window.sprite_size*2);
        this.playerPointB = new PlayerPoint(x+Window.sprite_size, y+Window.sprite_size*2);
        //checkIfWalking();
    }

    public void move(){
        if(left && right || !left && !right) xspeed *= 0.8;
        else if (left && !right) xspeed--;
        else if (!left && right) xspeed++;

        if(xspeed>0 && xspeed < 0.75) xspeed = 0;
        if(xspeed < 0 && xspeed > -0.75) xspeed = 0;
        if(xspeed > 7 ) xspeed = 7;
        if(xspeed < -7 ) xspeed = -7;

        x+=xspeed;
        y+=yspeed;

        updatePlayerPoints();
        checkIfWalking();
    }

    public void updatePlayerPoints(){
        playerPointA.updatePlayerPoint(x, y+Window.sprite_size*2);
        playerPointB.updatePlayerPoint(x+Window.sprite_size, y+Window.sprite_size*2);
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
}
