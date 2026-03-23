# Two Sum

## Problem

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up
to the target.

You may assume that:

- each input has exactly one solution
- you may not use the same element twice

---

## Example

```java
nums =[2,7,11,15]
target =9
```

Output:

```text
[0, 1]
```

Explanation:

```text
nums[0] + nums[1] = 2 + 7 = 9
```

---

## Pattern Thinking

When you see this problem, possible patterns to think about are:

- Brute Force
- Two Pointers
- Hash Map
- Binary Search

The best pattern here is:

```text
Hash Map
```

Why?

Because for each number, we want to quickly check whether the value needed to reach the target has already been seen.

That needed value is called the **complement**.

---

## Core Idea

For each number:

1. Calculate its complement

```text
complement = target - current number
```

2. Check whether that complement has already been seen
3. If yes, return the two indices
4. If no, store the current number and its index in the map

This works well because a hash map gives near O(1) lookup time.

---

## Code

```java
public static int[] twoSum(int[] array, int target) {

    Map<Integer, Integer> numToIndex = new HashMap<>();

    for (int i = 0; i < array.length; i++) {
        int num = array[i];
        int complement = target - num;

        if (numToIndex.containsKey(complement)) {
            return new int[]{numToIndex.get(complement), i};
        }

        numToIndex.put(num, i);
    }

    return new int[]{};
}
```

---

## Step-by-Step Walkthrough

### Example 1

```java
array =[2,7,11,15]
target =9
```

---

### Start

Create a map:

```java
Map<Integer, Integer> numToIndex = new HashMap<>();
```

This map stores:

```text
number → index
```

Initially:

```text
{}
```

---

### Iteration 1

```java
i =0
num =2
complement =9-2=7
```

Check if `7` is already in the map:

```text
No
```

So store `2` and its index:

```text
{2=0}
```

---

### Iteration 2

```java
i =1
num =7
complement =9-7=2
```

Check if `2` is already in the map:

```text
Yes
```

Map contains:

```text
2=0
```

So return:

```java
new int[]{0,1}
```

That means:

```text
array[0] + array[1] = 2 + 7 = 9
```

We stop immediately once the pair is found.

---

## Another Example

```java
array =[3,2,4]
target =6
```

---

### Iteration 1

```java
i =0
num =3
complement =3
```

Map does not contain `3` yet.

Store:

```text
{3=0}
```

---

### Iteration 2

```java
i =1
num =2
complement =4
```

Map does not contain `4`.

Store:

```text
{3=0, 2=1}
```

---

### Iteration 3

```java
i =2
num =4
complement =2
```

Map contains `2=1`

Return:

```java
new int[]{1,2}
```

Because:

```text
array[1] + array[2] = 2 + 4 = 6
```

---

## Why We Check Before Putting

Notice this order:

```java
if(numToIndex.containsKey(complement)){
        return new int[]{numToIndex.

get(complement),i};
        }

        numToIndex.

put(num, i);
```

This is important.

We check for the complement **before** storing the current number so that we do not use the same element twice.

---

## Why This Works

At every step, the map contains numbers we have already seen.

So when we are at the current number:

- we ask, "Have I already seen the number that would complete the target?"
- if yes, we are done
- if no, we store the current number for future checks

This turns the problem from repeated searching into quick lookup.

---

## Time Complexity

O(n)

Why?

- We traverse the array once
- Each hash map lookup is O(1) on average
- Each hash map insert is O(1) on average

So overall:

```text
O(n)
```

---

## Space Complexity

O(n)

Why?

- In the worst case, we may store almost every element in the hash map

So overall:

```text
O(n)
```

---

## Brute Force Comparison

A brute force solution would use nested loops:

- pick one number
- compare with every other number
- check whether the sum equals target

That would take:

```text
O(n²)
```

The hash map improves this to:

```text
O(n)
```

---

## Interview Thinking

When you see:

- find two numbers
- target sum
- return indices

Think:

```text
complement lookup
```

Ask yourself:

- for the current number, what value do I need to reach the target?
- have I already seen that value?

That usually points to:

```text
Hash Map
```

---

## Core Pattern

```text
target - currentValue = complement
```

Then:

- check if complement exists
- if yes, return indices
- if no, store current value

---

## Key Insight

This problem is not really about adding all pairs.

It is about:

```text
remembering what you have seen so far
```

That is why the hash map is so effective.

---

## Final Takeaway

- Two Sum is a classic hash map problem
- The key idea is complement lookup
- Check first, then store
- Hash map reduces the problem from O(n²) to O(n)