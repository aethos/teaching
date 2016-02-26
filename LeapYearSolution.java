import java.util.Scanner;

/**
Class to test if a year is a leap year.
Test cases:
	1995 -- Tests "not divisible by 4"
	2016 -- Tests "is divisible by 4, but not by 100 or 400"
	2100 -- Tests "is divisible by 4 and 100, but not 400"
	2400 -- Tests "is divisible by 4 and 100 and 400"
	Possible edge cases?
@Author Ethan Adams + 1004
@Version 1.0
*/
public class LeapYearSolution
{
	public static void main(String[] args)
	{
		Scanner user = new Scanner(System.in);

		System.out.print("Kindly enter a year: ");
		int year = user.nextInt();

		boolean isLeap = false;


		// Note, there are simpler ways to write this conditional.
		// This is just one way that's rather clear.
		if (year % 4 == 0) {
			// Divisible by 4
			if (year % 100 == 0) {
				// Divisible by 100
				if (year % 400 == 0) {
					// Divisible by 400
					isLeap = true;
				}
				else {
					// Not divisible by 400
					isLeap = false;
				}
			}
			else {
				// Not divisible by 100
				isLeap = true;
			}
		}
		else {
			// Not divisible by 4
			isLeap = false;
		}

		if (isLeap) {
			System.out.println("Hooray, it's a leap year!");
		}
		else {
			System.out.println("It's not a leap year you fool!");
		}
	}
}