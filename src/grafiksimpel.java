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


        drawHouse(g, 200, 300);
        drawTree(g,100,200);
//        drawStev(g,200,100);
    }
//   temperärt som stev för en simpel person.
    private void drawStev(Graphics g, int x, int y) {

    }

    private void drawTree(Graphics g, int x, int y) {

        g.setColor(new Color(163, 121, 27));
        g.fillRect(13+x,17+y,7,13);

        g.setColor(Color.GREEN);
        g.fillOval(x,y,34,20);

    }

    private void drawHouse(Graphics g, int x, int y) {
        g.setColor(new Color(0xAA1111));
        g.fillRect(x,y-40,50,40);

        g.setColor(new Color(0x444444));
        int[] xcoords = {x-5,x+25,x+55};
        int[] ycoords = {y-40,y-65,y-40};
        g.fillPolygon(xcoords,ycoords,3);
    }

    public static void main(String[] args) {
        grafiksimpel rityta = new grafiksimpel();
    }
}
