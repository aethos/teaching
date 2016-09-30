/**
* ScopeTester.java
* Tests the ScopeExample class.
* @author Ethan Adams ea2678
* @version 9-30-16
*/

import java.util.Scanner;

public class ScopeTester
{
	public static void main(String[] args)
	{
		Scanner user = new Scanner(System.in);
		System.out.println("Please enter three numbers: ");
		int first = user.nextInt();
		int second = user.nextInt();
		int third = user.nextInt();

		ScopeExample ex = new ScopeExample(first, second, third);

		System.out.println("First: " + ex.getFirst());
		System.out.println("Biggest: " + ex.getBiggest());
	}
}