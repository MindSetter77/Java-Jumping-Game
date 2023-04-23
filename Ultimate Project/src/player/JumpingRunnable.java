package player;

public class JumpingRunnable implements Runnable{

    Player player;
    int frame;
    double ys;

    public JumpingRunnable(Player player){
        this.player = player;
        this.frame = 0;
        this.ys = 0;
    }

    @Override
    public void run() {
        while (true){
            try{
                if(frame==0){
                    player.yspeed -= 7;
                } else if(frame >0 && frame <49) {
                    player.yspeed *= 0.98;
                    if(player.yspeed>1) player.yspeed=0;
                }else if(frame == 50){
                    player.yspeed = 0;
                    player.jumping = false;
                    player.jumpingFlag = false;
                    System.out.println("exit");
                    return;
                }
                

                
                frame++;
                Thread.sleep(1000/144);
            } catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
    
}
