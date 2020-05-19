import java.awt.*;

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Rectangle
{
    public int lowX, highX;
    public int lowY, highY;
    public Color color;
    public boolean shaded;
    public int row, column;
    
    public Tile(int lowX, int lowY, int highX, int highY)
    {
        this.lowX = lowX;
        this.lowY = lowY;
        this.highX = highX;
        this.highY = highY;
        
        color = Color.BLACK;
        
        shaded = false;
        row = column = 0;
    }
    
    public void setLocation(int i, int j)
    {
        row = i;
        column = j;
    }
}