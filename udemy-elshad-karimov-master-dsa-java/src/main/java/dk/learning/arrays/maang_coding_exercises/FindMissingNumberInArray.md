# Missing Number

## Explanation

- `public static int findMissingNumberInArray(int[] array)`  
  Defines a function that takes an integer array as input and returns the missing number.

- `int n = array.length + 1;`  
  Calculates the total number of values that should exist in the full range.  
  Since one number is missing, the array length is `n - 1`, so `n` is `array.length + 1`.

- Problem pattern  
  This is a **range completeness** problem.  
  The array is supposed to contain all unique values from `1` to `n`, but one value is missing.

- Main idea  
  Instead of checking each number one by one, compare:
    - the **expected sum** of numbers from `1` to `n`
    - the **actual sum** of numbers present in the array

- `int expectedSum = (n * (n + 1)) / 2;`  
  Calculates the total sum of the first `n` natural numbers using the formula:

  ```text
  n * (n + 1) / 2
  ```

- `int actualSum = 0;`  
  Initializes a variable to store the sum of the array elements.

- `for (int number : array)`  
  Iterates through each element in the array.

- `actualSum += number;`  
  Adds the current number to the running total.

- `return expectedSum - actualSum;`  
  The difference between the expected sum and the actual sum is the missing number.

---

## Example Walkthrough

Array: `{1, 2, 3, 4, 6}`

- `n = array.length + 1 = 5 + 1 = 6`

- Expected full range:
  `1, 2, 3, 4, 5, 6`

- `expectedSum = (6 * 7) / 2 = 21`

- `actualSum = 1 + 2 + 3 + 4 + 6 = 16`

- Missing number:
  `21 - 16 = 5`

---

## Java Solution

```java
public class MissingNumber {
    public static int findMissingNumberInArray(int[] array) {
        int n = array.length + 1;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int number : array) {
            actualSum += number;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 6};
        System.out.println(findMissingNumberInArray(myArray)); // 5
    }
}
```

---

## Time Complexity Explanation

- Function definition → O(1)
- `int n = array.length + 1;` → O(1)
- `int expectedSum = (n * (n + 1)) / 2;` → O(1)
- `int actualSum = 0;` → O(1)
- `for (int number : array)` → O(n)
- `actualSum += number;` → O(1) per iteration
- `return expectedSum - actualSum;` → O(1)

---

## Final Time Complexity

**Overall Time Complexity: O(n)**

Where:

- `n` = number of elements in the input array

The loop dominates the runtime because it processes each element once.

---

## Space Complexity

**O(1)**

- Only a few variables are used
- No extra array, list, or map is created
- Space usage stays constant regardless of input size

---

## Key Insights

- The problem is not really about searching randomly through the array
- It is about comparing an **expected complete total** with the **actual incomplete total**
- A single pass through the array is enough
- No sorting is required
- This is more efficient than checking every number individually

---

## Interview Thinking

When you see this kind of question, think like this:

- Is there an **expected complete set**?
- Is the input missing one element from that set?
- Can I compare **expected vs actual**?
- Can math simplify the solution?

Core pattern:

**Expected total vs actual total**

---

## How to Explain in an Interview

“I noticed the array should contain all unique numbers from `1` to `n`, with exactly one missing. Since the array has
one missing element, I first compute `n` as `array.length + 1`. Then I calculate the expected sum of the full range
using `n * (n + 1) / 2`, sum up the actual array values, and subtract the two. The difference gives the missing number.”