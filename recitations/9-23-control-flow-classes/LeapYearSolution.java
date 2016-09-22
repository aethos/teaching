import java.util.Scanner;

/**
Class to test if a year is a leap year.
Test cases:
	1995 -- Tests "not divisible by 4"
	2016 -- Tests "is divisible by 4, but not by 100 or 400"
	2100 -- Tests "is divisible by 4 and 100, but not 400"
	2400 -- Tests "is divisible by 4 and 100 and 400"
	Possible edge cases?
@Author Ethan Adams
@Version 1.1
*/
public class LeapYearSolution
{
	public static void main(String[] args)
	{
		// Accept user input
		Scanner user = new Scanner(System.in);
		System.out.print("Kindly enter a year: ");
		int year = user.nextInt();

		// require a positive year
		while (year < 0) {
			System.out.print("A non-negative year, please? ");
			year = user.nextInt();
		}

		boolean isLeap = false;

		// Note, there are simpler ways to write this conditional.
		// This is just one way that's rather clear.
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					isLeap = true; // divisible by 4, 100, and 400
				}
				else {
					isLeap = false;
				}
			}
			else {
				isLeap = true; // divisible by 4 but not by 100
			}
		}
		else {
			isLeap = false;
		}

		// print result
		if (isLeap) {
			System.out.println("Hooray, it's a leap year!");
		}
		else {
			System.out.println("It's not a leap year you goober!");
		}
	}
}