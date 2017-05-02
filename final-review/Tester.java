import java.util.Scanner;
import java.io.*;

public class Tester
{
	public static void main(String[] args)
	{
		try
		{
			// open a file that doesn't exist
			File badFile = new File("nope.txt");
			Scanner input = new Scanner(badFile);
		}
		catch(Exception e)
		{
			System.out.println("Something broke...");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Wrong filename!");
		}

	}
}