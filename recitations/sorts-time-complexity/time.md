#Time Complexity:
- What is it?
- What do we use it for, and why?
- How do we calcuate time complexity?
- What is "big-O" notation?
- Big-O and Time Complexity


###What is Time Complexity?:
Time complexity is a measure of how much time it takes an algorithm to run, in terms of the size of the input, <b>n</b>. In other words, time complexity is a function that describes the running time of an algorithm. 

###What do we use it for?:
Time complexity is a useful for determining the efficiency of an algorithm. It gives you an idea of the "blowup" of the algorithm -- how much additional work is needed for each additional piece of input. One way to think about it is a graph with the size of input on the x-axis, and the time to run the algorithm on the y-axis. What is the slope of the line? This will become clearer as we go forward.



###How do we calculate time complexity?:
The first step in calculating time complexity is to pick the <b>work unit</b>. The work unit is a single operation that we consider as taking "one" time. This could be one second, one nanosecond, one minute, the units are not important. All we need to know is that this operation takes some amount of time. Examples of a work unit could be any of the following:

- Adding two values together
- Comparing two values
- Swapping items in an array
- And more!

Our work unit takes "one" time. Now we need to look at how many times our algorithm performs the work unit, based on the length of input, <b>n</b>. Let's look at an example. This simple block of code calculates the sum of all the values in an array:

	// given array of values A
	sum = 0
	for i = 0 to n:
	  sum = sum + A[i]

The work unit is the addition in the line <b>sum = sum + A[i]</b>. Now the question is, how many times is our work unit performed, i.e. how many times is that line of code run? Well, the loop will run through i = 0 to i = n-1, which is a total of n iterations. Therefore, our work unit will be performed <b>n</b> times. We can notate this as <b>T(n)</b>, "the time the algorithm takes with input of size n". 

Let's look at a slightly more complex example, selection sort:

	sub selection_sort(A[]):
	  for i = 0 to length(A):
	    min_idx = i
	    for j = i+1 to length(A):
	      if (A[j] < A[min_idx]):
	        min_idx = j
	    swap(i, min_idx)

Here we'll pick the comparision <b>A[j] < A[min_idx]</b> as the work unit, taking "one" time. The line <b>swap(i, min_idx)</b> will also take "one" time, but we'll ignore this for now, and come back to it later.

We'd like to figure out how many work units this algorithm performs. First let's think about how many times the outer loop is run. <b>for i = 0 to length(A)</b> will run from i = 0 to i = n-1, where n is the length of the array. This is a total of <b>n</b> iterations. So now we know that the body of the inner loop will be run <b>n</b> times.

Now let's think about how many times the inner loop is run. On the first iteration of the outer loop, i = 0 and j = i+1 = 1. The inner loop will then run from j = 1 to n-1. This is (n-1) iterations, and so the inner loop will run <b>n-1</b> times. In this iteration, the work unit will be performed <b>n-1</b> times.

On the second iteration of the outer loop, i = 1 and j = i+1 = 2. The inner loop will then run from j = 2 to n-1. This is (n-2) iterations, and so the inner loop will run <b>n-2</b> times. In this iteration, the work unit will be performed <b>n-2</b> times.

This trend will continue, giving us the series <b>(n-1), (n-2), (n-3), ...</b>, as i increases. Now, we need to add this series together to get the total time taken for the algorithm. 

We can apply the formlua for the sum of the arithmatic series <b>k + (k-1) + (k-2) + ...</b> = <b>k(k-1)/2</b>. Here we have the arithmatic series <b>(n-1) + (n-2) + (n-3) + ...</b>, which will give us <b>(n-1)(n-2)/2</b>.

So the time selection sort takes is <b>T(n) = (n-1)(n-2)/2</b>. This looks pretty complicated, but luckily we can simply using big-O notation! We'll come back to this example in a minute.

###Big-O Notation:
Big-O notatation is a notation that describes the "asymtotic upper bound" of a function. That's a fancy way to say "how the function behaves as as the input gets really really big". You can think of it like taking the limit of a function as the input size <b>n</b> goes to infinity, as you might have done in math class.

Similarly to how limits work, big-O allows us to elimiate constants and lower order terms, as they do not matter when our input size is really big. For example:

	f(n) = 2n  		-->  O(f(n)) = O(2n) = O(n)
	f(n) = n^2 + n	-->  O(f(n)) = O(n^2 + n) = O(n^2)
	f(n) = n! + 8	-->  O(f(n)) = O(n! + 8) = O(n!)

Now that we've got big-O down, let's integrate it with time complexity.

###Big-O and Time Complexity:
Big-O is a useful way of looking at time complexity, and specifcally measures the "worst case" of the algorithm. That means that in every scenerio, we'll pick the worst possible outcome. For example, if we had the following block of code:

	// randomly get the value n
	if n == 4:
		print("hello")
		print("hello")
		print("hello")
	else:
		// do nothing

We would pick the worst possible case, which is <b>n == 4</b>. This is an important characteristic of big-O. There are other notations, called big-Theta and big-Omega, which measure the average and best cases of an algorithm, and therefore make different assumptions as they run through an algorithm. For our purposes, big-O is the most important measure of time complexity and the only one we'll be considering here. Note that this element of picking the worst case is not apparent in the selection sort example -- I'm mentioning it here for completeness.

Now let's turn our attention back to the selections sort example. We found the time complexity was <b>T(n) = (n-1)(n-2)/2</b>. What's the big-O for this algorithm? Let's simplify!

	T(n) = (n-1)(n-2)/2  --> O(T(n)) = O( (n-1)(n-2)/2) )

	// expanding
	--> O( (n^2 - 3n +2)/2) )

	// decomposing the fraction
	--> O( (n^2)/2 - (3n)/2 + (2)/2 )

	// elimiate lower order terms
	--> O( (n^2)/2 )

	// remove constants
	--> O(n^2)

	// done!

As we can see, the time complexity for selection sort is <b>O(n^2)</b>. This much easier to understand than the function <b>T(n) = (n-1)(n-2)/2</b> we had before. That's why we use time complexity -- it makes it easy to understand how fast algorithms run. As sorts go, this is pretty slow, and you'll come across other sorts like merge sort that have a better time complexity.
