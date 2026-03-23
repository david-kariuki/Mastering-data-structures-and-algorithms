package dk.learning.binary_search;

/**
 * Find Minimum in Rotated Sorted Array
 *
 * <p>A sorted array of unique integers is rotated at an unknown pivot. For example,
 * {@code [10, 20, 30, 40, 50]} can become {@code [30, 40, 50, 10, 20]}.</p>
 *
 * <p>Find the index of the minimum element in the rotated array.</p>
 *
 * <p><b>Examples:</b></p>
 *
 * <pre>
 * Input: [30, 40, 50, 10, 20]
 * Output: 3
 * Explanation: The smallest element is 10, and its index is 3.
 *
 * Input: [3, 5, 7, 11, 13, 17, 19, 2]
 * Output: 7
 * Explanation: The smallest element is 2, and its index is 7.
 * </pre>
 *
 * @author David Kariuki
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {

        int[] array1 = {30, 40, 50, 10, 20};
        int result = findMinRotated(array1);
        System.out.println(result); // 3

        int[] array2 = new int[]{3, 5, 7, 11, 13, 17, 19, 2};
        result = findMinRotated(array2);
        System.out.println(result); // 7
    }

    /**
     * Find the index of the minimum element in a rotated sorted array.
     * The minimum element is the point of rotation, and it is the only element that is less than its previous element.
     * The algorithm uses binary search to efficiently find the minimum element in O(log n) time.
     *
     * @param array Array
     * @return Index of the minimum element in the rotated sorted array.
     * Time complexity: O(log n) due to binary search.
     * Space complexity: O(1) since we are using only a constant amount of extra space.
     */
    public static int findMinRotated(int[] array) {

        int left = 0;                   // Start of the array
        int right = array.length - 1;   // End of the array

        // We start with -1 in case nothing is found, though in this problem a valid answer should exist.
        int boundaryIndex = -1;                             // ----------- O(1)

        while (left <= right) {                             // ----------- O(log n)
            int mid = left + (right - left) / 2;            // ----------- O(1)
            if (array[mid] <= array[array.length - 1]) {    // ----------- O(1)
                boundaryIndex = mid;                        // ----------- O(1)
                right = mid - 1;                            // ----------- O(1)
            } else {
                left = mid + 1;                             // ----------- O(1)
            }
        }
        return boundaryIndex;                               // ----------- O(1)
    }
}
