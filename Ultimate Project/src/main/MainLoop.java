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
                player.move();
                //System.out.println(player.inAir+"   Flags: "+player.up+" "+player.jumping+" "+player.jumpingFlag);
                //System.out.println(Thread.activeCount());
                gameScreen.repaint();
                Thread.sleep(1000/144);
            } catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
