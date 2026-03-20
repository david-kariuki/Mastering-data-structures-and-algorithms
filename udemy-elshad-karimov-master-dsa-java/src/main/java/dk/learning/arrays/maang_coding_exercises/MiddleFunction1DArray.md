## Middle Function Explanation

Here's a brief explanation of what each part of the code does:

- `public static int[] middle(int[] array)`: Defines the function that takes an integer array as input and returns a new
  array excluding the first and last elements.

- `if (array.length <= 2)`: Checks if the array has 2 or fewer elements.

- `return new int[0];`: Returns an empty array if the condition above is true.

- `int[] middleArray = new int[array.length - 2];`: Creates a new array that will hold the middle elements.

- `int index = 1;`: Initializes the index to start from the second element.

- `while (index < array.length - 1)`: Iterates through the array excluding the first and last elements.

- `middleArray[index - 1] = array[index];`: Copies elements into the new array.

- `index++;`: Moves to the next element.

- `return middleArray;`: Returns the resulting array.

---

## Time Complexity Explanation

The time complexity is determined by the loop that iterates through the array.

- `public static int[] middle(int[] array)`: O(1)

- `if (array.length <= 2)`: O(1)

- `return new int[0];`: O(1)

- `int[] middleArray = new int[array.length - 2];`: O(1)

- `int index = 1;`: O(1)

- `while (index < array.length - 1)`: O(n-2)

- `middleArray[index - 1] = array[index];`: O(1)

- `index++;`: O(1)

- `return middleArray;`: O(1)

---

## Final Time Complexity

The loop runs (n - 2) times, so:

**Overall Time Complexity: O(n)**

Where:

- n = length of the input array