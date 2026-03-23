## Sum of Diagonal Elements in a 2D Array

### Explanation

- `public static int sumDiagonalElements(int[][] array)`  
  Defines a function that takes a 2D array as input and returns the sum of its diagonal elements.

- `int sum = 0;`  
  Initializes a variable to store the sum of diagonal elements.

- `int numRows = array.length;`  
  Gets the number of rows in the 2D array.

- `for (int i = 0; i < numRows; i++)`  
  Iterates through each row using index `i`.

- `sum += array[i][i];`  
  Accesses and adds the diagonal element at position `(i, i)` to the sum.  
  This works because diagonal elements have equal row and column indices.

- `return sum;`  
  Returns the final computed sum.

---

### Time Complexity Explanation

- `public static int sumDiagonalElements(int[][] array)`  
  O(1)

- `int sum = 0;`  
  O(1)

- `int numRows = array.length;`  
  O(1)

- `for (int i = 0; i < numRows; i++)`  
  O(n), where n = number of rows

- `sum += array[i][i];`  
  O(1)

- `return sum;`  
  O(1)

---

### Final Time Complexity

The loop runs `n` times, so:

**Overall Time Complexity: O(n)**

Where:

- n = number of rows in the 2D array

---

### Key Insight

- Diagonal elements follow the pattern `(i, i)`
- Only one element per row is accessed
- No need to traverse the entire matrix