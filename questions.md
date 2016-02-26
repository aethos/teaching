###R4.12:
	Explain the differences between 2, 2.0, '2', "2", and "2.0".
	What are the results of these comparisons?
		(true / false / Compiler Error / Runtime Error)

	(2 == 2.0) 						
	(2 == "2")						
	(String.valueOf('2') == "2") 	
	("2.0" == "2") 					
	("2" == "2") 					
	("2".equals("2"))				
	(Integer.parseInt("2") == Integer.parseInt("2.0")) 
	('2' == 50)						

###E4.23:
	Implement a class Balloon with these methods:
		add some amount of air
		get the volume of the balloon
		get the surface area of the balloon
		get the radius of the baloon
	Write a tester for your class.


###Leap Year:
	Write a class to test if a year is a leap year.
	Accept a year as input.

	Leap years are years that are divisible by 4 and not by 100. 
	But, if a year is also divisible by 400, then it is a leap year.

	Come up with a set of test cases for this input.