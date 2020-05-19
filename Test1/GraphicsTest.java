import java.awt.Color;
import java.awt.Graphics; 
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.event.*;

public class GraphicsTest extends JFrame implements KeyListener, MouseWheelListener, MouseListener
{
    int x = 0;
    int y = 0;
    int size = 100;
    int speed = 1;
    Color color = Color.BLACK;
    Color background = Color.WHITE;
    boolean leaveTrail = false;
    char shape = 'o';

    public GraphicsTest()
    {
        addKeyListener(this);
        addMouseListener(this);
        addMouseWheelListener(this);
        //setFocusable(true);
        //setFocusTraversalKeysEnabled(false);
    }

    public void moveRight()
    {
        x += 1;
        repaint();
    }

    public void moveLeft()
    {
        x -= 1;
        repaint();
    }

    public void moveUp()
    {
        y -= 1;
        repaint();
    }

    public void moveDown()
    {
        y += 1;
        repaint();
    }

    public void shrink()
    {
        size -= 10;
        repaint();
    }

    public void grow()
    {
        size += 10;
        repaint();
    }

    public void mouseClicked(MouseEvent e)
    {

    }

    public void mousePressed(MouseEvent e)
    {
        if (leaveTrail)
        {
            leaveTrail = false;
        }
        else
        {
            leaveTrail = true;
        }
        repaint();
    }

    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }

    public void mouseWheelMoved(MouseWheelEvent e)
    {
        if (e.getWheelRotation() > 0)
        {
            grow();
        }
        else if (e.getWheelRotation() < 0)
        {
            shrink();
        }
    }

    public void keyTyped(KeyEvent e)
    {
        //System.out.println(e.getKeyCode() + " typed!");
    }

    public void keyPressed(KeyEvent e)
    {
        //System.out.println(e.getKeyCode() + " pressed!");
        if(e.getKeyCode()== KeyEvent.VK_RIGHT || e.getKeyCode()== KeyEvent.VK_D)
        {
            moveRight();
        }
        else if(e.getKeyCode()== KeyEvent.VK_LEFT || e.getKeyCode()== KeyEvent.VK_A)
        {
            moveLeft();
        }
        else if(e.getKeyCode()== KeyEvent.VK_DOWN || e.getKeyCode()== KeyEvent.VK_S)
        {
            moveDown();
        }
        else if(e.getKeyCode()== KeyEvent.VK_UP || e.getKeyCode()== KeyEvent.VK_W)
        {
            moveUp();
        }
    }

    public void keyReleased(KeyEvent e)
    {
        // movement
        if(e.getKeyCode()== KeyEvent.VK_RIGHT || e.getKeyCode()== KeyEvent.VK_D)
        {
            moveRight();
        }
        else if(e.getKeyCode()== KeyEvent.VK_LEFT || e.getKeyCode()== KeyEvent.VK_A)
        {
            moveLeft();
        }
        else if(e.getKeyCode()== KeyEvent.VK_DOWN || e.getKeyCode()== KeyEvent.VK_S)
        {
            moveDown();
        }
        else if(e.getKeyCode()== KeyEvent.VK_UP || e.getKeyCode()== KeyEvent.VK_W)
        {
            moveUp();
        }

        //change color
        if (e.getKeyCode() == KeyEvent.VK_NUMPAD0)
        {
            color = Color.BLACK;
            repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1)
        {
            color = Color.BLUE;
            repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2)
        {
            color = Color.GREEN;
            repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_NUMPAD3)
        {
            color = Color.RED;
            repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_NUMPAD4)
        {
            java.util.Random ran = new java.util.Random();
            color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
            repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_NUMPAD5)
        {
            java.util.Random ran = new java.util.Random();
            background = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
            repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_NUMPAD6)
        {
            if (shape == 'o')
            {
                shape = 's';
            }
            else
            {
                shape = 'o';
            }
            repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_H)
        {
            String helpMessage = "Instructions: \nWASD or arrow keys to move\nChange Colors (numpad): 0 - black | 1 - blue | 2 - green | 3 - red | 4 - random";
            helpMessage += "\n 5 - random background | 6 - toggle shape\nClick to toggle trail, scroll to change size\n\n Type h to show instructions again";
            JOptionPane.showMessageDialog(null, helpMessage);
        }
    }

    public void paint(Graphics g)
    {
        if (!leaveTrail)
        {
            super.paint(g);
        }

        this.getContentPane().setBackground(background);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(color);

        if (shape == 'o')
        {
            g2.fillOval(x, y, size, size);
        }
        else if (shape == 's')
        {
            g2.fillRect(x, y, size, size);
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        //System.out.println("Instructions: \nWASD or arrow keys to move\nChange Colors (numpad): 0 - black | 1 - blue | 2 - green | 3 - red | 4 - random \n 5 - random background | 6 - toggle shape\nClick to toggle trail, scroll to change size");

        int height = Integer.parseInt(new String(JOptionPane.showInputDialog(null, "Enter Height",
                        "Input first number", JOptionPane.QUESTION_MESSAGE)));

        int width = Integer.parseInt(new String(JOptionPane.showInputDialog(null, "Enter Width",
                        "Input first number", JOptionPane.QUESTION_MESSAGE)));

        GraphicsTest frame = new GraphicsTest();
        frame.setTitle("Painter");
        frame.setSize(height, width);
        frame.setMinimumSize(new java.awt.Dimension(height, width));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        String helpMessage = "Instructions: \nWASD or arrow keys to move\nChange Colors (numpad): 0 - black | 1 - blue | 2 - green | 3 - red | 4 - random";
        helpMessage += "\n 5 - random background | 6 - toggle shape\nClick to toggle trail, scroll to change size\n\n Type h to show instructions again";
        JOptionPane.showMessageDialog(null, helpMessage);
    }
}