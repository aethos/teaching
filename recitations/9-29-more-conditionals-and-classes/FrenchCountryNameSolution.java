/**
* FrenchCountryNameSolution.java
* Takes the name of a country in french and assigns the correct article.
* @author Ethan Adams ea2678
* @version 9-29-16
*/

public class FrenchCountryNameSolution
{
	private String country;


	/**
	* Constructor
	* Takes a french country name
	*/
	public FrenchCountryName(String c)
	{
		country = c;
	}

	/** 
	* Accessor (getter)
	* Returns the full name of the country with the correct article
	*/
	public String getFullName()
	{
		String lower = country.toLowerCase();
		String article = "";

		char lastChar = lower.charAt(lower.length() - 1);
		char firstChar = lower.charAt(0);


		if (lastChar == 'e')	// if feminine
		{
			article = "la";
		}
		else if (lastChar == 'a')	// if masculine
		{
			article = "le";
		}

		// if starts with a vowel
		if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' ||
			firstChar == 'o' || firstChar == 'u')
		{
			article = "l\'";
		}

		// special exceptions
		if (lower.equals("belize") || lower.equals("cambodge") ||
			lower.equals("mexique") || lower.equals("mozambique") ||
			lower.equals("zaire") || lower.equals("zimbabwe"))
		{
			article = "le";
		}

		// other sepecial exceptions
		if (lower.equals("etas-unis") || lower.equals("pays-bas"))
		{
			article = "les";
		}

		// return full country name with article
		return article + " "  + country;

	}
}