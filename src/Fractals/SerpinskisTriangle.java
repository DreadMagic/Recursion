package Fractals;

import javax.swing.*;
import java.awt.*;

public class SerpinskisTriangle extends JPanel
{
    private int levels;
    public SerpinskisTriangle(int lev)
    {
        levels = lev;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // Call JPanel's paintComponent method
        //   to paint the background
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;


        int [] xcoord = {xCenter - 128, xCenter+128, xCenter};
        int [] ycoord = {yCenter+128, yCenter + 128, yCenter - 100};

        g.setColor(Color.red);

        drawAndSplit(g, xcoord, ycoord, levels);

    }

    public int [] midpoints(int [] x)
    {
        int [] m = new int [3];

        m[0] = (x[0] + x[1])/2;
        m[1] = (x[1] + x[2])/2;
        m[2] = (x[2] + x[0])/2;


        return m;
    }

    public void drawAndSplit(Graphics g, int [] x, int [] y, int times)
    {
        if (times == 1){
            g.setColor(Color.red);
            g.fillPolygon(x,y,3);
            return;
        }

        int [] xmids = midpoints(x);
        int [] ymids = midpoints(y);
        drawAndSplit(g, new int[] {x[0], xmids[0],xmids[2]}, new int[] {ymids[0], y[0], ymids[2]},times-1);
        drawAndSplit(g, new int[] {xmids[0], x[1],xmids[1]}, new int[] {ymids[0], y[0], ymids[2]},times-1);
        drawAndSplit(g, new int[] {xmids[2], x[2],xmids[1]}, new int[] {ymids[2], y[2], ymids[2]},times-1);

    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fractals.SerpinskisTriangle panel = new Fractals.SerpinskisTriangle(2);
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}