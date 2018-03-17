import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.*;


import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class Img_To_Mat
{
    /*
     * basic logic :
     * 1.convert image to matrix
     * 2.left shift them parallely in c
     * 3.get back matrix and then reform image
     */
    static int w1,h1;
    @Initialized @Nullable public int[][] compute(File file)//convert image to matrix
    {
        try
        {
            BufferedImage img= ImageIO.read(file);//get image
            Raster raster=img.getData();
            int w=raster.getWidth(),h=raster.getHeight();//get image width and height
            w1=w;h1=h;
            int pixels[][]=new int[w][h];
            for (int x=0;x<w;x++)
            {
                for(int y=0;y<h;y++)
                {
                    pixels[x][y]=img.getRGB(x,y);//getting RGB values for every pixel
                }
            }
            return pixels;
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}


