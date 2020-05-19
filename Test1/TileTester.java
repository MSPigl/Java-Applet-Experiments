import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class TileTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TileTester extends JFrame
{
    Tile test = new Tile(100, 100, 200, 200);
    
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.BLACK);
        
        g2.draw(test);
        g2.fill(test);
    }
    
    public static void main(String[] args)
    {
        TileTester tesT= new TileTester();
        
        tesT.setSize(600, 600);
        tesT.setMinimumSize(new Dimension(600, 600));
        tesT.setResizable(false);
        tesT.pack();
        
        tesT.setVisible(true);
    }
}
