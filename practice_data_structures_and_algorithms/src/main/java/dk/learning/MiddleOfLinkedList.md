# Middle of a Linked List

## Problem

Find the middle node of a singly linked list.

- If the number of nodes is **odd**, return the exact middle node
- If the number of nodes is **even**, return the **second middle node**

---

## Examples

```
Input:  0 → 1 → 2 → 3 → 4
Output: 2
```

```
Input:  0 → 1 → 2 → 3 → 4 → 5
Output: 3
```

---

## Approach: Fast and Slow Pointers

Use two pointers:

- `slow` → moves one step at a time
- `fast` → moves two steps at a time

When `fast` reaches the end, `slow` will be at the middle.

---

## Code

```java
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public static int middleOfLinkedList(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }

    return slow.value;
}
```

---

## Step-by-Step Walkthrough (Odd Length)

```
0 → 1 → 2 → 3 → 4
```

### Start

```
slow = 0
fast = 0
```

### Iteration 1

```
slow → 1
fast → 2
```

### Iteration 2

```
slow → 2
fast → 4
```

### Stop Condition

- `fast.next == null` → cannot move further

### Result

```
slow = 2 (middle)
```

---

## Step-by-Step Walkthrough (Even Length)

```
0 → 1 → 2 → 3 → 4 → 5
```

### Start

```
slow = 0
fast = 0
```

### Iteration 1

```
slow → 1
fast → 2
```

### Iteration 2

```
slow → 2
fast → 4
```

### Iteration 3

```
slow → 3
fast → null
```

### Result

```
slow = 3 (second middle)
```

---

## Why This Works

- `fast` moves twice as fast as `slow`
- When `fast` reaches the end of the list
- `slow` has only covered half the distance

Halfway through the list = middle

---

## Loop Condition

```java
while(fast !=null&&fast.next !=null)
```

This ensures:

- `fast` exists
- `fast.next` exists

So that:

```java
fast =fast.next.next;
```

does not cause a null pointer error

---

## Time Complexity

O(n)

- We traverse the list once

---

## Space Complexity

O(1)

- Only two pointers are used

---

## Alternative Approach (Not Preferred)

1. Count total nodes
2. Traverse again to middle

Time complexity: O(n) + O(n) = O(n)

But requires two passes

---

## Why Fast/Slow is Better

- Single pass
- Cleaner logic
- Standard interview pattern

---

## Key Insight

This is a classic **two pointer technique**

---

## Interview Thinking

When you see:

- Linked list
- Need middle node
- One pass required

Think:

```
slow → 1 step
fast → 2 steps
```

---

## Core Pattern

Fast and slow pointers are used for:

- Finding middle of list
- Detecting cycles
- Finding start of cycle
- Finding kth node from end

---

## Mental Model

Think of it as a race:

- slow walks
- fast runs

When fast reaches the end,
slow is at the middle