/**
* MusiciansGroupTester.java
* Tester class for the Musicians Group class
* @author Narcisa Codreanu
*/

public class MusiciansGroupTester {

	public static void main(String[] args){

		MusiciansGroup myFirstGroup = new MusiciansGroup(4);
		System.out.println("My first group of musicians is a: " 
			+ myFirstGroup.getGroupNoun());

		MusiciansGroup mySecondGroup = new MusiciansGroup(5);
		System.out.println("My second group of musicians is a: " 
			+ mySecondGroup.getGroupNoun());
		// add more members
		mySecondGroup.addMusicians(2);
		System.out.println("My second group of musicians is now a: " 
			+ mySecondGroup.getGroupNoun());

		MusiciansGroup myThirdGroup = new MusiciansGroup(9);
		System.out.println("My third group of musicians is a: " 
			+ myThirdGroup.getGroupNoun());
		// add more members
		myThirdGroup.addMusicians(2);
		System.out.println("My third group of musicians is now a: " 
			+ myThirdGroup.getGroupNoun());
	}
}
