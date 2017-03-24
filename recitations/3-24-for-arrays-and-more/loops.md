# For Loops

## Outline:
- Review of While
- For
- Enhanced For
- Altogether and Patterns

## Signposting:
- What is a while loop?
- What is a for loop? How is a for loop like a while loop?
- What is an enhanced for loop? What is "enhanced" about it?
- In what situations should you use each kind of loop?


### Review of While
A while loop is the simplest kind of loop. It consists of a **termination condition** and a **body** of statements. The statements in the body will be executed until the termination condition is false. For example:

	int i = 0;
	while (i < 5) {
		i = i + 2;
	}

The termination condition is `i < 5`. The body consists of the single statement `i = i + 2;`. This loop will run and i will take on the values 0, 2, 4, 6, at which point the termination condition is false, and the loop will end. Let's look at another example.

	Scanner user = new Scanner(System.in);
	System.out.println("Enter an int, -1 to stop.");
	int number = 0;
	int sum = 0;

	while (number != -1) {
		System.out.println("Thanks!");
		number = user.nextInt();
		sum += number;
	}

	System.out.println(sum);

The intention of the code above is to take in ints one by one from the user, and add them together. When the user inputs `-1`, the loop should stop and output the sum. However, we've got a bug! If you try running the above code, you'll see that we don't get the sum we should get. If you put in `3, 2, 1, -1`, then you'll get a sum of 5. This is because we're adding the `-1` to the sum! Even though `number` will take on the value `-1`, the loop will not stop. Remember, the termination condition (also called a loop condition) is _only checked at the end of the body of statements, and not within the loop_. We can correct our mistake with the following:

	Scanner user = new Scanner(System.in);
	System.out.println("Enter an int, -1 to stop.");
	int number = user.nextInt();;
	int sum = 0;

	while (number != -1) {
		sum += number;
		System.out.println("Thanks!");
		number = user.nextInt();
	}

	System.out.println(sum);

Now, we take in a value for `number` instead of setting it to `0`. We get the new value of `number` from the user at the end of the loop, check it against the loop condition. If the loop condition is satisfied, then we'll run the body of the while loop, and add to `sum`. Great!


### For
The for loop is a simple and extremely handy control flow statement. The header of a for loop is composed of an **initialization**, a **termination condition**, and an **increment**, and the **body** is composed of statements. The intialization provides a loop variable and its initial value. The termination provides a condition that determines when the loop will stop. The increment provides the new value for the loop variable on each iteration. 

The flow of a for loop works like this:
- The loop variable is initialized to some value.
- The termination condition is checked. If it is true, then the statements in the loop body are executed.
- Once the statements have finished, the increment is performed.
- The termination condition is checked. If it is true, then the statements in the loop body are executed...
- And so on, until the termination condition is false.

Let's look at an example. This loop calculates the sum of numbers 1 to 10.

	int sum = 0;
	for(int i = 1; i <= 10; i++) {
		sum += i;
	}

The intialization is `int i = 0`. This declares a new varaible `i`, and assigns it the value `0`. The termination condition is `i <= 10`. When this condition is `false`, the loop will stop. The increment is `i++`. After each iteration of the loop, `i` will be incremented by 1.

Although this is the usual pattern of for loops