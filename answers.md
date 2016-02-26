###R4.12:
	Explain the differences between 2, 2.0, '2', "2", and "2.0".

	2 is an int, 2.0 a double, '2' a character, "2" a string, and "2.0" also a string.


	What are the results of these comparisons?
		(true / false / Compiler Error / Runtime Error)

	(2 == 2.0)
	True. 
	2 is implicitly converted from an int to a double. Java can do this because (a) There's a definite way to go from an int to a double, and (b) because there is no loss of precision. Java will not make automatic conversions that lose precision, such as a double to an int. You must force these conversions by casting.


	(2 == "2")
	Compiler error.
	Java has no way to convert between an int and a string, and no way to compare between the two. 

	(String.valueOf('2') == "2")
	False. String.valueOf() converts the character '2' to a string, so this becomes a comparision between two strings. But two strings compared with == does not compare the contents of the strings but instead compares their references, 


	("2.0" == "2")
	False.
	Same issue as above, == does not mean lexigraphical equality (character by character).

	("2" == "2")
	False.
	Same issue as above.


	("2".equals("2"))
	True.
	Two strings are compared lexigraphically by using string1.equals(string2)


	(Integer.parseInt("2") == Integer.parseInt("2.0"))
	Runtime error.
	This is tricky. The reason this is a runtime error and not a compile-time error is because Java does not check the contents of the string "2.0" to ensure it is an int value. The method Integer.parseInt() is accepting a string, and since we are passing it a string, the compiler is happy. But when we actually try to run the program, at some point in that method there will be an issue because Java expected an integer value inside the string, where really there was a double value.

	('2' == 50)
	True.
	Also tricky. This has to do with the ASCII encoding of characters. Every character (in ASCII)is technically represented as a integer from 0 to 127, so for example 'a' is represented as 13. Java sees that the right side of the expression, 50, is an integer, so it will implicitly convert the character '2' to its ASCII value for the == comparison. 