# Searches
- Intro
- Linear Search
- Binary Search


### Intro:
In this document we'll be looking at a few different ways to search an array for a value. In general, a search algorithm is an algorithm that, given a value and a collection of information, determines if the collection contains the specified value. We'll see later in the course that this can apply to many different types of information, and many different types of collections of data. But for these two searches, we will be using the example of searching for a number in an array of numbers.


### Linear Search
Linear Search, sometimes called Sequential Search is the simplest search algorithm out there. The algorithm starts at the beginning of the array, and compares it to the value that we are searching for. If we have found the value, then we can end our search. Otherwise, the algorithm looks at the next item in the array, and compares it to the value we are searching for, and so on, until we reach the end of the array. Let's look at the pseudocode:

	// given array of values A and value x we are searching for
	for (i = 0; i < A.length; i++) {
		if (A[i] == x) {
			print("we found it!")
			// exit program
		}
	}

	print("we did not find it")

One thing worth noting about our code here is that the algorithm ends as soon as it finds the value we're searching for. This is not always the case -- for example, you might want to keep searching to see how many times the value appears in the array. In this case, you'd need to modify the above code to do so. The time complexity for Linear Search is <b>O(n)</b>, where <b>n</b> is the length of the array we are searching. This is the worst-case of the algorithm, in which the value we are searching for does not appear in the array, so we will compare <b>x</b> against every value in the array one time. Since there are <b>n</b> items in the array, we have <b>O(n * 1) == O(n)</b>.


### Binary Search
Binary Search is a little more complicated. It's a clever algorithm that is much faster than Linear Search, but with one caveat. It requires that the array that you are searching is already sorted. As we will see, this property allows Binary Search to quickly narrow down the part of the array that it is searching. Let's see the code first:

	// given array of values A and value x we are searching for
	start = 0
	end = A.length
	while (start <= end) {
		mid = floor((start + end) / 2)
		if (A[mid] == x) {
			print ("we found it!")
			// exit program
		} else if (A[mid] < x) {
			start = mid + 1
		} else if (A[mid] > x) {
			end = mid - 1
		}
	}

	print("we did not find it")

As you can see, the algorithm keeps track of three indices, three places in the array. There is <b>start</b>, which marks the start of the section that we are searching. There is <b>end</b>, which marks the end of the section that we are searching. And there is <b>mid</b>, which markes the middle of the section we are searching, or the place on the left of the middle in the case that the middle is between two elements in the array. Let's run through an example. I'll mark the start and end of the searched section with braces. 

	// array of values A
	1	3	4	5	7	8	9

	// x == 7, the value we are searching for

The algorithm starts by considering the entire part of the array, i.e. <b>start == 0</b> and <b>end == n == 7</b>. This means we consider all of the array.

	{1	3	4	5	7	8	9}

We calculate the middle of this part as <b>mid == floor((0 + 7) / 2) == 3</b>. Now, we compare the the value at index <b>mid</b> with the value we are searching for, <b>x == 7</b>. We can see the value at index <b>mid</b>, which we notate as <b>A[mid]</b>m is <b>5</b>. Now here's the cool part. We know that the array is sorted. Therefore, if the we know that all of the values to the right of <b>A[mid]</b> will have to be greater than it. And since <b>x > A[mid]</b>, then we know that <em>if x appears in the array, it will have to be to the right of <b>mid</b></em>. Wow! With that knowledge, we can narrow down the part of the array we're looking at, by setting <b>start = mid + 1</b>.

	1	3	4	5	{7	8	9}

Check that out! We were previously considering 7 values, and now we are only considering 3. And now we never have to think about those values on the left of the array again.

Now, since <b>start == 4 <= end == 7</b>, we run the next iteration of the while loop. This time, <b>mid == 6</b>. Comparing <b>x == 7</b> with <b>A[mid] == 8</b>, we see that <b>A[mid] > x</b>. Again, since we know that the array is sorted, we know that <em>if x appears in the array, it will have to be to the left of <b>mid</b></em>. We set <b>end = mid - 1</b> and narrow down the part of the array we're considering.

	1	3	4	5	{7}	8	9.

Now we're down to only looking at one value. We run the while loop again because the condition <b>start == 6 <= end == 6</b> is true. We can see that <b>mid == floor((6 + 6) / 2</b>. Since <b>A[mid] == 7 == x</b>, we've found the value we were searching for! Thus we print a confirmation and exit the program. 

If we ran binary search again, but were instead looking for <b>x == 5.5</b>, then we would follow the exact same steps as above, but find that <b>A[mid] > x</b>. Therefore, we would expect to find <b>x</b> to the left of <b>A[mid]</b>, and we update <b>end = mid - 1</b>. However, we have already looked at all values to the left of <b>A[mid]</b>, and it wouldn't make sense to check them again. So, we should stop the program here. This is handled by the condition of the while loop. Because <b>end</b> is now less than <b>start</b>, the condition is no longer satisfied, and we terminate the loop. We print out a failure, and exit the program.

The strength of Binary Search is that it is able to eliminate large parts of the array rapidly. In fact, Binary Search is able to eliminate half of the current considered part on each iteration of the loop. This is what gives us the time complexity of Binary Search as <b>O(log(n))</b>, where n is the number of values in the array. The reasoning behind this is a little complex. If you had an array with 8 values, then on the first pass binary search would be looking at 8 values. On the next, 4 values. On the next, 2, and finally only 1 at the end. (Of course, this is in the worst-case; we might find the specified value sooner.) You can see a pattern here of dividing by 2. And we know that when we get down to only looking at 1 value, then we're done with searching. So the question is: how many divisions of 2 does it take to get down to only looking at 1 value? We write this as:

	n / 2^x = 1
	// Where n is the size of the array
	// and x is the number of times to divide by 2.

	// We can rearrange this to be
	n = 2^x

	// And now we do log base 2, notated as just "log" for convenience
	log(n) = log(2^x)

	// Simplify
	log(n) = x

And as we can see, that leaves us with our time complexity!

One last takeaway: Although Binary Search is much faster than Linear Search, it requires that the array be sorted before hand. Depending on the size of your data, sorting may take a long time. So, it's often the case that if you're running only a few searches, you shouldn't bother with sorting the data, Linear Search will be sufficient. But if you plan on running many many searches, then it may be better to first sort the data, and then the faster Binary Search for each search.