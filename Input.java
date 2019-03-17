package Keyboard;
import java.io.*;
/**
 * Summary description for KeyboardInput.
 */
public class Input
{
     BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	public Input()
	{
		//
		// TODO: Add Constructor Logic here
		//
	}
	public String Readstring()
	{
		//return System.Console.ReadLine();
            String cin2 = new String("");
            try
            {
                    cin2 = cin.readLine();
            }
            catch (Throwable i){}
                    return cin2;
	}
	public char Readchar()
	{
		// if more than 1 character is entered it goes past the next input
		int num=0;
                try
                {
		num = cin.read();
		cin.readLine();
                }
                catch (Throwable i){}
		char let = (char)num;
		return let;
	}
	public int Readint()
	{

		// returns 0 if an invalid character is entered
		String hold= new String("");
		int powoften=1, theint=0, stop = 0;
		char ch;
		boolean neg = false;
                try
                {
		hold = cin.readLine();
                }
                catch (Throwable i){}
		int i = hold.length();
		if (hold.charAt(0)=='-')
		{
			neg=true;
			stop = 1;
		}
		for(int j=i-1;j>=stop;j--)
		{
			ch = hold.charAt(j);
			if ((ch <'0' || ch > '9' )&& ch!='-' )
				return 0;
			theint +=(((int)ch-48)*powoften);
				powoften*=10;
		}
			if (neg)
				theint *= -1;
		return theint;
	}
	public double Readdouble()
	{
		String hold = new String("");
		char ch;
		boolean neg = false;
		int stop = 0, wherepointis=-1;
		double powoften=1;
		double value=0;
                try
                {
		hold = cin.readLine();
                }
                catch (Throwable i){}
		int len = hold.length();
		
		if (hold.charAt(0)=='-')
		{
			neg=true;
		
			len--;
			//hold = hold.Substring(1,len);
                        hold = hold.substring(len);
		}
		while (hold.charAt(stop)!='.' && stop<len-1)
			stop++;
		if (hold.charAt(stop)!='.')
			stop++;
		wherepointis = stop;
		for(int i=wherepointis-1;i>=0;i--)
		{
			ch = hold.charAt(i);
			if (ch <'0' || ch > '9' )
				return 0;
			value +=(((int)ch-48)*powoften);
			powoften*=10;
		}
		if (wherepointis < len)
		{
			powoften = .1;
			for(int i=wherepointis+1;i<len;i++)
			{
				ch = hold.charAt(i);
				if (ch <'0' || ch > '9' )
					return 0;
				value +=(((int)ch-48)*powoften);
				powoften/=10;
			}
		}
		if (neg)
			value *= -1;
		return value;
	}

}
