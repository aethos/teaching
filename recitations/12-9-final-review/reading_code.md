## Reading Code

What does this print?

	int[] a = {3, 4, 5, 5, 6};
	for (int i = 0; i < a.length; i = i + 2)
	{
		if (a[i] % 3 == 0)
		{
			System.out.println(i);
		}
	}

What is the value of b at the end of this block?

	int a = 4;
	int b = 1;
	int c = 0;

	while (a >= c)
	{
		b = b * 2;
		c = c + 1;
	}


What does this code do to arr?

	int[] arr = { /* some values */ };
	int temp;

	for (int i = 0; i < arr.length; i++)
	{
		for (int j = i; j < arr.length; j++)
		{
			if (arr[i] > arr[j])
			{
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
