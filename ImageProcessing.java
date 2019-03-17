/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Keyboard.Input;
/**
 * @author 19galvino Image 32
 */
public class ImageProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // Step 1: Bringing all the files into the program // Step 1: Bringing all the files into the program // Step 1: Bringing all the files into the program //Step 1: Bringing all the files into the program
        int FLOOP = 0; //get FLOOP from txt file
        String FName = new String();
        Input cin = new Input();
        ArrayList <COMPARE> Inumbers = new ArrayList <COMPARE>();
        ArrayList <Integer> numbers = new ArrayList <Integer>();
        try
        {
            FileInputStream stream = new FileInputStream ("MLTracker.txt");
            InputStreamReader NUMReader = new InputStreamReader (stream);
            BufferedReader reader = new BufferedReader (NUMReader);
            FLOOP = Integer.parseInt (reader.readLine());
            int H;
            for (int i=0; i<FLOOP ; i++)
            {
                H = Integer.parseInt (reader.readLine());
                numbers.add(H);                
            }
            
        }
        catch (IOException e)
        {
            System.out.println ("Faliure in reading text file program");
        }
        
        for (int i=0; i<FLOOP; i++)
        {
            FName = "Image" + i + ".jpg";
            Inumbers.add(new COMPARE (FName));
        }
        // Step 2: Comparing all the images and determining the image with the most amount of matching (non-white) pixels // Step 2: Comparing all the images and determining the image with the most amount of matching (non-white) pixels

        int clr=0,red=0,green=0,blue=0;
        int IC[] = new int [FLOOP];
        for (int i=0; i<FLOOP; i++){IC[i]=0;}
        COMPARE guess = new COMPARE("Image" + FLOOP + ".jpg");
        for (int F =0; F<numbers.size(); F++)
        {
            for ( int i =0; i<80; i++)
                {
                    for (int j=0; j<100; j++)
                    {
                        if (guess.NWPixels(i,j)==true)
                        {
                            if (Inumbers.get(F).NWPixels(i,j)==true)
                            {
                                 IC[F]++;  
                            }
                        }
                    }
                }
        }
        int most=0;
        for (int i=0; i<numbers.size(); i++)
        {
            if (IC[most] < IC[i]){most = i;} //THIS WORKS
        }
        //
        guess.FileName();
        System.out.println ("I think that the number you drew was " + numbers.get(most));
        System.out.println ("Is this correct? (Y or N)");
        char response;
        int correct=0;
        response = cin.Readchar();
        if (response == 'Y')
        {
           System.out.println ("YAY");
           correct = numbers.get(most);
           numbers.add(correct);
           FLOOP++;
        }
        if (response == 'N')
        {
            System.out.println ("What was the correct answer?");
            correct = cin.Readint();
            numbers.add(correct);
            FLOOP++;
        }
      
        ////////////////////////////////////////////////////////////////////////
        try
        {
            FileOutputStream write = new FileOutputStream ("MLTracker.txt");
            PrintWriter printwriter = new PrintWriter (write, true);
            printwriter.println (FLOOP);
            for (int i=0; i<FLOOP; i++)
            {
                printwriter.println (numbers.get(i));
            }
            write.close();
        }
        catch(IOException Ee)
        {
            System.out.println ("Error in writing to file");
        }  
        //for (int i =0; i<FLOOP-1; i++ ) {System.out.println(i + " " + IC[i]);}
        
        
        
        
        
        
    }
}
