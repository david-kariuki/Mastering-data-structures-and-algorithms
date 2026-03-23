# Find Boundary (First True in Boolean Array)

## Problem

Given a boolean array where all `false` values appear before `true` values, find the index of the **first `true` element
**.

---

## Examples

```text
Input:  [false, false, true, true, true]
Output: 2
```

```text
Input:  [false, false, false]
Output: -1
```

```text
Input:  [true, true, true]
Output: 0
```

---

## Pattern Thinking

This is a classic:

```text
Binary Search on Monotonic Condition
```

---

## Key Observation

The array follows a monotonic pattern:

```text
false false false true true true
```

This means:

- once `true` starts
- it remains `true` for the rest of the array

---

## Core Idea

We are not searching for a value.

We are searching for:

```text
the first index where value becomes true
```

---

## Code

```java
public static int findBoundary(boolean[] array) {

    int left = 0;
    int right = array.length - 1;
    int boundaryIndex = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (array[mid]) {
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
[false, false, false, true, true, true]
```

---

### Iteration 1

```text
left = 0
right = 5
mid = 2
value = false
```

Since:

```text
false → go right
```

```java
left =mid +1 →left =3
```

---

### Iteration 2

```text
left = 3
right = 5
mid = 4
value = true
```

Since:

```text
true → possible answer
```

Update:

```java
boundaryIndex =4
right =mid -1 →right =3
```

---

### Iteration 3

```text
left = 3
right = 3
mid = 3
value = true
```

Again:

```text
true → better candidate
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

The array has a **clear transition point**:

```text
false → true
```

Binary search finds this transition efficiently.

---

## Behavior Summary

### When value is TRUE

```java
if(array[mid])
```

- we found a candidate
- but we want the **first occurrence**
- so we move left

```java
right =mid -1;
```

---

### When value is FALSE

```java
else
```

- still in the false region
- boundary must be to the right

```java
left =mid +1;
```

---

## Edge Cases

### All false

```text
[false, false, false]
```

- never enters true branch
- `boundaryIndex` remains `-1`

Return:

```text
-1
```

---

### All true

```text
[true, true, true]
```

- keeps updating boundary
- moves left until first index

Return:

```text
0
```

---

## Time Complexity

O(log n)

- search space is halved every iteration

---

## Space Complexity

O(1)

- constant extra space used

---

## Interview Thinking

When you see:

- boolean condition
- false then true
- transition point

Think:

```text
Find first true
```

---

## Core Pattern

```text
false false false true true true
```

Binary search logic:

- false → go right
- true → record answer and go left

---

## Final Takeaway

- This is the foundation of advanced binary search
- Many problems reduce to "find first true"
- Always think in terms of monotonic conditions
- This pattern appears in many interview problems