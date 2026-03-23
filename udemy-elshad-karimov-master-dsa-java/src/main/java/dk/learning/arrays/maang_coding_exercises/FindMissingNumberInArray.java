package dk.learning.arrays.maang_coding_exercises;

/**
 * Missing Number
 * <p>
 * Write Java function called findMissingNumberInArray that takes an integer array containing n-1 unique elements from a range of 1 to n, with one missing number, and returns the missing number.
 * </p>
 * <p>
 * Example
 * myArray = {1,2,3,4,6}
 * findMissingNumberInArray(myArray, 6) // 5
 * </p>
 * <p>
 * Hint: Use the formula (n * (n + 1)) / 2 which  calculates the sum of the first n natural numbers.
 * </p>
 */
public class FindMissingNumberInArray {

    public static void main(String[] args) {

        int[] myArray = {1, 2, 3, 4, 6};
        int n = 6; // Target

        int missingNumber = findMissingNumberInArray(myArray, n); // 5
        System.out.print("\nMissing number is " + missingNumber);
    }

    /**
     * Find missing number in array
     *
     * @param array Array
     * @param n     Target
     * @return missing value
     * Time complexity: O(n) - Linear time, as we need to iterate through the entire array to calculate the sum of its elements.
     * Space complexity: O(1) - Constant space, as we are using only a fixed amount of extra space to store the expected sum and actual sum, regardless of the size of the input array.
     */
    public static int findMissingNumberInArray(int[] array, int n) {

        int expectedSum = (n * (n + 1)) / 2; // -------------------- O(1) - Constant time, as we are performing a fixed number of operations to calculate the expected sum of the first n natural numbers using the formula.
        int actualSum = 0; // -------------------- O(1) - Constant time, as we are simply initializing a variable to store the sum of the array elements.

        // Calculate current sum of the array
        for (int value : array) {
            actualSum += value; // -------------------- O(n) - Linear time, as we need to iterate through the entire array to calculate the sum of its elements.
        }

        System.out.print("\nCurrent sum : " + actualSum); // -------------------- O(1)
        System.out.print("\nFinal sum : " + expectedSum); // -------------------- O(1)

        return (expectedSum - actualSum); // -------------------- O(1)
    }
}
