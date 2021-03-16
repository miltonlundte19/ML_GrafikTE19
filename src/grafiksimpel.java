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


        drawHouse(g, 100, 200);
        drawTree(g,100,200);
        drawStev(g,200,100);
    }
//   temperärt som stev för en simpel person.
    private void drawStev(Graphics g, int x, int y) {

    }

    private void drawTree(Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        g.fillOval();
    }

    private void drawHouse(Graphics g, int x, int y) {

    }

    public static void main(String[] args) {
        grafiksimpel rityta = new grafiksimpel();
    }
}
