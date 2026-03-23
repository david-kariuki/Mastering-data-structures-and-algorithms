package dk.learning.arrays.maang_coding_exercises;

import java.util.Arrays;

/**
 * Write a function called middle that takes an array and returns a new array that contains all but the first
 * and last elements.
 * <code>
 * </>myArray = [1, 2, 3, 4]
 * middle(myArray)  # [2,3]
 * </p>
 *
 * @author David Kariuki
 */
public class MiddleFunction1DArray {

    public static void main(String[] args) {

        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        System.out.println("\nArray before middle operation is : " + Arrays.toString(array));
        System.out.println("\nMiddle array is : " + Arrays.toString(middleArray(array)));
    }

    /**
     * Find middle array
     *
     * @param array Array
     * @return New Array
     * Time complexity: O(n) - We need to iterate through the input array once to copy the middle elements to the new array.
     * Space complexity: O(n) - We are creating a new array to hold the middle elements, which requires additional space proportional to the size of the input array (minus 2).
     */
    public static int[] middleArray(int[] array) {
        if (array.length <= 2) {
            return new int[0]; // Return an empty array if the input array has 2 or fewer elements
        }

        // Create a new array with a size of the input array length minus 2
        int[] middleArray = new int[array.length - 2];

        // Copy the elements from the input array, excluding the first and last elements
        int index = 1;
        while (index < array.length - 1) {
            middleArray[index - 1] = array[index];
            index++;
        }

        return middleArray;
    }

    /**
     Here's a brief explanation of what each part of the code does:


     public static int[] middle(int[] array) {: This line defines the middle function, which takes an integer array as input and returns a new integer array containing all elements except the first and last elements.

     if (array.length <= 2) {: This line checks if the input array has 2 or fewer elements.

     return new int[0];: If the input array has 2 or fewer elements, this line returns an empty integer array.

     int[] middleArray = new int[array.length - 2];: This line creates a new integer array named middleArray with a length equal to the input array length minus 2.

     int index = 1;: This line initializes the index variable to 1.

     while (index < array.length - 1) {: This line starts a while loop that iterates from index 1 to index array.length - 2 of the input array.

     middleArray[index - 1] = array[index];: This line copies the current element from the input array to the middleArray, excluding the first and last elements.

     index++;: This line increments the index variable by 1.

     return middleArray;: This line returns the middleArray, which contains all elements of the input array except the first and last elements.

     Time complexity explanation

     In the provided middle function, the time complexity is determined by the loop that iterates through the elements of the input array.



     public static int[] middle(int[] array) {: Time complexity is O(1) as it defines the function.

     if (array.length <= 2) {: Time complexity is O(1) as it performs a single comparison.

     return new int[0];: Time complexity is O(1) as it returns an empty array.

     int[] middleArray = new int[array.length - 2];: Time complexity is O(1) as it allocates memory for the new array.

     int index = 1;: Time complexity is O(1) as it initializes the index variable.

     while (index < array.length - 1) {: The time complexity of the loop itself is O(n-2) because it iterates from index 1 to index array.length - 2 of the input array. However, the loop's time complexity will be dominated by the operations inside the loop.

     middleArray[index - 1] = array[index];: Time complexity is O(1) as it performs a single assignment operation.

     index++;: Time complexity is O(1) as it increments the index variable by 1.

     return middleArray;: Time complexity is O(1) as it returns the middleArray.

     In summary, the time complexity of the middle function is determined by the loop, which has a time complexity of O(n-2). Since we're looking at the overall time complexity and we usually ignore constants, the time complexity of the middle function can be considered O(n), where n is the length of the input array.
     */
}
