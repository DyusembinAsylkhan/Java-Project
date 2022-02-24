import javax.swing.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
public class Player {
    public static final int MAX_V = 50;
    public static final int MAX_TOP = -180;
    public static final int MAX_BOTTOM = 220;

    Image img = new ImageIcon("res/Images/Green_car.png").getImage();
    int v =0;
    int dv = 0;
    int s = 0;

    int x = -800;
    int y = 10;
    int dy = 0;

    int layer1 = 0;
    int layer2 = 850;

      public void move(){
        s+= v;
        v += dv;
        if(v <= 0 ){ v = 0; }
        if(v >= MAX_V ){ v = MAX_V; }

        y -= dy;
        if (y <= MAX_TOP){ y = MAX_TOP;}
        if (y >= MAX_BOTTOM){ y = MAX_BOTTOM;}

        if (layer2 - v <= 0) {
            layer1 = 0;
            layer2 = 850;
        }
        else {
            layer1 -= v;
            layer2 -= v;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT){
            dv = 1;
        }
        if (key == KeyEvent.VK_LEFT){
            dv = -1;
        }
        if (key == KeyEvent.VK_UP){
            dy = 6;
        }
        if (key == KeyEvent.VK_DOWN){
            dy = -6;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT){
            dv = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
            dy = 0;
        }
    }


}



