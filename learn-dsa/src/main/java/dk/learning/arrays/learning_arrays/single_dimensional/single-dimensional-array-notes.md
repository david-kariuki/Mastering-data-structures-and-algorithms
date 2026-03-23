# 📘 DSA Notes: Single Dimensional Arrays

## 1. Introduction

A **single dimensional array** is a linear data structure that stores elements of the same type in contiguous memory
locations. Each element is accessed using an index, starting from 0.

Arrays provide fast access to elements but are less efficient for operations that require shifting elements, such as
insertion and deletion in the middle.

---

## 2. Time and Space Complexity

> ⚠️ Note: Complexity depends on *where* the operation is performed (end vs middle).

| Operation                             | Time Complexity | Space Complexity |
|---------------------------------------|-----------------|------------------|
| Creating an empty array               | O(1)            | O(n)             |
| Accessing a given cell                | O(1)            | O(1)             |
| Traversing a given array              | O(n)            | O(1)             |
| Searching (Linear Search)             | O(n)            | O(1)             |
| Inserting at end (if space available) | O(1)            | O(1)             |
| Inserting at beginning/middle         | O(n)            | O(1)             |
| Deleting from end                     | O(1)            | O(1)             |
| Deleting from beginning/middle        | O(n)            | O(1)             |

---

## 3. Key Insight (Interview Critical)

- Arrays are **fast for access** → O(1)
- Arrays are **slow for shifting operations** → O(n)
- The cost comes from **moving elements**, not the operation itself

---

## 4. Example Explanation

### Deletion (Middle Case)

If you delete an element at index `i`:

- All elements after `i` must shift left
- That is why it becomes **O(n)**

---

## 5. Key Takeaway

Single dimensional arrays are best used when:

- You need fast access by index
- The size is known or fixed

They are not ideal when:

- Frequent insertions/deletions are required
- Dynamic resizing is needed (use ArrayList instead)