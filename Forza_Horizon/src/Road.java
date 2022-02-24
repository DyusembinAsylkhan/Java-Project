import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Road extends JPanel implements ActionListener, Runnable {
    Timer mainTimer = new Timer(20, (ActionListener) this);

    Image img = new ImageIcon("res/Images/Rroad.png").getImage();

    Player p = new Player();

    Thread enemiesFactory = new Thread(this);

    List<Enemy> enemies = new ArrayList<Enemy>();



    public Road() {
        mainTimer.start();
        enemiesFactory.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    @Override
    public void run() {
        while(true){
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(2000));
                enemies.add(new Enemy(1200, rand.nextInt(220), rand.nextInt(60), this));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
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

        Iterator<Enemy> i = enemies.iterator();
        while(i.hasNext()){
              Enemy e = i.next();
              if (e.x >= 2300  || e.x <= -2300){
                  i.remove();
              }
              else {
                  e.move();
                  g.drawImage(e.img, e.x, e.y, null);
              }
        }

    }

    public void actionPerformed(ActionEvent e){
        p.move();
        repaint();
        testCollisionWithEnemies();

    }

    private void testCollisionWithEnemies() {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()){
            Enemy e = i.next();
            if(p.getRect().intersects(e.getRect())){
                JOptionPane.showMessageDialog(null, "You are dead!");
                System.exit(1);
            }
        }
    }
}
