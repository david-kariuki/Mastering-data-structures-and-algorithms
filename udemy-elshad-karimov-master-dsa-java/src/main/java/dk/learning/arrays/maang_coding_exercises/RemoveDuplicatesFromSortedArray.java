package dk.learning.arrays.maang_coding_exercises;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns
 * the new length. Do not allocate extra space for another array; you must do this by modifying the input
 * array in-place with O(1) extra memory.
 * <p>
 * Example:
 * Input: nums = [1, 1, 2]
 * Output: 2
 *
 * @author David Kariuki
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] array = new int[]{1, 1, 2,};

        System.out.println();
        System.out.println("\nSize after removing duplicates : " + removeDuplicates(array));
    }

    /**
     * Remove duplicates from a sorted array in-place and return the new length of the array after duplicates
     * have been removed.
     *
     * @param array Array
     * @return New length of the array after duplicates have been removed.
     * Time Complexity: O(n) where n is the length of the input array.
     * Space Complexity: O(1) since we are modifying the input array in-place and not using any additional
     * data structures.
     */
    public static int removeDuplicates(int[] array) {
        if (array == null || array.length == 0) { // -------------- O(1)
            return 0; // ---------------- O(1)
        }

        int index = 0; // ---------------- O(1)
        for (int i = index + 1; i < array.length; i++) {    // ---------------- O(n)
            if (array[i] == array[index]) {                 // -------------- O(1)
                array[i] = array[index];                    // -------------- O(1)
                index++;                                    // ---------------- O(1)
            }
        }

        System.out.println(Arrays.toString(array));         // ---------------- O(n)
        return index + 1;                                   // ---------------- O(1)
    }
}
