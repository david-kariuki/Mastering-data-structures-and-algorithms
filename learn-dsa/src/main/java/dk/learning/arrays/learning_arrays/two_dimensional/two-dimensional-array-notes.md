# Two Dimensional Arrays (2D Arrays)

## 1. Introduction

A two dimensional array is a data structure that stores elements in a tabular format using rows and columns.

Each element is accessed using two indices:

- Row index (i)
- Column index (j)

General representation:
a[i][j]

---

## 2. Representation

A 2D array can be visualized as a grid or matrix.

Example:

[0]  1 33 55  
[1]  5 4 10  
[2]  24 50 37

Each row represents a separate array, and each column represents a position within that row.

---

## 3. Declaration, Instantiation, and Initialization

Declaration:
Defines the reference of the array.

Instantiation:
Allocates memory for rows and columns.

Initialization:
Assigns values to each position.

A 2D array is created with a fixed number of rows and columns, and this size cannot change after creation.

---

## 4. Memory Representation

In Java, a 2D array is not stored as a single continuous block.

Instead, it is an array of arrays:

- The main array stores references to row arrays
- Each row is stored separately in memory

This means:

- Rows can be independent
- Lengths can vary (jagged arrays)

---

## 5. Real World Understanding

A 2D array can represent structured data such as:

- Daily reports
- Student marks
- Sales data
- Game boards

Think of:

- Rows as records (e.g. days)
- Columns as attributes (e.g. values per day)

---

## 6. Traversal

Traversal means visiting every element in the array.

This is done using nested loops:

- Outer loop → rows
- Inner loop → columns

Time Complexity:
O(m × n), where m = rows and n = columns

---

## 7. Core Operations

### Instantiating

Creating the array with fixed size.
Time: O(1)
Space: O(m × n)

---

### Initializing

Assigning values to each cell.
Time depends on number of elements

---

### Inserting

Updating a specific position in the array.
Time: O(1)

---

### Accessing

Retrieving a value using row and column index.
Time: O(1)

---

### Traversing

Visiting all elements in the array.
Time: O(m × n)

---

### Searching

Finding a value by checking each element.

Since there is no direct lookup:

- Every cell must be checked

Time: O(m × n)
Space: O(1)

---

### Deleting

Arrays have fixed size, so deletion does not remove a cell.

Instead:

- The value is replaced (commonly with a placeholder)

Time: O(1)

---

## 8. Time and Space Complexity

Let:
m = number of rows
n = number of columns

 Operation      | Time Complexity | Space Complexity 
----------------|-----------------|------------------
 Create array   | O(1)            | O(m × n)         
 Access element | O(1)            | O(1)             
 Traverse array | O(m × n)        | O(1)             
 Search value   | O(m × n)        | O(1)             
 Insert value   | O(1)            | O(1)             
 Delete value   | O(1)            | O(1)             

---

## 9. Key Characteristics

- Uses two indices
- Stored as array of arrays in Java
- Fixed size after creation
- Efficient for direct access
- Not efficient for dynamic operations

---

## 10. When to Use

- When data is naturally tabular
- When fast access is required
- When size is known in advance

---

## 11. When to Avoid

- When frequent insertions or deletions are needed
- When dynamic resizing is required
- When memory flexibility is important

---

## 12. Key Insight

A 2D array is best understood as a grid:

- Rows → horizontal grouping
- Columns → vertical positioning

Most problems involve:

- Traversing the grid
- Checking neighbors
- Applying patterns on rows and columns