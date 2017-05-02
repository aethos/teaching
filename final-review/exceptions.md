## Exceptions

### General:
	
	What is an exception?

	What does try/catch do?

	What does throw mean? When do you use it?

	What does throws mean? When do you use it?

	What is a Checked Exception? Can you give an example of one?

	What are Runtime Exceptions? Can you give an example of one?


What will happen when the snippet below is run?

	String s = "hotdogs";
	int x = Integer.parseInt(s);


What will be printed in this case?

	try
	{
		// open a file that doesn't exist
		File badFile = new File("nope.txt");
		Scanner input = new Scanner(badFile);
	}
	catch(Exception e)
	{
		System.out.println("Something broke...");
	}
	catch(FileNotFoundException e)
	{
		System.out.println("Wrong filename!");
	}
	