import java.util.Scanner;
public class HasErrors
{
	public static void main(String[] args)
	{
		int x = 0;
		int y = 0;
		Scanner in = new Scanner("System.in");
		x = in.readInt();
		System.out.println("Please enter another integer: ");
		x = in.readInt();
		System.out.println("The Sum is " + x + y);
	}
}
