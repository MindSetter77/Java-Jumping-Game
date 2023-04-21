package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import platform.PlatformManager;
import player.*;

public class GameScreen extends JPanel {
    PlatformManager platformManager;
    Player player;

    public GameScreen(){
        this.platformManager = new PlatformManager();
        this.player = new Player(platformManager);


        // Main loop
        Runnable r = new MainLoop(this);
        Thread thread = new Thread(r);
        thread.start();
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        drawBackground(g2d);
        drawAllSprite(g2d);
        platformManager.drawAllPlatforms(g2d);
        player.drawPlayer(g2d);
    }

    public void drawBackground(Graphics2D g2d){
        g2d.setColor(Color.lightGray);
        g2d.fillRect(0,0,Window.width, Window.height);
    }

    public void drawAllSprite(Graphics2D g2d){
        
        int change = 0;

        g2d.setColor(Color.black);

        for(int i=0; i<Window.width/Window.sprite_size; i++){
            g2d.drawLine(change,0,change,Window.height);
            change+=Window.sprite_size;
        }

        change = 0;

        for(int i=0; i<(Window.height/Window.sprite_size)+1;i++){
            g2d.drawLine(0,change,Window.width,change);
            change+=Window.sprite_size;
        }
    }

    
    
}
