# For Loops

## Outline:
- Review of While
- For
- Enhanced For
- Putting it Together

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

So what's up with all this information we have to provide in a for loop? Well, the secret is that for loops are just convenient versions of while loops. _Any for loop can be written as a while loop, and any while loop can be written as a for loop_. We can rewrite the above example as a while loop like this:

	int sum = 0;
	int i = 1;   // initialization
	while (i <= 10) {
		sum += 1;
		i++;    // increment
	}

As you can see, we moved our intialization directly above the start of the loop. The termination condition is the same between the two loops. The increment is the last statement of the loop. It turns out, programmers were writing this kind of loop with intialization and incremeninting very often, so the for loop was created to make it easy and simple. We can say that for loops are **syntatic sugar**. They're simply a different convenient syntax for while loops.


It's worth noting that for loops can get pretty weird. It's possible for any of the three parts in the header of the foor loop to be empty, and it's possible that the parts do not strictly relate to each other. All of the below are valid for loops -- but that does not mean they are good design!

	int sum = 0;
	int i;
	for (i = 0; sum < 25; i++) {
		sum = sum * 2 + 1;
	}

In the above loop, `sum` will run through the values `0, 1, 3, 7, 15, 31`. The variable `i` is used as a counter here, to see how many iteration it takes for the terminaiton condition, `sum < 25` to be false. In other words, how many times do we have to run the statement `sum = sum * 2 + 1;` before `sum` is greater than 25?

	Scanner user = new Scanner(System.in);
	int i;
	for (i = 0; ; i++) {
		if (user.nextInt() == -1) {
			break;
		}
	}

The above loop will count how many times a user enters an int that is not 0. Note that our termination condition is empty. Instead, we're using `break`. This is bad design, as we can perform the same functionality like this:

	Scanner user = new Scanner(System.in);
	int i;
	for (i = 0; user.nextInt() == -1; i++) {

	}


### Enhanced For
The Enhanced For loop, also called the For-Each loop, is composed of a **loop variable** an **iterable**, and a **body** of statements. "Iterable" is a fancy word for a collection of things that can be iterated over. The loop variable is the variable that will be assigned to each element in the iterable/collection. 

The flow for the enhanced for loop works like this:
	- The loop variable is assigned to the first item in the iterable.
	- The code in the body is executed.
	- The loop variable is assigned to the next item in the iterable.
	- The code in the body is executed
	- And so on, until there are no more items in the iterable.

Let's see an example:

	int[] numbers = new int[10]; /* fill it to be 5, 2, 7, 3, 4 */
	int sum = 0;
	for (int num : numbers) {
		sum += num;
	}

The above code creates an array of numbers, and then iterates over it. On each iteration, `num` will be the value of the number in the array of numbers. In this case, `num` will be `5`, then `2`, then `7`, and so on. On each iteration we add `num` to `sum`, giving us the sum of all the numbers in the array at the end of the loop.

What's the difference between the enhanced for and the normal for? Let's write the same code above with a normal for loop to figure it out.

	int[] numbers = new int[10]; /* fill it to be 5, 2, 7, 3, 4 */
	int sum = 0;
	for (int i = 0; i < numbers.length; i++) {
		sum += numbers[i];
	}

In this loop, our loop variable is `i`. What values does `i` take on as the loop executes? It starts as 0, and each iteration is incremented by 1, so it goes through the values `0, 1, 2, ...`. The variable `i` represents an _index, the position of an element in the array_. In contrast, in the enhanced for above, the loop variable `num` represents _the actual value of the element in the array_. This is really important, so I'll say it again: _for loops run through indices, enhanced for loops run though elements_. Since `i` is the index of the elements, then we use `numbers[i]` to access the value in the array, the element at position `i`. 

With this understanding we can write the normal for loop again to make it clear what's going on in the enhanced version?

	int[] numbers = new int[10]; /* fill it to be 5, 2, 7, 3, 4 */
	int sum = 0;
	int num;
	for (int i = 0; i < numbers.length; i++) {
		num = numbers[i]; // secret!
		sum += num;
	}

In the above code, we've added in the line `num = numbers[i]`. This is what is secretly happening when you write an enhanced for loop. Java keeps track of which elements you're looking at, and assigns the loop variable to the element at that position. So as with while loops and for loops, we can see that any enhanced for loop can be written as a for loop!

So why use enhanced for loops? They easy! You don't have to keep track of which element you're looking at. You don't have to worry about a termination condition, because the loop will stop when you're out of elements. And you don't have to worry about incrementing, as Java will always give you the next element.


# Putting it Together