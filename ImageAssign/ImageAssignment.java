import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

public class ImageAssignment {

    /* First, some utility methods that you will need in the methods you write.
       Do not modify these methods in any way. */

    public static int getRed(int rgb) { return (rgb >> 16) & 0xff; }
    public static int getGreen(int rgb) { return (rgb >> 8) & 0xff; }
    public static int getBlue(int rgb) { return rgb & 0xff; }
    public static int rgbColour(int r, int g, int b) {
        return (r << 16) | (g << 8) | b;
    }
    public static double brightness(int rgb) {
        int r = getRed(rgb);
        int g = getGreen(rgb);
        int b = getBlue(rgb);
        return 0.21*r + 0.72*g + 0.07*b;
    }

    public static BufferedImage convertToGrayscale(BufferedImage img) {
        BufferedImage result = new BufferedImage(
                img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB
            );
        for(int x = 0; x < img.getWidth(); x++) {
            for(int y = 0; y < img.getHeight(); y++) {
                int col = img.getRGB(x, y);
                int gr = (int)brightness(col);
                result.setRGB(x, y, rgbColour(gr, gr, gr));
            }
        }
        return result;
    }

    /* ----------- Methods that you will write in this assignment. */

    public static BufferedImage thresholdImage(BufferedImage img, int threshold) {
            BufferedImage result = new BufferedImage(
                img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB
            );
        
        for(int x = 0; x < img.getWidth(); x++) {
            for(int y = 0; y < img.getHeight(); y++) {
                int col = img.getRGB(x, y);
                int gr = (int)brightness(col);
                
                if(gr <= threshold)
                result.setRGB(x, y, rgbColour(0, 0, 0));
            
                else
                result.setRGB(x, y, rgbColour(255, 255, 255));
            }
        }
        return result;
    
    }
    
    public static BufferedImage horizontalMirror(BufferedImage img) {
      
       BufferedImage result = new BufferedImage(
                img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB
            );
        
        for(int x = 0; x < img.getWidth(); x++) {
            for(int y = 0; y < img.getHeight(); y++) {
               
                     int col = img.getRGB(x, y);
                     int r = getRed(col);
                     int g = getGreen(col);
                     int b = getBlue(col);
                
                result.setRGB((img.getWidth()-1) - x, y, rgbColour(r, g, b));
            
                
            }
        }
        return result;
    
  
    }

    public static BufferedImage splitToFour(BufferedImage img) {
       
       BufferedImage result = new BufferedImage(
                img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB
            );
        
        for(int x = 0; x < img.getWidth(); x = x + 2) {
            for(int y = 0; y < img.getHeight(); y = y + 2 ) {
               
                     int col = img.getRGB(x, y);
                     int r = getRed(col);
                     int g = getGreen(col);
                     int b = getBlue(col);
                
                  result.setRGB( (int)(x/2), (int)(y/2), rgbColour(r, g, b));
                  result.setRGB( (int)(x/2) + (int)((img.getWidth()-1)/2), (int)(y/2), rgbColour(r, g, b));
                  result.setRGB( (int)(x/2) + (int)((img.getWidth()-1)/2), (int)(y/2) + (int)((img.getHeight()-1)/2), rgbColour(r, g, b));
                  result.setRGB( (int)(x/2), (int)(y/2) + (int)((img.getHeight()-1)/2), rgbColour(r, g, b));
                
            }
        }
        return result;
    
  
    
    }

