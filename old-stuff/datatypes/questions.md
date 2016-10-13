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