# Remove Duplicates from Sorted Array (In-Place)

## Explanation

- `public static int removeDuplicates(int[] array)`  
  Defines a function that takes a sorted integer array and returns the new length after removing duplicates in-place.

- Problem pattern  
  This is an **in-place array compression** problem.  
  Since the array is sorted, duplicates are adjacent.

- Key idea  
  Instead of removing elements physically, we:
    - overwrite duplicate positions
    - keep unique values at the beginning of the array
    - return the length of the unique portion

---

- `if (array == null || array.length == 0)`  
  Handles edge case where the array is empty.

- `return 0;`  
  If the array is empty, there are no elements.

---

- `int index = 0;`  
  This pointer tracks the position of the **last unique element**.

---

- `for (int i = 1; i < array.length; i++)`  
  Iterates through the array starting from the second element.

- `if (array[i] != array[index])`  
  Checks whether the current element is different from the last unique element.

  👉 Since the array is sorted:
    - duplicates are adjacent
    - comparing with the last unique value is sufficient

---

- `index++;`  
  Moves the index forward to the next position for a unique value.

- `array[index] = array[i];`  
  Writes the new unique value into the correct position.

---

- `return index + 1;`  
  Returns the number of unique elements.  
  Since index is zero-based, we add 1.

---

## Example Walkthrough

Input:

```text
[1, 1, 2]
```

Initial:

```text
index = 0
```

Step 1: `i = 1`

```text
array[1] == array[0] → duplicate → skip
```

Step 2: `i = 2`

```text
array[2] != array[0] → new value
index = 1
array[1] = 2
```

Array becomes:

```text
[1, 2, 2]
```

Return:

```text
2
```

Valid portion:

```text
[1, 2]
```

---

## Time Complexity Explanation

- Function definition → O(1)
- Null/empty check → O(1)
- Variable initialization → O(1)
- Loop through array → O(n)
- Comparison inside loop → O(1)
- Assignment inside loop → O(1)
- Return statement → O(1)

---

## Final Time Complexity

**Overall Time Complexity: O(n)**

Where:

- `n` = number of elements in the array

---

## Space Complexity

**O(1)**

- No additional data structures are used
- The array is modified in-place

---

## Key Insights

- The array being **sorted** is critical
- Duplicates are always adjacent
- Only one pass is needed
- Uses **two-pointer technique**
- No extra memory required

---

## Interview Thinking

When you see this problem, think:

- Is the array sorted?
- Can I avoid extra space?
- Can I overwrite values instead of deleting them?
- How do I track the last unique element?

Core pattern:

**Two pointers → read pointer + write pointer**

---

## Important Concept

- The array size does not change in Java
- Only the **first k elements** (returned length) matter
- Everything after that is irrelevant

---

## How to Explain in an Interview

“I use a two-pointer approach. One pointer tracks the last unique element, and the other scans the array. Since the
array is sorted, duplicates are adjacent. Whenever I find a new value, I move the write pointer forward and overwrite
that position. At the end, the write pointer gives me the number of unique elements.”