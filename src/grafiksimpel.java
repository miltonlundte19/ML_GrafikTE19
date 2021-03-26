import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class grafiksimpel extends Canvas {

    private int widthe = 600;
    private int height = 600;

    private Thread thread;
    int fps = 30;
    private boolean isrunning;

    private BufferStrategy bs;

    private int houseX, houseY, houseVX, houseVY;

    private int treeX, treeY, treeVX, treeVY;

    public grafiksimpel() {
        JFrame frame = new JFrame("A simple painting");
        this.setSize(widthe,height);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        isrunning = false;
    }
    public void update() {
        
    }
    public void draw() {
        bs =getBufferStrategy();
        if (bs ==null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        drawHouse(g, 200, 300);
        drawTree(g,100,200);
//        drawStev(g,200,100);

        g.dispose();
        bs.show();
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
        g.fillRect(x+4,y-35,15,35);
        g.drawRect(x+25,y-30,20,20);

        g.setColor(new Color(0xFFA3DCFA));
        g.fillRect(x+26,y-29,18,18);
    }

    public static void main(String[] args) {
        grafiksimpel rityta = new grafiksimpel();
        rityta.start();
    }

    public synchronized void start() {
        thread = new Thread(this);
        isrunning = true;
        thread.start();
    }

    public synchronized void stop() {
        isrunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        double deltaT = 1000.0/fps;
        long lastTime = System.currentTimeMillis();

        while (isrunning) {
            long now = System.currentTimeMillis();
            if (now-lastTime > deltaT) {
                update();
                draw();
                lastTime = now;
            }

        }
        stop();
    }

}
