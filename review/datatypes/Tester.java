/**
Tester for datatypes
What works, and what doesn't?
*/

public class Tester
{
	public static void main(String[] args)
	{
		System.out.println(2 == 2.0);

		// this will fail compilation
		// System.out.println(2 == "2");

		System.out.println(String.valueOf('2') == "2");

		System.out.println("2.0" == "2");

		String first = "2";
		String second = "21";
		second = second.substring(0, 1);
		// now second is also "2"

		System.out.println(first == second);

		System.out.println("2".equals("2"));

		// this will fail at runtime
		// System.out.println((Integer.parseInt("2") == Integer.parseInt("2.0")));

		System.out.println('2' == 50);
	}
}