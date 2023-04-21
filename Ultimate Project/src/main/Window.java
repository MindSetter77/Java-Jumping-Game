package main;

import player.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Window extends JFrame implements KeyListener{
    public static int width = 1920;
    public static int height = 1080;
    public static int sprite_size = 64;

    GameScreen gameScreen;
    Player player;


    public Window(){
        this.gameScreen = new GameScreen(); 
        this.player = gameScreen.player;

        this.add(gameScreen);
        this.addKeyListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyChar()){
            case 'a':
                player.left = true;
                break;
            case 'd':
                player.right = true;
                break;
            case 'w':
                player.up = true;
                break;
            case 's':
                player.down = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyChar()){
            case 'a':
                player.left = false;
                break;
            case 'd':
                player.right = false;
                break;
            case 'w':
                player.up = false;
                break;
            case 's':
                player.down = false;
                break;
        }
    }
    
}
