package player;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
    int x;
    int y;

    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;

    boolean walking;
    public Player(){
        this.x = 100;
        this.y = 100;

        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
    }

    

    public void drawPlayer(Graphics2D g2d){
        g2d.setColor(Color.blue);
        g2d.fillRect(x, y, 64, 128);
    }
    
}
