package platform;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Window;

public class Platform {
    int x;
    int y;
    public Platform(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void paintPlatform(Graphics2D g2d){
        g2d.setColor(Color.red);
        g2d.drawRect(x, y, Window.sprite_size, Window.sprite_size);
    }

    public void getXY(){
        System.out.println(x+" "+y);
    }
    
}
