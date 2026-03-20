# Remove Duplicates in Array

## Problem

Write a function which takes an integer array as a parameter and returns a new integer array with unique elements (
remove duplicates).

### Example

```java
removeDuplicates( {
    1, 1, 2, 2, 3, 4, 5
})
```

Output:

```java
[1,2,3,4,5]
```

---

## Problem Understanding

- Input: integer array (can contain duplicates)
- Output: new array with only unique elements
- Order: based on the example, **original order should be preserved**

---

## Key Pattern

This is a **duplicate detection problem**.

The core question becomes:

- Have I seen this value before?
- Or will I see this value again later?

There are two main ways to think about this:

1. Look **ahead** → check if a value appears again later (brute force)
2. Look **behind / track state** → check if a value has been seen before (optimal)

---

## Approach 1: Brute Force (Nested Loops)

### Idea

For each element:

- Check whether it appears again later in the array
- If it does, skip it
- If it does not, keep it

This approach keeps the **last occurrence** of each value.

---

### Java Code

```java
import java.util.Arrays;

public class RemoveDuplicatesInArray {

    public static int[] removeDuplicatesBruteForce(int[] array) {
        int length = array.length;
        int[] uniqueArray = new int[length];
        int index = 0;

        for (int i = 0; i < length; i++) {
            boolean isDuplicate = false;

            for (int j = i + 1; j < length; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                uniqueArray[index++] = array[i];
            }
        }

        return Arrays.copyOf(uniqueArray, index);
    }
}
```

---

### Example Walkthrough

Input:

```text
{1, 1, 2, 2, 3, 4, 5}
```

Process:

- First `1` → found again later → skip
- Second `1` → no duplicate later → keep
- First `2` → found again later → skip
- Second `2` → no duplicate later → keep
- `3` → no duplicate → keep
- `4` → no duplicate → keep
- `5` → no duplicate → keep

Output:

```text
[1, 2, 3, 4, 5]
```

---

### Time Complexity

- Outer loop → O(n)
- Inner loop → O(n) in worst case

**Overall Time Complexity: O(n²)**

---

### Space Complexity

- Temporary array → O(n)
- Final copied array → O(n)

**Overall Space Complexity: O(n)**

---

### Key Insights

- Simple and does not require extra data structures like sets
- Works by comparing elements manually
- Keeps the **last occurrence** of duplicates
- Inefficient for large datasets due to nested loops

---

## Approach 2: Optimal (Using LinkedHashSet)

### Idea

Use a data structure that:

- automatically removes duplicates
- preserves insertion order

A `LinkedHashSet` satisfies both.

---

### Java Code

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesInArray {

    public static int[] removeDuplicatesOptimal(int[] nums) {

        Set<Integer> uniqueValues = new LinkedHashSet<>();

        for (int num : nums) {
            uniqueValues.add(num);
        }

        int[] result = new int[uniqueValues.size()];
        int index = 0;

        for (int num : uniqueValues) {
            result[index++] = num;
        }

        return result;
    }
}
```

---

### Example Walkthrough

Input:

```text
{1, 1, 2, 2, 3, 4, 5}
```

Process:

- Add `1` → stored
- Add `1` → ignored (duplicate)
- Add `2` → stored
- Add `2` → ignored
- Add `3` → stored
- Add `4` → stored
- Add `5` → stored

Output:

```text
[1, 2, 3, 4, 5]
```

---

### Time Complexity

- Loop through array → O(n)
- Insert into set → O(1) average per operation
- Loop through set → O(n)

**Overall Time Complexity: O(n)**

---

### Space Complexity

- LinkedHashSet → O(n)
- Result array → O(n)

**Overall Space Complexity: O(n)**

---

### Key Insights

- Uses extra space to improve performance
- Preserves original order
- Keeps the **first occurrence** of each element
- Much more efficient than brute force for large inputs

---

## Brute Force vs Optimal

| Approach      | Time Complexity | Space Complexity | Behavior               |
|---------------|-----------------|------------------|------------------------|
| Brute Force   | O(n²)           | O(n)             | Keeps last occurrence  |
| LinkedHashSet | O(n)            | O(n)             | Keeps first occurrence |

---

## Interview Thinking

When you see this problem, think step by step:

1. What is the real problem?
    - Removing duplicates → duplicate detection

2. What are the constraints?
    - Do I need to preserve order?

3. What is the simplest solution?
    - Nested loops

4. What is the bottleneck?
    - Repeated scanning → O(n²)

5. How do I optimize?
    - Use a structure for fast lookup → Set

---

## Core Patterns

- Duplicate detection → think **Set**
- Nested loops → baseline / brute force
- Tradeoff → **time vs space**

---

## Important Observations

- Brute force checks:
    - “Does this value appear again later?”

- Optimal solution checks:
    - “Have I seen this value before?”

- These are two different ways of thinking about the same problem

---

## How to Explain in an Interview

Brute Force:

“I iterate through each element and check if it appears again later in the array. If it does, I skip it. If not, I
include it in the result. This works but has O(n²) time complexity due to nested loops.”

Optimal:

“I treat this as a duplicate detection problem. I use a LinkedHashSet to store elements because it removes duplicates
automatically while preserving insertion order. Then I convert the set back into an array. This reduces the time
complexity to O(n) at the cost of extra space.”

---

## Final Takeaway

- Always start with brute force to understand the problem
- Then identify the inefficiency (nested loops)
- Then optimize using the right data structure
- In interviews, explaining the transition is just as important as the final solution