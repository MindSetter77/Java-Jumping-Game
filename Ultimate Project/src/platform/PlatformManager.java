package platform;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import main.Window;

public class PlatformManager {
    File file;
    public ArrayList<Platform> platformList;

    public PlatformManager(){
        this.platformList = new ArrayList<>();
        this.file = new File("src/platform/levels/level1.txt");
        readLevel();
        test();
    }

    public void readLevel(){
        try{
            int y = 0;

            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String[] str = scan.nextLine().split("\\|");
                createPlatformlevel(str, y);
                y+=Window.sprite_size;
            }
            scan.close();

        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void createPlatformlevel(String[] str, int y){
        int x = 0;
        for(String s : str){
            if(s.equals("1")){
                platformList.add(new Platform(x, y));
            }
            x+=Window.sprite_size;
        }
    }

    public void drawAllPlatforms(Graphics2D g2d){
        for(Platform plt : platformList){
            plt.paintPlatform(g2d);
        }
    }

    public void test(){
        for(Platform plt : platformList){
            plt.getXY();
        }
    }
}
