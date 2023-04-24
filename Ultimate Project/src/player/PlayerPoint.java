package player;

import java.awt.Color;
import java.awt.Graphics2D;

public class PlayerPoint {
    public int x;
    public int y;
    public PlayerPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void updatePlayerPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void drawPlayerPoint(Graphics2D g2d){
    
        g2d.setColor(Color.cyan);
        g2d.fillRect(this.x, this.y, 5, 5);

        
    }

    
}
