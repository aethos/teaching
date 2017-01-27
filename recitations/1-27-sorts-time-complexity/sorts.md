#Topics:
- Sorts
- Selection Sort
- Insertion Sort
- Merge Sort
- (Binary Search)

####Sorts:
What are sorts? Sorts are a group of algorithms with a specific function. Recallthat an algorithm is a <em>well-defined procedure that transforms some given input in to output</em>. So for sorts, the input is some series of values. The output is the same values in non-decreasing order. Sorts have different time and space complexities, so the sort you'll want to pick will change from situtaion to situation. Let's go over a few!

####Selection Sort:
Selection sort is a basic sort that works on the principle of running over the array and "selecting" the smallest value in each iteration, to swap with with current position. It slowly builds up a sorted section of the array until the until array is sorted. Here's the psuedocode:

	sub selection_sort(A[]):
	  for i = 0 to length(A):
	    min_idx = i
	    for j = i+1 to length(A):
	      if A[j] < A[min_idx]:
	        min_idx = j
	    swap(i, min_idx)

The time complexity of selection sort is <b>O(n^2)</b>, where n is the length of the array. This means that selection sort will "touch" every element in the array n times. The notation here, which is called "big-O", gives the time complexity for the worst case of the algorithm. This is true not only in the worst case, but actually in <em>every</em> case of running the algorithm. Can you see why? It's because, unlike insertion sort, selection sort will <em>always</em> traverse the entire unsorted portion of the array.

####Insertion Sort:
Insertion sort works by maintaining a sorted section of the array, to which a new value is "inserted" into its correct position. Always think of insertion sort as having two sections in the array, the sorted section on the left, and the unsorted section on the right. We pick first value in the unsorted portion and put it in the sorted portion. It's usually faster that selection sort, which makes it a popular sorting algorithm. Here's the pseudocode:

	sub insertion_sort(A):
		for i = 1 to length(A):
			key = A[i]
			j = i-1
			while j >= 0 and key < A[j]:
				A[j+1] = A[j]
				j = j - 1
			A[j+1] = key


A few things to note here. We start considering values from the <em>second</em> position in the array (index 1). Why? Remember that we want to divide the array into two sections, sorted and unsorted. When we start the algorithm, we consider the first element in the array as in the sorted section. We could start with the sorted section as empty, but since one element by itself is sorted, we might as well start with the first element.

Here's an example. The sorted section of the array is marked with curly braces.

	{  5  }  2  3  4  7  1

The first value we consider is <b>2</b>, the first value in the unsorted section. Since 2 is less than 5, we shift 5 over and insert 2 into its correct position. The way this happens is not extremely important, as it will vary from implementation to implementation. The result is the following:

	{  2  5  }  3  4  7  1

Now we consider the value <b>3</b>, and compare it to the right-most element in the sorted portion, 5. Since 3 is less than 5, we'll shift 5 over. Now we compare 3 and 2. Since 3 is not less than 2, we know we've found the spot to insert our value. We end up with:

	{  2  3  5  }  4  7  1

We've just stumbled upon the reason that insertion sort is generally more efficient than selection sort. When we're going down the line and doing comparisions with the values in the sorted section, we can leverage the fact that the it's sorted to elimnate unecessary comparisions. We can see this clearly in the next interation.

Now we consider <b>4</b>. We compare 4 to 5 and shift 5 over. Then we compare 4 to 3, <em>stop comparing</em>, and insert 4. We don't need to compare 4 to 2 because we know that all the values to the left of 3 are <em>less</em> than 3, because that section of the array is <em>sorted!</em> How cool is that! Now we have the following:

	{  2  3  4  5  }  7  1

In the next iteration we consider <b>7</b>. Since 7 is greater than 5, and since we know that everything to the left of 5 is less than 5, we can stop our comparisions right away. We know that 7 is greater than anything in the sorted porition of the array, so we can just extend our sorted porition without any additional work.

	{  2  3  4  5  7  }  1

On this last step we consider <b>1</b>. We'll compare 1 to 7, then to 5, then to 4, then to 3, and then to 2, shifting the values over. Since we've reached the end of the array and have no more comparisions to make, we'll insert 1 at the front and that'll be it.

	{  1  2  3  4  5  7  }

Done!



####Merge Sort:



####Binary Search: