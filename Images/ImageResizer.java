import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
/**
 * This program demonstrates how to resize an image.
 *
 * @author www.codejava.net
 *
 */
public class ImageResizer {
 
    /**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        //inputImagePath = "Tile_Southeast.png";
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
        // writes to output file
        //outputImagePath = "./Assets/Tile_Southeast_Fixed.png";
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }
    
    /**
     * Test resizing images
     */
    public static void main(String[] args) {
        String sw = "./Tile_Southwest(1).png";
        String sw_o = "./Assets/Tile_Southwest_Fixed(1).png";
        
        String se = "./Tile_Southeast.png";
        String se_o = "./Assets/Tile_Southeast_Fixed.png";
 
        String ne = "./Tile_Northeast.png";
        String ne_o = "./Assets/Tile_Northeast_Fixed.png";
        
        String nw = "./Tile_Northwest.png";
        String nw_o = "./Assets/Tile_Northwest_Fixed.png";
        
        String we = "./Tile West East.png";
        String we_o = "./Assets/Tile West East_Fixed.png";
        
        String ns = "./Tile_North_South.png";
        String ns_o = "./Assets/Tile_North_South_Fixed.png";
        
        String start_n = "./Tile_Start_North.png";
        String start_n_o = "./Assets/Tile_Start_North_Fixed.png";
        
        String start_s = "./Tile_Start_South.png";
        String start_s_o = "./Assets/Tile_Start_South_Fixed.png";
        
        String start_e = "./Tile_Start_East.png";
        String start_e_o = "./Assets/Tile_Start_East_Fixed.png";
        
        String start_w = "./Tile_Start_West.png";
        String start_w_o = "./Assets/Tile_Start_West_Fixed.png";
        
        String end_n = "./Tile_End_North.png";
        String end_n_o = "./Assets/Tile_End_North_Fixed.png";
        
        String end_s = "./Tile_End_South.png";
        String end_s_o = "./Assets/Tile_End_South_Fixed.png";
        
        String end_e = "./Tile_End_East.png";
        String end_e_o = "./Assets/Tile_End_East_Fixed.png";
        
        String end_w = "./Tile_End_West.png";
        String end_w_o = "./Assets/Tile_End_West_Fixed.png";
        
        
        try {
            // resize to a fixed width
            int scaledWidth = 125;
            int scaledHeight = 125;
            
            ImageResizer.resize(sw, sw_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(se, se_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(nw, nw_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(ne, ne_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(we, we_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(ns, ns_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(start_n, start_n_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(start_s, start_s_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(start_w, start_w_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(start_e, start_e_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(end_n, end_n_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(end_s, end_s_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(end_w, end_w_o, scaledWidth, scaledHeight);
            
            ImageResizer.resize(end_e, end_e_o, scaledWidth, scaledHeight);
        } 
        catch (IOException ex) 
        {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
    }   
}