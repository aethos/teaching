/**
* FrenchCountryNameTester.java
* Tests the FrenchCountryName class.
* @author Ethan Adams ea2678
* @version 9-29-16
*/

import java.util.Scanner;

public class FrenchCountryNameTester
{
	public static void main(String[] args)
	{
		// read in a country's name
		Scanner user = new Scanner(System.in);
		System.out.print("Enter a country's name in French: ");
		String countryName = user.next();

		// create country
		FrenchCountryName myCountry = new FrenchCountryName(countryName);

		FrenchCountryNameSolution solution = 
			new FrenchCountryNameSolution(countryName);

		// return the full name
		System.out.println("The full name of the country is: "
			 + myCountry.getFullName());

		// return the solution too
		System.out.println("The (solution's) full name of the country is: "
			 + solution.getFullName());
	}
}