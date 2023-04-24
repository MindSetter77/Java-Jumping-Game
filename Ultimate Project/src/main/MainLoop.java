package main;

import player.*;

public class MainLoop implements Runnable{
    GameScreen gameScreen;
    Player player;

    public MainLoop(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        this.player = gameScreen.player;
    }

    @Override
    public void run() {
        while(true){
            try{
                player.checkIfInAir();
                player.updateHeadHit();
                player.move();
                gameScreen.repaint();
                Thread.sleep(1000/144);
            } catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
