import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JApplet;

public class Drawing extends JFrame
{
    //private static final long serialVersionUID = -3969699899491077333L;
    
    public static void main(String[] args)
    {
        Drawing frame = new Drawing();
        
        frame.setMinimumSize(new Dimension(400, 400));
        frame.pack();
        frame.setVisible(true);
    }
    
    public ArrayList<Integer> Xs, Ys;
    public ArrayList<Point> points;
    
    public Polygon poly;
    public boolean drawable = false;
    public Drawing()
    {
        Xs = new ArrayList<>();
        Ys = new ArrayList<>();
        points = new ArrayList<>();
        
        addMouseListener(new MouseAdapter(){
            
            @Override
            public void mousePressed(MouseEvent e)
            {
                if (e.getButton() == MouseEvent.BUTTON1)
                {
                    if (e.getClickCount() == 2)
                    {
                        points.add(new Point(e.getX(), e.getY()));
                        Xs.add(e.getX());
                        Ys.add(e.getY());
                        //showStatus("Point added at (" + e.getX() + ", " + e.getY() + ")");
                    }
                }
                else if (e.getButton() == MouseEvent.BUTTON3)
                {
                    int[] x = new int[Xs.size()];
                    for (int i = 0; i < x.length; i++)
                    {
                        x[i] = Xs.get(i);
                    }
                    
                    int[] y = new int[Ys.size()];
                    for (int i = 0; i < y.length; i++)
                    {
                        y[i] = Ys.get(i);
                    }
                    
                    poly = new Polygon(x, y, x.length);
                    drawable = true;
                    
                    points.clear();
                    Xs.clear();
                    Ys.clear();
                    
                    //showStatus("Drawing Polygon");
                }
                
                repaint();
            }
        });
        
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.RED);
        
        for (Point p: points)
        {
            g.fillOval(p.x, p.y, 5, 5);
        }
        
        if (drawable)
        {
            //super.paint(g);
            g.fillPolygon(poly);
            drawable = false;
        }
    }
}
