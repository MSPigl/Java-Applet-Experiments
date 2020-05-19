import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

/**
 * Write a description of class RoutePainter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoutePainter extends JFrame
{
    public BufferedImage image;
    
    public RoutePainter()
    {
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("./board_resize.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        repaint();
    }
    
    public void paint(Graphics g)
    {
//         int[] x = {350, 382, 385, 417, 419, 452, 454, 486, 488, 521, 521, 488, 486, 454, 452, 419, 417, 385, 382, 350};
//         int[] y = {86, 86, 86, 86, 86, 86, 86, 86, 86, 86, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104};
//         
//         int[] x2 = {162, 192, 195, 223, 227, 254, 257, 283, 285, 311, 317, 291, 289, 263, 259, 232, 228, 199, 195, 166};
//         int[] y2 = {231, 216, 213, 194, 191, 169, 166, 140, 138, 107, 120, 151, 154, 181, 184, 207, 210, 228, 231, 246};
//         
          g.drawImage(image, 0, 20, null);
//         g.setColor(Color.BLUE);
//         g.fillPolygon(x, y, 20);
//         g.fillPolygon(x2, y2, 20);
    }
    
    public static void main(String[] args)
    {
        RoutePainter frame = new RoutePainter();
        
        frame.setTitle("Image Test");
        //frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setMinimumSize(new Dimension(1900, 1000));
        //frame.setMaximumSize(new Dimension(1000, 1000));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
