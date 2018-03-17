import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class MainClass extends Img_To_Mat
{
    public static void main(String[] args) throws Exception
    {
        int sw;
        int gct = 0;
        System.out.println("Enter 1 then 2");
        System.out.println("1.Image to Matrix");
        System.out.println("2.Matrix to Image");
        int w = 332, h = 300;
        MainClass ob=new MainClass();
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);//creating blank raster
        File f = new File("D:\\index.bmp");//getting image from source
        int[][] pix = ob.compute(f);
        int i, j, x;
        while (gct < 2)
        {
            sw = Integer.parseInt(in.readLine());
            switch (sw)
            {
                case 1: //calling method and printing rgb values of a txt file
                {
                    FileWriter fw = new FileWriter("D:\\testout.txt");//file in which array values are written
                    for (i = 0; i < w1; i++)
                    {
                        for (j = 0; j < h1; j++)
                        {
                            x = pix[i][j];
                            fw.write(x + System.getProperty("line.separator"));//printing line by line values of each array entry
                        }
                    }
                    fw.close();
                    System.out.println("1st Success...");
                    break;
                }

                case 2://to convert matrix to image
                {
                    BufferedReader br = new BufferedReader(new FileReader("D:\\example.txt"));//getting modified array entries to convert to image
                    String str;
                    int ct = 0, z;
                    List<String> list = new ArrayList<String>();//creating dynamic arraylist
                    while ((str = br.readLine()) != null)
                    {
                        list.add(str);//adding each value to list
                    }
                    String[] stringArr = list.toArray(new String[0]);
                    for (i = 0; i < w1; i++)
                    {
                        for (j = 0; j < h1; j++)
                        {
                            z = Integer.parseInt(stringArr[ct]);
                            img.setRGB(i, j, z);//setting rgb values onto empty raster
                            ct++;
                        }
                    }
                    br.close();

                    f = new File("D:\\img.bmp");//creating destination image
                    ImageIO.write(img, "bmp", f);//writing onto file

                    System.out.println("2nd Success...");
                    break;
                }
            }
            gct++;
        }

    }

}



