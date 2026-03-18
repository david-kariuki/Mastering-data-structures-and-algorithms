package dk.learning.arrays.single_dimensional;

public class SingleDimensionalArray {

    int[] arr = null;

    public SingleDimensionalArray(int sizeOfArray) {
        arr = new int[sizeOfArray];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
        System.out.println("Array of size " + sizeOfArray + " is created!");    // ------------------ O(1)
        System.out.println("Array : " + arr);                                   // ------------------ O(1)
    }

    /**
     * Inserts value to the array at given location if the location is not already occupied.
     *
     * @param location          Index
     * @param valueToBeInserted Value
     *                          Time complexity: O(1)
     */
    public void insert(int location, int valueToBeInserted) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {               // ------------------ O(1)
                arr[location] = valueToBeInserted;                  // ------------------ O(1)
                System.out.println("Inserted value " + valueToBeInserted + " at location " + location); // ------------------ O(1)
            } else {
                System.out.println("Cell is already occupied!");    // ------------------ O(1)
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!");   // ------------------ O(1)
        }
    }

    /**
     * Traverses the array and prints each element.
     * Time complexity: O(n)
     */
    public void traverseArray() {
        try {
            for (int i = 0; i < arr.length; i++) {      // ------------------ O(n)
                System.out.print(arr[i] + " ");         // ------------------ O(1)
            }
        } catch (Exception e) {
            System.out.println("Array no longer exists! -> Error : " + e.getMessage()); // ------------------ O(1)
        }
    }

    /**
     * Searches for a value in the array and prints its index if found.
     *
     * @param valueToSearch Value
     *                      Time complexity: O(n)
     *                      Space complexity: O(1) - Extra memory not required to perform this operation
     */
    public void searchInArray(int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {      // ------------------ O(n)
            if (arr[i] == valueToSearch) {          // ------------------ O(1)
                System.out.println("Value " + valueToSearch + " found at index " + i); // ------------------ O(1)
                return;                             // ------------------ O(1)
            }
        }
        System.out.println("Value " + valueToSearch + " not found!");
    }
}
