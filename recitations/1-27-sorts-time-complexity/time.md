#Time Complexity:
- What is it?
- What do we use it for, and why?
- What is "big-O" notation?
- How do we calcuate time complexity?



###What is Time Complexity?:
Time complexity is a measure of how much time it takes an algorithm to run, in terms of the size of the input, <b>n</b>. In other words, time complexity is a function that describes the running time of an algorithm. 

###What do we use it for?:
Time complexity is a useful for determining the efficiency of an algorithm. It gives you an idea of the "blowup" of the algorithm -- how much additional work is needed for each additional piece of input. To understand this more, we'll need to look at "big-O" notation first.

###Big-O Notation:




###How do we calculate time complexity?:
The first step in calculating time complexity is to pick the <b>work unit</b>. The work unit is a single operation that we consider as taking "one" time. This could be one second, one nanosecond, one minute, the units are not important. All we need to know is that this operation takes some amount of time. Examples of a work unit could be any of the following:

- Adding two values together
- Comparing two values
- Swapping items in an array
- And more!

Our work unit takes "one" time, which is another way of saying it takes O(1) time, in the big-O notatation.

Now we need to look at how many times our algorithm performs the work unit, based on the length of input, <b>n</b>.


