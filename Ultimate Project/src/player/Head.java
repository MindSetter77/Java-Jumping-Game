package player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import main.Window;
import platform.Platform;

public class Head {
    int x1;
    int y1;
    int x2;
    int y2;

    ArrayList<Platform> platformList;



    public Head(Player player, ArrayList<Platform> platformList){
        this.x1 = player.x;
        this.x2 = player.x+Window.sprite_size;
        this.y1 = player.y;
        this.y2 = player.y;

        this.platformList = platformList;
    }

    public void drawHead(Graphics2D g2d){
        g2d.setColor(Color.cyan);
        g2d.fillRect(x1, y1, 5, 5);
        g2d.fillRect(x2, y2, 5, 5);
    }

    public void updateHead(int x, int y){
        this.x1 = x;
        this.y1 = y;

        this.x2 = x+Window.sprite_size;
        this.y2 = y;

    }

    public boolean checkIfHeadHit(){
        for(Platform plt : platformList){
            if(plt.checkIfInside(this.x1, this.y1)){
                return true;
            }

            if(plt.checkIfInside(this.x2, this.y2)){
                return true;
            }
        }
        return false;
    }
    
}
