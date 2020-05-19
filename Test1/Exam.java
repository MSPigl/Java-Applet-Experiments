import java.awt.*;
import javax.swing.JApplet;
import javax.swing.*;
import java.awt.event.*;

public class Exam extends JApplet
{
    public boolean[][] marks;
    
    Polygon[] gons = new Polygon[25];
    public void init()
    {
        marks = new boolean[5][5];
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e)
            {
                int x = e.getX()/50;
                int y = e.getY()/50;
                
                if (x < 0 || x >= 50*5 || y < 0 || y >= 50*5)
                {
                    showStatus("Bad choice");
                    return;
                }
                
                //int row = y/50;
                //int col = x/50;
                showStatus(y + ", " + x);
                //showStatus("Good pick");
                marks[y][x] = true;
                
                repaint();
            }
        });
        
        
    }
    
    public boolean valid(int r1, int r2, int c1, int c2)
    {
        return r1 == r2 || c1 == c2 || Math.abs(r1 - r2) == Math.abs(c1 - c2);
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (marks[i][j] == true)
                {
                    showStatus("Good pick");
                    g.setColor(Color.GREEN);
                    g.fillRect(j*50, i*50,50,50);
                }
                else
                {
                    g.setColor(Color.BLACK);
                    g.drawRect(j*50, i*50,50,50);
                }
            }
        }
    }
}
