import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

/**
 * Write a description of class ImageDrawer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageDrawer extends JFrame
{
    private BufferedImage image;
    
    public ImageDrawer()
    {
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("./Tile_Southwest_Fixed.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        repaint();
    }
    
    public void paint (Graphics g)
    {
        g.drawImage(image, 0, 20, null);
        g.drawImage(image, 127, 20, null);
        g.drawImage(image, 254, 20, null);
        g.drawImage(image, 381, 20, null);
        g.drawImage(image, 0, 147, null);
        g.drawImage(image, 127, 147, null);
        g.drawImage(image, 254, 147, null);
        g.drawImage(image, 381, 147, null);
        g.drawImage(image, 0, 274, null);
        g.drawImage(image, 127, 274, null);
        g.drawImage(image, 254, 274, null);
        g.drawImage(image, 381, 274, null);
        g.drawImage(image, 0, 401, null);
        g.drawImage(image, 127, 401, null);
        g.drawImage(image, 254, 401, null);
        g.drawImage(image, 381, 401, null);
    }
    
    public static void main(String[] args)
    {
        ImageDrawer frame = new ImageDrawer();
        
        frame.setTitle("Image Test");
        frame.setPreferredSize(new Dimension(508, 530));
        frame.setMinimumSize(new Dimension(508, 530));
        frame.setMaximumSize(new Dimension(508, 530));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}