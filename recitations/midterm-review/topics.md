# Topics

### Some Terms Review:
- Formal vs. Actual Parameter
- Implicit vs. Explicit Parameter
- Parameter vs. Argument
- Acessor vs. Mutator Methods
- Instance vs. Class Variable

### Time Complexity & Sorts:
- How do we calculate it?
- What is big O notation?


Example 1:

	int[] array = new int[10];
	int sum = 0;
	for (int i = 0; i < array.length; i++) {
		sum += array[i];
	}
	return sum;

Example 2: (as a sidenote, what is this code doing?)

	int[] array = new int[10];

	for (int i = 0; i < array.length; i++) {
		int minIdx = i;
		for (int j = i+1; j < array.length; j++) {
			if (A[j] < A[minIdx]) {
				minIdx = j;
			}
		}
		int temp = A[i];
		A[i] = A[minIdx];
		A[minIdx] = temp;
	}

Example 3: Insertion Sort

	for (int j = 1; j < n; j++) { 
		int temp = A[j] 
		int i = j - 1 
		while (i > 0 and A[i] > temp) {
			A[i+1] = A[i] 
			i = i - 1
		}
		A[i+1] = temp
	}


### Misc:
- What are all the primative types in Java, and their sizes?
- How can you convert the decimal number 42 to binary?
- What are the primary components of the Von Newmann architecture?