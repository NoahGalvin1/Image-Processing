/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author 19galvino
 */
public class COMPARE {
    
    private int clr=0, red=0,blue=0,green=0;
    private boolean COMPARE[][] = new boolean [80][100];
    private String Filename = new String();
    public COMPARE  (String FName)
    {
        Filename = FName;
        BufferedImage image;
        try 
        {
        File file = new File(FName);
        image = ImageIO.read(file);
        }
        catch (IOException ee)
        {
            System.out.println ("File Error");
            image = null;
        }
        for ( int i =0; i<80; i++)
            {
                for (int j=0; j<100; j++)
                {
                    clr = image.getRGB (i,j);
                    red = (clr & 0x00ff0000) >> 16;
                    green = (clr & 0x0000ff00) >> 8;
                    blue = clr & 0x00000ff;
                    if (red <20 && green < 20 && blue < 20){COMPARE[i][j]=true;}
                }
            }
        
    }
    public boolean NWPixels (int a, int b)
    { 
        if (COMPARE[a][b]){return true;}
        else {return false;}
    }
    public void FileName ()
    {
        System.out.println (Filename);
    }
}
