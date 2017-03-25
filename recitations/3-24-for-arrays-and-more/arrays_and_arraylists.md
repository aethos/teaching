# Arrays and ArrayLists

## Outline:
- Arrays
- ArrayLists
- When should I use what?

## Signposting:
- What is an array?
- What is an ArrayList? How does it differ from an array?
- When should you use an array? When should you use an ArrayList?

## Arrays

An array is a collection of a fixed number of elements of a single type. That means that an array has a **fixed length**, and a **fixed type** of element it stores. We initialize an array like this:

	int[] myNums = new int[10];

We have declared and initalized a new array, `myNums` that stores elements of type `int`. We've also given the array a length of `10`. When creating an array, we need to give both the length, and the type of element the array stores. It's impossible to create an array without both.

Arrays can store elements of any type, as long as it's the same type.

	Song[] myMusic = new Songs[200];

We insert an element into an array by specifying the index at which we want to insert it, and using the assignment operator `=`.

	myMusic[23] = new Song("Too Soon (Mallive Remix)", "Vanic");

We retrieve an element from an array by specifying the index at which it is.

	System.out.println(myMusic[23]);


The length of an array cannot be changed after it is created. Therefore, they are good for representing collections that have a predetermined size. For example, if you know that your phone can only hold 200 songs, then it makes sense to have an array to store the songs. The only way you could store more songs would be to buy a new phone, and the only way to increase the length of the array would be to make a new array. Likewise, it would make sense to use an array to represent a chessboard (with a 2D array). There's only 64 squares on the chessboard, and no way to add any more.

We access the length of an array with `.length`.

	Song[] myMusic = new Songs[200];
	myMusic.length; // number of songs, 200

The result of `myMusic.length` will be `200`, the length we initalized the array with. This is irrespective of the contents of the array, it is simply describing the length.

Because arrays are 0-indexed, the first index we start at is 0. Since we have 200 songs in total, our indecies will run from 0 to 199. This gives us a pattern for retrieving the last element of an array. It is always one less than the length of the array.

	myMusic[0] = // first song
	myMusic[myMusic.length-1] = // last song

This may seem kind of clunky, but it actually helps us right loops really easily!  In general, the format looks like this:

	int[] array;
	for(int i = 0; i < array.length; i++) {
		// code
	}

`i` will run from `0` to `array.length-1`, which is all of the indecies of the array.

There's two common issues we can run into with arrays. The first is an `ArrayIndexOutOfBoundsException`. This exception happens when you try to access an item outside the bounds of an array. For example:

	Song[] myMusic = new Songs[200];
	myMusic[999] = new Song();

This will generate an exception that looks like this:

	Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 999
	at Test.main(Test.java:4)

As you can see, Java will tell you which line the exception happens on, and what index you were trying to access, here `999`, when the exception occured. This issue occurs during **runtime** -- Java does not pick it up during compiletime. This might seem a bit silly to you, as you can obviously see that `999` is way out of bounds. But what if we had something like this?

	Song[] myMusic = new Songs[200];
	Scanner user = new Scanner(System.in):
	System.out.println("Enter an index.")
	int index = user.nextInt();
	myMusic[index] = new Song();

Java has no possible way of knowing what number the user will enter, and thus no possible way of knowing if `index` will be out of bounds or not. So, Java has no choice but to generate this exception at runtime.

The second common issue a a type mismatch:

	myMusic[22] = "Walking On A Dream by Empire of the Sun";

`myMusic` is an array of `Song` objects, but we're trying to save a `String` into it! Java will pick up on this type mismatch, and generate an error when compiling that looks something like this:

	Test.java:4: error: incompatible types: String cannot be converted to Song
		myMusic[22] = "Walking On A Dream by Empire of the Sun";
					  ^

Since Java knows all of the types here, it's able to pick this issue up at **compiletime**.





## ArrayLists

ArrayLists are a fancy version of arrays that is resizeable. The key to ArrayLists is that they automatically expand to accommodate more elements. When we want to use an ArrayList, we have to import them from the `java.util` library.

	import java.util.ArrayList;

	ArrayList<Song> myMusic = new ArrayList<Song>();

You will see that we still have to specify the type the ArrayList will hold, but we do not have to specify the length of the ArrayList. ArrayLists have a **fixed type** but do **not** have a **fixed length**.

Instead, ArrayLists magically (and for no reason) always start off built to hold 10 elements. In the case that they are full and you add another element, they will automatically expand by 1.5 times their current size. Don't worry about the exact numbers, as long as you remember that ArrayLists automatically expand.

We add elements to an ArrayList with the `.add()` method.

	Song newRemix = new Song("Too Soon (Mallive Remix)", "Vanic");
	myMusic.add(7, newRemix); // insert at 7

The above code will add the song `newRemix` in at position `7`. We also have the option not to specify an index, in which case the new element will be placed at the end of the ArrayList.

	myMusic.add(newRemix); // places at end

Using the add method without an index is useful for adding a bunch of elements to an ArrayList in a loop. You'll never run out of space, because the ArrayList will expand to accommodate the new elements!


Because of ArrayLists's expandable nature, the `.add()` method has some interesting behavior. If there is already an element at the index you are adding, then the elements will be shifted down as necessary. Let's look at at a basic example:

	/* myMusic contains Song1, Song2, Song3, Song4 */
	myMusic.add(1, newRemix);
	/* myMusic contains Song1, newRemix, Song2, Song3, Song4 */

There are two other methods you should know, the first of which is `.set()`. This `.set()` works like insertion for arrays. It sets the element at the index to the given value, and doesn't do any shifting. Therefore, you can think of it as overwriting that element.

	/* myMusic contains Song1, Song2, Song3, Song4 */
	myMusic.add(1, newRemix);
	/* myMusic contains Song1, newRemix, Song3, Song4 */

The other method is `.remove()`, which removes the element at a given index. When you remove an item, the ArrayList shift all the following elements one to the left.

	/* myMusic contains Song1, Song2, Song3, Song4 */
	myMusic.remove(1);
	/* myMusic contains Song1, Song3, Song4 */

It's important to note that although ArrayLists expand automatically, you can still run into out of bounds exceptions. For example:

	ArrayList<Song> myMusic = new ArrayList<Song>();
	/* put 200 elemnts into myMusic */
	myMusic.set(999, newRemix);

This will generate a runtime exception, becasue there is no 999th element we can set!

As a final note, you should know that ArrayLists are only able to hold objects, and not primative types. So if you need a collection of ints or doubles, then you need to use an Array. Luckily, primative types in Java have something called container types, which are Object version of themselves, which you are able to use with ArrayLists. The container type of `int` for example is `Integer`. So you are able to do this:

	ArrayList<Integer> nums = new ArrayList<Integer>();

## When should I use what?
- Adding elements to a collection? Know how many? -- use an Array
- Adding elements to a collection? Don't know how many? -- use an ArrayList
- Do you have a fixed number of items, like a game board? -- use an Array
- Do you need to make additions and deletions? -- use an ArrayList
- Need a collection of primatives? -- use an Array
