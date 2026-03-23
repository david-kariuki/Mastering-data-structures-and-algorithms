# Find Minimum in Rotated Sorted Array

## Problem

A sorted array of unique integers is rotated at an unknown pivot.

Example:

```text
[10, 20, 30, 40, 50] → [30, 40, 50, 10, 20]
```

Find the **index of the minimum element** in the rotated array.

---

## Examples

```text
Input:  [30, 40, 50, 10, 20]
Output: 3
```

```text
Input:  [3, 5, 7, 11, 13, 17, 19, 2]
Output: 7
```

---

## Pattern Thinking

This is NOT normal binary search.

This is:

```text
Binary Search on Monotonic Condition (Boundary Search)
```

---

## Key Observation

The rotated array is divided into two sorted sections:

```text
[30, 40, 50]   [10, 20]
```

- Left section → values **greater than last element**
- Right section → values **less than or equal to last element**

---

## Core Idea

Compare every element to the **last element**.

```java
array[i]<=array[last]
```

This creates a monotonic pattern:

```text
false false false true true
```

---

## What We Are Really Solving

```text
Find the first index where condition becomes true
```

That index is the **minimum element**.

---

## Code

```java
public static int findMinRotated(int[] array) {

    int left = 0;
    int right = array.length - 1;
    int boundaryIndex = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (array[mid] <= array[array.length - 1]) {
            boundaryIndex = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return boundaryIndex;
}
```

---

## Step-by-Step Walkthrough

### Example

```text
[30, 40, 50, 10, 20]
```

Last element:

```text
20
```

---

### Convert to Boolean Pattern

| Index | Value | <= 20 ? |
|-------|-------|---------|
| 0     | 30    | false   |
| 1     | 40    | false   |
| 2     | 50    | false   |
| 3     | 10    | true    |
| 4     | 20    | true    |

```text
false false false true true
```

---

### Iteration 1

```text
left = 0
right = 4
mid = 2
value = 50
```

Check:

```text
50 <= 20 → false
```

Move right side:

```java
left =mid +1 →left =3
```

---

### Iteration 2

```text
left = 3
right = 4
mid = 3
value = 10
```

Check:

```text
10 <= 20 → true
```

Update:

```java
boundaryIndex =3
right =mid -1 →right =2
```

---

### Loop Ends

```text
left = 3
right = 2
```

Stop.

Return:

```text
3
```

---

## Why This Works

- The array is split into two monotonic regions
- We identify the region using the last element
- The minimum is the **first element of the second region**
- Binary search finds this boundary efficiently

---

## Important Behavior

### When condition is TRUE

```java
array[mid]<=
last element
```

- mid is in second section
- possible answer
- move left to find earlier occurrence

```java
right =mid -1;
```

---

### When condition is FALSE

```java
array[mid]>
last element
```

- mid is in first section
- minimum must be to the right

```java
left =mid +1;
```

---

## Edge Case

If array is not rotated:

```text
[10, 20, 30, 40, 50]
```

All values satisfy:

```text
<= last element
```

```text
true true true true true
```

Binary search returns:

```text
index 0
```

Correct.

---

## Time Complexity

O(log n)

- search space is halved every step

---

## Space Complexity

O(1)

- only a few variables used

---

## Interview Thinking

When you see:

- rotated sorted array
- minimum or pivot
- sorted but broken

Think:

```text
convert problem to monotonic condition
```

Then:

```text
find first true (boundary)
```

---

## Core Pattern

```text
condition(i) = array[i] <= array[last]
```

Binary search:

- false → go right
- true → record answer and go left

---

## Final Takeaway

- This is a boundary detection problem
- The minimum is the first value in the second sorted section
- Binary search works because the condition is monotonic
- Think in terms of "first true", not "find value"