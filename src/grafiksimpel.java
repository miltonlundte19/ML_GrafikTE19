import javax.swing.*;
import java.awt.*;

public class grafiksimpel extends Canvas {
    public grafiksimpel() {
        JFrame frame = new JFrame("A simple painting");
        this.setSize(600,600);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {

    }
    public static void main(String[] args) {
        grafiksimpel rityta = new grafiksimpel();
    }
}
