import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Road extends JPanel implements ActionListener {
    Timer mainTimer = new Timer(20, (ActionListener) this);
    Image img = new ImageIcon("res/Images/Rroad.png").getImage();
    Player p = new Player();

    public Road() {
        mainTimer.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g){
        g = (Graphics2D) g;
        g.drawImage(img, p.layer1,0, null);
        g.drawImage(img, p.layer2,0, null);
        g.drawImage(p.img, p.x, p.y, null);

    }

    public void actionPerformed(ActionEvent e){
        p.move();
        repaint();

    }
}