    public static BufferedImage imageCorrelation(BufferedImage img, double[][] mask) {
      
        
    
    BufferedImage result = new BufferedImage(
                img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB
            );
        
       int r;
       int g;
       int b;
        for(int x = 1; x < img.getWidth()-1; x++) {
            for(int y = 1; y < img.getHeight()-1; y++) {
                
                     
                     
/*
                     r = getRed( img.getRGB(x-1, y-1) )*-1 + getRed(img.getRGB(x, y-1))*-1 + getRed(img.getRGB(x+1, y-1))*-1 +
                                                     
                             getRed( img.getRGB(x-1, y) )*-1  + getRed(img.getRGB(x, y))*8   + getRed(img.getRGB(x+1, y))*-1 +

                             getRed( img.getRGB(x-1, y+1) )*-1   + getRed(img.getRGB(x, y+1))*-1   + getRed(img.getRGB(x+1, y+1))*-1 ;

                             if(r<0) r=0;
                             if(r>255) r=255;

                    

                   

                
                      g = getGreen( img.getRGB(x-1, y-1) )*-1 + getGreen(img.getRGB(x, y-1))*-1 + getGreen(img.getRGB(x+1, y-1))*-1 +
                                                     
                             getGreen( img.getRGB(x-1, y) )*-1   + getGreen(img.getRGB(x, y))*8    + getGreen(img.getRGB(x+1, y))*-1 +

                             getGreen( img.getRGB(x-1, y+1) )*-1   + getGreen(img.getRGB(x, y+1))*-1    + getGreen(img.getRGB(x+1, y+1))*-1 ;

                             if(g<0) g=0;
                             if(g>255) g=255;
                    
                      
                      b = getBlue( img.getRGB(x-1, y-1) )*-1 + getBlue(img.getRGB(x, y-1))*-1 + getBlue(img.getRGB(x+1, y-1))*-1 +
                                                     
                             getBlue( img.getRGB(x-1, y) )*-1   + getBlue(img.getRGB(x, y))*8    + getBlue(img.getRGB(x+1, y))*-1 +

                             getBlue( img.getRGB(x-1, y+1) )*-1   + getBlue(img.getRGB(x, y+1))*-1    + getBlue(img.getRGB(x+1, y+1))*-1 ;

                             if(b<0) b=0;
                             if(b>255) b=255;
 */               
                   

                    r = (int)(getRed( img.getRGB(x-1, y-1) )*mask[0][0] + getRed(img.getRGB(x, y-1))*mask[0][1] + getRed(img.getRGB(x+1, y-1))*mask[0][2] +
                                                     
                             getRed( img.getRGB(x-1, y) )*mask[1][0]   + getRed(img.getRGB(x, y))*mask[1][1]    + getRed(img.getRGB(x+1, y))*mask[1][2] +

                             getRed( img.getRGB(x-1, y+1) )*mask[2][0]   + getRed(img.getRGB(x, y+1))*mask[2][1]    + getRed(img.getRGB(x+1, y+1))*mask[2][2]) ;

                             if(r<0) r=0;
                             if(r>255) r=255;


                                     g = (int)(getGreen( img.getRGB(x-1, y-1) )*mask[0][0] + getGreen(img.getRGB(x, y-1))*mask[0][1] + getGreen(img.getRGB(x+1, y-1))*mask[0][2] +
                                                     
                             getGreen( img.getRGB(x-1, y) )*mask[1][0]   + getGreen(img.getRGB(x, y))*mask[1][1]    + getGreen(img.getRGB(x+1, y))*mask[1][2] +

                             getGreen( img.getRGB(x-1, y+1) )*mask[2][0]   + getGreen(img.getRGB(x, y+1))*mask[2][1]    + getGreen(img.getRGB(x+1, y+1))*mask[2][2]) ;

                             if(g<0) g=0;
                             if(g>255) g=255;

                                     b = (int)(getBlue( img.getRGB(x-1, y-1) )*mask[0][0] + getBlue(img.getRGB(x, y-1))*mask[0][1] + getBlue(img.getRGB(x+1, y-1))*mask[0][2] +
                                                     
                             getBlue( img.getRGB(x-1, y) )*mask[1][0]   + getBlue(img.getRGB(x, y))*mask[1][1]    + getBlue(img.getRGB(x+1, y))*mask[1][2] +

                             getBlue( img.getRGB(x-1, y+1) )*mask[2][0]   + getBlue(img.getRGB(x, y+1))*mask[2][1]    + getBlue(img.getRGB(x+1, y+1))*mask[2][2]) ;

                             if(b<0) b=0;
                             if(b>255) b=255;
               
        
                
                result.setRGB(x, y, rgbColour(r, g, b));
            }
        }
        return result;
    

    

    }
    
    public static BufferedImage rowPixelSort(BufferedImage img, int n) {
       
            BufferedImage result = new BufferedImage(
                img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB
            );
        
int[] row;
row = new int[img.getWidth()];
int x = 0;
int y = 0;

for(y = 0; y < img.getHeight(); y++) {


for(x = 0; x < img.getWidth(); x++) {
row[x] = img.getRGB(x, y);
}


int j;
     boolean flag = true;   
     int temp;  
     while ( flag )
     {
            flag= false;    
            for( j=0;  j < row.length -1;  j++ )
            {
                   if ( brightness( row[ j ]) > brightness(row[j+1] ) )  
                   {
                           temp = row[ j ];               
                           row[ j ] = row[ j+1 ];
                           row[ j+1 ] = temp;
                          flag = true;               
                  } 
            } 
      } 


for(x = 0; x < img.getWidth(); x++) {

 result.setRGB(x, y, rgbColour( getRed( row[x] ), getGreen( row[x]), getBlue(row[x]) ) );

}



}




        return result;
    
    
    }
    // ------------------------------------ end of your code

    /* A utility method we need to convert Image objects to BufferedImage, copied from 
     * http://stackoverflow.com/questions/13605248/java-converting-image-to-bufferedimage
     */
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) { return (BufferedImage) img;}
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB
            );
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        // Return the buffered image
        return bimage;
    }

    /* A utility method to create a JPanel instance that displays the given Image. */
    public static JPanel createPanel(Image img) {
        // Define a local class from which we create an object to return as result.
        class ImagePanel extends JPanel {
            private Image img;
            public ImagePanel(Image img) {
                this.img = img;
                this.setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            }

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this);
            }
        }
        return new ImagePanel(img);
    }

    /* The main method to try out the whole shebang. */
    public static void main(String[] args) {
        Image img = Toolkit.getDefaultToolkit().getImage("ryerson1.jpg");
        MediaTracker m = new MediaTracker(new JPanel());
        m.addImage(img, 0);
        try { m.waitForAll(); } catch(InterruptedException e) { }
        BufferedImage bimg = toBufferedImage(img); 
        JFrame f = new JFrame("CCPS 109 Lab 7");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new GridLayout(2, 3));
        f.add(createPanel(thresholdImage(bimg, 150)));
        f.add(createPanel(horizontalMirror(bimg)));
        f.add(createPanel(splitToFour(bimg)));
        double wt = 1.0/9;
        double[][] blur = {{wt,wt,wt},{wt,wt,wt},{wt,wt,wt}};
        f.add(createPanel(imageCorrelation(bimg, blur)));
        double[][] edged ={{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
        f.add(createPanel(imageCorrelation(convertToGrayscale(bimg), edged)));
        double [][] sharpen = {{0,-1,0},{-1,5,-1},{0,-1,0}};
        f.add(createPanel(imageCorrelation(bimg, sharpen)));
        f.add(createPanel(rowPixelSort(bimg, bimg.getWidth())));
        f.pack();
        f.setVisible(true); 
    }
}
