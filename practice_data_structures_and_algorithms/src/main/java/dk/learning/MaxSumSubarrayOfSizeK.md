# Maximum Sum Subarray of Size K

## Problem

Given an array of integers `nums` consisting of only non-negative values, find the maximum sum among all contiguous
subarrays of size `k`.

---

## Example

```java
nums =[1,2,3,7,4,1]
k =3
```

Subarrays of size `3`:

```text
[1, 2, 3] → sum = 6
[2, 3, 7] → sum = 12
[3, 7, 4] → sum = 14
[7, 4, 1] → sum = 12
```

Output:

```text
14
```

---

## Approach

This is a **fixed size sliding window** problem.

Instead of recalculating the sum of every subarray from scratch, we:

- calculate the first window sum
- slide the window one step at a time
- subtract the element leaving the window
- add the element entering the window
- keep track of the largest sum seen so far

---

## Code

```java
private static int maxSumSubarrayOfSizeK(int[] nums, int k) {
    int windowSum = 0;

    for (int i = 0; i < k; i++) {
        windowSum += nums[i];
    }

    int largestSum = windowSum;

    for (int right = k; right < nums.length; right++) {
        int left = right - k;
        windowSum -= nums[left];
        windowSum += nums[right];
        largestSum = Math.max(largestSum, windowSum);
    }

    return largestSum;
}
```

---

## Step 1: Calculate the First Window Sum

```java
int windowSum = 0;

for(
int i = 0;
i<k;i++){
windowSum +=nums[i];
        }
```

This calculates the sum of the first `k` elements.

For:

```java
nums =[1,2,3,7,4,1]
k =3
```

The first window is:

```text
[1, 2, 3]
```

So:

```text
windowSum = 1 + 2 + 3 = 6
```

---

## Step 2: Initialize the Largest Sum

```java
int largestSum = windowSum;
```

At this point:

```text
largestSum = 6
```

We use the first window as the initial best answer.

---

## Step 3: Slide the Window

```java
for(int right = k;
right<nums.length;right++){
int left = right - k;
windowSum -=nums[left];
windowSum +=nums[right];
largestSum =Math.

max(largestSum, windowSum);
}
```

Now we move the window one step at a time.

- `right` points to the new element entering the window
- `left` points to the element leaving the window

---

## Step-by-Step Walkthrough

### Initial Window

```text
[1, 2, 3]
windowSum = 6
largestSum = 6
```

---

### Iteration 1

```java
right =3
left =right -k =3-3=0
```

Element leaving:

```text
nums[left] = nums[0] = 1
```

Element entering:

```text
nums[right] = nums[3] = 7
```

Update:

```text
windowSum = 6 - 1 + 7 = 12
largestSum = max(6, 12) = 12
```

New window:

```text
[2, 3, 7]
```

---

### Iteration 2

```java
right =4
left =4-3=1
```

Element leaving:

```text
nums[1] = 2
```

Element entering:

```text
nums[4] = 4
```

Update:

```text
windowSum = 12 - 2 + 4 = 14
largestSum = max(12, 14) = 14
```

New window:

```text
[3, 7, 4]
```

---

### Iteration 3

```java
right =5
left =5-3=2
```

Element leaving:

```text
nums[2] = 3
```

Element entering:

```text
nums[5] = 1
```

Update:

```text
windowSum = 14 - 3 + 1 = 12
largestSum = max(14, 12) = 14
```

New window:

```text
[7, 4, 1]
```

---

## Final Result

```java
return largestSum;
```

At the end:

```text
largestSum = 14
```

So the answer is:

```text
14
```

---

## Why This Works

Each new window overlaps heavily with the previous one.

For example:

```text
[1, 2, 3]
[2, 3, 7]
```

The second window already contains most of the first window.

So instead of recalculating the full sum again, we only:

- remove the value that left
- add the value that entered

That is what makes sliding window efficient.

---

## Time Complexity

O(n)

- The first loop runs `k` times
- The second loop runs `n - k` times
- Together this is linear

---

## Space Complexity

O(1)

- Only a few variables are used:
    - `windowSum`
    - `largestSum`
    - `left`
    - `right`

---

## Interview Thinking

When you see:

- contiguous subarray
- fixed size `k`
- sum / max / min

Think:

```text
fixed size sliding window
```

Ask yourself:

- what is leaving the window?
- what is entering the window?
- can I update the result instead of recalculating everything?

---

## Core Pattern

For fixed size sliding window:

1. Calculate the first window
2. Slide the window one step at a time
3. Remove outgoing value
4. Add incoming value
5. Update the answer

---

## Final Takeaway

- This problem is about avoiding repeated work
- Sliding window turns repeated subarray sum calculation into a linear solution
- The key idea is:
    - subtract the outgoing value
    - add the incoming value