import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.event.*; 

import javax.swing.JApplet;

/**
 * Models the color blob game as an applet
 * 
 * @author Matthew
 * @version 1.0
 * 
 */
public class Blob extends JApplet 
{

	private static final long serialVersionUID = 1L;
	public Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.PINK};
	public Color[][] grid = new Color[7][7];
	public Random ran = new Random();
	
	public void init()
	{
		for (int i = 0; i < 7; i++) 
		{
			for (int j = 0; j < 7; j++)
			{
				grid[i][j] = colors[ran.nextInt(4)];
			}
		}
		
		addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				
				if (x == 0 || y == 0 || x >= 50*7 || y >= 50*7)
				{
					showStatus("Invalid selection");
					return;
				}
				
				int row = e.getY()/50;
				int col = e.getX()/50;

				//Color temp = grid[row][col];
				//changeColor(grid[row][col], row, col);
				toggleColors(grid[row][col], row, col);
				showStatus("Valid selection: (" + row + ", " + col +")");
				repaint();
			}
		});
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		for (int i = 0; i < 7; i++) 
		{
			for (int j = 0; j < 7; j++)
			{
				g.setColor(grid[i][j]);
				g.fillRect(j*50, i*50, 50, 50);
				g.setColor(Color.BLACK);
				g.drawRect(j*50, i*50, 50, 50);
			}
		}
	}
	
	public void changeColor(Color color, int row, int col)
	{
		do
		{
			grid[row][col] = colors[ran.nextInt(5)];
		}
		while(grid[row][col].equals(color));
	}
	
	public void toggleColors(Color color, int row, int col)
	{
		if (row < 0 || col < 0 || row > 6 || col > 6)
		{
			return;
		}
		
		Color temp = null;
		
		if (!grid[row][col].equals(color))
		{
			return;
		}
		
		temp = grid[row][col];
		changeColor(grid[row][col], row, col);
		
		toggleColors(temp, row + 1, col);
		toggleColors(temp, row - 1, col);
		toggleColors(temp, row, col + 1);
		toggleColors(temp, row, col - 1);
	}
}