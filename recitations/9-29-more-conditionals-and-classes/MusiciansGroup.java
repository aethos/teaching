/**
* MusiciansGroup.java
* Class that takes a number of musicians and outputs 
* the corresponding group noun
* @author Narcisa Codreanu
*/

public class MusiciansGroup {

	int musicians;

	public MusiciansGroup(int number) {
		musicians = number;
	}

	public String getGroupNoun() {
		switch(musicians) {
			case 1: return "solo";
			case 2 : return "duet";
			case 3 : return "trio";
			case 4 : return "quartet";
			case 5 : return "quintet";
			case 6 : return "sextet";
			case 7 : return "septet";
			case 8 : return "octet";
			case 9 : return "nonet";
			default : return "group with no group noun :(";
		}
	}

	public void addMusicians(int newMembers) {
		musicians += newMembers;
	}
}
