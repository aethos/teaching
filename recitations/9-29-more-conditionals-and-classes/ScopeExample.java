/**
* ScopeExample.java
* Displays how scope works
* @author Ethan Adams ea2678
* @version 9-30-16
*/

public class ScopeExample
{
	private int one;
	private int two;
	private int three;

	public ScopeExample(int a, int b, int c)
	{
		one = a;
		two = b;
		three = c;
	}

	public int getFirst()
	{
		return one;
	}

	public int getBiggest()
	{
		if (one > two && two > three)
		{
			return one;
		}
		else if (two > three)
		{
			return two;
		}
		else
		{
			return three;
		}
	}
}