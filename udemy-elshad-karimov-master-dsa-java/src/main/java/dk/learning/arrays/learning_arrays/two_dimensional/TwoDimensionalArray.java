package dk.learning.arrays.learning_arrays.two_dimensional;

import java.util.Arrays;

public class TwoDimensionalArray {

    int[][] arr = null;

    public TwoDimensionalArray(int numberOfRows, int numberOfColumns) {

        arr = new int[numberOfRows][numberOfColumns]; // Instantiate

        // Initialize array
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                arr[row][column] = Integer.MIN_VALUE;
            }
        }
    }

    /**
     * Insert value in array
     *
     * @param rowIndex    Row
     * @param columnIndex Column
     * @param value       Value
     *                    Time complexity: O(1) - Constant time, as we are directly accessing the cell using row and column indices.
     *                    Space complexity: O(1) - No additional space is used, as we are modifying the existing array in place.
     */
    public void insertValueInTheArray(int rowIndex, int columnIndex, int value) {

        try {

            if (arr[rowIndex][columnIndex] == Integer.MIN_VALUE) {  // ------------- O(1)
                arr[rowIndex][columnIndex] = value;     // ------------- O(1)
                System.out.println("Inserted value " + value + " into the array");  // ------------- O(1)
            } else {
                System.out.println("Cell already occupied");  // ------------- O(1)
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds for 2D array!");  // ------------- O(1)
        }
    }

    /**
     * Access cell value
     *
     * @param rowIndex Row
     * @param colIndex Column
     *                 Time complexity: O(1) - Constant time, as we are directly accessing the cell using row and column indices.
     *                 Space complexity: O(1) - No additional space is used, as we are simply retrieving the value from the existing array.
     */
    public void accessCell(int rowIndex, int colIndex) {
        try {
            System.out.println("Cell value at row " + rowIndex + " and column " + colIndex + " is " + arr[rowIndex][colIndex]); // ------------- O(1)
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds for 2D array!"); // ------------- O(1)
        }
    }

    /**
     * Traverse 2D array
     * Time complexity: O(mn) - where m is the number of rows and n is the number of columns, as we need to visit each cell in the 2D array.
     * Space complexity: O(1) - No additional space is used, as we are simply printing the values from the existing array without using any extra data structures.
     */
    public void traverse2DArray() {
        for (int row = 0; row < arr.length; row++) { // ------------- O(m)
            for (int column = 0; column < arr[row].length; column++) { // ------------- O(n)
                System.out.print(arr[row][column] + " "); // ------------- O(1)
            }
            System.out.println(); // ------------- O(1)
        }
    }

    /**
     * Search for a value in the 2D array
     *
     * @param value Value to search
     *              Time complexity: O(mn) - where m is the number of rows and n is the number of columns, as we may need to check each cell in the worst case.
     *              Space complexity: O(1) - No additional space is used, as we are simply checking the values in the existing array without using any extra data structures.
     */
    public void searchElementInArray(int value) {
        for (int row = 0; row < arr.length; row++) { // ------------- O(m)
            for (int col = 0; col < arr[row].length; col++) { // ------------- O(n)
                if (arr[row][col] == value) { // ------------- O(1)
                    System.out.print("The value " + value + " is in the array at row " + row + " and column " + col); // ------------- O(1)
                    return; // Exit the method once the value is found ------------- O(1)
                }
            }
        }
        System.out.print("Value was not found in the array!"); // ------------- O(1)
    }

    /**
     * Delete value in the 2D array
     * <p>
     * Time complexity: O(1) - Constant time, as we are directly accessing the cell using row and column indices to delete the value.
     * Space complexity: O(1) - No additional space is used, as we are simply modifying the existing array in place without using any extra data structures.
     */
    public void deleteElementInArray(int row, int column) {
        try {
            System.out.println("Array before deletion: " + Arrays.deepToString(arr)); // ------------- O(1)
            arr[row][column] = Integer.MIN_VALUE; // ------------- O(1)
            System.out.println("Deleted element from the array at row " + row + " and column " + column); // ------------- O(1)
            System.out.println("Array after deletionf: " + Arrays.deepToString(arr)); // ------------- O(1)
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds for 2D array!"); // ------------- O(1)
        }
    }
}
