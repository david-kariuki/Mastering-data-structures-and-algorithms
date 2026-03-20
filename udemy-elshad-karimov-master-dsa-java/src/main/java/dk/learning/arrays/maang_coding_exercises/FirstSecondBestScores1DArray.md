## Find First and Second Highest Scores

### Explanation

- `public static int[] findTopTwoScores(int[] array)`  
  Defines a function that takes an integer array and returns a new array containing the highest and second highest
  values.

- `int firstHighest = Integer.MIN_VALUE;`  
  Initializes the variable to track the highest value.  
  Using `Integer.MIN_VALUE` ensures any number in the array will be greater.

- `int secondHighest = Integer.MIN_VALUE;`  
  Initializes the variable to track the second highest value.

- `for (int score : array)`  
  Iterates through each element in the array.

- `if (score > firstHighest)`  
  Checks if the current value is greater than the highest found so far.

- `secondHighest = firstHighest;`  
  Updates second highest before changing the highest value.

- `firstHighest = score;`  
  Updates the highest value.

- `else if (score > secondHighest && score < firstHighest)`  
  Ensures:
    - It is less than the highest (avoids duplicates)
    - It is greater than the current second highest

- `secondHighest = score;`  
  Updates the second highest value.

- `return new int[]{firstHighest, secondHighest};`  
  Returns both values in a new array.

---

### Time Complexity Explanation

- Function definition → O(1)
- Variable initialization → O(1)
- Loop through array → O(n)
- Comparisons and assignments inside loop → O(1)
- Return statement → O(1)

---

### Final Time Complexity

**Overall Time Complexity: O(n)**

Where:

- n = number of elements in the array

---

### Space Complexity

**O(1)**

- Only two variables are used regardless of input size

---

### Key Insights

- Single pass through the array is enough
- No sorting required, which avoids O(n log n)
- Handles duplicates correctly
- Efficient for large datasets