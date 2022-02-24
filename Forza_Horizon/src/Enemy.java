import java.awt.*;
import javax.swing.ImageIcon;

public class Enemy {
    Image img = new ImageIcon("res/Images/Enemy_car.png").getImage();
    int x;
    int y;
    int v;
    Road road;

    public Rectangle getRect(){
        return new Rectangle(x, y, 170, 100);

    }

    public Enemy(int x, int y, int v, Road road){
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void move(){
        x = x - road.p.v + v;
    }

}
