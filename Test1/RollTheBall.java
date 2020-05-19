import javax.swing.*; //JFrame stuffs
import java.awt.*;    //Graphics stuff
import java.awt.event.*; //Mouse listeners
import javax.swing.JOptionPane;
import java.io.*;

/**
 * Test mechanics for Roll the Ball
 * ********************************
 * ********************************
 * ********************************
 */
public class RollTheBall extends JFrame implements MouseListener
{
    private Point position = new Point(); //used in mouseClicked()

    Tile tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8;
    Tile tile9, tile10, tile11, tile12, tile13, tile14, tile15, tile16;

    Tile currentTile = null;

    Tile[][] zones = new Tile[4][4];

    public static void main(String[] args)
    {
        RollTheBall frame = new RollTheBall(); 

        frame.setTitle("Game Test");
        frame.setSize(700, 700);
        frame.setMinimumSize(new java.awt.Dimension(700, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Constructor
     */
    public RollTheBall()
    {
        addMouseListener(this);

        // first row
        tile1 = new Tile(100, 100, 225, 225);
        tile2 = new Tile(227, 100, 350, 225);
        tile3 = new Tile(354, 100, 479, 225);
        tile4 = new Tile(481, 100, 606, 225);

        // second row
        tile5 = new Tile(100, 227, 225, 350);
        tile6 = new Tile(227, 227, 352, 350);
        tile7 = new Tile(354, 227, 475, 350);
        tile8 = new Tile(481, 227, 606, 350);

        // third row
        tile9 = new Tile(100, 354, 225, 475);
        tile10 = new Tile(227, 354, 350, 475);
        tile11 = new Tile(354, 354, 475, 475);
        tile12 = new Tile(481, 354, 606, 475);

        // fourth row
        tile13 = new Tile(100, 481, 225, 606);
        tile14 = new Tile(227, 481, 352, 606);
        tile15 = new Tile(354, 481, 475, 606);
        tile16 = new Tile(481, 481, 606, 606);

        // fill array with Tile objects and assign tiles a location
        zones[0][0] = tile1;
        tile1.setLocation(0, 0);
        zones[0][1] = tile2;
        tile2.setLocation(0, 1);
        zones[0][2] = tile3;
        tile3.setLocation(0, 2);
        zones[0][3] = tile4;
        tile4.setLocation(0, 3);
        zones[1][0] = tile5;
        tile5.setLocation(1, 0);
        zones[1][1] = tile6;
        tile6.setLocation(1, 1);
        zones[1][2] = tile7;
        tile7.setLocation(1, 2);
        zones[1][3] = tile8;
        tile8.setLocation(1, 3);
        zones[2][0] = tile9;
        tile9.setLocation(2, 0);
        zones[2][1] = tile10;
        tile10.setLocation(2, 1);
        zones[2][2] = tile11;
        tile11.setLocation(2, 2);
        zones[2][3] = tile12;
        tile12.setLocation(2, 3);
        zones[3][0] = tile13;
        tile13.setLocation(3, 0);
        zones[3][1] = tile14;
        tile14.setLocation(3, 1);
        zones[3][2] = tile15;
        tile15.setLocation(3, 2);
        zones[3][3] = tile16;
        tile16.setLocation(3, 3);
    }

    public void paint(Graphics g)
    {
        g = (Graphics2D) g; //cast to Graphics2D

        this.getContentPane().setBackground(Color.BLACK); //background color of frame (I don't think this works)

        g.setColor(Color.WHITE);
        g.fillRect(100,100, 508, 508); //draw container for grid
        g.setColor(Color.BLACK);
        
        // draw the grid
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (zones[i][j].shaded)
                {
                    g.setColor(Color.GREEN);
                    g.fillRect(zones[i][j].lowX, zones[i][j].lowY, 125, 125);
                }
                else
                {
                    g.setColor(Color.BLACK);
                    g.drawRect(zones[i][j].lowX, zones[i][j].lowY, 125, 125);
                }
            }
        }

        if (currentTile != null)
        {
            g.setColor(Color.BLACK);
            g.fillRect(currentTile.lowX, currentTile.lowY, 125, 125);
        }
        reset();
    }

    /**
     * Resets all the tile colors
     */
    public void reset()
    {
        currentTile = null;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                zones[i][j].shaded = false;
            }
        }
    }

    /**
     * Checks if your click was in a specified range
     */
    public boolean checkRange(int lowX, int lowY, int highX, int highY)
    {
        if (position.x >= lowX && position.x <= highX)
        {
            if (position.y >= lowY && position.y <= highY)
            {
                return true; 
            }
        }

        return false;
    }

    public void mouseClicked(MouseEvent e)
    {
        // establish a Point
        position.x = e.getX();
        position.y = e.getY();

        // first row
        if (checkRange(tile1.lowX, tile1.lowY, tile1.highX, tile1.highY))
        {
            toggleShade(tile1);
            repaint();
        }
        else if (checkRange(tile2.lowX, tile2.lowY, tile2.highX, tile2.highY))
        {
            toggleShade(tile2);
            repaint();
        }
        else if (checkRange(tile3.lowX, tile3.lowY, tile3.highX, tile3.highY))
        {
            toggleShade(tile3);
            repaint();
        }
        else if (checkRange(tile4.lowX, tile4.lowY, tile4.highX, tile4.highY))
        {
            toggleShade(tile4);
            repaint();
        }
        // second row
        else if (checkRange(tile5.lowX, tile5.lowY, tile5.highX, tile5.highY))
        {
            toggleShade(tile5);
            repaint();
        }
        else if (checkRange(tile6.lowX, tile6.lowY, tile6.highX, tile6.highY))
        {
            toggleShade(tile6);
            repaint();
        }
        else if (checkRange(tile7.lowX, tile7.lowY, tile7.highX, tile7.highY))
        {
            toggleShade(tile7);
            repaint();
        }
        else if (checkRange(tile8.lowX, tile8.lowY, tile8.highX, tile8.highY))
        {
            toggleShade(tile8);
            repaint();
        }
        // third row
        else if (checkRange(tile9.lowX, tile9.lowY, tile9.highX, tile9.highY))
        {
            toggleShade(tile9);
            repaint();
        }
        else if (checkRange(tile10.lowX, tile10.lowY, tile10.highX, tile10.highY))
        {
            toggleShade(tile10);
            repaint();
        }
        else if (checkRange(tile11.lowX, tile11.lowY, tile11.highX, tile11.highY))
        {
            toggleShade(tile11);
            repaint();
        }
        else if (checkRange(tile12.lowX, tile12.lowY, tile12.highX, tile12.highY))
        {
            toggleShade(tile12);
            repaint();
        }
        // fourth row
        else if (checkRange(tile13.lowX, tile13.lowY, tile13.highX, tile13.highY))
        {
            toggleShade(tile13);
            repaint();
        }
        else if (checkRange(tile14.lowX, tile14.lowY, tile14.highX, tile14.highY))
        {
            toggleShade(tile14);
            repaint();
        }
        else if (checkRange(tile15.lowX, tile15.lowY, tile15.highX, tile15.highY))
        {
            toggleShade(tile15);
            repaint();
        }
        else if (checkRange(tile16.lowX, tile16.lowY, tile16.highX, tile16.highY))
        {
            toggleShade(tile16);
            repaint();
        }
        //JOptionPane.showMessageDialog(null, "X: " + position.x + " | Y: " + position.y);
    }

    // checks for valid moves
    public void toggleShade(Tile tile)
    {
        currentTile = tile;

        //if (tile.shaded)
        //{
        //    tile.shaded = false;
        //}
        //else
        //{
        //    tile.shaded = true;
        //}
        if (tile.row == 0)
        {
            if (tile.column != 0)
            {
                zones[tile.row][tile.column - 1].shaded = true;
            }
            if (tile.column != 3)
            {
                zones[tile.row][tile.column + 1].shaded = true;
            }
            zones[tile.row + 1][tile.column].shaded = true;
        }
        else if (tile.row == 3)
        {
            if (tile.column != 0)
            {
                zones[tile.row][tile.column - 1].shaded = true;
            }
            if (tile.column != 3)
            {
                zones[tile.row][tile.column + 1].shaded = true;
            }
            zones[tile.row - 1][tile.column].shaded = true;
        }
        else if (tile.column == 0)
        {
            if (tile.row != 0)
            {
                zones[tile.row - 1][tile.column].shaded = true;
            }
            if (tile.row != 3)
            {
                zones[tile.row + 1][tile.column].shaded = true;
            }
            zones[tile.row][tile.column + 1].shaded = true;
        }
        else if (tile.column == 3)
        {
            if (tile.row != 0)
            {
                zones[tile.row - 1][tile.column].shaded = true;
            }
            if (tile.row != 3)
            {
                zones[tile.row + 1][tile.column].shaded = true;
            }
            zones[tile.row][tile.column - 1].shaded = true;
        }
        else
        {
            zones[tile.row + 1][tile.column].shaded = true;
            zones[tile.row - 1][tile.column].shaded = true;
            zones[tile.row][tile.column + 1].shaded = true;
            zones[tile.row][tile.column - 1].shaded = true;
        }
        repaint();
    }

    public void mouseReleased(MouseEvent e){}

    public void mousePressed(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}
}