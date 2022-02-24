import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("Java_Game"); //JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit
        f.setSize(1200,768);
        f.add(new Road());
        f.setVisible(true);

    }
}
