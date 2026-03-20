package dk.learning.arrays.maang_coding_exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Duplicate Number
 * <p>
 * Write a function which takes integer array as a parameter and returns a new integer array with unique elements. (remove duplicates)
 * </p>
 * Example
 * removeDuplicates({1, 1, 2, 2, 3, 4, 5})
 * Output : [1, 2, 3, 4, 5]
 * </p>
 */
public class RemoveDuplicatesInArray {

    public static void main(String[] args) {

        int[] array = {1, 1, 2, 2, 3, 4, 5};
        System.out.print("\nOriginal array : " + Arrays.toString(array));


        // Brute force solution
        System.out.println();
        System.out.println("\nBrute force solution");
        System.out.print("Initial array : " + Arrays.toString(array));
        int[] uniqueArray1 = removeDuplicatesBruteForce(array);
        System.out.print("\nUnique array : " + Arrays.toString(uniqueArray1));

        // Optimal solution
        System.out.println();
        System.out.println("\nOptimal solution");
        System.out.print("Initial array : " + Arrays.toString(array));
        int[] uniqueArray2 = removeDuplicatesOptimal(array);
        System.out.print("\nUnique array : " + Arrays.toString(uniqueArray2));
    }


    /**
     * Brute Force Solution : Finding unique elements using nested loops
     *
     * @param array Array
     * @return Unique Array
     * Time complexity: O(n^2) - We have two nested loops, where the outer loop iterates through each element of
     * the input array O(n) and, the inner loop also iterates through the remaining elements to check for
     * duplicates (O(n)). Therefore, the overall time complexity is O(n^2).
     * Space complexity: O(n) - We create a new array uniqueArray to store the unique elements. In the worst case, if all
     */
    public static int[] removeDuplicatesBruteForce(int[] array) {

        int length = array.length;
        int[] uniqueArray = new int[length];
        int index = 0;

        for (int i = 0; i < length; i++) {

            boolean isDuplicate = false;

            for (int j = i + 1; i < length; i++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                uniqueArray[index++] = array[i];
            }
        }

        return Arrays.copyOf(uniqueArray, index);
    }


    /**
     * Optimal Solution : Finding unique elements using LinkedHashSet
     *
     * @param nums Array
     * @return Unique Array
     * Time complexity: O(n) - We iterate through the input array once to add elements to the LinkedHashSet, and then
     * we iterate through the LinkedHashSet to create the result array. Both operations are linear in relation to
     * the number of elements in the input array.
     * Space complexity: O(n) - In the worst case, if all elements in the input array are unique, the LinkedHashSet
     * will contain all n elements,
     */
    public static int[] removeDuplicatesOptimal(int[] nums) {

        Set<Integer> uniqueValues = new LinkedHashSet<>();

        for (int num : nums) {
            uniqueValues.add(num);
        }

        int[] result = new int[uniqueValues.size()];
        int index = 0;

        for (int num : uniqueValues) {
            result[index++] = num;
        }

        return result;
    }
}
