package dk.learning.arrays.maang_coding_exercises;

/**
 * Given 2D array calculate the sum of diagonal elements.
 * <p>
 * Example
 * myArray2D= {{1,2,3},{4,5,6},{7,8,9}};
 * sumDiagonalElements(myArray2D) # 15
 * </p>
 *
 * @author David Kariuki
 */
public class SumOfDiagonalElementsOf2DArray {

    public static void main(String[] args) {

        int[][] myArray2D = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


    }

    /**
     * Calculate the sum of diagonal elements of 2D array
     *
     * @param array Array
     * @return Sum
     * Time complexity: O(n) - We need to iterate through the diagonal elements of the 2D array once, where n is the number of rows (or columns) in the array.
     */
    public static int sumDiagonalElements(int[][] array) { // ------------- O(1) Function definition

        int sum = 0; // ------------- O(1)
        int numRows = array.length; // ------------- O(1)

        for (int i = 0; i < numRows; i++) { // ------------- O(n)
            sum += array[i][i]; // ------------- O(1) Accessing the diagonal element at row i and column i, and adding it to the sum.
        }

        return sum; // ------------- O(1)
    }
}
